/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: MyErrorController.java
 * Author:   jiangkun
 * Date:     2018/9/5 14:15
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.controller;

import com.example.framework.demoparent.entity.TAccount;
import com.example.framework.demoparent.rest.BaseRestResult;
import com.example.framework.demoparent.rest.DefaultRestResultImpl;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

//    @Autowired
//    private ErrorProperties errorProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider;

    //    @RequestMapping(value = PATH)
//    @RequestMapping(value = PATH,  produces = {MediaType.APPLICATION_JSON_VALUE})
//    StatefulBody error(HttpServletRequest request, HttpServletResponse response) {
//        if(!EnvironmentUtils.isProduction()) {
//            return buildBody(request,true);
//        }else{
//            return buildBody(request,false);
//        }
//    }

//    private StatefulBody buildBody(HttpServletRequest request,Boolean includeStackTrace){
//        Map<String,Object> errorAttributes = getErrorAttributes(request, includeStackTrace);
//        Integer status=(Integer)errorAttributes.get("status");
//        String path=(String)errorAttributes.get("path");
//        String messageFound=(String)errorAttributes.get("message");
//        String message="";
//        String trace ="";
//        if(!StringUtils.isEmpty(path)){
//            message=String.format("Requested path %s with result %s",path,messageFound);
//        }
//        if(includeStackTrace) {
//            trace = (String) errorAttributes.get("trace");
//            if(!StringUtils.isEmpty(trace)) {
//                message += String.format(" and trace %s", trace);
//            }
//        }
//        return FailureResponseBody.builder().code(0).status(status).message(message).build();
//    }

    @Override
    public String getErrorPath() {
        return serverProperties.getError().getPath();
    }

    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
                request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        return (modelAndView != null ? modelAndView : new ModelAndView("error", model));
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<BaseRestResult<Map<String, Object>>> error(HttpServletRequest request) {

        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);

        BaseRestResult<Map<String, Object>> restResult = new DefaultRestResultImpl<>();
        restResult.setCode(String.valueOf(status));
        restResult.setMsg(String.valueOf(body.get("message")));
        restResult.setResult(body);


        return new ResponseEntity<BaseRestResult<Map<String, Object>>>(restResult, status);
    }

    protected boolean isIncludeStackTrace(HttpServletRequest request,
                                          MediaType produces) {
        ErrorProperties.IncludeStacktrace include = serverProperties.getError().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    protected ModelAndView resolveErrorView(HttpServletRequest request,
                                            HttpServletResponse response, HttpStatus status, Map<String, Object> model) {
        for (ErrorViewResolver resolver : errorViewResolversProvider.getIfAvailable()) {
            ModelAndView modelAndView = resolver.resolveErrorView(request, status, model);
            if (modelAndView != null) {
                return modelAndView;
            }
        }
        return null;
    }

    protected boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase(Locale.ENGLISH));
    }

//    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public BaseRestResult<ModelAndView> errorJson(HttpServletRequest request,
//                                  HttpServletResponse response) {
//        HttpStatus status = getStatus(request);
//        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
//                request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
//        response.setStatus(status.value());
//        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
//
//        BaseRestResult<ModelAndView> restResult = new DefaultRestResultImpl<>();
//
//        restResult.setResult((modelAndView != null ? modelAndView : new ModelAndView("error", model)));
//
//        return restResult;
//    }
}
