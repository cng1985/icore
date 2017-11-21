package com.ada.site.action;


import com.quhaodian.data.page.Filter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import  com.ada.site.entity.LinkType;
import com.ada.site.service.LinkTypeService;
import org.springframework.web.bind.annotation.RequestParam;

/**
* Created by imake on 2017年06月07日16:36:27.
*/
@Controller
public class LinkTypeAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(LinkTypeAction.class);

	@Autowired
	private LinkTypeService manager;

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid, HttpServletRequest request, ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
				pageable.getOrders().add(Order.asc("code"));
			}
			pageable.getFilters().add(Filter.eq("parent.id", pid));
		}
		Page<LinkType> pagination = manager.page(pageable);
		model.addAttribute("tops", manager.findByTops(pid));
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("pid", pid);
		return "/admin/linktype/list";
	}

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/view_add")
	public String add(ModelMap model) {
		return "/admin/linktype/add";
	}

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/view_edit")
	public String edit(Pageable pageable,Integer id, HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/linktype/edit";
	}

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/view_view")
	public String view(Integer id,HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/linktype/view";
	}

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/model_save")
	public String save(Pageable pageable,LinkType bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:/admin/linktype/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/linktype/add";
		}
		return view;
	}

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/model_update")
	public String update(Pageable pageable, LinkType bean,HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/linktype/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/linktype/edit";
		}
		return view;
	}
	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/model_delete")
	public String delete(Pageable pageable, Integer id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,1, request, model);
	}

	@RequiresPermissions("linktype")
	@RequestMapping("/admin/linktype/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,1, request, model);
	}

}