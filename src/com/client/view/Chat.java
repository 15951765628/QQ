/**
 * 这是与好友聊天的界面
 */

package com.client.view;
import java.awt.event.*;


import javax.swing.*;

public class Chat extends JFrame implements MouseListener,ActionListener{
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chat ch=new Chat("小明");
	}
	
	public Chat(String friend){
		jta=new JTextArea();
		jtf=new JTextField(20);
		jb=new JButton("发送");
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp, "South");
		this.setTitle("你正在和"+friend+"聊天");
		this.setIconImage(new ImageIcon("images/1.png").getImage());
		this.setSize(300,200);
		this.setVisible(true);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

}
