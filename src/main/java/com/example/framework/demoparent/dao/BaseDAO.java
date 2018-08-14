/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: BaseDAO.java
 * Author:   jiangkun
 * Date:     2018/8/14 11:20
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.dao;

import com.github.pagehelper.Page;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface BaseDAO {

    <E> Page<E> findByPage();
}
