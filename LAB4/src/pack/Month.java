package pack;

import static pack.DAY_OF_THE_WEEK.Понедельник;
import static pack.DAY_OF_THE_WEEK.Вторник;
import static pack.DAY_OF_THE_WEEK.Среда;
import static pack.DAY_OF_THE_WEEK.Четверг;
import static pack.DAY_OF_THE_WEEK.Пятница;
import static pack.DAY_OF_THE_WEEK.Суббота;
import static pack.DAY_OF_THE_WEEK.Воскресенье;

public class Month {
    private int number;
    private Data[] days;
    private String month;

    public Month(String m, int n) {
        number = n;
        month = m;
        days = new Data[number];

        DAY_OF_THE_WEEK day = Понедельник;

        for (int i = 0; i < n; i++) {
            int a = i  % 7;

            if (a == 0)
                day = Понедельник;
            if (a == 1)
                day = Вторник;
            if (a == 2)
                day = Среда;
            if (a == 3)
                day = Четверг;
            if (a == 4)
                day = Пятница;
            if (a == 5)
                day = Суббота;
            if (a == 6)
                day = Воскресенье;

            days[i] = new Data(i+1, day);
        }
    }

    public void findByDayOfTheWeek(DAY_OF_THE_WEEK d) {
        int D = 0;
        System.out.println("День недели для поиска:"+d);
        System.out.print("Найденные дни :");

        for (int i = 0; i < number; i++) {
            if (days[i].day_of_the_week == d) {
                D = days[i].day;
                System.out.print(D+" ");
            }
        }

    }

    public void findByDay(int f) {
        DAY_OF_THE_WEEK q = null;
        for (int i = 0; i < number; i++) {
            if (days[i].day == f) {
                q = days[i].day_of_the_week;
            }
        }
        System.out.println("Число для поиска:"+f);
        System.out.print("Найденный день недели:"+q);
    }

    public void print() {
        System.out.println(month);
        for (int i = 0; i < number; i++) {
            System.out.print(days[i].day+" ");
            System.out.print(days[i].day_of_the_week);
            System.out.print(';');
        }
        System.out.println(" ");
    }
}
