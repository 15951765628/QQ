/**
 * 这是与好友聊天的界面
 * 因为客户端要处于读取的状态。因此我们要把它做成一线程
 */

package com.client.view;

import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.client.model.ClientConServer;
import com.client.tools.ManageClientConServerThread;
import com.common.Message;

public class Chat extends JFrame implements MouseListener,ActionListener,KeyListener{
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	
	String id;
	String friend;
	public String friends[];
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chat ch=new Chat("小明");
	}
	
	public Chat(String id,String friend){
		this.id=id;
		this.friend=friend;
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.addKeyListener(this);
		this.add(jta,"Center");
		this.add(jp, "South");
		this.setTitle(id+"正在和"+friend+"聊天");
		this.setIconImage(new ImageIcon("images/1.png").getImage());
		this.setSize(300,200);
		this.setVisible(true);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	//写一个方法，让他显示消息
	public void showMessage(Message m)
	{
		String info=m.getSender()+"对"+m.getGetter()+"说："+m.getCon()+"\r\n";
		this.jta.append(info);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			sendMes();
		}
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==13){
			sendMes();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	private void sendMes() {
		//用户端点击了发送按钮
		Message m=new Message();
		m.setSender(id);
		m.setGetter(friend);
		m.setCon(jtf.getText().trim());
		m.setSendTime(new java.util.Date().toString());
		//发送给服务器
		try {
			ObjectOutputStream oos=new ObjectOutputStream
					(ManageClientConServerThread.getClientConServerThread(id).getS().getOutputStream());
			oos.writeObject(m);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			jtf.setText("");
		}
	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){
//			//读取Object[如果读不到就等待，]
//			try {
//				ObjectInputStream ois=new ObjectInputStream(ClientConServer.s.getInputStream());
//				Message m=(Message)ois.readObject();
//				//显示
//				String info=m.getSender()+"对"+m.getGetter()+"说："+m.getCon()+"\r\n";
//				this.jta.append(info);
//						
//				
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

}
