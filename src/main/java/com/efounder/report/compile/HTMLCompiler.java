package com.efounder.report.compile;

import java.util.Map;

import org.dom4j.Element;

import com.efounder.report.data.ItemSetting;
import com.efounder.report.parse.ScriptParse;

public class HTMLCompiler extends CompileAbstract {


	@Override
	public void setScriptParse(ScriptParse scriptParse) {
		this.scriptParse=scriptParse;
	}
	@Override
	protected void buildPageHeader(Object data){
		ItemSetting pageHeadSetting=reportConfig.getPageHeaderSetting();
		Element pageHeadElement=dom.addElement("table");
		for(ItemSetting rowItem:pageHeadSetting.getChildrenList()){
			Element rowElement=pageHeadElement.addElement("tr");
			if(rowItem.getValue()!=null){
				rowElement.setText(rowItem.getValue());
			}
			for(ItemSetting columItem:rowItem.getChildrenList()){
				Element colElement=rowElement.addElement("td");
				colElement.setText(columItem.getValue());
				setStyle(colElement,columItem.getPropertys());
			}
		}
	}
	protected void setStyle(Element element,Map<String, String> propertys){
		
		for(String key:propertys.keySet()){
			if("Width".equals(key)){
				element.addAttribute("width",propertys.get(key));
			}
			if("TextAlign".equals(key)){
				element.addAttribute("align",propertys.get(key));
			}
		}
	}

	@Override
	protected void buildpageFooter(Object data) {
		ItemSetting pageFooterSetting=reportConfig.getPageHeaderSetting();
		Element pageHeadElement=dom.addElement("table");
		for(ItemSetting rowItem:pageFooterSetting.getChildrenList()){
			Element rowElement=pageHeadElement.addElement("tr");
			rowElement.setText(rowItem.getValue());
			for(ItemSetting columItem:rowItem.getChildrenList()){
				Element colElement=rowElement.addElement("td");
				colElement.setText(columItem.getValue());
				setStyle(colElement,columItem.getPropertys());
			}
		}
	}

	@Override
	protected void buildTable(Object data) {
		
	}
	
	

}
