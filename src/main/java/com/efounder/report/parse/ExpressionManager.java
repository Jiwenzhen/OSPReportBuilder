package com.efounder.report.parse;

import java.util.HashMap;
import java.util.Map;

/**
* 表达式管理类
* @ClassName: ExpressionManager  
* @Description: TODO
* @author GJX  
* @date 2017年9月29日 下午6:23:07  
*
 */
public class ExpressionManager {

	private static Map<String, IExpression> expressions;
	private static StringBuffer jscode;
	
	public ExpressionManager() {
		expressions=new HashMap<String, IExpression>();
		jscode=new StringBuffer();
	}
	
	public void registerExpression(String name,IExpression parse){
		expressions.put(name, parse);
	}
	public void registExpression(String code){
		jscode.append(code);
	}
	public Map<String, IExpression> getExpressions(){
		return expressions;
	}
	public IExpression getExpression(String key){
		return expressions.get(key);
	}
	public String getJSCode(){
		return jscode.toString();
	}
	
}
