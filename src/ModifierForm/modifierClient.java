package ModifierForm;

import javax.swing.*;

import GUI_Client.Clients;
import GUI_Client.MenuClient;
import bank.Connctionfactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
// import com.toedter.calendar.*;

public class modifierClient extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JLabel backgroundLabel;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JPasswordField pf2;
	JRadioButton r1;
	JRadioButton r2;
	JButton b1;
	String Num;
	String telold;
	int id;
	String g;
	// Random r= new Random();
	// long randNum = r.nextLong() %9000 +1000;
	// String numbre =""+Math.abs(randNum);
	// JDateChooser dt;

    public modifierClient(String Num) throws SQLException{
		this.Num=Num;
		Clients C = new Clients(Num);
		this.id=C.getId();
		this.telold=C.getTel();
		this.g= C.getGender();
        setTitle("modifier un compte bancaire");
		//bienvenue
		setLayout(null);
		l1=new JLabel("Mon Info");
		l1.setFont(new Font("Arial",Font.BOLD, 35));
		l1.setBounds(105,10,230,40);
		add(l1);
		//nom
		l2=new JLabel("Nom:");
		l2.setFont(new Font("Tohoma",Font.BOLD, 16));
		l2.setBounds(80,60,230,20);
		add(l2);
		tf2=new JTextField(20);
		tf2.setBounds(80,82,230,25);
		tf2.setFont(new Font("Tohoma",Font.BOLD, 12));
		tf2.setText(C.getNom());
		add(tf2);
		//prenom
		l3=new JLabel("Prenom:");
		l3.setFont(new Font("Tohoma",Font.BOLD, 16));
		l3.setBounds(80,110,230,20);
		add(l3);
		tf3=new JTextField(20);
		tf3.setBounds(80,132,230,25);
		tf3.setFont(new Font("Tohoma",Font.BOLD, 12));
		tf3.setText(C.getPrenom());
		add(tf3);
        //Telephone
		l4=new JLabel("Numero Telephone:");
		l4.setFont(new Font("Tohoma",Font.BOLD, 16));
		l4.setBounds(80,160,230,20);
		add(l4);
		tf4=new JTextField(20);
		tf4.setBounds(80,184,230,25);
		tf4.setFont(new Font("Tohoma",Font.BOLD, 12));
		tf4.setText(C.getTel());
		add(tf4);
        //email
        l5=new JLabel("Email:");
		l5.setFont(new Font("Tohoma",Font.BOLD, 16));
		l5.setBounds(80,210,230,20);
		add(l5);
		tf5=new JTextField(20);
		tf5.setBounds(80,234,230,25);
		tf5.setFont(new Font("Tohoma",Font.BOLD, 12));
		tf5.setText(C.getEmail());
		add(tf5);
        //adress 
        l6=new JLabel("adress:");
		l6.setFont(new Font("Tohoma",Font.BOLD, 16));
		l6.setBounds(80,260,230,20);
		add(l6);
		tf6=new JTextField(20);
		tf6.setBounds(80,284,230,25);
		tf6.setFont(new Font("Tohoma",Font.BOLD, 12));
		tf6.setText(C.getAdress());
		add(tf6);
        //gender
        // l7=new JLabel("Gender:");
		// l7.setFont(new Font("Tohoma",Font.BOLD, 16));
		// l7.setBounds(80,310,230,20);
        // add(l7);
		// r1=new JRadioButton("Femme");
		// r1.setBounds(240,308,70,25);
		// r1.setBackground(Color.white);
		// r1.setFont(new Font("Tohoma",Font.BOLD, 12));
		// add(r1);
		// r2=new JRadioButton("Homme");
		// r2.setBounds(160,308,70,25);
		// r2.setBackground(Color.white);
		// r2.setFont(new Font("Tohoma",Font.BOLD, 12));
		// add(r2);

		ButtonGroup bgGender=new ButtonGroup();
		bgGender.add(r1);
		bgGender.add(r2); // yay make it group for avoid the multi choose that so cool hhhhhhh

        //date naissance (jclander.jar)
        // l8=new JLabel("Date naissance:");
		// l8.setFont(new Font("Tohoma",Font.BOLD, 16));
		// l8.setBounds(80,340,230,20);
        // add(l8);
		// dt=new JDateChooser();
		// dt.setBounds(150,340,230,12);
		// add(dt);
		//it not working idk why !!!

        //password
        l9=new JLabel("Password:");
		l9.setFont(new Font("Tohoma",Font.BOLD, 16));
		l9.setBounds(80,320,230,20);
		add(l9);
		pf2=new JPasswordField(20);
		pf2.setBounds(80,340,230,25);
		pf2.setFont(new Font("Tohoma",Font.BOLD, 12));
		pf2.setText(C.getPass());
		add(pf2);
        
		//buttom
		b1= new JButton("save");
		b1.setFont(new Font("Tohoma",Font.BOLD, 16));
		b1.setBounds(120,380,150,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		add(b1);
		b1.addActionListener(this);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(400,500);
		setLocationRelativeTo(null); 
		
    }



    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
					// String formNum=numbre; 
					String nom = tf2.getText();
					String prenom = tf3.getText();
					String telnew = tf4.getText();
					String email = tf5.getText();
					String adress = tf6.getText();
					String pass = pf2.getText();
					Connctionfactory cf=new Connctionfactory();
					String query="select *from clients where tel='"+telnew+"' and id !='"+id+"'";
					try (ResultSet rs = cf.smt.executeQuery(query)) {
						//insertion sur db
						try{
							if(tf2.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre nom!","Erreur",JOptionPane.ERROR_MESSAGE);
							}
							else if(tf3.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre prenom!","Erreur",JOptionPane.ERROR_MESSAGE);
							}else if(tf4.getText().equals("") || !tf4.getText().matches("[2-4]\\d{7}")){
								JOptionPane.showMessageDialog(null,"Entrez un numéro de téléphone valide!","Erreur",JOptionPane.ERROR_MESSAGE);
							}else if(tf5.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre email!","Erreur",JOptionPane.ERROR_MESSAGE);
							}
							else if(tf6.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre adress!","Erreur",JOptionPane.ERROR_MESSAGE);
							}
							else if(pf2.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre password!","Erreur",JOptionPane.ERROR_MESSAGE);
							}else if(rs.next()){
								JOptionPane.showMessageDialog(null,"Le numero téléphone est deja inscrit!","Erreur",JOptionPane.ERROR_MESSAGE);
							}
							else{
								
								// Update data into 'clients' table
								query = "UPDATE clients SET " +
								"nom = '" + nom + "', " +
								"prenom = '" + prenom + "', " +
								"tel = '" + telnew + "', " +
								"email = '" + email + "', " +
								"adress = '" + adress + "', " +
								"pass = '" + pass + "' " +
								"WHERE id = " + id; 
								cf.smt.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Compte modifie avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
								this.setVisible(false);
								
								
								
							}
							
						}
						catch(Exception ex){
							ex.printStackTrace();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (!telold.equals(telnew)) {
						try {
							new MenuClient(telnew);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
			}
			
	}


}

