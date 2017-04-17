package com.server.model;

import java.util.*;

public class ManageClientThread {

	public static HashMap hm=new HashMap<String ,ServerConClient>();
	
	//向hm中添加一个客户端通信线程
	public static void  addClientThread(String uid,ServerConClient scc)
	{
		hm.put(uid, scc);
	}
	
	public static ServerConClient getClientThread(String uid)
	{
		return (ServerConClient)hm.get(uid);
	}
	
}
