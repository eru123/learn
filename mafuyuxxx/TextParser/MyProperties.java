import java.util.ArrayList;

public class MyProperties {
    public static ArrayList<String> names = new ArrayList<String>();
    public static ArrayList<String> age = new ArrayList<String>();
    public static ArrayList<String> email = new ArrayList<String>();
    
    public static void parseText(String text){
		for(String line: text.split("\n")){
		    String[] info = line.split(",");
		    names.add(info[0]);
		    age.add(info[1]);
		    email.add(info[2]);
		}
    }
}