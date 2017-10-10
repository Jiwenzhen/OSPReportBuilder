package com.efounder.report.parse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.efounder.report.parse.expression.ExpressionManager;
import com.efounder.report.parse.expression.SubExpression;

public class ExpressionTest {

	public static void main(String[] args) {
		/*ExpressionManager expressionManager=new ExpressionManager();
		//expressionManager.registerExpression("sub", parse);
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		try {
			String result=(String) engine.eval("function a=new com.efounder.report.parse.expression.SubExpression().getName");
			System.out.println(result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}*/
		SubExpression test=new SubExpression();
		System.out.println(test.getCode());
	}

}
