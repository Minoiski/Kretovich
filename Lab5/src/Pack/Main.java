package Pack;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main
{


    public static void main(String[] args)
    {
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());

        System.out.println("_____Треугольники_____");
        IsoscelesTriangle[] triangles = new IsoscelesTriangle[8];
        for (int i = 0; i < 7; ++i)
        {
            triangles[i] = new IsoscelesTriangle(Math.abs(rnd.nextInt()) %30,Math.abs(rnd.nextInt())%180);
            System.out.println(triangles[i].toString());
        }
        System.out.println();


        System.out.println("_____triangles[1].setA_B(5)_____");
        triangles[1].setA_B(5);
        System.out.println(triangles[1]);
        System.out.println();


        System.out.println("_____Тестируем_конструктор(String)_____");
        triangles[7] = new IsoscelesTriangle("9,90");
        System.out.println(triangles[7].toString());
        System.out.println();

        System.out.println("_____Сортировка_по_углам_____");
        Arrays.sort(triangles, new IsoscelesTriangle.CompareAngles());
        for (int i = 0; i < 8; ++i)
            System.out.println(triangles[i].toString());
        System.out.println("\n");


        System.out.println("_____compareTo_____");
        System.out.println(triangles[5].toString());
        System.out.println(triangles[6].toString());
        if (triangles[5].compareTo(triangles[6]) == -1)
            System.out.println("Первый меньше!");
        else if (triangles[5].compareTo(triangles[6]) == 1)
            System.out.println("Первый больше!");
        else
            System.out.println("Они равны!");
        System.out.println();

        System.out.println("_____Сортируем_по_стороне_А_____");
        Arrays.sort(triangles, new IsoscelesTriangle.CompareA());
        for (int i = 0; i < 8; ++i)
            System.out.println(triangles[i].toString());
        System.out.println("\n");

        System.out.println("_____Площадь_и_периметр_____");
        System.out.println("Что считаем: " + triangles[0].toString());
        System.out.print("Площадь: ");
        System.out.printf("%6.2f\n", triangles[0].area());
        System.out.print("Периметр: ");
        System.out.printf("%6.2f", triangles[0].perimetr());
        System.out.println("\n");


        System.out.println("_____Iterator: next, hasNext_____");
        int count = 1;
        while (triangles[2].hasNext())
        {
            System.out.printf("#%d поле: %6.2f\n", count++, triangles[2].next());
        }

        System.out.println();
        System.out.println("_____Iterable: foreach_____");
        for (IsoscelesTriangle triangle:triangles)
        {
            for(Double side : triangle)
            {
                System.out.println(side);
            }
        }
    }
}
