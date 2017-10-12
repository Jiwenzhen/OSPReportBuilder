package com.efounder.report.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 文件工具类
* @ClassName: FileUtils  
* @Description: 临时使用，后期可以使用已有
* @author GJX  
* @date 2017年10月12日 下午5:48:07  
*
 */
public class FileUtils {

	/**
	 * 获取文件文本
	 * @param file
	 * @return
	 */
	public static String readFile(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				result.append(System.lineSeparator() + s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
