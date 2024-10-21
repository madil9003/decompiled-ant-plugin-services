package com.dsi.ant.plugins.antplus.utility.db;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.widget.Toast;
import com.dsi.ant.plugins.antplus.R;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t0.b;

/* loaded from: classes.dex */
public class Activity_SavedDeviceList extends PreferenceActivity {

    /* loaded from: classes.dex */
    public class a implements Preference.OnPreferenceChangeListener {
        a() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            Activity_SavedDeviceList.this.a();
            return true;
        }
    }

    public void a() {
        getPreferenceScreen().removeAll();
        b bVar = new b(this);
        try {
            Map g3 = bVar.g();
            if (g3.isEmpty()) {
                Toast.makeText(this, "Device database is empty", 0).show();
                finish();
            } else {
                for (Map.Entry entry : g3.entrySet()) {
                    PreferenceCategory preferenceCategory = new PreferenceCategory(this);
                    preferenceCategory.setTitle((CharSequence) entry.getKey());
                    preferenceCategory.setPersistent(false);
                    getPreferenceScreen().addPreference(preferenceCategory);
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        t0.a aVar = new t0.a(this, (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) it.next());
                        aVar.setKey("test");
                        aVar.setOnPreferenceChangeListener(new a());
                        preferenceCategory.addPreference(aVar);
                    }
                }
            }
        } finally {
            bVar.d();
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.layout.activity_saved_device_list);
        getPreferenceScreen().setOrderingAsAdded(true);
        a();
    }
}
