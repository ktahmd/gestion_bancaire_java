package AccClient;
import java.sql.ResultSet;
import java.sql.SQLException;
import bank.Connctionfactory;

public class Clients {
    String client_id;
    String nom;
    String prenom;
    String tel;
    String email;
    String adress;
    String gender;
    String pass;
    String AccNum;
    int Balance;

    public Clients(String tel) throws SQLException{
        Connctionfactory cf=new Connctionfactory();
		String query="select *from clients c, clientacc a where c.id=a.client_id and tel='"+tel+"'";
        try (ResultSet rs = cf.smt.executeQuery(query)) {
            if (rs.next()) { 
                this.client_id = rs.getString("id");
                this.nom = rs.getString("nom");
                this.prenom = rs.getString("prenom");
                this.tel = rs.getString("tel");
                this.email = rs.getString("email");
                this.adress = rs.getString("adress");
                this.gender = rs.getString("gender");
                this.pass = rs.getString("pass");
                this.AccNum= rs.getString("Acc_num");
                this.Balance= rs.getInt("balance");
                
            } else {
                throw new SQLException("Client n'exist pas");
            }
        }
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getTel() {
        return tel;
    }
    public String getEmail() {
        return email;
    }
    public String getAdress() {
        return adress;
    }
    public String getPass() {
        return pass;
    }
    public String getGender() {
        return gender;
    }
    public String getAccNum() {
        return AccNum;
    }
    public int getBalance() {
        return Balance;
    }
}
