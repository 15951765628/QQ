
/**
 * 这是服务器的控制界面，可以完成启动服务器，关闭服务器
 * 可以管理和监控用户。
 * 
 */
package com.server;

import javax.swing.*;


public class ServerFrame extends JFrame{

	JPanel jp1;
	JButton jb1,jb2;
	
	
	public static void main(String[] args){
		ServerFrame s=new ServerFrame();
	}
	
	public ServerFrame(){
		
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb2=new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);
		
		
		this.add(jp1);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		
		
	}
}
