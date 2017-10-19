package com.efounder.report.config;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.efounder.report.parse.FileUtils;

public class Dom4jTest {

	public static void main(String[] args) {

		 String xml=FileUtils.readFile(new File("E:\\temp\\ReportStyle.xml"));
		 try {
			Document document=DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List elist=root.elements();
			System.out.println(elist.size());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
