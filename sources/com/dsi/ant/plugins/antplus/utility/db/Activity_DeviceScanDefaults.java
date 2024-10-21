package com.dsi.ant.plugins.antplus.utility.db;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.dsi.ant.plugins.antplus.R;
import com.dsi.ant.plugins.antplus.utility.db.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Activity_DeviceScanDefaults extends Activity {

    /* renamed from: a */
    private int f863a;

    /* renamed from: b */
    ArrayList f864b;

    /* renamed from: c */
    ArrayAdapter f865c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: com.dsi.ant.plugins.antplus.utility.db.Activity_DeviceScanDefaults$a$a */
        /* loaded from: classes.dex */
        class C0013a implements a.e {
            C0013a() {
            }

            @Override // com.dsi.ant.plugins.antplus.utility.db.a.e
            public void a(int i2, int i3) {
                Activity_DeviceScanDefaults.this.c(i3);
                Activity_DeviceScanDefaults.this.b(i3);
            }
        }

        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            if (i2 != 0) {
                return;
            }
            Activity_DeviceScanDefaults activity_DeviceScanDefaults = Activity_DeviceScanDefaults.this;
            com.dsi.ant.plugins.antplus.utility.db.a.a(activity_DeviceScanDefaults, activity_DeviceScanDefaults.f863a, new C0013a()).show();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f868a;

        b(int i2) {
            this.f868a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            String str;
            if (this.f868a == 0) {
                arrayList = Activity_DeviceScanDefaults.this.f864b;
                str = "Proximity Threshold:  OFF";
            } else {
                arrayList = Activity_DeviceScanDefaults.this.f864b;
                str = "Proximity Threshold:  " + this.f868a;
            }
            arrayList.set(0, str);
            Activity_DeviceScanDefaults.this.f865c.notifyDataSetChanged();
        }
    }

    public void b(int i2) {
        runOnUiThread(new b(i2));
    }

    public void c(int i2) {
        SharedPreferences.Editor edit = getSharedPreferences(getResources().getString(R.string.pluginmanager_settings_prefname), 0).edit();
        edit.putInt(getResources().getString(R.string.pluginmgr_settings_key_int_proximitybin), i2);
        edit.commit();
        this.f863a = i2;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_scan_defaults);
        this.f864b = new ArrayList();
        ListView listView = (ListView) findViewById(R.id.listView_settingsList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.f864b);
        this.f865c = arrayAdapter;
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new a());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f864b.clear();
        this.f864b.add("Proximity Threshold");
        int i2 = getSharedPreferences(getResources().getString(R.string.pluginmanager_settings_prefname), 0).getInt(getResources().getString(R.string.pluginmgr_settings_key_int_proximitybin), 0);
        this.f863a = i2;
        b(i2);
    }
}
