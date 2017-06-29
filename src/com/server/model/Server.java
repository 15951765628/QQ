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
		Server s=new Server();
	}
	
	public Server(){
		try {
				System.out.println("启动服务器");

				ServerSocket ss = new ServerSocket();
				for (int port = 8066;port<8076;port++){
					try {
						ss=new ServerSocket(port);
					}catch (IOException e){
						System.out.println("启动端口"+port+"失败");
						continue;
					}
					System.out.println("启动"+port+"成功");
					break;
				}

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
