import java.io.Console;

public class Chatbot {
	final static Console console = System.console();
	final static String[] greeting = { "Hello", "Hi", "Hey", "Howdy", "Greetings", "Good day", "Good to see you" };
	final static String[] farewell = { "Goodbye", "Bye", "See you later", "Have a nice day", "See you later" };

	// triggers
	final static String[] t_admission = { "register", "admission", "admit" };
	final static String[] t_departure = { "exit", "depart", "departure", "bye", "farewell", "thank", "q" };
	final static String[] t_another = { "yes", "y", "yeah", "ok", "okay", "sure", "affirmative", "affirm",
			"affirmatively", "affirmatively", "affirmed", "affirmedly" };
	final static String[] t_tuition = {"fee","tuition","how much","fees"};
	final static String[] t_courses = {"courses","course","list of course","course list"};

	// admission set of questions
	final static String[] q_admission = {
			"Oh great! may I know the student's name? ",
			"How about the student's gender? ",
			"Which level the student is applying? ",
			"What course is the student's applying to? "
	};

	private static String[] a_admission;
	private static String answer;
	private static boolean valid;
	public static void main(String[] args) {
		boolean run = true;
		int randomGreeting = (int) (Math.random() * greeting.length);
		System.out.format("%s!, this is a chatbot for school admission\n\n", greeting[randomGreeting]);
		while (run) {
			
			answer = console.readLine("bot: how can I help you?\nme: ").toLowerCase();
			valid = false;
			while (!valid){

				terminate(answer);

				for (int i = 0; i < t_admission.length; i++) {
					if (!valid && answer.contains(t_admission[i])) {
						a_admission = new String[q_admission.length];
						for (int j = 0; j < q_admission.length; j++) {
							System.out.format("bot: %s\n", q_admission[j]);
							a_admission[j] = console.readLine("me: ").toLowerCase();
						}
						System.out.println("bot: That's all I have for you, thank you for registering.");
						valid = true;
					}
				}

				for (int i = 0; i < t_tuition.length; i++) {
					if (!valid && answer.contains(t_tuition[i])){
						System.out.println("bot: The tuition fee is PHP 18,000 per semester");
						valid = true;
					}
				}

				for (int i = 0; i < t_courses.length; i++) {
					if (!valid && answer.contains(t_courses[i])){
						System.out.println("bot: The available courses we offers are: \n\tBS Computer Science\n\tBS Information Technology\n\tBS Business Administration");
						valid = true;
					}
				}

				if (!valid && answer == "") {
					answer = console.readLine("bot: Sorry, you didn't input anything\nbot: let's try again\nbot: How may I help you?").toLowerCase();
				} else if (!valid){
					answer = console.readLine("bot: Sorry, I don't understand what you said\nbot: let's try again\nbot: How can I help you?").toLowerCase();
				}
			}

			answer = console.readLine("bot: Do you have another request?\nme: ").toLowerCase();

			for (int i = 0; i < t_another.length; i++) {
				if (answer.contains(t_another[i])) run = false;
			}

			run = !run;

			if(!run) System.out.format("\n\nThank you for using our chatbot, %s!\n\n", farewell[(int) (Math.random() * farewell.length)]);
		}
	}

	public static void terminate(String answer){
		for (int i = 0; i < t_departure.length; i++) {
			if (answer.contains(t_departure[i])) {
				System.out.format("\n\nThank you for using our chatbot, %s!\n\n", farewell[(int) (Math.random() * farewell.length)]);
				System.exit(0);
			}
		}
	}
}