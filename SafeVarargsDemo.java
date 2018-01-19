import java.util.Arrays;
import java.util.List;

public class SafeVarargsDemo {

	public static void main(String[] args) {
		List<String> l1 = Arrays.asList("a","b");
		List<String> l2 = Arrays.asList("c","d");
		m1(l1,l2);
	}
	
	//Used for constructors,static methods and final methods till 1.7
	//For 1.9 it is used for private methods also
	@SafeVarargs
	public static void m1(List<String>... x) {
		//Object[] list = x;
		//list[0] = Arrays.asList(10,20);
		//String s = (String) x[0].get(0);
		
		for(List<String> l : x) {
			System.out.println(l);
		}
	}
	
	@SafeVarargs
	private void m2(List<String>... x) {
		
	}

}
