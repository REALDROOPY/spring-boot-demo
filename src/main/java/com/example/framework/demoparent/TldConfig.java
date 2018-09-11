/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: TldConfig.java
 * Author:   jiangkun
 * Date:     2018/8/28 17:11
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent;

import com.example.framework.demoparent.interceptor.RestCsrfHandlerInterceptor;
import freemarker.core.HTMLOutputFormat;
import freemarker.ext.jsp.TaglibFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

//@Configuration
public class TldConfig extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(TldConfig.class);

//    @Autowired
//    private FreeMarkerConfigurer configurer;
//
//    @PostConstruct
//    public void freeMarkerConfigurer() {
//        List<String> tlds = new ArrayList<>(5);
//        tlds.add("/static/tags/security.tld");
//        TaglibFactory taglibFactory = configurer.getTaglibFactory();
//        taglibFactory.setClasspathTlds(tlds);
//        if (taglibFactory.getObjectWrapper() == null) {
//            taglibFactory.setObjectWrapper(configurer.getConfiguration().getObjectWrapper());
//        }
//        //anti xss
//        configurer.getConfiguration().setOutputFormat(HTMLOutputFormat.INSTANCE);
//
//        //configurer.setPreTemplateLoaders(new HtmlTemplateLoader(configurer.getConfiguration().getTemplateLoader()));
//        //configurer.setPostTemplateLoaders(new HtmlTemplateLoader(configurer.getConfiguration().getTemplateLoader()));
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//        registry.addInterceptor(new RestCsrfHandlerInterceptor()).addPathPatterns("/rest/**");
//    }

}

