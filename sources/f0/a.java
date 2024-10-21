package f0;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.common.FitFileCommon;
import com.dsi.ant.plugins.antplus.pcc.AntPlusFitnessEquipmentPcc;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import g0.d;
import g0.e;
import g0.f;
import g0.g;
import g0.h;
import g0.i;
import g0.j;
import g0.k;
import g0.l;
import g0.m;
import g0.n;
import g0.o;
import g0.p;
import g0.q;
import g0.r;
import g0.s;
import g0.t;
import g0.u;
import g0.v;
import h0.a;
import java.math.BigDecimal;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import u0.a;
import v.e;

/* loaded from: classes.dex */
public class a extends v.c {
    private static final String X = "a";
    private e A;
    private f B;
    private h C;
    private i D;
    private j E;
    private k F;
    private l G;
    private g H;
    private o I;
    private m J;
    private n K;
    private p L;
    private q M;
    private r N;
    private s O;
    private t P;
    private u Q;
    private v R;
    private o.b S;
    private int T;
    private boolean U;
    private Object V;
    private boolean W;

    /* renamed from: w */
    private u0.a f1695w;

    /* renamed from: x */
    private g0.a f1696x;

    /* renamed from: y */
    private g0.c f1697y;

    /* renamed from: z */
    private d f1698z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f0.a$a */
    /* loaded from: classes.dex */
    public class C0033a implements a.c {
        C0033a() {
        }

        @Override // u0.a.c
        public void a() {
            h1.a.b(a.X, "ANTFS Executor died");
            a.this.f1695w = null;
            a.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.b {
        b() {
        }

        @Override // h0.a.b
        public void a(a.c cVar) {
            if (c.f1701a[cVar.ordinal()] != 1) {
                return;
            }
            a.this.E();
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f1701a;

        static {
            int[] iArr = new int[a.c.values().length];
            f1701a = iArr;
            try {
                iArr[a.c.TRANSPORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel) {
        super(deviceDbDeviceInfo, antChannel);
        this.V = new Object();
        this.W = false;
        this.U = true;
    }

    public void E() {
        try {
            this.f3424h.c(j.d.BIDIRECTIONAL_SLAVE);
            this.f3424h.z(57);
            this.f3424h.x(8192);
            this.f3424h.u(new j.b(this.T, p0.c.FITNESS_EQUIPMENT.b(), 0));
            this.f3424h.A(j.i.TWENTY_FIVE_SECONDS);
            this.f3424h.l();
            this.U = true;
            k(2);
        } catch (RemoteException unused) {
            h1.a.b(X, "RemoteException trying to configure and open receiver channel");
            s();
        } catch (g.a e3) {
            h1.a.b(X, "ACFE trying to configure and open receiver channel: " + e3.toString());
            this.f3424h.m();
        }
    }

    @Override // v.c, v.a, z.a.b
    public void a(k.l lVar, AntMessageParcel antMessageParcel) {
        if (lVar == k.l.CHANNEL_EVENT) {
            j.e j2 = new k.g(antMessageParcel).j();
            if (j2 == j.e.RX_SEARCH_TIMEOUT) {
                h1.a.b(X, "Broadcast reception search timed out");
            } else if (j2 == j.e.CHANNEL_CLOSED && this.U) {
                h1.a.b(X, "Channel closed.");
                s();
                return;
            }
        }
        super.a(lVar, antMessageParcel);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0039. Please report as an issue. */
    @Override // v.d, v.e
    public void b(UUID uuid, Message message) {
        int i2;
        z.b bVar;
        z.a aVar;
        String str;
        String str2;
        int i3;
        z.a bVar2;
        String str3;
        String str4;
        e.a aVar2 = (e.a) this.f3447b.get(uuid);
        Message obtain = Message.obtain();
        Bundle data = message.getData();
        obtain.what = message.what;
        int i4 = message.what;
        if (i4 != 105) {
            switch (i4) {
                case 20001:
                    i2 = 228;
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar = new z.b(AntPlusFitnessEquipmentPcc.CommandStatus.b.BASIC_RESISTANCE.b(), this, null);
                    break;
                case 20002:
                    BigDecimal bigDecimal = (BigDecimal) data.getSerializable("decimal_totalResistance");
                    if (bigDecimal == null) {
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetBasicResistance failed to start because total resistance was null";
                    } else if (bigDecimal.compareTo(new BigDecimal("0")) == -1) {
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetBasicResistance failed to start because total resistance was under 0%";
                    } else {
                        if (bigDecimal.compareTo(new BigDecimal("100")) != 1) {
                            obtain.arg1 = 0;
                            aVar = new z.a(g0.b.b(bigDecimal), this, null);
                            u(aVar, aVar2, 228, "int_requestStatus");
                            j(aVar2, obtain);
                            return;
                        }
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetBasicResistance failed to start because total resistance exceeded 100%";
                    }
                    h1.a.b(str, str2);
                    j(aVar2, obtain);
                    return;
                case 20003:
                    i2 = 228;
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar = new z.b(AntPlusFitnessEquipmentPcc.CommandStatus.b.TARGET_POWER.b(), this, null);
                    break;
                case 20004:
                    BigDecimal bigDecimal2 = (BigDecimal) data.getSerializable("decimal_targetPower");
                    if (bigDecimal2 == null) {
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetTargetPower failed to start because target power was null";
                    } else if (bigDecimal2.compareTo(new BigDecimal("0")) == -1) {
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetTargetPower failed to start because target power was under 0 W";
                    } else {
                        if (bigDecimal2.compareTo(new BigDecimal("1000")) != 1) {
                            obtain.arg1 = 0;
                            aVar = new z.a(g0.b.c(bigDecimal2), this, null);
                            u(aVar, aVar2, 228, "int_requestStatus");
                            j(aVar2, obtain);
                            return;
                        }
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetTargetPower failed to start because target power exceeded 1000 W";
                    }
                    h1.a.b(str, str2);
                    j(aVar2, obtain);
                    return;
                case 20005:
                    i3 = 228;
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.b(AntPlusFitnessEquipmentPcc.CommandStatus.b.WIND_RESISTANCE.b(), this, null);
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20006:
                    str3 = "Cmd requestSetWindResistance failed to start because the drafting factor exceeded 1.00";
                    BigDecimal bigDecimal3 = (BigDecimal) data.getSerializable("decimal_windResistanceCoefficient");
                    int i5 = data.getInt("int_windSpeed");
                    BigDecimal bigDecimal4 = (BigDecimal) data.getSerializable("decimal_draftingFactor");
                    if (bigDecimal3 != null && bigDecimal3.compareTo(new BigDecimal("255")) != 0) {
                        if (bigDecimal3.compareTo(new BigDecimal("0")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetWindResistance failed to start because the wind resistance coefficient was under 0 kg/m";
                        } else if (bigDecimal3.compareTo(new BigDecimal("1.86")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetWindResistance failed to start because the wind resistance coefficient exceeded 1.86 kg/m";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    bigDecimal3 = new BigDecimal("255");
                    if (i5 != 255) {
                        if (i5 < -127) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetWindResistance failed to start because the wind speed was under 0 km/h";
                            h1.a.b(str, str2);
                            j(aVar2, obtain);
                            return;
                        }
                        if (i5 > 127) {
                            obtain.arg1 = -3;
                            h1.a.b(X, "Cmd requestSetWindResistance failed to start because the wind speed exceeded 127 km/h");
                            j(aVar2, obtain);
                            return;
                        }
                    }
                    if (bigDecimal4 != null && bigDecimal4.compareTo(new BigDecimal("255")) != 0) {
                        if (bigDecimal4.compareTo(new BigDecimal("0")) != -1) {
                            if (bigDecimal4.compareTo(new BigDecimal("1.00")) == 1) {
                                obtain.arg1 = -3;
                                str4 = X;
                                h1.a.b(str4, str3);
                                j(aVar2, obtain);
                                return;
                            }
                        }
                        obtain.arg1 = -3;
                        h1.a.b(X, "Cmd requestSetWindResistance failed to start because the drafting factor was under 0");
                        j(aVar2, obtain);
                        return;
                    }
                    bigDecimal4 = new BigDecimal("255");
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.a(g0.b.f(bigDecimal3, (byte) i5, bigDecimal4), this, null);
                    i3 = 228;
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20007:
                    BigDecimal bigDecimal5 = (BigDecimal) data.getSerializable("decimal_frontalSurfaceArea");
                    BigDecimal bigDecimal6 = (BigDecimal) data.getSerializable("decimal_dragCoefficient");
                    BigDecimal bigDecimal7 = (BigDecimal) data.getSerializable("decimal_airDensity");
                    int i6 = data.getInt("int_windSpeed");
                    BigDecimal bigDecimal8 = (BigDecimal) data.getSerializable("decimal_draftingFactor");
                    if (bigDecimal5 == null) {
                        bigDecimal5 = new BigDecimal("0.40");
                    }
                    if (bigDecimal6 == null) {
                        bigDecimal6 = new BigDecimal("1.0");
                    }
                    if (bigDecimal7 == null) {
                        bigDecimal7 = new BigDecimal("1.275");
                    }
                    BigDecimal multiply = bigDecimal5.multiply(bigDecimal6).multiply(bigDecimal7);
                    if (multiply.compareTo(new BigDecimal("0")) == -1) {
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetWindResistance failed to start because the calculated wind resistance coefficient was under 0 kg/m";
                    } else {
                        if (multiply.compareTo(new BigDecimal("1.86")) != 1) {
                            if (i6 != 255) {
                                if (i6 < -127) {
                                    obtain.arg1 = -3;
                                    str = X;
                                    str2 = "Cmd requestSetWindResistance failed to start because the wind speed was under -127 km/h";
                                } else if (i6 > 127) {
                                    obtain.arg1 = -3;
                                    h1.a.b(X, "Cmd requestSetWindResistance failed to start because the wind speed exceeded 127 km/h");
                                    j(aVar2, obtain);
                                    return;
                                }
                            }
                            if (bigDecimal8 != null && bigDecimal8.compareTo(new BigDecimal("255")) != 0) {
                                if (bigDecimal8.compareTo(new BigDecimal("0")) != -1) {
                                    if (bigDecimal8.compareTo(new BigDecimal("1.00")) == 1) {
                                        obtain.arg1 = -3;
                                        str4 = X;
                                        str3 = "Cmd requestSetWindResistance failed to start because the drafting factor exceeded 1.00";
                                        h1.a.b(str4, str3);
                                        j(aVar2, obtain);
                                        return;
                                    }
                                }
                                obtain.arg1 = -3;
                                h1.a.b(X, "Cmd requestSetWindResistance failed to start because the drafting factor was under 0");
                                j(aVar2, obtain);
                                return;
                            }
                            bigDecimal8 = new BigDecimal("255");
                            obtain.arg1 = 0;
                            j(aVar2, obtain);
                            bVar2 = new z.a(g0.b.f(multiply, (byte) i6, bigDecimal8), this, null);
                            i3 = 228;
                            u(bVar2, aVar2, i3, "int_requestStatus");
                            return;
                        }
                        obtain.arg1 = -3;
                        str = X;
                        str2 = "Cmd requestSetWindResistance failed to start because the calculated wind resistance coefficient exceeded 1.86 kg/m";
                    }
                    h1.a.b(str, str2);
                    j(aVar2, obtain);
                    return;
                case 20008:
                    i3 = 228;
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.b(AntPlusFitnessEquipmentPcc.CommandStatus.b.TRACK_RESISTANCE.b(), this, null);
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20009:
                    BigDecimal bigDecimal9 = (BigDecimal) data.getSerializable("decimal_grade");
                    BigDecimal bigDecimal10 = (BigDecimal) data.getSerializable("decimal_rollingResistanceCoefficient");
                    if (bigDecimal9 != null && bigDecimal9.compareTo(new BigDecimal("65535")) != 0) {
                        if (bigDecimal9.compareTo(new BigDecimal("-200")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetTrackResistance failed to start because grade was under -200 %";
                        } else if (bigDecimal9.compareTo(new BigDecimal("200")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetTrackResistance failed to start because grade exceeded 200 %";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    bigDecimal9 = new BigDecimal("65535");
                    if (bigDecimal10 != null && bigDecimal10.compareTo(new BigDecimal("255")) != 0) {
                        if (bigDecimal10.compareTo(new BigDecimal("0")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetTrackResistance failed to start because the rolling resistance coefficient was under 0";
                        } else if (bigDecimal10.compareTo(new BigDecimal("0.0127")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetTrackResistance failed to start because the rolling resistance coefficient exceeded 0.0127";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    bigDecimal10 = new BigDecimal("255");
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.a(g0.b.d(bigDecimal9, bigDecimal10), this, null);
                    i3 = 228;
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20010:
                    i3 = 228;
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.b(54, this, null);
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20011:
                    i3 = 228;
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.b(55, this, null);
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20012:
                    AntPlusFitnessEquipmentPcc.UserConfiguration userConfiguration = (AntPlusFitnessEquipmentPcc.UserConfiguration) data.getParcelable("parcelable_UserConfiguration");
                    BigDecimal bigDecimal11 = userConfiguration.f675b;
                    if (bigDecimal11 != null) {
                        if (bigDecimal11.compareTo(new BigDecimal("0")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the user weight was under 0 kg";
                        } else if (userConfiguration.f675b.compareTo(new BigDecimal("655.34")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the user weight exceeded 655.34 kg";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    userConfiguration.f675b = new BigDecimal("65535");
                    BigDecimal bigDecimal12 = userConfiguration.f676c;
                    if (bigDecimal12 != null) {
                        if (bigDecimal12.compareTo(new BigDecimal("0")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the bicycle weight was under 0 kg";
                        } else if (userConfiguration.f676c.compareTo(new BigDecimal("50")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the bicycle weight exceeded 50 kg";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    userConfiguration.f676c = new BigDecimal("4095");
                    BigDecimal bigDecimal13 = userConfiguration.f677d;
                    if (bigDecimal13 != null) {
                        if (bigDecimal13.compareTo(new BigDecimal("0")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the bicycle wheel diameter was under 0 m";
                        } else if (userConfiguration.f677d.compareTo(new BigDecimal("2.54")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the bicycle wheel diamter exceeded 2.54 m";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    userConfiguration.f677d = new BigDecimal("255");
                    BigDecimal bigDecimal14 = userConfiguration.f678e;
                    if (bigDecimal14 != null) {
                        if (bigDecimal14.compareTo(new BigDecimal("0.03")) == -1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the gear ratio was under 0.03";
                        } else if (userConfiguration.f678e.compareTo(new BigDecimal("7.65")) == 1) {
                            obtain.arg1 = -3;
                            str = X;
                            str2 = "Cmd requestSetUserConfiguration failed to start because the gear ratio exceeded 7.65";
                        }
                        h1.a.b(str, str2);
                        j(aVar2, obtain);
                        return;
                    }
                    userConfiguration.f678e = new BigDecimal("255");
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    bVar2 = new z.a(g0.b.e(userConfiguration.f675b, userConfiguration.f676c, userConfiguration.f677d, userConfiguration.f678e), this, null);
                    i3 = 228;
                    u(bVar2, aVar2, i3, "int_requestStatus");
                    return;
                case 20013:
                    boolean z2 = data.getBoolean("bool_zeroOffsetCalibration");
                    boolean z3 = data.getBoolean("bool_spinDownCalibration");
                    obtain.arg1 = 0;
                    j(aVar2, obtain);
                    u(new z.a(g0.b.a(z2, z3), this, null), aVar2, 228, "int_requestStatus");
                    return;
                default:
                    obtain.recycle();
                    super.b(uuid, message);
                    return;
            }
        } else {
            i2 = 228;
            obtain.arg1 = 0;
            j(aVar2, obtain);
            bVar = new z.b(71, this, null);
        }
        u(bVar, aVar2, i2, "int_requestStatus");
    }

    @Override // v.e
    public boolean c(e.a aVar, v0.a aVar2, Bundle bundle) {
        Message obtain = Message.obtain();
        l(202, aVar, obtain);
        obtain.recycle();
        return super.c(aVar, aVar2, bundle);
    }

    @Override // v.a, v.e
    public void d() {
        s();
        super.d();
    }

    @Override // v.c, v.d, v.a
    public void o(boolean z2) {
        if (this.U) {
            super.o(z2);
        }
    }

    @Override // v.a
    public void s() {
        synchronized (this.V) {
            if (!this.W) {
                u0.a aVar = this.f1695w;
                if (aVar != null) {
                    aVar.t(true);
                }
                this.f3424h.m();
                this.f3444n.t(true);
                super.s();
                this.W = true;
            }
        }
    }

    @Override // v.c
    public List w() {
        g0.a aVar = new g0.a();
        this.f1696x = aVar;
        this.f1697y = new g0.c(aVar);
        this.f1698z = new d(this.f1696x);
        this.A = new g0.e(this.f1696x);
        this.B = new f(this.f1696x);
        this.C = new h(this.f1696x);
        this.D = new i(this.f1696x);
        this.E = new j(this.f1696x);
        this.F = new k(this.f1696x);
        this.G = new l(this.f1696x);
        this.S = new o.b();
        this.H = new g();
        this.I = new o();
        this.J = new m(this.f1696x, this.S);
        this.K = new n(this.f1696x, this.S);
        this.L = new p();
        this.M = new q();
        this.N = new r();
        this.O = new s();
        this.P = new t();
        this.Q = new u();
        this.R = new v();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1697y);
        arrayList.add(this.f1698z);
        arrayList.add(this.A);
        arrayList.add(this.B);
        arrayList.add(this.C);
        arrayList.add(this.D);
        arrayList.add(this.E);
        arrayList.add(this.F);
        arrayList.add(this.G);
        arrayList.add(this.H);
        arrayList.add(this.I);
        arrayList.add(this.J);
        arrayList.add(this.K);
        arrayList.add(this.L);
        arrayList.add(this.M);
        arrayList.add(this.N);
        arrayList.add(this.O);
        arrayList.add(this.P);
        arrayList.add(this.Q);
        arrayList.add(this.R);
        arrayList.addAll(v());
        return arrayList;
    }

    public a(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntChannel antChannel, AntChannel antChannel2, FitFileCommon.FitFile fitFile, FitFileCommon.FitFile[] fitFileArr) {
        super(deviceDbDeviceInfo, antChannel2);
        this.V = new Object();
        this.W = false;
        deviceDbDeviceInfo.f1177e = "Fitness Equipment Session";
        this.U = false;
        this.T = deviceDbDeviceInfo.f1176d.intValue();
        try {
            this.f1695w = new u0.a(antChannel, new C0033a());
            try {
                this.f1695w.u(new h0.a(this.T, 57, 8192, 1, 5, new b(), fitFile, fitFileArr), 0);
            } catch (InterruptedException unused) {
                h1.a.b(X, "Failed to start ANTFS task on executor");
                this.f1695w.t(true);
                throw new ClosedChannelException();
            }
        } catch (RemoteException unused2) {
            h1.a.b(X, "Executor blew up in constructor");
            throw new ClosedChannelException();
        }
    }
}
