package GUI_Admin;
import java.awt.*;
import java.awt.event.*;
// import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import bank.login;


public class MenuAgent extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,tl,nom;
    JButton b0,b1,b2,b3,b4;
    String username;
    
    public MenuAgent(String username) throws SQLException{
        setTitle("Transation page");
        setLayout(null);
        this.username=username;
        l1=new JLabel("Systeme Bancaire");
		l1.setFont(new Font("Arial",Font.BOLD, 35));
		l1.setBounds(80,40,600,40);
		add(l1);
        //logout
		b0= new JButton("deconnexion");
		b0.setFont(new Font("Tohoma",Font.BOLD, 16));
		b0.setBounds(1080,50,150,30);
		b0.setBackground(Color.black);
		b0.setForeground(Color.WHITE);
		add(b0);
		
		//Num
		l2=new JLabel("type du compte : Agence");
		l2.setFont(new Font("Tohoma",Font.BOLD, 16));
		l2.setBounds(80,100,230,20);
		add(l2);
        //Nom
		l3=new JLabel("Nom:");
		l3.setFont(new Font("Tohoma",Font.BOLD, 16));
		l3.setBounds(80,130,230,20);
		add(l3);
		nom=new JLabel("");
		nom.setFont(new Font("Tohoma",Font.BOLD, 16));
		nom.setBounds(210,130,230,20);
		add(nom);
		
		
        //Telephone
		l4=new JLabel("Tel: ");
		l4.setFont(new Font("Tohoma",Font.BOLD, 16));
		l4.setBounds(80,160,230,20);
		add(l4);
		tl=new JLabel("");
		tl.setFont(new Font("Tohoma",Font.BOLD, 16));
		tl.setBounds(210,160,230,20);
		add(tl);

		
		admin A;
        try {
            A = new admin(username);
            nom.setText(A.getUsername());
            tl.setText(A.getTel());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //box
        l5 = new JLabel("");
        l5.setBounds(50, 200, 1180, 600);
        l5.setBorder(BorderFactory.createLineBorder(Color.black)); 
        add(l5);
        //balance
        

        //deposer
		b1= new JButton("Depot sur un compte");
		b1.setFont(new Font("Tohoma",Font.BOLD, 16));
		b1.setBounds(80,340,1100,50);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		add(b1);

        //retrait
		b2= new JButton("Retrait du compte");
		b2.setFont(new Font("Tohoma",Font.BOLD, 16));
		b2.setBounds(80,420,1100,50);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		add(b2);

        //transfert
		b3= new JButton("Supprimer un compte");
		b3.setFont(new Font("Tohoma",Font.BOLD, 16));
		b3.setBounds(80,500,1100,50);
		b3.setBackground(Color.black);
		b3.setForeground(Color.WHITE);
		add(b3);
        
        //modifier
		b4= new JButton("modifier un compte");
		b4.setFont(new Font("Tohoma",Font.BOLD, 16));
		b4.setBounds(80,580,1100,50);
		b4.setBackground(Color.black);
		b4.setForeground(Color.WHITE);
		add(b4);

        //image background
        
        // ImageIcon bk = new ImageIcon(getClass().getResource("icons/backgroundlogin.jpg"));
		// Image Ik=bk.getImage().getScaledInstance(800,560,Image.SCALE_DEFAULT);
		// ImageIcon i3=new ImageIcon(Ik);
		// JLabel iblimage=new JLabel(i3);
		// iblimage.setBounds(0,0,800,560);
		// add(iblimage);
        

        //button action
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);


		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1500,1000);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
			if(ae.getSource() == b0){
                this.setVisible(false);
				new login();
			}else if(ae.getSource() == b1){
				new deposeA(username);
			}else if(ae.getSource() == b2){
				new retraitA(username);
			}else if(ae.getSource() == b3){
				new supprimerClient(username);
			}else if(ae.getSource() == b4){
				new modifierC(username);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
    }

}
