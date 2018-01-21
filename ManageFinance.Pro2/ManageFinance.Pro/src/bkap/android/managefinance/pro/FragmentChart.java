package bkap.android.managefinance.pro;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import bkap.android.managefinance.database.ManageFinanceDatasource;
import bkap.android.managefinance.entity.ThuchiEntity;

import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieGraph.OnSliceClickedListener;
import com.echo.holographlibrary.PieSlice;
import com.example.managefinance.pro.R;

public class FragmentChart extends Fragment {
	PieSlice slice;
	ManageFinanceDatasource database;
	List<ThuchiEntity> listExpense, listIncome = new ArrayList<ThuchiEntity>();
	private long valueExpense = 0;
	private long valueIncome = 0;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_chart, container,
				false);

		final DecimalFormat lamTron = new DecimalFormat(".##");

		database = new ManageFinanceDatasource(getActivity());
		database.Open();
		listExpense = database.getExpense();
		listIncome = database.getIncome();

		if (listExpense.size() != 0) {
			for (int i = 0; i < listExpense.size(); i++) {
				valueExpense += listExpense.get(i).getSoTien();
			}
		}

		if (listIncome.size() != 0) {
			for (int i = 0; i < listIncome.size(); i++) {
				valueIncome += listIncome.get(i).getSoTien();
			}
		}

		final PieGraph mPie = (PieGraph) rootView.findViewById(R.id.piegraph);
		slice = new PieSlice();
		slice.setColor(getResources().getColor(R.color.red));
		slice.setTitle("Expense");
		slice.setValue(valueExpense);
		mPie.addSlice(slice);

		slice = new PieSlice();
		slice.setColor(getResources().getColor(R.color.green));
		slice.setTitle("Income");
		slice.setValue(valueIncome);
		mPie.addSlice(slice);
		mPie.setInnerCircleRatio(120);

		mPie.setOnSliceClickedListener(new OnSliceClickedListener() {

			@Override
			public void onClick(int index) {
				if (index == 0 || index == 1) {
					Toast.makeText(
							getActivity(),
							mPie.getSlice(index).getTitle().toString()
									+ " "
									+ lamTron
											.format((mPie.getSlice(index)
													.getValue() / (valueExpense + valueIncome)) * 100)
									+ "%", Toast.LENGTH_SHORT).show();
				}

			}
		});

		return rootView;
	}
}
