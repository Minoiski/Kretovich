package Drugs;

import java.io.Serializable;
import java.util.Date;

public class Drug implements Serializable
{
    protected int numberOfPharmacy;
    protected String name;
    protected int amountOfPack;
    protected int costOfPack;
    protected Date dateOfReceive;
    protected String dateOfLife;

    public Drug()
    {
        this.numberOfPharmacy=0;
        this.name=null;
        this.amountOfPack=0;
        this.costOfPack=0;
        this.dateOfReceive=null;
        this.dateOfLife=null;
    }

    public Drug(int numberOfPharmacy, String name, int amountOfPack, int costOfPack,  String dateOfLife)
    {
        this.setNumberOfPharmacy(numberOfPharmacy);
        this.setName(name);
        this.setAmountOfPack(amountOfPack);
        this.setCostOfPack(costOfPack);
        this.dateOfReceive=new Date();
        this.setDateOfLife(dateOfLife);
    }


    public String toString()
    {
        return ("Drug:{"+this.name+
                ", Number of pharmacy: "+this.numberOfPharmacy+
                ", amount of pack: "+this.amountOfPack+
                ", cost of pack: "+this.costOfPack+
                ", date of receive: "+this.dateOfReceive+
                ", date of life: "+this.dateOfLife);

    }
    public int getNumberOfPharmacy()
    {
        return numberOfPharmacy;
    }

    public void setNumberOfPharmacy(int numberOfPharmacy)
    {
        this.numberOfPharmacy = numberOfPharmacy;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAmountOfPack()
    {
        return amountOfPack;
    }

    public void setAmountOfPack(int amountOfPack)
    {
        this.amountOfPack = amountOfPack;
    }

    public int getCostOfPack()
    {
        return costOfPack;
    }

    public void setCostOfPack(int costOfPack)
    {
        this.costOfPack = costOfPack;
    }

    public Date getDateOfReceive()
    {
        return dateOfReceive;
    }

    public void setDateOfReceive(Date dateOfReceive)
    {
        this.dateOfReceive = dateOfReceive;
    }

    public String getDateOfLife()
    {
        return dateOfLife;
    }

    public void setDateOfLife(String dateOfLife)
    {
        this.dateOfLife = dateOfLife;
    }
}
