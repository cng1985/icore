package com.ada.admin.service;

import java.util.List;

import com.ada.admin.entity.Menu;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;

public interface MenuService {
    List<Menu> childMenus(int id);

    /**
     * 查找该节点下的所有节点包括自己
     *
     * @param id
     * @return
     */
    List<Menu> childs(int id);

    long count(Filter... filters);

    Menu deleteById(Integer id);

    Menu[] deleteByIds(Integer[] ids);

    Menu findById(Integer id);

    /**
     * 查询下一级节点
     *
     * @param id
     * @return
     */
    List<Menu> findChild(int id);

    List<Menu> findChildMenu(int id);


    List<Menu> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

    Page<Menu> findPage(Pageable pageable);

    List<Menu> findTop(Integer id);

    Pagination getPage(int pageNo, int pageSize);

    Menu save(Menu bean);

    Menu update(Menu bean);

}