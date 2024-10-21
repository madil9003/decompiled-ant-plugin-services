package com.dsi.ant.plugins.antplus.utility.search;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.R;
import com.dsi.ant.plugins.antplus.utility.db.a;
import com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo;
import com.dsi.ant.plugins.antplus.utility.search.e;
import com.dsi.ant.plugins.antplus.utility.search.f;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Activity_SearchAllDevices extends Activity implements ActivitySearchInfo.b {

    /* renamed from: x */
    private static final String f907x = "Activity_SearchAllDevices";

    /* renamed from: a */
    String f908a;

    /* renamed from: b */
    Bundle f909b;

    /* renamed from: c */
    ActivitySearchInfo f910c;

    /* renamed from: e */
    int f912e;

    /* renamed from: f */
    TextView f913f;

    /* renamed from: g */
    TextView f914g;

    /* renamed from: h */
    CountDownLatch f915h;

    /* renamed from: i */
    ArrayList f916i;

    /* renamed from: j */
    ArrayList f917j;

    /* renamed from: k */
    TextView f918k;

    /* renamed from: l */
    ArrayAdapter f919l;

    /* renamed from: m */
    ArrayAdapter f920m;

    /* renamed from: n */
    boolean f921n;

    /* renamed from: p */
    boolean f923p;

    /* renamed from: q */
    boolean f924q;

    /* renamed from: s */
    private boolean f926s;

    /* renamed from: t */
    private boolean f927t;

    /* renamed from: u */
    private SearchResultInfo f928u;

    /* renamed from: v */
    private e.a f929v;

    /* renamed from: w */
    private com.dsi.ant.plugins.antplus.utility.search.e f930w;

    /* renamed from: d */
    Object f911d = new Object();

    /* renamed from: o */
    private final Object f922o = new Object();

    /* renamed from: r */
    private final Object f925r = new Object();

    /* loaded from: classes.dex */
    public static final class FoundDevice implements Parcelable {
        public static final Parcelable.Creator<FoundDevice> CREATOR = new a();

        /* renamed from: a */
        public SearchResultInfo f931a;

        /* renamed from: b */
        public AntPluginDeviceDbProvider.DeviceDbDeviceInfo f932b;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public FoundDevice createFromParcel(Parcel parcel) {
                FoundDevice foundDevice = new FoundDevice(null);
                foundDevice.f931a = (SearchResultInfo) parcel.readParcelable(SearchResultInfo.class.getClassLoader());
                foundDevice.f932b = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) parcel.readParcelable(AntPluginDeviceDbProvider.DeviceDbDeviceInfo.class.getClassLoader());
                return foundDevice;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public FoundDevice[] newArray(int i2) {
                return new FoundDevice[i2];
            }
        }

        private FoundDevice() {
        }

        /* synthetic */ FoundDevice(d dVar) {
            this();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f931a, i2);
            parcel.writeParcelable(this.f932b, i2);
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(Activity_SearchAllDevices.this, "Connecting to device failed, try again or select new device", 0).show();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f934a;

        b(String str) {
            this.f934a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity_SearchAllDevices.this.f919l.add(this.f934a);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f936a;

        /* renamed from: b */
        static final /* synthetic */ int[] f937b;

        static {
            int[] iArr = new int[e.a.values().length];
            f937b = iArr;
            try {
                iArr[e.a.INTERRUPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f937b[e.a.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f937b[e.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[f.a.values().length];
            f936a = iArr2;
            try {
                iArr2[f.a.INTERRUPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f936a[f.a.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f936a[f.a.CRASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
            activity_SearchAllDevices.z((Bundle) activity_SearchAllDevices.f917j.get(i2));
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((ProgressBar) Activity_SearchAllDevices.this.findViewById(R.id.progressBar_Spinner)).setVisibility(0);
            ((Button) Activity_SearchAllDevices.this.findViewById(R.id.button_SearchAgain)).setVisibility(8);
            Activity_SearchAllDevices.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements AdapterView.OnItemClickListener {

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ FoundDevice f942a;

            /* renamed from: b */
            final /* synthetic */ String f943b;

            b(FoundDevice foundDevice, String str) {
                this.f942a = foundDevice;
                this.f943b = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                Activity_SearchAllDevices.this.D(this.f942a.f931a, this.f943b);
            }
        }

        /* loaded from: classes.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ FoundDevice f945a;

            /* renamed from: b */
            final /* synthetic */ EditText f946b;

            /* renamed from: c */
            final /* synthetic */ CheckBox f947c;

            /* renamed from: d */
            final /* synthetic */ AlertDialog f948d;

            c(FoundDevice foundDevice, EditText editText, CheckBox checkBox, AlertDialog alertDialog) {
                this.f945a = foundDevice;
                this.f946b = editText;
                this.f947c = checkBox;
                this.f948d = alertDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f945a.f932b.f1177e = this.f946b.getText().toString().trim();
                this.f945a.f932b.f1178f = Boolean.valueOf(this.f947c.isChecked());
                String str = this.f945a.f932b.f1177e;
                if (str == null || str.length() == 0) {
                    Toast.makeText(this.f948d.getContext(), "Must specify device name", 0).show();
                    return;
                }
                if (!this.f945a.f932b.f1177e.matches("^[\\p{L}\\p{N}]+$")) {
                    Toast.makeText(this.f948d.getContext(), "Name must not contain spaces or special characters", 0).show();
                    return;
                }
                t0.b bVar = new t0.b(Activity_SearchAllDevices.this);
                try {
                    try {
                        Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
                        Bundle c3 = activity_SearchAllDevices.f910c.c(this.f945a.f931a, activity_SearchAllDevices.f909b);
                        bVar.b(this.f945a.f932b, Activity_SearchAllDevices.this.f908a, (com.dsi.ant.channel.b) Activity_SearchAllDevices.this.f909b.getSerializable("predefinednetwork_NetKey"), c3.getInt("int_DevType"), c3.getInt("int_TransType"), c3.getInt("int_Period"), c3.getInt("int_RfFreq"));
                    } catch (SQLException e3) {
                        h1.a.b(Activity_SearchAllDevices.f907x, "SQL error saving device to db: " + e3.toString());
                        Toast.makeText(this.f948d.getContext(), "Database error, device not saved", 0).show();
                    }
                    bVar.d();
                    this.f948d.dismiss();
                    Activity_SearchAllDevices activity_SearchAllDevices2 = Activity_SearchAllDevices.this;
                    FoundDevice foundDevice = this.f945a;
                    SearchResultInfo searchResultInfo = foundDevice.f931a;
                    activity_SearchAllDevices2.D(searchResultInfo, activity_SearchAllDevices2.f910c.e(searchResultInfo, foundDevice.f932b.f1177e));
                } catch (Throwable th) {
                    bVar.d();
                    throw th;
                }
            }
        }

        f() {
        }

        private void a(FoundDevice foundDevice, String str) {
            View inflate = LayoutInflater.from(Activity_SearchAllDevices.this).inflate(R.layout.dialogpref_modify_device, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.edittext_deviceName);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkbox_isPreferred);
            AlertDialog.Builder builder = new AlertDialog.Builder(Activity_SearchAllDevices.this);
            builder.setTitle("New device selected, save info?");
            builder.setView(inflate);
            builder.setCancelable(false);
            builder.setPositiveButton("Save ", new a());
            builder.setNegativeButton("Don't Save", new b(foundDevice, str));
            AlertDialog create = builder.create();
            t0.b bVar = new t0.b(Activity_SearchAllDevices.this);
            try {
                checkBox.setChecked(bVar.l(Activity_SearchAllDevices.this.f908a) ? false : true);
                bVar.d();
                create.show();
                create.getButton(-1).setOnClickListener(new c(foundDevice, editText, checkBox, create));
            } catch (Throwable th) {
                bVar.d();
                throw th;
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            h1.a.i(Activity_SearchAllDevices.f907x, "Search All, device selected, cancelling scan");
            FoundDevice foundDevice = (FoundDevice) Activity_SearchAllDevices.this.f916i.get(i2);
            synchronized (Activity_SearchAllDevices.this.f922o) {
                Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
                if (activity_SearchAllDevices.f921n) {
                    return;
                }
                activity_SearchAllDevices.f915h = new CountDownLatch(1);
                Activity_SearchAllDevices.this.u(foundDevice.f931a);
                String str = (String) Activity_SearchAllDevices.this.f919l.getItem(i2);
                if (foundDevice.f932b.f1174b == null) {
                    a(foundDevice, str);
                } else {
                    Activity_SearchAllDevices.this.D(foundDevice.f931a, str);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements f.b {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((ProgressBar) Activity_SearchAllDevices.this.findViewById(R.id.progressBar_Spinner)).setVisibility(8);
                ((Button) Activity_SearchAllDevices.this.findViewById(R.id.button_SearchAgain)).setVisibility(0);
            }
        }

        g() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            Activity_SearchAllDevices.this.q(searchResultInfo);
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void c(f.a aVar, AntChannel antChannel) {
            synchronized (Activity_SearchAllDevices.this.f910c) {
                Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
                activity_SearchAllDevices.f910c.f900a = antChannel;
                activity_SearchAllDevices.f926s = false;
                if (Activity_SearchAllDevices.this.f927t) {
                    if (antChannel != null) {
                        Activity_SearchAllDevices.this.B();
                    } else {
                        Activity_SearchAllDevices.this.f927t = false;
                        Activity_SearchAllDevices.this.f928u = null;
                        Activity_SearchAllDevices.this.f929v = e.a.CRASH;
                        Activity_SearchAllDevices.this.f915h.countDown();
                    }
                }
                Activity_SearchAllDevices.this.f910c.notifyAll();
            }
            int i2 = c.f936a[aVar.ordinal()];
            if (i2 == 1 || i2 == 2) {
                Activity_SearchAllDevices.this.runOnUiThread(new a());
                return;
            }
            if (i2 != 3) {
                return;
            }
            h1.a.b(Activity_SearchAllDevices.f907x, "UI Scan crashed!");
            Message obtain = Message.obtain();
            obtain.what = -4;
            Activity_SearchAllDevices.this.C(obtain);
            Activity_SearchAllDevices.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class h implements e.b {
        h() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void a(SearchResultInfo searchResultInfo, AntChannel antChannel) {
            synchronized (Activity_SearchAllDevices.this.f910c) {
                Activity_SearchAllDevices.this.f927t = false;
                ActivitySearchInfo activitySearchInfo = Activity_SearchAllDevices.this.f910c;
                activitySearchInfo.f900a = antChannel;
                activitySearchInfo.notifyAll();
            }
            Activity_SearchAllDevices.this.f928u = searchResultInfo;
            Activity_SearchAllDevices.this.f915h.countDown();
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.e.b
        public void d(e.a aVar, AntChannel antChannel) {
            synchronized (Activity_SearchAllDevices.this.f910c) {
                Activity_SearchAllDevices.this.f927t = false;
                ActivitySearchInfo activitySearchInfo = Activity_SearchAllDevices.this.f910c;
                activitySearchInfo.f900a = antChannel;
                activitySearchInfo.notifyAll();
            }
            Activity_SearchAllDevices.this.f928u = null;
            Activity_SearchAllDevices.this.f929v = aVar;
            Activity_SearchAllDevices.this.f915h.countDown();
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements a.e {
            a() {
            }

            @Override // com.dsi.ant.plugins.antplus.utility.db.a.e
            public void a(int i2, int i3) {
                Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
                activity_SearchAllDevices.f912e = i3;
                activity_SearchAllDevices.f910c.f903d.c(i3);
                if (i3 != 0 && (i3 < i2 || i2 == 0)) {
                    Activity_SearchAllDevices.this.f916i.clear();
                    Activity_SearchAllDevices.this.f919l.clear();
                }
                Activity_SearchAllDevices.this.x();
            }
        }

        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
            com.dsi.ant.plugins.antplus.utility.db.a.a(activity_SearchAllDevices, activity_SearchAllDevices.f912e, new a()).show();
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity_SearchAllDevices activity_SearchAllDevices = Activity_SearchAllDevices.this;
            int i2 = activity_SearchAllDevices.f912e;
            TextView textView = activity_SearchAllDevices.f914g;
            if (i2 == 0) {
                textView.setVisibility(0);
                Activity_SearchAllDevices.this.f913f.setText("");
            } else {
                textView.setVisibility(8);
                Activity_SearchAllDevices activity_SearchAllDevices2 = Activity_SearchAllDevices.this;
                activity_SearchAllDevices2.f913f.setText(String.valueOf(activity_SearchAllDevices2.f912e));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            Activity_SearchAllDevices.this.r();
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AlertDialog f957a;

        /* renamed from: b */
        final /* synthetic */ String f958b;

        l(AlertDialog alertDialog, String str) {
            this.f957a = alertDialog;
            this.f958b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Activity_SearchAllDevices.this.f915h.await();
                this.f957a.dismiss();
                Activity_SearchAllDevices.this.A(this.f958b);
            } catch (InterruptedException unused) {
                h1.a.b(Activity_SearchAllDevices.f907x, "InterruptedException while waiting on search for selected device");
                Activity_SearchAllDevices.this.r();
                Message obtain = Message.obtain();
                obtain.what = -4;
                Activity_SearchAllDevices.this.C(obtain);
                Activity_SearchAllDevices.this.finish();
            }
        }
    }

    public void B() {
        this.f930w.b(this.f910c.f900a, new h());
    }

    public void C(Message message) {
        synchronized (this.f925r) {
            if (!this.f924q) {
                try {
                    ((Messenger) this.f909b.getParcelable("msgr_SearchResultReceiver")).send(message);
                } catch (RemoteException unused) {
                    h1.a.b(f907x, "RemoteException trying to send result to client");
                }
                this.f924q = true;
            } else {
                h1.a.a(f907x, "Prevented erroneous sending of an extra reply: " + message.what);
            }
        }
    }

    public void q(SearchResultInfo searchResultInfo) {
        synchronized (this.f916i) {
            Iterator it = this.f916i.iterator();
            while (it.hasNext()) {
                if (this.f910c.a(searchResultInfo, ((FoundDevice) it.next()).f931a)) {
                    h1.a.i(f907x, "Found already discovered device");
                    return;
                }
            }
            Iterator it2 = this.f917j.iterator();
            while (it2.hasNext()) {
                if (this.f910c.b(searchResultInfo, (Bundle) it2.next())) {
                    h1.a.i(f907x, "Found already connected device");
                    return;
                }
            }
            t0.b bVar = new t0.b(this);
            FoundDevice foundDevice = new FoundDevice(null);
            foundDevice.f931a = searchResultInfo;
            try {
                AntPluginDeviceDbProvider.DeviceDbDeviceInfo f3 = bVar.f(searchResultInfo.f976a.a(), this.f908a);
                foundDevice.f932b = f3;
                if (f3 == null) {
                    foundDevice.f932b = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
                    foundDevice.f932b.f1177e = this.f910c.e(searchResultInfo, "ID <" + searchResultInfo.f976a.a() + "> -not saved-");
                    foundDevice.f932b.f1176d = Integer.valueOf(searchResultInfo.f976a.a());
                    foundDevice.f932b.f1174b = null;
                }
                this.f916i.add(foundDevice);
                bVar.d();
                p(foundDevice.f932b.f1177e);
            } catch (Throwable th) {
                bVar.d();
                throw th;
            }
        }
    }

    public void r() {
        synchronized (this.f910c) {
            com.dsi.ant.plugins.antplus.utility.search.e eVar = this.f930w;
            if (eVar != null) {
                eVar.a();
            }
            while (this.f927t) {
                try {
                    this.f910c.wait();
                } catch (InterruptedException unused) {
                    h1.a.j(f907x, "Interrupted while waiting for device search to finish.");
                }
            }
        }
    }

    private void s() {
        this.f910c.f903d.a();
        synchronized (this.f910c) {
            while (this.f926s) {
                try {
                    this.f910c.wait();
                } catch (InterruptedException unused) {
                    h1.a.j(f907x, "Interrupted while waiting for scan to finish.");
                }
            }
        }
    }

    private void t() {
        if (this.f910c == null) {
            return;
        }
        r();
        s();
    }

    public void u(SearchResultInfo searchResultInfo) {
        synchronized (this.f910c) {
            if (this.f927t) {
                return;
            }
            this.f927t = true;
            this.f930w = this.f910c.d(searchResultInfo, this.f909b);
            if (this.f926s) {
                this.f910c.f903d.a();
            } else {
                B();
            }
        }
    }

    private void v(int i2) {
        if (this.f912e == -1) {
            this.f912e = i2;
        }
        this.f913f = (TextView) findViewById(R.id.textView_ProxValueLabel);
        this.f914g = (TextView) findViewById(R.id.textView_ProxOffLabel);
        ((ImageView) findViewById(R.id.imageView_ProxIcon)).setOnClickListener(new i());
        x();
    }

    public void w() {
        synchronized (this.f910c) {
            if (this.f926s) {
                return;
            }
            this.f926s = true;
            ActivitySearchInfo activitySearchInfo = this.f910c;
            activitySearchInfo.f903d.b(activitySearchInfo.f900a, new g());
        }
    }

    public void x() {
        runOnUiThread(new j());
    }

    private void y() {
        Message obtain = Message.obtain();
        obtain.what = -2;
        C(obtain);
    }

    protected void A(String str) {
        synchronized (this.f922o) {
            if (this.f921n) {
                return;
            }
            if (this.f928u != null) {
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.arg1 = 0;
                Bundle bundle = new Bundle();
                bundle.putParcelable("clsRESULTINFO", this.f928u);
                bundle.putString("str_SelectedDeviceName", str);
                obtain.setData(bundle);
                C(obtain);
                finish();
                return;
            }
            int i2 = c.f937b[this.f929v.ordinal()];
            if (i2 == 2) {
                runOnUiThread(new a());
            } else if (i2 == 3) {
                h1.a.b(f907x, "Search for device crashed!");
                Message obtain2 = Message.obtain();
                obtain2.what = -4;
                C(obtain2);
                finish();
            }
        }
    }

    protected void D(SearchResultInfo searchResultInfo, String str) {
        try {
            if (this.f915h.await(0L, TimeUnit.MILLISECONDS)) {
                A(str);
                return;
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_search_wait, (ViewGroup) null);
            inflate.findViewById(R.id.buttonPanel_SearchPreferredButtons).setVisibility(8);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Acquiring Signal");
            builder.setView(inflate);
            builder.setCancelable(false);
            builder.setNegativeButton("Cancel", new k());
            AlertDialog create = builder.create();
            create.show();
            ((TextView) create.findViewById(R.id.textView_Status)).setText("Connecting to '" + str + "'...");
            new Thread(new l(create, str)).start();
        } catch (InterruptedException unused) {
            h1.a.b(f907x, "InterruptedException while waiting on search for selected device");
            r();
            Message obtain = Message.obtain();
            obtain.what = -4;
            C(obtain);
            finish();
        }
    }

    @Override // com.dsi.ant.plugins.antplus.utility.search.ActivitySearchInfo.b
    public void a() {
        synchronized (this.f910c) {
            this.f926s = false;
            this.f927t = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        synchronized (this.f922o) {
            this.f921n = true;
            t();
            if (!this.f924q) {
                y();
            }
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList arrayList;
        Bundle bundle2;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f912e = bundle.getInt("int_CurrentProximitySetting");
            arrayList = bundle.getParcelableArrayList("searchResultInfoArrayList_DetectedDevices");
        } else {
            this.f912e = -1;
            arrayList = new ArrayList();
        }
        this.f916i = arrayList;
        setContentView(R.layout.activity_search_all_devices);
        this.f923p = false;
        this.f924q = false;
        this.f921n = false;
        this.f926s = false;
        this.f927t = false;
        Intent intent = getIntent();
        if (intent != null) {
            this.f909b = intent.getBundleExtra("com.dsi.ant.plugins.antplus.pcc.plugindata");
        }
        if (intent == null || (bundle2 = this.f909b) == null) {
            h1.a.b(f907x, "Attempt to start activity with illegal arguments");
            this.f924q = true;
            finish();
            return;
        }
        ActivitySearchInfo activitySearchInfo = (ActivitySearchInfo) bundle2.getParcelable("cls_ActivitySearchInfo");
        this.f910c = activitySearchInfo;
        if (activitySearchInfo.f905f) {
            finish();
            return;
        }
        activitySearchInfo.f906g = this;
        this.f908a = this.f909b.getString("str_PluginName");
        TextView textView = (TextView) findViewById(R.id.textView_Status);
        this.f918k = textView;
        textView.setText("Searching for " + this.f908a + "...");
        v(this.f910c.f904e);
        ArrayList parcelableArrayList = this.f909b.getParcelableArrayList("albdlCONNECTEDDEVICES");
        this.f917j = parcelableArrayList;
        if (parcelableArrayList.size() > 0) {
            ArrayList parcelableArrayList2 = this.f909b.getParcelableArrayList("albdlCONNECTEDDEVICEINFOS");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = parcelableArrayList2.iterator();
            while (it.hasNext()) {
                arrayList2.add(((AntPluginDeviceDbProvider.DeviceDbDeviceInfo) it.next()).f1177e);
            }
            this.f920m = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayList2);
            ListView listView = (ListView) findViewById(R.id.listView_AlreadyConnectedDevices);
            listView.setAdapter((ListAdapter) this.f920m);
            listView.setOnItemClickListener(new d());
            listView.setVisibility(0);
            findViewById(R.id.textView_AlreadyConnectedTitle).setVisibility(0);
        }
        ((Button) findViewById(R.id.button_SearchAgain)).setOnClickListener(new e());
        this.f919l = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        Iterator it2 = this.f916i.iterator();
        while (it2.hasNext()) {
            this.f919l.add(((FoundDevice) it2.next()).f932b.f1177e);
        }
        ListView listView2 = (ListView) findViewById(R.id.listView_FoundDevices);
        listView2.setAdapter((ListAdapter) this.f919l);
        listView2.setOnItemClickListener(new f());
        w();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        synchronized (this.f922o) {
            t();
            if (!this.f923p) {
                this.f921n = true;
                if (!this.f924q) {
                    y();
                }
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        this.f923p = true;
        return super.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("int_CurrentProximitySetting", this.f912e);
        bundle.putSerializable("searchResultInfoArrayList_DetectedDevices", this.f916i);
        super.onSaveInstanceState(bundle);
    }

    protected void p(String str) {
        runOnUiThread(new b(str));
    }

    protected void z(Bundle bundle) {
        synchronized (this.f922o) {
            t();
            this.f921n = true;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        C(obtain);
        finish();
    }
}
