package bkap.android.managefinance.adapter;

import java.util.List;

import bkap.android.managefinance.entity.ThuchiEntity;

import com.example.managefinance.pro.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ExpensesAdapter extends ArrayAdapter<ThuchiEntity> {

	private Context context;
	private int resId;
	private List<ThuchiEntity> listThuChi;

	public ExpensesAdapter(Context context, int resource,
			List<ThuchiEntity> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resId = resource;
		this.listThuChi = objects;
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
			viewHolder.lbLoaiTaiKhoan = (TextView) itemView
					.findViewById(R.id.lbTaiKhoan);
			viewHolder.lbMota = (TextView) itemView.findViewById(R.id.lbMota);
			viewHolder.lbSoTien = (TextView) itemView
					.findViewById(R.id.lbSoTien);
			itemView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) itemView.getTag();
		}
		viewHolder.lbLoaiTaiKhoan.setText(listThuChi.get(position)
				.getLoaiTaiKhoan());
		viewHolder.lbMota.setText(listThuChi.get(position).getMota());
		viewHolder.lbSoTien.setText(String.valueOf(listThuChi.get(position)
				.getSoTien()));
		return itemView;
	}

	public class ViewHolder {
		TextView lbMota;
		TextView lbLoaiTaiKhoan;
		TextView lbSoTien;
	}
}
