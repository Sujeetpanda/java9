import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UnModifieableCollectionDemo {

	public static void main(String[] args) {
		
		//Till java8 we are following the below way to create unmodifieable collections
		List<String> list = new ArrayList<>();
		list.add("Sueet");
		list.add("Kumar");
		list.forEach(l -> System.out.println(l));
		
		List<String> unmodifiedList8 = Collections.unmodifiableList(list);
		
		System.out.println(unmodifiedList8);
		
		//unmodifiedList8.add("Panda");
		//System.out.println(unmodifiedList8);
		
		List<String> unmodifiedList9 = List.of("sujeet","kumar");
		System.out.println(unmodifiedList9);
		
		//unmodifiedList9.add("panda");
		
		//If one of the element is NULL we get null pointer execption
		//List<String> unmodifiedList91 = List.of("sujeet","kumar",null);
		//System.out.println(unmodifiedList91);
		
		//In set we cannnot add duplicate elements so IllegalArgumentException similarly for Map
		//Set<String> set = Set.of("A","B","B");
		
		Map<Integer,String> map = Map.of(10,"sujeet",11,"kumar");
		
		map.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));
		
		Entry<Integer, String> e1 = Map.entry(100, "Sujeet");
		Entry<Integer, String> e2 = Map.entry(101, "panda");
		
		Map<Integer,String> map2 = Map.ofEntries(e1,e2);
		
		map2.forEach((k,v) -> System.out.println("Key : " + k + " Value : " + v));
		
	}

}
