
public class Test implements Card{

	public static void main(String[] args) {
		Test ob = new Test();
		ob.showMessage();
	}

	@Override
	public void show() {
		
	}

}


 interface Card{

	  private void privateMethod(){
	    System.out.println("These are the common code. This is private method");
	  }
	  
	  default void showMessage() {
		  privateMethod();
		  System.out.println("New logic after commmon code");
	  }
	  
	  void show();

}