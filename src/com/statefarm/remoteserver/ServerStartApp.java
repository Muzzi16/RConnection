package com.statefarm.remoteserver;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerStartApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);

		// get the bean from spring container
		ServerStart theServer = context.getBean("serverStart", ServerStart.class);

		// call a method on the bean
		System.out.println(theServer.getDestnationPort());

		ServerSocket serverSocket = null;
		Robot robot = null;
		Rectangle rectangle = null;
		/////
		try {
			System.out.println("Awaiting Connection from Client");
			serverSocket = new ServerSocket(Integer.parseInt(theServer.getDestnationPort()));
			GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

			rectangle = new Rectangle(dim);
			robot = new Robot(gDev);

			// drawGUI();

			while (true) {
				Socket sc = serverSocket.accept();
				new SendScreen(sc, robot, rectangle);
				new ReceiveEvents(sc, robot);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// close the context
		context.close();

	}

}
