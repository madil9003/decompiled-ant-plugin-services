package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* loaded from: classes.dex */
public final class p implements g2.b {

    /* renamed from: a */
    private final b f1290a;

    /* renamed from: b */
    private final int f1291b;

    /* renamed from: c */
    private final p1.b f1292c;

    /* renamed from: d */
    private final long f1293d;

    /* renamed from: e */
    private final long f1294e;

    p(b bVar, int i2, p1.b bVar2, long j2, long j3, String str, String str2) {
        this.f1290a = bVar;
        this.f1291b = i2;
        this.f1292c = bVar2;
        this.f1293d = j2;
        this.f1294e = j3;
    }

    public static p b(b bVar, int i2, p1.b bVar2) {
        boolean z2;
        if (!bVar.f()) {
            return null;
        }
        RootTelemetryConfiguration a3 = q1.g.b().a();
        if (a3 == null) {
            z2 = true;
        } else {
            if (!a3.c()) {
                return null;
            }
            z2 = a3.d();
            l w2 = bVar.w(bVar2);
            if (w2 != null) {
                if (!(w2.u() instanceof com.google.android.gms.common.internal.b)) {
                    return null;
                }
                com.google.android.gms.common.internal.b bVar3 = (com.google.android.gms.common.internal.b) w2.u();
                if (bVar3.I() && !bVar3.e()) {
                    ConnectionTelemetryConfiguration c3 = c(w2, bVar3, i2);
                    if (c3 == null) {
                        return null;
                    }
                    w2.F();
                    z2 = c3.e();
                }
            }
        }
        return new p(bVar, i2, bVar2, z2 ? System.currentTimeMillis() : 0L, z2 ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    private static ConnectionTelemetryConfiguration c(l lVar, com.google.android.gms.common.internal.b bVar, int i2) {
        int[] b3;
        int[] c3;
        ConnectionTelemetryConfiguration G = bVar.G();
        if (G == null || !G.d() || ((b3 = G.b()) != null ? !u1.a.a(b3, i2) : !((c3 = G.c()) == null || !u1.a.a(c3, i2))) || lVar.s() >= G.a()) {
            return null;
        }
        return G;
    }

    @Override // g2.b
    public final void a(g2.d dVar) {
        l w2;
        int i2;
        int i3;
        int i4;
        int a3;
        long j2;
        long j3;
        int i5;
        if (this.f1290a.f()) {
            RootTelemetryConfiguration a4 = q1.g.b().a();
            if ((a4 == null || a4.c()) && (w2 = this.f1290a.w(this.f1292c)) != null && (w2.u() instanceof com.google.android.gms.common.internal.b)) {
                com.google.android.gms.common.internal.b bVar = (com.google.android.gms.common.internal.b) w2.u();
                int i6 = 0;
                boolean z2 = this.f1293d > 0;
                int y2 = bVar.y();
                if (a4 != null) {
                    z2 &= a4.d();
                    int a5 = a4.a();
                    int b3 = a4.b();
                    i2 = a4.e();
                    if (bVar.I() && !bVar.e()) {
                        ConnectionTelemetryConfiguration c3 = c(w2, bVar, this.f1291b);
                        if (c3 == null) {
                            return;
                        }
                        boolean z3 = c3.e() && this.f1293d > 0;
                        b3 = c3.a();
                        z2 = z3;
                    }
                    i4 = a5;
                    i3 = b3;
                } else {
                    i2 = 0;
                    i3 = 100;
                    i4 = 5000;
                }
                b bVar2 = this.f1290a;
                if (dVar.g()) {
                    a3 = 0;
                } else {
                    if (dVar.e()) {
                        i6 = 100;
                    } else {
                        Exception c4 = dVar.c();
                        if (c4 instanceof o1.b) {
                            Status a6 = ((o1.b) c4).a();
                            int b4 = a6.b();
                            ConnectionResult a7 = a6.a();
                            a3 = a7 == null ? -1 : a7.a();
                            i6 = b4;
                        } else {
                            i6 = 101;
                        }
                    }
                    a3 = -1;
                }
                if (z2) {
                    long j4 = this.f1293d;
                    long currentTimeMillis = System.currentTimeMillis();
                    i5 = (int) (SystemClock.elapsedRealtime() - this.f1294e);
                    j2 = j4;
                    j3 = currentTimeMillis;
                } else {
                    j2 = 0;
                    j3 = 0;
                    i5 = -1;
                }
                bVar2.E(new MethodInvocation(this.f1291b, i6, a3, j2, j3, null, null, y2, i5), i2, i4, i3);
            }
        }
    }
}
