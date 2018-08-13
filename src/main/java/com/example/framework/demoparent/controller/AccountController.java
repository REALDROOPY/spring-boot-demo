/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: AccountController.java
 * Author:   jiangkun
 * Date:     2018/8/13 16:28
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.controller;

import com.example.framework.demoparent.entity.TAccount;
import com.example.framework.demoparent.service.AccountService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAccounts(Model model) {

        Page<TAccount> page = accountService.findByPage(1,5);


//        List<TAccount> result = accountService.selectAll();
        List<TAccount> result = page.getResult();
        model.addAttribute("resultList", result);
        return "account/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAccountById(Model model, @PathVariable("id") Long id) {
        TAccount vo = accountService.selectByPrimaryKey(id);
        model.addAttribute("vo", vo);
        return "account/view";
    }
}
