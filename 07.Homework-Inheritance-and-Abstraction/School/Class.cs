namespace School
{
    using System;
    using System.Collections.Generic;
    
    class Class : IDetailable
    {
        public Class(string uniqueTextIdentifier, List<Teacher> teachers, List<Student> students, string details)
            : this(uniqueTextIdentifier, teachers, students)
        {
            this.Details = details;
        }
        
        public Class(string uniqueTextIdentifier, List<Teacher> teachers, List<Student> students)
        {
            this.UniqueTextIdentifier = uniqueTextIdentifier;
            this.Teachers = teachers;
            this.Students = students;
        }
       
        private string uniqueTextIdentifier;
        private List<Teacher> teachers;
        private List<Student> students;
        private string details;
        private List<string> allTextIdentifiers = new List<string>();
        
        public string UniqueTextIdentifier
        {
            get
            {
                return this.uniqueTextIdentifier;
            }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("The unique text identifier cannot be empty");
                }
               
                if (allTextIdentifiers.Contains(value))
                {
                    throw new ArgumentException("This unique text identifier has already been taken");
                }
               
                this.uniqueTextIdentifier = value;
            }
        }
      
        public List<Teacher> Teachers
        {
            get
            {
                return this.teachers;
            }
            set
            {
                if (value == null)
                {
                    throw new ArgumentException("The set of teachers cannot be null");
                }
                
                this.teachers = value;
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
                    throw new ArgumentException("The set of students cannot be null");
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