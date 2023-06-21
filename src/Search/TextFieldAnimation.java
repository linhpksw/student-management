/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

/**
 *
 * @author Win
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class TextFieldAnimation extends JTextField {

    private Color backgroundColor = Color.WHITE;
    private final Icon iconSearch;
    private Color animationColor = new Color(235, 113, 83);
    private String hintText = "Search ...";
    public boolean show;
    private final Icon iconClose;
    private Image image;

    public TextFieldAnimation() {
        setBackground(new Color(255, 255, 255, 0));
        setOpaque(false);
        setBorder(new EmptyBorder(10, 10, 10, 50));
        setText("");

        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setSelectionColor(new Color(80, 199, 255));
        iconSearch = new ImageIcon(getClass().getResource("/Search/search.png"));
        iconClose = new ImageIcon(getClass().getResource("/Search/close.png"));
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                if (checkMouseOver(me.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            }
        });

    }

    public void initEvent(SearchAction s) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (checkMouseOver(me.getPoint())) {
                        if (!show) {
                            s.onSearch();
                        }
                    }
                }
            }
        });
    }

    protected void paintComponent(Graphics grphcs) {

        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);    //  For smooth line
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); //  For smooth image
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, width, height, height, height);
        super.paintComponent(grphcs);
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        GradientPaint gra = new GradientPaint(0, 0, new Color(255, 255, 255), width, 0, animationColor);
        g2.setPaint(gra);
        g2.fillOval(width - height + 3, marginButton, buttonSize, buttonSize);

        int marginImage = 5;
        int imageSize = buttonSize - marginImage * 2;
        Image image = ((ImageIcon) iconSearch).getImage();

        g2.drawImage(image, width - height + marginImage + 3, marginButton + marginImage, imageSize, imageSize, null);
        g2.dispose();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(hintText, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

    private boolean checkMouseOver(Point mouse) {
        int width = getWidth();
        int height = getHeight();
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 3, marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }
}
