package com.efounder.report.parse;

import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptException;


/**
* 脚本解析器
* @ClassName: ScriptParse  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:20:36  
*
 */
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
		Object result=null;
		if(param!=null){
			for(String name:param.keySet()){
				paramCode.append("var ").append(name).append("=");
				paramCode.append(param.get(name)).append(";");
			}
		}
		
		code.append("(function(){").append(paramCode.toString());
		code.append("return ").append(script).append(";})();");
		try {
			result=engine.eval(code.toString());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}
}
