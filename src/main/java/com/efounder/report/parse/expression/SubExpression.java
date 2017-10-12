package com.efounder.report.parse.expression;

import java.util.Arrays;
import java.util.List;

import com.efounder.report.parse.IExpression;

/**
* 求差表达式
* @ClassName: SubExpression  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:19:28  
*
 */
public class SubExpression implements IExpression {

	@Override
	public Object call(String... args) {
		return null;
	}

	@Override
	public List<String> getParamList() {
		String[] params={"a","b"};
		return Arrays.asList(params);
	}

}
