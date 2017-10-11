package com.efounder.report.parse.expression;

import java.util.Arrays;
import java.util.List;

import com.efounder.report.parse.IExpression;

public class SubExpression implements IExpression {

	@Override
	public Object call(String... args) {
		return null;
	}

	@Override
	public List<String> getParamList() {
		String[] params={"1","2"};
		return Arrays.asList(params);
	}

}
