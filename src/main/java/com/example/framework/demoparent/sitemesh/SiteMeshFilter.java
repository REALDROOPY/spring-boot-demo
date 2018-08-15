/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: SiteMeshFilter.java
 * Author:   jiangkun
 * Date:     2018/8/15 12:28
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {

    private static final Logger log = LoggerFactory.getLogger(SiteMeshFilter.class);

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {

        log.debug("========> applyCustomConfiguration()");

        builder.addDecoratorPath("/**", "/decorators/decorator")
//                .addDecoratorPath("/strategy/**", "/WEB-INF/views/decorators/decorator.jsp")
//                .addExcludedPath("/login/**")
//                .addExcludedPath("/main/**")
                .addExcludedPath("/static/**")
                .addExcludedPath("/decorators/decorator")
                .addExcludedPath("/AdminLTE/**")
                .addTagRuleBundle(new Sm2TagRuleBundle());
//        builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
    }
}
