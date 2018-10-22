package Internet_Shop;

import java.io.Serializable;

public class Admin implements Serializable
{
    String name;

    public Admin() {
        this.name = null;
    }

    public Admin(String name) {
        this.name = name;
    }


    public void SetGood(Good good, int cost, Type type) {
        good.cost = cost;
        good.type = type;
    }

    public void RegisterSale(Client client)
    {
        if(client.order.Sum()>client.money)
        {
            client.blackList=true;
        }
        else
        {
            client.money-=client.order.Sum();
            for(int i=0;i<5;i++)
            {
                client.order.goods[i].sold=true;
            }
        }
    }
}