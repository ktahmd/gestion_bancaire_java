package GUI_Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import bank.Connctionfactory;

public class admin extends Connctionfactory {
    /**
	 * 
	 */
    String agent_id;
    String username;
    String pass;
    String tel;
    public admin(String user) throws SQLException{
        Connctionfactory cf=new Connctionfactory();
		String query="select *from admin where user_name='"+user+"'";
        try (ResultSet rs = cf.smt.executeQuery(query)) {
            if (rs.next()) { // Check if ResultSet has any data
                this.agent_id = rs.getString("id");
                this.username = rs.getString("user_name");
                this.pass = rs.getString("pass");
                this.tel = rs.getString("tel");
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
    public String getAgent_id() {
        return agent_id;
    }

}
