package com.efounder.report.parse.expression;

import java.util.HashMap;
import java.util.Map;

import com.efounder.report.parse.IExpression;

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
	
	public ExpressionManager() {
		expressions=new HashMap<String, IExpression>();
	}
	
	public void registerExpression(String name,IExpression parse){
		expressions.put(name, parse);
	}
	
	public Map<String, IExpression> getExpressions(){
		return expressions;
	}
	public IExpression getExpression(String key){
		return expressions.get(key);
	}
}
