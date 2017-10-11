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

	public void buildPDF(File file,String html);
}
