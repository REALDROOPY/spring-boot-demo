/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: MyAccessDeniedHandler.java
 * Author:   jiangkun
 * Date:     2018/9/4 9:22
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyAccessDeniedHandler extends AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private static final Logger log = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.debug("========> handle()");
        super.handle(request, response, accessDeniedException);
    }

    @Override
    public void setErrorPage(String errorPage) {
        log.debug("========> setErrorPage() errorPage: {}", errorPage);
        super.setErrorPage(errorPage);
    }
}
