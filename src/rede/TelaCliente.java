package rede;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class TelaCliente extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(34, 11, 368, 205);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(278, 227, 124, 23);
		contentPane.add(btnNewButton);
	}
}
