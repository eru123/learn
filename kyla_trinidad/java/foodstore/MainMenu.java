import java.io.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public abstract class MainMenu {
    final static String DELIMITER = ",";
    final static String ORDER_DELIMITER = ":";
    final static Console console = System.console();
    final static String[] STORES = { "Mcdo", "Jollibee", "Starbucks", "Burger King", "KFC" };
    final static String ADMIN_FILE = "admins.txt";
    final static String EMPLOYEE_FILE = "employees.txt";
    final static String TRANSACTION_FILE = "transactions.txt";
    final static String FOODS_FILE = "foods.txt";
    final static DecimalFormat df = new DecimalFormat("0.00");

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public int showMenu(String title, String[] options) {
        int counter = 0;
        while (true) {
            System.out.println(title + "\n");
            for (int i = 0; i < options.length; i++) {
                if (options[i] != null && options[i] != "") {
                    System.out.println(i + 1 + ". " + options[i]);
                    counter++;
                }
            }
            try {
                int choice = Integer.parseInt(console.readLine("\nEnter your choice: "));
                if (choice > 0 && choice <= counter) {
                    clearScreen();
                    return choice - 1;
                } else {
                    clearScreen();
                    System.out.println("Invalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                clearScreen();
                System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    public String[][] getDataFromFile(String file, int fieldCount) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(DELIMITER);
                data.add(fields);
            }
            br.close();
        } catch (IOException e) {
            // ignore error
            // it is expected that there will be error
            // on the first run, because the file doesn't
            // already exists
        }

        String[][] dataArray = new String[data.size()][fieldCount];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i);
        }
        return dataArray;
    }

    public void writeDataToFile(String file, String[][] data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (int i = 0; i < data.length; i++) {
                String line = "";
                for (int j = 0; j < data[i].length; j++) {
                    line += data[i][j];
                    if (j != data[i].length - 1)
                        line += DELIMITER;
                }
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + file);
        }
    }

    class FoodType {
        public int id;
        public String name;
        public double price;
        public int store;

        public FoodType(int id, String name, double price, int store) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.store = store;
        }
    }

    class Foods {
        private ArrayList<FoodType> foods = new ArrayList<FoodType>();

        public Foods() {
            loadFromFile();
        }

        public void loadFromFile() {
            String[][] data = getDataFromFile(FOODS_FILE, 4);
            for (int i = 0; i < data.length; i++) {
                foods.add(new FoodType(Integer.parseInt(data[i][0]), data[i][1], Double.parseDouble(data[i][2]),
                        Integer.parseInt(data[i][3])));
            }
        }

        public boolean foodIdExists(int id) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).id == id)
                    return true;
            }
            return false;
        }

        public void toFile() {
            String[][] data = new String[foods.size()][4];
            for (int i = 0; i < foods.size(); i++) {
                data[i][0] = Integer.toString(foods.get(i).id);
                data[i][1] = foods.get(i).name;
                data[i][2] = Double.toString(foods.get(i).price);
                data[i][3] = Integer.toString(foods.get(i).store);
            }
            writeDataToFile(FOODS_FILE, data);
        }

        public void add(int id, String name, double price, int store) {
            FoodType f = new FoodType(id, name, price, store);
            foods.add(f);
            toFile();
        }

        public boolean update(int id, String name, double price, int store) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).id == id) {
                    foods.get(i).name = name;
                    foods.get(i).price = price;
                    foods.get(i).store = store;
                    toFile();
                    return true;
                }
            }
            return false;
        }

        public boolean remove(int id) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).id == id) {
                    foods.remove(i);
                    toFile();
                    return true;
                }
            }
            return false;
        }

        public String[][] listAll() {
            String[][] data = new String[foods.size()][6];
            for (int i = 0; i < foods.size(); i++) {
                data[i][0] = Integer.toString(foods.get(i).id);
                data[i][1] = foods.get(i).name;
                data[i][2] = Double.toString(foods.get(i).price);
                data[i][3] = Integer.toString(foods.get(i).store);
                data[i][4] = STORES[foods.get(i).store];
                data[i][5] = STORES[foods.get(i).store] + " - " + foods.get(i).name + " - "
                        + Double.toString(foods.get(i).price) + " PHP";
            }
            return data;
        }

        public String[][] listByStore(int store) {
            String[][] data = new String[foods.size()][6];
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).store == store) {
                    data[i][0] = Integer.toString(foods.get(i).id);
                    data[i][1] = foods.get(i).name;
                    data[i][2] = Double.toString(foods.get(i).price);
                    data[i][3] = Integer.toString(foods.get(i).store);
                    data[i][4] = STORES[foods.get(i).store];
                    data[i][5] = foods.get(i).name + " - " + Double.toString(foods.get(i).price) + " PHP";
                }
            }
            return data;
        }

        public String getName(int id) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).id == id) {
                    return foods.get(i).name;
                }
            }
            return "";
        }

        public Double getPrice(int id) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).id == id) {
                    return foods.get(i).price;
                }
            }
            return 0.0;
        }

        public String[] parseList(String[][] data, int index) {
            String[] list = new String[data.length];
            for (int i = 0; i < data.length; i++) {
                list[i] = data[i][index];
            }
            return list;
        }
    }

    class AdminType {
        private int id;
        private String name;
        private String password;

        public AdminType(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public boolean equals(int id, String password) {
            if (this.id == id && this.password.equals(password)) {
                return true;
            }
            return false;
        }
    }

    class Admins {
        private ArrayList<AdminType> admins = new ArrayList<AdminType>();
        private boolean authenticated = false;
        private AdminType admin;
        public Admins() {
            loadFromFile();
        }

        public void add(int id, String name, String password) {
            AdminType a = new AdminType(id, name, password);
            admins.add(a);
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void logout() {
            authenticated = false;
        }

        public boolean login(int id, String password) {
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(i).equals(id, password)) {
                    admin = admins.get(i);
                    authenticated = true;
                    return true;
                }
            }
            return false;
        }

        public void register(int id, String name, String password) {
            AdminType a = new AdminType(id, name, password);
            admins.add(a);
            toFile();
        }

        public String getName() {
            return admin.name;
        }

        private void loadFromFile() {
            String[][] data = getDataFromFile(ADMIN_FILE, 3);
            for (int i = 0; i < data.length; i++) {
                add(Integer.parseInt(data[i][0]), data[i][1], data[i][2]);
            }
        }

        private void toFile() {
            String[][] data = new String[admins.size()][3];
            for (int i = 0; i < admins.size(); i++) {
                data[i][0] = Integer.toString(admins.get(i).id);
                data[i][1] = admins.get(i).name;
                data[i][2] = admins.get(i).password;
            }
            writeDataToFile(ADMIN_FILE, data);
        }
    }

    class EmployeeType {
        int id;
        String name;
        String phone;
        String address;

        public EmployeeType(int id, String name, String phone, String address) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.address = address;
        }
    }

    class Employees {
        public ArrayList<EmployeeType> employees = new ArrayList<EmployeeType>();
        private int current_employee;
        private boolean authenticated = false;

        public Employees() {
            loadFromFile();
        }

        public void add(int id, String name, String phone, String address) {
            EmployeeType e = new EmployeeType(id, name, phone, address);
            employees.add(e);
            toFile();
        }

        public String[][] getEmployeeData() {
            String[][] data = new String[employees.size()][5];
            for (int i = 0; i < employees.size(); i++) {
                data[i][0] = Integer.toString(employees.get(i).id);
                data[i][1] = employees.get(i).name;
                data[i][2] = employees.get(i).phone;
                data[i][3] = employees.get(i).address;
            }
            return data;
        }

        public boolean employeeIdExists(int id) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).id == id) {
                    return true;
                }
            }
            return false;
        }

        public boolean remove(int id) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).id == id) {
                    employees.remove(i);
                    toFile();
                    return true;
                }
            }
            return false;
        }

        private void loadFromFile() {
            String[][] data = getDataFromFile(EMPLOYEE_FILE, 4);
            for (int i = 0; i < data.length; i++) {
                add(Integer.parseInt(data[i][0]), data[i][1], data[i][2], data[i][2]);
            }
        }

        private void toFile() {
            String[][] data = new String[employees.size()][4];
            for (int i = 0; i < employees.size(); i++) {
                data[i][0] = Integer.toString(employees.get(i).id);
                data[i][1] = employees.get(i).name;
                data[i][2] = employees.get(i).phone;
                data[i][3] = employees.get(i).address;
            }
            writeDataToFile(EMPLOYEE_FILE, data);
        }

        public boolean login(int id) {
            for (int i = 0; i < employees.size(); i++) {
                if (id == employees.get(i).id){
                    current_employee = id;
                    authenticated = true;
                    return true;
                }
            }
            return false;
        }

        public void logout(){
            current_employee = -1;
            authenticated = false;
        }

        public int getCurrentEmployeeId(){
            for (int i = 0; i < employees.size(); i++) {
                if (current_employee == employees.get(i).id){
                    return employees.get(i).id;
                }
            }
            return -1;
        }

        public EmployeeType getCurrentEmployee(){
            for (int i = 0; i < employees.size(); i++) {
                if (current_employee == employees.get(i).id){
                    return employees.get(i);
                }
            }
            return null;
        }

        public boolean isAuthenticated(){
            return authenticated;
        }
    }

    class Transaction {
        public String name;
        public String address;
        public String phone;
        public int store;
        public ArrayList<Integer> orders = new ArrayList<Integer>();
        public ArrayList<Integer> qty = new ArrayList<Integer>();
        public boolean isDelivered;
        public boolean isPaid;
        public int employee;

        public Transaction(String name, String address, String phone, int store, ArrayList<Integer> orders,
                ArrayList<Integer> qty, boolean isDelivered, boolean isPaid, int employee) {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.store = store;
            this.orders = orders;
            this.qty = qty;
            this.isDelivered = isDelivered;
            this.isPaid = isPaid;
            this.employee = employee;
        }

        public String getOrderString() {
            String s = "";
            for (int i = 0; i < orders.size(); i++) {
                s += orders.get(i);
                if (i != orders.size() - 1) {
                    s += ORDER_DELIMITER;
                }
            }
            return s;
        }

        public String getQtyString() {
            String s = "";
            for (int i = 0; i < qty.size(); i++) {
                s += qty.get(i);
                if (i != qty.size() - 1) {
                    s += ORDER_DELIMITER;
                }
            }
            return s;
        }

        public String[] getOrders() {
            Foods foods = new Foods();
            String[] ordersList = new String[orders.size()];
            for (int i = 0; i < orders.size(); i++) {
                int t_id = orders.get(i);
                int t_qty = (int) qty.get(i);
                String t_name = foods.getName(t_id);
                double t_price = foods.getPrice(t_id) * t_qty;
                ordersList[i] = t_name + " x" + t_qty + " - PHP " + t_price;
            }
            return ordersList;
        }

        public String[][] getOrdersTableData() {
            Foods foods = new Foods();
            String[][] data = new String[orders.size()][4];
            for (int i = 0; i < orders.size(); i++) {
                int t_id = orders.get(i);
                int t_qty = (int) qty.get(i);
                String t_name = foods.getName(t_id);
                double t_price = foods.getPrice(t_id);
                data[i][0] = t_name;
                data[i][1] = Double.toString(t_price);
                data[i][2] = Integer.toString(t_qty);
                data[i][3] = Double.toString(t_price * t_qty);
            }
            return data;
        }

        public void printReceiptTable(boolean isCustomer) {
            String[][] data = getOrdersTableData();
            System.out.format("+-----------------+----------------------------------------------------+\n");
            if (!isCustomer) {
                System.out.format("| %15s | %50s |\n", "PAYMENT STATUS", (this.isPaid ? "PAID" : "PENDING"));
                System.out.format("| %15s | %50s |\n", "DELIVERY STATUS", (this.isDelivered ? "DELIVERED" : "PENDING"));
            }
            System.out.format("| %15s | %50s |\n", "NAME", this.name);
            System.out.format("| %15s | %50s |\n", "ADDRESS", this.address);
            System.out.format("| %15s | %50s |\n", "PHONE", this.phone);
            System.out.format("| %15s | %50s |\n", "STORE", STORES[this.store]);
            System.out.format("+-----------------+----------------------------------------------------+\n");
            double total = 0;
            for (int i = 0; i < data.length; i++) {
                String food_name = data[i][0];
                int food_qty = Integer.parseInt(data[i][2]);
                double food_total = Double.parseDouble(data[i][3]);
                total += food_total;
                if (i == 0) {
                    System.out.format("| %15s | %25s %6dx %16s |\n", "ORDERS", food_name, food_qty,
                            Double.toString(food_total));
                } else {
                    System.out.format("| %15s | %25s %6dx %16s |\n", "", food_name, food_qty,
                            Double.toString(food_total));
                }
            }
            System.out.format("+-----------------+----------------------------------------------------+\n");
            System.out.format("| %15s | %50s |\n", "TOTAL", df.format(total));
            System.out.format("+-----------------+----------------------------------------------------+\n");
        }

        public void updateOrder(int order, int quantity) {
            qty.set(order, quantity);
        }

        public void addOrder(int id, int q) {
            orders.add(id);
            qty.add(q);
        }

        public void removeOrder(int id) {
            orders.remove(id);
            qty.remove(id);
        }
    }

    class Transactions {
        public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        private int current = 0;

        public Transactions() {
            loadFromFile();
        }

        public void add(String name, String address, String phone, int store, ArrayList<Integer> orders,
                ArrayList<Integer> qty, boolean isDelivered, boolean isPaid, int employee) {
            Transaction t = new Transaction(name, address, phone, store, orders, qty, isDelivered, isPaid, employee);
            transactions.add(t);
            toFile();
        }

        public String[][] getTranstactionData() {
            String[][] data = new String[transactions.size()][7];
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                data[i][0] = Integer.toString(i + 1);
                data[i][1] = t.name;
                data[i][2] = t.address;
                data[i][3] = t.phone;
                data[i][4] = STORES[t.store];
                data[i][5] = t.getOrderString();
                data[i][6] = t.getQtyString();
            }
            return data;
        }

        public void add(Transaction t) {
            transactions.add(t);
            toFile();
        }

        public Transaction getCurrent() {
            if (transactions.size() == 0) {
                return null;
            }
            for (int i = current; i < transactions.size(); i++) {
                if (!transactions.get(i).isDelivered || !transactions.get(i).isPaid) {
                    current = i;
                    return transactions.get(i);
                }
            }
            return null;
        }

        public boolean isCurrentValid() {
            return !transactions.get(current).isPaid || !transactions.get(current).isDelivered;
        }

        public void payCurrent(int employee_id) {
            if (isCurrentValid()) {
                transactions.get(current).isPaid = true;
                transactions.get(current).employee = employee_id;
                getCurrent();
                toFile();
            }
        }

        public void deliverCurrent(int employee_id) {
            if (isCurrentValid()) {
                transactions.get(current).isDelivered = true;
                transactions.get(current).employee = employee_id;
                getCurrent();
                toFile();
            }
        }

        public void loadFromFile() {
            String[][] data = getDataFromFile(TRANSACTION_FILE, 9);
            for (int i = 0; i < data.length; i++) {
                ArrayList<Integer> orders = new ArrayList<Integer>();
                ArrayList<Integer> qty = new ArrayList<Integer>();
                for (String e : data[i][4].split(ORDER_DELIMITER))
                    orders.add(Integer.parseInt(e));
                for (String e : data[i][5].split(ORDER_DELIMITER))
                    qty.add(Integer.parseInt(e));
                add(data[i][0],
                        data[i][1],
                        data[i][2],
                        Integer.parseInt(data[i][3]),
                        orders,
                        qty,
                        Boolean.parseBoolean(data[i][6]),
                        Boolean.parseBoolean(data[i][7]),
                        Integer.parseInt(data[i][8]));
            }
        }

        public void toFile() {
            String[][] data = new String[transactions.size()][9];
            for (int i = 0; i < transactions.size(); i++) {
                data[i][0] = transactions.get(i).name;
                data[i][1] = transactions.get(i).address;
                data[i][2] = transactions.get(i).phone;
                data[i][3] = Integer.toString(transactions.get(i).store);
                data[i][4] = transactions.get(i).getOrderString();
                data[i][5] = transactions.get(i).getQtyString();
                data[i][6] = Boolean.toString(transactions.get(i).isDelivered);
                data[i][7] = Boolean.toString(transactions.get(i).isPaid);
                data[i][8] = Integer.toString(transactions.get(i).employee);
            }
            writeDataToFile(TRANSACTION_FILE, data);
        }
    }
}
