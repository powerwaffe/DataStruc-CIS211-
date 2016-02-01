package Ch1;

/**
 * Created by Sean on 1/12/2016.
 */
public class Circle implements Circular
{
    private double radius;

    public void setRadius(double newRadius)
    {
        radius = newRadius;
    } //end setRadius

    public double getRadius()
    {
        return getRadius();
    } //end getRadius

    public double getArea()
    {
        return Math.PI * radius * radius;
    } //end getArea
} //end Ch1.Circle
