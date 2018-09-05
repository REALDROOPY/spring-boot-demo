package com.example.framework.demoparent;

import com.example.framework.demoparent.entity.TAccount;
import com.example.framework.demoparent.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoPomApplicationTests {

    @Autowired
    private AccountService accountService;

    @Test
    public void contextLoads() {
        TAccount account = accountService.selectByPrimaryKey(new Long("1"));
        Assert.assertEquals(account.getId(), new Long("1"));
    }

}
