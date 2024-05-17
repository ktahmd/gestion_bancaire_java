package GUI_Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bank.Connctionfactory;



public class transfertClient extends JFrame implements ActionListener {
    JTextField tf1, tf2;
    JButton b1;
    String tel;
    public transfertClient(String tel) {
        this.tel = tel;
        setTitle("Transfert argent");
        setLayout(null); 

        JLabel l1 = new JLabel("Transfert argent");
        l1.setFont(new Font("Arial", Font.BOLD, 35));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(130, 10, 300, 40); 
        add(l1);

        JLabel lblName = new JLabel("Numéro de téléphone:");
        lblName.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        lblName.setBounds(180, 120, 230, 20); 
        add(lblName);

        tf1 = new JTextField();
        tf1.setColumns(10);
        tf1.setBounds(180, 140, 230, 25); 
        add(tf1);

        JLabel lblMontant = new JLabel("Montant:");
        lblMontant.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        lblMontant.setHorizontalAlignment(SwingConstants.LEFT);
        lblMontant.setBounds(180, 180, 230, 20);
        add(lblMontant);

        tf2 = new JTextField();
        tf2.setColumns(10);
        tf2.setBounds(180, 200, 230, 25); 
        add(tf2);

        b1 = new JButton("Transférer");
        b1.setBounds(180, 250, 100, 30); 
        b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
        

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400); 
        setLocationRelativeTo(null); 
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new transfertClient("32323200");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                String tel1 = tel;
                String tel2 = tf1.getText();
                if(tf2.getText().matches("\\d+")){
                    int montant =Integer.valueOf(tf2.getText());
                    Clients C1 = new Clients(tel1);
                    Clients C2 = new Clients(tel2);
                    Connctionfactory cf=new Connctionfactory();
                    if (tel1.equals(tel2)) {
                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas transférer de l'argent à vous-même.");
                    } else if (C2.getNom() != null) {
                        int k = C1.retrait(montant);
                        if(k==1){
                            C2.depose(montant);
                            String trans_num =generateTransferNumber();
                            String query = "SELECT COUNT(*) AS count FROM transfert WHERE trans_id = '" + trans_num + "'";
                                ResultSet rs2 = cf.smt.executeQuery(query);
                                rs2.next();
                                int count = rs2.getInt("count");
                                if (count > 0) {
                                    trans_num =generateTransferNumber();
                                }
                            query="insert into transfert(trans_id,fromWho,toWho,montant) values ('"+trans_num+"','"+tel1+"','"+tel2+"','"+montant+"')";
                            cf.smt.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Transfert réussi! \nNuméro de transfert : " + trans_num, "Succès", JOptionPane.PLAIN_MESSAGE);
                            }
                        else{
                            JOptionPane.showMessageDialog(null, "Votre solde est insuffisant pour effectuer cette transaction","Erreur",JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Le destinataire n'a pas de compte bancaire complet.","Erreur",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Le montant doit être un nombre entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String generateTransferNumber() {
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
        return "C00" + String.valueOf(randomNumber);
    }

}
