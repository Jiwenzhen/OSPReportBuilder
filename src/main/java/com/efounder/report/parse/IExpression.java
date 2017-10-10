package com.efounder.report.parse;

import java.util.List;

/**
* 表达式接口
* @ClassName: IExpression  
* @Description: 表达式接口
* @author GJX  
* @date 2017年9月29日 下午6:21:13  
*
 */
public interface IExpression {

	public void call(String ... args);
	public List<String> getParamList();
}
