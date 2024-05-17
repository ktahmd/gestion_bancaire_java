package AccClient;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.Connctionfactory;

public class Clients {
    int client_id;
    String nom;
    String prenom;
    String tel;
    String email;
    String adress;
    String gender;
    String pass;
    String AccNum;
    int Balance;
    Connctionfactory cf=new Connctionfactory();
    
    public Clients(String Num) throws SQLException{
    String query="select *from clients c, clientacc a where c.id=a.client_id and c.tel='"+Num+"' or a.Acc_num='"+Num+"'";
        try (ResultSet rs = cf.smt.executeQuery(query)) {
            if (rs.next()) { 
                this.client_id = rs.getInt("client_id");
                this.nom = rs.getString("nom");
                this.prenom = rs.getString("prenom");
                this.tel = rs.getString("tel");
                this.email = rs.getString("email");
                this.adress = rs.getString("adress");
                this.gender = rs.getString("gender");
                this.pass = rs.getString("pass");
                this.AccNum= rs.getString("Acc_num");
                this.Balance= rs.getInt("balance");
                
            }
        }
    }
    public int getId() {
        return client_id;
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

    public void depose(int montant) throws SQLException{
        this.Balance += montant;
        String query = "UPDATE clientacc SET balance = '" + this.Balance + "' WHERE client_id = (SELECT id FROM clients WHERE tel = '" + tel + "')";
        cf.smt.executeUpdate(query);

    }
    public int retrait(int montant) throws SQLException {
        if(this.Balance <montant ){
            return 0;
        }else{
            this.Balance -= montant;
            String query = "UPDATE clientacc SET balance = '" + this.Balance + "' WHERE client_id = (SELECT id FROM clients WHERE tel = '" + tel + "')";
            cf.smt.executeUpdate(query);
            return 1;
        }
    }
    public void supprimerAcc(String Num) throws SQLException  {
        String queryClientAcc = "DELETE FROM ClientAcc WHERE Acc_num='" + Num + "'";
            cf.smt.executeUpdate(queryClientAcc);
    }
    public void supprimerClient(int id) throws SQLException  {
        String queryClients = "DELETE FROM Clients WHERE id='"+id+"'";
            cf.smt.executeUpdate(queryClients); 
    }

    
}