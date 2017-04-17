/**
 * 这是客户端连接服务器的后台
 */
package com.client.model;

import com.client.tools.ClientConServerThread;
import com.client.tools.ManageClientConServerThread;
import com.common.Message;
import com.common.User;

import java.net.*;
import java.io.*;

public class ClientConServer {

	public Socket s; 
	
	public boolean sendLoginInfoToServer(Object o)//发送给服务器验证
	{
		boolean b=false ;
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message ms=(Message)ois.readObject();
			//这里就是验证用户登陆的地方
			if(ms.getMesType().equals("1")){
				//就创建一个改QQ号和服务器端保持通讯连接的线程
				ClientConServerThread ccst=new ClientConServerThread(s);
				//启动该通讯
				ccst.start();
				ManageClientConServerThread.addClientConServerThread(((User)o).getName(), ccst);
				b=true;
			}else{
				s.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return b;
	}
}
