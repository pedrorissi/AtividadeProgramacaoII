package rede;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField mensagemChat;


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
		
		JTextArea areadeTexto = new JTextArea();
		areadeTexto.setBounds(34, 11, 368, 169);
		contentPane.add(areadeTexto);
		
		JButton botaoEnviar = new JButton("Enviar");
		botaoEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoEnviar.setBounds(263, 202, 97, 23);
		contentPane.add(botaoEnviar);
		
		mensagemChat = new JTextField();
		mensagemChat.setBounds(34, 196, 219, 35);
		contentPane.add(mensagemChat);
		mensagemChat.setColumns(10);
	}
	
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("127.0.0.1", 10000);
		System.out.println("Cliente conectado ao servidor!");
		
		Scanner s = new Scanner(System.in);
		PrintStream out = new PrintStream(client.getOutputStream());
		
		while (s.hasNextLine()) {
			out.println(s.nextLine());
		}
			
		out.close(); 
		s.close();
		client.close();
		
	}
	
}
