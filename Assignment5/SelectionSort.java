
import java.util.ArrayList;

public class SelectionSort implements Runnable {

	private static ArrayList<Context> selectcopy = new ArrayList<Context>(Main.copylist);
	private static int Size;
	public static double Time;

	/* reference: wikipedia */
	private static ArrayList<Context> Selectionsort(ArrayList<Context> selectcopy) {
		int i, n, min;
		Size = selectcopy.size();
		for (i = 0; i < Size - 1; i++) {
			min = i;
			for (n = i + 1; n < Size; n++)
				if (selectcopy.get(min).Name.compareTo(selectcopy.get(n).Name) > 0) {
					min = n;
				}
			Context temp = selectcopy.get(min);
			selectcopy.set(min, selectcopy.get(i));
			selectcopy.set(i, temp);
		}
		return selectcopy;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double StartTime = System.nanoTime();// Time Start//
		Selectionsort(selectcopy);
		double EndTime = System.nanoTime();// Time End//
		Time = (EndTime - StartTime) / 1000000000;// Time//

		if (Main.test(selectcopy)) {
			MainFrame.setSelectionSortTime(SelectionSort.Time);
		} else {
			MainFrame.setSelectionSortTime("Error");
		}

	}

}
