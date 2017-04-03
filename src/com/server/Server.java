/**
 * 这是QQ服务器，他在监听，等待某个QQ客户端来连接
 */

package com.server;

import java.io.*;
import java.net.*;


public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Server(){
		try {
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			
			String info=br.readLine();
			
			while(true){
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
