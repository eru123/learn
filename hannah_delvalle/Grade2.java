public class Main
{
	public static void main(String[] args) {
		
		// Grade list 
		int[] g = {88,90,85};
		
		// variables
		int i, min = g[0], max = g[0];
		double sum = 0, average;
		
		for(i = 0; i < g.length;i++){
		    
		    // Print all array element
		    System.out.println(g[i]);
		    
		    // add to total sum - this is for average computation
		    sum += g[i];
		    
		    // get the min and max
		    if(i > 0){
		        if(min > g[i]) min = g[i]; // min
		        if(max < g[i]) max = g[i]; // max
		    }
		}
		
		// Compute the average
		average = sum / g.length;
		
		// Display results
		System.out.println("Average is: " + average); // average
		System.out.println("Lowest Grade is: " + min); // min
		System.out.println("Highest Grade is: " + max); // max
		
	}
}

