import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Pos {
	private static JFrame frame;
	private static ArrayList<Product> products;
	private static ButtonGroup customerType;
	private static JButton bt_add;
	private static JButton bt_checkout;
	private static JLabel l_menu;
	private static JLabel l_quantity;
	private static JLabel l_receipt;
	private static JLabel l_customer;
	private static JRadioButton r_regular;
	private static JRadioButton r_senior;
	private static JScrollPane scroll_menu;
	private static JScrollPane scroll_receipt;
	private static JTextArea ta_receipt;
	private static List productList;
	private static JSpinner qty;
	private static ArrayList<CartItem> cart;

	static class Product {
		public String name;
		public double price;
		
		Product(String name, double price) {
			this.name = name;
			this.price = price;
		}

		public String toString() {
			return name + " - PHP " + price;
		}
	}

	static class CartItem {
		public Product product;
		public int quantity;
		public double discount; // rate of discount
		
		CartItem(Product product, int quantity, double discount) {
			this.product = product;
			this.quantity = quantity;
			this.discount = discount;
		}
	}

	public static void main(String[] args) {
		products = new ArrayList<Product>();
		cart = new ArrayList<CartItem>();

		// Add products here
		products.add(new Product("Meal A", 100.00));
		products.add(new Product("Meal B", 150.00));

		initComponents();
	}

	private static void initComponents() {

		customerType = new ButtonGroup();
		l_menu = new JLabel();
		l_quantity = new JLabel();
		l_receipt = new JLabel();
		l_customer = new JLabel();
		scroll_menu = new JScrollPane();
		productList = new List();
		qty = new JSpinner();
		r_regular = new JRadioButton();
		r_senior = new JRadioButton();
		bt_add = new JButton();
		bt_checkout = new JButton();
		scroll_receipt = new JScrollPane();
		ta_receipt = new JTextArea();

		bt_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bt_addActionPerformed(evt);
			}
		});

		bt_checkout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bt_checkoutActionPerformed(evt);
			}
		});

		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		l_menu.setText("Menu");
		l_quantity.setText("Quantity");
		l_receipt.setText("Receipt");
		l_customer.setText("Type of Customer");
		r_regular.setText("Regular");
		r_senior.setText("Senior Citizen");
		bt_add.setText("ADD");
		bt_checkout.setText("CHECKOUT");

		qty.setValue(1);

		for (int i = 0; i < products.size(); i++) {
			productList.add(products.get(i).toString());
		}

		ta_receipt.setFont(new Font("Consolas", Font.PLAIN, 12));

		scroll_menu.setViewportView(productList);
		scroll_receipt.setViewportView(ta_receipt);

		customerType.add(r_regular);
		customerType.add(r_senior);
		ta_receipt.setColumns(20);
		ta_receipt.setRows(5);

		frame.getContentPane().add(l_menu);
		frame.getContentPane().add(scroll_menu);
		frame.getContentPane().add(l_quantity);
		frame.getContentPane().add(l_receipt);
		frame.getContentPane().add(l_customer);
		frame.getContentPane().add(qty);
		frame.getContentPane().add(r_regular);
		frame.getContentPane().add(r_senior);
		frame.getContentPane().add(bt_add);
		frame.getContentPane().add(bt_checkout);
		frame.getContentPane().add(scroll_receipt);

		l_menu.setBounds(10, 10, 120, 16);
		scroll_menu.setBounds(10, 30, 190, 140);
		qty.setBounds(100, 180, 100, 20);
		l_quantity.setBounds(10, 180, 120, 20);
		l_receipt.setBounds(280, 10, 130, 16);
		l_customer.setBounds(10, 220, 190, 16);
		r_regular.setBounds(30, 240, 170, 25);
		r_senior.setBounds(30, 265, 170, 25);
		bt_add.setBounds(20, 320, 70, 25);
		bt_checkout.setBounds(100, 320, 100, 25);
		scroll_receipt.setBounds(220, 30, 226, 310);

		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 410);
		frame.setLocationRelativeTo(null);
	}

	protected static void bt_checkoutActionPerformed(ActionEvent evt) {
		productList.select(-1);
		qty.setValue(1);
		
		String result = "\n-------------------------\n        RECEIPT\n-------------------------\n";
		double total = 0;
		for (int i = 0; i < cart.size(); i++) {
			CartItem item = cart.get(i);
			result += item.product.toString() + " x" + item.quantity +"\n";
			total += (item.product.price * item.quantity) - (item.product.price * item.quantity * item.discount);
		}
		result += "\n-------------------------\n";
		result += "Total: " + total + "\n";
		result += "-------------------------\n";
		ta_receipt.setText(result);
	}

	protected static void bt_addActionPerformed(ActionEvent evt) {
		double discount_rate = 0;

		int productIndex = productList.getSelectedIndex();
		if (productIndex < 0) {
			JOptionPane.showMessageDialog(frame, "Please select a product", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int quantity = (int) qty.getValue();
		if (quantity <= 0) {
			JOptionPane.showMessageDialog(frame, "Quality must be atleast 1", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (r_senior.isSelected()) {
			discount_rate = 0.20;
		} else if (r_regular.isSelected()) {
			discount_rate = 0;
		} else {
			JOptionPane.showMessageDialog(frame, "Please select a customer type", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		productList.select(-1);
		qty.setValue(1);

		cart.add(new CartItem(products.get(productIndex), quantity, discount_rate));

		updateOrders();
	}

	private static void updateOrders() {
		String result = "Orders:\n\n";
		double total = 0;
		for (int i = 0; i < cart.size(); i++) {
			CartItem item = cart.get(i);
			result += item.product.toString() + " x" + item.quantity +"\n";
			total += (item.product.price * item.quantity) - (item.product.price * item.quantity * item.discount);
		}
		result += "\nTotal: " + total;
		ta_receipt.setText(result);
	}
}
