using System;
class TestProblems
{
    static void Main()
    {
        Point p1 = new Point(0, 1, 2);
        Point p2 = new Point(4.8, 3.2, 6.84);

        double distance = DistanceCalcolator.CalculateDistance(p1, p2);
        Console.WriteLine(distance);
        Console.WriteLine();
    }
}
