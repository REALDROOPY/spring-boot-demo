/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: WebConfig.java
 * Author:   jiangkun
 * Date:     2018/8/15 12:30
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent;

import com.example.framework.demoparent.sitemesh.SiteMeshFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
public class WebConfig {

    private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Bean(name = "sitemesh3")
    SiteMeshFilter siteMeshFilter() {
        log.debug("====> siteMeshFilter()");
        return new SiteMeshFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(@Qualifier("sitemesh3") SiteMeshFilter siteMeshFilter) {
        log.debug("====> filterRegistrationBean()");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(siteMeshFilter);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
