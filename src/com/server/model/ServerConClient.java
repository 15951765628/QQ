/**
 * 
 * 功能：是服务器和某个客户端的通信线程
 */
package com.server.model;

import java.net.*;

import com.common.Message;
import com.common.MessageType;

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
				
				//对从客户端取得的消息进行类新判断，然后做相应的处理
				if(m.getMesType().equals(MessageType.mes_comm_mes)){

					//取得接收人的通信线程
					ServerConClient scc=ManageClientThread.getClientThread(m.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(scc.s.getOutputStream());
					oos.writeObject(m);
						
				}else if(m.getMesType().equals(MessageType.mes_get_onLineFriends)){
					//把在服务器的好友给该客户端
					String res=ManageClientThread.getAllOnLineUserId();
					Message m2=new Message();
					m2.setCon(res);
					m2.setGetter(m.getSender());
					m2.setMesType(MessageType.mes_ret_onLoneFriends);
					
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(m2);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
