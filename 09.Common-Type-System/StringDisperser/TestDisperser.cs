namespace StringDisperser
{
    using System;

    class TestDisperser
    {
        static void Main()
        {
            StringDisperser disperser = new StringDisperser("hello", "world");
            Console.WriteLine(disperser);
            
            foreach (var ch in disperser)
            {
                Console.Write(ch + " ");
            }
            
            StringDisperser disperser2 = new StringDisperser("hey", "man!");
            Console.WriteLine();
            Console.WriteLine(disperser.CompareTo(disperser2));
        }
    }
}
