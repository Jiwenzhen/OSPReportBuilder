package com.efounder.report.parse.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.efounder.report.data.ItemSetting;
import com.efounder.report.parse.ConfigParseAbstract;

public class MyReportConfigParse extends ConfigParseAbstract {

	protected ItemSetting getPageHeaderSettings(Element root) {

		ItemSetting pageHeaderSetting=new ItemSetting();
		List<ItemSetting> rowSettings = new ArrayList<ItemSetting>();

		Element pageHeaderSettings = root.element("PageHeaderSettings");
		List<?> itemSettings = pageHeaderSettings.elements("ItemSetting");
		for (Object itemSetting : itemSettings) {
			Element rowSetting = (Element) itemSetting;
			if ("CaptionRowSetting".equals(rowSetting.attributeValue("type"))) {
				List<?> captionCellSettings = rowSetting.element("CaptionCellSettings").elements("ItemSetting");
				ItemSetting irowSetting=new ItemSetting();
				List<ItemSetting> cellSettings = new ArrayList<ItemSetting>();
				for (Object captionCellSetting : captionCellSettings) {
					Element cellSetting = (Element) captionCellSetting;
					cellSettings.add(parseCaptionCellSetting(cellSetting));

				}
				irowSetting.setChildrenList(cellSettings);
				rowSettings.add(irowSetting);
			}
		}
		pageHeaderSetting.setChildrenList(rowSettings);
		return pageHeaderSetting;
	}

	protected ItemSetting getPageFooterSettings(Element root) {
		ItemSetting pageFooterSetting=new ItemSetting();
		List<ItemSetting> footerSettings = new ArrayList<ItemSetting>();

		Element pageFooterSettings = root.element("TableFooterSettings");
		List<?> itemSettings = pageFooterSettings.elements("ItemSetting");
		for (Object itemSetting : itemSettings) {
			Element rowSetting = (Element) itemSetting;
			if ("CaptionRowSetting".equals(rowSetting.attributeValue("type"))) {
				List<?> captionCellSettings = rowSetting.element("CaptionCellSettings").elements("ItemSetting");
				ItemSetting footerSetting=new ItemSetting();
				List<ItemSetting> crowSetting = new ArrayList<ItemSetting>();
				for (Object captionCellSetting : captionCellSettings) {
					Element cellSetting = (Element) captionCellSetting;
					crowSetting.add(parseCaptionCellSetting(cellSetting));

				}
				footerSetting.setChildrenList(crowSetting);
				footerSettings.add(footerSetting);
			}
		}
		pageFooterSetting.setChildrenList(footerSettings);
		return pageFooterSetting;
	}

	protected List<ItemSetting> getTableColumnSettings(Element root) {
		List<ItemSetting> tableColumnSettings=new ArrayList<ItemSetting>();
		
		List<?> itemSettings = root.elements("ItemSetting");
		for(Object itemSetting:itemSettings){
			tableColumnSettings.add(parseTableColumnSetting((Element) itemSetting));
		}
		return tableColumnSettings;
	}

	protected List<ItemSetting> getTableHeaderSettings(Element root) {
		List<ItemSetting> tableRowSettings=new ArrayList<ItemSetting>();
		
		List<?> itemSettings = root.elements("ItemSetting");
		for (Object itemSetting : itemSettings) {
			Element rowSetting = (Element) itemSetting;
			if ("TableRowSetting".equals(rowSetting.attributeValue("type"))) {
				List<?> tableCellSettings = rowSetting.element("TableCellSettings").elements("ItemSetting");
				ItemSetting irowSetting=new ItemSetting();
				List<ItemSetting> crowSetting = new ArrayList<ItemSetting>();
				for (Object tableCellSetting : tableCellSettings) {
					Element cellSetting = (Element) tableCellSetting;
					crowSetting.add(parseTableCellSetting(cellSetting));
				}
				irowSetting.setChildrenList(crowSetting);
				tableRowSettings.add(irowSetting);
			}
		}
		return tableRowSettings;
	}

	public List<ItemSetting> getTableDetailSettings(Element root) {
		return null;
	}

	public List<ItemSetting> getTableFooterSettings(Element root) {
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

	private ItemSetting parseCaptionCellSetting(Element element) {
		if (!"CaptionCellSetting".equals(element.attributeValue("type"))) {
			return null;
		}
		ItemSetting cellSetting=new ItemSetting();
		String value = element.element("Value").getText();
		cellSetting.setValue(value);
		cellSetting.setType("CaptionCellSetting");
		List<?> childrens = element.element("Style").elements();
		for (Object children : childrens) {
			String key = ((Element) children).getName();
			String pvalue = ((Element) children).getText();
			cellSetting.addProperty(key, pvalue);
		}
		return cellSetting;
	}
	private ItemSetting parseTableCellSetting(Element element){
		if (!"TableCellSetting".equals(element.attributeValue("type"))) {
			return null;
		}
		ItemSetting tableCellSetting=new ItemSetting();
		String value = element.element("Value").getText();
		tableCellSetting.setValue(value);
		tableCellSetting.setType("TableCellSetting");
		List<?> childrens = element.element("Style").elements();
		for (Object children : childrens) {
			String key = ((Element) children).getName();
			String pvalue = ((Element) children).getText();
			tableCellSetting.addProperty(key, pvalue);
		}
		return tableCellSetting;
	}
	
	private ItemSetting parseTableColumnSetting(Element element){
		if (!"TableColumnSetting".equals(element.attributeValue("type"))) {
			return null;
		}
		ItemSetting tableColumnSetting=new ItemSetting();
		tableColumnSetting.setType("TableColumnSetting");
		List<?> childrens = element.elements();
		for (Object children : childrens) {
			String key = ((Element) children).getName();
			String pvalue = ((Element) children).getText();
			tableColumnSetting.addProperty(key, pvalue);
		}
		return tableColumnSetting;
	}

	@Override
	protected List<ItemSetting> getTableGroupHeaderSetting(Element root) {
		return null;
	}

	@Override
	protected List<ItemSetting> getTableGroupFooterSetting(Element root) {
		return null;
	}
}
