package com.efounder.report;

import java.io.File;

import com.efounder.report.core.ReportBuilder;
import com.efounder.report.data.ReportSetting;
import com.efounder.report.linker.PartLinker;
import com.efounder.report.parse.ConfigParseAbstract;
import com.efounder.report.parse.FileUtils;

public class ReportBuilderTest extends ReportBuilder {

	public String Compile(String configPath,Object data){
		String configContent=FileUtils.readFile(new File(configPath));
		String targetCode=null;
		try {
			ConfigParseAbstract configParse=linker.getConfigParse();
			ReportSetting reportSetting=configParse.parse(configContent);
			targetCode =linker.getCompile().compile(reportSetting, data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetCode;
	}
	public static void main(String[] args) {

		ReportBuilderTest test=new ReportBuilderTest();
		test.setLinker(new PartLinker());
		test.setTempPath("");
		String html=test.Compile("E:\\temp\\ReportStyle.xml", null);
		System.out.println(html);
	}

}
