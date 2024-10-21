package b1;

import a1.e;
import android.os.Bundle;
import android.os.RemoteException;
import com.dsi.ant.plugins.antplus.pcc.AntPlusWeightScalePcc;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import k.l;
import v.e;

/* loaded from: classes.dex */
public class a extends u0.b {
    private static final String P = "a";
    AntPlusWeightScalePcc.UserProfile A;
    private boolean L;
    private boolean O;

    /* renamed from: q */
    z0.a f210q;

    /* renamed from: r */
    CountDownLatch f211r;

    /* renamed from: s */
    private boolean f212s = false;

    /* renamed from: t */
    AntPlusWeightScalePcc.AdvancedMeasurement f213t = new AntPlusWeightScalePcc.AdvancedMeasurement();

    /* renamed from: u */
    u.a f214u = new u.a(202);

    /* renamed from: v */
    a1.b f215v = new a1.b();

    /* renamed from: w */
    a1.c f216w = new a1.c();

    /* renamed from: x */
    a1.d f217x = new a1.d();

    /* renamed from: y */
    e f218y = new e();

    /* renamed from: z */
    e f219z = new e();
    int B = 65535;
    boolean C = false;
    boolean D = false;
    boolean E = false;
    boolean F = false;
    private boolean G = false;
    boolean H = false;
    boolean I = false;
    boolean J = false;
    boolean K = false;
    private int M = 1;
    byte[] N = new byte[8];

    /* renamed from: b1.a$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0004a {

        /* renamed from: a */
        static final /* synthetic */ int[] f220a;

        /* renamed from: b */
        static final /* synthetic */ int[] f221b;

        static {
            int[] iArr = new int[l.values().length];
            f221b = iArr;
            try {
                iArr[l.CHANNEL_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f221b[l.BROADCAST_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f221b[l.ACKNOWLEDGED_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.e.values().length];
            f220a = iArr2;
            try {
                iArr2[j.e.RX_SEARCH_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f220a[j.e.CHANNEL_CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f220a[j.e.TRANSFER_TX_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f220a[j.e.TRANSFER_TX_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(z0.a aVar, e.a aVar2, AntPlusWeightScalePcc.UserProfile userProfile) {
        this.f210q = aVar;
        this.A = userProfile;
        this.f214u.c(aVar2.f3454c, aVar2.f3455d);
    }

    public void B() {
        boolean z2;
        try {
            z2 = this.f210q.f3444n.u(this, 1000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            z2 = false;
        }
        if (z2) {
            this.f210q.k(300);
        } else {
            C(AntPlusWeightScalePcc.d.FAIL_ALREADY_BUSY_EXTERNAL);
        }
    }

    public void C(AntPlusWeightScalePcc.d dVar) {
        synchronized (this.f214u) {
            if (this.f212s) {
                return;
            }
            int b3 = dVar.b();
            Bundle bundle = new Bundle();
            bundle.putInt("int_statusCode", b3);
            if (dVar == AntPlusWeightScalePcc.d.SUCCESS) {
                bundle.putParcelable("parcelable_AdvancedMeasurement", this.f213t);
            }
            this.f214u.a(bundle);
            this.f212s = true;
        }
    }

    @Override // u0.b
    public void d() {
        AntPlusWeightScalePcc.d dVar;
        try {
            try {
            } catch (InterruptedException unused) {
                h1.a.b(P, "Interrupted waiting for result");
                Thread.currentThread().interrupt();
            }
            if (this.f3396a.p().l() != j.c.TRACKING) {
                h1.a.b(P, "Failed: Channel not tracking");
                C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
                return;
            }
            AntPlusWeightScalePcc.AdvancedMeasurement advancedMeasurement = this.f213t;
            advancedMeasurement.f760b = null;
            advancedMeasurement.f762d = null;
            advancedMeasurement.f761c = null;
            advancedMeasurement.f764f = null;
            advancedMeasurement.f763e = null;
            advancedMeasurement.f766h = null;
            advancedMeasurement.f765g = null;
            this.f210q.f3616w.l();
            this.f211r = new CountDownLatch(1);
            f();
            this.f211r.await(60L, TimeUnit.SECONDS);
            if (!this.E) {
                h1.a.b(P, "Timed out receiving capabilities");
                C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
                return;
            }
            if (this.C) {
                this.f211r = this.A == null ? new CountDownLatch(1) : new CountDownLatch(4);
                this.f218y.f(this.A);
                this.f218y.b(true);
                this.f218y.c(false);
                this.f218y.d(true);
                this.f218y.e(this.D);
                this.f218y.a(this.N);
                try {
                    this.f3396a.D(this.N);
                } catch (g.a unused2) {
                }
            } else {
                h1.a.a(P, "Scale does not support user profile exchange");
                this.F = true;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f211r = countDownLatch;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            countDownLatch.await(60L, timeUnit);
            c();
            if (this.H && this.C && this.A != null) {
                this.f211r = new CountDownLatch(3);
                f();
                this.f211r.await(5L, timeUnit);
                c();
            }
            AntPlusWeightScalePcc.AdvancedMeasurement advancedMeasurement2 = this.f213t;
            if (advancedMeasurement2.f760b == null) {
                if (this.O) {
                    h1.a.b(P, "Timed out waiting for measurement, weight value never stabilized");
                    dVar = AntPlusWeightScalePcc.d.FAIL_WEIGHT_VALUE_NOT_STABILIZED;
                } else {
                    h1.a.b(P, "Timed out waiting for measurement");
                    dVar = AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE;
                }
                C(dVar);
                return;
            }
            if (advancedMeasurement2.f762d == null) {
                advancedMeasurement2.f762d = a1.b.f78d;
            }
            if (advancedMeasurement2.f761c == null) {
                advancedMeasurement2.f761c = a1.b.f78d;
            }
            if (advancedMeasurement2.f765g == null) {
                advancedMeasurement2.f765g = a1.c.f83d;
            }
            if (advancedMeasurement2.f766h == null) {
                advancedMeasurement2.f766h = a1.c.f83d;
            }
            if (advancedMeasurement2.f763e == null) {
                advancedMeasurement2.f763e = a1.d.f88d;
            }
            if (advancedMeasurement2.f764f == null) {
                advancedMeasurement2.f764f = a1.d.f88d;
            }
            C(this.L ? AntPlusWeightScalePcc.d.FAIL_PROFILE_MISMATCH : AntPlusWeightScalePcc.d.SUCCESS);
            this.f211r = new CountDownLatch(1);
            this.G = true;
            f();
            try {
                this.f211r.await(60L, TimeUnit.SECONDS);
            } catch (InterruptedException unused3) {
                h1.a.b(P, "Interrupted waiting for result");
                Thread.currentThread().interrupt();
            }
        } catch (g.a e3) {
            h1.a.b(P, "AntCommandFailedException in dowork(): " + e3.toString());
            C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
            throw new RemoteException();
        }
    }

    @Override // u0.b
    public String k() {
        return "Advanced Measurement Request";
    }

    @Override // u0.b
    public void o() {
        C(AntPlusWeightScalePcc.d.FAIL_DEVICE_COMMUNICATION_FAILURE);
    }

    @Override // u0.b
    public void s() {
        this.L = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x027e A[Catch: a -> 0x02e6, TryCatch #0 {a -> 0x02e6, blocks: (B:2:0x0000, B:9:0x0015, B:11:0x0019, B:13:0x0025, B:16:0x0053, B:18:0x0057, B:20:0x005b, B:22:0x0064, B:24:0x0071, B:26:0x0074, B:29:0x0083, B:32:0x0093, B:34:0x00af, B:37:0x00c3, B:41:0x00d7, B:43:0x00df, B:48:0x00f1, B:50:0x010f, B:52:0x011b, B:54:0x012d, B:55:0x0131, B:56:0x027a, B:58:0x027e, B:60:0x0282, B:62:0x0289, B:69:0x013a, B:71:0x013e, B:73:0x0142, B:75:0x0155, B:77:0x015f, B:78:0x0169, B:80:0x0171, B:81:0x017b, B:83:0x0181, B:85:0x0185, B:87:0x0189, B:88:0x018e, B:90:0x0194, B:92:0x01a0, B:94:0x01a4, B:96:0x01a8, B:98:0x01bb, B:100:0x01c5, B:101:0x01cf, B:103:0x01d7, B:104:0x01e1, B:106:0x01e7, B:108:0x01eb, B:110:0x01ef, B:111:0x01f5, B:113:0x01fb, B:115:0x0208, B:117:0x020c, B:119:0x0210, B:121:0x0223, B:123:0x022d, B:124:0x0237, B:126:0x023f, B:127:0x0249, B:129:0x024f, B:131:0x0253, B:133:0x0257, B:134:0x025d, B:136:0x0263, B:139:0x0272, B:141:0x0276, B:142:0x0298, B:149:0x02b2, B:151:0x02bb, B:153:0x02ce, B:155:0x02de), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // u0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void u(k.l r12, com.dsi.ant.message.ipc.AntMessageParcel r13) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.a.u(k.l, com.dsi.ant.message.ipc.AntMessageParcel):void");
    }
}
