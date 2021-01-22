//wholesale retailer and bill generation
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
class Billprocess
{
	Scanner s = new Scanner(System.in);
	int n=1,item,p,sv;
	String name,shopname;
	float pepsi=120;
	float sevenup=130;
	boolean choice = true;
	float pe,sev,totamount;
	String item1="pepsi",item2="sevenup";
	public void fnOrder()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter your Name :");
			name = s.nextLine();
			System.out.println("Enter your Shop Name :");
			shopname = s.nextLine();
			while(choice == true)
			{
				System.out.println("***Our items***");
				System.out.println("1.pepsi 1 lt (1box = 24 bottles)");
				System.out.println("2.sevenup 1 lt (1box = 24 bottles)");
				System.out.println("3.exit");
				item = s.nextInt();
				if(item == 1)
				{
					System.out.println("Enter number of pepsi boxs :");
					p += s.nextInt();
				}
				else if(item == 2)
				{
					System.out.println("Enter number of sevenup boxs :");
					sv += s.nextInt();
				}
				else
					choice = false;
					
			}
			
		}
	}
	public void fnCal()
	{
		pe = pepsi * (float)p;
		sev = sevenup * (float)sv;
		totamount = pe + sev;
		System.out.println(totamount);
	}
	public void fnBillgenerate()
	{
		try
		{
			
			FileWriter fw = new FileWriter("bill.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			Date today = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
			SimpleDateFormat formatter1 = new SimpleDateFormat("h:mm a");
			fw.write("  				***J.D Whole Sale Market***				 ");
			fw.write("\n");
			fw.write("Date: " + formatter.format(today));
			fw.write("\n");
			fw.write("Time: " + formatter1.format(today));
			fw.write("\n");
			fw.write("\n");
			fw.write("Residence number: 033 2522 - 4738");
			fw.write("\n");
			fw.write("Office number: 033 2521-5254");
			fw.write("\n");
			fw.write("Office Address: 175/A Laketown, Block - A, Kolkata- 700054");
			fw.write("\n");
			fw.write("***************************************************************************************************************");
			fw.write("\n");
			fw.write("s.no"+"		"+"Shopname"+"		"+"ownername"+"	"+"item"+"		"+"quantity"+"		"+"amount");
			fw.write("\n");
			fw.write(n+"		"+shopname+"		"+name+"		"+item1+"		"+p+"		"+pe);
			fw.write("\n");
			fw.write("\n");
			fw.write(n+"		"+shopname+"		"+name+"		"+item2+"		"+sv+"		"+sev);
			fw.write("\n");
			fw.write("***************************************************************************************************************");
			fw.write("\n");
			fw.write("total amount"+"									"+totamount);
			fw.write("\n");
			fw.write("***************************************************************************************************************");
			fw.write("\n");
			fw.write("\n");
			fw.close();
		}
		catch(IOException e)
		{
		  e.printStackTrace();
		}
	}
	public void PrintAllBill()
	{
		try{
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream fin = new FileInputStream("bill.txt");
		while(true)
		{
			int i = fin.read();
			if(i==-1)
				break;
			System.out.print((char)i);
		}
		fin.close();
		}
		catch(IOException e)
		{
		  e.printStackTrace();
		}
	}
	
}
public class Bill
{
	public static void main(String as[])
	{
		Scanner s = new Scanner(System.in);
		Billprocess b1 = new Billprocess();
		b1.fnOrder();
		b1.fnCal();	
		b1.fnBillgenerate();
		b1.PrintAllBill();
	}
}

