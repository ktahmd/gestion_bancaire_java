package AccAdmin;

import java.sql.ResultSet;
import java.sql.SQLException;
import bank.Connctionfactory;

public class admin extends Connctionfactory {
    String username;
    String pass;
    String tel;
    public admin(String user) throws SQLException{
        Connctionfactory cf=new Connctionfactory();
		String query="select *from admin where user_name='"+user+"'";
        try (ResultSet rs = cf.smt.executeQuery(query)) {
            if (rs.next()) { // Check if ResultSet has any data
                this.username = rs.getString("user_name");
                this.pass = rs.getString("pass");
                this.tel = rs.getString("tel");
            } else {
                // Handle case where no data is found for the given user
                throw new SQLException("User not found");
            }
        }
    }
    public String getUsername() {
        return username;
    }
    public String getPass() {
        return pass;
    }
    public String getTel() {
        return tel;
    }

}
