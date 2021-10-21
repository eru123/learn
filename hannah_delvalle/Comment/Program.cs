using System;

class Program
{
    static void Main(string[] args)
    {
        Comment comment = new Comment("user1", "I Like this book");
        Console.WriteLine(comment.username);
        Console.WriteLine(comment.content);
    }
}