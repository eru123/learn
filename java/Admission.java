import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class Admission  {
	private static JFrame frame;
	private static ButtonGroup year;
    private static JButton calculate;
    private static JLabel cp_mj;
    private static JLabel cp_mj1;
    private static JLabel cp_mj2;
    private static JLabel cp_mj3;
    private static JLabel cp_mj4;
    private static JLabel cp_mn;
    private static JLabel cp_mn1;
    private static JLabel cp_mn2;
    private static JLabel cp_mn3;
    private static JRadioButton cp_r1;
    private static JRadioButton cp_r2;
    private static JRadioButton cp_r3;
    private static JRadioButton cp_r4;
    private static JLabel cp_unit;
    private static JLabel cost_l;
    private static JScrollPane jScrollPane1;
    private static JCheckBox mj_sub1;
    private static JCheckBox mj_sub2;
    private static JCheckBox mj_sub3;
    private static JCheckBox mj_sub4;
    private static JLabel mj_subs1;
    private static JLabel mj_units1;
    private static JCheckBox mn_sub1;
    private static JCheckBox mn_sub2;
    private static JCheckBox mn_sub3;
    private static JCheckBox mn_sub4;
    private static JLabel mn_subs;
    private static JLabel mn_units;
    private static JTextArea summary;
    private static JLabel summary_l;
    private static JTextField tc;
    private static JLabel tcl;
    private static JTextField tmjc;
    private static JLabel tmjl;
    private static JTextField tmnc;
    private static JLabel tmnl;

	public static void main(String args[]) {
        initComponents();
    }

    private static void initComponents() {
        year = new ButtonGroup();
        mj_units1 = new JLabel();
        mj_subs1 = new JLabel();
        mj_sub1 = new JCheckBox();
        mj_sub2 = new JCheckBox();
        mj_sub3 = new JCheckBox();
        mj_sub4 = new JCheckBox();
        mn_units = new JLabel();
        mn_subs = new JLabel();
        mn_sub1 = new JCheckBox();
        mn_sub2 = new JCheckBox();
        mn_sub3 = new JCheckBox();
        mn_sub4 = new JCheckBox();
        cp_unit = new JLabel();
        cp_mj = new JLabel();
        cp_mn = new JLabel();
        cp_mn1 = new JLabel();
        cp_mj2 = new JLabel();
        cp_mn2 = new JLabel();
        cp_mj1 = new JLabel();
        cp_mj3 = new JLabel();
        cp_mn3 = new JLabel();
        cp_mj4 = new JLabel();
        cp_r4 = new JRadioButton();
        cp_r3 = new JRadioButton();
        cp_r2 = new JRadioButton();
        cp_r1 = new JRadioButton();
        jScrollPane1 = new JScrollPane();
        summary = new JTextArea();
        summary_l = new JLabel();
        tmjc = new JTextField();
        tmnc = new JTextField();
        tc = new JTextField();
        tcl = new JLabel();
        tmnl = new JLabel();
        tmjl = new JLabel();
        calculate = new JButton();
        cost_l = new JLabel();

		frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Program");
        frame.getContentPane().setLayout(null);

		// set major subjects
        mj_sub1.setText("Major Subject 1");
		mj_sub2.setText("Major Subject 2");
		mj_sub3.setText("Major Subject 3");
		mj_sub4.setText("Major Subject 4");

		// set major subject price for each year level
		cp_mj1.setText("500");
        cp_mj2.setText("400");
        cp_mj3.setText("300");
        cp_mj4.setText("200");

		// set minor subjects
		mn_sub1.setText("Minor Subject 1");
		mn_sub2.setText("Minor Subject 2");
		mn_sub3.setText("Minor Subject 3");
		mn_sub4.setText("Minor Subject 4");

		// set minor subject price for each year level
        cp_mn1.setText("300");
        cp_mn2.setText("200");
        cp_mn3.setText("100");

		// Set text
        mj_units1.setText("6 Units");
		mj_subs1.setText("Major Subjects");
		mn_units.setText("3 Units");
        mn_subs.setText("Minor Subjects");
        cp_unit.setText("Cost Per Unit");
        cp_mj.setText("Major");
        cp_mn.setText("Minor");
        cp_r4.setText("4th Year");
        cp_r3.setText("3rd Year");
        cp_r2.setText("2nd Year");
        cp_r1.setText("1st Year");
        summary_l.setText("Summary");
        tcl.setText("Total Cost");
        tmnl.setText("Total Minor Units");
        tmjl.setText("Total Major Units");
        calculate.setText("Calculate");
        cost_l.setText("Cost");

		summary.setColumns(20);
        summary.setRows(5);
        jScrollPane1.setViewportView(summary);

		calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

		// year btn group
		year.add(cp_r4);
        year.add(cp_r3);
        year.add(cp_r2);
        year.add(cp_r1);

		// add to frame
        frame.getContentPane().add(mj_units1);
        frame.getContentPane().add(mj_subs1);
        frame.getContentPane().add(mj_sub1);
        frame.getContentPane().add(mj_sub2);
        frame.getContentPane().add(mj_sub3);
        frame.getContentPane().add(mj_sub4);
        frame.getContentPane().add(mn_units);
        frame.getContentPane().add(mn_subs);
        frame.getContentPane().add(mn_sub1);
        frame.getContentPane().add(mn_sub2);
        frame.getContentPane().add(mn_sub3);
        frame.getContentPane().add(mn_sub4);
        frame.getContentPane().add(cp_unit);
        frame.getContentPane().add(cp_mj);
        frame.getContentPane().add(cp_mn);
        frame.getContentPane().add(cp_mn1);
        frame.getContentPane().add(cp_mj2);
        frame.getContentPane().add(cp_mn2);
        frame.getContentPane().add(cp_mj1);
        frame.getContentPane().add(cp_mj3);
        frame.getContentPane().add(cp_mn3);
        frame.getContentPane().add(cp_mj4);
        frame.getContentPane().add(cp_r4);
        frame.getContentPane().add(cp_r3);
        frame.getContentPane().add(cp_r2);
        frame.getContentPane().add(cp_r1);
        frame.getContentPane().add(jScrollPane1);
        frame.getContentPane().add(summary_l);
        frame.getContentPane().add(tmjc);
        frame.getContentPane().add(tmnc);
        frame.getContentPane().add(tc);
        frame.getContentPane().add(tcl);
        frame.getContentPane().add(tmnl);
        frame.getContentPane().add(tmjl);
        frame.getContentPane().add(calculate);
        frame.getContentPane().add(cost_l);

		// set position
        mj_units1.setBounds(110, 20, 100, 16);
        mj_subs1.setBounds(90, 40, 100, 16);
        mj_sub1.setBounds(50, 70, 155, 25);
        mj_sub2.setBounds(50, 90, 155, 25);
        mj_sub3.setBounds(50, 110, 155, 25);
        mj_sub4.setBounds(50, 130, 155, 25);
        mn_units.setBounds(290, 20, 100, 16);
        mn_subs.setBounds(270, 40, 100, 16);
        mn_sub1.setBounds(230, 70, 155, 25);
        mn_sub2.setBounds(230, 90, 155, 25);
        mn_sub3.setBounds(230, 110, 155, 25);
        mn_sub4.setBounds(230, 130, 155, 25);
        cp_unit.setBounds(130, 190, 80, 16);
        cp_mj.setBounds(180, 220, 40, 16);
        cp_mn.setBounds(230, 220, 40, 16);
        cp_mj1.setBounds(180, 250, 30, 16);
        cp_mj2.setBounds(180, 280, 40, 16);
        cp_mj3.setBounds(180, 310, 30, 16);
        cp_mj4.setBounds(180, 340, 40, 16);
		cp_mn1.setBounds(230, 250, 40, 16);
        cp_mn2.setBounds(230, 280, 40, 16);
        cp_mn3.setBounds(230, 310, 40, 16);
        cp_r1.setBounds(70, 250, 91, 25);
        cp_r2.setBounds(70, 280, 91, 25);
        cp_r3.setBounds(70, 310, 91, 25);
        cp_r4.setBounds(70, 340, 91, 25);
        jScrollPane1.setBounds(340, 230, 259, 267);
        summary_l.setBounds(340, 210, 90, 16);
        tmjc.setBounds(200, 410, 86, 22);
        tmnc.setBounds(200, 440, 86, 22);
        tc.setBounds(200, 480, 86, 22);
        tcl.setBounds(60, 480, 131, 16);
        tmnl.setBounds(60, 440, 131, 16);
        tmjl.setBounds(60, 410, 131, 16);
        calculate.setBounds(120, 520, 90, 25);
        cost_l.setBounds(200, 390, 43, 16);

        frame.getAccessibleContext().setAccessibleParent(frame);
		frame.setVisible(true);
        frame.pack();
		frame.setSize(670,630);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
    }                     
    

	private static void calculateActionPerformed(java.awt.event.ActionEvent evt) {
		int major_price = 0;
		int minor_price = 0;
		int total_major = 0;
		int total_minor = 0;
		int total_cost = 0;

		ArrayList<String> majors = new ArrayList<String>();
		ArrayList<String> minors = new ArrayList<String>();

		if (mj_sub1.isSelected()) majors.add(mj_sub1.getText());
		if (mj_sub2.isSelected()) majors.add(mj_sub2.getText());
		if (mj_sub3.isSelected()) majors.add(mj_sub3.getText());
		if (mj_sub4.isSelected()) majors.add(mj_sub4.getText());
		if (mn_sub1.isSelected()) minors.add(mn_sub1.getText());
		if (mn_sub2.isSelected()) minors.add(mn_sub2.getText());
		if (mn_sub3.isSelected()) minors.add(mn_sub3.getText());
		if (mn_sub4.isSelected()) minors.add(mn_sub4.getText());

		if(minors.size() == 0 && majors.size() == 0) {
			JOptionPane.showMessageDialog(null, "Please select atleast 1 subject", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(cp_r1.isSelected()) {
			major_price = 500;
			minor_price = 300;
		} else if(cp_r2.isSelected()) {
			major_price = 400;
			minor_price = 200;
		} else if(cp_r3.isSelected()) {
			major_price = 300;
			minor_price = 100;
		} else if(cp_r4.isSelected()) {
			major_price = 200;
			minor_price = 0;
		} else {
			JOptionPane.showMessageDialog(null, "Please select a year level", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		total_major = majors.size() * major_price;
		total_minor = minors.size() * minor_price;
		total_cost = total_major + total_minor;

		tmjc.setText(String.valueOf(total_major));
		tmnc.setText(String.valueOf(total_minor));
		tc.setText(String.valueOf(total_cost));

		String result = "";
		if (majors.size() > 0) {
			result += "\nMajor Subjects: \n";
			for (String major : majors) result += major + "  -  PHP " + major_price + "\n";
		}
		if (minors.size() > 0) {
			result += "\nMinor Subjects: \n";
			for (String minor : minors) result += minor + "  -  PHP " + minor_price + "\n";
		}
		result += "\nTotal Subjects: " + (majors.size() + minors.size()) + "\n";
		result += "\nTotal Major: PHP " + total_major + "\nTotal Minor: PHP " + total_minor + "\nTotal Cost: PHP " + total_cost;
		summary.setText(result);
    } 
}
