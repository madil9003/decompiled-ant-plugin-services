package com.dsi.ant.plugins.antplus.multisearch;

import android.os.Looper;
import android.os.RemoteException;
import com.dsi.ant.channel.AntChannel;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import com.dsi.ant.plugins.antplus.utility.search.f;
import com.dsi.ant.plugins.antplus.utility.search.j;
import j.i;
import j.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w0.b;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private final HashSet f517a = new HashSet();

    /* renamed from: b */
    private final Object f518b = new Object();

    /* renamed from: c */
    private f f519c;

    /* renamed from: d */
    private boolean f520d;

    /* renamed from: e */
    private f.b f521e;

    /* renamed from: f */
    private boolean f522f;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.dsi.ant.plugins.antplus.multisearch.b$b */
    /* loaded from: classes.dex */
    public class C0010b implements f.b {
        private C0010b() {
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void a(SearchResultInfo searchResultInfo) {
            synchronized (b.this.f518b) {
                if (b.this.f521e != this) {
                    return;
                }
                ArrayList arrayList = new ArrayList(b.this.f517a);
                l lVar = searchResultInfo.f977b;
                Integer valueOf = (lVar == null || lVar.a() != l.a.DBM) ? null : Integer.valueOf(searchResultInfo.f977b.c());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).b(searchResultInfo.f976a, valueOf);
                }
            }
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void b() {
            synchronized (b.this.f518b) {
                if (b.this.f521e != this) {
                    return;
                }
                Iterator it = new ArrayList(b.this.f517a).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).c();
                }
            }
        }

        @Override // com.dsi.ant.plugins.antplus.utility.search.f.b
        public void c(f.a aVar, AntChannel antChannel) {
            if (antChannel != null) {
                antChannel.m();
            }
            synchronized (b.this.f518b) {
                if (b.this.f521e != this) {
                    return;
                }
                b.this.f519c = null;
                b.this.f520d = false;
                if (aVar == f.a.INTERRUPTED) {
                    return;
                }
                Iterator it = new ArrayList(b.this.f517a).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(-4);
                }
            }
        }

        /* synthetic */ C0010b(b bVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i2);

        void b(j.b bVar, Integer num);

        void c();
    }

    public boolean f() {
        boolean z2;
        synchronized (this.f518b) {
            z2 = (this.f519c == null || this.f520d) ? false : true;
        }
        return z2;
    }

    public void g(c cVar) {
        synchronized (this.f518b) {
            this.f517a.add(cVar);
        }
    }

    public boolean h() {
        boolean z2;
        synchronized (this.f518b) {
            z2 = this.f522f;
        }
        return z2;
    }

    public int i(AntChannel antChannel) {
        boolean z2;
        synchronized (this.f518b) {
            try {
                z2 = antChannel.k().k();
            } catch (RemoteException unused) {
                z2 = false;
            }
            b.C0065b c0065b = new b.C0065b();
            c0065b.f3504a = new j.b(0, 0, 0);
            c0065b.f3506c = 8192;
            c0065b.f3505b = 57;
            c0065b.f3507d = 0;
            c0065b.f3508e = i.TEN_SECONDS;
            j jVar = new j(c0065b, Looper.getMainLooper(), -1L);
            C0010b c0010b = new C0010b();
            if (!jVar.b(antChannel, c0010b)) {
                antChannel.m();
                return -4;
            }
            j();
            this.f519c = jVar;
            this.f520d = false;
            this.f521e = c0010b;
            this.f522f = z2;
            return 0;
        }
    }

    public void j() {
        synchronized (this.f518b) {
            f fVar = this.f519c;
            if (fVar != null && !this.f520d) {
                fVar.a();
                this.f520d = true;
            }
        }
    }

    public void k(c cVar) {
        synchronized (this.f518b) {
            this.f517a.remove(cVar);
        }
    }
}
