package com.bootcamp.events.exercise;

import com.bootcamp.events.customEvents.EmailEvent;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.org.apache.bcel.internal.generic.ISUB;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by priyanka on 31/3/17.
 */
@ComponentScan(basePackages = {"com.bootcamp.events.exercise"})
public class EmployeeService {

    public static void InsertEmployeeRecord(ClassPathXmlApplicationContext context)
    {


        EmployeePublisher employeePublisher = (EmployeePublisher) context.getBean("employeePublisher");


        Scanner in = new Scanner(System.in);
        boolean flag;

        Employee e= new Employee();



        System.out.println("Enter employee firstname");
        String fname= in.nextLine();


        System.out.println("Enter employee lastname");
        String lname=in.nextLine();

        System.out.println("Enter Employee id");
        Integer eid = in.nextInt();

        System.out.println("Enter phone number");
        Long  num =in.nextLong();

        System.out.println("Enter salary");
        Integer sal = in.nextInt();

        e.setEmpid(eid);
        e.setFirstName(fname);
        e.setLastName(lname);
        e.setNumber(num);
        e.setSalary(sal);

        if(sal>30000)
        {

            EmployeeEvent employeeEvent = new EmployeeEvent(e);

            employeePublisher.publish(employeeEvent);

        }





        System.out.println("Enter the Account details of employee");

        Account a= new Account();

        System.out.println("Enter starting balance");
        Integer bal = in.nextInt();

        a.setBalance(bal);
        a.setAcc_num();
        a.setPin();
        e.setAccount(a);

        System.out.println("Your Account details are");

        System.out.println("Your account numnber"+ a.getAcc_num());

        System.out.println("Your pin number"+a.getPin());



        EmployeeDaoIml employeeDaoIml = (EmployeeDaoIml) context.getBean(EmployeeDaoIml.class);

         do {

             try {
                 employeeDaoIml.insert(e);
                 flag = false;

             }catch (Exception ex)
             {
                 System.out.println("This employee id already exist.... Enter new");
                 System.out.println("Employee id");
                 eid=in.nextInt();
                 e.setEmpid(eid);
                 flag=true;
             }

         }while(flag);



    }

    public static void changePin(ClassPathXmlApplicationContext context) {


        Account account=new Account();

        Scanner in = new Scanner(System.in);

        EmployeeDaoIml employeeDaoIml = (EmployeeDaoIml) context.getBean(EmployeeDaoIml.class);

        boolean ispresent;

        do {


            System.out.println("Enter  account number");

            Integer acc__num;

            acc__num = in.nextInt();

            System.out.println("Enter account pin");

            Integer pin = in.nextInt();

            account.setAcc_num_Account(acc__num);

            account.setPin_Account(pin);




             ispresent=  employeeDaoIml.check_Account_Exist(account);

           if(!(ispresent))
           {
               System.out.println("Invalid account number or pin....Try again");

           }

        }while (!(ispresent));



          AccountPublisher accountPublisher = context.getBean(AccountPublisher.class);


            AccountEvent accountEvent = new AccountEvent(account,"update");

            accountPublisher.publish(accountEvent);


            if(employeeDaoIml.update_Employee_Account(account))
            {
                System.out.println("account pin updated successfully");
            }
            else {
                System.out.println("Couldn't update .. try later");
            }

    }

    private static void changeNumber(ClassPathXmlApplicationContext context) {


        Account account=new Account();

        Scanner in = new Scanner(System.in);

        EmployeeDaoIml employeeDaoIml = (EmployeeDaoIml) context.getBean(EmployeeDaoIml.class);

        boolean ispresent;

        do {


            System.out.println("Enter  account number");

            Integer acc__num;

            acc__num = in.nextInt();

            System.out.println("Enter account pin");

            Integer pin = in.nextInt();

            account.setAcc_num_Account(acc__num);

            account.setPin_Account(pin);




            ispresent=  employeeDaoIml.check_Account_Exist(account);

            if(!(ispresent))
            {
                System.out.println("Invalid account number or pin....Try again");

            }

        }while (!(ispresent));



        AccountPublisher accountPublisher = context.getBean(AccountPublisher.class);


        AccountEvent accountEvent = new AccountEvent(account,"update");

        accountPublisher.publish(accountEvent);


        if(employeeDaoIml.update_Employee_Record(account))
        {
            System.out.println("Mobile number updated successfully");
        }
        else {
            System.out.println("Couldn't update .. try later");
        }

    }

    private static void withdrawCash(ClassPathXmlApplicationContext context) {


        Account account=new Account();

        Scanner in = new Scanner(System.in);

        EmployeeDaoIml employeeDaoIml = (EmployeeDaoIml) context.getBean(EmployeeDaoIml.class);

        boolean ispresent;

        do {


            System.out.println("Enter  account number");

            Integer acc__num;

            acc__num = in.nextInt();

            System.out.println("Enter account pin");

            Integer pin = in.nextInt();

            account.setAcc_num_Account(acc__num);

            account.setPin_Account(pin);




            ispresent=  employeeDaoIml.check_Account_Exist(account);

            if(!(ispresent))
            {
                System.out.println("Invalid account number or pin....Try again");

            }

        }while (!(ispresent));

        System.out.println("Enter amount to be deducted :");
        int amount= in.nextInt();
        AccountPublisher accountPublisher = context.getBean(AccountPublisher.class);



        if(employeeDaoIml.withdraw_balance(account,amount))
          {


              AccountEvent accountEvent = new AccountEvent(account,"withdraw");

              accountPublisher.publish(accountEvent);
              System.out.println("Amount debited :"+amount);}

          else
          {
              System.out.println("Cannot deduct balance.. or insufficient balance");
          }
    }


    private static void depositCash(ClassPathXmlApplicationContext context) {


        Account account=new Account();

        Scanner in = new Scanner(System.in);

        EmployeeDaoIml employeeDaoIml = (EmployeeDaoIml) context.getBean(EmployeeDaoIml.class);

        boolean ispresent;

        do {


            System.out.println("Enter  account number");

            Integer acc__num;

            acc__num = in.nextInt();

            System.out.println("Enter account pin");

            Integer pin = in.nextInt();

            account.setAcc_num_Account(acc__num);

            account.setPin_Account(pin);




            ispresent=  employeeDaoIml.check_Account_Exist(account);

            if(!(ispresent))
            {
                System.out.println("Invalid account number or pin....Try again");

            }

        }while (!(ispresent));

        System.out.println("Enter amount to be credited :");

        int amount= in.nextInt();

        AccountPublisher accountPublisher = context.getBean(AccountPublisher.class);



        if(employeeDaoIml.deposit_balance(account,amount))
        {
            AccountEvent accountEvent = new AccountEvent(account,"deposit");

            accountPublisher.publish(accountEvent);
            System.out.println("Amount credited :"+amount);}

        else
        {
            System.out.println("Cannot credit amount due to some technical error");
        }
    }


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");


        String option;


        do {


        System.out.println("SELECT FROM THE OPTIONS");
        System.out.println("1. Add an Employee");
        System.out.println("2. Change pin");
            System.out.println("3.Change mobile number");
        System.out.println("4. Withdraw Cash");
        System.out.println("5. Deposit Cash");
        System.out.print("Enter choice :");
        Scanner in =new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice)
        {case 1:  InsertEmployeeRecord(context);
                          break;

            case 2: changePin(context);
            break;
            case 3: changeNumber(context);
                     break;

            case  4: withdrawCash(context);
                 break;
            case 5: depositCash(context);
        }

            System.out.println("Do u want to continue? (Y/N)");
            option= in.next();



        }while(option.equals("y")||option.equals("Y"));

    }




}
