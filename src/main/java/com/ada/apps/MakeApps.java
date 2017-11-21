package com.ada.apps;

import com.quhaodian.imake.ChainMake;
import com.quhaodian.imake.template.hibernate.TemplateHibernateDir;
import com.quhaodian.imake.templates.adminlte.TemplateAdminLTE;
import com.ada.site.entity.Link;
import com.ada.site.entity.LinkType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ada on 2017/6/7.
 */
public class MakeApps {

    public static void main(String[] args) {
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.ada.site.action");

        File view = new File("E:\\mvnspace\\usite\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        // cs.add(SupplierContract.class);
        cs.add(Link.class);
        cs.add(LinkType.class);

        make.setDao(false);
        make.setService(false);
        make.setView(false);
        make.setAction(true);
        make.makes(cs);
        System.out.println("ok");
    }
}
