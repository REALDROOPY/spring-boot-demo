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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN','admin')")
    @RequestMapping(value = "/{id}")
    public BaseRestResult<TAccount> getAccountById(@PathVariable("id") Long id) {
        TAccount vo = accountService.selectByPrimaryKey(id);
        BaseRestResult<TAccount> restResult = new DefaultRestResultImpl<>();
        restResult.setResult(vo);
        return restResult;
    }
}
