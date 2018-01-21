package com.example.thudemo;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import Database.DataAdapter;

public class khoanvay_activite extends Activity {

    private Date dateFinish;
    private DataAdapter data;
    Calendar cal;
    Button Btdate1, Btdate2, Btthem, Bt_clear;
    ImageButton imgbt_back;
    EditText editsotienv, editlaisuatv, editdate1, editdate2, editTenKV;
    ListView listtab;
    SimpleCursorAdapter cursordata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khoangvay_activite);

        Btdate1 = (Button) findViewById(R.id.bt_nvay);
        Btdate2 = (Button) findViewById(R.id.bt_ntra);
        Btthem = (Button) findViewById(R.id.bt_themkv);
        Bt_clear = (Button) findViewById(R.id.bt_clearkv);
        imgbt_back = (ImageButton) findViewById(R.id.imgbt_backkv);
        editsotienv = (EditText) findViewById(R.id.editsotien);
        editlaisuatv = (EditText) findViewById(R.id.editlaisuat);
        editdate1 = (EditText) findViewById(R.id.et_datenv);
        editdate2 = (EditText) findViewById(R.id.et_datetra);
        editTenKV = (EditText) findViewById(R.id.et_tkv);
        listtab = (ListView) findViewById(R.id.listkhoanvay);

        data = new DataAdapter(this);
        data.open();
        Cursor curn = data.getAllkv();
        startManagingCursor(curn);

        String[] from = new String[]{DataAdapter.tenkhoanvay, DataAdapter.sotienv, DataAdapter.laisuatv, DataAdapter.ngayvay, DataAdapter.ngaymuon};
        int[] to = new int[]{R.id.txttenv, R.id.txtsotien, R.id.txtlaisuat, R.id.txtngayvay, R.id.txtngaytra};

        cursordata = new SimpleCursorAdapter(this, R.layout.row_khoanvay, curn, from, to);
        listtab.setAdapter(cursordata);
        loadTabs();
        disAll();



        Btthem.setEnabled(false);
        editTenKV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((editTenKV.getText().toString().equals("")) ||
                        (editsotienv.getText().toString().equals("")) ||
                        (editlaisuatv.getText().toString().equals("")) ||
                        (editdate1.getText().toString().equals("")) ||
                        (editdate2.getText().toString().equals(""))) {
                    Btthem.setEnabled(false);
                } else Btthem.setEnabled(true);
            }
        });
        editTenKV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((editTenKV.getText().toString().equals("")) ||
                        (editsotienv.getText().toString().equals("")) ||
                        (editlaisuatv.getText().toString().equals("")) ||
                        (editdate1.getText().toString().equals("")) ||
                        (editdate2.getText().toString().equals(""))) {
                    Btthem.setEnabled(false);
                } else Btthem.setEnabled(true);
            }
        });
        editsotienv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((editTenKV.getText().toString().equals("")) ||
                        (editsotienv.getText().toString().equals("")) ||
                        (editlaisuatv.getText().toString().equals("")) ||
                        (editdate1.getText().toString().equals("")) ||
                        (editdate2.getText().toString().equals(""))) {
                    Btthem.setEnabled(false);
                } else Btthem.setEnabled(true);
            }
        });
        editlaisuatv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((editTenKV.getText().toString().equals("")) ||
                        (editsotienv.getText().toString().equals("")) ||
                        (editlaisuatv.getText().toString().equals("")) ||
                        (editdate1.getText().toString().equals("")) ||
                        (editdate2.getText().toString().equals(""))) {
                    Btthem.setEnabled(false);
                } else Btthem.setEnabled(true);
            }
        });
        editdate1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((editTenKV.getText().toString().equals("")) ||
                        (editsotienv.getText().toString().equals("")) ||
                        (editlaisuatv.getText().toString().equals("")) ||
                        (editdate1.getText().toString().equals("")) ||
                        (editdate2.getText().toString().equals(""))) {
                    Btthem.setEnabled(false);
                } else Btthem.setEnabled(true);
            }
        });
        editdate2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((editTenKV.getText().toString().equals("")) ||
                        (editsotienv.getText().toString().equals("")) ||
                        (editlaisuatv.getText().toString().equals("")) ||
                        (editdate1.getText().toString().equals("")) ||
                        (editdate2.getText().toString().equals(""))) {
                    Btthem.setEnabled(false);
                } else Btthem.setEnabled(true);
            }
        });

        Btdate1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getDefaultInforkv(editdate1);
                showDatePickerDialogkv(editdate1);
            }
        });
        Btdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getDefaultInforkv(editdate2);
                showDatePickerDialogkv(editdate2);

            }
        });
        Btthem.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                /*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                  String 	nv = sdf.format(new Date());
			      String	nm = sdf.format(new Date());*/

                String tkv = editTenKV.getText().toString();
                int st = Integer.parseInt(editsotienv.getText().toString());
                int ls = Integer.parseInt(editlaisuatv.getText().toString());
                String nv = editdate1.getText().toString();
                String nm = editdate2.getText().toString();

                data.insertkhoanvay(tkv, st, ls, nv, nm);
                Toast.makeText(getApplicationContext(), "Bạn Thêm Thành Công: " + tkv, Toast.LENGTH_LONG).show();
                disAll();

                editTenKV.setText(null);
                editsotienv.setText(null);
                editlaisuatv.setText(null);
                editdate1.setText(null);
                editdate2.setText(null);
            }
        });
        Bt_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editTenKV.setText(null);
                editsotienv.setText(null);
                editlaisuatv.setText(null);
                editdate1.setText(null);
                editdate2.setText(null);
            }
        });
        imgbt_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(khoanvay_activite.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private void disAll() {
        data.open();
        try {
            Cursor curn = data.getAllkv();
            startManagingCursor(curn);

            String[] from = new String[]{DataAdapter.tenkhoanvay, DataAdapter.sotienv, DataAdapter.laisuatv, DataAdapter.ngayvay, DataAdapter.ngaymuon};
            int[] to = new int[]{R.id.txtten, R.id.txtsotien, R.id.txtlaisuat, R.id.txtngayvay, R.id.txtngaytra};

            cursordata = new SimpleCursorAdapter(this, R.layout.row_khoanvay, curn, from, to);
            listtab.setAdapter(cursordata);

            listtab.setOnItemClickListener(new OnItemClickListener() {

                @SuppressLint("NewApi")
                @Override
                public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                    // TODO Auto-generated method stub

                    Cursor cursor = (Cursor) parent.getItemAtPosition(position);

                    final int item_id = cursor.getInt(cursor.getColumnIndex(DataAdapter.colkvID));

                    String item_tkv = cursor.getString(cursor.getColumnIndex(DataAdapter.tenkhoanvay));
                    String item_st = cursor.getString(cursor.getColumnIndex(DataAdapter.sotienv));
                    String item_ls = cursor.getString(cursor.getColumnIndex(DataAdapter.laisuatv));
                    String item_nv = cursor.getString(cursor.getColumnIndex(DataAdapter.ngayvay));
                    String item_nt = cursor.getString(cursor.getColumnIndex(DataAdapter.ngaymuon));

                    AlertDialog.Builder myDialog = new AlertDialog.Builder(khoanvay_activite.this);

                    myDialog.setTitle("Delete/Edit?");
                    TextView dialogTxt_id = new TextView(khoanvay_activite.this);

                    LayoutParams dialogTxt_idLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                    dialogTxt_id.setLayoutParams(dialogTxt_idLayoutParams);

                    dialogTxt_id.setText("->"+String.valueOf(position+1) );

                    final EditText tenkv = new EditText(khoanvay_activite.this);
                    final EditText st = new EditText(khoanvay_activite.this);
                    st.setInputType(InputType.TYPE_CLASS_NUMBER);
                    final EditText ls = new EditText(khoanvay_activite.this);
                    ls.setInputType(InputType.TYPE_CLASS_NUMBER);
                    final EditText nv = new EditText(khoanvay_activite.this);
                    nv.setInputType(InputType.TYPE_CLASS_DATETIME);
                    final EditText nt = new EditText(khoanvay_activite.this);
                    nt.setInputType(InputType.TYPE_CLASS_DATETIME);

                    LayoutParams tenkv_layoupa = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams st_layoupa = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams ls_layoupa = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams nv_layopa = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams nt_layopa = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

                    tenkv.setLayoutParams(tenkv_layoupa);
                    st.setLayoutParams(st_layoupa);
                    ls.setLayoutParams(ls_layoupa);
                    nv.setLayoutParams(nv_layopa);
                    nt.setLayoutParams(nt_layopa);

                    tenkv.setText(item_tkv);
                    st.setText(item_st);
                    ls.setText(item_ls);
                    nv.setText(item_nv);
                    nt.setText(item_nt);

                    LinearLayout layout = new LinearLayout(khoanvay_activite.this);

                    layout.setOrientation(LinearLayout.VERTICAL);

                    layout.addView(dialogTxt_id);

                    layout.addView(tenkv);
                    layout.addView(st);
                    layout.addView(ls);
                    layout.addView(nv);
                    layout.addView(nt);

                    myDialog.setView(layout);

                    myDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked

                        public void onClick(DialogInterface arg0, int arg1) {

                            LinearLayout layout = new LinearLayout(khoanvay_activite.this);
                            AlertDialog.Builder builder = new AlertDialog.Builder(layout.getContext());
                            builder.setTitle("Hỏi Xóa");
                            builder.setMessage("Bạn Có Muốn Xóa Khoản vay Này Không?");
                            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    data.open();
                                    data.deletetkv(item_id);

                                    Cursor c = data.getAllkv();
                                    startManagingCursor(c);
                                    String[] from = new String[]{DataAdapter.tenkhoanvay, DataAdapter.sotienv, DataAdapter.laisuatv, DataAdapter.ngayvay, DataAdapter.ngaymuon};
                                    int[] to = new int[]{R.id.txtten, R.id.txtsotien, R.id.txtlaisuat, R.id.txtngayvay, R.id.txtngaytra};


                                    SimpleCursorAdapter notes = new SimpleCursorAdapter(khoanvay_activite.this, R.layout.row_khoanvay, c, from, to);
                                    listtab.setAdapter(notes);

                                    notes.notifyDataSetChanged();
                                    data.close();
                                }
                            });
                            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                }
                            });
                            builder.create().show();

                        }

                    });

                    myDialog.setNeutralButton("Update", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked

                        public void onClick(DialogInterface arg0, int arg1) {

                            String valt = tenkv.getText().toString();
                            int valst = Integer.parseInt(st.getText().toString());
                            int valls = Integer.parseInt(ls.getText().toString());
                            String valnv = nv.getText().toString();
                            String valnt = nt.getText().toString();
                            data.open();
                            data.updatekhoanvay(item_id, valt, valst, valls, valnv, valnt);

                            Cursor c = data.getAllkv();
                            startManagingCursor(c);

                            String[] from = new String[]{DataAdapter.tenkhoanvay, DataAdapter.sotienv, DataAdapter.laisuatv, DataAdapter.ngayvay, DataAdapter.ngaymuon};
                            int[] to = new int[]{R.id.txttenv, R.id.txtsotien, R.id.txtlaisuat, R.id.txtngayvay, R.id.txtngaytra};

                            SimpleCursorAdapter notes = new SimpleCursorAdapter(khoanvay_activite.this, R.layout.row_khoanvay, c, from, to);
                            listtab.setAdapter(notes);
                            Toast.makeText(getApplicationContext(), "Bạn Sửa Thành Công: " + valt, Toast.LENGTH_LONG).show();
                            notes.notifyDataSetChanged();
                            data.close();
                        }

                    });

                    myDialog.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {

                                // do something when the button is clicked

                                public void onClick(DialogInterface arg0, int arg1) {
                                }

                            });

                    myDialog.show();

                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }
        data.close();
    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    public void loadTabs() {
        //Lấy Tabhost id ra trước (cái này của built - in android
        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        //gọi lệnh setup
        tab.setup();
        TabHost.TabSpec spec;
        //Tạo tab1
        spec = tab.newTabSpec("t1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Thêm Khoản Vay");
        tab.addTab(spec);
        //Tạo tab2
        spec = tab.newTabSpec("t2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Danh Sách Khoản Vay");
        tab.addTab(spec);
        //Thiết lập tab mặc định được chọn ban đầu là tab 0
        tab.setCurrentTab(0);
    }


    public void showDatePickerDialogkv(final EditText editText) {
        OnDateSetListener callback = new OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView Date
                editText.setText((dayOfMonth) + "/" + (monthOfYear + 1) + "/" + year);
                //Lưu vết lại biến ngày hoàn thành
                cal.set(year, monthOfYear, dayOfMonth);
                dateFinish = cal.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
        //sẽ giống với trên TextView khi mở nó lên
        String s1 = editText.getText() + "";
        String strArrtmp1[] = s1.split("/");
        int ngayv = Integer.parseInt(strArrtmp1[0]);
        int thangv = Integer.parseInt(strArrtmp1[1]) - 1;
        int namv = Integer.parseInt(strArrtmp1[2]);
        DatePickerDialog pic1 = new DatePickerDialog(khoanvay_activite.this, callback, namv, thangv, ngayv);
        pic1.setTitle("Chọn ngày hoàn thành");
        pic1.show();
    }

    public void getDefaultInforkv(EditText editText) {
        //lấy ngày hiện tại của hệ thống
        cal = Calendar.getInstance();
        SimpleDateFormat dft = null;
        //Định dạng ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(cal.getTime());
        //hiển thị lên giao diện
        editText.setText(strDate);
        //gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
        dateFinish = cal.getTime();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
