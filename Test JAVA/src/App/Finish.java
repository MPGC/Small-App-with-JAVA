package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.Font;

public class Finish extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static ArrayList<Event> testEvents = new ArrayList<Event>();

	// Para lanzar la aplicaci�n.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish frame = new Finish();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Para crear y dar formato a la pantalla.
	public Finish() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			}
		});
		
		//Pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(173, 275, 439, 163);
		textField.setColumns(10);
		contentPane.add(textField);
		
		
		// 1� Bot�n SEARCH
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBackground(new Color(0, 255, 204));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TestingApp test = new TestingApp();
				test.setupData();

				textField = new JTextField();
				textField.setBounds(173, 275, 439, 163);
				textField.setColumns(10);
				textField.setText(test.testSearchEventByTimestamp("2022-02-13 17:53:10.0").toString());
				contentPane.add(textField);

			}
		});
		
		btnNewButton.setBounds(454, 113, 85, 21);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("SEARCH EVENTS BY TIMESTAMP LIST");
		lblNewLabel.setBounds(172, 113, 272, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SEARCH EVENTS BY SOURCE ID");
		lblNewLabel_1.setBounds(172, 154, 272, 21);
		contentPane.add(lblNewLabel_1);
		
		
		// 2� Bot�n SEARCH
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setBackground(new Color(255, 255, 102));
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TestingApp test = new TestingApp();
				test.setupData();

				textField = new JTextField();
				textField.setBounds(173, 275, 439, 163);
				textField.setColumns(10);
				textField.setText(test.testSearchEventBySourceID("2").toString());
				contentPane.add(textField);

			}
		});
		
		btnNewButton_1.setBounds(454, 154, 85, 21);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1_1 = new JLabel("SEARCH EVENTS BY RANGE OF VALUES");
		lblNewLabel_1_1.setBounds(172, 199, 272, 21);
		contentPane.add(lblNewLabel_1_1);
		
		
		// 3� Bot�n SEARCH
		JButton btnNewButton_1_1 = new JButton("SEARCH");
		btnNewButton_1_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TestingApp test = new TestingApp();
				test.setupData();

				textField = new JTextField();
				textField.setBounds(173, 275, 439, 163);
				textField.setColumns(10);
				textField.setText(test.testSearchEventWithinValueRange(1, 2).toString());
				contentPane.add(textField);

			}
		});
		
		
		btnNewButton_1_1.setBounds(454, 199, 85, 21);
		contentPane.add(btnNewButton_1_1);

		JLabel lblNewLabel_2 = new JLabel("RESULTS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(172, 252, 112, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CHOSSE AN OPTION:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBackground(SystemColor.activeCaption);
		lblNewLabel_3.setBounds(172, 90, 137, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("WELCOME TO OUR NEW APP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(275, 23, 244, 39);
		contentPane.add(lblNewLabel_4);
	}
}
