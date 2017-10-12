package com.efounder.report.linker;

import com.efounder.report.build.IBuilder;
import com.efounder.report.compile.ICompile;
import com.efounder.report.parse.ConfigParseAbstract;
import com.efounder.report.parse.ScriptParse;

/**
* 资源连接器
* @ClassName: ILinker  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:17:37  
*
 */
public abstract class LinkerAbstract {

	public LinkerAbstract() {
	}
	public abstract ConfigParseAbstract getConfigParse();
	public abstract void registExpression();
	public abstract ScriptParse getScriptParse();
	public abstract ICompile getCompile();
	public abstract IBuilder getBuilder();
}
