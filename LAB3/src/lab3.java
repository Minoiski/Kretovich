import java.util.Scanner;
import java.util.Random;
public class lab3
{
    public static void main(String[] args)
    {
        int n;
        Scanner in=new Scanner(System.in);
        System.out.println("Введите n:");
        n=in.nextInt();
        if(n<=1)
        {
            System.err.print("Неправильное число!");
            System.exit(1);
        }
        int [][]mas=new int [n][n];
        Random r=new Random();
        r.setSeed(System.currentTimeMillis() );

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int help=r.nextInt();
                mas[i][j]=help%(n+1);
                System.out.printf("%4d",mas[i][j]);
            }
            System.out.println();

        }
        System.out.println();

        System.out.println("Введите 1 - поворот на 90, 2 - на 180, 3-на 270");
        int m;
        m=in.nextInt();

        while(m!=0)
        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int mr=mas[i][j];
                    mas[i][j]=mas[j][i];
                    mas[j][i]=mr;}}

            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n; j++) {
                    int pr=mas[i][j];
                    mas[i][j]=mas[n-i-1][j];
                    mas[n-i-1][j]=pr;}}
            m--;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.printf("%4d",mas[i][j]);
            }
            System.out.println();

        }
    }
}
