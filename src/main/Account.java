package main;

abstract class Account
{
    public String name;
    public int ID;
    public double amount;

    public Account(String name, int ID, double amount)
    {
        this.name = name;
        this.ID = ID;
        this.amount = amount;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getID()
    {
        return this.ID;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public String table()
    {
        return "name: " + name + "  Id: " + ID + "  Amount: " + amount;
    }

    abstract String myacc();
    abstract void deposit(double v);
    abstract void withdraw(double v);
}
