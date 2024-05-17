package GUI_Admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import ModifierForm.modifierA;

public class modifierC extends JFrame implements ActionListener {
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
    public modifierC(String username) {
        this.username = username;
        setTitle("Modifier un Compte");
        setLayout(null); 

        JLabel l1 = new JLabel("Modifier un Compte");
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


        b1 = new JButton("modifier compte");
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
                this.setVisible(false);
                new modifierA(tf1.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
