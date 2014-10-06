namespace Animals
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    
    class TestAnimals
    {
        static void Main()
        {
            List<Dog> dogs = new List<Dog>()
            {
                new Dog("Rex", 13, Gender.Male),
                new Dog("Jessica", 6, Gender.Female),
                new Dog("Milo", 17, Gender.Male),
                new Dog("Jade", 1, Gender.Female)
            };
           
            List<Kitten> kittens = new List<Kitten>()
            {
                new Kitten("Kat", 6),
                new Kitten("Sweety", 0),
                new Kitten("Sandy", 4),
                new Kitten("Catherine", 3)
            };
          
            List<Tomcat> tomcats = new List<Tomcat>()
            {
                new Tomcat("Zorro", 7),
                new Tomcat("Lucky", 7),
                new Tomcat("Tom", 7),
                new Tomcat("Sage", 4)
            };
           
            List<Frog> frogs = new List<Frog>()
            {
                new Frog("Randy", 3, Gender.Male),
                new Frog("Bob", 6, Gender.Male),
                new Frog("Steward", 2, Gender.Male),
                new Frog("Queen", 4, Gender.Female)
            };
           
            CalculateAverageAge(dogs, "dog");
            CalculateAverageAge(kittens, "kitten");
            CalculateAverageAge(tomcats, "tomcat");
            CalculateAverageAge(frogs, "frog");
        }
        
        public static void CalculateAverageAge<T>(List<T> animals, string species)
        {
            var animalList = animals.Cast<Animal>().ToList();
            double averageAge =
                animalList
                .Average(animal => animal.Age);
            
            Console.WriteLine("Average {0}s age: {1:F1}", species, averageAge);
        }
    }
}