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
				while(true){
				Socket s=ss.accept();//阻塞，等待连接
				//接受客户端发来的信息
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				
				User u=(User)ois.readObject();
				Message m=new Message();
				if(u.getPassword().equals("123456")){
					//登陆成功，返回1
					
					m.setMesType("1");		
					oos.writeObject(m);
					//这里就单开一个线程，让爱西安城与客户端保持通信
					ServerConClient scc=new ServerConClient(s);
					ManageClientThread.addClientThread(u.getName(),scc);
					//启动与给客户端的通信
					scc.start();
					
				}else{
					m.setMesType("2"); 
					oos.writeObject(m);
					//关闭连接
					s.close();
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
