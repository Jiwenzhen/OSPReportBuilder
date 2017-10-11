package com.efounder.report.linker;

import com.efounder.report.build.IBuilder;
import com.efounder.report.compile.ICompile;
import com.efounder.report.parse.ConfigParseAbstract;
import com.efounder.report.parse.ScriptParse;

public interface ILinker {

	public ConfigParseAbstract getConfigParse();
	public void registExpression();
	public ScriptParse getScriptParse();
	public ICompile getCompile();
	public IBuilder getBuilder();
}
