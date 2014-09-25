using System;
class Person
{
    static void Main()
    {
        Persons person1 = new Persons("Guran", 15, "asdf@t");
        Console.WriteLine(person1);
        Persons person2 = new Persons("Stamat", 16);
        Console.WriteLine(person2);
    }
}
