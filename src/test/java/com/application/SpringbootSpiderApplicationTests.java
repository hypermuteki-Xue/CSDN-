package com.application;

import com.application.dao.csdnInfoDao;
import com.application.domain.csdnInfo;
import com.application.service.csdnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSpiderApplicationTests {

@Autowired
    csdnInfoDao csdnInfoDao;
    @Test
    void contextLoads() {
        csdnInfo csdnInfo=new csdnInfo("11","22","33","44","55");
        csdnInfoDao.InsertBlog(csdnInfo);
    }

}
