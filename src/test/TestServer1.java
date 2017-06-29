package test;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class TestServer1 extends JFrame implements ActionListener{
	
	private JScrollPane jsp;
	private JPanel jp;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jb;
	
	private PrintWriter pw;
	
	
	public static void main(String[] args){
		TestServer1 ts1=new TestServer1();
	}
	
	public TestServer1(){
		
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		
		jb=new JButton("发送");
		jtf=new JTextField(10);
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp,"Center");
		this.add(jp,"North");
		this.setTitle("服务器");
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();

			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true){

				String info = br.readLine();
				
				jta.append("客户端说："+info+"\r\n");
				if(info.equals("1")){
					s.close();
					jta.append("会话已关闭");
				}
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			String info=jtf.getText();
			pw.println(info);
			jta.append("服务器说："+info+"\r\n");
		}
	}

}
