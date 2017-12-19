package sample;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
Static methods
Instance methods
Constructors using new operator (TreeSet::new)

 * @author sunning
 *
 */
public class MethodReferences {
	   public static void main(String args[]){
		      List names = new ArrayList();
				
		      names.add("Mahesh");
		      names.add("Suresh");
		      names.add("Ramesh");
		      names.add("Naresh");
		      names.add("Kalpesh");
				
		      names.forEach(System.out::println);
		   }
}
