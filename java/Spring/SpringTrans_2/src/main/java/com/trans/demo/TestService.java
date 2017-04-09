package com.trans.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class TestService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;


    @Autowired
    public TestService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMail(String sender, String reciever,Long amount) {


       String query = "Insert into account_transfer(sender, reciever,amount) Values (?,?,?)";
       jdbcTemplate.update(query,new Object[]{sender,reciever,amount});

       int a = 1 / 0;




        System.out.println(" mail sent");
    }
}
