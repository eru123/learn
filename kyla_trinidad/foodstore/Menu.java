public interface Menu {
    static int MAX_ID = 1000;
    public int admin_id[] = {};
    public String admin_name[] = {};
    public String admin_password[] = {};
    public int employee_id[] = {};
    public String employee_name[] = {};
    public String employee_phone[] = {};
    public String employee_address[] = {};
    public String customer_name[] = {};
    public String transaction_name[] = {};
    public String transaction_address[] = {};
    public String transaction_phone[] = {};
    public String transaction_restaurant[] = {};
    public int transaction_orders[][] = {};
    public int transaction_quantities[][] = {};
    public boolean transaction_isDelivered[] = {};
    public boolean transaction_isPaid[] = {};
    public int transaction_employee_id[] = {};
    public int food_id[] = {};
    public String food_name[] = {};
    public double food_price[] = {};
    public String title = "";
    public String[] options = {};
    public int menu();
}
