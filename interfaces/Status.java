package interfaces;

import sql.SQL_API;

import java.sql.*;

public class Status
{
    // -------------------<LOGIN CREDENTIALS>-----------------------
    public static String url = "jdbc:mysql://34.66.94.176:3306/chocan";
    public static String user = "timothy";
    public static String pass = "timothy1";


    private String name;
    private String membership_status;

    public Status() {
        this.name = new String();
        this.membership_status = new String();
    }

    public Status(String name, String value) {
        this.name = name;
        this.membership_status = value;
    }

    public void initStatus(String name, String membership_status) {
        this.name = name;
        this.membership_status = membership_status;
    }

    public String getName()
    {
        return this.name;
    }

    public String getMembership_status()
    {
        return this.membership_status;
    }
    //updating the status using the associated member ID
    public String setStatus(String memberID, String status){
        try
        {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE members set membership_state = ? where member_id = ?";
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setString(1, status);
            preparedStmt.setString(2, memberID);
            preparedStmt.executeUpdate();
            this.membership_status = status;
            return "Status is successfully updated.";
        }
        catch (Exception var5)
        {
            var5.printStackTrace();
            return"System Error";
        }
    }
}
