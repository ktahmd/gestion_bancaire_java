package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
// import com.toedter.calendar.*;
import java.util.Random;

public class inscrire extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JLabel backgroundLabel;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JPasswordField pf2;
	JRadioButton r1;
	JRadioButton r2;
	JButton b1, b2;
	// Random r= new Random();
	// long randNum = r.nextLong() %9000 +1000;
	// String numbre =""+Math.abs(randNum);
	// JDateChooser dt;

    public inscrire(){
        setTitle("Cree un compte bancaire");
		//bienvenue
		setLayout(null);
		l1=new JLabel("INSCRIRE");
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
		add(tf2);
		//prenom
		l3=new JLabel("Prenom:");
		l3.setFont(new Font("Tohoma",Font.BOLD, 16));
		l3.setBounds(80,110,230,20);
		add(l3);
		tf3=new JTextField(20);
		tf3.setBounds(80,132,230,25);
		tf3.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(tf3);
        //Telephone
		l4=new JLabel("Numero Telephone:");
		l4.setFont(new Font("Tohoma",Font.BOLD, 16));
		l4.setBounds(80,160,230,20);
		add(l4);
		tf4=new JTextField(20);
		tf4.setBounds(80,184,230,25);
		tf4.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(tf4);
        //email
        l5=new JLabel("Email:");
		l5.setFont(new Font("Tohoma",Font.BOLD, 16));
		l5.setBounds(80,210,230,20);
		add(l5);
		tf5=new JTextField(20);
		tf5.setBounds(80,234,230,25);
		tf5.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(tf5);
        //adress 
        l6=new JLabel("adress:");
		l6.setFont(new Font("Tohoma",Font.BOLD, 16));
		l6.setBounds(80,260,230,20);
		add(l6);
		tf6=new JTextField(20);
		tf6.setBounds(80,284,230,25);
		tf6.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(tf6);
        //gender
        l7=new JLabel("Gender:");
		l7.setFont(new Font("Tohoma",Font.BOLD, 16));
		l7.setBounds(80,310,230,20);
        add(l7);
		r1=new JRadioButton("Femme");
		r1.setBounds(240,308,70,25);
		r1.setBackground(Color.white);
		r1.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(r1);
		r2=new JRadioButton("Homme");
		r2.setBounds(160,308,70,25);
		r2.setBackground(Color.white);
		r2.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(r2);

		ButtonGroup bgGender=new ButtonGroup();
		bgGender.add(r1);
		bgGender.add(r2); // yay make it group for avoid the multi choose

        //date naissance (jclander.jar)
        l8=new JLabel("Date naissance:");
		l8.setFont(new Font("Tohoma",Font.BOLD, 16));
		l8.setBounds(80,340,230,20);
        add(l8);
		// dt=new JDateChooser();
		// dt.setBounds(150,340,230,12);
		// add(dt);
		//it not working idk why !!!
        //password
        l9=new JLabel("Password:");
		l9.setFont(new Font("Tohoma",Font.BOLD, 16));
		l9.setBounds(80,370,230,20);
		add(l9);
		pf2=new JPasswordField(20);
		pf2.setBounds(80,394,230,25);
		pf2.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(pf2);
        
		//buttom
		b1= new JButton("inscrire");
		b1.setFont(new Font("Tohoma",Font.BOLD, 16));
		b1.setBounds(120,430,150,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		add(b1);
		b1.addActionListener(this);
		//clean
		b2= new JButton("connexion");
		b2.setFont(new Font("Tohoma",Font.BOLD, 16));
		b2.setBounds(120,470,150,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		add(b2);
		b2.addActionListener(this);
		//action des buttons
		// b1.addActionListener(this);
		// b2.addActionListener(this);
		
		//background
        ImageIcon bk = new ImageIcon(getClass().getResource("icons/backgroundlogin.jpg"));
		Image Ik=bk.getImage().getScaledInstance(800,560,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(Ik);
		JLabel iblimage=new JLabel(i3);
		iblimage.setBounds(0,0,800,560);
		add(iblimage);

		// getContentPane().setLayout(new BorderLayout());
		// getContentPane().add(new JLabel(backgroundImage), BorderLayout.CENTER);

		// getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(800,560);
		setLocation(280,200);
		
    }

    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
					// String formNum=numbre;
					String nom = tf2.getText();
					String prenom = tf3.getText();
					String tel = tf4.getText();
					String email = tf5.getText();
					String adress = tf6.getText();
					String gender="X" ;
					if(r1.isSelected()){
						gender = "F";
					}
					else if(r2.isSelected()){
						gender = "H";
					}
					String date_naissance = null;
					String pass = pf2.getText();
					Connctionfactory cf=new Connctionfactory();
					String query="select *from clients where tel='"+tel+"'";
					try (ResultSet rs = cf.smt.executeQuery(query)) {
						//insertion sur db
						try{
							if(tf2.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre nom!","Erreur",JOptionPane.ERROR_MESSAGE);
							}
							else if(tf3.getText().equals("")){
								JOptionPane.showMessageDialog(null,"Entrez votre prenom!","Erreur",JOptionPane.ERROR_MESSAGE);
							}else if(tf4.getText().equals("") || !tf4.getText().matches("\\d{8}")){
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
								//Insert data into 'clients' table
								query="insert into Clients(nom,prenom,tel,email,adress,gender,date_naissance,pass) values ('"+nom+"','"+prenom+"','"+tel+"','"+email+"','"+adress+"','"+gender+"',IFNULL('"+date_naissance+"', NULL),'"+pass+"')";
								cf.smt.executeUpdate(query);
								// select la derinieur id client 
								query = "SELECT LAST_INSERT_ID() AS last_id";
								try (ResultSet generatedKeys = cf.smt.executeQuery(query)) {
									if (generatedKeys.next()) {
										int client_id = generatedKeys.getInt("last_id");
										//random account num
										String accountNum = generateAccountNumber();
										//verification si le accountNum exist dans db ou non
										query = "SELECT COUNT(*) AS count FROM clientAcc WHERE Acc_num = '" + accountNum + "'";
										ResultSet rs2 = cf.smt.executeQuery(query);
										rs2.next();
										int count = rs2.getInt("count");
										if (count > 0) {
											accountNum = generateAccountNumber();
										}
										// Insert data into 'clientAcc' table
										query = "INSERT INTO clientAcc(Acc_num, client_id, balance) VALUES ('" + accountNum + "', " + client_id + ", 0)";
										cf.smt.executeUpdate(query);
										//afficher une msg de reussie
										JOptionPane.showMessageDialog(null, "Inscription réussie", "Succès", JOptionPane.PLAIN_MESSAGE);
									}
								}
							}
							
						}
						catch(Exception ex){
							ex.printStackTrace();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		else if(e.getSource() == b2){
	
			this.setVisible(false);
			new login();
		}
	}
	public static String generateAccountNumber() {
		Random random = new Random();
		StringBuilder accountNumber = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			accountNumber.append(random.nextInt(10));
		}
		while (accountNumber.length() < 11) {
			accountNumber.insert(0, '0');
		}
		return accountNumber.toString();
	}

}
