package c;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class d implements c {

    /* renamed from: a */
    private final LocaleList f262a;

    public d(LocaleList localeList) {
        this.f262a = localeList;
    }

    @Override // c.c
    public Locale a(int i2) {
        return this.f262a.get(i2);
    }

    @Override // c.c
    public Object b() {
        return this.f262a;
    }

    public boolean equals(Object obj) {
        return this.f262a.equals(((c) obj).b());
    }

    public int hashCode() {
        return this.f262a.hashCode();
    }

    public String toString() {
        return this.f262a.toString();
    }
}
