import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResoursesDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
		try(reader1) {
		} 
	}

}
