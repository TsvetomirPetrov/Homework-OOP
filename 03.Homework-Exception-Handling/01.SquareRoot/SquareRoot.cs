using System;

class SquareRoot
{
    static void Main()
    {
        string input = Console.ReadLine();

        try
        {
            int number = int.Parse(input);
            if (number < 0)
            {
                throw new ArithmeticException();
            }
            Console.WriteLine(Math.Sqrt(number));
        }
        catch (FormatException)
        {
            Console.WriteLine("Invalid number");
        }
        catch(ArithmeticException)
        {
            Console.WriteLine("Invalid number");
        }
        finally
        {
            Console.WriteLine("Good Bye");
        }
    }
}

