package com.efounder.report.parse.expression;


import com.efounder.report.parse.IExpression;

/**
* javascript表达式类
* @ClassName: JavaScriptExpressionAbstract  
* @Description: TODO
* @author GJX  
* @date 2017年9月29日 下午6:22:37  
*
 */
public class JavaScriptExpression implements IExpression{

	private static String javascriptCode;
	
	@Override
	public String getCode() {
		return javascriptCode;
	}
	
	public static void addCode(String code){
		javascriptCode+=code;
	}
	
}
