import javax.swing.*;
import java.awt.event.*;

public class Triangle {
	private static JFrame frame;
    private static JButton bt_ok;
    private static JButton bt_reset;
    private static javax.swing.ButtonGroup radio_buttons;
    private static JLabel l_area;
    private static JLabel l_per;
    private static JLabel l_s1;
    private static JLabel l_s2;
    private static JLabel l_s3;
    private static JRadioButton r_area;
    private static JRadioButton r_per;
    private static JTextField tf_area;
    private static JTextField tf_per;
    private static JTextField tf_s1;
    private static JTextField tf_s2;
    private static JTextField tf_s3;
	
	public static void main(String[] args) {
		initComponents();
	}

    private static void initComponents() {
        radio_buttons = new ButtonGroup();
        l_s1 = new JLabel();
        l_s2 = new JLabel();
        l_area = new JLabel();
        l_s3 = new JLabel();
        l_per = new JLabel();
        r_area = new JRadioButton();
        r_per = new JRadioButton();
        bt_ok = new JButton();
        bt_reset = new JButton();
        tf_per = new JTextField();
        tf_s1 = new JTextField();
        tf_s2 = new JTextField();
        tf_s3 = new JTextField();
        tf_area = new JTextField();

		bt_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bt_okActionPerformed(evt);
			}
		});

		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bt_resetActionPerformed(evt);
			}
		});

		frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

		// set text
        l_s1.setText("Side 1 (Base)");
        l_s2.setText("Side 2 (Height)");
		l_area.setText("Area");
        l_s3.setText("Side 3");
        l_per.setText("Perimeter");
        r_area.setText("Area");
        r_per.setText("Perimeter");
        bt_ok.setText("OK");
        bt_reset.setText("RESET");

		// add to radio buttons group
		radio_buttons.add(r_area);
        radio_buttons.add(r_per);

		// add to frame 
        frame.getContentPane().add(l_s1);
        frame.getContentPane().add(l_s2);
        frame.getContentPane().add(l_area);
        frame.getContentPane().add(l_s3);
        frame.getContentPane().add(l_per);
        frame.getContentPane().add(r_area);
        frame.getContentPane().add(r_per);
        frame.getContentPane().add(bt_ok);
        frame.getContentPane().add(bt_reset);
        frame.getContentPane().add(tf_per);
        frame.getContentPane().add(tf_s1);
        frame.getContentPane().add(tf_s2);
        frame.getContentPane().add(tf_s3);
        frame.getContentPane().add(tf_area);

        l_s1.setBounds(10, 10, 100, 16);
        l_s2.setBounds(10, 40, 100, 16);
        l_s3.setBounds(10, 70, 100, 16);
        l_area.setBounds(10, 100, 100, 16);
        l_per.setBounds(10, 130, 100, 16);
        r_area.setBounds(10, 160, 100, 25);
        r_per.setBounds(10, 190, 86, 25);

		tf_s1.setBounds(120, 10, 120, 22);
        tf_s2.setBounds(120, 40, 120, 22);
        tf_s3.setBounds(120, 70, 120, 22);
        tf_area.setBounds(120, 100, 120, 22);
        tf_per.setBounds(120, 130, 120, 22);

        bt_ok.setBounds(10, 230, 80, 25);
        bt_reset.setBounds(100, 230, 100, 25);
		
        frame.pack();
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Triangle");
    }

	protected static void bt_resetActionPerformed(ActionEvent evt) {
		tf_s1.setText("");
		tf_s2.setText("");
		tf_s3.setText("");
		tf_area.setText("");
		tf_per.setText("");
		r_area.setSelected(false);
		r_per.setSelected(false);
	}

	protected static void bt_okActionPerformed(ActionEvent evt) {
		double s1, s2, s3, area, per;
		s1 = Double.parseDouble(tf_s1.getText());
		s2 = Double.parseDouble(tf_s2.getText());
		s3 = Double.parseDouble(tf_s3.getText());
		if (r_area.isSelected()) {
			area = s1 * s2 / 2;
			tf_per.setText("");
			tf_area.setText(String.valueOf(area));
		} else if (r_per.isSelected()) {
			per = s1 + s2 + s3;
			tf_area.setText("");
			tf_per.setText(String.valueOf(per));
		} else {
			JOptionPane.showMessageDialog(null, "Please select one of the options", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
