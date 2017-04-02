package com.bootcamp.events.exercise;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Scanner;

/**
 * Created by priyanka on 2/4/17.
 */

public class EmployeeDaoIml implements IEmployeeDao {



    private NamedParameterJdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
        //jdbcTemplate = new SimpleJdbcInsert(dataSource).withTableName("Employee");
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }










    // private NamedParameterJdbcTemplate jdbcTemplate;




    @Transactional
    @Override
    public void insert(Employee employee)  {



        String sql1 = "INSERT INTO Employee " +
                "(eid,number, firstName, lastName,salary) VALUES (:eid,:number, :firstName, :lastName,:salary)";

        /*Map source=new HashMap();
        source.put("pid",employee.getFirstName());
        source.put("firstName",employee.getFirstName());
        source.put("surName",employee.getLastName());
*/
        MapSqlParameterSource source1=new MapSqlParameterSource();

        source1.addValue("number",employee.getNumber())
                .addValue("firstName",employee.getFirstName())
                .addValue("lastName",employee.getLastName()).addValue("salary",employee.getSalary())
                .addValue("eid",employee.getEmpid());


        String sql2="Insert  Into Account "+
                "(eid,account_num,pin,balance) VALUES(:eid,:account_num,:pin,:balance)";

        MapSqlParameterSource source2= new MapSqlParameterSource();

        source2.addValue("eid",employee.getEmpid())
                                    .addValue("account_num",employee.getAccount().getAcc_num())
                                    .addValue("pin",employee.getAccount().getPin())
                                    .addValue("balance",employee.getAccount().getBalance());

        jdbcTemplate.update(sql1,source1);

        jdbcTemplate.update(sql2,source2);

    }



    @Override
    public boolean update_Employee_Record(Account account) {


        String sql1 ="Select eid from Account where account_num=:account_num ";

        SqlParameterSource namedParameters = new MapSqlParameterSource("account_num",account.getAcc_num());

        Integer eid=jdbcTemplate.queryForInt(sql1, namedParameters);

        if(eid==null)
        { return false;}


        String sql = "Update Employee set number=:number where eid=:eid";


            System.out.println("Entered new number");

            Scanner in = new Scanner(System.in);

            Long number = in.nextLong();

            namedParameters = new MapSqlParameterSource("number",number)
                .addValue("eid",eid);


            int up = jdbcTemplate.update(sql,namedParameters);


            if(up<=0)

                return  false;



        return  true;



    }

    @Override
    public void delete_Employee_Record(Employee employee) {

    }

    @Override
    public void delete_Employee_Account(Account account) {


    }

    @Override
    public boolean check_Account_Exist(Account account) {

        Integer empid=null;

        Integer pin = null;

        String sql1 ="Select eid from Account where account_num=:account_num ";

        String sql2 = "Select pin from Account where pin=:pin";




        SqlParameterSource namedParameters = new MapSqlParameterSource("account_num",account.getAcc_num());

        empid=jdbcTemplate.queryForInt(sql1, namedParameters);

        if(empid==null)
        { return false;}

             namedParameters = new MapSqlParameterSource("pin",account.getPin());

                   pin=jdbcTemplate.queryForInt(sql2,namedParameters);

            if(pin==null)
               { return  false;}


        return  true;

    }

    @Override
    public boolean withdraw_balance(Account account, int balance) {

        String sql1 = "Select balance from Account where account_num = :account_num";

        SqlParameterSource namedParameters = new MapSqlParameterSource("account_num",account.getAcc_num());

        int amount=jdbcTemplate.queryForInt(sql1,namedParameters);

         if(amount<=balance)
           return false;

        String sql = "Update Account set balance=balance-:balance where account_num=:account_num";

           namedParameters = new MapSqlParameterSource("balance",balance).
                addValue("account_num",account.getAcc_num());

        int up = jdbcTemplate.update(sql,namedParameters);




        if(up<=0)
            return  false;



        return  true;
    }

    @Override
    public boolean deposit_balance(Account account,Integer balance) {

        String sql1 = "Select balance from Account where account_num = :account_num";

        SqlParameterSource namedParameters = new MapSqlParameterSource("account_num",account.getAcc_num());

        int amount=jdbcTemplate.queryForInt(sql1,namedParameters);

        String sql = "Update Account set balance=balance+:balance where account_num=:account_num";

        namedParameters = new MapSqlParameterSource("balance",balance).
                addValue("account_num",account.getAcc_num());

        int up = jdbcTemplate.update(sql,namedParameters);




        if(up<=0)
            return  false;



        return  true;
    }

    @Override
    public boolean update_Employee_Account(Account account) {


     String sql = "Update Account set pin=:pin where account_num=:account_num";



        System.out.println("Entered new pin");

        Scanner in = new Scanner(System.in);
         Integer pin = in.nextInt();

           SqlParameterSource namedParameters = new MapSqlParameterSource("account_num",account.getAcc_num())
             .addValue("pin",pin);

       int up = jdbcTemplate.update(sql,namedParameters);




       if(up<=0)
           return  false;



       return  true;

    }
}
