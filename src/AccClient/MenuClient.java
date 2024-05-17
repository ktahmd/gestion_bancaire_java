package AccClient;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import bank.login;
import java.sql.*;


public class MenuClient extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JLabel lNum,lPrn, lNom, lTel,bl;
    JButton b0,b1,b2,b3,b4,mc;
    String tel;
    
    public MenuClient(String tel) throws SQLException{
		this.tel=tel;
        setTitle("Transation page");
        setLayout(null);
        l1=new JLabel("Bienvenue en Systeme Bancaire");
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
		mc= new JButton("mon compte");
		mc.setFont(new Font("Tohoma",Font.BOLD, 16));
		mc.setBounds(1080,90,150,30);
		mc.setBackground(Color.black);
		mc.setForeground(Color.WHITE);
		add(mc);
		//Num
		l2=new JLabel("Numero:");
		l2.setFont(new Font("Tohoma",Font.BOLD, 16));
		l2.setBounds(80,100,230,20);
		add(l2);
        lNum = new JLabel("");
        lNum.setFont(new Font("Tohoma", Font.BOLD, 16));
        lNum.setBounds(180, 100, 230, 20);
        add(lNum);
        //Nom
		l3=new JLabel("Nom:");
		l3.setFont(new Font("Tohoma",Font.BOLD, 16));
		l3.setBounds(80,130,230,20);
		add(l3);
        lNom = new JLabel("");
        lNom.setFont(new Font("Tohoma", Font.BOLD, 16));
        lNom.setBounds(180, 130, 230, 20);
        add(lNom);
		// lPrn = new JLabel("");
        // lPrn.setFont(new Font("Tohoma", Font.BOLD, 16));
        // lPrn.setBounds(260, 130, 230, 20);
        // add(lPrn);
        //Telephone
		l4=new JLabel("Tel:");
		l4.setFont(new Font("Tohoma",Font.BOLD, 16));
		l4.setBounds(80,160,230,20);
		add(l4);
        lTel = new JLabel("");
        lTel.setFont(new Font("Tohoma", Font.BOLD, 16));
        lTel.setBounds(180, 160, 230, 20);
        add(lTel);

        //box
        l5 = new JLabel("");
        l5.setBounds(50, 200, 1180, 600);
        l5.setBorder(BorderFactory.createLineBorder(Color.black)); 
        add(l5);
        //balance
        l6=new JLabel("Balance :");
		l6.setFont(new Font("Arial",Font.BOLD, 35));
		l6.setBounds(80,230,600,40);
        add(l6);
        //MRU
		bl=new JLabel("");
		bl.setFont(new Font("Arial",Font.BOLD, 35));
		bl.setBounds(760,230,300,40);
		bl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(bl);
        l7=new JLabel("MRU");
		l7.setFont(new Font("Arial",Font.BOLD, 35));
		l7.setBounds(1080,230,150,40);
        add(l7);

		//les info de client sur db
		Clients C;
        try {
            C = new Clients(tel);
			lNum.setText(C.getAccNum());
            lNom.setText(C.getNom()+" "+C.getPrenom());
			// lPrn.setText(C.getPrenom());
            lTel.setText(C.getTel());
			bl.setText(String.valueOf(C.getBalance()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //deposer
		b1= new JButton("deposer argent");
		b1.setFont(new Font("Tohoma",Font.BOLD, 16));
		b1.setBounds(80,340,1100,50);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		add(b1);

        //retrait
		b2= new JButton("retrait argent");
		b2.setFont(new Font("Tohoma",Font.BOLD, 16));
		b2.setBounds(80,420,1100,50);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		add(b2);

        //transfert
		b3= new JButton("transfert argent");
		b3.setFont(new Font("Tohoma",Font.BOLD, 16));
		b3.setBounds(80,500,1100,50);
		b3.setBackground(Color.black);
		b3.setForeground(Color.WHITE);
		add(b3);

        //activite
		b4= new JButton("activite");
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
				new deposeClient(tel);
			}else if(ae.getSource() == b2){
				new retraitClient(tel);	
			}else if(ae.getSource() == b3){
				new transfertClient(tel);
			}else if(ae.getSource() == b4){
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}
    }

}