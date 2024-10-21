package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.plugins.antplus.pccbase.a;
import com.dsi.ant.plugins.antplus.pccbase.d;
import java.math.BigDecimal;
import java.util.EnumSet;

/* loaded from: classes.dex */
public class a extends com.dsi.ant.plugins.antplus.pccbase.c {
    b F;
    g1.b G;

    /* renamed from: n0.a$a */
    /* loaded from: classes.dex */
    public enum EnumC0041a {
        LIVE_DATA(1),
        INITIAL_VALUE(2),
        ZERO_DETECTED(3),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f2646a;

        EnumC0041a(int i2) {
            this.f2646a = i2;
        }

        public static EnumC0041a c(int i2) {
            for (EnumC0041a enumC0041a : values()) {
                if (enumC0041a.b() == i2) {
                    return enumC0041a;
                }
            }
            EnumC0041a enumC0041a2 = UNRECOGNIZED;
            enumC0041a2.f2646a = i2;
            return enumC0041a2;
        }

        public int b() {
            return this.f2646a;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(long j2, EnumSet enumSet, int i2, long j3, BigDecimal bigDecimal, EnumC0041a enumC0041a);
    }

    /* loaded from: classes.dex */
    public enum c {
        DATA_SOURCE_PAGE_4(1),
        DATA_SOURCE_CACHED(2),
        DATA_SOURCE_AVERAGED(3),
        HEART_RATE_ZERO_DETECTED(4),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f2653a;

        c(int i2) {
            this.f2653a = i2;
        }

        public int b() {
            return this.f2653a;
        }
    }

    private a() {
    }

    public static d E(Context context, int i2, int i3, a.f fVar, a.e eVar) {
        return com.dsi.ant.plugins.antplus.pccbase.a.u(context, i2, i3, new a(), fVar, eVar);
    }

    public void F(b bVar) {
        if (this.f836t < 20208) {
            if (bVar != null) {
                this.G = new g1.b(bVar);
                B(202);
            } else {
                this.G = null;
                D(202);
            }
            bVar = this.G;
        }
        this.F = bVar;
        if (bVar != null) {
            B(201);
        } else {
            D(201);
        }
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.a
    protected int m() {
        return 0;
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.a
    protected Intent n() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.dsi.ant.plugins.antplus", "com.dsi.ant.plugins.antplus.heartrate.HeartRateService"));
        return intent;
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.c, com.dsi.ant.plugins.antplus.pccbase.a
    public void q(Message message) {
        int i2 = message.arg1;
        if (i2 != 207) {
            switch (i2) {
                case 201:
                    if (this.F == null) {
                        return;
                    }
                    Bundle data = message.getData();
                    this.F.a(data.getLong("long_EstTimestamp"), p0.d.b(data.getLong("long_EventFlags")), data.getInt("int_computedHeartRate"), data.getLong("long_heartBeatCounter"), (BigDecimal) data.getSerializable("decimal_timestampOfLastEvent"), data.containsKey("int_dataState") ? EnumC0041a.c(data.getInt("int_dataState")) : EnumC0041a.LIVE_DATA);
                    return;
                case 202:
                    if (this.G == null) {
                        return;
                    }
                    Bundle data2 = message.getData();
                    this.G.b(data2.getLong("long_EstTimestamp"), p0.d.b(data2.getLong("long_EventFlags")), (BigDecimal) data2.getSerializable("decimal_timestampOfLastEvent"));
                    return;
                case 203:
                    return;
                default:
                    super.q(message);
                    return;
            }
        }
    }
}
