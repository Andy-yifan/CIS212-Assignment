import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {

	// 2 button 2 frame//
	private final JButton SelectSortButton;
	private final JButton MargeSortButton;
	private static  JLabel SelectionSortTime;
	private static  JLabel MergeSortTime;
	
    //let to show if report error
	public static void setSelectionSortTime(Object report) {
		SelectionSortTime.setText(null);
		SelectionSortTime.setText("" + report);
	}

	public static void setMargeSortTime(Object report) {
		MergeSortTime.setText(null);
		MergeSortTime.setText("" + report);
	}

	public MainFrame() {
		setLayout(new BorderLayout());
		JPanel SortButtonPannel = new JPanel();
		SortButtonPannel.setLayout(new GridLayout(2, 1));

		// buttons to call sort method//
		SelectSortButton = new JButton("Select Sort");
		SelectSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				(new Thread(new SelectionSort())).start();
			}
		});

		MargeSortButton = new JButton("Marge Sort");
		MargeSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				(new Thread(new MergeSort())).start();
			}
		});
		SortButtonPannel.add(SelectSortButton);
		SortButtonPannel.add(MargeSortButton);
		add(SortButtonPannel, BorderLayout.WEST);
		//labels//
		JPanel LabelPannel = new JPanel();
		LabelPannel.setLayout(new GridLayout(2, 1));
		SelectionSortTime = new JLabel();
		MergeSortTime = new JLabel();
	
		LabelPannel.add(SelectionSortTime);
		LabelPannel.add(MergeSortTime);
		add(LabelPannel, BorderLayout.EAST);
	}

}
