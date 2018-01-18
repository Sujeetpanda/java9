
public class Generics9Demo {

	public static void main(String[] args) {
		//Before 1.9 version we need to pass the type parameter for anonymous classes
		MyGenClass<String> g1 = new MyGenClass<String>("Sujeet") {
			public void process() {
				System.out.println("Process method ...." + getObj());
			}
		};
		g1.process();
		System.out.println("The anonymous class is " + g1.getClass().getName());
		
		//For 1.9 version no need to pass type parameters for anonymous classes
		MyGenClass<String> g2 = new MyGenClass<>("Panda") {
			public void process() {
				System.out.println("Process method ...." + getObj());
			}
		};
		g2.process();
		System.out.println("The anonymous class is " + g2.getClass().getName());
	}

}

class MyGenClass<T> {
	T obj;
	
	public MyGenClass(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	public void process() {
		System.out.println("Inside my Gen class process");
	}
}
