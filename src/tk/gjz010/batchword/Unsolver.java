/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.gjz010.batchword;

//import java.io.FileOutputStream;
//import org.apache.commons.codec.binary.Hex;
//import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
//import org.apache.commons.codec.binary.StringUtils;
/**
 *
 * @author Administrator
 */
public class Unsolver {
    public static void main(String args[])throws Exception{
        Map<String,String> mps=getstrs();
        //Properties props=new Properties();
        
        //System.out.println("{");
for(Map.Entry<String, String> entry: mps.entrySet()) {
    System.out.println(entry.getKey()+" "+entry.getValue());
// System.out.println("\""+entry.getKey() + "\":\"" + entry.getValue() + "\",");
  }
//props.storeToXML(new FileOutputStream("src/xiandai.xml"),"xiandai","utf-8");
//System.out.println("}");
    }/*Outdated Code
    public static Map<String,String> getstrsFromDB() throws Exception{
        //byte[] bts=Hex.decodeHex("E998BFE9BCBBE59CB0E78BB1".toCharArray());
        //System.out.println(new String(bts, "UTF8"));
        Class.forName("org.sqlite.JDBC");
        Connection conn=null;
        conn = DriverManager.getConnection("jdbc:sqlite::resource:tk/gjz010/batchword/xiandai.db"); 
        Statement st=conn.createStatement();
        st.setQueryTimeout(30);
        ResultSet rs=st.executeQuery("select * from phrase");
        Map<String,String>m=new HashMap<>();
        while(rs.next()){
            //System.out.println("phr:"+hex2str(rs.getString("_phrase")));
            m.put(hex2str(rs.getString("_phrase")),rs.getString("_content"));
        }
        return m;
    }*/
    public static Map<String,String> getstrs() throws Exception{
        Map<String,String> mps=new HashMap<>();
        Properties props=new Properties();
        props.loadFromXML(Thread.currentThread().getContextClassLoader().getResourceAsStream("tk/gjz010/batchword/xiandai.xml"));
for(Map.Entry<Object, Object> entry: props.entrySet()) {
    mps.put((String)entry.getKey(), (String)entry.getValue());
}
return mps;
    }

}