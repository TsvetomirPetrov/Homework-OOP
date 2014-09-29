using System;

class EnterNumbers
{
    static void Main()
    {
        int start = 1;
        int end = 10;
        for (int i = 0; i < 10; i++)
        {
            ReadNumber(start, end);
        }
    }
    static void ReadNumber(int start, int end)
    {
        try
        {
            Console.WriteLine("Enter a number in the range[{0}...{1}]", start, end);
            string input = Console.ReadLine();
            int num = Int32.Parse(input);
            if (num < start || num > end)
            {
                throw new ArgumentOutOfRangeException();
            }
            return;
        }
        catch (FormatException)
        {
            Console.WriteLine("Not a number");
        }
        catch (ArgumentOutOfRangeException)
        {
            Console.WriteLine("The number must to be in range [{0}...{1}]", start, end);
        }
        ReadNumber(start, end);
    }
}

