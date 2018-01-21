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
import android.util.Log;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import Database.DataAdapter;

public class KhoanChi_acitive extends Activity {


    private DataAdapter db;
    private Date dateFinish;
    Calendar cal;
    Button bttthemkc, bttdate, bt_clear;
    EditText editsotien, editdate, et_tkc;
    ListView listviekc;
    SimpleCursorAdapter cursordata;
    ImageButton imgbt_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khoangchi);

        bttthemkc = (Button) findViewById(R.id.btnkhoanchi);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        bttdate = (Button) findViewById(R.id.bt_datekc);
        editdate = (EditText) findViewById(R.id.editdatekc);
        editsotien = (EditText) findViewById(R.id.editsotienkc);
        listviekc = (ListView) findViewById(R.id.listVkc);
        imgbt_back = (ImageButton) findViewById(R.id.imgbt_backkc);
        et_tkc = (EditText) findViewById(R.id.et_tkc);


        db = new DataAdapter(KhoanChi_acitive.this);
        db.open();
        Cursor curn = db.getAllkc();
        startManagingCursor(curn);

        String[] from = new String[]{DataAdapter.mathloaichi, DataAdapter.colsotienkc, DataAdapter.colngaychi};
        int[] to = new int[]{R.id.txttenkc, R.id.txtsotienkc, R.id.txtngaytrakc};

        cursordata = new SimpleCursorAdapter(this, R.layout.row_khoanchi, curn, from, to);
        listviekc.setAdapter(cursordata);
        disAllKC();
        loadTabs();


        bttthemkc.setEnabled(false);
        et_tkc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((et_tkc.getText().toString().equals("")) ||
                        (editsotien.getText().toString().equals("")) ||
                        (editdate.getText().toString().equals(""))) {
                    bttthemkc.setEnabled(false);
                } else {
                    bttthemkc.setEnabled(true);
                }
            }
        });
        editsotien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((et_tkc.getText().toString().equals("")) ||
                        (editsotien.getText().toString().equals("")) ||
                        (editdate.getText().toString().equals(""))) {
                    bttthemkc.setEnabled(false);
                } else {
                    bttthemkc.setEnabled(true);
                }
            }
        });


        editdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((et_tkc.getText().toString().equals("")) ||
                        (editsotien.getText().toString().equals("")) ||
                        (editdate.getText().toString().equals(""))) {
                    bttthemkc.setEnabled(false);
                } else {
                    bttthemkc.setEnabled(true);
                }
            }
        });


        bttdate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getDefaultInforkc();
                showDatePickerDialogkc();
            }
        });
        bttthemkc.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub\

                String tkc = et_tkc.getText().toString();
                int st = Integer.parseInt(editsotien.getText().toString());
                String nc = editdate.getText().toString();
                db.insertkhoanchi(tkc, st, nc);
                Toast.makeText(getApplicationContext(), "Thêm Thành Công Tên: " + tkc, Toast.LENGTH_LONG).show();
                disAllKC();
                editsotien.setText(null);
                editdate.setText(null);
                et_tkc.setText(null);
            }
        });
        bt_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                et_tkc.setText(null);
                editdate.setText(null);
                editsotien.setText(null);
            }
        });

        imgbt_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhoanChi_acitive.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void disAllKC() {
        try {
            db.open();
            //	try {
            Cursor curn = db.getAllkc();
            startManagingCursor(curn);

            String[] from = new String[]{DataAdapter.mathloaichi, DataAdapter.colsotienkc, DataAdapter.colngaychi};
            int[] to = new int[]{R.id.txttenkc, R.id.txtsotienkc, R.id.txtngaytrakc};

            cursordata = new SimpleCursorAdapter(this, R.layout.row_khoanchi, curn, from, to);
            listviekc.setAdapter(cursordata);
            listviekc.setOnItemClickListener(new OnItemClickListener() {

                @SuppressLint("NewApi")
                @Override
                public void onItemClick(AdapterView<?> parent, View arg1, int position, long id) {
                    // TODO Auto-generated method stub

                    Cursor cursor = (Cursor) parent.getItemAtPosition(position);

                    final int item_id = cursor.getInt(cursor.getColumnIndex(DataAdapter.colkvID));
                    String item_ten = cursor.getString(cursor.getColumnIndex(DataAdapter.mathloaichi));
                    String item_st = cursor.getString(cursor.getColumnIndex(DataAdapter.colsotienkc));
                    String item_nc = cursor.getString(cursor.getColumnIndex(DataAdapter.colngaychi));

                    AlertDialog.Builder myDialog = new AlertDialog.Builder(KhoanChi_acitive.this);

                    myDialog.setTitle("Delete/Edit?");
                    TextView dialogTxt_id = new TextView(KhoanChi_acitive.this);

                    LayoutParams dialogTxt_idLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                    dialogTxt_id.setLayoutParams(dialogTxt_idLayoutParams);

                    dialogTxt_id.setText("->" + String.valueOf(position + 1));


                    final EditText stkc = new EditText(KhoanChi_acitive.this);
                    stkc.setInputType(InputType.TYPE_CLASS_NUMBER);
                    final EditText nc = new EditText(KhoanChi_acitive.this);
                    nc.setInputType(InputType.TYPE_CLASS_DATETIME);
                    final EditText tenkc = new EditText(KhoanChi_acitive.this);

                    LayoutParams tenkc_layoupa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams stkc_layoupa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
                    LayoutParams nc_layoupa = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

                    tenkc.setLayoutParams(tenkc_layoupa);
                    stkc.setLayoutParams(stkc_layoupa);
                    nc.setLayoutParams(nc_layoupa);

                    tenkc.setText(item_ten);
                    stkc.setText(item_st);
                    nc.setText(item_nc);

                    LinearLayout layout = new LinearLayout(KhoanChi_acitive.this);

                    layout.setOrientation(LinearLayout.VERTICAL);

                    layout.addView(dialogTxt_id);

                    layout.addView(tenkc);
                    layout.addView(stkc);
                    layout.addView(nc);

                    myDialog.setView(layout);

                    myDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked

                        public void onClick(DialogInterface arg0, int arg1) {

                            LinearLayout layout = new LinearLayout(KhoanChi_acitive.this);
                            AlertDialog.Builder builder = new AlertDialog.Builder(layout.getContext());
                            builder.setTitle("Hỏi Xóa");
                            builder.setMessage("Bạn Có Muốn Xóa Khoản Chi Này Không?");
                            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated
                                    // method stub
                                    db.open();
                                    db.deletekc(item_id);

                                    Cursor c = db.getAllkc();
                                    startManagingCursor(c);
                                    String[] from = new String[]{DataAdapter.mathloaichi, DataAdapter.colsotienkc, DataAdapter.colngaychi};
                                    for (int i = 0; i < from.length; i++) {
                                        Log.e("mathloaichi", from[i]);
                                    }
                                    int[] to = new int[]{R.id.txttenkc, R.id.txtsotienkc, R.id.txtngaytrakc};

                                    SimpleCursorAdapter notes = new SimpleCursorAdapter(KhoanChi_acitive.this, R.layout.row_khoanchi, c, from, to);
                                    listviekc.setAdapter(notes);

                                    notes.notifyDataSetChanged();
                                    db.close();
                                }
                            });
                            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated
                                    // method stub
                                    dialog.dismiss();
                                }
                            });
                            builder.create().show();

                        }

                    });

                    myDialog.setNeutralButton("Update", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked

                        public void onClick(DialogInterface arg0, int arg1) {

                            String valt = tenkc.getText().toString();
                            int valstkc = Integer.parseInt(stkc.getText().toString());
                            String valkc = nc.getText().toString();
                            db.open();
                            db.updatekhoanchi(item_id, valt, valstkc, valkc);

                            Cursor c = db.getAllkc();
                            startManagingCursor(c);

                            String[] from = new String[]{DataAdapter.mathloaichi, DataAdapter.colsotienkc, DataAdapter.colngaychi};
                            int[] to = new int[]{R.id.txttenkc, R.id.txtsotienkc, R.id.txtngaytrakc};

                            SimpleCursorAdapter notes = new SimpleCursorAdapter(KhoanChi_acitive.this, R.layout.row_khoanchi, c, from, to);
                            listviekc.setAdapter(notes);
                            Toast.makeText(getApplicationContext(), "Bạn Sửa Thành Công: " + valt, Toast.LENGTH_LONG).show();
                            notes.notifyDataSetChanged();
                            db.close();
                        }

                    });

                    myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

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
        db.close();
    }


    public void loadTabs() {
        // Lấy Tabhost id ra trước (cái này của built - in android
        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        // gọi lệnh setup
        tab.setup();
        TabHost.TabSpec spec;
        // Tạo tab1
        spec = tab.newTabSpec("tab1");
        spec.setContent(R.id.tab1kc);
        spec.setIndicator("Thêm Khoản Chi");
        tab.addTab(spec);
        // Tạo tab2
        spec = tab.newTabSpec("t2");
        spec.setContent(R.id.tab2kc);
        spec.setIndicator("Danh Sách Khoản Chi");
        tab.addTab(spec);
        // Thiết lập tab mặc định được chọn ban đầu là tab 0
        tab.setCurrentTab(0);
    }

    public void getDefaultInforkc() {
        // lấy ngày hiện tại của hệ thống
        cal = Calendar.getInstance();
        SimpleDateFormat dft = null;
        // Định dạng ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(cal.getTime());
        // hiển thị lên giao diện
        editdate.setText(strDate);
        // gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
        dateFinish = cal.getTime();
    }

    public void showDatePickerDialogkc() {
        OnDateSetListener callback = new OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView
                // Date
                editdate.setText((dayOfMonth) + "/" + (monthOfYear + 1) + "/" + year);
                // Lưu vết lại biến ngày hoàn thành
                cal.set(year, monthOfYear, dayOfMonth);
                dateFinish = cal.getTime();
            }
        };
        // các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
        // sẽ giống với trên TextView khi mở nó lên
        String s1 = editdate.getText() + "";
        String strArrtmp1[] = s1.split("/");
        int ngayv = Integer.parseInt(strArrtmp1[0]);
        int thangv = Integer.parseInt(strArrtmp1[1]) - 1;
        int namv = Integer.parseInt(strArrtmp1[2]);
        DatePickerDialog pic1 = new DatePickerDialog(KhoanChi_acitive.this, callback, namv, thangv, ngayv);
        pic1.setTitle("Chọn ngày hoàn thành");
        pic1.show();
    }

}
