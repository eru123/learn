public class Main
{   
	static MyProperties myProperties = new MyProperties();
	
	public static void main(String[] args) {
		String raw = "Joey,24,joey@gmail.com\nMarcus,26,marcus@gmail.com\nLincoln,21,lincoln@gmail.com\nBryan,29,bryan@gmail.com";
		myProperties.parseText(raw);
		
		for(int i=0; i < myProperties.names.size(); i++){
		    System.out.println("Hello, " + 
		        myProperties.names.get(i) + 
		        "! Your age is " + 
		        myProperties.age.get(i) + 
		        " and your email is " + 
		        myProperties.email.get(i)
            );
		}
	}
}
