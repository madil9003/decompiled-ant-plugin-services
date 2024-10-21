package q1;

import android.os.Bundle;
import o1.a;

/* loaded from: classes.dex */
public class j implements a.d {

    /* renamed from: b */
    public static final j f3039b = a().a();

    /* renamed from: a */
    private final String f3040a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private String f3041a;

        /* synthetic */ a(l lVar) {
        }

        public j a() {
            return new j(this.f3041a, null);
        }
    }

    /* synthetic */ j(String str, m mVar) {
        this.f3040a = str;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f3040a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return e.a(this.f3040a, ((j) obj).f3040a);
        }
        return false;
    }

    public final int hashCode() {
        return e.b(this.f3040a);
    }
}
