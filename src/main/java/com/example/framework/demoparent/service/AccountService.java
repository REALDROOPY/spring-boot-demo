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
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private TAccountMapper accountMapper;

    public TAccount findById(Long id) {
        return accountMapper.selectByPrimaryKey(new TAccountKey(id));
    }

    public int insert(TAccount user) {
        user.setCreateBy(1L);
        user.setUpdateBy(1L);
        user.setUpdateTime(new Date());
        int result = accountMapper.insert(user);

        log.debug("====> id: {}", user.getId());

        return result;
    }

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
        return accountMapper.selectPageByExample(example);
    }

    public PageInfo<TAccount> selectPageByExample(int pageNo,
                                                  int pageSize,
                                                  String pageSort,
                                                  String pageOrder,
                                                  Long id,
                                                  String userName) {
        TAccountExample example = new TAccountExample();
        TAccountExample.Criteria criteria = example.createCriteria();
        if (id != null) {
            criteria.andIdEqualTo(id);
        }

        if (StringUtils.isNotBlank(userName)) {
            criteria.andUserNameLike("%" + userName + "%");
        }

        if (StringUtils.isNotBlank(pageSort) && StringUtils.isNotBlank(pageOrder)) {
            example.setOrderByClause(String.format("%s %s", pageSort, pageOrder));
        }

        PageHelper.startPage(pageNo, pageSize);
        Page<TAccount> page = accountMapper.selectPageByExample(example);
        PageInfo<TAccount> pageInfo = page.toPageInfo();
        return pageInfo;
    }

    public Page<TAccount> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return accountMapper.findByPage();
    }

}