import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Lab04EFst
{
    public static void main(String args[])
    {
        GrfxWindow tester = new GrfxWindow();
        tester.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        tester.setSize(1322,760);
        tester.setVisible(true);
    }
}

class GrfxWindow extends Frame
{
    private ArrayList<FlyingSaucer> flyingSaucers;

    public GrfxWindow()
    {
        super("Lab04EF By: Henry Van Kirk");

        flyingSaucers = new ArrayList<FlyingSaucer>();
        for (int j = 0; j < 4; j++)
            flyingSaucers.add(new FlyingSaucer((j+1)*300-100,375,j));
    }

    public void paint(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.translate(11,49);
        g2D.setStroke(new BasicStroke(4));

        for (int j = 0; j < flyingSaucers.size(); j++)
            flyingSaucers.get(j).drawFlyingSaucer(g);

        Utility.delay(75);

        for (int j = 0; j < flyingSaucers.size(); j++)
            flyingSaucers.get(j).move(g);

        checkCollisions();

        repaint();
    }

    private void checkCollisions()
    {
        for (int i = 0; i < flyingSaucers.size(); i++)
        {
            for (int j = i + 1; j < flyingSaucers.size(); j++)
            {
                FlyingSaucer a = flyingSaucers.get(i);
                FlyingSaucer b = flyingSaucers.get(j);

                if (a.intersects(b))
                {
                    a.reverseDirection();
                    b.reverseDirection();

                    Color temp = a.getTopColor();
                    a.setTopColor(b.getTopColor());
                    b.setTopColor(temp);
                }
            }
        }
    }
}

class FlyingSaucer
{
    private int x, y, incX, incY;
    private Color topColor, bottomColor;
    private int width, height, hr, vr;

    public FlyingSaucer(int xp, int yp, int index)
    {
        x = xp;
        y = yp;
        topColor = getColor(index);
        bottomColor = topColor;

        width = 150;
        height = 50;
        hr = width / 2;
        vr = height / 2;

        incX = Utility.random(1,3) * 5;
        incY = Utility.random(1,3) * 5;

        if (Utility.random(1,2) == 1)
            incX = -incX;
        if (Utility.random(1,2) == 1)
            incY = -incY;
    }

    private Color getColor(int index)
    {
        if (index == 0) return Color.red;
        if (index == 1) return Color.green;
        if (index == 2) return Color.blue;
        if (index == 3) return Color.magenta;
        return getColor(index % 4);
    }

    public void drawFlyingSaucer(Graphics g)
    {
        g.setColor(topColor);
        g.fillOval(x-vr, y-height, height, height);
        g.setColor(Color.black);
        g.drawOval(x-vr, y-height, height, height);

        g.setColor(bottomColor);
        g.fillOval(x-hr, y-vr, width, height);
        g.setColor(Color.black);
        g.drawOval(x-hr, y-vr, width, height);
    }

    public void eraseFlyingSaucer(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x-hr-5, y-height-5, width+10, height+vr+10);
    }

    public void move(Graphics g)
    {
        eraseFlyingSaucer(g);

        if (incX > 0 && x + incX > 1225)
            incX = -incX;
        if (incX < 0 && x + incX < 75)
            incX = -incX;
        if (incY > 0 && y + incY > 625)
            incY = -incY;
        if (incY < 0 && y + incY < 50)
            incY = -incY;

        x += incX;
        y += incY;
    }

    public void reverseDirection()
    {
        incX = -incX;
        incY = -incY;
    }

    public Color getTopColor()
    {
        return topColor;
    }

    public void setTopColor(Color c)
    {
        topColor = c;
    }

    public boolean intersects(FlyingSaucer other)
    {
        int left1 = x - hr;
        int right1 = x + hr;
        int top1 = y - height;
        int bottom1 = y + vr;

        int left2 = other.x - other.hr;
        int right2 = other.x + other.hr;
        int top2 = other.y - other.height;
        int bottom2 = other.y + other.vr;

        if (right1 < left2) return false;
        if (left1 > right2) return false;
        if (bottom1 < top2) return false;
        if (top1 > bottom2) return false;

        return true;
    }
}