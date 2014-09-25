namespace Ex03.PC_Catalog
{
    using System;
    public class Computer : Component
    {
        private string name;
        public Computer()
        {
        }
        public Computer(string name, string componentName, string componentDescription, decimal componentPrice)
        {
            this.Name = name;
            this.AddComponent(componentName, componentDescription, componentPrice);
        }
        public Computer(string name, string componentName, decimal componentPrice)
            : this(name, componentName, string.Empty, componentPrice)
        {
        }
        public Computer(string name)
        {
            this.Name = name;
        }
        public string Name
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
    }
}