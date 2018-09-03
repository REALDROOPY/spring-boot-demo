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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

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
    private AccountService accountService;

    @InitBinder
    public void intDate(WebDataBinder dataBinder) {
        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm"), "createTime");
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(Model model) {
        return "account/edit";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertSubmit(@ModelAttribute("user") TAccount user) {
        log.debug("====> user: {}" + user);
        accountService.insert(user);
        log.debug("====> saved user: {}" + user);
        return "account/list";
    }

    @RequestMapping(value = "/updateSubmit", method = RequestMethod.POST)
    public String updateSubmit(@ModelAttribute("user") TAccount user) {
        log.debug("====> user: {}" + user);
        accountService.update(user);
        log.debug("====> saved user: {}" + user);
        return "account/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @PreAuthorize("hasAnyAuthority('ROLE_USER2','ROLE_ADMIN2','admin2')")
    public String getAccounts(HttpServletRequest request, Model model) {
        RequestContext requestContext = new RequestContext(request);
        String msg = requestContext.getMessage("test.str");
        log.debug("====> msg: {}", msg);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.debug("====> username: {}", userDetails.getUsername());

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            log.debug("====> authority: {}", grantedAuthority.getAuthority());
        }


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
