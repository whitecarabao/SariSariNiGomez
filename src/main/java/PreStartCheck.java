import javax.swing.*;
import java.awt.*;


public class PreStartCheck extends JFrame{
    private JProgressBar progressBar1;
    private JPanel eSARI;
    private JLabel pleaseWaitLabel;

    public PreStartCheck(int num) throws Exception {
        progressBar1.setMinimum(0);
        progressBar1.setValue(0);
        progressBar1.setStringPainted(true);
        progressBar1.setString("Loading Apache Derby in Embedded Mode...");
        progressBar1.setMaximum(100);

        progressBar1.setValue(85);
        DatabaseClass authSesh = new DatabaseClass();
        progressBar1.setValue(15);
        authSesh.resetCart(); //resets itemcount to 0!
        progressBar1.setValue(45);

        pleaseWaitLabel.setText(authSesh.chkInteg());
        progressBar1.setString("Database Integrity Check in progress...");
        progressBar1.setValue(85);
        Thread.sleep(3000);
        progressBar1.setString("Loading Apache Derby in Embedded Mode...");


    }
    public PreStartCheck() throws Exception {
    dispPreStartCheck();
    }

    public void dispPreStartCheck() throws Exception {
        JFrame frame = new JFrame("PreStartCheck");
        frame.setContentPane(new PreStartCheck(1).eSARI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);

        Thread.sleep(500);
        progressBar1.setValue(100);
        Thread.sleep(10500);

        frame.setVisible(false);

    }



}

