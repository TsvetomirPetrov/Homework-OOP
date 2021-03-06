﻿namespace Customer
{
    using System;

    class Payment
    {
        public Payment(string productName, decimal price)
        {
            this.ProductName = productName;
            this.Price = price;
        }

        private string productName;
        private decimal price;

        public string ProductName
        {
            get
            {
                return this.productName;
            }
            set
            {
                Utilities.ValidateString(value, "Product name");
                this.productName = value;
            }
        }

        public decimal Price
        {
            get
            {
                return this.price;
            }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Price cannot have a negative value");
                }
                this.price = value;
            }
        }

        public override string ToString()
        {
            string info = "Product name: " + this.ProductName + "Price: " + this.Price + "$";
            return info;
        }
    }
}
