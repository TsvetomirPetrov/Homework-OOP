namespace Ex03.PC_Catalog
{
    using System;
    using System.Collections.Generic;
    using System.Globalization;
    public class Component
    {
        private string name;
        private string details;
        private decimal money;
        private List<Component> listOfComponents = new List<Component>();
        public Component()
        {
        }
        protected Component(string name, string details, decimal price)
        {
            this.Name = name;
            this.Details = details;
            this.Money = price;
        }
        public decimal PriceInDecimal
        {
            get
            {
                return this.SumOfComponents();
            }
        }
        private string Name
        {
            get
            {
                return this.name;
            }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Inputed value cannot be null or empty !");
                }
                this.name = value;
            }
        }
        private string Details
        {
            get
            {
                return this.details;
            }
            set
            {
                this.details = value;
            }
        }
        private decimal Money
        {
            get
            {
                return this.money;
            }
            set
            {
                if (value < 0)
                {
                    throw new IndexOutOfRangeException("Price cannot be less than 0");
                }
                this.money = value;
            }
        }
        public void AddComponent(string name, string details, decimal price)
        {
            if (this.listOfComponents.Exists(cmpt => cmpt.Name == name))
            {
                throw new ArgumentException("Component already exist.");
            }
            this.listOfComponents.Add(new Component(name, details, price));
        }
        public void ChangeComponent(string nameOldComponent, string name, string details, decimal price)
        {
            if (this.listOfComponents.Exists(cmpt => cmpt.Name == name))
            {
                var i = this.listOfComponents.FindIndex(cmpt => cmpt.Name == nameOldComponent);
                this.listOfComponents[i].Name = name;
                this.listOfComponents[i].Details = details;
                this.listOfComponents[i].Money = price;
            }
            else
            {
                throw new ArgumentException("Missing component");
            }
        }
        public void RemoveComponent(string name)
        {
            if (this.listOfComponents.Exists(cmpt => cmpt.Name == name))
            {
                this.listOfComponents.RemoveAll(cmpt => cmpt.name == name);
            }
            else
            {
                throw new ArgumentException("Cannot remove component, because is missing.");
            }
        }
        public void ShowAllComponents()
        {
            for (int i = 0; i < this.listOfComponents.Count; i++)
            {
                Console.WriteLine("Component: {0}, details: {1}, price : {2}", this.listOfComponents[i].Name, this.listOfComponents[i].Details, this.listOfComponents[i].Money);
            }
            Console.WriteLine("Price is : {0}", this.PriceCulture(this.SumOfComponents(), "BG-bg"));
        }
        public void ShowCurrentComponent(string name)
        {
            if (this.listOfComponents.Exists(cmpt => cmpt.Name == name))
            {
                var sublist = this.listOfComponents.Find(cmpt => cmpt.Name == name);
                Console.WriteLine("Component: {0}, details: {1}, price : {2}", sublist.Name, sublist.Details, sublist.Money);
            }
            else
            {
                throw new ArgumentException("Missing element");
            }
        }
        public string Price()
        {
            return this.PriceCulture(this.SumOfComponents(), "BG-bg");
        }
        private string PriceCulture(decimal price, string culture)
        {
            return price.ToString("C2", CultureInfo.CreateSpecificCulture(culture));
        }
        private decimal SumOfComponents()
        {
            if (this.listOfComponents.Count == 0)
            {
                throw new InvalidOperationException("Missing components! cannot sum components.");
            }
            decimal sum = 0;
            for (int i = 0; i < this.listOfComponents.Count; i++)
            {
                sum += this.listOfComponents[i].Money;
            }
            return sum;
        }
    }
}