package com.efounder.report.render;

import java.io.File;

/**
* PDF渲染器
* @ClassName: IRender  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:20:50  
*
 */
public interface IRender {

	public void render(File file,String content);
}
