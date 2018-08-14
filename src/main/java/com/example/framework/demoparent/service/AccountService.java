/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: AccountService.java
 * Author:   jiangkun
 * Date:     2018/8/13 16:29
 * Description:
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.example.framework.demoparent.service;

import com.example.framework.demoparent.entity.TAccount;
import com.example.framework.demoparent.entity.TAccountExample;
import com.example.framework.demoparent.entity.TAccountKey;
import com.example.framework.demoparent.mapper.TAccountMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author jiangkun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountService {

    @Autowired
    private TAccountMapper accountMapper;

    public TAccount selectByPrimaryKey(Long id) {
        TAccountKey key = new TAccountKey();
        key.setId(id);

        return accountMapper.selectByPrimaryKey(key);
    }

    public List<TAccount> selectAll() {
        TAccountExample example = new TAccountExample();
        example.createCriteria().andUserNameLike("dr%");
        example.setOrderByClause("id asc");
        PageHelper.startPage(1, 5);
        accountMapper.selectPageByExample(example);
        return accountMapper.selectByExample(example);
    }

    public Page<TAccount> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return accountMapper.findByPage();
    }

}