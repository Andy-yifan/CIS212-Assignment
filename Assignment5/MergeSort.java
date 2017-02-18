import java.util.ArrayList;

public class MergeSort implements Runnable {

	private static ArrayList<Context> Mergecopy = new ArrayList<Context>(Main.copylist);
	public static double Time;

	/*
	 * reference:http://www.codexpedia.com/java/java-merge-sort-implementation
	 */
	private static ArrayList<Context> Mergesort(ArrayList<Context> Mergecopy) {
		ArrayList<Context> left = new ArrayList<Context>();
		ArrayList<Context> right = new ArrayList<Context>();
		int center;
		if (Mergecopy.size() == 1) {
			return Mergecopy;
		} else {
			center = Mergecopy.size() / 2;
			for (int i = 0; i < center; i++) {
				left.add(Mergecopy.get(i));
			}
			for (int i = center; i < Mergecopy.size(); i++) {
				right.add(Mergecopy.get(i));
			}
			left = Mergesort(left);
			right = Mergesort(right);
			merge(left, right, Mergecopy);
		}
		return Mergecopy;
	}

	private static void merge(ArrayList<Context> left, ArrayList<Context> right, ArrayList<Context> Whole) {
		int leftIndex = 0;
		int rightIndex = 0;
		int wholeIndex = 0;
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).Name.compareTo(right.get(rightIndex).Name) < 0) {
				Whole.set(wholeIndex, left.get(leftIndex));
				leftIndex++;
			} else {
				Whole.set(wholeIndex, right.get(rightIndex));
				rightIndex++;
			}
			wholeIndex++;
		}

		ArrayList<Context> rest;
		int restIndex;
		if (leftIndex >= left.size()) {
			rest = right;
			restIndex = rightIndex;
		} else {
			rest = left;
			restIndex = leftIndex;
		}
		for (int i = restIndex; i < rest.size(); i++) {
			Whole.set(wholeIndex, rest.get(i));
			wholeIndex++;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double StartTime = System.nanoTime();// Time Start//
		Mergesort(Mergecopy);
		double EndTime = System.nanoTime();// Time End//
		Time = (EndTime - StartTime) / 1000000000;// Time//

		if (Main.test(Mergecopy)) {
			MainFrame.setMargeSortTime(MergeSort.Time);
		} else {
			MainFrame.setMargeSortTime("Error");
		}
	}
}