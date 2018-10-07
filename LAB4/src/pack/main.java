package pack;

import static pack.DAY_OF_THE_WEEK.Понедельник;
import static pack.DAY_OF_THE_WEEK.Вторник;
import static pack.DAY_OF_THE_WEEK.Среда;
import static pack.DAY_OF_THE_WEEK.Четверг;
import static pack.DAY_OF_THE_WEEK.Пятница;
import static pack.DAY_OF_THE_WEEK.Суббота;
import static pack.DAY_OF_THE_WEEK.Воскресенье;

public class main {
    public static void main(String[] args) {
        Month A = new Month("Январь", 31);
       // A.print();
        Month B = new Month("Февраль", 28);
        //B.print();
        Month C = new Month("Март", 31);
        //C.print();
        Month D = new Month("Апрель", 30);
       // D.print();
        Month E = new Month("Май", 31);
        //E.print();
        System.out.println(" ");
        A.findByDay(20);
        System.out.println(" ");
        A.findByDayOfTheWeek(Понедельник);
        Month [] Year=new Month[12];
        Year[0]=A;
        Year[1]=B;
        Year[2]=C;
        Year[3]=D;
        Year[4]=E;
        for(int i=0;i<5;i++)
        {
            Year[i].print();
        }
    }
}
