package com.efounder.report.compile;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.efounder.report.data.ReportSetting;
import com.efounder.report.parse.ScriptParse;

/**
* 报表编译器	
* @ClassName: ICompile  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:14:08  
*
 */
public abstract class CompileAbstract {

	protected ScriptParse scriptParse;
	protected ReportSetting reportConfig;
	protected Object reportData;
	protected Document dom=DocumentHelper.createDocument();
	
	/**
	 * 根据配置文件和数据编译成中间文件
	 * @param config 配置文件类
	 * @param data 数据
	 * @return
	 */
	public String compile(ReportSetting config,Object data){
		dom.setRootElement(DocumentHelper.createElement("html"));
		this.reportConfig=config;
		this.reportData=data;
		buildPageHeader(data);
		buildpageFooter(data);
		buildTable(data);
		return dom.toString();
	}
	
	/**
	 * 设置脚本解析器
	 * @param scriptParse
	 */
	public void setScriptParse(ScriptParse scriptParse){
		this.scriptParse=scriptParse;
	}
	
	protected abstract void buildPageHeader(Object data);
	protected abstract void buildpageFooter(Object data);
	
	protected abstract void buildTable(Object data);
	
	
}
