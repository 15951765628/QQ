/**
 * 功能，登录界面
 */

package com.client.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class Login extends JFrame{

	//定义北部需要的组件
	
	JLabel jl1;
	
	
	//定义中需要的组件
	//中部有三个JPanel，有一个叫选项卡串口管理
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jl1,jp2_jl2,jp2_jl3,jp2_jl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	
	
	//定义南部需要的组件
	
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login l=new Login();
	}
	
	public Login(){
		//处理北部
		
		jl1=new JLabel(new ImageIcon("images/tou.png"));
		
		//处理中部
		jp2=new JPanel(new GridLayout(3,3));
		jp2_jl1=new JLabel("QQ号码",JLabel.CENTER);
		jp2_jl2=new JLabel("QQ密码",JLabel.CENTER);
		jp2_jl3=new JLabel("忘记密码",JLabel.CENTER);
		jp2_jl3.setForeground(Color.cyan);
		jp2_jl4=new JLabel("申请密码保护",JLabel.CENTER);
		jp2_jb1=new JButton("清除号码");
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		jp2_jcb1=new JCheckBox("隐身登录");
		jp2_jcb2=new JCheckBox("记住密码");
		
		
		//把空间按照顺序加到jp2
		jp2.add(jp2_jl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jl4);
		
		//创建jp3
		jp3=new JPanel();
		//创建jp4
		jp4=new JPanel();
		
		jtp=new JTabbedPane();
		jtp.add("1", jp2);
		jtp.add("2", jp3);
		jtp.add("3", jp4);
		
		//处理南部
		jp1=new JPanel();
		jp1_jb1=new JButton(new ImageIcon("images/dl.png"));
		
		//把三个按钮放到jp1
		jp1.add(jp1_jb1);
		
		this.add(jtp,"Center");
		this.add(jl1,"North");
		this.add(jp1,"South");
		this.setLocation(1000,500);
		this.setSize(350,240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
