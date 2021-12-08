using System;

class Apples
{
    static void Main(string[] args)
    {
        Console.Write("Enter the piece of apple: ");
        int apples = Convert.ToInt32(Console.ReadLine());
        Console.Write("Enter total price of {0} apple(s): ", apples);
        double price = Convert.ToDouble(Console.ReadLine());
        Console.WriteLine("The price of {0} apple(s) is {1}", apples, price);
        Console.WriteLine("The original price is {0}", price);
        double priceFloor = Math.Floor(price);
        Console.WriteLine("The converted price is {0}", priceFloor);
    }
}