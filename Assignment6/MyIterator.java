import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyIterator<T> implements Iterator {
	private ArrayList<T> _list;
	private int _index;

	public MyIterator(HashMap<T, ?> h) {
		Set<T> myKeys = h.keySet();
		_list = new ArrayList<T>();
		for(T key : myKeys)
		{
			for(int i = 0; i < (int) h.get(key); i++)
			{
				_list.add(key);
			}
		}
	}

	public boolean hasNext() {
		return _index < _list.size();
	}

	@Override
	public Object next() {
		return _list.get(_index++);
	}

	@Override
	public void remove() {
		_list.remove(_index);
	}
}

