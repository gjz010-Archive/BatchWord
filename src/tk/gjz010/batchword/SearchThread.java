/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.gjz010.batchword;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class SearchThread extends Thread{
    private int id;
    private String word;
    public SearchThread(int id,String word){
        this.id=id;
        this.word=word;
    }
    public void run(){
        System.out.println("Start Working!ID:"+Integer.toString(id)+" Word:"+word);
        int i=1;
        String html="";
        while(i<=3){
        html=getText();
        if(!(html.equals(""))) break;
        i=i+1;
        System.out.println(word+" Http重连中 已重连次数"+Integer.toString(i));
        }
        if(html.equals("")) {MainFrame.opt.setWord(id,"网络错误","网络错误",false);return;};
        if(html.contains("查无此词语")|html.contains("请输入汉字")) {MainFrame.opt.setWord(id,"查无此词或不是汉字","查无此词或不是汉字",false);return;};
        MainFrame.opt.setWord(id,parsePinyin(html),parseDesc(html),true);
    }
    private String getText(){ 
        HttpURLConnection conn=null;
        try {
        //API:http://www.zdic.net/search/?q=待查词语&c=2
        URL fu=new URL("http://www.zdic.net/search/?q="+URLEncoder.encode(word,"utf-8")+"&c=2");
        conn = (HttpURLConnection) fu.openConnection();
       conn.setConnectTimeout(5000); //设置连接超时为5秒
       conn.setRequestMethod("GET"); //设定请求方式
       conn.connect(); //建立到远程对象的实际连接
       //返回打开连接读取的输入流
       DataInputStream dis = new DataInputStream(conn.getInputStream());  
      //判断是否正常响应数据 
        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
           System.out.println("网络错误异常！!!!");
           return "";
       }
        //解析
        char c;
        StringBuilder str=new StringBuilder("");
        BufferedReader reader = new BufferedReader(new InputStreamReader(dis,"utf-8"));
        String line = null;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
        return str.toString();
        //解析结束
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
    if (conn != null) {
     conn.disconnect(); //中断连接
    }
    }
    return "";
    }
    private String parsePinyin(String text){
        String pinyin=text.substring(text.indexOf("<span class=\"dicpy\">")+20,text.indexOf("</span></p>"));
        return pinyin;
    }
    private String parseDesc(String text){
        if(text.contains("[成语解释]")){
        int i=text.indexOf("<b>解释</b>：")+new String("<b>解释</b>：").length();
        return text.substring(i,text.indexOf("<br/>",i));
        }else{
            //return "不是成语！";
            List<String> list=new ArrayList<String>();
            //list.add("test");
            Pattern pattern = Pattern.compile("\\[[\\x00-\\xff]*?(\\])");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
              // System.out.print("Start index: " + matcher.start());
              //System.out.print(" End index: " + matcher.end());
              //System.out.println(" Found: " + matcher.group());
                int e=text.indexOf("</p>",matcher.end());
                list.add(text.substring(matcher.start()+matcher.group().length(),e));
            }
            int i=1;
            StringBuilder sb=new StringBuilder("");
            for(String m:list){
                sb.append(Integer.toString(i));
                sb.append(".");
                sb.append(m);
                i++;
            }
            return sb.toString();
        }
        }
}
