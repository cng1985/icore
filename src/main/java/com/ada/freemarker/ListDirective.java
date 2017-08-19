package com.ada.freemarker;

import com.young.web.utils.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

/**
 * Created by cng19 on 2017/6/26.
 */
public abstract class ListDirective<T> implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {

        map = params;

        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
        paramWrap.put("list", DEFAULT_WRAPPER.wrap(list()));
        Map<String, TemplateModel> origMap = DirectiveUtils
                .addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
    }

    public abstract List<T> list();

    private Map map;

    private Map getParams() {
        return map;
    }

    public Integer getInt(String name) {
        Integer size = null;
        try {
            size = DirectiveUtils.getInt(name, map);

        } catch (Exception e) {

        }
        if (size == null) {
            size = 10;
        }
        return size;
    }
    public String getString(String name,String defaul) {
        String result = null;
        try {
            result = DirectiveUtils.getString(name, map);
        } catch (Exception e) {

        }
        if (defaul==null){
            defaul="";
        }
        if (result == null) {
            result = defaul;
        }
        return result;
    }
}
