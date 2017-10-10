package com.efounder.report.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.efounder.report.data.ReportSetting;
import com.efounder.report.parse.config.MyReportConfigParse;

public class MyReportConfigParseTest {

	public static void main(String[] args) {
		 File file = new File("C:/Users/GJX/Desktop/SubReportRowStyle1.xml");
		 String xml=txt2String(file);
		 MyReportConfigParse parse=new MyReportConfigParse();
		 try {
			 ReportSetting reportSetting=parse.parse(xml);
			 if(reportSetting!=null){
				 System.out.println("it's ok");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
