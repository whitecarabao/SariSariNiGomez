import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ItemListPage extends JFrame {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JButton addCarneNorteButton;
    private JButton addButton1;
    private JButton addButton2;
    private JButton addButton3;
    private JButton addButton4;
    private JButton addButton5;
    private JButton addButton6;
    private JButton addButton7;
    private JTextArea textArea1;
    private JButton checkoutButton;
    private JPanel itemList;
    private JFormattedTextField formattedTextField1;
    private JButton retrieveDetailsButton;
    private JButton clearCartButton;
    private JButton accountPanelButton;
    private JButton giftCardCouponButton;
    private JButton calculateTotalButton;
    private JButton carneNorteReduce;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton removeReduceButton;
    private JButton removeReduceButton1;
    public JTextField textField1;
    public String userName;

    public ItemListPage(String userName) throws Exception {

        this.userName = userName;
//        welcomeSetter(this.userName);
        dispItemListPage();



    }

    public ItemListPage(int lol) throws Exception {

        DatabaseClass cartObj = new DatabaseClass();
        welcomeSetter(cartObj.getLoggedInUser());
        addCarneNorteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int c1 = comboBox1.getSelectedIndex();
                try {
                    addCartProcedure("CARNENORTE", c1);
                } catch (Exception exception) {

                }

            }
        });


        removeReduceButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("BIODERMP", comboBox8.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        removeReduceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("RAMPCAKEMX", comboBox7.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        addButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addCartProcedure("BIODERMP", comboBox8.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        addButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addCartProcedure("RAMPCAKEMX", comboBox7.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("CERELAC2PK", comboBox4.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("GCROSSALC", comboBox6.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        addButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addCartProcedure("GCROSSALC", comboBox6.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("MAGICFLK10", comboBox2.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("KOJIESAN3", comboBox3.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("TALC", comboBox5.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int c1 = comboBox2.getSelectedIndex();
                    addCartProcedure("MAGICFLK10", c1);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });

        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int c1 = comboBox3.getSelectedIndex();
                    addCartProcedure("KOJIESAN3", c1);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        carneNorteReduce.addActionListener(new ActionListener() { //remover button for Carne Norte
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCartProcedure("CARNENORTE", comboBox1.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        addButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addCartProcedure("CERELAC2PK", comboBox4.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        addButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addCartProcedure("TALC", comboBox5.getSelectedIndex());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.setText(cartObj.cartPusher() + "    x" + cartObj.getItemTotal("CARNENORTE"));
                    //textArea1.append(cartObj.cartPusher() + "    x" + cartObj.getItemTotal(("MAGICFLAKES")));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }


    public void dispItemListPage() throws Exception {
        JFrame frame = new JFrame("ItemListPage");
        frame.setContentPane(new ItemListPage(1).itemList);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public void removeCartProcedure(String itemName, int itemCount) throws Exception {
        try {
            DatabaseClass cartRemover = new DatabaseClass();
            JOptionPane.showMessageDialog(null, itemCount + " units of " + itemName + " has been removed from your cart :)");
            cartRemover.cartRemover(itemName, itemCount);
            System.out.println("DEBUG - " + itemName + "reduced/removed. Count: " + itemCount);
            //ResultSet currCartContents = cartObj.cartContents();

            textArea1.setText("");
            textArea1.setText("Your Shopping Cart\nItem List is as follows: " + "\nItem Name - Item Code  -  Item Count" + "\n");
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;

            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT ITEMNAME, ITEMCODE, ITEMCOUNT FROM ESARIDATABASE.SHOPPINGCART WHERE ITEMCOUNT > 0");

            ResultSet resultAuth = statementPrep.executeQuery();
            //resultAuth.next();
            while (resultAuth.next()) {
                textArea1.append(resultAuth.getString("ITEMNAME") + " - " + resultAuth.getString("ITEMCODE") + "  " + resultAuth.getInt("ITEMCOUNT") + "\n");
            }

        } catch(Exception e)

            {
                throw e;
            } finally
            {
                sqlClose();
            }
        }










    public void addCartProcedure(String pancake, int itemcount) throws Exception {
        try {
            DatabaseClass cartObj = new DatabaseClass();
            JOptionPane.showMessageDialog(null, pancake + " has been added to your cart :)");
            cartObj.addItems(pancake, itemcount);
            System.out.println("DEBUG - " + pancake + "added. Count: " + itemcount);
            //ResultSet currCartContents = cartObj.cartContents();

            textArea1.setText("");
            textArea1.setText("Your Shopping Cart\nItem List is as follows: " + "\nItem Name - Item Code  -  Item Count" + "\n");
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;

            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT ITEMNAME, ITEMCODE, ITEMCOUNT FROM ESARIDATABASE.SHOPPINGCART WHERE ITEMCOUNT > 0");

            ResultSet resultAuth = statementPrep.executeQuery();
            //resultAuth.next();
            while (resultAuth.next()) {
                textArea1.append(resultAuth.getString("ITEMNAME") + " - " + resultAuth.getString("ITEMCODE") + "  " + resultAuth.getInt("ITEMCOUNT") + "\n");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            sqlClose();
        }
    }

        public void welcomeSetter (String userName) throws Exception {
            DatabaseClass chkName = new DatabaseClass();
            chkName.getName(userName);
            System.out.println(chkName.getName(userName));
            formattedTextField1.setText("Welcome, " + chkName.getName(userName) + ". We hope you enjoy your shopping experience!");
            // super.update(this.getGraphics());
        }

        public static void main (String[]args){

        }

        public void sqlClose () {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
        }
    }

