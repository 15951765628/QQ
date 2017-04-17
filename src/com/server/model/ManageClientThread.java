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
	//返回当前在线的人数的情况
	public static String getAllOnLineUserId(){
		//使用迭代器完成
		Iterator it=hm.keySet().iterator();
		String res="";
		while(it.hasNext()){
			res+=it.next().toString()+" ";
		}
		return res;
	}
	
}
