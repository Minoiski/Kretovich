package Pack;
import java.util.Comparator;
import java.util.Iterator;

public class IsoscelesTriangle extends Triangle implements Comparable<IsoscelesTriangle>, Iterator<Double>, Iterable<Double>
{
    protected int iterator_index = 0;

    public void setA_B(int a)
    {
        this.a=a;
        this.b=a;
    }
    public void setA(int a)
    { }
    public void setB(int a)
    {}
    @Override
    public int compareTo(IsoscelesTriangle T)
    {
        if (this.a < T.a) return -1;
        if (this.a > T.a) return 1;
        return 0;
    }

    @Override
    public Iterator<Double> iterator()
    {
        reset();
        return this;
    }

    @Override
    public boolean hasNext()
    {
        return iterator_index < 3;
    }

    @Override
    public Double next()
    {
        switch (iterator_index)
        {
            case 0:
                iterator_index++;
                return angle;
            case 1:
                iterator_index++;
                return Double.parseDouble(Integer.toString(a));
            case 2:
                iterator_index++;
                return Double.parseDouble(Integer.toString(b));
            default:
                reset();
                return null;
        }
    }
    public void reset()
    {
        iterator_index = 0;
    }

    public static class CompareAngles implements Comparator<IsoscelesTriangle> {
        @Override
        public int compare(IsoscelesTriangle T1, IsoscelesTriangle T2) {
            if (T1.angle < T2.angle) return -1;
            if (T1.angle > T2.angle) return 1;
            return 0;
        }
    }

    public static class CompareA implements Comparator<IsoscelesTriangle> {
        @Override
        public int compare(IsoscelesTriangle T1, IsoscelesTriangle T2) {
            if (T1.a < T2.a) return -1;
            if (T1.a > T2.a) return 1;
            return 0;
        }
    }

    public static class CompareB implements Comparator<IsoscelesTriangle> {
        @Override
        public int compare(IsoscelesTriangle T1, IsoscelesTriangle T2) {
            if (T1.b < T2.b) return -1;
            if (T1.b > T2.b) return 1;
            return 0;
        }
    }
    @Override
    public String toString()
    {
        return "Равнобедренный_треугольник{" +
                "angle=" + angle + "\u00B0" +
                ", a=" + String.format("%3d", a) +
                ", b=" + String.format("%3d", b) +
                '}';
    }

    public double area()

    {
        return (a*b*Math.sin(Math.toRadians(angle))/2);
    }

    public IsoscelesTriangle(int A,double Angle)
    {
        a=A;
        b=a;
        angle=Angle;
    }
    public IsoscelesTriangle(String s)
    {
        int i = s.indexOf(',');
        String z=s.substring(0,i);
        a= Integer.parseInt(z);
        b=a;
        angle=Integer.parseInt(s.substring(i+1));
    }

}
