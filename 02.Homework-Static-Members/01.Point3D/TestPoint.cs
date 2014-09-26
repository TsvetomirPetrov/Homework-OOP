using System;

class TestPoint3D
{
    static void Main()
    {
        Point p1 = new Point(0, 1, 2);
        Point p2 = new Point(4.8, 3.2, 6.84);

        Console.WriteLine(p1);
        Console.WriteLine(p2);
        Console.WriteLine(Point.StartPoint);
        Console.WriteLine();
    }
}