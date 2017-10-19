package com.efounder.report.linker;

import com.efounder.report.build.IBuilder;
import com.efounder.report.compile.CompileAbstract;
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
		registExpression();
	}
	/**
	 * 设置配置文件解析器实现类
	 * @return
	 */
	public abstract ConfigParseAbstract getConfigParse();
	/**
	 * 注册所有表达式
	 */
	public abstract void registExpression();
	
	/**
	 * 设置脚本解析器
	 * @return
	 */
	public abstract ScriptParse getScriptParse();
	/**
	 * 设置编译器
	 * @return
	 */
	public abstract CompileAbstract getCompile();
	
	/**
	 * 设置构建器
	 * @return
	 */
	public abstract IBuilder getBuilder();
}
