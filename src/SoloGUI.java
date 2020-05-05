import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class SoloGUI {
    private JButton button1;
    private JButton button2;
    private JPanel Panel;
    private JTextArea textArea1;
    private JButton button3;
    Connection conn;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SoloGUI");

        frame.setContentPane(new SoloGUI().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SoloGUI() {
        try {
            conn = soloadventure.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.setText(soloadventure.getBody(conn));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
