import java.util.*;
import java.io.*;
			
class LoadAndSave
{	
	public ArrayList <Account> load() throws IOException
	{		
		ArrayList <Account> info = new ArrayList <Account> ();
				
		FileInputStream fstream = new FileInputStream("accs.txt");
		BufferedReader rf = new BufferedReader(new InputStreamReader(fstream));
		
		String strline;				
		while((strline=rf.readLine())!=null)
		{
			String [] hudai = strline.split("   ");
			
			String name = hudai[0];
			int id = Integer.parseInt(hudai[1]);
			double amount = Double.parseDouble(hudai[2]);
			int type = Integer.parseInt(hudai[3]);
						
			if(type==1)
			{
				Account acc = new CurrentAccount(name,id,amount);
				info.add(acc);
			}			
			else
			{
				Account acc = new SavingAccount(name,id,amount);
				info.add(acc);
			}
		}		
		
		rf.close();
		
		return info;
	}		
	
	public void save(ArrayList <Account> info) throws IOException
	{		
		FileOutputStream wstream = new FileOutputStream("accs.txt");
		BufferedWriter wf = new BufferedWriter(new OutputStreamWriter(wstream));
			
		for(int i=0; i<info.size(); i++)
		{	
			wf.write(info.get(i).myacc()+"\n");
		}	
		wf.close();
	}
}			
