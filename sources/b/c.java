package b;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final Bundle f132a;

        /* renamed from: b */
        private IconCompat f133b;

        /* renamed from: c */
        private final f[] f134c;

        /* renamed from: d */
        private final f[] f135d;

        /* renamed from: e */
        private boolean f136e;

        /* renamed from: f */
        boolean f137f;

        /* renamed from: g */
        private final int f138g;

        /* renamed from: h */
        private final boolean f139h;

        /* renamed from: i */
        public int f140i;

        /* renamed from: j */
        public CharSequence f141j;

        /* renamed from: k */
        public PendingIntent f142k;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.a(null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f142k;
        }

        public boolean b() {
            return this.f136e;
        }

        public Bundle c() {
            return this.f132a;
        }

        public int d() {
            return this.f140i;
        }

        public IconCompat e() {
            int i2;
            if (this.f133b == null && (i2 = this.f140i) != 0) {
                this.f133b = IconCompat.a(null, "", i2);
            }
            return this.f133b;
        }

        public f[] f() {
            return this.f134c;
        }

        public int g() {
            return this.f138g;
        }

        public boolean h() {
            return this.f137f;
        }

        public CharSequence i() {
            return this.f141j;
        }

        public boolean j() {
            return this.f139h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, f[] fVarArr, f[] fVarArr2, boolean z2, int i2, boolean z3, boolean z4) {
            this.f137f = true;
            this.f133b = iconCompat;
            if (iconCompat != null && iconCompat.f() == 2) {
                this.f140i = iconCompat.b();
            }
            this.f141j = d.d(charSequence);
            this.f142k = pendingIntent;
            this.f132a = bundle == null ? new Bundle() : bundle;
            this.f134c = fVarArr;
            this.f135d = fVarArr2;
            this.f136e = z2;
            this.f138g = i2;
            this.f137f = z3;
            this.f139h = z4;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {

        /* renamed from: e */
        private CharSequence f143e;

        @Override // b.c.e
        public void b(b.b bVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(bVar.a()).setBigContentTitle(this.f171b).bigText(this.f143e);
            if (this.f173d) {
                bigText.setSummaryText(this.f172c);
            }
        }

        public b g(CharSequence charSequence) {
            this.f143e = d.d(charSequence);
            return this;
        }
    }

    /* renamed from: b.c$c */
    /* loaded from: classes.dex */
    public static final class C0003c {
        public static Notification.BubbleMetadata a(C0003c c0003c) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        Notification O;
        public ArrayList P;

        /* renamed from: a */
        public Context f144a;

        /* renamed from: b */
        public ArrayList f145b;

        /* renamed from: c */
        ArrayList f146c;

        /* renamed from: d */
        CharSequence f147d;

        /* renamed from: e */
        CharSequence f148e;

        /* renamed from: f */
        PendingIntent f149f;

        /* renamed from: g */
        PendingIntent f150g;

        /* renamed from: h */
        RemoteViews f151h;

        /* renamed from: i */
        Bitmap f152i;

        /* renamed from: j */
        CharSequence f153j;

        /* renamed from: k */
        int f154k;

        /* renamed from: l */
        int f155l;

        /* renamed from: m */
        boolean f156m;

        /* renamed from: n */
        boolean f157n;

        /* renamed from: o */
        e f158o;

        /* renamed from: p */
        CharSequence f159p;

        /* renamed from: q */
        CharSequence[] f160q;

        /* renamed from: r */
        int f161r;

        /* renamed from: s */
        int f162s;

        /* renamed from: t */
        boolean f163t;

        /* renamed from: u */
        String f164u;

        /* renamed from: v */
        boolean f165v;

        /* renamed from: w */
        String f166w;

        /* renamed from: x */
        boolean f167x;

        /* renamed from: y */
        boolean f168y;

        /* renamed from: z */
        boolean f169z;

        public d(Context context) {
            this(context, null);
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i2, boolean z2) {
            int i3;
            Notification notification = this.O;
            if (z2) {
                i3 = i2 | notification.flags;
            } else {
                i3 = (~i2) & notification.flags;
            }
            notification.flags = i3;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f145b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new b.d(this).c();
        }

        public Bundle c() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public d e(boolean z2) {
            j(16, z2);
            return this;
        }

        public d f(String str) {
            this.I = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f149f = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f148e = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f147d = d(charSequence);
            return this;
        }

        public d k(boolean z2) {
            this.f167x = z2;
            return this;
        }

        public d l(int i2) {
            this.f155l = i2;
            return this;
        }

        public d m(int i2) {
            this.O.icon = i2;
            return this;
        }

        public d n(e eVar) {
            if (this.f158o != eVar) {
                this.f158o = eVar;
                if (eVar != null) {
                    eVar.f(this);
                }
            }
            return this;
        }

        public d o(CharSequence charSequence) {
            this.O.tickerText = d(charSequence);
            return this;
        }

        public d p(long j2) {
            this.O.when = j2;
            return this;
        }

        public d(Context context, String str) {
            this.f145b = new ArrayList();
            this.f146c = new ArrayList();
            this.f156m = true;
            this.f167x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            Notification notification = new Notification();
            this.O = notification;
            this.f144a = context;
            this.I = str;
            notification.when = System.currentTimeMillis();
            this.O.audioStreamType = -1;
            this.f155l = 0;
            this.P = new ArrayList();
            this.N = true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a */
        protected d f170a;

        /* renamed from: b */
        CharSequence f171b;

        /* renamed from: c */
        CharSequence f172c;

        /* renamed from: d */
        boolean f173d = false;

        public void a(Bundle bundle) {
        }

        public abstract void b(b.b bVar);

        public RemoteViews c(b.b bVar) {
            return null;
        }

        public RemoteViews d(b.b bVar) {
            return null;
        }

        public RemoteViews e(b.b bVar) {
            return null;
        }

        public void f(d dVar) {
            if (this.f170a != dVar) {
                this.f170a = dVar;
                if (dVar != null) {
                    dVar.n(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
