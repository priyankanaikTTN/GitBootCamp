package com.trans.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import javax.sql.rowset.spi.TransactionalWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by priyanka on 29/3/17.
 */
@Service
public class AccountService {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    TestService testService;

    @Autowired
    public AccountService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }


    @Transactional
    public void transferAmount(String reciever, String sender, Long amount) {

       /* TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
*/
        System.out.println("transfer Amount 111");

        String query1 = "UPDATE account set balance= balance+? where name=?";


        jdbcTemplate.update(query1, new Object[]{amount, reciever});



        String query2 = "UPDATE account set balance = balance-? where name=?";
        jdbcTemplate.update(query2, new Object[]{amount, sender});



        System.out.println("transfer Amount : sending mail");
        try {
            testService.sendMail(sender, amount);

        }catch (ArithmeticException e)
        {}
          /* platformTransactionManager.commit(transactionStatus);
*/



          /* platformTransactionManager.rollback(transactionStatus);
*/


    }

    @Transactional
    public Account getAccountStateOfUser(String name) {
        System.out.println("Account: " + name);

        Account account = (Account) jdbcTemplate.queryForObject("Select * from account where name=?", new Object[]{name}, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setBal(resultSet.getInt("balance"));
                account.setName(resultSet.getString("name"));
                account.setId(resultSet.getInt("id"));


                return account;
            }
        });

        return account;
    }





}
