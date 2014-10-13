namespace Customer
{
    using System;
    using System.Collections.Generic;

    class TestCustomer
    {
        static void Main()
        {
            Payment newTV = new Payment("Sony XT-33", 12999.99m);
            Payment brokia = new Payment("Brokia Universe -1", 4242.42m);
            Payment chair = new Payment("Chair", 54);
            Payment plate = new Payment("Plate", 20);
            Payment ancientCherokeeSkull = new Payment("Ancient Cherokee skull", 3000);
            Payment lighbulb = new Payment("Lightbulb", 4.99m);
            Payment scrabble = new Payment("Scrabble", 39.99m);

            List<Payment> randomPayments = new List<Payment>();
            randomPayments.Add(newTV);
            randomPayments.Add(brokia);
            randomPayments.Add(ancientCherokeeSkull);

            List<Payment> notSoRandomPayments = new List<Payment>();
            notSoRandomPayments.Add(chair);
            notSoRandomPayments.Add(plate);
            notSoRandomPayments.Add(lighbulb);
            notSoRandomPayments.Add(scrabble);

            Customer Mike = new Customer("Mike", "Stirling", "Wasowski", "9912138770", "New Oak 55"
                , "+555 334 534", "wasowski99@hotmail.com", randomPayments, CustomerType.Regular);

            Customer Mike2 = new Customer("Mike", "Stirling", "Wasowski", "9912138771", "New Oak 55"
                , "+555 334 532", "wasowski992@hotmail.com", randomPayments, CustomerType.Regular);

            Customer Martin = new Customer("Martin", "Davis", "Junior", "9512130000", "Rixton str. 216"
                , "+555 132 784", "mister_fantastico@gmail.com", notSoRandomPayments, CustomerType.Diamond);

            Console.WriteLine(Customer.Equals(Mike, Mike2)); // returns true because the IDs match
            Console.WriteLine(Mike.CompareTo(Mike2));
            Console.WriteLine(Martin);
            Customer Martin2 = (Customer)Martin.Clone();
            Martin2.Email = "first Email hasn't changed :)";
            Console.WriteLine(Martin);
        }
    }
}
