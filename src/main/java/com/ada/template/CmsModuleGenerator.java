package com.ada.template;


public class CmsModuleGenerator {
	private static String packName = "com.ada.template";
private static String fileName = "p_album.properties"; 

	public static void main(String[] args) {
		new ModuleGenerator(packName, fileName).generate();
		System.out.println("ok");
	}
}
