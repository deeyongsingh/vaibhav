import java.util.Scanner;
public class Student{
    public static void main(String[]args){
        System.out.println("to take number from user");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter first number");
        int a=sc.nextInt();
        System.out.println("enter your second number");
        int b=sc.nextInt();
        int sum=a+b;
        System.out.println("the sum of these number is");
        System.out.println(sum);
    }
}