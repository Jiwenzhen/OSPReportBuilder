package com.efounder.report.core;

import com.efounder.report.linker.ILinker;

/**
* 报表主类
* @ClassName: ReportBuilder  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:14:33  
*
 */
public class ReportBuilder {

	private ILinker linker;
	public void setLinker(ILinker linker){
		this.linker=linker;
	}
}
