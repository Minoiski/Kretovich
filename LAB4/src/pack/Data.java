package pack;

enum DAY_OF_THE_WEEK { Понедельник, Вторник, Среда, Четверг, Пятница, Суббота, Воскресенье}

public class Data {
     int day;
    DAY_OF_THE_WEEK day_of_the_week;
    public Data(int day, DAY_OF_THE_WEEK day_of_the_week)
    {
        this.day_of_the_week = day_of_the_week;
        this.day = day;
    }
}
