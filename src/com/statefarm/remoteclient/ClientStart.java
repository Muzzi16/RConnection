package com.statefarm.remoteclient;

import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientStart {
	static String port = "5962";

	public static void main(String args[]) {
		String ip = JOptionPane.showInputDialog("Please enter server ip");
		new ClientStart().initialize(ip, Integer.parseInt(port));
	}

	public void initialize(String ip, int port) {
		try {

			Socket clientSocket = new Socket(ip, port);
			System.out.println("Connecting to the Server");
			CreateFrame abc = new CreateFrame(clientSocket, "1920.0", "1080.0");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
