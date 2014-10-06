namespace School
{
    using System;
   
    public abstract class Person : IDetailable
    {
        protected Person(string name)
        {
            this.Name = name;
        }
       
        protected Person(string name, string details)
            : this(name)
        {
            this.Details = details;
        }
        
        private string name;
        private string details;
        
        public string Name
        {
            get
            {
                return this.name;
            }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Name cannot be empty");
                }
               
                this.name = value;
            }
        }
       
        public string Details
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
    }
}