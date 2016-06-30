package com.ada.site.dao.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.site.dao.WebTemplateDao;
import com.ada.site.entity.TemplatePush;
import com.ada.site.entity.WebTemplate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Repository
public class WebTemplateDaoImpl extends CriteriaDaoImpl<WebTemplate, String> implements WebTemplateDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public WebTemplate findById(String id) {
	    if (id==null) {
			return null;
		}
		WebTemplate entity = get(id);
		return entity;
	}

	public WebTemplate save(WebTemplate bean) {
		getSession().save(bean);
		
		
		return bean;
	}

	public WebTemplate deleteById(String id) {
		WebTemplate entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<WebTemplate> getEntityClass() {
		return WebTemplate.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
	
	public String text(String templateid, Map<String, Object> keys) {
		String result = "";
		WebTemplate notice = findById(templateid);

		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		config.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX );
		try {
			Template template = new Template(notice.getId(), notice.getNote(), config);
			Writer out = new StringWriter();
			template.process(keys, out);
			result = out.toString();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}