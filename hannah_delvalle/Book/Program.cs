using System;

class Program
{
    static void Main(string[] args)
    {
        Book book = new Book("My Book", "Me", 200);
        Console.WriteLine(book.name);
        Console.WriteLine(book.author);
        Console.WriteLine(book.pages);
    }
}