package k1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class w implements Comparable {

    /* renamed from: c */
    public static final long f2458c = d1.f2152z.longValue();

    /* renamed from: d */
    private static final Map f2459d;

    /* renamed from: a */
    private long f2460a;

    /* renamed from: b */
    private double f2461b = 0.0d;

    static {
        HashMap hashMap = new HashMap();
        f2459d = hashMap;
        hashMap.put(268435456L, "MIN");
    }

    public w(long j2) {
        this.f2460a = j2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(w wVar) {
        return this.f2460a == wVar.e().longValue() ? Double.compare(this.f2461b, wVar.d().doubleValue()) : this.f2460a > wVar.e().longValue() ? 1 : -1;
    }

    public void b(long j2) {
        long j3 = this.f2460a;
        if (j3 < 268435456) {
            this.f2460a = j3 + j2;
        }
    }

    public Date c() {
        return new Date((this.f2460a * 1000) + Math.round(this.f2461b * 1000.0d) + 631065600000L);
    }

    public Double d() {
        return new Double(this.f2461b);
    }

    public Long e() {
        return new Long(this.f2460a);
    }

    public String toString() {
        return c().toString();
    }
}
