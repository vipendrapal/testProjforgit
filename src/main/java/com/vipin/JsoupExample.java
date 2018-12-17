package com.vipin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupExample {

	public static void main(String[] args) throws IOException {
		JsoupExample j = new JsoupExample();
		File file = j.loadStandardTemplate("path");

		File stmtHtml = j.getUseHtmlFile(file);

	}

	private File getUseHtmlFile(File standardHtmlfile) throws IOException {
		Document doc = Jsoup.parse(standardHtmlfile, "UTF-8");

		// get page title
		String title = doc.title();
		Element ele = doc.getElementById("newBalance");
		ele.attr("name", "newBalancetest");
		ele.text("20.00");

		File newFile = new File("D:\\TestJava\\newFile.html");
		if (!newFile.exists()) {
			newFile.createNewFile();
		}
		PrintWriter writer = new PrintWriter(new FileWriter(newFile));
		writer.write(doc.toString());
		writer.flush();
		writer.close();
		return newFile;
	}

	private File loadStandardTemplate(String path) {
		File file = new File("C:\\Users\\E00805\\Desktop\\statement\\CRED-PRINT\\CRED-PRINT\\stmtPageCopy.html");
		return file;
	}
}
