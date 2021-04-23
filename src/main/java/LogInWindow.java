import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.gc;

public class LogInWindow {
    private JTextField textField1;
    private JTextField textField2;
    private JButton logInButton;
    private JButton signUpButton;
    private JButton forgotPasswordButton;
    private JTextArea textArea1;
    private JPanel LogInWindow;

    //LogInWindow.setVisible(true);


    public void startRoutine() throws Exception{

    makeThingGoBeep();



    }



    public LogInWindow() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textField1.setEditable(false);
                    textField2.setEditable(false);
                    DatabaseClass authSession = new DatabaseClass();
                    //authSession.authenticateUser(textField1.getText(), textField2.getText());
                    if(authSession.authenticateUser(textField1.getText(), textField2.getText()).equals(
                    "SUCCESS")){

                        ItemListPage buySess = new ItemListPage(textField1.getText());
                    }


                } catch (Exception exception) {
                    exception.printStackTrace();
                }



                System.out.println("Button was pressed!");
                textArea1.setText("Username: " + textField1.getText());
                textArea1.append("\nPassword: "+ textField2.getText());

            }
        });
    }

    public void makeThingGoBeep() throws Exception {
        JFrame frame = new JFrame("LogInWindow");
        frame.setContentPane(new LogInWindow().LogInWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        PreStartCheck pStart = new PreStartCheck();
        Thread.sleep(500);
        frame.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);

        Thread.sleep(60000);

        frame.setVisible(false);
        pStart = null;
        //pStart.setVisible(true);


    }


}
