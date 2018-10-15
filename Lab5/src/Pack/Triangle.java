package Pack;

 public class Triangle
{
    protected int a;
    protected int b;
    protected double angle;
    public double area()
    {
        return(a*b*Math.sin(Math.toRadians((double)angle))/2);
    }
    public double perimetr()
    {
        return(a+b+(Math.pow(a*a+b*b-2*a*b*Math.cos(Math.toRadians(angle)),0.5)));
    }
    public Triangle()
    {
        a=0;
        b=0;
        angle=0;
    }
    public Triangle(int A,int B,double Angle)
    {
        a=A;
        b=B;
        angle=Angle;
    }


    public int getA()
    {
        return a;
    }

    public void setA (int a)
    {
        this.a = a;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    public double getAngle()
    {
        return angle;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }
}