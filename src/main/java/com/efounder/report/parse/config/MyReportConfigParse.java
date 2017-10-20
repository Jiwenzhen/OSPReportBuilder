package com.efounder.report.parse.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.efounder.report.data.ItemSetting;
import com.efounder.report.parse.ConfigParseAbstract;

/**
* MyReport配置文件解析器
* @ClassName: MyReportConfigParse  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:18:38  
*
 */
public class MyReportConfigParse extends ConfigParseAbstract {

	@Override
	protected ItemSetting getPageHeaderSettings(Element root) {
		Element pageHeaderSettings = root.element("PageHeaderSettings");
		if(pageHeaderSettings==null){
			return null;
		}
		List<?> rowsSetting=pageHeaderSettings.elements("ItemSetting");
		ItemSetting pageHeaderSetting=new ItemSetting();
		for(Object rowSetting:rowsSetting){
			ItemSetting row=parseRowSetting((Element)rowSetting);
			pageHeaderSetting.addChildren(row);
		}
		return pageHeaderSetting;
	}

	@Override
	protected ItemSetting getPageFooterSettings(Element root) {
		Element pageFooterSettings = root.element("PageFooterSettings");
		if(pageFooterSettings==null){
			return null;
		}
		List<?> rowsSetting=pageFooterSettings.elements("ItemSetting");
		ItemSetting pageHeaderSetting=new ItemSetting();
		for(Object rowSetting:rowsSetting){
			ItemSetting row=parseRowSetting((Element)rowSetting);
			pageHeaderSetting.addChildren(row);
		}
		return pageHeaderSetting;
	}

	@Override
	protected ItemSetting getTableColumnSettings(Element root) {
		Element tableColumn = root.element("TableColumnSettings");
		if(tableColumn==null){
			return null;
		}
		List<?> items=tableColumn.elements("ItemSetting");
		ItemSetting tableColumnSetting=new ItemSetting();
		for(Object item:items){
			tableColumnSetting.addChildren(parseItemSetting((Element)item));
		}
		return tableColumnSetting;
	}

	@Override
	protected ItemSetting getTableHeaderSettings(Element root) {
		Element tableHeader = root.element("TableHeaderSettings");
		if(tableHeader==null){
			return null;
		}
		List<?> rowsSetting=tableHeader.elements("ItemSetting");
		ItemSetting tableHeaderSetting=new ItemSetting();
		for(Object rowSetting:rowsSetting){
			ItemSetting row=parseRowSetting((Element)rowSetting);
			tableHeaderSetting.addChildren(row);
		}
		return tableHeaderSetting;
	}

	@Override
	public ItemSetting getTableDetailSettings(Element root) {
		Element tableDetail = root.element("TableDetailSettings");
		if(tableDetail==null){
			return null;
		}
		List<?> rowsSetting=tableDetail.elements("ItemSetting");
		ItemSetting tableDetailSetting=new ItemSetting();
		for(Object rowSetting:rowsSetting){
			ItemSetting row=parseRowSetting((Element)rowSetting);
			tableDetailSetting.addChildren(row);
		}
		return tableDetailSetting;
	}

	@Override
	public ItemSetting getTableFooterSettings(Element root) {
		Element tableFooter = root.element("TableFooterSettings");
		if(tableFooter==null){
			return null;
		}
		List<?> rowsSetting=tableFooter.elements("ItemSetting");
		ItemSetting tableFooterSetting=new ItemSetting();
		for(Object rowSetting:rowsSetting){
			ItemSetting row=parseRowSetting((Element)rowSetting);
			tableFooterSetting.addChildren(row);
		}
		return tableFooterSetting;
	}
	
	@Override
	protected ItemSetting getTableGroupHeaderSetting(Element root) {
		return null;
	}

	@Override
	protected ItemSetting getTableGroupFooterSetting(Element root) {
		return null;
	}

	protected Map<String, String> getPropertys(Element root) {
		List<?> childrens = root.elements();
		Map<String, String> propertys = new HashMap<String, String>();
		for (Object children : childrens) {
			Element element = (Element) children;
			if (element.isTextOnly()) {
				String key = element.getName();
				String value = element.getText();
				propertys.put(key, value);
			}
		}
		return propertys;
	}

	protected ItemSetting parseRowSetting(Element element) {
		if(element==null){
			return null;
		}
		//保证parseRowSetting方法的复用性。add by jiwenzhen at 2017年10月20日9:06:12
		List<?> tableRow;
        if(!element.elements("CaptionCellSettings").isEmpty()){
        	tableRow = element.elements("CaptionCellSettings");
        }else if(!element.elements("TableCellSettings").isEmpty()){
        	tableRow = element.elements("TableCellSettings");
        }else{
        	return null;
        }
		Element cellListRoot=(Element) tableRow.get(0);
		List<?> itemList =cellListRoot.elements("ItemSetting");
		List<ItemSetting> list=new ArrayList<ItemSetting>();
		for(Object item:itemList){
			list.add(parseItemSetting((Element)item));
		}
		ItemSetting rowSetting=new ItemSetting();
		rowSetting.setChildrenList(list);
		return rowSetting;
	}
	
	protected ItemSetting parseItemSetting(Element element){
		ItemSetting itemSetting=new ItemSetting();
		String value = null;
		String type = null;
		if(element.element("Value") != null){
			value= element.element("Value").getText();
		}
		if(element.element("Type") != null){
			type = element.element("Type").getText();
		}
		
		itemSetting.setValue(value);
		itemSetting.setType(type);
		if(element.element("Style")==null){
			return itemSetting;
		}
		List<?> childrens = element.element("Style").elements();
		for (Object children : childrens) {
			String key = ((Element) children).getName();
			String pvalue = ((Element) children).getText();
			itemSetting.addProperty(key, pvalue);
		}
		return itemSetting;
	}
	
}
