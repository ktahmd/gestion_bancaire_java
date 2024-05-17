package bank;
import javax.swing.*;

import AccAdmin.MenuAgent;
import AccAdmin.admin;
import AccClient.Clients;
import AccClient.MenuClient;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;



	public login(){
		setTitle("Systeme de Gestion Bancaire");
		//bienvenue
		setLayout(null);
		l1=new JLabel("BIENVENIE");
		l1.setFont(new Font("Arial",Font.BOLD, 35));
		l1.setBounds(100,40,230,40);
		add(l1);
		//Telephone
		l2=new JLabel("Numero Telephone:");
		l2.setFont(new Font("Tohoma",Font.BOLD, 16));
		l2.setBounds(80,100,230,20);
		add(l2);
		tf1=new JTextField(20);
		tf1.setBounds(80,122,230,25);
		tf1.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(tf1);
		//password
		l3=new JLabel("Password:");
		l3.setFont(new Font("Tohoma",Font.BOLD, 16));
		l3.setBounds(80,150,230,20);
		add(l3);
		pf2=new JPasswordField(20);
		pf2.setBounds(80,172,230,25);
		pf2.setFont(new Font("Tohoma",Font.BOLD, 12));
		add(pf2);
		//buttom
		b1= new JButton("connexion");
		b1.setFont(new Font("Tohoma",Font.BOLD, 16));
		b1.setBounds(120,210,150,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		add(b1);
		//clean
		b2= new JButton("Reset");
		b2.setFont(new Font("Tohoma",Font.BOLD, 16));
		b2.setBounds(120,250,150,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		add(b2);
		//refister
		l1=new JLabel("Nouvel utilisateur ?");
		l1.setFont(new Font("Arial",Font.CENTER_BASELINE, 10));
		l1.setBounds(80,360,230,15);
		add(l1);
		b3= new JButton("inscrire");
		b3.setFont(new Font("Tohoma",Font.BOLD, 16));
		b3.setBounds(120,380,150,30);
		b3.setBackground(Color.black);
		b3.setForeground(Color.WHITE);
		add(b3);
		//action des buttons
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		//background
        ImageIcon bk = new ImageIcon(getClass().getResource("icons/backgroundlogin.jpg"));
		Image Ik=bk.getImage().getScaledInstance(800,540,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(Ik);
		JLabel iblimage=new JLabel(i3);
		iblimage.setBounds(0,0,800,500);
		add(iblimage);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setSize(800,500);
		setLocation(280,200);

	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == b1){
				String tel= tf1.getText();
				String pass= pf2.getText();
				Clients C = new Clients(tel);
				admin A = new admin(tel);
				if(tel.equals(C.getTel())&&(pass.equals(C.getPass()))){
					setVisible(false);
					new MenuClient(tel).setVisible(true);
				}else if(tel.equals(A.getUsername())&&(pass.equals(A.getPass()))){
					setVisible(false);
					new MenuAgent(tel).setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null,"Le numéro de téléphone ou le mot de passe est incorrect !","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			} else if(ae.getSource() == b2){
				
				tf1.setText("");
				pf2.setText("");
			} else if(ae.getSource() == b3){
				
				this.setVisible(false);
				new inscrire();
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}


}