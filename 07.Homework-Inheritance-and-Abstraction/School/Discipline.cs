namespace School
{
    using System;
    using System.Collections.Generic;
    
    class Discipline : IDetailable
    {
        public Discipline(string name, int numberOfLectures, List<Student> students, string details)
        {
            this.Name = name;
            this.NumberOfLectures = numberOfLectures;
            this.Students = students;
            this.Details = details;
        }
        
        public Discipline(string name, int numberOfLectures, List<Student> students)
            : this(name, numberOfLectures, students, null)
        {
        }
       
        private string name;
        private int numberOfLectures;
        private List<Student> students = new List<Student>();
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
        public int NumberOfLectures
        {
            get
            {
                return this.numberOfLectures;
            }
            set
            {
                if (numberOfLectures < 0)
                {
                    throw new ArgumentOutOfRangeException("The number of lectures cannot be negative");
                }
              
                this.numberOfLectures = value;
            }
        }
       
        public List<Student> Students
        {
            get
            {
                return this.students;
            }
            set
            {
                if (value == null)
                {
                    throw new ArgumentException("The list of students cannot be null");
                }
               
                this.students = value;
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