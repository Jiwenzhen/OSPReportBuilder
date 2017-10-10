package com.efounder.report.parse;

import java.util.Map;

import com.efounder.report.parse.expression.ExpressionManager;


public abstract class ScriptParseAbstract {

	private Map<String, IExpression> expressions;
	public ScriptParseAbstract() {
		expressions=new ExpressionManager().getExpressions();
	}
	public Map<String, IExpression> getExpressions(){
		return expressions;
	}
	public abstract Object parseScript(String script,Map<String, Object>param);
}
