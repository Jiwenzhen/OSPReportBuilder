package com.efounder.report.linker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.efounder.report.build.IBuilder;
import com.efounder.report.build.ItextpdfBuilder;
import com.efounder.report.compile.ICompile;
import com.efounder.report.parse.ConfigParseAbstract;
import com.efounder.report.parse.ExpressionManager;
import com.efounder.report.parse.ScriptParse;
import com.efounder.report.parse.config.MyReportConfigParse;
import com.efounder.report.parse.expression.SubExpression;

/**
 * 部件连接器
* @ClassName: PartLinker  
* @Description: 连接各部件类，方便获取各部件实现类
* @author GJX  
* @date 2017年10月12日 上午9:15:13  
*
 */
public class PartLinker implements ILinker {

	@Override
	public ConfigParseAbstract getConfigParse() {
		return new MyReportConfigParse();
	}

	@Override
	public void registExpression() {
		ExpressionManager expressionManager=new ExpressionManager();
		expressionManager.registerExpression("sub", new SubExpression());
		
		String jspath = "/com/efounder/report/parse/expression/expressions.js";
		InputStream in = this.getClass().getResourceAsStream(jspath);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int i = -1;
		try {
			while ((i = in.read()) != -1) {
				out.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		expressionManager.registExpression(out.toString());
	}

	@Override
	public ScriptParse getScriptParse() {
		return new ScriptParse();
	}

	@Override
	public ICompile getCompile() {
		return null;
	}

	@Override
	public IBuilder getBuilder() {
		return new ItextpdfBuilder();
	}

}
