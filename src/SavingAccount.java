class SavingAccount extends Account
{
	public double interestRate=10;
	public SavingAccount(String name, int ID, double amount)
	{
		super(name, ID, amount);
	}
	
	void deposit(double v)
	{
		amount = amount - v;
	}
	
	void withdraw(double v)
	{
		amount = amount + v;
	}
	public double getInterest()
	{
		return (this.amount/100*interestRate);
	}
	
	public String myacc()
	{
		return name + "   " + ID + "   " + amount + "   " + "2";
	}
}

