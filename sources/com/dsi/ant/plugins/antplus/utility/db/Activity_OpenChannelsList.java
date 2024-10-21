package com.dsi.ant.plugins.antplus.utility.db;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.TextView;
import com.dsi.ant.plugins.antplus.R;

/* loaded from: classes.dex */
public class Activity_OpenChannelsList extends Activity {

    /* renamed from: i */
    static final String f870i = "Activity_OpenChannelsList";

    /* renamed from: a */
    f.a f871a;

    /* renamed from: e */
    TextView f875e;

    /* renamed from: f */
    TextView f876f;

    /* renamed from: b */
    boolean f872b = false;

    /* renamed from: c */
    boolean f873c = false;

    /* renamed from: d */
    boolean f874d = false;

    /* renamed from: g */
    ServiceConnection f877g = new a();

    /* renamed from: h */
    BroadcastReceiver f878h = new b();

    /* loaded from: classes.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Activity_OpenChannelsList.this.f871a = new f.a(iBinder);
            Activity_OpenChannelsList activity_OpenChannelsList = Activity_OpenChannelsList.this;
            activity_OpenChannelsList.f873c = true;
            try {
                activity_OpenChannelsList.d(Integer.valueOf(activity_OpenChannelsList.f871a.b().b()));
            } catch (RemoteException unused) {
                h1.a.j(Activity_OpenChannelsList.f870i, "RemoteException occured while trying to query available channels");
                Activity_OpenChannelsList.this.b("RemoteException querying ARS");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h1.a.b(Activity_OpenChannelsList.f870i, "AntChannelProvider binder disconnected");
            Activity_OpenChannelsList.this.b("Binder disconnected");
            Activity_OpenChannelsList.this.c();
            Activity_OpenChannelsList.this.f873c = true;
        }
    }

    /* loaded from: classes.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("com.dsi.ant.intent.action.CHANNEL_PROVIDER_STATE_CHANGED")) {
                h1.a.a(Activity_OpenChannelsList.f870i, "Received unexpected intent: " + intent.getAction());
                return;
            }
            Bundle extras = intent.getExtras();
            if (!extras.containsKey("com.dsi.ant.intent.extra.CHANNEL_PROVIDER_NUM_CHANNELS_AVAILABLE")) {
                h1.a.b(Activity_OpenChannelsList.f870i, "Channel Provider State Change intent did not contain channel available data");
            }
            Activity_OpenChannelsList.this.d(Integer.valueOf(extras.getInt("com.dsi.ant.intent.extra.CHANNEL_PROVIDER_NUM_CHANNELS_AVAILABLE")));
            Activity_OpenChannelsList.this.f873c = true;
        }
    }

    public void d(Integer num) {
        this.f875e.setText("Detected Channels Available: ");
        this.f876f.setText(num.toString());
        this.f876f.setEnabled(true);
    }

    void b(String str) {
        this.f875e.setText("Error: " + str + "!");
        this.f876f.setText("!");
        this.f876f.setEnabled(false);
    }

    void c() {
        if (this.f872b) {
            unbindService(this.f877g);
            this.f872b = false;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_open_channels_list);
        this.f875e = (TextView) findViewById(R.id.textView_Status);
        this.f876f = (TextView) findViewById(R.id.textView_FreeChannels);
        this.f875e.setText("Connecting to binder...");
        this.f876f.setText("");
        registerReceiver(this.f878h, new IntentFilter("com.dsi.ant.intent.action.CHANNEL_PROVIDER_STATE_CHANGED"));
        this.f873c = false;
        if (this.f872b) {
            return;
        }
        if (f.a.a(this, this.f877g)) {
            this.f872b = true;
        } else {
            unbindService(this.f877g);
            b("Bind failed");
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        unregisterReceiver(this.f878h);
        c();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f874d = false;
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f874d = true;
    }
}
