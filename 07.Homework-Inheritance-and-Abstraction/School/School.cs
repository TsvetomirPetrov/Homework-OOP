namespace School
{
    using System;
    using System.Collections.Generic;
   
    class School
    {
        public School(List<Class> classes)
        {
            this.Classes = classes;
        }
       
        private List<Class> classes = new List<Class>();
       
        public List<Class> Classes
        {
            get
            {
                return this.classes;
            }
            set
            {
                if (value == null)
                {
                    throw new ArgumentException("The list of classes cannot be null");
                }
           
                this.classes = value;
            }
        }
    }
}