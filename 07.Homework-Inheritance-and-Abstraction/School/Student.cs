namespace School
{
    using System;
    using System.Collections.Generic;
   
    public class Student : Person
    {
        public Student(string name, string uniqueClassNumber)
            : this(name, uniqueClassNumber, null)
        {
        }
        
        public Student(string name, string uniqueClassNumber, string details)
            : base(name, details)
        {
            this.UniqueClassNumber = uniqueClassNumber;
        }
       
        private string uniqueClassNumber;
        private static List<string> allClassNumbers = new List<string>();
        
        public string UniqueClassNumber
        {
            get
            {
                return this.uniqueClassNumber;
            }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Unique class number cannot be empty");
                }
                
                if (allClassNumbers.Contains(value))
                {
                    throw new ArgumentException("This unique class number has already been taken");
                }
                
                this.uniqueClassNumber = value;
                allClassNumbers.Add(uniqueClassNumber);
            }
        }
    }
}