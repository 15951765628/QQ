/**
 * 这是QQ服务器，他在监听，等待某个QQ客户端来连接
 */

package com.server.model;

import java.io.*;
import java.net.*;

import com.common.Message;
import com.common.User;


public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Server(){
		try {
			System.out.println("启动服务器");
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();//阻塞，等待连接
			//接受客户端发来的信息
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			User u=(User)ois.readObject();
			Message m=new Message();
			if(u.getPassword().equals("123456")){
				//登陆成功，返回1
				
				m.setMesType("1");		
			}else{
				m.setMesType("2"); 
			}
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
