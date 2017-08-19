package com.ada.site.freemaker;

import com.ada.data.page.Filter;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.site.entity.Link;
import com.ada.site.service.LinkService;
import com.young.web.utils.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

public class LinkDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {


        Integer size = DirectiveUtils.getInt("size", params);
        if (size == null) {
            size = 10;
        }
        Integer id = DirectiveUtils.getInt("id", params);
        Pageable pagex = new Pageable();
        pagex.setPageSize(size);
        pagex.setPageNumber(1);
        pagex.getFilters().add(Filter.eq("linkType.id", id));

        Page<Link> page = linkService.page(pagex);

        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
        paramWrap.put("list", DEFAULT_WRAPPER.wrap(page.getContent()));
        Map<String, TemplateModel> origMap = DirectiveUtils
                .addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

    }

    @Autowired
    LinkService linkService;
}