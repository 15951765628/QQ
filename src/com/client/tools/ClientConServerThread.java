/**
 * 这是客户端和服务器端保持通讯的线程。
 */

package com.client.tools;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.client.view.Chat;
import com.client.view.List;
import com.common.Message;
import com.common.MessageType;

public class ClientConServerThread extends Thread{
	private Socket s;
	
	//构造函数
	public ClientConServerThread(Socket s)
	{
		this.s=s;
		
	}
	
	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public void run(){
		while(true){
			//不停地读取从服务器端发来的消息
			try { 
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				if(m.getMesType().equals(MessageType.mes_comm_mes)){
					//把从服务器获得的信息，显示到该聊天的聊天界面
					Chat chat=ManageChat.getChat(m.getGetter()+" "+m.getSender());
					//显示
					chat.showMessage(m);
				}else if(m.getMesType().equals(MessageType.mes_get_onLineFriends)){
					//请求在线好友
					String con=m.getCon();
					String friends[]=con.split(" ");
					String getter=m.getGetter();
					//修改相应的好友列表
					List list = ManageList.getList(getter);
					//更新在线好友
					list.update(m);
					
				}
								
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
