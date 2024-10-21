package c;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b */
    private static final b f260b = a(new Locale[0]);

    /* renamed from: a */
    private c f261a;

    private b(c cVar) {
        this.f261a = cVar;
    }

    public static b a(Locale... localeArr) {
        return c(new LocaleList(localeArr));
    }

    public static b c(LocaleList localeList) {
        return new b(new d(localeList));
    }

    public Locale b(int i2) {
        return this.f261a.a(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && this.f261a.equals(((b) obj).f261a);
    }

    public int hashCode() {
        return this.f261a.hashCode();
    }

    public String toString() {
        return this.f261a.toString();
    }
}
