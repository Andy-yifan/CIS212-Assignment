import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T> {
	HashMap<T, Integer> myHashMap = new HashMap<T, Integer>();

	private ArrayList<T> makeSortedKyeList() {
		ArrayList<T> keyList = new ArrayList<T>(myHashMap.keySet());
		Collections.sort(keyList, new Comparator<T>() {
			public int compare(T a, T b) {
				return myHashMap.get(a) - (myHashMap.get(b));

			}
		});
		return keyList;
	}

	@Override
	public int size() {
		return myHashMap.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(Object o) {

		return myHashMap.containsKey(o);
	}

	@Override
	public MyIterator<T> iterator() {
		MyIterator<T> iter = new MyIterator<T>(myHashMap);
		return iter;

	}

	@Override
	public Object[] toArray() {

		return makeSortedKyeList().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		ArrayList<T> List = (ArrayList<T>) makeSortedKyeList();
		for (int i = 0; i < List.size(); i++) {
			a[i] = List.get(i);
		}
		return a;
	}

	@Override
	public boolean add(T e) {
		int counter = 1;
		if (myHashMap.containsKey(e)) {
			counter = myHashMap.get(e);
			counter++;

		}
		myHashMap.put(e, counter);
		return true;

	}

	@Override
	public boolean remove(Object o) {
		return myHashMap.remove(o) == null ? false : true;

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object x : c) {
			if (!this.contains(x)) {
				return false;
			}

		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (Object x : c) {
			add((T) x);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean Bool = false;
		for (Object x : myHashMap.values()) {

			if (!c.contains(x)) {
				remove(x);
				Bool = true;
			}

		}
		return Bool;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object x : c) {
			remove(x);
		}
		return true;
	}

	@Override
	public void clear() {
		myHashMap.clear();
	}

	public String toString() {
		return makeSortedKyeList().toString();

	}

}
