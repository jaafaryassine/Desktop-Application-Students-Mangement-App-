package org.example;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                    String passwordHashed = encryptPassword(this.password);
                    if (passwordHashed.equals(res.getString("password"))) {
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
    public String encryptPassword(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

