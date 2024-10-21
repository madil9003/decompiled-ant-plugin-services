package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.plugins.antplus.pccbase.a;
import java.math.BigDecimal;
import java.util.EnumSet;

/* loaded from: classes.dex */
public class b extends com.dsi.ant.plugins.antplus.pccbase.b {
    f K;
    e L;
    d M;
    h N;
    InterfaceC0042b O;
    c P;
    a Q;
    g R;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j2, EnumSet enumSet, long j3);
    }

    /* renamed from: n0.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0042b {
        void a(long j2, EnumSet enumSet, BigDecimal bigDecimal);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(long j2, EnumSet enumSet, BigDecimal bigDecimal);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(long j2, EnumSet enumSet, BigDecimal bigDecimal);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(long j2, EnumSet enumSet, BigDecimal bigDecimal);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(long j2, EnumSet enumSet, BigDecimal bigDecimal);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(long j2, EnumSet enumSet, j jVar, p0.a aVar, i iVar, k kVar);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(long j2, EnumSet enumSet, long j3);
    }

    /* loaded from: classes.dex */
    public enum i {
        OK(0),
        ERROR(1),
        WARNING(2),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f2659a;

        i(int i2) {
            this.f2659a = i2;
        }

        public static i c(int i2) {
            for (i iVar : values()) {
                if (iVar.b() == i2) {
                    return iVar;
                }
            }
            i iVar2 = UNRECOGNIZED;
            iVar2.f2659a = i2;
            return iVar2;
        }

        public int b() {
            return this.f2659a;
        }
    }

    /* loaded from: classes.dex */
    public enum j {
        LACES(0),
        MIDSOLE(1),
        OTHER(2),
        ANKLE(3),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f2666a;

        j(int i2) {
            this.f2666a = i2;
        }

        public static j c(int i2) {
            for (j jVar : values()) {
                if (jVar.b() == i2) {
                    return jVar;
                }
            }
            j jVar2 = UNRECOGNIZED;
            jVar2.f2666a = i2;
            return jVar2;
        }

        public int b() {
            return this.f2666a;
        }
    }

    /* loaded from: classes.dex */
    public enum k {
        INACTIVE(0),
        ACTIVE(1),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f2671a;

        k(int i2) {
            this.f2671a = i2;
        }

        public static k c(int i2) {
            for (k kVar : values()) {
                if (kVar.b() == i2) {
                    return kVar;
                }
            }
            k kVar2 = UNRECOGNIZED;
            kVar2.f2671a = i2;
            return kVar2;
        }

        public int b() {
            return this.f2671a;
        }
    }

    private b() {
    }

    public static com.dsi.ant.plugins.antplus.pccbase.d H(Context context, int i2, int i3, a.f fVar, a.e eVar) {
        return com.dsi.ant.plugins.antplus.pccbase.a.u(context, i2, i3, new b(), fVar, eVar);
    }

    public void I(a aVar) {
        this.Q = aVar;
        if (aVar != null) {
            B(207);
        } else {
            D(207);
        }
    }

    public void J(InterfaceC0042b interfaceC0042b) {
        this.O = interfaceC0042b;
        if (interfaceC0042b != null) {
            B(205);
        } else {
            D(205);
        }
    }

    public void K(c cVar) {
        this.P = cVar;
        if (cVar != null) {
            B(206);
        } else {
            D(206);
        }
    }

    public void L(d dVar) {
        this.M = dVar;
        if (dVar != null) {
            B(203);
        } else {
            D(203);
        }
    }

    public void M(e eVar) {
        this.L = eVar;
        if (eVar != null) {
            B(202);
        } else {
            D(202);
        }
    }

    public void N(f fVar) {
        this.K = fVar;
        if (fVar != null) {
            B(201);
        } else {
            D(201);
        }
    }

    public void O(g gVar) {
        this.R = gVar;
        if (gVar != null) {
            B(208);
        } else {
            D(208);
        }
    }

    public void P(h hVar) {
        this.N = hVar;
        if (hVar != null) {
            B(204);
        } else {
            D(204);
        }
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.a
    protected int m() {
        return 0;
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.a
    protected Intent n() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.dsi.ant.plugins.antplus", "com.dsi.ant.plugins.antplus.stridesdm.StrideSdmService"));
        return intent;
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.b, com.dsi.ant.plugins.antplus.pccbase.a
    public void q(Message message) {
        switch (message.arg1) {
            case 201:
                if (this.K == null) {
                    return;
                }
                Bundle data = message.getData();
                this.K.a(data.getLong("long_EstTimestamp"), p0.d.b(data.getLong("long_EventFlags")), (BigDecimal) data.getSerializable("decimal_instantaneousSpeed"));
                return;
            case 202:
                if (this.L == null) {
                    return;
                }
                Bundle data2 = message.getData();
                this.L.a(data2.getLong("long_EstTimestamp"), p0.d.b(data2.getLong("long_EventFlags")), (BigDecimal) data2.getSerializable("decimal_instantaneousCadence"));
                return;
            case 203:
                if (this.M == null) {
                    return;
                }
                Bundle data3 = message.getData();
                this.M.a(data3.getLong("long_EstTimestamp"), p0.d.b(data3.getLong("long_EventFlags")), (BigDecimal) data3.getSerializable("decimal_cumulativeDistance"));
                return;
            case 204:
                if (this.N == null) {
                    return;
                }
                Bundle data4 = message.getData();
                this.N.a(data4.getLong("long_EstTimestamp"), p0.d.b(data4.getLong("long_EventFlags")), data4.getLong("long_cumulativeStrides"));
                return;
            case 205:
                if (this.O == null) {
                    return;
                }
                Bundle data5 = message.getData();
                this.O.a(data5.getLong("long_EstTimestamp"), p0.d.b(data5.getLong("long_EventFlags")), (BigDecimal) data5.getSerializable("decimal_timestampOfLastComputation"));
                return;
            case 206:
                if (this.P == null) {
                    return;
                }
                Bundle data6 = message.getData();
                this.P.a(data6.getLong("long_EstTimestamp"), p0.d.b(data6.getLong("long_EventFlags")), (BigDecimal) data6.getSerializable("decimal_updateLatency"));
                return;
            case 207:
                if (this.Q == null) {
                    return;
                }
                Bundle data7 = message.getData();
                this.Q.a(data7.getLong("long_EstTimestamp"), p0.d.b(data7.getLong("long_EventFlags")), data7.getLong("long_cumulativeCalories"));
                return;
            case 208:
                if (this.R == null) {
                    return;
                }
                Bundle data8 = message.getData();
                this.R.a(data8.getLong("long_EstTimestamp"), p0.d.b(data8.getLong("long_EventFlags")), j.c(data8.getInt("int_SensorLocation")), p0.a.c(data8.getInt("int_BatteryStatus")), i.c(data8.getInt("int_SensorHealth")), k.c(data8.getInt("int_UseState")));
                return;
            default:
                super.q(message);
                return;
        }
    }
}
