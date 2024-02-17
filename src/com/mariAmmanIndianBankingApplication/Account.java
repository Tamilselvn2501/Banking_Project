package com.mariAmmanIndianBankingApplication;

import java.util.List;
import java.util.Scanner;

public class Account 
{
	static String bank = "MARIAMMAN INDIAN BANK";
	String name ;
	String phoneNum;
	int accno ;
	String password;
	double accBalance;
	
	Account(String name ,String phoneNum, int accno ,String password ,double accBalance)
	{
		this.name = name;
		this.phoneNum = phoneNum;
		this.accno = accno;
		this.password = password;
		this.accBalance = accBalance;
	}
	
	Scanner s = new Scanner(System.in);
	
	
	void withDrawl(List<Account> l)
	{
		System.out.println("ENTER YOUR ACCOUNT NUMBER - ");
		int ACCNO = s.nextInt();
		
		System.out.println("ENTER PASSWORD - ");
		String PASSWORD = s.next();
		
		String peru = "";
		int number = 0;
		double balance = 0.0;
		String secret = ""; 
		
		double newbalance = 0.0;
		String phn = "";
		
		int index = 0;
		
		for(Account x : l)
		{
			if(x.accno == ACCNO)
			{
				secret = x.password;
				number = x.accno;
				balance = x.accBalance;
				peru=x.name;
				phn = x.phoneNum;
			}
		}
		
		if(number == ACCNO && secret.equals(PASSWORD))
		{
			System.out.println("WELCOME "+peru);
			
			
			System.out.println("FYI - ");
			System.out.println("MINIMUN RS 500 HAS TO BE WITHDRAWLED ");
			System.out.println("AND ");
			System.out.println("AMOUNT HAS TO BE MULTIPLES OF 500 RS ONLY ");
			System.out.println();
			System.out.println("ENTER THE AMOUNT TO WITHDRAWL - ");
			double AMOUNT = s.nextDouble();
			
			if(AMOUNT >= 500 && AMOUNT%500 == 0)
			{
			
				if(balance >= AMOUNT)
				{
					newbalance = balance-AMOUNT;
					System.out.println("RS "+AMOUNT+" SUCESSFULLY WITHDRAWLED FROM YOUR ACCOUNT");
					System.out.println("YOUR CURRENT BALANCE IS "+newbalance+" RS");
					
					for(Account i : l)
					{
						if(number == i.accno)
							index = l.indexOf(i);
					}
					
					Account a = new Account(peru,phn, ACCNO, secret, newbalance);
					l.set(index, a);					
				}
				else
					System.out.println("IN SUFFICIENT BALANCE IN YOUR CURRENT ACCOUNT");
			}
			
			else
			{
				System.out.println("MINIMUN RS 500 HAS TO BE WITHDRAWLED ");
				System.out.println("AND ");
				System.out.println("AMOUNT HAS TO BE MULTIPLES OF 500 RS ONLY ");
				System.out.println("PLEASE TRY AGAIN ");
			}
				
			
					
		}
		else
		{
			System.out.println("please enter the correct details");
		}
	}
	
	
	void deposit(List<Account> l)
	{
		System.out.println("ENTER YOUR ACCOUNT NUMBER - ");
		int ACCNO = s.nextInt();
		
		System.out.println("ENTER PASSWORD - ");
		String PASSWORD = s.next();
		
		String peru = "";
		int number = 0;
		double balance = 0.0;
		String secret = ""; 
		int index = 0;
		double newbalance = 0.0;
		String phn = "";
		
		for(Account x : l)
		{
			if(x.accno == ACCNO)
			{
				secret = x.password;
				number = x.accno;
				balance = x.accBalance;
				peru=x.name;
				phn = x.phoneNum;
			}
		}
		
		if(number == ACCNO && secret.equals(PASSWORD))
		{
			System.out.println("WELCOME "+peru);
			
			System.out.println("ENTER THE AMOUNT TO DEPOSIT - ");
			double AMOUNT = s.nextDouble();
			
			newbalance = balance+AMOUNT;
			System.out.println("RS "+AMOUNT+" SUCESSFULLY DEPOSITED IN YOUR ACCOUNT");
			System.out.println("YOUR CURRENT BALANCE IS "+newbalance+" RS");	
			
			for(Account i : l)
			{
				if(number == i.accno)
					index = l.indexOf(i);
			}
			
			Account a = new Account(peru, phn, ACCNO, secret, newbalance);
			l.set(index, a);	
		}
		else
		{
			System.out.println("please enter the correct details");
		}
	}
	
	void checkBalance(List<Account> l)
	{
		System.out.println("ENTER ACCOUNT NUMBER ");
		int ACCNO = s.nextInt();
		
		System.out.println("ENTER PASSWORD");
		String PASSWORD = s.next();
		
		String peru = "";
		String secret = "";
		double balance = 0.0;
		int num = 0;
		
		for(Account x : l)
		{
			if(x.accno == ACCNO)
			{
				peru = x.name;
				secret = x.password;
				balance = x.accBalance;
				num = x.accno;
			}			
		}
		
		if(num == ACCNO && PASSWORD.equals(secret))
		{
			System.out.println("YOUR CURRENT BALANCE IS "+balance+" RS");
		}
	}
}

