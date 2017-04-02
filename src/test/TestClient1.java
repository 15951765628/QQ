package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class TestClient1 extends JFrame implements ActionListener,KeyListener{
	
	private PrintWriter pw;
	private JPanel jp;
	private JButton jb;
	private JScrollPane jsp;
	private JTextField jtf;
	private JTextArea jta;
	
	
	
	public static void main(String[] args)
	{
		TestClient1 tc=new TestClient1();
	}
	
	public TestClient1()
	{
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jtf=new JTextField(10);
		jtf.addKeyListener(this);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		
		
		this.add(jsp,"Center");
		this.add(jp, "South");
		
		this.setTitle("QQ客户端");
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		try {
			Socket s=new Socket("127.0.0.1",9999);
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true){
				String info=br.readLine();
				jta.append("服务器说："+info+"\r\n");
				if(info.equals("1")){
					s.close();
					jta.append("会话结束！");	
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
			jta.append("客户端说："+info+"\r\n");
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
