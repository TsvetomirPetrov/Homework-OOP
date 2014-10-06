namespace School
{
    using System;
    using System.Collections.Generic;
   
    class Teacher : Person
    {
        public Teacher(string name, List<Discipline> disciplines)
            : this(name, disciplines, null)
        {
        }
       
        public Teacher(string name, List<Discipline> disciplines, string details)
            : base(name, details)
        {
            this.Disciplines = disciplines;
        }
       
        private List<Discipline> disciplines = new List<Discipline>();
       
        public List<Discipline> Disciplines
        {
            get
            {
                return this.disciplines;
            }
            set
            {
                if (value == null)
                {
                    throw new ArgumentException("The set of disciplines cannot be null");
                }
                
                this.disciplines = value;
            }
        }
    }
}