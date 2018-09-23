import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Lab2
{

	public static int min(int a, int b, int c, int d,int k)
	{
      return min(a, min(b, min(c,min(d,k))));
    }

  public static int min(int a, int b)
  {
  	if(a==-1)
  		return b;
  	if(b==-1)
  		return a;
      return a > b ? b : a;
  }

  public static int max(int a, int b, int c, int d)
  {
      return max(a, max(b, max(c,d)));
  }

  public static int max(int a, int b)
  {
      return a < b ? b : a;
  }

	public static void main(String[] args)
	{
		try {
			Scanner in = new Scanner(new File("C:\\Users\\Евгений\\IdeaProjects\\LAB2\\src\\text.txt"));
			Scanner in_= new Scanner(System.in);

		while(in.hasNextLine())
		{
			String s=in.nextLine();
			int step=0;
			int i_z=0;
			int i_1=0;
			int i_2=0;
			int i=s.indexOf('x');
			int x;
			System.out.print("Введите x: ");
			x=Integer.parseInt(in_.nextLine());
			if(i!=-1)
				s=s.substring(0,i)+x+s.substring(i+1);
			while((i_z=s.indexOf('*'))!=-1)
			{
				i_1=max(s.lastIndexOf('*',i_z-1),s.lastIndexOf('/',i_z),s.lastIndexOf('+',i_z),s.lastIndexOf('-',i_z));
				i_2=min(s.indexOf('*',i_z+1),s.indexOf('/',i_z),s.indexOf('+',i_z),s.indexOf('-',i_z),s.indexOf('=',i_z));
				System.out.println(s.substring(i_1+1,i_z)+"*"+s.substring(i_z+1,i_2));
				step=Integer.parseInt(s.substring(i_1+1,i_z))*Integer.parseInt(s.substring(i_z+1,i_2));
				s=s.substring(0,i_1+1)+Integer.toString(step)+s.substring(i_2);
			}
			while((i_z=s.indexOf('/'))!=-1)
			{
				i_1=max(s.lastIndexOf('*',i_z),s.lastIndexOf('/',i_z-1),s.lastIndexOf('+',i_z),s.lastIndexOf('-',i_z));
				i_2=min(s.indexOf('*',i_z),s.indexOf('/',i_z+1),s.indexOf('+',i_z),s.indexOf('-',i_z),s.indexOf('=',i_z));
				System.out.println(s.substring(i_1+1,i_z)+"/"+s.substring(i_z+1,i_2));
				step=Integer.parseInt(s.substring(i_1+1,i_z))/Integer.parseInt(s.substring(i_z+1,i_2));
				s=s.substring(0,i_1+1)+Integer.toString(step)+s.substring(i_2);
			}
			while((i_z=s.indexOf('+'))!=-1)
			{
				i_1=max(s.lastIndexOf('*',i_z),s.lastIndexOf('/',i_z),s.lastIndexOf('+',i_z-1),s.lastIndexOf('-',i_z));
				i_2=min(s.indexOf('*',i_z),s.indexOf('/',i_z),s.indexOf('+',i_z+1),s.indexOf('-',i_z),s.indexOf('=',i_z));
				System.out.println(s.substring(i_1+1,i_z)+"+"+s.substring(i_z+1,i_2));
				step=Integer.parseInt(s.substring(i_1+1,i_z))+Integer.parseInt(s.substring(i_z+1,i_2));
				s=s.substring(0,i_1+1)+Integer.toString(step)+s.substring(i_2);
			}
			while((i_z=s.indexOf('-'))!=-1)
			{
				i_1=max(s.lastIndexOf('*',i_z),s.lastIndexOf('/',i_z),s.lastIndexOf('+',i_z),s.lastIndexOf('-',i_z-1));
				i_2=min(s.indexOf('*',i_z),s.indexOf('/',i_z),s.indexOf('+',i_z),s.indexOf('-',i_z+1),s.indexOf('=',i_z));

				System.out.println(s.substring(i_1+1,i_z)+"-"+s.substring(i_z+1,i_2));

				step=Integer.parseInt(s.substring(i_1+1,i_z))-Integer.parseInt(s.substring(i_z+1,i_2));
				s=s.substring(0,i_1+1)+Integer.toString(step)+s.substring(i_2);
			}
			s=s.substring(0,s.length()-1);
			System.out.println("Ответ:"+s);
		}
			in.close();
		}
		catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	}