package bank;
import java.sql.*;
public class Connctionfactory{
    Connection cnx;
    public Statement smt;

    public Connctionfactory(){
    /**
	 * 
	 */
        //connection MYSQL
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            smt=cnx.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
