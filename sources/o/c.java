package o;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusBikePowerPcc;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import o.a;
import p.f;
import p.g;
import p.h;
import p.i;
import v.e;

/* loaded from: classes.dex */
public class c extends v.c {
    private static final String U = "c";
    private p.d A;
    private p.e B;
    private h C;
    private i D;
    private g E;
    private o.a F;
    private int G;
    private o.b H;
    private Handler I;
    private HandlerThread J;
    private w.d K;
    private boolean L;
    private int M;
    private long N;
    private short O;
    private boolean P;
    private final Runnable Q;
    private final Runnable R;
    private final Runnable S;
    private f.b T;

    /* renamed from: w */
    private w.f f2736w;

    /* renamed from: x */
    private f f2737x;

    /* renamed from: y */
    private p.b f2738y;

    /* renamed from: z */
    private p.c f2739z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.P = false;
            c.this.L = true;
            try {
                o.a aVar = c.this.F;
                Objects.requireNonNull(aVar);
                c.this.F.b(new a.b(c.this.M, c.this.G, System.currentTimeMillis()));
            } catch (NullPointerException e3) {
                h1.a.b(c.U, "Unable to update db: " + e3.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.P = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o.c$c */
    /* loaded from: classes.dex */
    public class RunnableC0045c implements Runnable {
        RunnableC0045c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.K.e();
            c.this.L = false;
        }
    }

    /* loaded from: classes.dex */
    class d implements f.b {
        d() {
        }

        @Override // p.f.b
        public void a(int i2) {
            if (c.this.P) {
                c.this.I.removeCallbacksAndMessages(c.this.Q);
                c.this.I.postDelayed(c.this.Q, 2000L);
                c.this.I.removeCallbacksAndMessages(c.this.R);
                c.this.G = i2;
                return;
            }
            if (!c.this.L) {
                if (c.this.K == null) {
                    return;
                }
                c.this.K.d(i2);
                if (c.this.K.f() && c.this.K.b(5) && (c.this.G == AntPlusBikePowerPcc.f.INVALID_CTF_CAL_REQ.b() || c.this.K.c(c.this.G, 200))) {
                    c cVar = c.this;
                    cVar.G = (int) Math.round(cVar.K.a());
                    c.this.I.post(c.this.Q);
                }
            }
            c.this.I.removeCallbacksAndMessages(c.this.S);
            c.this.I.postDelayed(c.this.S, 2000L);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class e {

        /* renamed from: a */
        static final /* synthetic */ int[] f2744a;

        static {
            int[] iArr = new int[AntPlusBikePowerPcc.c.values().length];
            f2744a = iArr;
            try {
                iArr[AntPlusBikePowerPcc.c.AUTO_CRANK_LENGTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2744a[AntPlusBikePowerPcc.c.MANUAL_CRANK_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2744a[AntPlusBikePowerPcc.c.INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel, Context context) {
        super(deviceDbDeviceInfo, antChannel);
        String str;
        StringBuilder sb;
        String str2;
        this.G = AntPlusBikePowerPcc.f.INVALID_CTF_CAL_REQ.b();
        this.J = new HandlerThread("calDb update thread");
        this.K = new w.d(5);
        this.L = false;
        this.O = (short) 0;
        this.P = false;
        this.Q = new a();
        this.R = new b();
        this.S = new RunnableC0045c();
        this.N = j1.a.a(context);
        try {
            this.M = antChannel.o().j().a();
            o.a aVar = new o.a(context);
            this.F = aVar;
            a.b a3 = aVar.a(this.M);
            if (a3 != null) {
                this.G = a3.f2708c;
            }
            this.J.start();
            this.I = new Handler(this.J.getLooper());
        } catch (RemoteException e3) {
            e = e3;
            str = U;
            sb = new StringBuilder();
            str2 = "RemoteException during initizalization: ";
            sb.append(str2);
            sb.append(e.getMessage());
            h1.a.b(str, sb.toString());
        } catch (g.a e4) {
            e = e4;
            str = U;
            sb = new StringBuilder();
            str2 = "AntCommandFailedException during initizalization: ";
            sb.append(str2);
            sb.append(e.getMessage());
            h1.a.b(str, sb.toString());
        }
    }

    public int P() {
        return this.G;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x002c. Please report as an issue. */
    @Override // v.d, v.e
    public void b(UUID uuid, Message message) {
        String str;
        String str2;
        z.a aVar;
        z.a aVar2;
        String str3;
        String str4;
        e.a aVar3 = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        Bundle data = message.getData();
        obtain.what = message.what;
        int i2 = message.what;
        if (i2 == 104) {
            int i3 = data.getInt("int_requestedCommandId");
            byte[] byteArray = data.getByteArray("arrayByte_commandData");
            if (i3 < 0 || i3 > 255) {
                obtain.arg1 = -3;
                str = U;
                str2 = "Cmd commandBurst failed to start because Command ID is outside of 0-255 range.";
            } else {
                if (byteArray != null && byteArray.length != 0 && byteArray.length % 8 == 0) {
                    obtain.arg1 = 0;
                    j(aVar3, obtain);
                    short s2 = this.O;
                    this.O = (short) (s2 + 1);
                    u(new z.a(x.a.a(i3, s2, 15, 65532, this.N, byteArray), this, null), aVar3, 218, "int_requestStatus");
                    if (this.O > 255) {
                        this.O = (short) 0;
                        return;
                    }
                    return;
                }
                obtain.arg1 = -3;
                str = U;
                str2 = "Cmd commandBurst failed to start because Command Data length must be a non-zero multiple of 8 bytes.";
            }
            h1.a.b(str, str2);
            j(aVar3, obtain);
            return;
        }
        switch (i2) {
            case 20001:
                this.I.removeCallbacksAndMessages(this.R);
                this.I.postDelayed(this.R, 10000L);
                this.P = true;
                obtain.arg1 = 0;
                j(aVar3, obtain);
                aVar = new z.a(p.a.b(), this, null);
                u(aVar, aVar3, 218, "int_requestStatus");
                return;
            case 20002:
                obtain.arg1 = 0;
                j(aVar3, obtain);
                aVar = new z.a(p.a.a(data.getBoolean("bool_autoZeroEnable")), this, null);
                u(aVar, aVar3, 218, "int_requestStatus");
                return;
            case 20003:
                BigDecimal bigDecimal = (BigDecimal) data.getSerializable("decimal_slope");
                if (bigDecimal == null) {
                    obtain.arg1 = -3;
                    h1.a.b(U, "Cmd requestSetCtfSlope failed to start because slope was null.");
                    j(aVar3, obtain);
                }
                if (bigDecimal.compareTo(new BigDecimal("50")) == 1) {
                    obtain.arg1 = -3;
                    str3 = U;
                    str4 = "Cmd requestSetCtfSlope failed to start because slope exceeded 50.0Nm/Hz.";
                } else {
                    if (bigDecimal.compareTo(new BigDecimal("10")) != -1) {
                        obtain.arg1 = 0;
                        j(aVar3, obtain);
                        aVar2 = new z.a(p.a.d(bigDecimal), this, null);
                        u(aVar2, aVar3, 218, "int_requestStatus");
                        return;
                    }
                    obtain.arg1 = -3;
                    str3 = U;
                    str4 = "Cmd requestSetCtfSlope failed to start because slope is below 10.0Nm/Hz.";
                }
                h1.a.b(str3, str4);
                j(aVar3, obtain);
                return;
            case 20004:
                byte[] byteArray2 = data.getByteArray("arrayByte_manufacturerSpecificParameters");
                if (byteArray2 != null && byteArray2.length == 6) {
                    obtain.arg1 = 0;
                    j(aVar3, obtain);
                    aVar2 = new z.a(p.a.c(byteArray2), this, null);
                    u(aVar2, aVar3, 218, "int_requestStatus");
                    return;
                }
                obtain.arg1 = -3;
                str3 = U;
                str4 = "Cmd requestCustomCalibrationParameters failed to start because the manufacturer specific parameters must be 6 bytes long.";
                h1.a.b(str3, str4);
                j(aVar3, obtain);
                return;
            case 20005:
                byte[] byteArray3 = data.getByteArray("arrayByte_manufacturerSpecificParameters");
                if (byteArray3 != null && byteArray3.length == 6) {
                    obtain.arg1 = 0;
                    j(aVar3, obtain);
                    aVar2 = new z.a(p.a.f(byteArray3), this, null);
                    u(aVar2, aVar3, 218, "int_requestStatus");
                    return;
                }
                obtain.arg1 = -3;
                str3 = U;
                str4 = "Cmd requestSetCustomCalibrationParameters failed to start because the manufacturer specific parameters must be 6 bytes long.";
                h1.a.b(str3, str4);
                j(aVar3, obtain);
                return;
            case 20006:
                obtain.arg1 = 0;
                j(aVar3, obtain);
                aVar = new z.b(2, 1, this, null);
                u(aVar, aVar3, 218, "int_requestStatus");
                return;
            case 20007:
                AntPlusBikePowerPcc.c c3 = AntPlusBikePowerPcc.c.c(data.getInt("int_crankLengthSetting"));
                BigDecimal bigDecimal2 = (BigDecimal) data.getSerializable("decimal_fullCrankLength");
                if (c3 == null) {
                    obtain.arg1 = -3;
                    str3 = U;
                    str4 = "Cmd requestSetCrankParameters failed to start because crankLengthSetting was null.";
                } else {
                    if (c3 != AntPlusBikePowerPcc.c.MANUAL_CRANK_LENGTH || bigDecimal2 != null) {
                        int i4 = e.f2744a[c3.ordinal()];
                        if (i4 == 1) {
                            obtain.arg1 = 0;
                            j(aVar3, obtain);
                            aVar = new z.a(p.a.e((byte) AntPlusBikePowerPcc.c.AUTO_CRANK_LENGTH.b()), this, null);
                        } else if (i4 != 2) {
                            if (i4 != 3) {
                                return;
                            }
                            obtain.arg1 = 0;
                            j(aVar3, obtain);
                            aVar = new z.a(p.a.e((byte) AntPlusBikePowerPcc.c.INVALID.b()), this, null);
                        } else if (bigDecimal2.compareTo(new BigDecimal("236.5")) == 1) {
                            obtain.arg1 = -3;
                            str3 = U;
                            str4 = "Cmd requestSetCrankParameters failed to start because fullCrankLength exceeded 236.5mm.";
                        } else if (bigDecimal2.compareTo(new BigDecimal("110")) == -1) {
                            obtain.arg1 = -3;
                            str3 = U;
                            str4 = "Cmd requestSetCrankParameters failed to start because fullCrankLength is below 110.0mm.";
                        } else {
                            obtain.arg1 = 0;
                            j(aVar3, obtain);
                            aVar = new z.a(p.a.e(((BigDecimal) data.getSerializable("decimal_fullCrankLength")).subtract(new BigDecimal("110")).multiply(new BigDecimal("2")).byteValue()), this, null);
                        }
                        u(aVar, aVar3, 218, "int_requestStatus");
                        return;
                    }
                    obtain.arg1 = -3;
                    str3 = U;
                    str4 = "Cmd requestSetCrankParameters failed to start because fullCrankLength was null.";
                }
                h1.a.b(str3, str4);
                j(aVar3, obtain);
                return;
            default:
                obtain.recycle();
                super.b(uuid, message);
                return;
        }
    }

    @Override // v.a, v.e
    public void d() {
        this.I.removeCallbacksAndMessages(null);
        this.I.getLooper().quit();
        this.f3444n.t(true);
        super.d();
    }

    @Override // v.c
    public List w() {
        this.T = new d();
        this.H = new o.b(this);
        this.f2736w = new w.f(255, 12000);
        this.f2737x = new f(this.T);
        this.f2738y = new p.b(this.f2736w, this.H);
        this.f2739z = new p.c(this.H);
        this.A = new p.d(this.H);
        this.B = new p.e(this.f2736w);
        this.C = new h(this.H);
        this.D = new i();
        this.E = new g();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2737x);
        arrayList.add(this.f2738y);
        arrayList.add(this.f2739z);
        arrayList.add(this.A);
        arrayList.add(this.B);
        arrayList.add(this.C);
        arrayList.add(this.D);
        arrayList.add(this.E);
        arrayList.addAll(v());
        return arrayList;
    }
}
