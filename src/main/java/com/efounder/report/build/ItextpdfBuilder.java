package com.efounder.report.build;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * itextpdf构造器
* @ClassName: ItextpdfBuilder  
* @Description: pdf构造器的一种实现，直接将html编译成pdf
* @author GJX  
* @date 2017年10月12日 上午9:11:13  
*
 */
public class ItextpdfBuilder implements IBuilder {

	@Override
	public void buildPDF(File file, String html) {

		Document document = new Document();
		try{
		
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes("Utf-8")),
					Charset.forName("UTF-8"));
			document.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
