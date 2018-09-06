/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: AccountRestController.java
 * Author:   jiangkun
 * Date:     2018/9/5 13:34
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.controller;

import com.example.framework.demoparent.entity.TAccount;
import com.example.framework.demoparent.rest.BaseRestResult;
import com.example.framework.demoparent.rest.DefaultRestResultImpl;
import com.example.framework.demoparent.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/rest/account")
public class AccountRestController {

    private static final Logger log = LoggerFactory.getLogger(AccountRestController.class);

    @Autowired
    private AccountService accountService;

    @ModelAttribute
    protected void before() {
        log.debug("====> before()");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN','admin')")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseRestResult<TAccount> getAccountById(HttpServletRequest request, @PathVariable("id") Long id) {

        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            log.debug("====> attributeName: {}", attributeNames.nextElement());
        }

        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        log.debug("====> ParameterName: {}", csrfToken.getParameterName());
        log.debug("====> HeaderName: {}", csrfToken.getHeaderName());
        log.debug("====> Token: {}", csrfToken.getToken());

        TAccount vo = accountService.selectByPrimaryKey(id);
        BaseRestResult<TAccount> restResult = new DefaultRestResultImpl<>();
        restResult.setResult(vo);
        return restResult;
    }

    @RequestMapping(value = "/updateSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseRestResult<TAccount> getAccountById(@ModelAttribute("user") TAccount user, BindingResult bindingResult) {
        log.debug("====> user: {}", user);
        accountService.update(user);
        log.debug("====> saved user: {}", user);
        BaseRestResult<TAccount> restResult = new DefaultRestResultImpl<>();
        restResult.setResult(user);
        return restResult;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("account/list");
        return mv;
    }

    @ModelAttribute
    protected void after() {
        log.debug("====> after()");
    }


}
