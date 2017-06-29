package test;



import com.hibernate.mapping.ProjectTable;
import com.hibernate.mapping.UserTable;
import com.sun.corba.se.pept.encoding.InputObject;
import org.junit.Test;
import sun.org.mozilla.javascript.internal.json.JsonParser;
import tc.service.bean.ResultMessage;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by Administrator on 2017.06.22.
 */
public class test3{

    @Test
    public void test1() throws ClassNotFoundException {
        PrintWriter pw;
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            UserTable userTable = new UserTable();

            userTable.setUsername("zhuf2");
            userTable.setPassword("111111");
            userTable.setId(4);



            ResultMessage<UserTable> resultMessage=new ResultMessage<UserTable>();
            resultMessage.setData(userTable);
            resultMessage.setType("MR_login");
            oos.writeObject(resultMessage);
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println(((ResultMessage<UserTable>)isr.readObject()).getData().getId());


            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() throws ClassNotFoundException {
        PrintWriter pw;
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            UserTable userTable = new UserTable();

            userTable.setUsername("zhuf2");
            userTable.setPassword("111111");
            userTable.setId(4);



            ResultMessage<UserTable> resultMessage=new ResultMessage<UserTable>();
            resultMessage.setData(userTable);
            // resultMessage.setType("MR_login");
            resultMessage.setType("MR_projectList");
            oos.writeObject(resultMessage);
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println(((ResultMessage<List<ProjectTable>>)isr.readObject()).getData().get(0).getId());

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3() throws ClassNotFoundException {
        PrintWriter pw;
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            UserTable userTable = new UserTable();

            userTable.setUsername("zhuf2");
            userTable.setPassword("111111");
            userTable.setId(4);



            ResultMessage<UserTable> resultMessage=new ResultMessage<UserTable>();
            resultMessage.setData(userTable);
            // resultMessage.setType("MR_login");
            resultMessage.setType("MR_projectList");
            oos.writeObject(resultMessage);
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println(((ResultMessage<List<ProjectTable>>)isr.readObject()).getData().get(0).getId());

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4() throws ClassNotFoundException {
        PrintWriter pw;
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            UserTable userTable = new UserTable();

            userTable.setUsername("zhuf2");
            userTable.setPassword("111111");
            userTable.setId(4);



            ResultMessage<UserTable> resultMessage=new ResultMessage<UserTable>();
            resultMessage.setData(userTable);
            // resultMessage.setType("MR_login");
            resultMessage.setType("");
            oos.writeObject(resultMessage);
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println(((ResultMessage<List<ProjectTable>>)isr.readObject()).getData().get(0).getId());

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
