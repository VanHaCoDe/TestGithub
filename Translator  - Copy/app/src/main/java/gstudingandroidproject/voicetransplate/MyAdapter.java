package gstudingandroidproject.voicetransplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Admin on 03/05/2016.
 */
public class MyAdapter extends BaseAdapter {
    ArrayList<WordTranslateEnity> arrayList = new ArrayList<>();

    public void setArrayList(ArrayList<WordTranslateEnity> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.layout_adapter, null);

        return null;
    }
}
