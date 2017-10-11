package com.efounder.report.parse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.efounder.report.parse.expression.SubExpression;

public class ExpressionTest {

	public static void main(String[] args) {
		ExpressionManager expressionManager=new ExpressionManager();
		//expressionManager.registerExpression("sub", parse);
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		try {
			String result=(String) engine.eval("var a='test';");
			System.out.println(engine.get("a"));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
