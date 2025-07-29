package Array;
import java.util.Scanner;
public class TwoDArrayExample {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("enter your row size:");
        int rows= scanner.nextInt();
        System.out.println("enter your column size:");
        int columns=scanner.nextInt();

        int[][] arr = new int[rows][columns];
        System.out.println("enter your elements:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]= scanner.nextInt();
            }
        }
        System.out.println("2D array are :");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
