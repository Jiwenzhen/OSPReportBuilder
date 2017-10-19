package com.efounder.report.data;



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
	
	private ItemSetting tableHeaderSetting;//表格头
	private ItemSetting tableColumnSetting;//表格列配置
	private ItemSetting tableDetailSetting;//表格主体
	private ItemSetting tableFooterSetting;//表格尾
	
	private ItemSetting tableGroupHeaderSetting;//分组头
	private ItemSetting tableGroupFooterSetting;//分组尾
	
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
	public ItemSetting getTableHeaderSetting() {
		return tableHeaderSetting;
	}
	public void setTableHeaderSetting(ItemSetting tableHeaderSetting) {
		this.tableHeaderSetting = tableHeaderSetting;
	}
	public ItemSetting getTableColumnSetting() {
		return tableColumnSetting;
	}
	public void setTableColumnSetting(ItemSetting tableColumnSetting) {
		this.tableColumnSetting = tableColumnSetting;
	}
	public ItemSetting getTableDetailSetting() {
		return tableDetailSetting;
	}
	public void setTableDetailSetting(ItemSetting tableDetailSetting) {
		this.tableDetailSetting = tableDetailSetting;
	}
	public ItemSetting getTableFooterSetting() {
		return tableFooterSetting;
	}
	public void setTableFooterSetting(ItemSetting tableFooterSetting) {
		this.tableFooterSetting = tableFooterSetting;
	}
	public ItemSetting getTableGroupHeaderSetting() {
		return tableGroupHeaderSetting;
	}
	public void setTableGroupHeaderSetting(ItemSetting tableGroupHeaderSetting) {
		this.tableGroupHeaderSetting = tableGroupHeaderSetting;
	}
	public ItemSetting getTableGroupFooterSetting() {
		return tableGroupFooterSetting;
	}
	public void setTableGroupFooterSetting(ItemSetting tableGroupFooterSetting) {
		this.tableGroupFooterSetting = tableGroupFooterSetting;
	}

	
}
