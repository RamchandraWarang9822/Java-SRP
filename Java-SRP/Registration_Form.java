package SRPWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





@SuppressWarnings("serial")

public class Registration_Form extends JFrame {


//---------------
// MODEL  
//---------------


	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtCon;
	private JTextField txtAdd;

	Connection con;
	PreparedStatement pst;
	private JTable table;
	private JScrollPane scrollPane;


	//DATABASE Connection : MySQl 
	public void Table_update() {

		int c;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_1", "root", "aditya 08");

			pst = con.prepareStatement("Select * from Records");
			ResultSet Rs = pst.executeQuery();

			java.sql.ResultSetMetaData rd = Rs.getMetaData();
			c = rd.getColumnCount();
			DefaultTableModel df = (DefaultTableModel) table.getModel();
			df.setRowCount(0);

			while (Rs.next()) {

				Vector<Object> v2 = new Vector<>();

				for (int i = 1; i <= c; i++) {

					v2.add(Rs.getString("idRecords"));
					v2.add(Rs.getString("Name"));
					v2.add(Rs.getString("Contact"));
					v2.add(Rs.getString("Address"));
					v2.add(Rs.getString("Course"));

				}
				df.addRow(v2);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}


//---------------	
// VIEW
//---------------


	// Create the frame.
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Registration_Form() {
		
		setForeground(Color.BLACK);
		setFont(new Font("Tahoma", Font.BOLD, 18));
		setTitle("Register Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 669);

	//Main Panel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0x0F3D3E));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


	//Input & Label Panel

		//Header Label
		JLabel lblNewLabel = new JLabel("Register Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0xE2DCC8));
		lblNewLabel.setBounds(10, 11, 860, 81);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		contentPane.add(lblNewLabel);


		//Labels
		JLabel lblNewLabel_1 = new JLabel("Enter Course : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 368, 281, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Name : ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 129, 281, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Enter Contact number : ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 208, 281, 25);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Enter Address : ");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 289, 281, 25);
		contentPane.add(lblNewLabel_1_3);


		//Input Fields 
		txtname = new JTextField();
		txtname.setBounds(10, 165, 281, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		txtname.setForeground(new Color(0x0F3D3E));
		

		txtCon = new JTextField();
		txtCon.setColumns(10);
		txtCon.setBounds(10, 246, 281, 32);
		contentPane.add(txtCon);
		txtCon.setForeground(new Color(0x0F3D3E));

		txtAdd = new JTextField();
		txtAdd.setColumns(10);
		txtAdd.setBounds(10, 325, 281, 32);
		contentPane.add(txtAdd);
		txtAdd.setForeground(new Color(0x0F3D3E));

		JComboBox<?> courselist = new JComboBox<Object>();
		courselist.setFont(new Font("Tahoma", Font.BOLD, 13));
		courselist.setBackground(new Color(0xFFFFFF));
		courselist.setModel(new DefaultComboBoxModel(new String[] { "CS", "IT", "AI&DS", "ENTC" }));
		courselist.setBounds(10, 404, 281, 38);
		contentPane.add(courselist);
		courselist.setForeground(new Color(0x0F3D3E));


	//Button Section
		JButton Addbtn = new JButton("Add");
		Addbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Addbtn.setBounds(10, 458, 133, 46);
		Addbtn.setBackground(new Color(0xFFFFFF));
		Addbtn.setForeground(new Color(0x0F3D3E));
		contentPane.add(Addbtn);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setBounds(158, 458, 133, 46);
		btnEdit.setBackground(new Color(0xFFFFFF));
		btnEdit.setForeground(new Color(0x0F3D3E));
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(10, 525, 133, 46);
		btnDelete.setBackground(new Color(0xFFFFFF));
		btnDelete.setForeground(new Color(0x0F3D3E));
		contentPane.add(btnDelete);

		JButton btnBack = new JButton("Log out");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(158, 525, 133, 46);
		btnBack.setBackground(new Color(0xFFFFFF));
		btnBack.setForeground(new Color(0x0F3D3E));
		contentPane.add(btnBack);


	//Record Display pannel
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(301, 127, 559, 442);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Table Colors
		table.setBackground(new Color(0xFFFFFF));
		table.setForeground(new Color(0x000000));

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Roll no", "Name", "Contact", "Address", "Course" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Integer.class, String.class,
					String.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		Table_update();

		
//---------------
// CONTROLLER
//---------------


		//JTable Mouse Listener
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel d1 = (DefaultTableModel) table.getModel();

				int selectIndex = table.getSelectedRow();

				txtname.setText(d1.getValueAt(selectIndex, 1).toString());
				txtCon.setText(d1.getValueAt(selectIndex, 2).toString());
				txtAdd.setText(d1.getValueAt(selectIndex, 3).toString());
				courselist.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());

			}
		});

		//Add Button function
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = txtname.getText();
				String contact = txtCon.getText();
				String address = txtAdd.getText();
				String course = courselist.getSelectedItem().toString();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_1", "root", "aditya 08");

					pst = con.prepareStatement("insert into Records(Name,Contact,Address,Course)values(?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, contact);
					pst.setString(3, address);
					pst.setString(4, course);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(scrollPane, " Record Added! ", " Message ", 1);

					txtname.setText("");
					txtCon.setText("");
					txtAdd.setText("");
					courselist.setSelectedIndex(-1);
					txtname.requestFocus();

					Table_update();

				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}

			}
		});

		//Edit Button function
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel d2 = (DefaultTableModel) table.getModel();

				int selectIndex = table.getSelectedRow();

				try {

					String Id = d2.getValueAt(selectIndex, 0).toString();
					String name = txtname.getText();
					String contact = txtCon.getText();
					String address = txtAdd.getText();
					String course = courselist.getSelectedItem().toString();

					pst = con.prepareStatement(
							"update Records set Name=?,Contact=?,Address=?,Course=? where idRecords=?");

					pst.setString(1, name);
					pst.setString(2, contact);
					pst.setString(3, address);
					pst.setString(4, course);
					pst.setString(5, Id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(scrollPane, " Record Edited! ", " Message ", 1);

					txtname.setText("");
					txtCon.setText("");
					txtAdd.setText("");
					courselist.setSelectedIndex(-1);
					txtname.requestFocus();

					Table_update();

					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_1", "root", "aditya 08");

				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}

			}
		});

		//Delete Button Function
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel d2 = (DefaultTableModel) table.getModel();

				int selectIndex = table.getSelectedRow();

				try {

					String Id = d2.getValueAt(selectIndex, 0).toString();

					pst = con.prepareStatement("delete from Records where idRecords=?");

					pst.setString(1, Id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(scrollPane, " Record Deleted! ", " Message ", 2);

					txtname.setText("");
					txtCon.setText("");
					txtAdd.setText("");
					courselist.setSelectedIndex(-1);
					txtname.requestFocus();

					Table_update();

					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_1", "root", "aditya 08");

				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

	}

//
//	Launch the application.
//

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_Form frame = new Registration_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
