package Internet_Shop;

import java.io.Serializable;

enum Type{pan, plate, spoon, phone,sneakers}
public class Good implements Serializable
{
    boolean sold;
    int cost;
    Type type;

    public Good()
    {
        cost=0;
        type=null;
        sold=false;
    }
    public Good(int cost,Type type)
    {
        this.cost=cost;
        this.type=type;
        this.sold=false;
    }
}
