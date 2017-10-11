package com.efounder.report.parse;

import java.util.Map;

import javax.script.ScriptEngine;



public class ScriptParse {

	private ScriptContext scriptContext;
	private ScriptEngine engine;
	
	public ScriptParse() {
		scriptContext=ScriptContext.getInstance();
		engine=scriptContext.getScriptEngine();
	}
	
	
	public  Object parseScript(String script,Map<String, Object>param){
		StringBuffer code=new StringBuffer();
		StringBuffer paramCode=new StringBuffer();
		for(String name:param.keySet()){
			paramCode.append("var ").append(name).append("=");
			paramCode.append(param.get(name)).append(";");
		}
		code.append("function(){").append(paramCode.toString());
		code.append("return ").append(script).append(";}();");
		return param;
	}
}
