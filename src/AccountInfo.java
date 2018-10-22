import java.util.*;

class AccountInfo
{
	Scanner scan = new Scanner(System.in);
	int choice = 0;
	String name, tmp;
	int ID = 100000;
	double v;
	public ArrayList <Account> info;
	
	public AccountInfo()
	{
		info = new ArrayList <Account> ();
		LoadAndSave tmp = new LoadAndSave();		
		
		try
		{
			info = tmp.load();
		}
		catch(Exception e)
		{
			new AllExceptions(e);
		}
		
		if(info.size()!=0)	ID = info.get(info.size()-1).getID();
		make();
		printAll();
		
		try
		{
			tmp.save(info);
		}
		catch(Exception e)
		{
			new AllExceptions(e);
		}
	}
	
	public void make()
	{	
		while(true)
		{
			try
			{
			   System.out.println("Choose an option:\n1.Current Account\n2.Saving Account\n3.Existed Account\n4.exit");		
				choice = scan.nextInt();
				tmp = scan.nextLine();
					
				if(choice == 1)
				{	
					Account acc = new CurrentAccount(null, 0, 0);
					System.out.println("Enter name");
					name = scan.nextLine();
					acc.setName(name);
					ID++;
					acc.setID(ID);
					
					int chs = 0;
					while(true)
					{
						try
						{
							System.out.println("Press 1 for withdraw, 2 for deposit,3 for see, 4 for exit");
							chs = scan.nextInt();
							tmp = scan.nextLine();
						
							if(chs==1)
							{
								System.out.println("Enter value");
								v=scan.nextDouble();
								acc.withdraw(v);
							}					
						
							else if(chs==2)
							{
								System.out.println("Enter value");
								v=scan.nextDouble();
								if(v>acc.getAmount())
									System.out.println("exided amount. total amount is " + acc.getAmount());
								else acc.deposit(v);
							}
							
							else if(chs==3)
							{
								System.out.println(acc.table());
							}
							
							else if(chs==4)
							{
								info.add(acc);
								break;
							}
						}catch(InputMismatchException e)
						{
							System.out.println("Wrong input. Enter an integer");
							scan.next();
						}
					}								
				}	
			
				else if(choice == 2)
				{	
					
					Account scc = new SavingAccount(null, 0, 0);
					System.out.println("Enter name");
					name = scan.nextLine();
					scc.setName(name);
					ID++;
					scc.setID(ID);
					
					int chs = 0;
					
					while(true)
					{
						try
						{
							System.out.println("Press 1 for withdraw, 2 for deposit, 3 for see, 4 for exit");
							chs = scan.nextInt();
							tmp = scan.nextLine();
						
							if(chs==1)
							{
								System.out.println("Enter value");
								v=scan.nextDouble();
								scc.withdraw(v);
							}					
						
							else if(chs==2)
							{
								System.out.println("Enter value");
								v=scan.nextDouble();
								if(v>scc.getAmount())
									System.out.println("exided amount. total amount is " + scc.getAmount());
								else scc.deposit(v);
							}
						
							else if(chs==3)
							{
								System.out.println(scc.table());
							}
							
							else if(chs==4)
							{
								info.add(scc);
								break;
							}
						
						}catch(InputMismatchException e)
						{
							System.out.println("Wrong input. Enter an integer");
							scan.next();
						}
					}			
				}	
				else if(choice == 3)
				{	
					System.out.println("Enter ID number");
					ID = scan.nextInt();
					
					int index=0;	
					while(true)
					{
						if(info.get(index).ID == ID)	
							break;
						index++;
					}
					
					int chs = 0;					
					while(true)
					{
						try
						{
							System.out.println("Press 1 for withdraw, 2 for deposit, 3 for see, 4 for exit");
							chs = scan.nextInt();
							tmp = scan.nextLine();
						
							if(chs==1)
							{
								System.out.println("Enter value");
								v=scan.nextDouble();
								info.get(index).withdraw(v);
							}					
						
							else if(chs==2)
							{
								System.out.println("Enter value");
								v=scan.nextDouble();
								if(v>info.get(index).getAmount())
									System.out.println("exided amount. total amount is " + info.get(index).getAmount());
								else info.get(index).deposit(v);
							}
						
							else if(chs==3)
							{
								System.out.println(info.get(index).table());
							}
							
							else if(chs==4)
							{
								break;
							}
						
						}catch(InputMismatchException e)
						{
							System.out.println("Wrong input. Enter an integer");
							scan.next();
						}
					}			
				}
				else if(choice == 4)
				{
					break;
				}
			}catch(InputMismatchException e)
			{
				System.out.println("Wrong input. Enter an integer");
				scan.next();
			}
		}
	}
	public void printAll()
	{
		System.out.println("Do you want to see all Accounts?\nPress 1 for Yes, 2 for No");
		Scanner scan = new Scanner(System.in);
		int ch = scan.nextInt();
		if(ch==1)
			for(int i=0; i<info.size(); i++)	System.out.println(info.get(i).table());		
	}
}

