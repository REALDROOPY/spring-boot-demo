/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: MySpringSecurityMessageSource.java
 * Author:   jiangkun
 * Date:     2018/8/31 11:34
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.security;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.SpringSecurityMessageSource;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MySpringSecurityMessageSource extends ResourceBundleMessageSource {
    // ~ Constructors
    // ===================================================================================================

    public MySpringSecurityMessageSource() {
        setBasename("com.example.framework.demoparent.security.messages");
    }

    // ~ Methods
    // ========================================================================================================

    public static MessageSourceAccessor getAccessor() {
        return new MessageSourceAccessor(new MySpringSecurityMessageSource());
    }
}
