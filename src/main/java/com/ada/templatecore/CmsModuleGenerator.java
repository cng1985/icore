package com.ada.templatecore;

import com.ada.template_ace.ModuleMavenGenerator;

public class CmsModuleGenerator {
	private static String packName = "com.ada.templatecore";
private static String fileName = "p_article.properties"; 

	public static void main(String[] args) {
		new ModuleMavenGenerator(packName, fileName).generate();
		System.out.println("ok");
	}
}
