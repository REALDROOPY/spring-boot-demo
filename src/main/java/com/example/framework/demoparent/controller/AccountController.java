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
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAccounts(Model model) {

//        accountService.selectAll();

//        Page<TAccount> page = accountService.findByPage(1, 5);
//        log.debug("====> page: {}", page);
//        List<TAccount> result = page.getResult();
//        model.addAttribute("resultList", result);
        return "account/list";
    }

    @RequestMapping(value = "/loadData", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<TAccount> loadData(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam(name = "pageSort", required = false) String pageSort,
                                       @RequestParam(name = "pageOrder", required = false) String pageOrder,
                                       @RequestParam(name = "id", required = false) Long id,
                                       @RequestParam(name = "userName", required = false) String userName) {
        log.debug("====> pageNum: {}, pageSize: {}, pageSort: {}, pageOrder: {}, id: {}, userName: {}.",
                pageNum, pageSize, pageSort, pageOrder, id, userName);
//        Page<TAccount> page = accountService.findByPage(pageNum, pageSize);
//        log.debug("====> page: {}", page);
//        log.debug("====> page json: {}", com.alibaba.fastjson.JSONObject.toJSON(page));
//        log.debug("====> page info: {}", page.toPageInfo());

        PageInfo<TAccount> pageInfo = accountService.selectPageByExample(pageNum, pageSize, pageSort, pageOrder, id, userName);

        return pageInfo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAccountById(Model model, @PathVariable("id") Long id) {
        TAccount vo = accountService.selectByPrimaryKey(id);
        model.addAttribute("vo", vo);
        return "account/view";
    }
}
