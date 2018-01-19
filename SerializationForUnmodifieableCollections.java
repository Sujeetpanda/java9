import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class SerializationForUnmodifieableCollections {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Student> studuentList = List.of(new Student(10,"Sujeet"),new Student(11,"Ajit"));
		
		System.out.println("Before serializing");
		studuentList.forEach(s -> System.out.println(s));
		
		//Serialize the collection
		System.out.println("Serializing the objects");
		FileOutputStream fo = new FileOutputStream("student.ser");
		ObjectOutputStream oss = new ObjectOutputStream(fo);
		oss.writeObject(studuentList);
		
		System.out.println("Deserializing the objects");
		FileInputStream fi = new FileInputStream("student.ser");
		ObjectInputStream osi = new ObjectInputStream(fi);
		List<Student> deserializeStudentList = (List<Student>) osi.readObject();
		
		System.out.println("After serializing");
		deserializeStudentList.forEach(s -> System.out.println(s));
		//After desialization the collection still remains unmodifieable
		//deserializeStudentList.add(new Student(102,"Ram"));
	}

}

@SuppressWarnings("serial")
class Student implements Serializable{
	private int rollNo;
	private String name;
	
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return String.format("%d = %s",rollNo,name);
	}
	
}
