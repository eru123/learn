import java.util.Scanner;
import java.util.ArrayList; 

public class BubbleSort
{
	public static void main(String[] args) {
	    Scanner input_str = new Scanner(System.in);
	    Scanner input_int = new Scanner(System.in);
	    
	    ArrayList<Integer> id = new ArrayList<Integer>();
	    ArrayList<String> description = new ArrayList<String>();
	    ArrayList<Integer> price = new ArrayList<Integer>();
	    
		for(int i=0;i<4;i++){
		    System.out.println("Enter item data");
		    
		    System.out.print(" Item Id: ");
		    id.add(input_int.nextInt());
		    
		    System.out.print("Description: ");
		    description.add(input_str.nextLine());
		    
		    System.out.print("Price: ");
		    price.add(input_int.nextInt());
		}
		
		System.out.print("To show the item in ascending order base on ID, press 1; to show item in descending order base on price, press 2: ");
		int choice = input_int.nextInt();
		
		if(choice == 1){
		    for(int i=0;i<id.size();i++){
		        for(int j=0;j<id.size()-1;j++){
		            if(id.get(j) > id.get(j+1)){
		                int tmp = id.get(j);
		                id.set(j,id.get(j+1));
		                id.set(j+1, tmp);
		            }
		        }
		    }
		} else if (choice == 2) {
		    for(int i=0;i<price.size();i++){
		        for(int j=0;j<price.size()-1;j++){
		            if(price.get(j) < price.get(j+1)){
		                int tmp = price.get(j);
		                price.set(j,price.get(j+1));
		                price.set(j+1, tmp);
		            }
		        }
		    }
		}
		
		for(int i=0;i<id.size();i++) System.out.println( id.get(i) + " || " + description.get(i) + " || " + price.get(i));
	}
}

