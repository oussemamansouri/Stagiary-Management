package Gestion_des_stagiaires;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;



public class Gestion_des_stagiaires extends JFrame {

	 JPanel frame;
	private JTextField id;
	private JTextField mat;
	private JTextField nom;
	private JTextField prenom;
	private JTable table;
	CheckboxGroup G;
	Checkbox C1,C2,C3;
	Choice ch;
	DefaultTableModel model ;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_des_stagiaires frame = new Gestion_des_stagiaires();
					frame.setVisible(true);
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gestion_des_stagiaires() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
		setTitle("Gestion Des Stagiaires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,200, 739, 454);
		frame = new JPanel();
		frame.setBackground(SystemColor.text);
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 86, 83, 13);
		frame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricule :");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(22, 109, 83, 13);
		frame.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(135, 82, 122, 19);
		frame.add(id);
		id.setColumns(10);
		
		mat = new JTextField();
		mat.setColumns(10);
		mat.setBounds(135, 105, 122, 19);
		frame.add(mat);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(135, 128, 122, 19);
		frame.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(135, 151, 122, 19);
		frame.add(prenom);
		
		JLabel sexe = new JLabel("Sexe :");
		sexe.setFont(new Font("Tahoma", Font.BOLD, 12));
		sexe.setBounds(22, 236, 43, 13);
		frame.add(sexe);
		
		
		Choice ch = new Choice();
		ch.setBounds(135, 173, 122, 18);
		frame.add(ch);
		ch.add("Choisir le service");
		ch.add("informatique");
		ch.add("gestion et recrutment");
		ch.add("maintenance");
		ch.add("logistique");
		ch.add("fiscale");
		ch.add("transport");
		
		Choice ch2 = new Choice();
		ch2.setBounds(135, 200, 122, 18);
		frame.add(ch2);
		ch2.add("Choisir la durée");
		ch2.add("1 mois");
		ch2.add("2 mois");
		ch2.add("3 mois");
		
		G = new CheckboxGroup();
		
		Checkbox C1 = new Checkbox("F\u00E9minin",G,true);
		C1.setBounds(74, 236, 74, 21);
		frame.add(C1);
		
		Checkbox C2 = new Checkbox("Masculin",G,false);
		C2.setBounds(151, 236, 76, 21);
		frame.add(C2);
		
		Checkbox C3 = new Checkbox("Autre",G,false);
		C3.setBounds(231, 236, 66, 21);
		frame.add(C3);
		
	
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 61, 374, 331);
		frame.add(scrollPane);
		
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			
				int i = table.getSelectedRow();
				id.setText((String) model.getValueAt(i, 0));
				mat.setText((String) model.getValueAt(i, 1));
				nom.setText((String) model.getValueAt(i, 2));
				prenom.setText((String) model.getValueAt(i, 3));
				ch.select((String) model.getValueAt(i, 4));
				ch2.select((String) model.getValueAt(i, 5));
				
				
			}
		});
		table.setBackground(Color.WHITE);
		model=new DefaultTableModel();
		Object[] column = {"Id","Matricule","Nom","Prenom","Service","Durée De Stage","Sexe"};
		final Object[] row = new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		JButton ajou = new JButton("ajouter");
		ajou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (id.getText().equals("") ||  mat.getText().equals("") || nom.getText().equals("") || prenom.getText().equals("") || ch.getSelectedItem().equals("Choisir le service") || ch2.getSelectedItem().equals("Choisir la durée") )
				{
					JOptionPane.showMessageDialog(null, "Veuillez remplir les informations complètes");
					
				}else
				{
				row[0]=id.getText();
				row[1]=mat.getText();
				row[2]=nom.getText();
				row[3]=prenom.getText();
				row[4]=ch.getSelectedItem();
				row[5]=ch2.getSelectedItem();
				row[6]=G.getSelectedCheckbox().getLabel();
				model.addRow(row);
				
				id.setText("");
				mat.setText("");
				nom.setText("");
				prenom.setText("");
				ch.select(0);
				ch2.select(0);
				
				JOptionPane.showMessageDialog(null, "Enregistré avec succès");
				
				}
			}
		});
		ajou.setBounds(22, 297, 109, 21);
		frame.add(ajou);
		
		
		JButton supp = new JButton("supprimer");
		supp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if (i>=0){
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Supprimé avec succès");
					
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez d'abord sélectionner une ligne");
				
				}		
					
			}
		});
		supp.setBounds(22, 354, 109, 21);
		frame.add(supp);
		
		
		
		
		JButton modi = new JButton("modifier");
		modi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=table.getSelectedRow();
				if (i>=0) {
				model.setValueAt(id.getText(), i, 0);
				model.setValueAt(mat.getText(), i, 1);
				model.setValueAt(nom.getText(), i, 2);
				model.setValueAt(prenom.getText(), i, 3);
				model.setValueAt(ch.getSelectedItem(), i, 4);
				model.setValueAt(ch2.getSelectedItem(), i, 5);
				model.setValueAt(G.getSelectedCheckbox().getLabel(), i, 6);
				
				JOptionPane.showMessageDialog(null, "Mis à jour avec succés");
				
				}else
				{
					JOptionPane.showMessageDialog(null, "Veuillez d'abord sélectionner une ligne");
				}
			}
		});
		modi.setBounds(149, 297, 109, 21);
		frame.add(modi);
		
		
		
		JButton actu = new JButton("réinitialiser");
		actu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id.setText("");
				mat.setText("");
				nom.setText("");
				prenom.setText("");
				ch.select(0);
				ch2.select(0);
				
			}
		});
		actu.setBounds(149, 354, 111, 21);
		frame.add(actu);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBackground(SystemColor.menu);
		lblNewLabel_1_1.setBounds(22, 132, 83, 13);
		frame.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBackground(SystemColor.menu);
		lblNewLabel_1_2.setBounds(22, 155, 83, 13);
		frame.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Service :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBackground(SystemColor.menu);
		lblNewLabel_1_3.setBounds(22, 178, 83, 13);
		frame.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Dur\u00E9e De Stage :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBackground(SystemColor.menu);
		lblNewLabel_1_4.setBounds(22, 201, 121, 13);
		frame.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion Des Stagiares");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 19));
		lblNewLabel_2.setBounds(276, 17, 227, 23);
		frame.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("image/back34.jpg"));
		lblNewLabel_3.setBounds(0, 0, 725, 417);
		frame.add(lblNewLabel_3);
	
	}
}
