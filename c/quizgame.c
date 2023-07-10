#include <stdio.h>
#include <windows.h>
#include <stdbool.h>

#define PROGRESS_BAR_SIZE 44

int highscore = 0;

void print_n_chars(int n, int c)
{
  while (n-- > 0)
    putchar(c);
}
void display_progress_bar(int p)
{
  putchar('\r');
  putchar('[');
  print_n_chars(PROGRESS_BAR_SIZE * p / 100, '|');
  print_n_chars(PROGRESS_BAR_SIZE - PROGRESS_BAR_SIZE * p / 100, ' ');
  putchar(']');
}
void game_loading()
{
  system("cls");
  printf("##############################################\n");
  printf("##                                          ##\n");
  printf("##               Game Loading               ##\n");
  printf("##                                          ##\n");
  printf("##############################################\n");
  printf("              ...Please Wait...\n\n");
  int p;
  for (p = 0; p <= 100; ++p)
  {
    display_progress_bar(p);
    Sleep(10);
  }
  system("cls");
}
void user_login()
{
  char *accounts[3][2] = {
      {"admin", "admin"},
      {"user", "user"},
      {"guest", "guest"}};

  char *username, *password;
  int i;
  bool is_login = false;
  while (!is_login)
  {
    system("cls");
    printf("Login\n");
    printf("Username: ");
    username = (char *)malloc(sizeof(char) * 20);
    scanf("%s", username);
    printf("Password: ");
    password = (char *)malloc(sizeof(char) * 20);
    scanf("%s", password);

    for (i = 0; i < 3; i++)
    {
      if (strcmp(username, accounts[i][0]) == 0 && strcmp(password, accounts[i][1]) == 0)
      {
        system("cls");
        printf("Welcome %s\n\n", username);
        is_login = true;
        break;
      }
    }

    if (!is_login)
    {
      printf("\n\nWrong username or password!\n");
      printf("Press any key to try again...\n");
      getch();
      system("cls");
    }
  }
}
char main_menu()
{
  char choice = '0';

  // check if choice is valid
  while (choice != 'S' && choice != 'V' && choice != 'R' && choice != 'H' && choice != 'Q')
  {
    system("cls");
    printf("           C Program Quiz Game\n");
    printf("---------------------------------------\n");
    printf("                WELCOME\n");
    printf("                   to \n");
    printf("                ThE GAME\n\n");
    printf("#######################################\n");
    printf("          BECOME A BILLIONAIRE! \n");
    printf("#######################################\n\n");
    printf(" Press S to start the game \n");
    printf(" Press V to view the highest score \n");
    printf(" Press R to reset score \n");
    printf(" Press H to for help          \n");
    printf(" Press Q to quit       \n");
    printf("_______________________________________\n");
    choice = getch();
    choice = toupper(choice);

    if (choice != 'S' && choice != 'V' && choice != 'R' && choice != 'H' && choice != 'Q')
    {
      printf("\n\nInvalid choice!\n");
      printf("Press any key to try again...\n");
      getch();
      system("cls");
    }
  }
}
void start_game()
{
  struct Question
  {
    char *question;
    char *answer;
    char *choices[3];
  };

  // questions var
  struct Question questions[11] = {
      {"What is the capital of India?", "New Delhi", {"Chennai", "Mumbai", "New Delhi", "Kolkata"}},
      {"What is the capital of China?", "Beijing", {"Shanghai", "Beijing", "Hong Kong", "Guangzhou"}},
      {"What is the capital of Brazil?", "Brasilia", {"Sao Paulo", "Rio de Janeiro", "Brasilia", "Lisbon"}},
      {"What is the capital of Australia?", "Canberra", {"Brisbane", "Sydney", "Melbourne", "Canberra"}},
      {"What is the capital of France?", "Paris", {"Lyon", "Paris", "Marseille", "Toulouse"}},
      {"What is the capital of Germany?", "Berlin", {"Frankfurt", "Munich", "Berlin", "Hamburg"}},
      {"What is the capital of Italy?", "Rome", {"Turin", "Milan", "Naples", "Rome"}},
      {"What is the capital of Russia?", "Moscow", {"Kazan", "Saint Petersburg", "Novosibirsk", "Moscow"}},
      {"What is the capital of Spain?", "Madrid", {"Valencia", "Barcelona", "Madrid", "Seville"}},
      {"What is the capital of the United States?", "Washington D.C.", {"Washington D.C.", "New York", "Los Angeles", "Chicago"}},
      {"What is the capital of the United Kingdom?", "London", {"Manchester", "London", "Liverpool", "Birmingham"}}
  };

  int score = 0;
  int i;
  int j;

  // generate alphabet array
  char alphabet[4] = {'A', 'B', 'C', 'D'};

  // ask each question
  for (i = 0; i < 10; i++)
  {
    printf("Question #%d: %s\n", i + 1, questions[i].question);
    char answer;
    for (j = 0; j < 4; j++)
    {
      printf("%c. %s\n", alphabet[j], questions[i].choices[j]);
      if (strcmp(questions[i].answer, questions[i].choices[j]) == 0)
      {
        answer = alphabet[j];
      }
    }

    char choice;
    while (1)
    {
      printf("\nYour answer: ");
      choice = getch();
      choice = toupper(choice);
      printf("%c\n", choice);
      if (choice >= 'A' && choice <= 'D')
      {
        break;
      }
      else
      {
        printf("Invalid choice! ");
      }
    }

    if (choice == answer)
    {
      score++;
      printf("\nCorrect!\n");
    }
    else
    {
      printf("\nWrong! The correct answer is %c.\n", answer);
    }

    printf("\n\nPress any key to continue...\n");
    getch();
    system("cls");
  }

  if (score > highscore)
  {
    highscore = score;
    printf("\n\nYou got a new high score!\n");
  }
  else
  {
    printf("\n\nYour score is %d\n", score);
  }
  printf("\n\nPress any key to continue...\n");
  getch();
  system("cls");
}
void view_highscore()
{
  system("cls");
  printf("\n\nHigh score: %d\n", highscore);
  printf("\n\nPress any key to continue...\n");
  getch();
  system("cls");
}
void reset_highscore()
{
  highscore = 0;
  printf("\n\nHigh score has been reset!\n");
  printf("\n\nPress any key to continue...\n");
  getch();
  system("cls");
}
void help()
{
  system("cls");
  printf("+----------------Welcome to C Program Quiz Game---------------+\n");
  printf("|    Here are some tips you might wanna know before playing   |\n");
  printf("+-------------------------------------------------------------+\n");
  printf(" >> There are 2 rounds in this Quiz Game, WARM UP ROUND AND CHALLENGE ROUND\n");
  printf(" >> In warm Up you will be ask a total of 3 question to test your\n");
  printf("    general knowledge. You are eligible to play the game if give atleast 2\n");
  printf("    right answers, otherwise you can't proceed further to the Challenge round.\n");
  printf(" >> Your game starts with Challenge round. In this round you will be ask a\n");
  printf("    total of 10 questions. Each right answer will be awarded 10 peso!\n");
  printf("    By this way you can win upto 100 pesos cash prize!.\n");
  printf(" >> You will be given 4 options and you have to press A,B,C or D for the\n");
  printf("    right option.\n");
  printf(" >> You will be ask questions continuously, till right answer are given\n");
  printf(" >> No negative marking for wrong answers\n");
  printf("\n\nPress any key to continue...\n");
  getch();
  system("cls");
}
int main()
{
  game_loading();
  user_login();

  char choice = 'Z';
  do
  {
    choice = main_menu();
    system("cls");

    switch (choice)
    {
    case 'S':
      start_game();
      break;
    case 'V':
      view_highscore();
      break;
    case 'R':
      reset_highscore();
      break;
    case 'H':
      help();
      break;
    case 'Q':
      break;
    default:
      printf("\n\nInvalid choice!\n");
      printf("Press any key to try again...\n");
      getch();
      break;
    }

  } while (choice != 'Q');

  printf("Thank you for playing!\n");

  return 0;
}