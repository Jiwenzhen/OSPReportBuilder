package com.efounder.report.data;

import java.util.List;


/**
 * 报表配置类
* @ClassName: ReportSetting  
* @Description: TODO
* @author GJX  
* @date 2017年9月29日 上午9:28:29  
*
 */
public class ReportSetting extends ItemSetting{

	private ItemSetting pageHeaderSetting;//报表头
	private ItemSetting pageFooterSetting;//报表尾
	
	private List<ItemSetting> tableHeaderSetting;//表格头
	private List<ItemSetting> tableColumnSetting;//表格列配置
	private List<ItemSetting> tableDetailSetting;//表格主体
	private List<ItemSetting> tableFooterSetting;//表格尾
	
	private List<ItemSetting> tableGroupHeaderSetting;//分组头
	private List<ItemSetting> tableGroupFooterSetting;//分组尾
	
	public ItemSetting getPageHeaderSetting() {
		return pageHeaderSetting;
	}
	public void setPageHeaderSetting(ItemSetting pageHeaderSetting) {
		this.pageHeaderSetting = pageHeaderSetting;
	}
	public ItemSetting getPageFooterSetting() {
		return pageFooterSetting;
	}
	public void setPageFooterSetting(ItemSetting pageFooterSetting) {
		this.pageFooterSetting = pageFooterSetting;
	}
	public List<ItemSetting> getTableHeaderSetting() {
		return tableHeaderSetting;
	}
	public void setTableHeaderSetting(List<ItemSetting> tableHeaderSetting) {
		this.tableHeaderSetting = tableHeaderSetting;
	}
	public List<ItemSetting> getTableColumnSetting() {
		return tableColumnSetting;
	}
	public void setTableColumnSetting(List<ItemSetting> tableColumnSetting) {
		this.tableColumnSetting = tableColumnSetting;
	}
	public List<ItemSetting> getTableDetailSetting() {
		return tableDetailSetting;
	}
	public void setTableDetailSetting(List<ItemSetting> tableDetailSetting) {
		this.tableDetailSetting = tableDetailSetting;
	}
	public List<ItemSetting> getTableFooterSetting() {
		return tableFooterSetting;
	}
	public void setTableFooterSetting(List<ItemSetting> tableFooterSetting) {
		this.tableFooterSetting = tableFooterSetting;
	}
	public List<ItemSetting> getTableGroupHeaderSetting() {
		return tableGroupHeaderSetting;
	}
	public void setTableGroupHeaderSetting(List<ItemSetting> tableGroupHeaderSetting) {
		this.tableGroupHeaderSetting = tableGroupHeaderSetting;
	}
	public List<ItemSetting> getTableGroupFooterSetting() {
		return tableGroupFooterSetting;
	}
	public void setTableGroupFooterSetting(List<ItemSetting> tableGroupFooterSetting) {
		this.tableGroupFooterSetting = tableGroupFooterSetting;
	}
	
	
}
