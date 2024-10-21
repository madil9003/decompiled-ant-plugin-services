package v;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.util.SparseArray;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: g */
    private static final String f3445g = "e";

    /* renamed from: a */
    public final ArrayList f3446a = new ArrayList();

    /* renamed from: b */
    public HashMap f3447b = new HashMap();

    /* renamed from: c */
    private SparseArray f3448c = new SparseArray();

    /* renamed from: d */
    public boolean f3449d = true;

    /* renamed from: e */
    private int f3450e;

    /* renamed from: f */
    public AntPluginDeviceDbProvider.DeviceDbDeviceInfo f3451f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public String f3452a;

        /* renamed from: b */
        public String f3453b;

        /* renamed from: c */
        public UUID f3454c;

        /* renamed from: d */
        public v0.a f3455d;

        /* renamed from: e */
        public int f3456e;

        /* renamed from: f */
        public int f3457f;
    }

    public e(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, int i2) {
        this.f3451f = deviceDbDeviceInfo;
        this.f3450e = i2;
        for (u.a aVar : f()) {
            ArrayList arrayList = (ArrayList) this.f3448c.get(aVar.f3372a.intValue());
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f3448c.put(aVar.f3372a.intValue(), arrayList);
            }
            arrayList.add(aVar);
        }
    }

    private boolean m(int i2, a aVar, Message message) {
        ArrayList arrayList = (ArrayList) this.f3448c.get(i2);
        if (arrayList == null) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((u.a) it.next()).d(aVar.f3454c)) {
                h1.a.j(f3445g, "App requesting to unsubscribe without being subscribed. Event ID: " + i2);
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:            if (m(r6.arg1, r5, r6) != false) goto L22;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:            r0.arg1 = -3;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:            if (l(r6.arg1, r5, r6) != false) goto L22;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.UUID r5, android.os.Message r6) {
        /*
            r4 = this;
            java.util.HashMap r0 = r4.f3447b
            java.lang.Object r5 = r0.get(r5)
            v.e$a r5 = (v.e.a) r5
            android.os.Message r0 = android.os.Message.obtain()
            int r1 = r6.what
            r0.what = r1
            int r1 = r6.what
            r2 = -3
            r3 = 0
            switch(r1) {
                case 10000: goto L47;
                case 10001: goto L3b;
                case 10002: goto L35;
                default: goto L17;
            }
        L17:
            java.lang.String r1 = v.e.f3445g
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Received unhandled command from PCC: "
            r2.append(r3)
            int r6 = r6.what
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            h1.a.b(r1, r6)
            r6 = -99999999(0xfffffffffa0a1f01, float:-1.7929145E35)
            r0.arg1 = r6
            goto L50
        L35:
            r4.i(r5, r6)
        L38:
            r0.arg1 = r3
            goto L50
        L3b:
            int r1 = r6.arg1
            boolean r6 = r4.m(r1, r5, r6)
            if (r6 == 0) goto L44
        L43:
            goto L38
        L44:
            r0.arg1 = r2
            goto L50
        L47:
            int r1 = r6.arg1
            boolean r6 = r4.l(r1, r5, r6)
            if (r6 == 0) goto L44
            goto L43
        L50:
            r4.j(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.b(java.util.UUID, android.os.Message):void");
    }

    public boolean c(a aVar, v0.a aVar2, Bundle bundle) {
        synchronized (this.f3446a) {
            this.f3446a.add(aVar);
            if (this.f3447b.put(aVar.f3454c, aVar) != null) {
                h1.a.b(f3445g, "Client '" + aVar.f3452a + "' somehow double subscribed to " + this.f3451f.f1177e);
            }
        }
        return true;
    }

    public void d() {
        k(-100);
        this.f3449d = false;
    }

    public int e() {
        return this.f3450e;
    }

    public abstract Set f();

    public boolean g(String str, Bundle bundle) {
        synchronized (this.f3446a) {
            Iterator it = this.f3446a.iterator();
            while (it.hasNext()) {
                if (((a) it.next()).f3452a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean h() {
        return !this.f3449d;
    }

    public void i(a aVar, Message message) {
        for (int i2 = 0; i2 < this.f3448c.size(); i2++) {
            Iterator it = ((ArrayList) this.f3448c.valueAt(i2)).iterator();
            while (it.hasNext()) {
                ((u.a) it.next()).d(aVar.f3454c);
            }
        }
        synchronized (this.f3446a) {
            if (!this.f3446a.remove(aVar)) {
                h1.a.b(f3445g, "Client '" + aVar.f3452a + "' somehow requesting remove without being on list of " + this.f3451f.f1177e);
            }
            this.f3447b.remove(aVar.f3454c);
        }
        if (this.f3446a.size() == 0) {
            d();
        }
    }

    public boolean j(a aVar, Message message) {
        try {
            aVar.f3455d.b(message);
            return true;
        } catch (RemoteException unused) {
            h1.a.b(f3445g, "Remote Exception sending client message: " + message.what);
            return false;
        }
    }

    public void k(int i2) {
        synchronized (this.f3446a) {
            if (i2 == this.f3450e) {
                h1.a.a(f3445g, "Ignoring plugin attempt to set current state to existing state: " + i2);
                return;
            }
            this.f3450e = i2;
            Iterator it = this.f3446a.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.arg1 = i2;
                j(aVar, obtain);
            }
        }
    }

    public boolean l(int i2, a aVar, Message message) {
        ArrayList arrayList = (ArrayList) this.f3448c.get(i2);
        if (arrayList == null) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((u.a) it.next()).c(aVar.f3454c, aVar.f3455d)) {
                h1.a.j(f3445g, "App attempting to subscribe to event twice. Event ID: " + i2);
            }
        }
        return true;
    }
}
