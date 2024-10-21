package d1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.widget.Toast;
import com.dsi.ant.plugins.antplus.pccbase.a;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: l */
    private static final String f1583l = "a";

    /* renamed from: k */
    protected Context f1594k;

    /* renamed from: a */
    private final Object f1584a = new Object();

    /* renamed from: b */
    private Map f1585b = new HashMap();

    /* renamed from: c */
    private List f1586c = new ArrayList();

    /* renamed from: d */
    private List f1587d = new ArrayList();

    /* renamed from: e */
    public Map f1588e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f */
    private List f1589f = null;

    /* renamed from: g */
    private int f1590g = 0;

    /* renamed from: i */
    private Map f1592i = Collections.synchronizedMap(new HashMap());

    /* renamed from: j */
    private final f1.a f1593j = new f1.a(10000);

    /* renamed from: h */
    private g f1591h = new g();

    /* renamed from: d1.a$a */
    /* loaded from: classes.dex */
    public class RunnableC0029a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ d1.c f1595a;

        RunnableC0029a(d1.c cVar) {
            this.f1595a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B(this.f1595a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f1597a;

        /* renamed from: b */
        final /* synthetic */ DataType f1598b;

        /* renamed from: c */
        final /* synthetic */ z1.b f1599c;

        /* renamed from: d */
        final /* synthetic */ d1.c f1600d;

        b(int i2, DataType dataType, z1.b bVar, d1.c cVar) {
            this.f1597a = i2;
            this.f1598b = dataType;
            this.f1599c = bVar;
            this.f1600d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1597a == 0) {
                synchronized (a.this.f1584a) {
                    if (a.this.f1585b.get(this.f1598b) != this.f1599c) {
                        return;
                    }
                    if (!a.this.f1592i.containsKey(Integer.valueOf(a.this.f1590g))) {
                        a.this.f1590g = 0;
                    }
                    if (a.this.f1590g == 0) {
                        a aVar = a.this;
                        aVar.f1590g = aVar.v();
                        if (a.this.f1590g == 0) {
                            d1.c cVar = new d1.c(this.f1597a, a.this.f1587d);
                            cVar.f(this.f1598b, this.f1599c);
                            a.this.C(cVar, -3);
                            return;
                        }
                    }
                    if (!a.this.f1592i.containsKey(Integer.valueOf(a.this.f1590g))) {
                        a aVar2 = a.this;
                        d1.c n2 = aVar2.n(aVar2.f1590g);
                        a.this.f1592i.put(Integer.valueOf(a.this.f1590g), n2);
                        a.this.B(n2);
                    }
                }
            } else {
                a.this.B(this.f1600d);
            }
            a.this.E(this.f1599c, this.f1597a, this.f1598b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements a.e {

        /* renamed from: a */
        private p0.b f1602a = null;

        /* renamed from: b */
        final /* synthetic */ d1.c f1603b;

        c(d1.c cVar) {
            this.f1603b = cVar;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.e
        public void b(p0.b bVar) {
            a aVar;
            d1.c cVar;
            int i2;
            if (this.f1602a == null) {
                this.f1602a = bVar;
            }
            int i3 = f.f1608a[bVar.ordinal()];
            if (i3 == 1) {
                aVar = a.this;
                cVar = this.f1603b;
                i2 = -2;
            } else {
                if (i3 != 2) {
                    return;
                }
                aVar = a.this;
                cVar = this.f1603b;
                i2 = -1;
            }
            aVar.C(cVar, i2);
            a.this.D(this.f1603b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Context f1605a;

        d(Context context) {
            this.f1605a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + com.dsi.ant.plugins.antplus.pccbase.a.k()));
            intent.addFlags(268435456);
            this.f1605a.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class f {

        /* renamed from: a */
        static final /* synthetic */ int[] f1608a;

        /* renamed from: b */
        static final /* synthetic */ int[] f1609b;

        static {
            int[] iArr = new int[p0.e.values().length];
            f1609b = iArr;
            try {
                iArr[p0.e.CHANNEL_NOT_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1609b[p0.e.ADAPTER_NOT_DETECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1609b[p0.e.BAD_PARAMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1609b[p0.e.OTHER_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1609b[p0.e.DEPENDENCY_NOT_INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1609b[p0.e.USER_CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1609b[p0.e.SEARCH_TIMEOUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1609b[p0.e.UNRECOGNIZED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[p0.b.values().length];
            f1608a = iArr2;
            try {
                iArr2[p0.b.DEAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1608a[p0.b.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1608a[p0.b.SEARCHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends Handler {
        g() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.dsi.ant.plugins.antplus.pccbase.d A;
            d1.c cVar = (d1.c) message.obj;
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1 || cVar.f1617c == null) {
                    return;
                }
                h1.a.f(a.f1583l, "Release_PCC_ACCESS " + cVar);
                cVar.f1617c.g();
                A = null;
            } else {
                if (!a.this.f1592i.containsValue(cVar) || cVar.f1617c != null) {
                    return;
                }
                h1.a.f(a.f1583l, "Request pcc access for device " + cVar.f1615a);
                A = a.this.A(cVar);
            }
            cVar.f1617c = A;
        }
    }

    public a(Context context) {
        this.f1594k = context;
    }

    public void B(d1.c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = cVar;
        this.f1591h.sendMessage(obtain);
    }

    public void D(d1.c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.f1591h.sendMessage(obtain);
    }

    public d1.c n(int i2) {
        ArrayList arrayList = new ArrayList();
        for (DataSource dataSource : this.f1586c) {
            if (d1.f.a(dataSource.c()).f1644a == i2) {
                arrayList.add(dataSource);
            }
        }
        return new d1.c(i2, arrayList);
    }

    private boolean p(int i2, DataType dataType) {
        synchronized (this.f1586c) {
            for (DataSource dataSource : this.f1586c) {
                if (d1.f.a(dataSource.c()).f1644a == i2 && dataSource.a().equals(dataType)) {
                    return false;
                }
            }
            return true;
        }
    }

    private ArrayList q(DataType dataType, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataSource dataSource = (DataSource) it.next();
            if (dataType.equals(dataSource.a())) {
                arrayList.add(dataSource);
            }
        }
        return arrayList;
    }

    private List s() {
        if (this.f1589f == null) {
            this.f1589f = o();
        }
        return this.f1589f;
    }

    private void y(d1.c cVar) {
        this.f1593j.e(new RunnableC0029a(cVar));
    }

    protected abstract com.dsi.ant.plugins.antplus.pccbase.d A(d1.c cVar);

    protected abstract void C(d1.c cVar, int i2);

    public boolean E(z1.b bVar, int i2, DataType dataType) {
        d1.c cVar;
        int i3;
        d1.c cVar2;
        String str = f1583l;
        h1.a.f(str, "setDispatcher() for type: " + dataType.b() + " device id: " + i2);
        if (i2 == 0) {
            synchronized (this.f1584a) {
                this.f1585b.put(dataType, bVar);
            }
        }
        if (this.f1592i.containsKey(Integer.valueOf(i2))) {
            h1.a.a(str, "updating dispatcher for existing data stream");
            cVar2 = (d1.c) this.f1592i.get(Integer.valueOf(i2));
            cVar2.f(dataType, bVar);
        } else {
            if (i2 != 0 || (i3 = this.f1590g) == 0) {
                if (i2 != 0) {
                    h1.a.a(str, "creating a new data stream for dispatcher");
                    cVar = n(i2);
                    cVar.f(dataType, bVar);
                    this.f1592i.put(Integer.valueOf(i2), cVar);
                } else {
                    cVar = null;
                }
                this.f1593j.e(new b(i2, dataType, bVar, cVar));
                return true;
            }
            cVar2 = (d1.c) this.f1592i.get(Integer.valueOf(i3));
            cVar2.h(dataType, bVar);
        }
        y(cVar2);
        return true;
    }

    public void F(int i2, int i3) {
        if (this.f1588e.containsKey(Integer.valueOf(i2))) {
            this.f1588e.put(Integer.valueOf(i2), Integer.valueOf(i3));
            h1.a.f(f1583l, "updateDeviceRssi(): device " + i2 + " with new rssi value " + i3);
        }
    }

    public void k(Context context, int i2) {
        List list = this.f1586c;
        if (list == null) {
            return;
        }
        synchronized (list) {
            d1.f fVar = new d1.f();
            fVar.f1645b = t();
            fVar.f1644a = i2;
            for (DataType dataType : s()) {
                if (p(i2, dataType)) {
                    this.f1586c.add(new DataSource.a().e(Device.a(context)).d(dataType).g(0).b(context).f(fVar.toString()).a());
                    this.f1588e.put(Integer.valueOf(i2), Integer.MIN_VALUE);
                    h1.a.f(f1583l, "DataSource for type: " + dataType + " is built. Total data source: " + this.f1586c.size());
                } else {
                    h1.a.f(f1583l, "Attempting to add duplicate data source for the same device ID.");
                }
            }
        }
    }

    public void l(Context context) {
        if (this.f1587d == null) {
            h1.a.b(f1583l, "Wildcard list is null");
            return;
        }
        d1.f fVar = new d1.f();
        fVar.f1644a = 0;
        fVar.f1645b = t();
        for (DataType dataType : s()) {
            this.f1587d.add(new DataSource.a().d(dataType).g(0).b(context).f(fVar.toString()).a());
            h1.a.a(f1583l, "DataSource for type: " + dataType + " with wildcard is built.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m(int r4, com.google.android.gms.fitness.data.DataType r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 != 0) goto L2c
            java.lang.Object r2 = r3.f1584a
            monitor-enter(r2)
            java.util.Map r4 = r3.f1585b     // Catch: java.lang.Throwable -> L29
            r4.remove(r5)     // Catch: java.lang.Throwable -> L29
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
            int r4 = r3.f1590g
            if (r4 == 0) goto L3e
            java.util.Map r2 = r3.f1592i
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            d1.c r4 = (d1.c) r4
            r4.h(r5, r1)
            boolean r5 = r4.e()
            if (r5 != 0) goto L3d
            r3.f1590g = r0
            goto L3d
        L29:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
            throw r3
        L2c:
            java.util.Map r2 = r3.f1592i
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            d1.c r4 = (d1.c) r4
            if (r4 == 0) goto L3d
            r4.f(r5, r1)
        L3d:
            r1 = r4
        L3e:
            if (r1 != 0) goto L41
            return r0
        L41:
            boolean r4 = r1.e()
            if (r4 != 0) goto L55
            java.util.Map r4 = r3.f1592i
            int r5 = r1.f1615a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.remove(r5)
            r3.D(r1)
        L55:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.a.m(int, com.google.android.gms.fitness.data.DataType):boolean");
    }

    protected abstract List o();

    public ArrayList r(DataType dataType) {
        ArrayList q2;
        if (this.f1586c.size() > 0) {
            synchronized (this.f1586c) {
                q2 = q(dataType, this.f1586c);
            }
        } else {
            synchronized (this.f1587d) {
                q2 = q(dataType, this.f1587d);
            }
        }
        return q2;
    }

    public abstract p0.c t();

    public String toString() {
        StringBuilder sb = new StringBuilder("ANTSensor, DataSources: ");
        Iterator it = this.f1586c.iterator();
        while (it.hasNext()) {
            sb.append(((DataSource) it.next()).a() + " ");
        }
        sb.append(" Supported datatypes: ");
        Iterator it2 = s().iterator();
        while (it2.hasNext()) {
            sb.append(((DataType) it2.next()) + " ");
        }
        return sb.toString();
    }

    public a.e u(d1.c cVar) {
        return new c(cVar);
    }

    public int v() {
        int i2 = 0;
        int i3 = Integer.MIN_VALUE;
        for (Map.Entry entry : this.f1588e.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i3) {
                i3 = ((Integer) entry.getValue()).intValue();
                i2 = ((Integer) entry.getKey()).intValue();
            }
        }
        if (i3 == Integer.MIN_VALUE && this.f1588e.size() > 0) {
            i2 = d1.f.a(((DataSource) this.f1586c.get(r6.size() - 1)).c()).f1644a;
            h1.a.f(f1583l, "No RSSI value available, resorting to last device found: " + i2);
        }
        h1.a.f(f1583l, "Device with the highest rssi value (-2147483648): " + i2);
        return i2;
    }

    public void w(Context context, d1.c cVar, p0.e eVar, p0.b bVar) {
        int i2;
        String str;
        D(cVar);
        switch (f.f1609b[eVar.ordinal()]) {
            case 1:
                Toast.makeText(context, "Channel Not Available", 0).show();
                i2 = -4;
                C(cVar, i2);
                return;
            case 2:
                str = "ANT Adapter Not Available. Built-in ANT hardware or external adapter required.";
                break;
            case 3:
                str = "Bad request parameters.";
                break;
            case 4:
                str = "RequestAccess failed. See logcat for details.";
                break;
            case 5:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Missing Dependency");
                builder.setMessage("The required service\n\"" + com.dsi.ant.plugins.antplus.pccbase.a.j() + "\"\n was not found. You need to install the ANT+ Plugins service or you may need to update your existing version if you already have it. Do you want to launch the Play Store to get it?");
                builder.setCancelable(true);
                builder.setPositiveButton("Go to Store", new d(context));
                builder.setNegativeButton("Cancel", new e());
                builder.create().show();
                return;
            case 6:
                return;
            case 7:
                Toast.makeText(context, "Search Timed out.", 0).show();
                i2 = -3;
                C(cVar, i2);
                return;
            case 8:
                str = "Failed: UNRECOGNIZED. PluginLib Upgrade Required?";
                break;
            default:
                str = "Unrecognized result: " + eVar;
                break;
        }
        Toast.makeText(context, str, 0).show();
    }

    public boolean x() {
        return this.f1592i.size() == 0;
    }

    public void z(d1.c cVar, DataPoint dataPoint) {
        try {
            h1.a.i(f1583l, "Publishing data point for type: " + dataPoint.c());
            z1.b b3 = cVar.b(dataPoint.c());
            if (b3 != null) {
                b3.a(dataPoint);
            }
        } catch (RemoteException e3) {
            h1.a.c(f1583l, "publishData()", e3);
        }
    }
}
