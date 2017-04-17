/**
 * 这是客户端连接服务器的后台
 */
package com.client.model;

import com.common.Message;
import java.net.*;
import java.io.*;

public class ClientConServer {

	public static Socket s; 
	
	public boolean sendLoginInfoToServer(Object o)//发送给服务器验证
	{
		boolean b=false ;
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message ms=(Message)ois.readObject();
			if(ms.getMesType().equals("1")){
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
