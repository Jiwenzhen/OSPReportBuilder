package com.efounder.report.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 属性配置最小单元 
* @ClassName: ItemSetting  
* @Description: TODO
* @author GJX  
* @date 2017年10月11日 下午6:15:00  
*
 */
public class ItemSetting {

	protected String type;
	protected String value;
	protected Map<String, String> propertys;
	protected List<ItemSetting> childrens;
	
	public ItemSetting() {
		propertys=new HashMap<String, String>();
		childrens=new ArrayList<ItemSetting>();
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public void addProperty(String key,String value){
		propertys.put(key, value);
	}
	
	public String getProperty(String key){
		return propertys.get(key);
	}
	
	public void setPropertys(Map<String, String> propertys){
		this.propertys=propertys;
	}
	
	public void addChildren(ItemSetting children){
		if(children!=null){
			childrens.add(children);
		}
		
	}
	
	public void setChildrenList(List<ItemSetting> list){
		this.childrens=list;
	}
	public List<ItemSetting> getChildrenList(){
		return childrens;
	}
	public Map<String, String> getPropertys(){
		return propertys;
	}
}
