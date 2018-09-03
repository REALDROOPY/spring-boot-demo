/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: MyUserDetailsService.java
 * Author:   jiangkun
 * Date:     2018/8/28 13:32
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("====> 用户的用户名: {}", username);


        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, "123456",
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_ADMIN,ACTUATOR"));
        return user;
    }
}
