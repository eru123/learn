import java.applet.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GuessTheWordApplet extends Applet {
    // word list
    String[] words = { "apple", "banana", "orange", "pear", "grape", "strawberry", "watermelon", "cherry", "mango",
            "pineapple", "peach", "plum", "coconut", "lemon", "lime" };
    static String word;
    static String firstLetter;
    static String lastLetter;
    static int life;

    public static void main(String[] args) {
        GuessTheWordApplet applet = new GuessTheWordApplet();
        word = applet.words[(int) (Math.random() * applet.words.length)].toLowerCase();
        firstLetter = word.substring(0, 1);
        lastLetter = word.substring(word.length() - 1);
        life= 10;

        System.out.println("Debug: Word is " + word);

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Guess The Word");

        // add text field
        TextField textField = new TextField();
        textField.setBounds(230, 160, 100, 20);
        frame.add(textField);

        // button
        Button button = new Button("Guess");
        button.setBounds(230, 200, 100, 20);
        frame.add(button);

        // add button event listener
        button.addActionListener(e -> {
            String guess = textField.getText().toLowerCase();
            if (guess.equals(word)) {
                frame.setVisible(false);
                frame.dispose();
                JOptionPane.showMessageDialog(null, "You win!");
                askRetry(frame, args);
            } else {
                frame.setVisible(false);
                frame.dispose();
                textField.setText("");
                life--;
                if (life == 0) {
                    JOptionPane.showMessageDialog(null, "You lose!");
                    askRetry(frame, args);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Wrong! You have " + life + " life left.\nHINT: First letter is " + firstLetter.toUpperCase()
                                    + " and last letter is " + lastLetter.toUpperCase());
                }
            }
        });

        frame.add(applet);
        applet.init();
        applet.start();
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        this.setSize(400, 400);
    }

    public void paint(Graphics g) {
        // draw the word to guess
        g.drawString("Word List", 20, 20);
        g.drawRect(20, 30, 150, 310);
        for (int i = 0; i < words.length; i++) {
            g.drawString(words[i], 30, 50 + i * 20);
        }

        // guess the word label for input
        g.drawString("Guess the secret word", 220, 60);
        g.drawString("from the word list", 230, 80);
        g.drawString("Input your answer in the box", 200, 150);
    }

    public static void askRetry(JFrame frame, String[] args) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to play again?","Confirm",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            main(args);
        }
    }
}
