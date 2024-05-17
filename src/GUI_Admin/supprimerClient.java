package GUI_Admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI_Client.Clients;

public class supprimerClient extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
    JTextField tf1;
    JButton b1;
    String username;
    public supprimerClient(String username) {
        this.username = username;
        setTitle("Supprimer client");
        setLayout(null); 

        JLabel l1 = new JLabel("Supprimer un client");
        l1.setFont(new Font("Arial", Font.BOLD, 35));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(130, 10, 300, 40); 
        add(l1);

        JLabel lblName = new JLabel("Numéro du compte:");
        lblName.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        lblName.setBounds(180, 140, 230, 20); 
        add(lblName);

        tf1 = new JTextField();
        tf1.setColumns(10);
        tf1.setBounds(180, 160, 230, 25); 
        add(tf1);


        b1 = new JButton("Supprimer compte");
        b1.setBounds(180, 200, 200, 30); 
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                String AccNum = tf1.getText();
                Clients C = new Clients(AccNum);
                if (C.getNom() != null) {
                    // Demander une confirmation à l'utilisateur
                    int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce compte ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        String Num= C.getAccNum();
                        int id = C.getId();
                        C.supprimerAcc(Num);
                        C.supprimerClient(id);
                        JOptionPane.showMessageDialog(null, "Compte supprimé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Compte n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
