using System;

class TestProblems
{
    static void Main()
    {
        Point p1 = new Point(0, 1, 2);
        Point p2 = new Point(4.8, 3.2, 6.84);

        Path path = new Path(p1, p2, Point.StartPoint);
        Console.WriteLine("Save path: {0}", path);
        Storage.SavePathInFile("path.txt", path);
        Path loadPath = Storage.LoadPathOfFile("path.txt");
        Console.WriteLine("Load path: {0}", loadPath);
    }
}