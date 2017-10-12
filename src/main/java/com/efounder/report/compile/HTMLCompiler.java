package com.efounder.report.compile;

import com.efounder.report.data.ReportSetting;
import com.efounder.report.parse.ScriptParse;

public class HTMLCompiler implements ICompile {

	private ScriptParse scriptParse;
	@Override
	public String compile(ReportSetting config, Object data) {
		return null;
	}

	@Override
	public void setScriptParse(ScriptParse scriptParse) {
		this.scriptParse=scriptParse;
	}

}
