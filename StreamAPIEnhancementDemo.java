import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIEnhancementDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<String> stringList = Arrays.asList("Sujeet", "panda");

		List<Integer> mappedStringList = stringList.stream().flatMap(x -> Stream.of(x.length(), x.length() + 2))
				.collect(Collectors.toList());
		mappedStringList.forEach(x -> System.out.print(" " + x));
		System.out.println();
		List<Integer> mappedList = list.stream().flatMap(x -> Stream.of(x * x, x * x * x)).collect(Collectors.toList());
		mappedList.forEach(x -> System.out.print(" " + x));
		System.out.println();
		List<Integer> newList = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> flatMapList = newList.stream().flatMap(x -> {
			if (x % 2 == 0)
				return Stream.empty();
			else
				return Stream.of(x, x * 10);
		}).collect(Collectors.toList());

		flatMapList.forEach(x -> System.out.print(" " + x));
		System.out.println();
		//java9 enhancement to stream API
		
		//takeWhile,dropWhile(Default methods)
		//Stream.iterate(), Stream.ofNullable(Static methods)
		
		//Difference between filter and takeWhile
		//takeWhile stops once the condition is false.Similarly for dropWhile
		List<String> strList = Arrays.asList("Sujeet","Kumar","panda","Berhampur");
		
		Predicate<String> p = s -> {if (Character.isUpperCase(s.charAt(0))) 
										return true;
									else
										return false;};
		
		List<String> filteredList = strList.stream().filter(p).collect(Collectors.toList());
		filteredList.forEach(x -> System.out.print(" " + x));
		System.out.println();
		
		List<String> takeWhileList = strList.stream().takeWhile(p).collect(Collectors.toList());
		takeWhileList.forEach(System.out::println);
		System.out.println();
		
		List<String> dropWhileList = strList.stream().dropWhile(p).collect(Collectors.toList());
		dropWhileList.forEach(System.out::println);
		System.out.println();
		
		//java8 iterate(2 args)
		List<Integer> itrList = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
		itrList.forEach(System.out::println);
		
		//Java9 iterator iterate(3 args)
		List<Integer> itrList9 = Stream.iterate(1, x -> x <= 10,x -> x + 1).collect(Collectors.toList());
		itrList9.forEach(System.out::println);
		
		List<Integer> nullableTestList = Arrays.asList(10,20,null,30,null,40,null,50);
		
		List<Integer> afterNullableTestList = nullableTestList.stream().flatMap(x -> Stream.ofNullable(x)).collect(Collectors.toList());
		System.out.println();
		System.out.println(afterNullableTestList);
		
		//Example for map
		
		//Collect all the values from the map which are not null
		
		Map<Integer,String> map = new HashMap<>();
		map.put(10, "Sujeet");
		map.put(11, null);
		map.put(12, "panda");
		
		List<Integer> mappedKeysList = map.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
		List<String> mapValuesWithoutNull = map.entrySet().stream().flatMap(e -> Stream.ofNullable(e.getValue())).collect(Collectors.toList());
		
		System.out.println(mappedKeysList);
		System.out.println(mapValuesWithoutNull);
	}

}
