package bkap.android.managefinance.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import bkap.android.managefinance.entity.TaikhoanEntity;

import com.example.managefinance.pro.R;

@SuppressLint("ServiceCast")
public class AccountAdapter extends ArrayAdapter<TaikhoanEntity> {

	private Context context;
	private int resId;
	private List<TaikhoanEntity> listAccount;

	public AccountAdapter(Context context, int resource,
			List<TaikhoanEntity> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub

		this.context = context;
		this.resId = resource;
		this.listAccount = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View itemView = convertView;
		ViewHolder viewHolder = new ViewHolder();
		if (itemView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(resId, null);
			viewHolder.lbTaikhoan = (TextView) itemView
					.findViewById(R.id.lbTaiKhoan);
			viewHolder.lbMota = (TextView) itemView.findViewById(R.id.lbMota);
			viewHolder.lbSotien = (TextView) itemView
					.findViewById(R.id.lbSoTien);
			itemView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) itemView.getTag();
		}
		TaikhoanEntity taikhoan = new TaikhoanEntity();
		taikhoan = listAccount.get(position);
		viewHolder.lbTaikhoan.setText(taikhoan.getLoaiTaiKhoan());
		viewHolder.lbMota.setText(taikhoan.getMota());
		viewHolder.lbSotien.setText(String.valueOf(taikhoan.getSoTien()));

		return itemView;
	}

	public class ViewHolder {
		TextView lbTaikhoan;
		TextView lbMota;
		TextView lbSotien;
	}
}
