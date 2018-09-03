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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;
import java.util.List;

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

    private static final Logger log = LoggerFactory.getLogger(MyWebSecurityConfigurerAdapter.class);

    @Autowired
    private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public AuthenticationProvider myAuthenticationProvider() {
        MyAuthenticationProvider myAuthenticationProvider = new MyAuthenticationProvider();
        myAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        return myAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(myAuthenticationProvider())
                .userDetailsService(myUserDetailsService)

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
                .antMatchers("/trace").permitAll()
                .antMatchers("/configprops").permitAll()
                .antMatchers("/metrics").permitAll()
                .antMatchers("/mappings").permitAll()
                .antMatchers("/autoconfig").permitAll()
                .antMatchers("/env").permitAll()
                .antMatchers("/info").permitAll()
                .antMatchers("/dump").permitAll()
                .antMatchers("/heapdump").permitAll()
                .antMatchers("/loggers").permitAll()
                .antMatchers("/beans").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        ProviderManager authenticationManager = new ProviderManager(Arrays.asList(myAuthenticationProvider()));

        //不擦除认证密码，擦除会导致TokenBasedRememberMeServices因为找不到Credentials再调用UserDetailsService而抛出UsernameNotFoundException
        authenticationManager.setEraseCredentialsAfterAuthentication(false);
        authenticationManager.setMessageSource(new MySpringSecurityMessageSource());

        List<AuthenticationProvider> providerList = authenticationManager.getProviders();
        for (AuthenticationProvider provider : providerList) {
            log.debug("====> provider: {}", provider.getClass().getName());
        }


        return authenticationManager;
    }

//    @Override
//    protected UserDetailsService userDetailsService() {
//        return myUserDetailsService;
//    }

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
