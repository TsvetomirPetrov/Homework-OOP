namespace HumanStudentWorker
{
    using System;
    using System.Text.RegularExpressions;
   
    class Student : Human
    {
        public Student(string firstName, string lastName, string facultyNumber)
            : base(firstName, lastName)
        {
            this.FacultyNumber = facultyNumber;
        }
       
        private string facultyNumber;
        
        public string FacultyNumber
        {
            get
            {
                return this.facultyNumber;
            }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Faculty number cannot be null or empty");
                }
             
                if (!Regex.IsMatch(value, @"^[a-zA-Z0-9]+$"))
                {
                    throw new ArgumentException("Faculty number must contain 5-10 digits / letters");
                }
           
                this.facultyNumber = value;
            }
        }
    }
}