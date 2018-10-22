package Internet_Shop;

import java.io.Serializable;

public class Order implements Serializable
{
    Good [] goods;
    int number;



    public Order()
    {
        goods=null;
        number=0;
    }
    public Order(int number,Good good1,Good good2,Good good3,Good good4,Good good5,Good good6)
    {
        goods = new Good[6];
        this.number=number;
        this.goods[0]=good1;
        this.goods[1]=good2;
        this.goods[2]=good3;
        this.goods[3]=good4;
        this.goods[4]=good5;
        this.goods[5]=good6;

    }

    public int Sum()
    {
        int sum=0;
        for(int i=0;i<6;i++)
        {
            sum+=this.goods[i].cost;
        }
        return sum;
    }
}
