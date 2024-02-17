package com.mariAmmanIndianBankingApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MainClass 
{
	public static void main(String[] args)
	{
		List <Account> L = new ArrayList();
		
		L.add(new Account("RAM","7401326676",7401,"7401",5000.00));
		L.add(new Account("ARAVIND","9710127528",9710,"9710",15000.00));
		L.add(new Account("SURYA","9841126167",9841,"9841",4000.00));
		
		List <Upi> U = new ArrayList();
		
		U.add(new Upi("7401326676", 6676));
		U.add(new Upi("9710127528", 7528));
		U.add(new Upi("9841126167", 6167));	
		
		
		
		Scanner sc = new Scanner(System.in);
		
		boolean  user = true;
		
		while(user)
		{
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println();
			
			
			System.out.println(" 1 - ATM / 2 - UPI   ");
			
			
			
			int opt = sc.nextInt();
			 
			switch (opt) 
			{
			case 1 :
			{
				System.out.println("WELCOME TO "+Account.bank);
				
				System.out.println("SELECT OPTIONS TO BE PERFORMED");
				System.out.println("1 - DEPOSIT / 2 - WITHDRAWL / 3 - CHECKBALANCE ");
				int op = sc.nextInt();
				
				if(op == 1)
				{
					Account a = new Account(null, null, 0, null, 0.00);
					a.deposit(L);
				}
				else if (op == 2)
				{
					Account a = new Account(null, null, 0, null, 0.00);
					a.withDrawl(L);
				}
				else if (op ==3)
				{
					Account a = new Account(null, null, 0, null, 0.00);
					a.checkBalance(L);
				}
				else
				{
					System.out.println("ENTER APPROPRIATE OPTION");
				}			
			}
			break; 
			
			case 2 :
			{
				
				System.out.println("SELECT UPI MODE");
				System.out.println("1 - GPAY / 2 - PAYTYM / 3 - PHONEPAY");
				
				int upiOpt = sc.nextInt();
				
				switch (upiOpt)
				{
				case 1 :
				{
					System.out.println("WELCOME TO G PAY");
					System.out.println("SELECT OPTIONS TO BE PERFORMED");
					System.out.println("1 - TRANSFER AMOUNT / 2 - CHECKBALANCE " );
					int op = sc.nextInt();
					
					
					if (op == 1)
					{
						Upi u = new Upi(null,0);
						u.withDrawl(L, U);
						
					}
					else if (op == 2 )
					{
						Upi u = new Upi(null,0);
						u.checkBalance(L, U);
						
					}
					
					else
					{
						System.out.println("ENTER APPROPRIATE OPTION");
					}		
				}
				break;
				
				case 2 :
				{
					System.out.println("WELCOME TO PAY TYM");
					System.out.println("SELECT OPTIONS TO BE PERFORMED");
					System.out.println("1 - TRANSFER AMOUNT / 2 - CHECKBALANCE ");
					int op = sc.nextInt();
					
					
					if (op == 1)
					{
						Upi u = new Upi(null,0);
						u.withDrawl(L, U);
						
					}
					else if (op == 2 )
					{
						Upi u = new Upi(null,0);
						u.checkBalance(L, U);
						
					}
					else
					{
						System.out.println("ENTER APPROPRIATE OPTION");
					}		
				}
				break;
				case 3 :
				{
					System.out.println("WELCOME TO PHONE PAY");
					System.out.println("SELECT OPTIONS TO BE PERFORMED");
					System.out.println("1 - TRANSFER AMOUNT / 2 - CHECKBALANCE ");
					int op = sc.nextInt();
					
					
					if (op == 1)
					{
						Upi u = new Upi(null,0);
						u.withDrawl(L, U);
						
					}
					else if (op == 2 )
					{
						Upi u = new Upi(null,0);
						u.checkBalance(L, U);
						
					}
					else
					{
						System.out.println("ENTER APPROPRIATE OPTION");
					}		
				}
				break;
				}
				
					
			}
			break;
			
			default :
			{
				System.out.println("ENTER APPROPRIATE OPTION");
			}
			
			}
		}
			
	}
}

