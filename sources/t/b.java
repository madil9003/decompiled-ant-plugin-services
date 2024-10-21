package t;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import com.dsi.ant.plugins.antplus.pcc.AntPlusBloodPressurePcc;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.DataFormatException;
import k1.e1;
import k1.i;
import k1.j;
import k1.t1;
import k1.x;
import s0.a;
import s0.g;
import v.e;

/* loaded from: classes.dex */
public class b {

    /* renamed from: l */
    private static final String f3291l = "b";

    /* renamed from: a */
    Object f3292a = new Object();

    /* renamed from: b */
    ArrayList f3293b = new ArrayList();

    /* renamed from: c */
    LinkedList f3294c = new LinkedList();

    /* renamed from: d */
    boolean f3295d = false;

    /* renamed from: e */
    final u0.a f3296e;

    /* renamed from: f */
    final t.c f3297f;

    /* renamed from: g */
    final long f3298g;

    /* renamed from: h */
    final int f3299h;

    /* renamed from: i */
    final int f3300i;

    /* renamed from: j */
    final int f3301j;

    /* renamed from: k */
    final int f3302k;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3303a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3304b;

        static {
            int[] iArr = new int[g.l.values().length];
            f3304b = iArr;
            try {
                iArr[g.l.FAIL_NOT_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3304b[g.l.FAIL_AUTHENTICATION_REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3304b[g.l.FAIL_DEVICE_TRANSMISSION_LOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[g.k.values().length];
            f3303a = iArr2;
            try {
                iArr2[g.k.AUTH_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3303a[g.k.AUTH_WAITING_FOR_PAIRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3303a[g.k.NOT_CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: t.b$b */
    /* loaded from: classes.dex */
    public static class C0054b {

        /* renamed from: a */
        public e.a f3305a;

        /* renamed from: b */
        public boolean f3306b;

        /* renamed from: c */
        public boolean f3307c;

        /* renamed from: d */
        public boolean f3308d;

        /* renamed from: e */
        t.a f3309e;

        /* renamed from: f */
        Object f3310f = new Object();

        /* renamed from: g */
        public boolean f3311g = false;

        /* renamed from: h */
        public boolean f3312h = false;

        /* renamed from: i */
        public long f3313i;

        /* renamed from: j */
        public long f3314j;

        /* renamed from: k */
        public boolean f3315k;

        /* renamed from: l */
        public boolean f3316l;

        /* renamed from: m */
        public long f3317m;

        public C0054b(e.a aVar, boolean z2, boolean z3, boolean z4, t.a aVar2) {
            this.f3305a = aVar;
            this.f3306b = z2;
            this.f3307c = z3;
            this.f3308d = z4;
            this.f3309e = aVar2;
        }

        private void d(AntPlusBloodPressurePcc.a aVar, int i2) {
            synchronized (this.f3310f) {
                if (this.f3311g) {
                    h1.a.a(b.f3291l, "Download Measurement status message sent after finished sent: " + aVar.toString() + "-" + i2);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("int_statusCode", aVar.b());
                    bundle.putInt("int_finishedCode", i2);
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = 204;
                    obtain.setData(bundle);
                    this.f3309e.j(this.f3305a, obtain);
                    if (aVar == AntPlusBloodPressurePcc.a.FINISHED) {
                        this.f3311g = true;
                    }
                }
            }
        }

        public void a(int i2, long j2, long j3) {
            synchronized (this.f3310f) {
                if (this.f3311g) {
                    h1.a.a(b.f3291l, "Download Measurement ANTFS state message sent after finished sent: " + i2);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("int_stateCode", i2);
                    bundle.putLong("long_transferredBytes", j2);
                    bundle.putLong("long_totalBytes", j3);
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = 190;
                    obtain.setData(bundle);
                    this.f3309e.j(this.f3305a, obtain);
                }
            }
        }

        public void b(int i2) {
            d(AntPlusBloodPressurePcc.a.FINISHED, i2);
        }

        public boolean c(AntPlusBloodPressurePcc.BloodPressureMeasurement bloodPressureMeasurement) {
            synchronized (this.f3310f) {
                if (this.f3311g) {
                    h1.a.a(b.f3291l, "Download Measurement measurement sent after finished sent: " + bloodPressureMeasurement.f596b.toString());
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("parcelable_measurement", bloodPressureMeasurement);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.arg1 = 205;
                obtain.setData(bundle);
                return this.f3309e.j(this.f3305a, obtain);
            }
        }

        public void e(AntPlusBloodPressurePcc.a aVar) {
            d(aVar, 0);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a */
        g f3318a;

        /* renamed from: b */
        boolean f3319b = false;

        /* renamed from: c */
        ArrayList f3320c = new ArrayList();

        /* renamed from: d */
        g.m f3321d = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements g.m {
            a() {
            }

            @Override // s0.g.m
            public void a(g.k kVar, g.j jVar) {
                int i2 = a.f3303a[kVar.ordinal()];
                if (i2 == 1) {
                    c.this.d(500, 0L, 0L);
                } else if (i2 == 2) {
                    c.this.d(550, 0L, 0L);
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    c.this.f3319b = false;
                }
            }
        }

        /* renamed from: t.b$c$b */
        /* loaded from: classes.dex */
        public class C0055b implements g.n {
            C0055b() {
            }

            @Override // s0.g.n
            public void a(long j2, long j3) {
            }
        }

        /* renamed from: t.b$c$c */
        /* loaded from: classes.dex */
        public class C0056c implements g.n {

            /* renamed from: a */
            final /* synthetic */ long f3325a;

            /* renamed from: b */
            final /* synthetic */ long f3326b;

            C0056c(long j2, long j3) {
                this.f3325a = j2;
                this.f3326b = j3;
            }

            @Override // s0.g.n
            public void a(long j2, long j3) {
                Iterator it = c.this.f3320c.iterator();
                while (it.hasNext()) {
                    c.this.d(850, this.f3325a + j2, this.f3326b);
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements Comparator {
            d() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(i iVar, i iVar2) {
                return iVar.e().e().compareTo(iVar2.e().e());
            }
        }

        /* loaded from: classes.dex */
        public class e implements j {

            /* renamed from: a */
            final /* synthetic */ ArrayList f3329a;

            e(ArrayList arrayList) {
                this.f3329a = arrayList;
            }

            @Override // k1.j
            public void a(i iVar) {
                this.f3329a.add(iVar);
            }
        }

        c() {
        }

        private boolean a(g.i iVar) {
            if (iVar == g.i.SUCCESS) {
                return false;
            }
            h1.a.b(b.f3291l, "ANTFS download request failed, code: " + iVar);
            b.this.d(-40);
            return true;
        }

        private boolean b(g.l lVar) {
            if (lVar == g.l.SUCCESS) {
                return false;
            }
            h1.a.b(b.f3291l, "ANTFS request failed, code: " + lVar);
            int i2 = a.f3304b[lVar.ordinal()];
            b.this.d(i2 != 1 ? i2 != 2 ? i2 != 3 ? -40 : -41 : -1040 : -61);
            return true;
        }

        private void c() {
            int i2;
            long j2;
            s0.a aVar;
            long j3;
            long j4;
            boolean z2;
            long j5 = Long.MAX_VALUE;
            long j6 = 0;
            long j7 = 0;
            loop0: while (true) {
                synchronized (b.this.f3293b) {
                    if (!b.this.f3294c.isEmpty()) {
                        b.this.f3297f.b();
                        Iterator it = b.this.f3294c.iterator();
                        while (it.hasNext()) {
                            C0054b c0054b = (C0054b) it.next();
                            c0054b.f3317m = b.this.f3297f.g();
                            c0054b.e(AntPlusBloodPressurePcc.a.PROGRESS_SYNCING_WITH_DEVICE);
                            b.this.f3293b.add(c0054b);
                            if (c0054b.f3306b) {
                                c0054b.f3313i = b.this.f3297f.h(c0054b.f3305a.f3452a, c0054b.f3317m);
                                c0054b.f3314j = b.this.f3297f.i(c0054b.f3305a.f3452a, c0054b.f3317m);
                            } else {
                                c0054b.f3313i = j6;
                                c0054b.f3314j = j6;
                            }
                            long j8 = c0054b.f3313i;
                            if (j8 < j5) {
                                j7 = j6;
                                j5 = j8;
                            }
                        }
                        b.this.f3297f.close();
                        b.this.f3294c.clear();
                    } else if (b.this.f3293b.isEmpty()) {
                        return;
                    }
                    long j9 = j5;
                    long j10 = j7;
                    if (!this.f3319b) {
                        d(100, 0L, 0L);
                        if (b(this.f3318a.R(b.this.f3297f))) {
                            return;
                        }
                        d(800, 0L, 0L);
                        this.f3319b = true;
                    }
                    if (a(this.f3318a.S(0, new C0055b()))) {
                        return;
                    }
                    try {
                        s0.a aVar2 = new s0.a(this.f3318a.M(), this.f3318a.O());
                        if (aVar2.f3075a.f3083f > j10) {
                            ArrayList arrayList = new ArrayList();
                            long j11 = j6;
                            long j12 = j11;
                            for (int i3 = 0; i3 < aVar2.f3076b.size(); i3++) {
                                a.b bVar = (a.b) aVar2.f3076b.valueAt(i3);
                                long j13 = bVar.f3090g;
                                if (j13 > j11) {
                                    j11 = j13;
                                }
                                if (bVar.f3085b == FitFileCommon.a.FIT_DATA_TYPE.b() && bVar.f3088e.contains(a.c.READ) && bVar.f3090g > j9) {
                                    synchronized (b.this.f3293b) {
                                        Iterator it2 = b.this.f3293b.iterator();
                                        while (it2.hasNext()) {
                                            C0054b c0054b2 = (C0054b) it2.next();
                                            if (c0054b2.f3313i < bVar.f3090g) {
                                                if (!this.f3320c.contains(c0054b2)) {
                                                    this.f3320c.add(c0054b2);
                                                }
                                                c0054b2.f3315k = true;
                                            }
                                        }
                                    }
                                    arrayList.add(bVar);
                                    j12 += bVar.f3089f;
                                }
                            }
                            if (arrayList.isEmpty()) {
                                aVar = aVar2;
                                j3 = j11;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it3 = arrayList.iterator();
                                long j14 = 0;
                                while (true) {
                                    if (!it3.hasNext()) {
                                        aVar = aVar2;
                                        j3 = j11;
                                        z2 = false;
                                        break;
                                    }
                                    a.b bVar2 = (a.b) it3.next();
                                    aVar = aVar2;
                                    Iterator it4 = it3;
                                    j3 = j11;
                                    i2 = -40;
                                    if (a(this.f3318a.S(bVar2.f3084a, new C0056c(j14, j12)))) {
                                        z2 = true;
                                        break;
                                    }
                                    byte[] M = this.f3318a.M();
                                    j14 += bVar2.f3089f;
                                    if (!e(M, arrayList2)) {
                                        break loop0;
                                    }
                                    it3 = it4;
                                    aVar2 = aVar;
                                    j11 = j3;
                                }
                                if (z2) {
                                    return;
                                }
                                Collections.sort(arrayList2, new d());
                                synchronized (b.this.f3293b) {
                                    Iterator it5 = arrayList2.iterator();
                                    while (it5.hasNext()) {
                                        i iVar = (i) it5.next();
                                        long longValue = iVar.e().e().longValue();
                                        Iterator it6 = this.f3320c.iterator();
                                        AntPlusBloodPressurePcc.BloodPressureMeasurement bloodPressureMeasurement = null;
                                        while (it6.hasNext()) {
                                            C0054b c0054b3 = (C0054b) it6.next();
                                            if (!c0054b3.f3311g && c0054b3.f3314j < longValue) {
                                                if (bloodPressureMeasurement == null) {
                                                    bloodPressureMeasurement = new AntPlusBloodPressurePcc.BloodPressureMeasurement(iVar);
                                                }
                                                if (c0054b3.c(bloodPressureMeasurement)) {
                                                    c0054b3.f3316l = true;
                                                    c0054b3.f3314j = longValue;
                                                    b.this.f3297f.b();
                                                    b.this.f3297f.k(c0054b3.f3305a.f3452a, c0054b3.f3317m, longValue);
                                                    b.this.f3297f.close();
                                                } else {
                                                    h1.a.a(b.f3291l, "Sending measurement failed, removing watcher");
                                                    c0054b3.f3311g = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            synchronized (b.this.f3293b) {
                                b.this.f3297f.b();
                                Iterator it7 = b.this.f3293b.iterator();
                                while (it7.hasNext()) {
                                    C0054b c0054b4 = (C0054b) it7.next();
                                    if (c0054b4.f3313i != j3) {
                                        j4 = j3;
                                        c0054b4.f3313i = j4;
                                        b.this.f3297f.j(c0054b4.f3305a.f3452a, c0054b4.f3317m, j4);
                                    } else {
                                        j4 = j3;
                                    }
                                    j3 = j4;
                                }
                                j2 = j3;
                                b.this.f3297f.close();
                            }
                            j10 = aVar.f3075a.f3083f;
                        } else {
                            j2 = j9;
                        }
                        synchronized (b.this.f3293b) {
                            this.f3320c.clear();
                            Iterator it8 = b.this.f3293b.iterator();
                            while (it8.hasNext()) {
                                C0054b c0054b5 = (C0054b) it8.next();
                                if (!c0054b5.f3311g) {
                                    if (c0054b5.f3307c) {
                                        if (c0054b5.f3315k) {
                                            d(800, 0L, 0L);
                                        }
                                        if (!c0054b5.f3312h) {
                                            c0054b5.f3312h = true;
                                            c0054b5.e(AntPlusBloodPressurePcc.a.PROGRESS_MONITORING);
                                        }
                                        c0054b5.f3315k = false;
                                        c0054b5.f3316l = false;
                                    } else {
                                        c0054b5.b(0);
                                    }
                                }
                                it8.remove();
                            }
                        }
                        Thread.sleep(2000L);
                        j5 = j2;
                        j7 = j10;
                        j6 = 0;
                    } catch (DataFormatException e3) {
                        i2 = -40;
                        h1.a.b(b.f3291l, "ANTFS directory DataFormatException: " + e3.getMessage());
                    }
                }
            }
            b.this.d(i2);
        }

        private boolean e(byte[] bArr, ArrayList arrayList) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            if (!new x().d(byteArrayInputStream)) {
                h1.a.b(b.f3291l, "FIT file integrity check failed.");
                return false;
            }
            try {
                byteArrayInputStream.reset();
            } catch (IOException unused) {
            }
            e eVar = new e(arrayList);
            t1 t1Var = new t1();
            t1Var.c(eVar);
            try {
                t1Var.d(byteArrayInputStream);
                return true;
            } catch (e1 e3) {
                h1.a.b(b.f3291l, "Error decoding FIT file: " + e3.toString());
                return false;
            }
        }

        protected void d(int i2, long j2, long j3) {
            Iterator it = (!this.f3319b ? b.this.f3293b : this.f3320c).iterator();
            while (it.hasNext()) {
                ((C0054b) it.next()).a(i2, j2, j3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this.f3292a) {
                g.m mVar = this.f3321d;
                b bVar = b.this;
                g gVar = new g(mVar, bVar.f3298g, bVar.f3299h);
                this.f3318a = gVar;
                b bVar2 = b.this;
                gVar.Z(bVar2.f3300i, bVar2.f3301j, bVar2.f3302k);
                try {
                    if (!b.this.f3296e.u(this.f3318a, 1000)) {
                        b.this.d(-20);
                        return;
                    }
                    try {
                        c();
                    } finally {
                        b.this.f3295d = false;
                        if (this.f3318a.Q() != g.l.SUCCESS) {
                            h1.a.j(b.f3291l, "DownloadMeasurements Failed to close ANTFS session.");
                        }
                    }
                } catch (InterruptedException unused) {
                    h1.a.b(b.f3291l, "ANTFS request InterruptedException");
                    b.this.d(-40);
                }
            }
        }
    }

    public b(u0.a aVar, t.c cVar, long j2, int i2, int i3, int i4, int i5) {
        this.f3296e = aVar;
        this.f3297f = cVar;
        this.f3298g = j2;
        this.f3299h = i2;
        this.f3300i = i3;
        this.f3301j = i4;
        this.f3302k = i5;
    }

    public void b(C0054b c0054b) {
        synchronized (this.f3293b) {
            this.f3294c.add(c0054b);
            if (!this.f3295d) {
                this.f3295d = true;
                new Thread(new c()).start();
            }
        }
    }

    public void c() {
        synchronized (this.f3293b) {
            Log.d(f3291l, "Entering DestroyMonitor()");
            this.f3294c.clear();
            d(-10);
        }
    }

    public void d(int i2) {
        synchronized (this.f3293b) {
            Iterator it = this.f3293b.iterator();
            while (it.hasNext()) {
                ((C0054b) it.next()).b(i2);
            }
        }
    }

    public boolean e(e.a aVar) {
        synchronized (this.f3293b) {
            Iterator it = this.f3294c.iterator();
            while (it.hasNext()) {
                C0054b c0054b = (C0054b) it.next();
                if (c0054b.f3305a.equals(aVar)) {
                    c0054b.b(-2);
                    it.remove();
                    return true;
                }
            }
            Iterator it2 = this.f3293b.iterator();
            while (it2.hasNext()) {
                C0054b c0054b2 = (C0054b) it2.next();
                if (c0054b2.f3305a.equals(aVar)) {
                    c0054b2.b(-2);
                    c0054b2.f3311g = true;
                    return true;
                }
            }
            return false;
        }
    }
}
