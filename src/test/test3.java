package test;




import com.spasvo.manualtest.dao.module.ComponentBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.junit.Test;
import tc.service.bean.ResultMessage;
import java.io.*;
import java.net.Socket;


/**
 * Created by Administrator on 2017.06.22.
 */
public class test3{

    /**
     * 登录
     * @throws ClassNotFoundException
     */
    @Test
    public void test1() throws ClassNotFoundException {
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            JSONObject result=new JSONObject();
            JSONObject jsonData = new JSONObject();
            jsonData.put("username","zhuf2");
            jsonData.put("password","111111");

            result.put("data",jsonData);
            result.put("type","MR_login");
            oos.writeObject(result.toString());
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println((JSONObject.fromObject((String)isr.readObject())));


            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 项目
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException {
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            JSONObject result=new JSONObject();
            JSONObject jsonData = new JSONObject();
            jsonData.put("username","zhuf2");
            jsonData.put("password","111111");
            jsonData.put("id",4);

            result.put("data",jsonData);
            result.put("type","MR_projectList");
            oos.writeObject(result.toString());
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            JSONArray resultDataList=JSONObject.fromObject((String)isr.readObject()).getJSONArray("data");
            for (int i=0;i<resultDataList.size();i++){
                System.out.println(resultDataList.getJSONObject(i).getString("name"));
            }


            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 组件组和组件列表
     * @throws ClassNotFoundException
     */
    @Test
    public void test3() throws ClassNotFoundException {
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            JSONObject jsonData=new JSONObject();
            jsonData.put("parentId",1);
            jsonData.put("projectId",2);
//            List<Integer> list = new ArrayList<Integer>();
//            list.add(0);
//            list.add(2);

          //  list.add(4);
          // list.add(2);



            JSONObject resultMessage=new JSONObject();
            resultMessage.put("data",jsonData);
            resultMessage.put("type","MR_comList");
            oos.writeObject(resultMessage.toString());
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            JSONObject result = JSONObject.fromObject((String)isr.readObject());
            JSONArray resultDataList = result.getJSONArray("data");
            for (int i=0;i<resultDataList.size();i++){
                if (resultDataList.getJSONObject(i).has("dataName"))
              System.out.println(resultDataList.getJSONObject(i).getString("dataName")+"   name:"+resultDataList.getJSONObject(i).getString("name"));
                else
                {
                    System.out.println("groupname:"+resultDataList.getJSONObject(i).getString("name"));
                }
               // System.out.println(resultDataList.getJSONObject(i).getString("id"));
            }


            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 检查传递文件，选择文件
     */

    @Test
    public void testUpFile() throws IOException {

        try {
            JSONObject json =new JSONObject();
            JSONObject jsonData = new JSONObject();
            json.put("type","MR_upScript");
            jsonData.put("dataName","23333333333");
            jsonData.put("projectId",2);

            Socket s;
            ObjectOutputStream oos;

            String scriptName="C:\\Users\\Administrator\\Documents\\test\\A";
            this.testZip(scriptName+"Image",scriptName+"Image.zip");
            String[] fileArr={scriptName+".bsh",scriptName+".xml",scriptName+".xls",scriptName+"Image.zip"};


            for (String filePath:fileArr) {
                s = new Socket("127.0.0.1", 10088);
                oos = new ObjectOutputStream(s.getOutputStream());
                jsonData.put("fileName", filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length()));
                json.put("data", jsonData);
                oos.writeObject(json.toString());
                BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filePath));
                System.out.println(filePath);
                OutputStream os = s.getOutputStream();
                byte[] b = new byte[1024 * 1024];
                int length = 0;
                while ((length = bi.read(b)) > 0) {
                    os.write(b, 0, length);
                }

                // ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
                // JSONObject rm=JSONObject.fromObject((String)isr.readObject());
                // System.out.println(rm.getString("data"));
                s.shutdownOutput();
                //Thread.sleep(100);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * 测试压缩文件
     */
   // @Test
    public  void testZip(String inPath,String outPath) throws BuildException, RuntimeException {

        File file = new File(inPath);
        if (!file.exists()) {
            throw new RuntimeException("source file or directory  does not exist.");
        }
        if((new File(outPath)).exists()){
            (new File(outPath)).delete();
        }

        Project proj = new Project();
        FileSet fileSet = new FileSet();
        fileSet.setProject(proj);
        // 判断是目录还是文件
        if (file.isDirectory()) {
            fileSet.setDir(file);
            // ant中include/exclude规则在此都可以使用
            // 比如:
            // fileSet.setExcludes("**/*.txt");
            // fileSet.setIncludes("**/*.xls");
        } else {
            fileSet.setFile(file);
        }

        Zip zip = new Zip();
        zip.setProject(proj);
        zip.setDestFile(new File(outPath));
        zip.addFileset(fileSet);
        zip.setEncoding("GBK");
        zip.execute();

        System.out.println("compress successed.");
    }


    /**
     * 检查名称是否重复MR_addComment
     * @throws ClassNotFoundException
     */
    @Test
    public void test4() {
        try {
            Socket s = new Socket("127.0.0.1", 10088);
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            //模拟addLeaf
            JSONObject param = new JSONObject();
            ComponentBean bean=new ComponentBean();
            String path = "D:\\TC\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TestLab\\file\\2\\components";
            //设置语言
            //String lang = getUserSummary(request).getLang();
            String lang = "zn";
            //设置组件名称
            param.put("name", "来自北方的组件");
            //版本号
            param.put("version","");

            //详细描述
            param.put("description", "");
            //继承的脚本的ID，没有的是0
            param.put("extendsComId", 0);
            //设置脚本名称
            param.put("scriptName", "A");
            //runId=2？？？是运行环境，mobilerunner需要新建一个类别。安卓用的是3，ios用4
            param.put("runId", 3);
            //所在组件组名称
            param.put("groupName", "zu1");
            //时间戳，前台提供，通过调用后台接口的方式获取时间戳
            param.put("dataName", "1499067237211");
            //所在组件组的ID
            param.put("parentId", 1);
            //用户名，登录名称
            param.put("userName", "zhuf2");
            //项目ID
            param.put("projectId", 2);
            //目录层级 001代表一级，001001代表两级
            param.put("tier", "001");
            //脚本所在的位置：D:\\TC\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TestLab\\file\\2\\components
            param.put("path", path);

            JSONObject result=new JSONObject();
            result.put("data",param);
            result.put("type","MR_addComment");

            oos.writeObject(result.toString());
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println(JSONObject.fromObject((String)isr.readObject()));



            oos.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 修改组件MR_updateComponent
     * @throws ClassNotFoundException
     */
    @Test
    public void test5() throws ClassNotFoundException {

        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 10088);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject param =new JSONObject();
        //获取路径
       // String path = servlet.getServletContext().getRealPath("/");
       // path = path.concat("/file/" + summary.getProjectID() + "/components");
        String path = "D:\\TC\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TestLab\\file\\2\\components";

        param.put("path", path);
        //组件名称
        param.put("name", "我是最新的组件");
        //版本信息
        param.put("version", "");
        //详细描述
        param.put("description", "我是最新的组件");
        //继承ID
        param.put("extendsComId", "0");
        //脚本名称（脚本的文件名称）
        param.put("scriptName", "A");
        //父节点ID
        param.put("parentId", "NaN");
        //运行类型，安卓 3  ios 4
        param.put("runId", "2");
        //存储的文件夹目录,查询原先的目录得来的
        param.put("dataName", "1496902453520");
        //当前脚本的ID
        param.put("id", "10");
        //原先的组件名称
        param.put("oldName", "3");
        //原先文件夹的脚本的名称
        param.put("deleteFile", "c");
        //获取用户名
        param.put("userName", "zhuf2");
        //获取当前项目ID
        param.put("projectId","2");
        JSONObject result=new JSONObject();
        result.put("data",param);
        result.put("type","MR_updateComponent");




        try {
            oos.writeObject(result.toString());
            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
            System.out.println(JSONObject.fromObject((String)isr.readObject()));
        } catch (IOException e) {
            e.printStackTrace();
        }
//            ObjectInputStream isr = new ObjectInputStream(s.getInputStream());
//            System.out.println(((ResultMessage)isr.readObject()).getData());


        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
