package GUI_Client;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.Connctionfactory;

public class AfficherList extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    public AfficherList(String tel) {
        setTitle("Dernières activités");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Opération");
        tableModel.addColumn("Trans_num");
        tableModel.addColumn("De");
        tableModel.addColumn("À");
        tableModel.addColumn("Date");
        tableModel.addColumn("Montant");

        JTable table = new JTable(tableModel);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 16)); 

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);


        table.setFont(new Font("Arial", Font.BOLD, 14)); 

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


        JLabel titleLabel = new JLabel("Dernières activités");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(titleLabel, BorderLayout.NORTH);

        Connctionfactory cf = new Connctionfactory();

        try {
            String query = "SELECT trans_id, fromWho, ToWho, date_trans, montant " +
                "FROM transfert " +
                "WHERE fromWho = '" + tel + "' OR ToWho = '" + tel + "' " +
                "ORDER BY date_trans DESC";
            ResultSet rs = cf.smt.executeQuery(query);

            while (rs.next()) {
                String trans_id = rs.getString("trans_id");
                String fromWho = rs.getString("fromWho");
                String toWho = rs.getString("ToWho");
                String date_trans = rs.getString("date_trans");
                String montant = rs.getString("montant");

                //operation
                String operation;
                if (fromWho.startsWith("agent N:")) {
                    operation = "Dépôt";
                } else if (toWho.startsWith("agent N:")) {
                    operation = "Retrait";
                } else if (fromWho.equals(tel)) {
                    operation = "Transfert";
                } else if (toWho.equals(tel)) {
                    operation = "Reçu";
                } else {
                    operation = "Inconnu";
                }

                tableModel.addRow(new String[]{operation, trans_id, fromWho, toWho, date_trans, montant});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
