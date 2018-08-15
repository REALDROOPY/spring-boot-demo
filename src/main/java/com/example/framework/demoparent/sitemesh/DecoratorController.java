/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: DecoratorController.java
 * Author:   jiangkun
 * Date:     2018/8/15 15:50
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.sitemesh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/decorators")
public class DecoratorController {

    @RequestMapping("/decorator")
    public String defaultDecorator() {
        return "/decorators/decorator";
    }
}
