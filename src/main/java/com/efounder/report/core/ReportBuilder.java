package com.efounder.report.core;

import java.io.File;
import java.util.UUID;

import com.efounder.report.data.ReportSetting;
import com.efounder.report.linker.LinkerAbstract;
import com.efounder.report.parse.FileUtils;

/**
* 报表主类
* @ClassName: ReportBuilder  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:14:33  
*
 */
public class ReportBuilder {

	protected LinkerAbstract linker;
	protected String tempPath;
	/**
	 * 设置连接器
	 * @param linker
	 */
	public void setLinker(LinkerAbstract linker){
		this.linker=linker;
	}
	/**
	 * 设置缓存目录
	 * @param path
	 */
	public void setTempPath(String path){
		this.tempPath=path;
	}
	/**
	 * 构建报表PDF
	 * @param configPath 配置文件路径
	 * @param data 数据
	 * @return 生成报表文件路径
	 */
	public String buildReportPDF(String configPath,Object data){
		String configContent=FileUtils.readFile(new File(configPath));
		String targetFilePath = null;
		try {
			ReportSetting reportSetting=linker.getConfigParse().parse(configContent);
			String targetCode =linker.getCompile().compile(reportSetting, data);
			targetFilePath=tempPath+UUID.randomUUID();
			linker.getBuilder().buildPDF(new File(targetFilePath), targetCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetFilePath;
	}

}
