package Student;

import javax.swing.*;

public class Notification {

    public static void showErrorMessage(JDialog parentDialog, String message) {
        JOptionPane.showMessageDialog(parentDialog, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInformationMessage(JDialog parentDialog, String message) {
        JOptionPane.showMessageDialog(parentDialog, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

}
