package org.example;
import java.sql.*;

public class Login {
    String username;
    String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean testLogin(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            if (conn != null) {
                String get_admin_query = "SELECT * FROM administateur WHERE login=?";
                PreparedStatement preparedStatement = conn.prepareStatement(get_admin_query);
                preparedStatement.setString(1,this.username);
                ResultSet res = preparedStatement.executeQuery();
                if(res.next()==true){
                    if (this.password.equals(res.getString("password"))) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

