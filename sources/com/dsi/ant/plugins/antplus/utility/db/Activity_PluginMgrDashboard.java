package com.dsi.ant.plugins.antplus.utility.db;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.dsi.ant.plugins.antplus.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Activity_PluginMgrDashboard extends ListActivity {

    /* renamed from: a */
    private static final String f881a = "Activity_PluginMgrDashboard";

    /* loaded from: classes.dex */
    class a extends HashMap {
        a() {
            put("title", "Saved Devices");
            put("desc", "Manage saved and preferred devices");
        }
    }

    /* loaded from: classes.dex */
    class b extends HashMap {
        b() {
            put("title", "Device Scan Defaults");
            put("desc", "Change default settings for device scans");
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            h1.a.f(f881a, "ANT+ Plugin Settings Version: " + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e3) {
            h1.a.f(f881a, "ANT+ Plugin Settings Version: " + e3.toString());
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_plugin_mgr_dashboard);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a());
        arrayList.add(new b());
        setListAdapter(new SimpleAdapter(this, arrayList, android.R.layout.simple_list_item_2, new String[]{"title", "desc"}, new int[]{android.R.id.text1, android.R.id.text2}));
    }

    @Override // android.app.ListActivity
    protected void onListItemClick(ListView listView, View view, int i2, long j2) {
        Intent intent;
        String str;
        if (i2 == 0) {
            intent = new Intent(this, (Class<?>) Activity_SavedDeviceList.class);
        } else if (i2 == 1) {
            intent = new Intent(this, (Class<?>) Activity_DeviceScanDefaults.class);
        } else {
            if (i2 != 2) {
                if (i2 != 4) {
                    str = "This menu item is not implemented";
                } else {
                    deleteDatabase("saved_devices.db");
                    str = "Database Cleared";
                }
                Toast.makeText(this, str, 0).show();
                return;
            }
            intent = new Intent(this, (Class<?>) Activity_OpenChannelsList.class);
        }
        startActivity(intent);
    }
}
