package com.efounder.report.parse;

import com.efounder.report.linker.PartLinker;

public class ExpressionTest {

	private PartLinker linker=new PartLinker();
	
	public void expressionTest(){
		ScriptParse scriptParse=linker.getScriptParse();
		System.out.println("sum(1,2)="+scriptParse.parseScript("sum(1,2)", null));
	}

	public void scriptTest(){
		ScriptParse scriptParse=linker.getScriptParse();
		System.out.println(scriptParse.parseScript("test()", null));
	}
	public void registFunctionTest(){
		ExpressionManager expressionManager=new ExpressionManager();
		expressionManager.registExpression("function test(){return 'function regist success';}");
	}
	public static void main(String[] args) {
		ExpressionTest test=new ExpressionTest();
		test.registFunctionTest();
		test.expressionTest();
		test.scriptTest();
	}
}
