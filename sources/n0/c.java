package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.dsi.ant.plugins.antplus.pccbase.MultiDeviceSearch$MultiDeviceSearchResult;
import com.dsi.ant.plugins.antplus.pccbase.a;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public class c {

    /* renamed from: g */
    private static final String f2672g = "c";

    /* renamed from: a */
    private final a.f f2673a = new a();

    /* renamed from: b */
    private final a.e f2674b = new b();

    /* renamed from: c */
    private final f f2675c;

    /* renamed from: d */
    private final e f2676d;

    /* renamed from: e */
    private final InterfaceC0043c f2677e;

    /* renamed from: f */
    private final com.dsi.ant.plugins.antplus.pccbase.d f2678f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.f {
        a() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.f
        /* renamed from: b */
        public void a(f fVar, p0.e eVar, p0.b bVar) {
            if (eVar != p0.e.SUCCESS) {
                c.this.f2676d.a(eVar);
            } else {
                c.this.f2676d.b(fVar.F ? fVar.I() ? d.AVAILABLE : d.UNAVAILABLE : d.UNKNOWN_OLDSERVICE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements a.e {
        b() {
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.e
        public void b(p0.b bVar) {
        }
    }

    /* renamed from: n0.c$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0043c {
        void a(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public enum d {
        AVAILABLE,
        UNAVAILABLE,
        UNKNOWN_OLDSERVICE
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(p0.e eVar);

        void b(d dVar);

        void c(MultiDeviceSearch$MultiDeviceSearchResult multiDeviceSearch$MultiDeviceSearchResult);
    }

    /* loaded from: classes.dex */
    public static class f extends com.dsi.ant.plugins.antplus.pccbase.a {
        public c E;
        public volatile boolean F;

        /* loaded from: classes.dex */
        public static class a extends a.g {

            /* renamed from: c */
            public WeakReference f2685c;

            public a(f fVar) {
                this.f2685c = new WeakReference(fVar);
            }

            @Override // com.dsi.ant.plugins.antplus.pccbase.a.g
            public boolean b(Message message) {
                f fVar;
                if (message.what == 0 && (fVar = (f) this.f2685c.get()) != null) {
                    fVar.F = message.getData().containsKey("bool_RssiSupport");
                }
                return super.b(message);
            }

            @Override // com.dsi.ant.plugins.antplus.pccbase.a.g
            /* renamed from: d */
            public void c(f fVar, a.f fVar2) {
                super.c(fVar, fVar2);
            }
        }

        public f(c cVar) {
            this.E = cVar;
        }

        public com.dsi.ant.plugins.antplus.pccbase.d H(Context context, Bundle bundle) {
            c cVar = this.E;
            Objects.requireNonNull(cVar);
            g gVar = new g(this.E.f2673a, this.E.f2674b);
            this.f838v = gVar;
            a aVar = new a(this);
            aVar.c(this, gVar);
            this.f839w = gVar;
            com.dsi.ant.plugins.antplus.pccbase.a.w(context, bundle, this, aVar);
            return gVar;
        }

        public boolean I() {
            return this.f837u;
        }

        public void J() {
            h();
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a
        protected int m() {
            return 20205;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a
        protected Intent n() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.dsi.ant.plugins.antplus", "com.dsi.ant.plugins.antplus.multisearch.MultiSearchService"));
            return intent;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a
        protected void q(Message message) {
            int i2 = message.arg1;
            if (i2 == 1) {
                Bundle data = message.getData();
                data.setClassLoader(MultiDeviceSearch$MultiDeviceSearchResult.class.getClassLoader());
                this.E.f2676d.c((MultiDeviceSearch$MultiDeviceSearchResult) data.getParcelable("dev_Device"));
                return;
            }
            if (i2 == 2) {
                if (this.E.f2677e == null) {
                    return;
                }
                Bundle data2 = message.getData();
                this.E.f2677e.a(data2.getInt("int_resultID"), data2.getInt("int_rssi"));
                return;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    ((g) this.f839w).a(null, p0.e.c(message.arg2), null);
                    this.E.g();
                    return;
                }
                h1.a.a(c.f2672g, "Unrecognized event received: " + message.arg1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends com.dsi.ant.plugins.antplus.pccbase.d implements a.f, a.e {

        /* renamed from: i */
        protected boolean f2686i;

        public g(a.f fVar, a.e eVar) {
            super(fVar, eVar);
            this.f2686i = false;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.e
        public void b(p0.b bVar) {
            if (bVar == p0.b.DEAD) {
                a(null, p0.e.OTHER_FAILURE, null);
            }
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.d
        public boolean h() {
            boolean z2;
            synchronized (this.f855d) {
                z2 = !this.f852a && (this.f853b || this.f2686i);
            }
            return z2;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.d
        protected void i() {
            c.this.f2675c.J();
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.a.f
        /* renamed from: j */
        public void a(f fVar, p0.e eVar, p0.b bVar) {
            synchronized (this.f855d) {
                this.f858g.a(fVar, eVar, bVar);
                if (eVar == p0.e.SUCCESS) {
                    this.f853b = false;
                    this.f2686i = true;
                }
            }
        }
    }

    public c(Context context, EnumSet enumSet, e eVar, InterfaceC0043c interfaceC0043c) {
        if (context == null || enumSet == null || eVar == null) {
            throw new IllegalArgumentException("Null parameter passed into MultiDeviceSearch constructor");
        }
        int i2 = 0;
        int i3 = interfaceC0043c != null ? 1 : 0;
        this.f2676d = eVar;
        this.f2677e = interfaceC0043c;
        Bundle bundle = new Bundle();
        bundle.putInt("int_RequestAccessMode", 2);
        bundle.putInt("int_RssiMode", i3);
        int[] iArr = new int[enumSet.size()];
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((p0.c) it.next()).b();
            i2++;
        }
        bundle.putIntArray("intarr_deviceTypeList", iArr);
        f fVar = new f(this);
        this.f2675c = fVar;
        this.f2678f = fVar.H(context, bundle);
    }

    public void g() {
        this.f2678f.g();
    }
}
