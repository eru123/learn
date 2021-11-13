**Must have topics**

```txt
// operators
// control structures and arrays
// encapsulation and inheritance
// polymorphism and abstraction
// exception and assertion
// collections
// input and output streams
// FileWriter and FileReader
```

**Structure**

```txt
FOOD DELIVERY STORE PROGRAM
Administrator
MAIN MENU (Parent Class)
IT Administrator
Employee
Customer

IT Administrator (Child Class) 
Add food to the menu 
Modify Menu
Delete food to the menu
View List of Foods
View transaction history (dito malagay data ni customer)
Exit program

Employee (Child Class)
Ship/Delivered or not?
Paid or not?
View checkout order (from customer’s class)
Exit program

Customer (Child Class)
Ask for customer details
Complete name
Address/Location
Contact number
Five Restaurants (choices -- Mcdo, Jollibee, Starbucks, Burger King, KFC)
(system pause)   
{WELCOME TO EMERLU}
List of Orders
1. Add order
2. Edit order
3. Delete order
4. View order/Receipt
5. Checkout/Save (proceed to view checkout order and transaction history)
6. Exit Program
```

**Update**

```txt
IT ADMIN
-id number
-name
-password
-add employee
-delete employee
-view customers
-view employee

Employee
-id number
-name
-password
```

**Update**
```txt
sa main menu ng employee tatlo nalang

order status
view checkout order
return to main menu
```


***removed part just in case***
```java
 // Admin account registration
private void register() {
    System.out.println("IT ADMINISTRATOR REGISTRATION\n");
    
    int user_id = Integer.parseInt(console.readLine("Admin ID: ")) ;
    String name = console.readLine("Name: ");
    String password = console.readLine("Password: ");
    String confirm_password = console.readLine("Confirm password: ");

    assert user_id > 0;

    for (int i = 0; i < 100; i++) {
        if (this.admin_id[i] == user_id) {
            this.clearScreen();
            System.out.println("User id is already exist.\n");
            return;
        }
    }

    if (password.equals(confirm_password)) {
        this.clearScreen();
        System.out.println("Account created\n");

        try {
            FileWriter writer = new FileWriter("admin.txt", true);
            String admin_info = user_id + "," + name + "," + password + "\n";
            writer.write(admin_info);
            writer.close();
            System.out.println("Admin account created\n");
        } catch (IOException e) {
            System.out.println("Error creating Admin account\n");
        }
    } else {
        this.clearScreen();
        System.out.println("Password and confirm password are not the same. Try again\n");
        return;
    }
}
```