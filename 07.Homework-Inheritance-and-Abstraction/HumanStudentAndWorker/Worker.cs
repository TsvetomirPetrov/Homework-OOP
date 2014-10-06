namespace HumanStudentWorker
{
    using System;
   
    class Worker : Human
    {
        public Worker(string firstName, string lastName, decimal weekSalary, int workHoursPerDay)
            : base(firstName, lastName)
        {
            this.WeekSalary = weekSalary;
            this.WorkHoursPerDay = workHoursPerDay;
        }
        
        private decimal weekSalary;
        private int workHoursPerDay;
       
        public decimal WeekSalary
        {
            get
            {
                return this.weekSalary;
            }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("The week salary cannot be a negative number");
                }
               
                this.weekSalary = value;
            }
        }
       
        public int WorkHoursPerDay
        {
            get
            {
                return this.workHoursPerDay;
            }
            set
            {
                if (value < 0 && value > 24)
                {
                    throw new ArgumentOutOfRangeException("The work hours per day must be in the range [0;24]");
                }
               
                this.workHoursPerDay = value;
            }
        }
       
        public decimal MoneyPerHour()
        {
            decimal moneyPerDay = this.weekSalary / 7;
            decimal moneyPerHour = moneyPerDay / this.workHoursPerDay;
            return moneyPerHour;
        }
    }
}