package q1;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b */
    private static g f3036b;

    /* renamed from: c */
    private static final RootTelemetryConfiguration f3037c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a */
    private RootTelemetryConfiguration f3038a;

    private g() {
    }

    public static synchronized g b() {
        g gVar;
        synchronized (g.class) {
            if (f3036b == null) {
                f3036b = new g();
            }
            gVar = f3036b;
        }
        return gVar;
    }

    public RootTelemetryConfiguration a() {
        return this.f3038a;
    }

    public final synchronized void c(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f3038a = f3037c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f3038a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.e() < rootTelemetryConfiguration.e()) {
            this.f3038a = rootTelemetryConfiguration;
        }
    }
}
