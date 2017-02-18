import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
	OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
	intSet.add(1);
	intSet.add(3);
	intSet.add(5);
	intSet.add(5);
	intSet.add(3);
	intSet.add(3);
	intSet.add(3);
	
	System.out.println(intSet);
	OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
	stringSet.add("hello");
	stringSet.add("hello");
	stringSet.add("world");
	stringSet.add("world");
	stringSet.add("world");
	stringSet.add("here");
	System.out.println("before clear: "+stringSet);
	stringSet.clear();
	System.out.println("after clear: "+stringSet);
	OccurrenceSet<String> stringSet2 = new OccurrenceSet<String>();
	stringSet2.add("hello");
	stringSet2.add("hello");
	stringSet2.add("world");
	stringSet2.add("world");
	stringSet2.add("world");
	System.out.println("before remove 'hello': "+stringSet2);
	stringSet2.remove("hello");
	System.out.println("after: "+stringSet2);
	OccurrenceSet<String> stringSet3 = new OccurrenceSet<String>();
	stringSet3.add("hello");
	stringSet3.add("hello");
	stringSet3.add("world");
	stringSet3.add("world");
	stringSet3.add("world");
	stringSet3.add("here");
	System.out.println("before remove all 'world', it's size is: "+stringSet3.size());
	System.out.println("before remove all 'world', it is: "+stringSet3);

	stringSet3.removeAll(stringSet2);
	System.out.println("after remove all 'world', it's size is : "+stringSet3.size());
	System.out.println("which are :"+stringSet3);
	//test code on pizza of myiterator work
	MyIterator<String> iterator = stringSet3.iterator();
	while (iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
	
	
}
	
}
