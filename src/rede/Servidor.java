package rede;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(10000);
		System.out.println("Porta 10000 aberta! Aguardando conexão como cliente...");
		
		Socket client = servidor.accept();
		System.out.println("conexão do cliente!" +  client.getInetAddress().getHostAddress());
		
		Scanner s = new Scanner(client.getInputStream());
		while(s.hasNextLine()) {
			System.out.println(s.hasNextLine());
		}
		
		s.close();
		client.close();
		servidor.close();
	}
}
