package com.ada.template2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModuleMavenGenerator {

	private static final Logger log = LoggerFactory
			.getLogger(ModuleMavenGenerator.class);
	public static final String SPT = File.separator;

	public static final String ENCODING = "UTF-8";

	private Properties prop = new Properties();
	
	private String packName;
	private String fileName;
	private File daoImplFile;
	private File daoFile;
	private File managerFile;
	private File managerImplFile;
	private File actionFile;
	private File pageListFile;
	private File pageEditFile;
	private File pageAddFile;

	private File daoImplTpl;
	private File daoTpl;
	private File managerTpl;
	private File managerImplTpl;
	private File actionTpl;
	private File pageListTpl;
	private File pageEditTpl;
	private File pageAddTpl;
	private File pageTpl;
	private File pageFile;

	public ModuleMavenGenerator(String packName, String fileName) {
		this.packName = packName;
		this.fileName = fileName;
	}

	@SuppressWarnings("unchecked")
	private void loadProperties() {
		try {
			log.debug("packName=" + packName);
			log.debug("fileName=" + fileName);
			FileInputStream fileInput = new FileInputStream(getFilePath(
					packName, fileName));
			prop.load(fileInput);
			String entityUp = prop.getProperty("Entity");
			log.debug("entityUp:" + entityUp);
			if (entityUp == null || entityUp.trim().equals("")) {
				log.warn("Entity not specified, exit!");
				return;
			}
			String entityLow = entityUp.substring(0, 1).toLowerCase()
					+ entityUp.substring(1);
			log.debug("entityLow:" + entityLow);
			prop.put("entity", entityLow);
			if (log.isDebugEnabled()) {
				Set ps = prop.keySet();
				for (Object o : ps) {
					log.debug(o + "=" + prop.get(o));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void prepareFile() {
		String pageFilePath = getFilePath(prop.getProperty("page_p"),
				prop.getProperty("Entity") + "Page.java");
		pageFile= new File(pageFilePath);
		
		String daoImplFilePath = getFilePath(prop.getProperty("dao_impl_p"),
				prop.getProperty("Entity") + "DaoImpl.java");
		daoImplFile = new File(daoImplFilePath);
		log.debug("daoImplFile:" + daoImplFile.getAbsolutePath());

		String daoFilePath = getFilePath(prop.getProperty("dao_p"), prop
				.getProperty("Entity")
				+ "Dao.java");
		daoFile = new File(daoFilePath);
		log.debug("daoFile:" + daoFile.getAbsolutePath());

		String managerFilePath = getFilePath(prop.getProperty("manager_p"),
				prop.getProperty("Entity") + "Service.java");
		managerFile = new File(managerFilePath);
		log.debug("managerFile:" + managerFile.getAbsolutePath());

		String managerImplFilePath = getFilePath(prop
				.getProperty("manager_impl_p"), prop.getProperty("Entity")
				+ "ServiceImpl.java");
		managerImplFile = new File(managerImplFilePath);
		log.debug("managerImplFile:" + managerImplFile.getAbsolutePath());
		String actionFilePath = getFilePath(prop.getProperty("action_p"), prop
				.getProperty("Entity")
				+ "Action.java");
		actionFile = new File(actionFilePath);
		log.debug("actionFile:" + actionFile.getAbsolutePath());

		String pagePath = "src/main/webapp/WEB-INF/"
				+ prop.getProperty("config_sys") + "/"
				+ prop.getProperty("config_entity") + "/";
		pageListFile = new File(pagePath + "list.html");
		log.debug("pageListFile:" + pageListFile.getAbsolutePath());
		pageEditFile = new File(pagePath + "edit.html");
		log.debug("pageEditFile:" + pageEditFile.getAbsolutePath());
		pageAddFile = new File(pagePath + "add.html");
		log.info("pageAddFile:" + pageAddFile.getAbsolutePath());
	}

	private void prepareTemplate() {
		String tplPack = getClass().getResource("/com/ada/template2").getFile();
		log.info("tplPack:" + tplPack);
		daoImplTpl = new File(getFilePath2(tplPack, "dao_impl.txt"));
		daoTpl = new File(getFilePath2(tplPack, "dao.txt"));
		managerImplTpl = new File(getFilePath2(tplPack, "manager_impl.txt"));
		managerTpl = new File(getFilePath2(tplPack, "manager.txt"));
		actionTpl = new File(getFilePath2(tplPack, "action.txt"));
		pageListTpl = new File(getFilePath2(tplPack, "page_list.txt"));
		pageAddTpl = new File(getFilePath2(tplPack, "page_add.txt"));
		pageEditTpl = new File(getFilePath2(tplPack, "page_edit.txt"));
		pageTpl= new File(getFilePath2(tplPack, "page.txt"));
	}

	private static void stringToFile(File file, String s) throws IOException {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		FileUtils.writeStringToFile(file, s, ENCODING);
	}

	private void writeFile() {
		try {
			if ("true".equals(prop.getProperty("is_dao"))) {
				stringToFile(daoImplFile, readTpl(daoImplTpl));
				stringToFile(daoFile, readTpl(daoTpl));
			}
			if ("true".equals(prop.getProperty("is_manager"))) {
				stringToFile(managerImplFile, readTpl(managerImplTpl));
				stringToFile(managerFile, readTpl(managerTpl));
			}
			if ("true".equals(prop.getProperty("is_action"))) {
				stringToFile(actionFile, readTpl(actionTpl));
			}
			if ("true".equals(prop.getProperty("is_page"))) {
				stringToFile(pageListFile, readTpl(pageListTpl));
				stringToFile(pageAddFile, readTpl(pageAddTpl));
				stringToFile(pageEditFile, readTpl(pageEditTpl));
			}
			if ("true".equals(prop.getProperty("page"))) {
				stringToFile(pageFile, readTpl(pageTpl));
			}
		} catch (IOException e) {
			log.warn("write file faild! " + e.getMessage());
		}
	}

	private String readTpl(File tpl) {
		String content = null;
		try {
			content = FileUtils.readFileToString(tpl, ENCODING);
			Set<Object> ps = prop.keySet();
			for (Object o : ps) {
				String key = (String) o;
				String value = prop.getProperty(key);
				content = content.replaceAll("\\#\\{" + key + "\\}", value);
			}
		} catch (IOException e) {
			log.warn("read file faild. " + e.getMessage());
		}
		return content;

	}

	private String getFilePath(String packageName, String name) {
		log.debug("replace:" + packageName);
		String path = packageName.replaceAll("\\.", "/");
		log.debug("after relpace:" + path);
		return "src/main/java/" + path + "/" + name;
	}
	private String getFilePath2(String packageName, String name) {
		return  packageName + "/" + name;
	}
	private String getFilePath(String dir,String packageName, String name) {
		log.debug("replace:" + packageName);
		String path = packageName.replaceAll("\\.", "/");
		log.debug("after relpace:" + path);
		return "src/main/java/" + path + "/" + name;
	}

	public void generate() {
		loadProperties();
		prepareFile();
		prepareTemplate();
		writeFile();
	}

	public static void main(String[] args) {
		String packName = "com.jeecms.common.developer.template";
		String fileName = "template.properties";
		new ModuleMavenGenerator(packName, fileName).generate();
	}
}
