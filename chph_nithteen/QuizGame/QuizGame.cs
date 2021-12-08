using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QuizGame
{
    class Program
    {   
        // array of username and password
        private static string[][] accounts = new string[][]
        {
            new string[] {"admin", "admin"},
            new string[] {"user", "user"}
        };

        private int accountIndex = -1;
        private bool authenticated = false;
        private bool close = false;
        private List<Question> questions = new List<Question>();
        private int highScore = 0;

        private 

        static void Main(string[] args)
        {
            Program app = new Program();

            app.addQuestion(new Question("What is the capital of Australia?", "Canberra", new string[] {"Sydney", "Melbourne", "Brisbane", "Perth"}));
            app.addQuestion(new Question("What is the capital of New Zealand?", "Wellington", new string[] {"Auckland", "Christchurch", "Dunedin", "Hamilton"}));
            app.addQuestion(new Question("What is the capital of France?", "Paris", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of Germany?", "Berlin", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of Italy?", "Rome", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of Spain?", "Madrid", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of the United States?", "Washington", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of the United Kingdom?", "London", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of Brazil?", "Brasilia", new string[] {"London", "Berlin", "Madrid", "Paris"}));
            app.addQuestion(new Question("What is the capital of Japan?", "Tokyo", new string[] {"London", "Berlin", "Madrid", "Paris"}));

            app.drawFlashScreen();
            while(!app.authenticated) app.LoginMenu();
            while(!app.close) app.MainMenu();
        }
        private void drawFlashScreen(int speed = 5) {
            Console.Clear();
            Console.WriteLine("##############################################");
            Console.WriteLine("##                                          ##");
            Console.WriteLine("##               Game Loading               ##");
            Console.WriteLine("##                                          ##");
            Console.WriteLine("##############################################\n");
            Console.WriteLine("              ...Please Wait...\n\n");
            int i = 0;
            while (i <= 100)
            {
                // sleep for 1 of 200th  of the given speed
                System.Threading.Thread.Sleep((1000 * speed) / 500);
                drawTextProgressBar(i, 100);
                i++;
            }
            Console.Clear();
        }
        private void drawTextProgressBar(int progress, int total)
        {
            //draw empty progress bar
            Console.CursorLeft = 0;
            Console.Write("["); //start
            Console.CursorLeft = 32;
            Console.Write("]"); //end
            Console.CursorLeft = 1;
            float onechunk = 30.0f / total;

            //draw filled part
            int position = 1;
            for (int i = 0; i < onechunk * progress; i++)
            {
                Console.BackgroundColor = ConsoleColor.Gray;
                Console.CursorLeft = position++;
                Console.Write(" ");
            }

            //draw unfilled part
            for (int i = position; i <= 31; i++)
            {
                Console.BackgroundColor = ConsoleColor.Green;
                Console.CursorLeft = position++;
                Console.Write(" ");
            }

            //draw totals
            Console.CursorLeft = 35;
            Console.BackgroundColor = ConsoleColor.Black;
            Console.Write(progress.ToString() + " of " + total.ToString() + "    "); //blanks at the end remove any excess
        }
        private void LoginMenu(){
            Console.WriteLine("Menu");
            Console.WriteLine("[L] Login");
            Console.WriteLine("[Q] Quit");
            Console.Write("Enter your choice: ");

            // get char 
            char choice = Console.ReadKey().KeyChar;
            Console.Clear();

            // validate choice 
            if (choice == 'L' || choice == 'l')
            {
                Console.Clear();
                Console.WriteLine("Login");
                Console.Write("Username: ");
                string username = Console.ReadLine();
                Console.Write("Password: ");
                string password = Console.ReadLine();

                Console.Clear();

                bool found = false;

                for (int i = 0; i < accounts.Length; i++)
                {
                    if (accounts[i][0] == username && accounts[i][1] == password)
                    {
                        found = true;
                        authenticated = true;
                        accountIndex = i;
                        break;
                    }
                }

                if (!found) Console.WriteLine("Invalid username or password! Try again later\n");
            }
            else if (choice == 'Q' || choice == 'q')
            {
                Environment.Exit(0);
            }
            else
            {
                Console.WriteLine("Invalid Choice\n");
            }
        }
        private void addQuestion(Question question)
        {
            questions.Add(question);
        }
        private void MainMenu(){
            Console.WriteLine("          C# Program Quiz Game");
            Console.WriteLine("---------------------------------------");
            Console.WriteLine("                WELCOME");
            Console.WriteLine("                   to ");
            Console.WriteLine("                ThE GAME\n");
            Console.WriteLine("#######################################");
            Console.WriteLine("          BECOME A BILLIONAIRE! ");
            Console.WriteLine("#######################################\n");
            Console.WriteLine(" Press S to start the game ");
            Console.WriteLine(" Press V to view the highest score ");
            Console.WriteLine(" Press R to reset score ");
            Console.WriteLine(" Press H to for help          ");
            Console.WriteLine(" Press Q to quit       ");
            Console.WriteLine("_______________________________________");

            // get char
            char choice = Console.ReadKey().KeyChar;
            choice = char.ToUpper(choice);
            Console.Clear();

            switch(choice){
                case 'S':
                    startGame();
                    break;
                case 'V':
                    Console.WriteLine("Your highest score is: " + this.highScore);
                    Console.WriteLine("\n\n\n\nPress any key to continue...");
                    Console.ReadKey();
                    Console.Clear();
                    break;
                case 'R':
                    this.highScore = 0;
                    Console.WriteLine("Your score has been reset");
                    Console.WriteLine("\n\n\n\nPress any key to continue...");
                    Console.ReadKey();
                    Console.Clear();
                    break;
                case 'H':
                    Console.WriteLine("+---------------Welcome to C# Program Quiz Game---------------+");
                    Console.WriteLine("|    Here are some tips you might wanna know before playing   |");
                    Console.WriteLine("+-------------------------------------------------------------+");
                    Console.WriteLine(" >> There are 2 rounds in this Quiz Game, WARM UP ROUND AND CHALLENGE ROUND ");
                    Console.WriteLine(" >> In warm Up you will be ask a total of 3 question to test your ");
                    Console.WriteLine("    general knowledge. You are eligible to play the game if give atleast 2 ");
                    Console.WriteLine("    right answers, otherwise you can't proceed further to the Challenge round.");
                    Console.WriteLine(" >> Your game starts with Challenge round. In this round you will be ask a");
                    Console.WriteLine("    total of 10 questions. Each right answer will be awarded 10 peso!");
                    Console.WriteLine("    By this way you can win upto 100 pesos cash prize!.");
                    Console.WriteLine(" >> You will be given 4 options and you have to press A,B,C or D for the");
                    Console.WriteLine("    right option.");
                    Console.WriteLine(" >> You will be ask questions continuously, till right answer are given");
                    Console.WriteLine(" >> No negative marking for wrong answers");
                    Console.WriteLine("\n\n\n\nPress any key to continue...");
                    Console.ReadKey();
                    Console.Clear();
                    break;
                case 'Q':
                    this.close = true;
                    break;
                default:
                    Console.WriteLine("Invalid Choice\n");
                    break;
            }
        }
        private void startGame(){
            Console.Clear();
            int correct = 0;
            int i = 1;

            // randomize questions 
            Random rnd = new Random();
            this.questions = this.questions.OrderBy(x => rnd.Next()).ToList();            

            foreach (Question question in this.questions) {
                Console.Write("Question #" + i +": ");
                bool isCorrect = question.ask();
                if(isCorrect) correct++;
                i++;
            }
            if (correct > this.highScore) {
                this.highScore = correct;
                Console.WriteLine("You have set a New High Score!");
            }
            Console.WriteLine("You got " + correct + " out of " + questions.Count + " correct\n");
           
        }
    }

    class Question {
        private string question {get; set;  }
        private string answer {get; set;    }
        private string[] options {get; set; }
        private char[] abc;

        public Question(string question, string answer, string[] options) {
            this.question = question;
            this.answer = answer;
            this.options = options;

            // alphabet array A - Z
            this.abc = new char[26];
            for (int i = 0; i < this.abc.Length; i++) {
                this.abc[i] = (char)('A' + i);
            }
        }

        public bool ask() {
            List<string> choices = new List<string>(this.options);
            choices.Add(this.answer);

            // randomize choices
            Random rnd = new Random();
            for (int i = choices.Count - 1; i > 0; i--)
            {
                int j = rnd.Next(i + 1);
                string temp = choices[j];
                choices[j] = choices[i];
                choices[i] = temp;
            }

            int correctIndex = choices.IndexOf(this.answer); // index of correct answer

            // write question
            Console.WriteLine(this.question);
            for (int i = 0; i < choices.Count; i++) {
                Console.WriteLine("[" + this.abc[i] + "] " + choices[i]);
            }

            Console.Write("Enter your choice: ");
            char choice = Console.ReadKey().KeyChar;
            choice = char.ToUpper(choice);
            Console.Clear();

            if (choice == this.abc[correctIndex]) {
                Console.WriteLine("Correct!\n");
                return true;
            }
            else {
                Console.WriteLine("Incorrect! the correct answer is " + this.abc[correctIndex] + ". " + this.answer + "\n");
            }

            
            return false;
        }
    }
}
