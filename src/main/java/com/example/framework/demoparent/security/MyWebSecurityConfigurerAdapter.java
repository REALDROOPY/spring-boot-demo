/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: MyWebSecurityConfigurerAdapter.java
 * Author:   jiangkun
 * Date:     2018/8/28 13:30
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.userDetailsService(myUserDetailsService)

                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginSubmit")
                .defaultSuccessUrl("/account/list")

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .permitAll()
                .logoutSuccessUrl("/login?logout=true")

                .and()
                .authorizeRequests()
                .antMatchers("/account/**").access("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
                .antMatchers("/loginSubmit").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/AdminLTE/**").permitAll()
                .antMatchers("/bootstrap-table/**").permitAll()
                .antMatchers("/jquery-validation/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .anyRequest().authenticated();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.expressionHandler(new DefaultWebSecurityExpressionHandler() {
//            @Override
//            protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
//                WebSecurityExpressionRoot root = (WebSecurityExpressionRoot) super.createSecurityExpressionRoot(authentication, fi);
//                root.setDefaultRolePrefix(""); //remove the prefix ROLE_
//                return root;
//            }
//        });
//    }

}
