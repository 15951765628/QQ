/**
 * 
 * 功能：是服务器和某个客户端的通信线程
 */
package com.server.model;

import java.net.*;

import com.common.Message;

import java.io.*;

public class ServerConClient extends Thread{

	Socket s;
	
	public ServerConClient(Socket s){
		//把服务器和客户端的连接赋给S
		this.s=s;
	}
	
	public void run(){
		while(true){
			//这里该线程就可以接受客户端的信息
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
				//取得接收人的通信线程
				ServerConClient scc=ManageClientThread.getClientThread(m.getGetter());
				ObjectOutputStream oos=new ObjectOutputStream(scc.s.getOutputStream());
				oos.writeObject(m);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
