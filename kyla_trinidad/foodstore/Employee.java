public class Employee extends MainMenu {
    private int current_id;
    private boolean is_login = false;

    public void open(){
        this.clearScreen();
        this.loadEmployeeData();
        this.login();
        // while(is_login){
        //     this.title = "EMPLOYEE MENU";
        //     this.options = new String[]{"Add Order", "Edit Order", "Delete Order", "View Orders/Receipt", "Checkout", "Return to Main Menu"};
        //     int choice = this.menu();
        //     assert choice >= 0 && choice < this.options.length;
        // }
    }

    // login
    public void login(){
        System.out.println("Employee\n");
        current_id = Integer.parseInt(console.readLine("Enter Employee ID: "));
        for(int i = 0; i < this.employee_id.length ; i++){
            if(current_id == this.employee_id[i]){
                is_login = true;
                this.clearScreen();
                break;
            }
        }
        if(!is_login){
            this.clearScreen();
            System.out.println("Invalid Employee ID\n");
            return;
        }
    }

}
