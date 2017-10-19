package com.efounder.report.config;

import java.io.File;

import com.efounder.report.data.ReportSetting;
import com.efounder.report.parse.FileUtils;
import com.efounder.report.parse.config.MyReportConfigParse;

public class MyReportConfigParseTest {

	public static void main(String[] args) {
		 String xml=FileUtils.readFile(new File("E:\\temp\\ReportStyle.xml"));
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
}
