package bkap.android.managefinance.adapter;

import java.util.List;

import com.example.managefinance.pro.R;

import bkap.android.managefinance.entity.ThuchiEntity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class IncomeAdapter extends ArrayAdapter<ThuchiEntity> {

	private Context context;
	private int resId;
	private List<ThuchiEntity> listIncome;

	public IncomeAdapter(Context context, int resource,
			List<ThuchiEntity> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resId = resource;
		this.listIncome = objects;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View itemView = convertView;
		ViewHolder viewHolder = new ViewHolder();
		if (itemView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(resId, null);
			viewHolder.mLbLoaiTaiKhoan = (TextView) itemView
					.findViewById(R.id.lbTaiKhoan);
			viewHolder.mLbMota = (TextView) itemView.findViewById(R.id.lbMota);
			viewHolder.mLbSoTien = (TextView) itemView
					.findViewById(R.id.lbSoTien);

			itemView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) itemView.getTag();
		}

		viewHolder.mLbLoaiTaiKhoan.setText(listIncome.get(position)
				.getLoaiTaiKhoan());
		viewHolder.mLbMota.setText(listIncome.get(position).getMota());
		viewHolder.mLbSoTien.setText(String.valueOf(listIncome.get(position)
				.getSoTien()));
		// TODO Auto-generated method stub
		return itemView;
	}

	public class ViewHolder {
		TextView mLbMota;
		TextView mLbSoTien;
		TextView mLbLoaiTaiKhoan;
	}
}
