package Detail;

import javax.swing.*;

public class StudentInfo {

    public static void updateInfo(
            JLabel id, JLabel name, JLabel gender, JLabel status,
            JLabel pt, JLabel ass, JLabel ws, JLabel pe, JLabel fe, JLabel tg,
            String getStudentID, String getName, String getGender, String getStatus,
            double getPt, double getAss, double getWs, double getPe, double getFe, double getTg) {

        id.setText(getStudentID);
        name.setText(getName);
        gender.setText(getGender);
        status.setText(getStatus);

        pt.setText(String.valueOf(getPt));
        ass.setText(String.valueOf(getAss));
        ws.setText(String.valueOf(getWs));
        pe.setText(String.valueOf(getPe));
        fe.setText(String.valueOf(getFe));
        tg.setText(String.valueOf(getTg));
    }
}
