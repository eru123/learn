using System;

class Program
{
    public enum Importance { 
        None,
        Trivial,
        Important,
        Critical
    }
    static void Main(string[] args)
    {
        Importance value = Importance.Critical;

        if (value == Importance.Trivial)
        {
            Console.WriteLine("It's Trivial");
        }
        else if (value == Importance.Important)
        {
            Console.WriteLine("It's Important");
        }
        else if (value == Importance.Critical)
        {
            Console.WriteLine("It's Critical");
        }
        else
        {
            Console.WriteLine("No Importance");
        }
    }
}