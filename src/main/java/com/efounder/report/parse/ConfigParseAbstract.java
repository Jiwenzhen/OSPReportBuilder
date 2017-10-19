package com.efounder.report.parse;

import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.efounder.report.data.ItemSetting;
import com.efounder.report.data.ReportSetting;

/**
* 配置文件解析器虚类
* @ClassName: ConfigParseAbstract  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:19:43  
*
 */
public abstract class ConfigParseAbstract {

	public ReportSetting parse(String config) throws Exception {
		Document document;
		ReportSetting reportSetting=new ReportSetting();
		try {
			 document = DocumentHelper.parseText(config);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new Exception("文档解析错误");
		}
		Element root = document.getRootElement(); 
		reportSetting.setPropertys(getPropertys(root));
		
		reportSetting.setPageHeaderSetting(getPageHeaderSettings(root));
		reportSetting.setPageFooterSetting(getPageFooterSettings(root));
		
		reportSetting.setTableColumnSetting(getTableColumnSettings(root));
		reportSetting.setTableDetailSetting(getTableDetailSettings(root));
		reportSetting.setTableHeaderSetting(getTableHeaderSettings(root));
		reportSetting.setTableFooterSetting(getTableFooterSettings(root));
		
		reportSetting.setTableGroupHeaderSetting(getTableGroupHeaderSetting(root));
		reportSetting.setTableGroupFooterSetting(getTableGroupFooterSetting(root));
		
		return reportSetting;
	}
	protected abstract ItemSetting getPageHeaderSettings(Element root);
	
	protected abstract ItemSetting getPageFooterSettings(Element root);
	
	protected abstract ItemSetting getTableColumnSettings(Element root);
	
	protected abstract ItemSetting getTableHeaderSettings(Element root);
	
	protected abstract ItemSetting getTableDetailSettings(Element root);
	
	protected abstract ItemSetting getTableFooterSettings(Element root);
	
	protected abstract ItemSetting getTableGroupHeaderSetting(Element root);
	
	protected abstract ItemSetting getTableGroupFooterSetting(Element root);
	
	protected abstract Map<String, String> getPropertys(Element root);
	
	
}
