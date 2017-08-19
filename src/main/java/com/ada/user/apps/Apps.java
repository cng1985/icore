package com.ada.user.apps;


import com.ada.activity.entity.ActivityCatalog;
import com.ada.article.entity.ArticleCatalog;
import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.simple.TemplateSimpleDir;
import com.ada.question.entity.QuestionCatalog;

import java.io.File;

public class Apps {

	public static void main(String[] args) {
		File file = new File("D:\\mvnspace\\iwan\\iwan_web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
		ChainMake make = new ChainMake(TemplateSimpleDir.class, TemplateHibernateDir.class);
		make.setAction("com.ada.iwan.controller.admin");
		make.setView(file);
		make.setDao(true);
		make.setService(true);
		make.setAction(false);
		make.setView(false);
		make.setMenus("1,71,96");
		// UserOauthToken.
		make.makes(ArticleCatalog.class);
	}

}
