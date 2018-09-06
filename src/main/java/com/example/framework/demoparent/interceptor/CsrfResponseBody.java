/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: CsrfResponseBody.java
 * Author:   jiangkun
 * Date:     2018/9/6 13:28
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.interceptor;

import com.example.framework.demoparent.rest.BaseRestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ControllerAdvice
public class CsrfResponseBody implements ResponseBodyAdvice<Object> {

    private static final Logger log = LoggerFactory.getLogger(CsrfResponseBody.class);

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        log.debug("========> beforeBodyWrite() body: {}", body);

        if (body != null && body instanceof BaseRestResult) {

            BaseRestResult result = (BaseRestResult) body;
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            CsrfToken csrfToken = (CsrfToken) servletRequest.getAttribute("_csrf");
            if (csrfToken != null) {
                result.setCsrfHeaderName(csrfToken.getHeaderName());
                result.setCsrfParameterName(csrfToken.getParameterName());
                result.setCsrfToken(csrfToken.getToken());
                log.debug("========> beforeBodyWrite() result: {}", result);
            }

        }

        return body;
    }
}
