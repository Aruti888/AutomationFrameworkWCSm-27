package Vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = add(40, 30);
		System.out.println(c);
	}
	
	public static int add (int a, int b) //Generic
	{
		int sum = a+b; //actions
		return sum;
	}

}
