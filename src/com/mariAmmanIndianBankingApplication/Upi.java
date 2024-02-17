package com.mariAmmanIndianBankingApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


interface Gpay 
{
	void withDrawl(List<Account> l , List <Upi> u);
	public void checkBalance(List<Account> l , List <Upi> u);
}

interface PayTym
{
	void withDrawl(List<Account> l , List <Upi> u);
	public void checkBalance(List<Account> l , List <Upi> u);
}

interface PhonePay
{
	void withDrawl(List<Account> l , List <Upi> u);
	public void checkBalance(List<Account> l , List <Upi> u);
}

public class Upi implements Gpay , PayTym ,PhonePay
{
	String phoneNum ;
	int upiPassword;
	
	Upi(String phoneNum ,int upiPassword)
	{
		this.phoneNum = phoneNum;
		this.upiPassword = upiPassword;
	}

	
	Scanner s = new Scanner(System.in);
	
	
	public void withDrawl(List<Account> l , List <Upi> u)
	{	
		System.out.println("ENTER PHONE NUMBER FOR LOGIN ");
		String PHONENUM = s.next();
		
		double accBalance = 0.0;
		String accPhNum = "";
		String upiPhNum = "";
		int upiPass = 0;
		double newbalance = 0.0;		
		String accPassword = "";
		String accName = "";
		int accNum = 0;
		
		boolean rs = false;	
			
		
		for(Account x : l)
		{
			if(x.phoneNum.equals(PHONENUM))
			{
				accPhNum = x.phoneNum;
				accBalance = x.accBalance;
			    accPassword = x.password;
				accName = x.name;
				accNum = x.accno;
				rs = true;
				
			} 
		}
		
		if(rs)	
		{
			for(Upi y : u)
			{
				if(y.phoneNum.equals(PHONENUM))
				{
					upiPhNum = y.phoneNum;
					upiPass = y.upiPassword;				
				}
			}
			
			
			if(accPhNum.equals(upiPhNum))
			{
				System.out.println("ENTER PASSWORD");
				int UPIPASS = s.nextInt();
				
				if( UPIPASS == upiPass)
				{
					System.out.println("ENTER AMOUNT TO BE WITHDRAWLED ");
					double AMT = s.nextDouble();
					
					System.out.println("ENTER PAY NUMBER ");
					String PAYNUM = s.next();
					
					
					double DaccBalance = 0.0;
					String DaccPhNum = "";		
					String DaccPassword = "";
					String DaccName = "";
					int DaccNum = 0;
					double DnewBalance = 0.0;
					int Dindex = 0;
					
					for(Account z : l)
					{
						if(z.phoneNum.equals(PAYNUM))
						{
							DaccPhNum = z.phoneNum;
							DaccBalance = z.accBalance;
						    DaccPassword = z.password;
							DaccName = z.name;
							DaccNum = z.accno;
							Dindex = l.indexOf(z);
						}
					}
					
					if(AMT <= accBalance)
					{
						newbalance = accBalance-AMT;
						System.out.println("AMOUNT "+AMT+" SUCESSFULLY TRANSFERED TO "+DaccName);
						System.out.println("YOUR CURRENT BALANCE IS "+newbalance+" RS");
						
						int index = 0;
						
						for(Account z :l)
						{
							if(PHONENUM.equals(z.phoneNum))
							{
								index = l.indexOf(z);
							}
						}
						
						Account T = new Account(accName ,accPhNum ,accNum, accPassword , newbalance);
						l.set(index, T);
						
						DnewBalance = DaccBalance+AMT;					
								
						Account D = new Account(DaccName ,DaccPhNum ,DaccNum, DaccPassword , DnewBalance);
						l.set(Dindex, D);
						
						
						
						
						
					}
					else
						System.out.println("INSUFFICIENT BALANCE IN YOUR ACCOUNT");
				
				}
				else
					System.out.println("ENTER APPROPRIATE DETAILS");			
			} 
		}
		
		else 
		{
			System.out.println("THIS NUMBER IS NOT LOGGED IN WITH THE DEVICE");
		} 		
	}
	

	
	public void checkBalance(List<Account> l , List <Upi> u)
	{
		System.out.println("ENTER PHONE NUMBER");
		String PHONENUM = s.next();
		
		System.out.println("ENTER PASSWORD");
		int PASSWORD = s.nextInt();
		
		String accPhNum = "";
		double balance = 0.00;
		int password = 0;
		
		for(Account x : l)
		{
			if(x.phoneNum.equals(PHONENUM))
			{
				accPhNum = x.phoneNum;
				balance = x.accBalance;	
			} 
		}
		
		for(Upi U  : u)
		{
			if(U.upiPassword == PASSWORD )
			{
				password = U.upiPassword;
			}
		}
		
		if(password  == PASSWORD)
		{
			System.out.println("YOUR CURRENT BALANCE IS = "+balance+" RS");	
		}
		
		else
			System.out.println("WRONG PASSWORD");
		
	}	
	
}
