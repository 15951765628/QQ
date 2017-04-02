/**
 * 我的好友列表，也包括陌生人，黑名单 
 */

package com.client.view;

import javax.swing.*;
import java.awt.*;


public class List extends JFrame{

	//定义需要的组件，3张卡片
	
	//处理第一张卡片
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jsp1;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l=new List();
	}
	
	public List(){
		
		//处理第一张卡片
		
		
		jphy_jb1=new JButton("我的好友");
		
		jphy_jb2=new JButton("陌生人");
		
		jphy_jb3=new JButton("黑名单");
		
		jphy1=new JPanel(new BorderLayout());
		//假定有50个好友
		jphy2=new JPanel(new GridLayout(50, 1,4,4));
		
		//给jphy2,初始化50好友
		JLabel[] jbls=new JLabel[50];
		int i=0;
		for(JLabel jb:jbls){
			jb=new JLabel(++i+"",new ImageIcon("images/1.png"),JLabel.LEFT);
			jphy2.add(jb);
		}
		
//		for(int i=0;i<jbls.length;i++){
//			jbls[i]=new JLabel(i+"",new ImageIcon("images/1.png"),JLabel.LEFT);
//			jphy2.add(jbls[i]);
//		}
		
		
		jphy3=new JPanel(new GridLayout(2,1));
		
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		
		
		jsp1=new JScrollPane(jphy2);
		
		//对jphy1初始化
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jsp1,"Center");
		jphy1.add(jphy3,"South");
		
		this.add(jphy1,"Center");
		this.setTitle("我的QQ");
		this.setSize(200,500);
		this.setLocation(1000, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
