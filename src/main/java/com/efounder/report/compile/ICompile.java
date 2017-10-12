package com.efounder.report.compile;

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
public interface ICompile {

	/**
	 * 根据配置文件和数据编译成中间文件
	 * @param config 配置文件类
	 * @param data 数据
	 * @return
	 */
	public String compile(ReportSetting config,Object data);
	
	/**
	 * 设置脚本解析器
	 * @param scriptParse
	 */
	public void setScriptParse(ScriptParse scriptParse);
	
}
