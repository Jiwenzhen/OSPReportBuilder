package com.efounder.report.build;

import java.io.File;

/**
* PDF构建器 
* @ClassName: IBuilder  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:13:50  
*
 */
public interface IBuilder {

	/**
	 * 根据HTML构建PDF文件
	 * @param file 目标文件
	 * @param html html源文件
	 */
	public void buildPDF(File file,String html);
}
