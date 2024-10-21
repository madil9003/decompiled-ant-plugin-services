package c0;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import j.e;
import java.util.EnumSet;
import java.util.concurrent.CountDownLatch;
import k.k;
import k.l;
import o0.g;
import w0.d;

/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: q */
    private final EnumSet f274q;

    /* renamed from: r */
    private EnumSet f275r;

    /* renamed from: s */
    private int f276s;

    /* renamed from: t */
    private k f277t;

    /* renamed from: u */
    private w0.b f278u;

    /* renamed from: v */
    private SearchResultInfo f279v;

    /* renamed from: w */
    private CountDownLatch f280w;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f281a;

        static {
            int[] iArr = new int[l.values().length];
            f281a = iArr;
            try {
                iArr[l.BROADCAST_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f281a[l.ACKNOWLEDGED_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f281a[l.CHANNEL_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(EnumSet enumSet) {
        this.f274q = enumSet.clone();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void C(k.k r8) {
        /*
            r7 = this;
            byte[] r0 = r8.k()
            r1 = 0
            r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            if (r0 == r1) goto L5d
            r1 = 2
            if (r0 == r1) goto L18
            r8 = 7
            if (r0 == r8) goto L13
            goto L64
        L13:
            java.util.EnumSet r8 = r7.f275r
            o0.g r0 = o0.g.VIDEO_MODE
            goto L61
        L18:
            b0.c r0 = new b0.c
            r0.<init>()
            r2 = 0
            r4 = 0
            com.dsi.ant.message.ipc.AntMessageParcel r6 = new com.dsi.ant.message.ipc.AntMessageParcel
            r6.<init>(r8)
            r1 = r0
            r1.b(r2, r4, r6)
            com.dsi.ant.plugins.antplus.pcc.controls.pccbase.AntPlusBaseRemoteControlPcc$ControlDeviceCapabilities r8 = r0.f200a
            boolean r8 = r8.a()
            if (r8 == 0) goto L39
            java.util.EnumSet r8 = r7.f275r
            o0.g r1 = o0.g.AUDIO_MODE
            r8.add(r1)
        L39:
            com.dsi.ant.plugins.antplus.pcc.controls.pccbase.AntPlusBaseRemoteControlPcc$ControlDeviceCapabilities r8 = r0.f200a
            boolean r8 = r8.d()
            if (r8 == 0) goto L48
            java.util.EnumSet r8 = r7.f275r
            o0.g r1 = o0.g.VIDEO_MODE
            r8.add(r1)
        L48:
            com.dsi.ant.plugins.antplus.pcc.controls.pccbase.AntPlusBaseRemoteControlPcc$ControlDeviceCapabilities r8 = r0.f200a
            boolean r8 = r8.b()
            if (r8 == 0) goto L57
            java.util.EnumSet r8 = r7.f275r
            o0.g r0 = o0.g.GENERIC_MODE
            r8.add(r0)
        L57:
            java.util.concurrent.CountDownLatch r7 = r7.f280w
            r7.countDown()
            return
        L5d:
            java.util.EnumSet r8 = r7.f275r
            o0.g r0 = o0.g.AUDIO_MODE
        L61:
            r8.add(r0)
        L64:
            int r8 = r7.f276s
            int r0 = r8 + 1
            r7.f276s = r0
            r0 = 8
            if (r8 <= r0) goto L73
            java.util.concurrent.CountDownLatch r7 = r7.f280w
            r7.countDown()
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.b.C(k.k):void");
    }

    @Override // w0.d
    public void B(w0.b bVar, k kVar, SearchResultInfo searchResultInfo) {
        this.f278u = bVar;
        this.f277t = kVar;
        this.f279v = searchResultInfo;
    }

    @Override // u0.b
    public void d() {
        f();
        try {
            this.f280w.await();
        } catch (InterruptedException unused) {
        }
        this.f279v.f978c = new Bundle();
        this.f279v.f978c.putLong("long_SupportedModes", g.e(this.f275r));
        if (this.f275r.containsAll(this.f274q)) {
            return;
        }
        this.f278u.B();
    }

    @Override // u0.b
    public String k() {
        return "Controls: mode check task";
    }

    @Override // u0.b
    public void o() {
        this.f280w.countDown();
    }

    @Override // u0.b
    public boolean p(int i2) {
        this.f280w.countDown();
        return true;
    }

    @Override // u0.b
    public void s() {
        this.f276s = 0;
        this.f275r = EnumSet.noneOf(g.class);
        this.f280w = new CountDownLatch(1);
        C(this.f277t);
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
        int i2 = a.f281a[lVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            C((k) k.b.e(antMessageParcel));
            return;
        }
        if (i2 != 3) {
            return;
        }
        k.g gVar = new k.g(antMessageParcel);
        if (gVar.j() == e.CHANNEL_CLOSED || gVar.j() == e.RX_SEARCH_TIMEOUT) {
            this.f280w.countDown();
        }
    }
}
