package com.dsi.ant.plugins.antplus.utility.search;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.R;
import com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo;
import com.dsi.ant.plugins.antplus.utility.search.e;

/* loaded from: classes.dex */
public class Dialog_SearchPreferredDevice extends Activity implements ActivitySearchInfo.b {

    /* renamed from: h */
    private static final String f960h = "Dialog_SearchPreferredDevice";

    /* renamed from: a */
    String f961a;

    /* renamed from: b */
    Bundle f962b;

    /* renamed from: c */
    ActivitySearchInfo f963c;

    /* renamed from: d */
    boolean f964d;

    /* renamed from: e */
    boolean f965e;

    /* renamed from: f */
    boolean f966f;

    /* renamed from: g */
    private final Object f967g = new Object();

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog_SearchPreferredDevice dialog_SearchPreferredDevice = Dialog_SearchPreferredDevice.this;
            dialog_SearchPreferredDevice.h(dialog_SearchPreferredDevice.f962b);
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog_SearchPreferredDevice.this.onBackPressed();
        }
    }

    /* loaded from: classes.dex */
    public class c implements e.b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: com.dsi.ant.plugins.antplus.utility.search.Dialog_SearchPreferredDevice$c$a$a */
            /* loaded from: classes.dex */
            class DialogInterfaceOnClickListenerC0015a implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC0015a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Dialog_SearchPreferredDevice.this.k();
                }
            }

            /* loaded from: classes.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Dialog_SearchPreferredDevice dialog_SearchPreferredDevice = Dialog_SearchPreferredDevice.this;
                    dialog_SearchPreferredDevice.h(dialog_SearchPreferredDevice.f962b);
                }
            }

            /* renamed from: com.dsi.ant.plugins.antplus.utility.search.Dialog_SearchPreferredDevice$c$a$c */
            /* loaded from: classes.dex */
            class DialogInterfaceOnClickListenerC0016c implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC0016c() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Dialog_SearchPreferredDevice.this.i();
                    Dialog_SearchPreferredDevice.this.finish();
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(Dialog_SearchPreferredDevice.this).setCancelable(false).setTitle("Preferred Device Not Found").setNegativeButton("Cancel", new DialogInterfaceOnClickListenerC0016c()).setNeutralButton("Search All", new b()).setPositiveButton("Retry", new DialogInterfaceOnClickListenerC0015a()).show();
            }
        }

        c() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            synchronized (Dialog_SearchPreferredDevice.this.f967g) {
                Dialog_SearchPreferredDevice dialog_SearchPreferredDevice = Dialog_SearchPreferredDevice.this;
                dialog_SearchPreferredDevice.f963c.f900a = antChannel;
                dialog_SearchPreferredDevice.f966f = false;
                dialog_SearchPreferredDevice.f967g.notify();
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = 0;
            Bundle bundle = new Bundle();
            bundle.putParcelable("clsRESULTINFO", searchResultInfo);
            bundle.putString("str_SelectedDeviceName", Dialog_SearchPreferredDevice.this.f961a);
            obtain.setData(bundle);
            Dialog_SearchPreferredDevice.this.j(obtain);
            Dialog_SearchPreferredDevice.this.finish();
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            synchronized (Dialog_SearchPreferredDevice.this.f967g) {
                Dialog_SearchPreferredDevice dialog_SearchPreferredDevice = Dialog_SearchPreferredDevice.this;
                dialog_SearchPreferredDevice.f963c.f900a = antChannel;
                dialog_SearchPreferredDevice.f966f = false;
                dialog_SearchPreferredDevice.f967g.notify();
            }
            int i2 = d.f975a[aVar.ordinal()];
            if (i2 == 1) {
                Dialog_SearchPreferredDevice.this.runOnUiThread(new a());
                return;
            }
            if (i2 != 3) {
                return;
            }
            h1.a.b(Dialog_SearchPreferredDevice.f960h, "Search for preferred device crashed.");
            Message obtain = Message.obtain();
            obtain.what = -4;
            Dialog_SearchPreferredDevice.this.j(obtain);
            Dialog_SearchPreferredDevice.this.finish();
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class d {

        /* renamed from: a */
        static final /* synthetic */ int[] f975a;

        static {
            int[] iArr = new int[e.a.values().length];
            f975a = iArr;
            try {
                iArr[e.a.TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f975a[e.a.INTERRUPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f975a[e.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void g() {
        e eVar;
        ActivitySearchInfo activitySearchInfo = this.f963c;
        if (activitySearchInfo == null || (eVar = activitySearchInfo.f901b) == null) {
            return;
        }
        eVar.a();
        synchronized (this.f967g) {
            while (this.f966f) {
                try {
                    this.f967g.wait();
                } catch (InterruptedException unused) {
                    h1.a.j(f960h, "Interrupted while waiting for search to finish.");
                }
            }
        }
    }

    public void i() {
        Message obtain = Message.obtain();
        obtain.what = -2;
        j(obtain);
    }

    public void j(Message message) {
        synchronized (this.f967g) {
            if (!this.f965e) {
                try {
                    ((Messenger) this.f962b.getParcelable("msgr_SearchResultReceiver")).send(message);
                } catch (RemoteException unused) {
                    h1.a.b(f960h, "RemoteException trying to send result to client");
                }
                this.f965e = true;
            } else {
                h1.a.a(f960h, "Prevented erroneous sending of an extra reply: " + message.what);
            }
        }
    }

    public void k() {
        synchronized (this.f967g) {
            if (this.f966f) {
                return;
            }
            this.f966f = true;
            ActivitySearchInfo activitySearchInfo = this.f963c;
            activitySearchInfo.f901b.b(activitySearchInfo.f900a, new c());
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo.b
    public void a() {
        synchronized (this.f967g) {
            this.f966f = false;
            finish();
        }
    }

    void h(Bundle bundle) {
        g();
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_SearchAllDevices.class);
        intent.putExtra("com.dsi.ant.plugins.antplus.pcc.plugindata", bundle);
        startActivity(intent);
        this.f965e = true;
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        g();
        i();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        setContentView(R.layout.dialog_search_wait);
        this.f964d = false;
        this.f965e = false;
        Intent intent = getIntent();
        if (intent != null) {
            this.f962b = intent.getBundleExtra("com.dsi.ant.plugins.antplus.pcc.plugindata");
        }
        if (intent == null || (bundle2 = this.f962b) == null) {
            h1.a.b(f960h, "Attempt to start activity with illegal arguments");
            this.f965e = true;
            finish();
            return;
        }
        ActivitySearchInfo activitySearchInfo = (ActivitySearchInfo) bundle2.getParcelable("cls_ActivitySearchInfo");
        this.f963c = activitySearchInfo;
        if (activitySearchInfo.f901b == null) {
            h(this.f962b);
        } else {
            TextView textView = (TextView) findViewById(R.id.textView_Status);
            this.f961a = this.f963c.f902c;
            textView.setText("Searching for preferred device: " + this.f961a);
            ActivitySearchInfo activitySearchInfo2 = this.f963c;
            if (activitySearchInfo2.f905f) {
                finish();
                return;
            } else {
                activitySearchInfo2.f906g = this;
                k();
            }
        }
        ((Button) findViewById(R.id.button_SearchAll)).setOnClickListener(new a());
        ((Button) findViewById(R.id.button_CancelSearch)).setOnClickListener(new b());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        g();
        if (!this.f965e && !this.f964d) {
            i();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        this.f964d = true;
        return super.onRetainNonConfigurationInstance();
    }
}
