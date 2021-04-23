import javax.swing.*;
import java.sql.*;



public class DatabaseClass {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DatabaseClass() throws Exception {


    }

    public static void main(String[] args) throws Exception {
        //DatabaseClass dao = new DatabaseClass();
        DatabaseClass authCheck = new DatabaseClass();
        authCheck.authenticateUser("daryll.gomez", "testpassword");
    }

    public void resetCart() throws Exception {
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("UPDATE ESARIDATABASE.SHOPPINGCART SET ITEMCOUNT = 0 WHERE ITEMCOUNT != 0");

            statementPrep.executeUpdate();
            PreparedStatement logOutAllLoggedInUsers = connect
                    .prepareStatement("UPDATE ESARIDATABASE.ESARIACCOUNTS SET SESSIONMODE = 'LOGGED OUT' WHERE SESSIONMODE = 'ACTIVE'");

            PreparedStatement logOutStatement = connect.prepareStatement("UPDATE ESARIDATABASE.ESARIACCOUNTS SET SESSIONMODE = 'LOGGED OUT' WHERE SESSIONMODE IS NULL");
            logOutStatement.executeUpdate();
            logOutAllLoggedInUsers.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void addUser(String username, String firstName, String lastName, String password) throws Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("INSERT INTO ESARIDATABASE.ESARIACCOUNTS(USERNAME, FIRSTNAME, LASTNAME, PASSWORD)");
            statementPrep.setString(1, username);
            statementPrep.setString(2, firstName);
            statementPrep.setString(3, lastName);
            statementPrep.setString(4, password);
            statementPrep.executeUpdate();
            JOptionPane.showMessageDialog(null, "New User Added!\nName: "+firstName + " " + lastName+"\nUsername: "
        + username);



        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void addItems(String itemCode, int itemCount) throws Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("UPDATE ESARIDATABASE.SHOPPINGCART SET itemCount = itemCount + ? WHERE itemCode = ?");
            statementPrep.setString(1, String.valueOf(itemCount));
            statementPrep.setString(2, itemCode);
            statementPrep.executeUpdate();
            System.out.println(itemCode + "+ " + itemCount);



        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public String cartPusher() throws Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT ITEMCODE, ITEMCOUNT FROM ESARIDATABASE.SHOPPINGCART WHERE ITEMCOUNT > 0");

            ResultSet resultAuth = statementPrep.executeQuery();
            resultAuth.next();
              //  getItemTotal(resultAuth.getString("ITEMCODE"));
            return resultAuth.getString("ITEMCODE");

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }


    }

    public int getCartContentItemCount(int itemCount){

        return itemCount;
    }

    public void changePassword(String username, String newPass, String fName)throws Exception {
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("UPDATE ESARIDATABASE.ESARIACCOUNTS SET PASSWORD = ? WHERE USERNAME = ? AND FIRSTNAME = ?");

            statementPrep.setString(1, newPass);
            statementPrep.setString(2, username);
            statementPrep.setString(3, fName);


            statementPrep.executeUpdate();
            System.out.println("DEBUG - User: " + username + "\nPassword: " + newPass + "\nPassword changed successfully.");


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void cartRemover(String itemToRemove, int itemCount)throws Exception{ //removes or reduce items in db
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("UPDATE ESARIDATABASE.SHOPPINGCART SET itemCount = itemCount - ? WHERE itemCode = ?");
            statementPrep.setString(1, String.valueOf(itemCount));
            statementPrep.setString(2, itemToRemove);
            statementPrep.executeUpdate();
            System.out.println(itemToRemove + "- " + itemCount);



        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public String getLoggedInUser()throws  Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT USERNAME FROM ESARIDATABASE.ESARIACCOUNTS WHERE SESSIONMODE = 'ACTIVE'");

            ResultSet resultAuth = statementPrep.executeQuery();
            resultAuth.next();
            return resultAuth.getString(1);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    public int getItemTotal(String itemCode) throws Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT ITEMCOUNT FROM ESARIDATABASE.SHOPPINGCART WHERE ITEMCODE = ?");
            statementPrep.setString(1, itemCode);
            ResultSet resultAuth = statementPrep.executeQuery();
            resultAuth.next();
                return resultAuth.getInt("ITEMCOUNT");

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
public ResultSet cartContents() throws SQLException {
    try {

        // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        connect = DriverManager
                .getConnection("jdbc:derby:eSariDatabaseSystem");

        PreparedStatement auth;
        PreparedStatement statementPrep = connect
                .prepareStatement("SELECT ITEMCODE, ITEMCOUNT FROM ESARIDATABASE.SHOPPINGCART WHERE ITEMCOUNT > 0");

        ResultSet resultAuth = statementPrep.executeQuery();
        //resultAuth.next();
        return resultAuth;

    } catch (Exception e) {
        throw e;
    } finally {
        close();
    }
}
    public String authenticateUser(String username, String password) throws Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT 'USERNAME', 'PASSWORD' from ESARIDATABASE.ESARIACCOUNTS WHERE USERNAME = ? AND PASSWORD = ?");
            statementPrep.setString(1, username);
            statementPrep.setString(2, password);
            ResultSet resultAuth = statementPrep.executeQuery();

            if(resultAuth.next()){
                JOptionPane.showMessageDialog(null, "Login Success.");
                PreparedStatement logInStatement = connect.prepareStatement("UPDATE ESARIDATABASE.ESARIACCOUNTS SET SESSIONMODE = 'ACTIVE' WHERE USERNAME = ?");
                logInStatement.setString(1, username);
                System.out.println(username + " has now been set to logged in :)");
                logInStatement.executeUpdate();
                return "SUCCESS";
            }

            else{
                JOptionPane.showMessageDialog(null, "Login Failed.");
                return "FAILURE";
            }


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public String getName(String username) throws Exception{
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT FIRSTNAME || ' '|| LASTNAME AS FULL_NAME FROM ESARIDATABASE.ESARIACCOUNTS WHERE USERNAME = ?");
            statementPrep.setString(1, username);

            ResultSet resultAuth = statementPrep.executeQuery();
            resultAuth.next();
            System.out.println("User's name: " + resultAuth.getString("FULL_NAME"));
            return resultAuth.getString("FULL_NAME");


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public String chkInteg() throws Exception {
        try {

            // Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:derby:eSariDatabaseSystem");

            PreparedStatement auth;
            PreparedStatement statementPrep = connect
                    .prepareStatement("SELECT COUNT(*) AS ROW_COUNT FROM ESARIDATABASE.ESARIACCOUNTS");

            ResultSet resultAuth = statementPrep.executeQuery();
            resultAuth.next();
            int count = resultAuth.getInt("ROW_COUNT");
            if(count > 0){
                return count + " records found!";
            }

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
return "No Database Records found!";
    }

    private void close() {
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