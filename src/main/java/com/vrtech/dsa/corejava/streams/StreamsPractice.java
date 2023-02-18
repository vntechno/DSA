package com.vrtech.dsa.corejava.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamsPractice {
	
	public static void main(String[] args) throws IOException {
		// 1. Integer Stream
		IntStream
		    .of(1,2,3,4,5,6)
			//.range(1, 10)
			.forEach(System.out::print);
		System.out.println();
		
		// 2. Integer Stream with skip
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(x -> System.out.println(x));
		System.out.println();
		
		// 3. Integer Stream with sum
		System.out.println(
		IntStream
			.range(1, 5)
			.sum());
		System.out.println();
			
		// 4. Stream.of, sorted and findFirst
		Stream.of("Ava", "Aneri", "Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
			
		// 5. Stream from Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Arrays.stream(names)	// same as Stream.of(names)
			.filter(x -> x.startsWith("S"))
			.sorted()
			.forEach(System.out::println);
					
		// 6. average of squares of an int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
			.map(x -> x * x)
			.average()
			.ifPresent(System.out::println);
		
		// 7. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people
			.stream()
			.map(String::toLowerCase)
			.filter(x -> x.startsWith("a"))
			.forEach(System.out::println);
			
		// 8. Stream rows from text file, sort, filter, and print
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands
			.sorted()
			.filter(x -> x.length() > 13)
			.forEach(System.out::println);
		bands.close();
		
		// 9. Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("bands.txt"))
			.filter(x -> x.contains("jit"))
			.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
		
		// 10. Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int)rows1
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.count();
		System.out.println(rowCount + " rows.");
		rows1.close();
		
		// 11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows2.close();
		
		// 12. Stream rows from CSV file, store fields in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.collect(Collectors.toMap(
                x -> x[0],
                x -> Integer.parseInt(x[1])));
		rows3.close();
		for (String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
			
		// 13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
			.reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total = " + total);
		
		// 14. Reduction - summary statistics
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
			.summaryStatistics();
		System.out.println(summary);
		
	}
}


 class HighestNumber {

	public static void main(String[] argss) {
		List<Integer> list = Arrays.asList(1, 12, 13, 15, 11, 10, 9, 8);

		int max = list.stream().mapToInt(x -> x).summaryStatistics().getMax();
		System.out.println(max);
		int min = list.stream().mapToInt(x -> x).summaryStatistics().getMin();
		System.out.println(min);
		long count = list.stream().mapToInt(x -> x).summaryStatistics().getCount();
		System.out.println(count);
		long sum = list.stream().mapToInt(x -> x).summaryStatistics().getSum();
		System.out.println(sum);
		double avg = list.stream().mapToInt(x -> x).summaryStatistics().getAverage();
		System.out.println(avg);
		System.out.print(list.stream().filter(e -> e % 2 == 0).mapToInt(x -> x).summaryStatistics().getMax());

		System.out.println("================");

		Random random = new Random();
		random.doubles(2).limit(6).forEach(System.out::println);
	}

}
 
 
 class SumOFNumbers {

		public static void main(String args[]) {

			// add the sum of n numbers
			List<Integer> list = new ArrayList<>();
			list.add(10);
			list.add(5);
			list.add(4);
			list.add(20);
			list.add(35);
			list.add(2);
			Optional<Integer> sum = list.stream().reduce((a, b) -> a + b);
			sum.ifPresent(System.out::println);

			System.out.println("=================================");

			// sorted array
			List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
			System.out.println(sortedList);

			System.out.println("=================================");

			// Average of Numbers
			double aveg = list.stream().mapToInt(e -> e).average().getAsDouble();
			System.out.println(aveg);

			System.out.println("=================================");

			// square filter average number

			double squareAvg = list.stream().map(e -> e * e).filter(e -> e > 100).mapToInt(e -> e).average().getAsDouble();

			System.out.println(squareAvg);

			System.out.println("=================================");

			// Even numbers
			list.stream().sorted().filter(e -> e % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
			// odd numbers
			list.stream().sorted().filter(e -> e % 2 != 0).collect(Collectors.toList()).forEach(System.out::println);

			System.out.println("=================================");

			// print number starts with prefix 2
			List<Integer> list1 = Arrays.asList(2, 222, 22, 234, 22, 345, 678, 435, 432);
			list1.stream().map(e -> String.valueOf(e)).filter(e -> e.startsWith("2")).map(Integer::valueOf)
					.collect(Collectors.toList()).forEach(System.out::println);

			System.out.println("=================================");

			// Duplicate Numbers
			List<Integer> duplicateNumbersList = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 1, 2, 4, 5, 7, 8, 14, 13, 4);

			duplicateNumbersList.stream().filter(e -> Collections.frequency(duplicateNumbersList, e) > 1).sorted()
					.collect(Collectors.toSet()).forEach(System.out::println);

			System.out.println("=================================");

			// another way
			Set<Integer> duplicateSet = new HashSet<>();
			duplicateNumbersList.stream().filter(e -> !duplicateSet.add(e)).collect(Collectors.toList())
					.forEach(System.out::println);

			System.out.println("=================================");

			String s1 = "hello world manonmani manonmani sarvesh sarvesh";

			List<String> duplicateName = Arrays.asList(s1.split(" "));
			duplicateName.stream().filter(e -> Collections.frequency(duplicateName, e) > 1).collect(Collectors.toSet())
					.forEach(System.out::println);

			System.out.println("=================================");

			// Max and Min numbers

			int maxValue = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
			System.out.println("max Value " + maxValue);

			System.out.println("=================================");

			int minValue = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
			System.out.println("min value " + minValue);

			System.out.println("=================================");

			// Sorted List
			list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

			System.out.println("=================================");

			// reverse order
			list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);

			System.out.println("=================================");

			// Limit numbers -->get first 3 numbers and sum also

			int sumValue = list.stream().limit(3).reduce((a, b) -> a + b).get();
			System.out.println(sumValue);
			System.out.println("=================================");

			// Skip numbers

			int skipSum = list.stream().skip(2).reduce((a, b) -> a + b).get();
			System.out.println(skipSum);
			System.out.println("=================================");

			// SecondlowestHighestNumber

			int secondhighest = duplicateNumbersList.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1)
					.findFirst().get();

			System.out.println("secondhighest" + secondhighest);

			System.out.println("=================================");

			int secondlowest = duplicateNumbersList.stream().sorted().distinct().skip(1).findFirst().get();

			System.out.println("secondlowest" + secondlowest);

			System.out.println("=================================");

			// lowestnumer and highest number

			int lowestnumber = duplicateNumbersList.stream().sorted().distinct().findFirst().get();

			System.out.println("lowestnumber" + lowestnumber);

			System.out.println("=================================");

			int highestnumber = duplicateNumbersList.stream().sorted(Collections.reverseOrder()).distinct().findFirst()
					.get();

			System.out.println("highestnumber" + highestnumber);

			System.out.println("=================================");

			// anagram
			String s2 = "AMMA";
			String s3 = "mmaa";

			System.out.println("S2====" + s2);
			System.out.println("S3====" + s3);

			s2 = s2.toLowerCase();
			s3 = s3.toLowerCase();

			System.out.println("S2====" + s2);
			System.out.println("S3====" + s3);

			char[] a1 = s2.toCharArray();
			char[] a2 = s3.toCharArray();

			System.out.println("a1====" + Arrays.toString(a1));
			System.out.println("a2====" + Arrays.toString(a2));

			Arrays.sort(a1);

			Arrays.sort(a2);

			System.out.println("a1====" + Arrays.toString(a1));
			System.out.println("a2====" + Arrays.toString(a2));

			System.out.println(Arrays.equals(a1, a2));

			HashMap<Integer, String> map = new HashMap<>();
			map.put(1, "100");
			map.put(2, "400");
			map.put(4, "200");
			map.put(8, "50");
			for (Entry<Integer, String> entry : map.entrySet()) {
				System.out.println(entry.getValue());
				System.out.println(entry.getKey());

			}

			map.forEach((K, v) -> System.out.println("Key" + K + "; " + "Value" + v));

			map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

			Integer n1 = 190;
			Integer n2 = 190;
			System.out.println(n1 == n2);

		}

	}
 
 class StringPrefix {

		public static void main(String[] args) {
			List<Integer> list = new ArrayList<>();
			list.add(10);
			list.add(5);
			list.add(4);
			list.add(20);
			list.add(35);
			list.add(2);

			List<String> nameList = Arrays.asList("mano", "aaa", "AMO", "Sarvesh");

			String joinedList = list.stream().map(e -> e % 2 == 0 ? "e" + e : "o" + e).map(String::valueOf)
					.collect(Collectors.joining(","));
			System.out.println(joinedList);

			System.out.println("=====================================");

			// start with a name length should be 3
			nameList.stream().filter(s -> s.startsWith("a") && s.length() == 3).forEach(System.out::println);

			System.out.println("=====================================");

			double d = list.stream().mapToInt(e -> e).summaryStatistics().getAverage();
			System.out.println(d);

			System.out.println("=====================================");

			double d1 = list.stream().mapToInt(x -> x).average().getAsDouble();
			System.out.println(d1);
			System.out.println("=====================================");

			nameList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);

			System.out.println("=====================================");

		}

	}
 
 
 @FunctionalInterface
 interface Switch {
	
	//void switchOn();
	
	void sum(int a, int b);

}
 class TestData {
	
	public static void main(String[] args) {
		
//		Switch s=()-> System.out.println("On");
//		s.switchOn();
		
		/*
		 * Switch s1=(a,b)->System.out.print(a+b); s1.sum(1, 2);
		 */
		
		List<Book> books=new BookDAO().getBooks();		
		Collections.sort(books, (o1,o2)->o1.getName().compareToIgnoreCase(o2.getName()));		
		System.out.println(books);
		
		
		
		// use of consumer
		Consumer<Integer> consumer=(a)->System.out.println(a);		
		consumer.accept(1);		
		List<Integer> list=Arrays.asList(1,2,3,4,5);		
		list.stream().forEach(consumer);		
		//or
		list.stream().forEach(consumer);
		list.stream().forEach(t->System.out.println("print -->"+t));
		
		//use of predicate
		Predicate<Integer> predicate=(a)->{ 
			if(a%2==0)
				return true;
			return false;
		};
		
		System.out.println(predicate.test(2));
		
		list.stream().filter(predicate).forEach(consumer);		
		
		Consumer<Integer> consumer1=(t)->System.out.println(t);
		consumer.accept(10);
		
		List<Integer>   list1=Arrays.asList(1,2,3,4,5);
		
		list.stream().forEach(consumer1);

		
		List<Integer> uniqlist=list1.stream().map(x->x*x).collect(Collectors.toList());
		
		System.out.println(uniqlist);		
		 
	}

}
