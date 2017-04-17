package com.client.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Message;
import com.common.User;

public class ClientUser {

	public boolean checkUser(User u){		
		return new ClientConServer().sendLoginInfoToServer(u);
	}

}
