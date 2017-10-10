package com.efounder.report.parse;

import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptParse extends ScriptParseAbstract {

	private ScriptEngine engine;
   
    public JavaScriptParse() {
    	 ScriptEngineManager factory = new ScriptEngineManager();
    	 engine = factory.getEngineByName("JavaScript");
    	 StringBuffer functionsCode=new StringBuffer();
    	 for(String key:getExpressions().keySet()){
    		 functionsCode.append(getExpressions().get(key).getCode());
    	 }
    	 try {
			engine.eval(functionsCode.toString());
			Object result = null;
			engine.put("result", result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
    
	@Override
	public Object parseScript(String script, Map<String, Object> param) {
		try {
			StringBuffer code=new StringBuffer();
			code.append("result=").append(script);
			engine.eval(code.toString());
			return engine.get("result");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}

}
