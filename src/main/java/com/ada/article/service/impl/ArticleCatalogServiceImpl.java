package com.ada.article.service.impl;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.article.dao.ArticleCatalogDao;
import com.ada.article.entity.ArticleCatalog;
import com.ada.article.service.ArticleCatalogService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.util.List;
import java.util.LinkedList;

import com.ada.data.utils.FilterUtils;


/**
 * Created by imake on 2017年05月30日09:19:28.
 */
@Service
@Transactional
public class ArticleCatalogServiceImpl implements ArticleCatalogService {

    private ArticleCatalogDao dao;


    @Override
    @Transactional(readOnly = true)
    public ArticleCatalog findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<ArticleCatalog> findByTops(Integer pid) {
        LinkedList<ArticleCatalog> result = new LinkedList<ArticleCatalog>();
        ArticleCatalog catalog = dao.findById(pid);
        if (catalog != null) {
            while (catalog != null && catalog.getParent() != null) {
                result.addFirst(catalog);
                catalog = dao.findById(catalog.getParentId());
            }
            result.addFirst(catalog);
        }
        return result;
    }

    @Override
    @Transactional
    public ArticleCatalog save(ArticleCatalog bean) {
        dao.save(bean);
        return bean;
    }

    @Override
    @Transactional
    public ArticleCatalog update(ArticleCatalog bean) {
        Updater<ArticleCatalog> updater = new Updater<ArticleCatalog>(bean);
        return dao.updateByUpdater(updater);
    }

    @Override
    @Transactional
    public ArticleCatalog deleteById(Integer id) {
        ArticleCatalog bean = dao.findById(id);
        dao.deleteById(id);
        return bean;
    }

    @Override
    @Transactional
    public ArticleCatalog[] deleteByIds(Integer[] ids) {
        ArticleCatalog[] beans = new ArticleCatalog[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }


    @Autowired
    public void setDao(ArticleCatalogDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ArticleCatalog> findPage(Pageable pageable) {
        return dao.findPage(pageable);
    }

    @Override
    public Page<ArticleCatalog> page(Pageable pageable) {
        return dao.page(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Filter... filters) {
        return dao.count(filters);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
        return dao.findList(first, count, filters, orders);
    }

    @Override
    public Page<ArticleCatalog> page(Pageable pageable, Object search) {
        List<Filter> filters = FilterUtils.getFilters(search);
        if (filters != null) {
            pageable.getFilters().addAll(filters);
        }
        return dao.page(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ArticleCatalog> findChild(int id) {
        Finder finder = Finder.create("from ArticleCatalog t where t.parent.id=" + id);
        finder.append(" order by t.sortNum asc");
        finder.setCacheable(true);
        return dao.find(finder);
    }

    @Override
    public List<ArticleCatalog> findChilds(int id) {
        List<ArticleCatalog> list=null;
        ArticleCatalog catalog = dao.findById(id);
        if (catalog!=null){
            Finder finder = Finder.create("from ArticleCatalog t where t.lft>=:lft");
            finder.append(" and t.rgt<=:rgt");
            finder.setParam("lft",catalog.getLft());
            finder.setParam("rgt",catalog.getRgt());
            finder.append(" order by t.lft asc");
            finder.setCacheable(true);
            list=dao.find(finder);
        }
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ArticleCatalog> all() {
        Finder finder = Finder.create("from ArticleCatalog a order by a.sortNum asc");
        // TODO Auto-generated method stub
        return dao.find(finder);
    }

    @Transactional(readOnly = true)
    @Override
    public Pagination pageByPid(int pid, int pageNo, int pageSize) {
        Finder finder = Finder.create("from ArticleCatalog t where t.parent.id=" + pid);
        finder.append(" order by t.sortNum asc");
        finder.setCacheable(true);
        return dao.find(finder, pageNo, pageSize);
    }
}