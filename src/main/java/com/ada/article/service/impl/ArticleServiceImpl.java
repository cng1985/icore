package com.ada.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.article.dao.ArticleCatalogDao;
import com.ada.article.dao.ArticleDao;
import com.ada.article.dao.ArticleTagDao;
import com.ada.article.entity.Article;
import com.ada.article.entity.ArticleCatalog;
import com.ada.article.entity.ArticleTag;
import com.ada.article.page.ArticlePage;
import com.ada.article.service.ArticleService;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao dao;

	@Autowired
	private ArticleTagDao tagDao;

	@Autowired
	private ArticleCatalogDao catalogDao;

	@Transactional
	@Override
	public Article addTag(Long id, String tag) {
		Article article = dao.findById(id);
		if (article!=null) {
			addTag(tag, article);
		}
		return article;
	}

	private void addTag(String tag, Article article) {
		ArticleTag e=tagDao.tag(tag);
		article.getTags().add(e);
	}

	@Transactional
	@Override
	public Article addTagS(Long id, List<String> tags) {
		Article article = dao.findById(id);
		if (article!=null) {
			for (String string : tags) {
				addTag(string, article);
			}
		}
		return article;
	}

	@Transactional
	public Article deleteById(Long id) {

		Article bean = dao.findById(id);
		Integer cid = -1;
		if (bean.getCatalog() != null) {
			cid = bean.getCatalog().getId();
		}
		dao.delete(bean);
		if (cid > 0) {
			catalogDao.updateNumsAndTime(cid);
		}
		return bean;
	}
	
	@Transactional
	public Article[] deleteByIds(Long[] ids) {
		Article[] beans = new Article[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	@Transactional(readOnly = true)
	public Article findById(Long id) {
		Article entity = dao.findById(id);
		return entity;
	}

	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Finder finder = Finder.create("from Article a order by a.id desc ");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	@Override
	public ArticlePage pageByCatalog(int catalog, int pageNo, int pageSize) {
		ArticlePage result = null;

		ArticleCatalog catalogs = catalogDao.findById(catalog);
		if (catalogs != null) {
			Finder finder = Finder.create();
			finder.append("from Article a where a.catalog.lft >= :lft ");
			finder.setParam("lft", catalogs.getLft());
			finder.append(" and a.catalog.rgt <= :rgt");
			finder.setParam("rgt", catalogs.getRgt());
			Pagination<Article> page = dao.find(finder, pageNo, pageSize);
			result = new ArticlePage(page);
		}
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public ArticlePage pageByCatalog(long uid, int catalog, int pageNo, int pageSize) {
		ArticlePage result = null;

		ArticleCatalog catalogs = catalogDao.findById(catalog);
		if (catalogs != null) {
			Finder finder = Finder.create();
			finder.append("from Article a where a.catalog.lft >= :lft ");
			finder.setParam("lft", catalogs.getLft());
			finder.append(" and a.catalog.rgt <= :rgt");
			finder.setParam("rgt", catalogs.getRgt());
			finder.append("  and a.user.id =:uid");
			finder.setParam("uid", uid);
			finder.append("  order by a.id desc  ");
			Pagination<Article> page = dao.find(finder, pageNo, pageSize);
			result = new ArticlePage(page);
		}
		return result;
	}

	@Transactional
	@Override
	public Article resetTagS(Long id, List<String> tags) {
		Article article = dao.findById(id);
		if (article!=null) {
			article.getTags().clear();
			for (String string : tags) {
				addTag(string, article);
			}
		}
		return article;
	}

	@Transactional
	public Article save(Article bean,String... tag) {
		dao.save(bean);
		if (tag!=null) {
			for (String string : tag) {
				addTag(string,bean);
			}
		}
		Integer cid = -1;
		if (bean.getCatalog() != null) {
			cid = bean.getCatalog().getId();
		}
		if (cid > 0) {
			catalogDao.updateNumsAndTime(cid);
		}
		return bean;
	}

	@Autowired
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	@Transactional
	public Article update(Article bean) {
		Updater<Article> updater = new Updater<Article>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}
	@Transactional
	@Override
	public Article view(Long id) {
		Article result=dao.findById(id);
		if (result!=null) {
			Integer views=result.getViews();
			if (views==null) {
				views=0;
			}
			views++;
			result.setViews(views);
		}
		return result;
	}
}