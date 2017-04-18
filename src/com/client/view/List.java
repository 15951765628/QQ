/**
 * 我的好友列表，也包括陌生人，黑名单 
 */

package com.client.view;

import javax.swing.*;

import com.client.tools.ManageChat;
import com.common.Message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class List extends JFrame implements ActionListener,MouseListener{

	//定义需要的组件，3张卡片
	CardLayout c1;
	
	//处理第一张卡片
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jsp1;
	
	//处理第2张卡片
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
	JScrollPane jsp2;	
	
	JLabel[] jbls;
	
	private String id;
 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List l=new List();
	}
	
	//更新在线的好友
	public void update(Message m)
	{
		String[] onLineFriends=m.getCon().split(" ");
		for(int i=0;i<onLineFriends.length;i++){
			jbls[Integer.parseInt(onLineFriends[i])-1].setEnabled(true);
		}
		
	}
	
	
	
	public List(String id){
		
		//处理第一张卡片
		
		this.id=id;
		jphy_jb1=new JButton("我的好友");
		
		
		jphy_jb2=new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		
		jphy_jb3=new JButton("黑名单");
		
		jphy1=new JPanel(new BorderLayout());
		//假定有50个好友
		jphy2=new JPanel(new GridLayout(50, 1,4,4));
		
		//给jphy2,初始化50好友
		jbls=new JLabel[50];
//		int i=0;
//		for(JLabel jb:jbls){
//			System.out.println(1);
//			jb=new JLabel(++i+"",new ImageIcon("images/1.png"),JLabel.LEFT);
//			
//		}
		
		for(int i=0;i<jbls.length;i++){
			jbls[i]=new JLabel((i+1)+"",new ImageIcon("images/1.png"),JLabel.LEFT);
			jbls[i].setEnabled(false);
			
			if(jbls[i].getText().equals(id)){
				jbls[i].setEnabled(true);
			}
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);
		}
		
		
		jphy3=new JPanel(new GridLayout(2,1));
		
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		
		
		jsp1=new JScrollPane(jphy2);
		
		//对jphy1初始化
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jsp1,"Center");
		jphy1.add(jphy3,"South");
		
		//处理第二张卡片
		
		
		jpmsr_jb1=new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("陌生人");
		
		jpmsr_jb3=new JButton("黑名单");
		
		jpmsr1=new JPanel(new BorderLayout());
		//假定有50个好友
		jpmsr2=new JPanel(new GridLayout(50, 1,4,4));
		
		//给jphy2,初始化50好友
		JLabel[] jbls2=new JLabel[20];

		
		for(int j=0;j<jbls2.length;j++){
			jbls2[j]=new JLabel(j+1+"",new ImageIcon("images/1.png"),JLabel.LEFT);
			jbls2[j].addMouseListener(this);
			jpmsr2.add(jbls2[j]);
		}
		
		
		jpmsr3=new JPanel(new GridLayout(2,1));
		
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		
		jsp2=new JScrollPane(jpmsr2);
		
		//对jphy1初始化
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jsp2,"Center");
		jpmsr1.add(jpmsr_jb3,"South");		
		
		
		
		c1=new CardLayout();
	
		this.setLayout(c1);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		
		this.setTitle(id);
		
		
		
		this.setSize(200,500);
		this.setLocation(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jpmsr_jb1){
			c1.show(this.getContentPane(), "1");
		}
		if(e.getSource()==jphy_jb2){
			c1.show(this.getContentPane(), "2");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//响应用户双击事件，并得到好友的编号
		if(e.getClickCount()==2){
			//得到给好友的编号
			String friendNo=((JLabel)e.getSource()).getText();
			Chat chat=new Chat(this.getTitle(),friendNo);
			//把聊天界面接入到管理类
			ManageChat.addChat(this.getTitle()+" "+friendNo, chat);
		}
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
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);
		
	}

}
