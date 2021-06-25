package rede;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaServidor extends JFrame {

	private JPanel contentPane;
	private JTextField mensagemChatServer;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	
	

	/**
	 * Create the frame.
	 */
	public TelaServidor() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Handler ouvinte = new Handler();
		
		JTextArea areadeTextoServer = new JTextArea();
		areadeTextoServer.setBounds(38, 11, 368, 140);
		contentPane.add(areadeTextoServer);
		
		mensagemChatServer = new JTextField();
		mensagemChatServer.setBounds(36, 198, 197, 20);
		contentPane.add(mensagemChatServer);
		mensagemChatServer.setColumns(10);
		
		JButton botaoEnviarServer = new JButton("Enviar");
		botaoEnviarServer.setBounds(255, 197, 89, 23);
		contentPane.add(botaoEnviarServer);
		botaoEnviarServer.addActionListener(ouvinte);
	}
	

	public class Handler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
				String msgout = "";
				msgout = mensagemChatServer.getText().trim();
				msgout.writeUTF(msgout);
				
			}
	}
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(10000);
		System.out.println("Porta 10000 aberta! Aguardando conexão como cliente...");
		
		Socket client = servidor.accept();
		System.out.println("conexão do cliente!" +  client.getInetAddress().getHostAddress());
		
		Scanner s = new Scanner(client.getInputStream());
		while(s.hasNextLine()) {
			System.out.println(s.hasNextLine());
		}
		
		try {
			ss = new ServerSocket(1201);
			
			
		} catch (Exception e) {
			
		}
		
		s.close();
		client.close();
		servidor.close();
	}
}
