import java.applet.*;
import java.awt.*;
public class Triangle extends Applet implements Runnable{
    Thread t = null;

    private static final int trianglePoints = 4;


    private int [] xPoints = new int[trianglePoints];

    private int [] yPoints = new int[trianglePoints];


    public void start()
    {
        if (t == null)
            t = new Thread(this);
        t.start();
    }
    public void init()
    {
        this.setSize(400, 400);
    }
    public Color getHtmlColor( String strRGB, Color def )
    {
        if ( strRGB != null && strRGB.charAt(0)== '#' )
        {
            try
            {
                return new Color(Integer.parseInt( strRGB.substring( 1 ), 16 ) );
            } catch ( NumberFormatException e ) {
                return def;
            }
        }
        return def;
    }
    public int getIntParam(String par, int param)
    {
        if(par==null)
            return param;
        else
        {
            return Integer.parseInt(par);
        }
    }
    @Override
    public void run()
    {
        Color colx = getHtmlColor(getParameter( "DrawBkColor" ), new Color(227, 225, 221));
        setBackground( colx );
        String s1=getParameter("x2");
        String s2=getParameter("y2");
        String s3=getParameter("x3");
        String s4=getParameter("y3");
        String s5=getParameter("x4");
        String s6=getParameter("y4");
        xPoints[1]=getIntParam(s1,220);
        xPoints[2]=getIntParam(s3,50);
        xPoints[3]=getIntParam(s5,110);
        xPoints[0]=(xPoints[1]+xPoints[2]+xPoints[3])/3;
        System.out.println(xPoints[0]);
        yPoints[1]=getIntParam(s2,50);
        yPoints[2]=getIntParam(s4,50);
        yPoints[3]=getIntParam(s6,110);
        yPoints[0]=(yPoints[1]+yPoints[2]+yPoints[3])/3;
        System.out.println(yPoints[0]);
        int r1x=xPoints[1]-xPoints[0];
        int r1y=yPoints[1]-yPoints[0];
        int r2x=xPoints[2]-xPoints[0];
        int r2y=yPoints[2]-yPoints[0];
        int r3x=xPoints[3]-xPoints[0];
        int r3y=yPoints[3]-yPoints[0];
        int i=1;
        while(true)
        {
            try
            {
                Thread.sleep(10);

                double x = Math.PI / 180;

                double newX = xPoints[0] + (r1x) * Math.cos(x * i) - (r1y) * Math.sin(x * i);

                double newY = yPoints[0] + (r1x) * Math.sin(x * i) + (r1y) * Math.cos(x * i);

                xPoints[1] = (int) newX;
                yPoints[1] = (int) newY;


                newX = xPoints[0] + (r2x)*Math.cos(x *i) - (r2y)*Math.sin(x *i);

                newY = yPoints[0] + (r2x)*Math.sin(x *i) + (r2y)*Math.cos(x *i);

                xPoints[2] = (int) newX;
                yPoints[2] = (int) newY;

                newX = xPoints[0] + (r3x)*Math.cos(x *i) - (r3y)*Math.sin(x *i);

                newY = yPoints[0] + (r3x)*Math.sin(x *i) + (r3y)*Math.cos(x *i);

                xPoints[3] = (int) newX;
                yPoints[3] = (int) newY;
                i++;
                if(i>=360)
                    i=1;
                repaint();
            }
            catch(InterruptedException e) {}
        }
    }
    public void paint(Graphics dr)
    {

        dr.translate(xPoints[0], yPoints[0]);
        Color cl = getHtmlColor("DrawColor", new Color(160, 41, 25));
        dr.setColor(cl);
        dr.drawLine(xPoints[1], yPoints[1], xPoints[2], yPoints[2]);
        dr.drawLine(xPoints[2], yPoints[2], xPoints[3], yPoints[3]);
        dr.drawLine(xPoints[3], yPoints[3], xPoints[1], yPoints[1]);

    }
}
