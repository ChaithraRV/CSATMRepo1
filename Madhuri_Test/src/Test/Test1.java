package Test;

public class Test1
{

	
	public static void main(String[] args)
	{
		int p[][] = {{1,2,3},{4,5,6},{7,8,9}};
		for(int []i : p)
		{
			for(int j : i)
			{
				System.out.print(j +" ");
			}
			
			System.out.print('\n');
			System.out.print('\n');
		}
		
}
}