import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tmp {
	public static void main(String [] args) throws IOException
	{
		FileInputStream fstream = new FileInputStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				
		String par="";
		String strline="";
		
		while((strline=br.readLine()) != null)
		{
			String [] arr = strline.split(" ");
			//par = par + strline + "\n";
			for(int i=0; i<arr.length; i++)	System.out.println(arr[i]);
		}
		br.close();

		//FileOutputStream wstream = new FileOutputStream("output.txt");
		//BufferedWriter wf = new BufferedWriter(new OutputStreamWriter(wstream));
		
		//wf.write(par);
		//for(int i=0; i<10; i++)
		//{
		//	wf.write("rabbi\n");
		//}
		//wf.close();
	}
}

