package com.bootcamp.events.exercise;

/**
 * Created by priyanka on 2/4/17.
 */
public interface IEmployeeDao {

    void insert(Employee employee);

    boolean check_Account_Exist(Account account);

    void delete_Employee_Record(Employee employee);

    void delete_Employee_Account(Account account);

    boolean update_Employee_Account(Account account);

    boolean update_Employee_Record(Account account);

    boolean withdraw_balance(Account account,int amount);

    boolean deposit_balance(Account account, Integer amount);



 }
