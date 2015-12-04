package com.ada.template2;

import com.ada.template2.ModuleMavenGenerator;

public class CmsModuleGenerator {
	private static String packName = "com.ada.template2";
private static String fileName = "p_album.properties"; 

	public static void main(String[] args) {
		new ModuleMavenGenerator(packName, fileName).generate();
		System.out.println("ok");
	}
}
