import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuessTheWordSwing {
    // word list
    static String[] words = { "apple", "banana", "orange", "pear", "grape", "strawberry", "watermelon", "cherry",
            "mango", "pineapple", "peach", "plum", "coconut", "lemon", "lime" };
    static String word;
    static String firstLetter;
    static String lastLetter;
    static int life;

    public static void main(String[] args) {
        word = words[(int) (Math.random() * words.length)].toLowerCase();
        firstLetter = word.substring(0, 1);
        lastLetter = word.substring(word.length() - 1);
        life = 10;

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
                life--;
                if (life == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, "You lose!");
                    askRetry(frame, args);
                    return;
                } else {
                    textField.setText("");
                    JOptionPane.showMessageDialog(null,
                            "Wrong! You have " + life + " life left.\nHINT: First letter is "
                                    + firstLetter.toUpperCase() + " and last letter is " + lastLetter.toUpperCase());
                }
            }
        });

        frame.add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void askRetry(JFrame frame, String[] args) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirm", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            main(args);
        }
    }

    static class MyPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

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

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}
