package com.statefarm.remoteserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerStart {

	@Value("${server.port}")

	private String DEST_PORT;

	private static void drawGUI() {
	}

	public String getDestnationPort() {
		return DEST_PORT;
	}

}