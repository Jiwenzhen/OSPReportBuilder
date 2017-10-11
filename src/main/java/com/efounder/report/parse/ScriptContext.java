package com.efounder.report.parse;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptContext {

	private ExpressionManager expressionManager;
	private ScriptEngine engine;
	
	public static ScriptContext getInstance(){
		ScriptContext scriptContext=new ScriptContext();
		scriptContext.initContext();
		return scriptContext;
	}
	
	public ScriptContext() {
		expressionManager=new ExpressionManager();
		ScriptEngineManager factory = new ScriptEngineManager();
   	 	engine = factory.getEngineByName("JavaScript");
	}
	public void initContext(){
		registExpression(expressionManager.getJSCode());
		for(String key:expressionManager.getExpressions().keySet()){
			registExpression(key, expressionManager.getExpression(key));
		}
	}
	protected void registExpression(String funName,IExpression expression){
		engine.put(funName+"OBJ", expression);
		StringBuffer code=new StringBuffer();
		code.append("function ").append(funName).append("(");
		StringBuffer params=new StringBuffer();
		for(String param:expression.getParamList()){
			params.append(param).append(",");
		}
		code.append(params.substring(0,params.length()-1));
		code.append("){").append(funName).append("OBJ").append(".call(");
		code.append(params.substring(0,params.length()-1)).append(");}");
		try {
			engine.eval(code.toString());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	protected void registExpression(String code){
		try {
			engine.eval(code);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	public ScriptEngine getScriptEngine(){
		return engine;
	}
}
