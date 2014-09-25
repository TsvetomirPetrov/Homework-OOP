namespace Ex03.PC_Catalog
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;

    class ComputerReview
    {
        public static void Main()
        {
            Console.OutputEncoding = Encoding.UTF8;// use Lucida Console to print лв.
            Computer lenovo = new Computer("lenovo", "HDD", "128GB SSD", 200);
            lenovo.AddComponent("graphics card", "Intel HD Graphics 4400", 200);
            lenovo.AddComponent("processor", "Intel Core i5-4210U (2-core, 1.70 - 2.70 GHz, 3MB cache)", 350);
            Computer asus = new Computer("Asus-5500", "HDD", "128GB SSD", 1200);
            Computer toshiba = new Computer("Toshiba-9300", "HDD", "500GB SSD", 900);
            Computer sony = new Computer("Sony-b600", "HDD", "10TB SSD", 3900);
            List<Computer> computers = new List<Computer>();
            computers.Add(lenovo);
            computers.Add(asus);
            computers.Add(toshiba);
            computers.Add(sony);
            PrintListOfComputers(computers);
        }

        private static void PrintListOfComputers(List<Computer> computers)
        {
            var sortedComp = computers.OrderByDescending(x => x.PriceInDecimal).ToArray();
            for (int i = 0; i < sortedComp.Length; i++)
            {
                Console.WriteLine("Computer: {0}, Price: {1}", sortedComp[i].Name, sortedComp[i].Price());
            }
        }
    }
}