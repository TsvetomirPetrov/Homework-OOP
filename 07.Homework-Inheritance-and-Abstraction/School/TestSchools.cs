namespace School
{
    using System;
    using System.Collections.Generic;
   
    class TestSchools
    {
        static void Main()
        {
            Student stewDent = new Student("Stew Dent", "012234");
            Student beefStew = new Student("Beef Stew", "432210");
            Student beefSteaks = new Student("Beef Stakes", "342201");
            Student highStakes = new Student("High Stakes", "432201");
           
            List<Student> friends = new List<Student>();
            friends.Add(stewDent);
            friends.Add(highStakes);
           
            List<Student> fries = new List<Student>();
            fries.Add(beefStew);
            fries.Add(beefSteaks);
           
            List<Student> everybody = new List<Student>();
            everybody.AddRange(friends);
            everybody.AddRange(fries);
          
            Discipline OOP = new Discipline("OOP", 19, friends);
            Discipline HQC = new Discipline("High-Quality Code", 36, fries);
            Discipline EOPD = new Discipline("Every Other Possible Discipline", 999, everybody);
           
            List<Discipline> disciplineSet = new List<Discipline>();
            disciplineSet.Add(OOP);
            disciplineSet.Add(HQC);
          
            List<Discipline> advancedDisciplineSet = new List<Discipline>();
            disciplineSet.Add(HQC);
            disciplineSet.Add(EOPD);
          
            Teacher vlado = new Teacher("Vladislav Karamfilov", disciplineSet);
            Teacher nakov = new Teacher("Svetlin Nakov", advancedDisciplineSet);
            Teacher unkown = new Teacher("Un Known", disciplineSet, "All I wanna do...");
            Teacher known = new Teacher("Well Known", disciplineSet, "...is have some fun!");
           
            List<Teacher> rookieTeachers = new List<Teacher>();
            rookieTeachers.Add(unkown);
            rookieTeachers.Add(known);
          
            List<Teacher> masterTeachers = new List<Teacher>();
            masterTeachers.Add(nakov);
            masterTeachers.Add(vlado);
          
            Class friendsClass = new Class("Friends", masterTeachers, friends, "I gotta feelin...");
            Class friesClass = new Class("Fries", rookieTeachers, fries, "...that I'm not the only one...");
          
            List<Class> awesomeClasses = new List<Class>();
            awesomeClasses.Add(friendsClass);
            awesomeClasses.Add(friesClass);
         
            School softUni = new School(awesomeClasses);
        }
    }
}