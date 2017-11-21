package com.ada.site.service.impl;

import com.young.word.patchca.AdaptiveRandomWordFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.site.dao.AppDao;
import com.ada.site.entity.App;
import com.ada.site.service.AppService;
import com.ada.site.page.AppPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;

import java.util.List;


@Service
@Transactional
public class AppServiceImpl implements AppService {

    @Transactional
    @Override
    public String key() {
        String result = "";
        AdaptiveRandomWordFactory f = new AdaptiveRandomWordFactory();
        f.setMinLength(8);
        f.setMaxLength(12);
        f.setCharacters("1234567890abcdefhjkmnpwx");
        result = f.getNextWord();
        while (dao.count(Filter.eq("appKey", result)) > 0) {
            result = f.getNextWord();
        }
        return result;
    }

    @Override
    public String secret() {
        AdaptiveRandomWordFactory f = new AdaptiveRandomWordFactory();
        f.setMinLength(16);
        f.setMaxLength(32);
        f.setCharacters("1234567890abcdefhjkmnpwx");
        return f.getNextWord();
    }

    @Transactional(readOnly = true)
    public App findById(Long id) {
        App entity = dao.findById(id);
        return entity;
    }

    @Override
    public App visit(Long id) {

        App entity = dao.findById(id);
        if (entity != null) {
            Long counts = entity.getCounts();
            if (counts == null) {
                counts = 0l;
            }
            counts++;
            entity.setCounts(counts);
        }
        return entity;
    }

    @Transactional
    public App save(App bean) {
        dao.save(bean);
        return bean;
    }

    @Transactional
    public App update(App bean) {
        Updater<App> updater = new Updater<App>(bean);
        bean = dao.updateByUpdater(updater);
        return bean;
    }

    @Transactional
    public App deleteById(Long id) {
        App bean = dao.deleteById(id);
        return bean;
    }

    @Transactional
    public App[] deleteByIds(Long[] ids) {
        App[] beans = new App[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }

    @Override
    public Page<App> page(Pageable pageable) {
        return dao.page(pageable);
    }

    private AppDao dao;

    @Autowired
    public void setDao(AppDao dao) {
        this.dao = dao;
    }


    @Transactional(readOnly = true)
    public Page<App> findPage(Pageable pageable) {
        return dao.findPage(pageable);
    }

    @Transactional(readOnly = true)
    public long count(Filter... filters) {

        return dao.count(filters);

    }

    @Transactional(readOnly = true)
    public List<App> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

        return dao.findList(first, count, filters, orders);

    }
}