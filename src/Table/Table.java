package Table;

import java.awt.Color;
import java.awt.Component;
import Scroll.ScrollBar;
import System.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    private static final ImageIcon EMPTY_IMAGE = new ImageIcon("img1.png");

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {

                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                com.setBackground(new Color(246, 189, 176));
                setBorder(noFocusBorder);
                if (selected) {
                    com.setForeground(Color.BLACK);
                    com.setBackground(new Color(235, 113, 83));
                } else {
                    com.setForeground(Color.BLACK);
                }
                return com;
            }
        });
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(new Color(246, 189, 176));
        scroll.getViewport().setBackground(new Color(246, 189, 176));
        JPanel p = new JPanel();
        p.setBackground(new Color(246, 189, 176));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

}
