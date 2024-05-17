package AccClient;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

public class deposeClient extends JFrame {
    JLabel l1, l2, lNum;

    public deposeClient(String tel) {
        setTitle("Depose argent");
        setLayout(new BorderLayout());

        // Panel for labels
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1, 0, 10));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        l1 = new JLabel("Pour déposer de l'argent");
        l1.setFont(new Font("Arial", Font.BOLD, 35));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(l1);

        l2 = new JLabel("veuillez vous rendre à l'agence la plus proche de chez vous.");
        l2.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(l2);

        lNum = new JLabel();
        lNum.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        lNum.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(lNum);

        add(labelPanel, BorderLayout.NORTH);

        // Image panel
        ImageIcon bk = new ImageIcon(getClass().getResource("icons/Agence.png"));
        Image Ik = bk.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(Ik);
        JLabel iblimage = new JLabel(i3);
        iblimage.setHorizontalAlignment(SwingConstants.CENTER);
        add(iblimage, BorderLayout.CENTER);

        // Fetch and display account number
        try {
            Clients C = new Clients(tel);
            lNum.setText("Votre numéro de compte: " + C.getAccNum());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération du numéro de compte.", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window on screen
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

}
