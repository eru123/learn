using System;

class ActivityTen
{
    static void Main()
    {
        Random random = new Random();
        int guess = random.Next(1, 10);

        Console.WriteLine("Guess the number from 1 to 10");

        int attempt = 3;

        while (attempt != 0)
        {
            Console.WriteLine("\n[{0} attempts left]", attempt);

            Console.Write("Enter your guess\nInput: ");
            int input = Convert.ToInt32(Console.ReadLine());

            if (input == guess)
            {
                Console.WriteLine("Message: CONGRATULATIONS! You picked the right number!");
                break;
            }
            else if (guess > input)
            {
                Console.WriteLine("Message: Nice try... But {0} is not the number that I am thinking of. Try Higher!", input);
            }
            else
            {
                Console.WriteLine("Message: Sorry... But {0} is not the number that I am thinking of. Try Lower!", input);
            }

            attempt--;

            if (attempt == 0)
            {
                Console.WriteLine("Message: You have no attempts left, try again later.");
            }
        }
    }
}
