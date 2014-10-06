namespace HumanStudentWorker
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
  
    class TestPeople
    {
        static void Main()
        {
            List<Student> students = new List<Student>(){
                new Student("Jack", "Allen", "3434q"),
                new Student("Henry", "Bing", "7787w"),
                new Student("Georgia", "Cromwell", "1153z"),
                new Student("Fury", "Dean", "3891m"),
                new Student("Eleanor", "Ester", "3534j"),
                new Student("Dave", "Franco", "7385h"),
                new Student("Cate", "Garrett", "1989x"),
                new Student("Bane", "Hudson", "6685y"),
                new Student("Anne", "Ivy", "3498d"),
                new Student("Zane", "Johnson", "9034k")
            };
           
            List<Worker> workers = new List<Worker>(){
                new Worker("Back", "Fallen", 5409, 5),
                new Worker("Trendy", "Sting", 4999, 3),
                new Worker("Thia", "Boswell", 3490,1),
                new Worker("Lury", "Bean", 8999, 7),
                new Worker("Belvedere", "Faster", 100000, 8),
                new Worker("Jeff", "Jenko", 500000, 7),
                new Worker("Tate", "Jared", 45998, 8),
                new Worker("Jane", "Budson", 5700, 7),
                new Worker("Dan", "Heidy", 30000, 6),
                new Worker("Stan", "Dawson", 30000, 5)
            };
           
            var sortedStudents =
                students
                .OrderBy(student => student.FacultyNumber);
           
            foreach (Student student in sortedStudents)
            {
                Console.WriteLine("Name: {0} {1}, Faculty Number: {2}",
                    student.FirstName, student.LastName, student.FacultyNumber);
            }
            var sortedWorkers =
                workers
                .OrderByDescending(worker => worker.MoneyPerHour());
            
            foreach (Worker worker in sortedWorkers)
            {
                Console.WriteLine("Name: {0} {1}, Week Salary: {2}, Work Hours Per Day: {3}",
                    worker.FirstName, worker.LastName, worker.WeekSalary, worker.WorkHoursPerDay);
            }
            
            List<Human> humans = new List<Human>();
            humans.AddRange(students);
            humans.AddRange(workers);
            
            var sortedHumans =
                humans
                .OrderBy(human => human.FirstName)
                .ThenBy(human => human.LastName);
            
            foreach (Human human in sortedHumans)
            {
                Console.WriteLine("Name: {0} {1}", human.FirstName, human.LastName);
            }
        }
    }
}