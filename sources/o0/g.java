package o0;

import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public enum g {
    UNRECOGNIZED_MODE_PRESENT(1, -1),
    AUDIO_MODE(2, 300),
    VIDEO_MODE(4, 301),
    GENERIC_MODE(8, 302);


    /* renamed from: a */
    private final long f2812a;

    /* renamed from: b */
    private final int f2813b;

    g(long j2, int i2) {
        this.f2812a = j2;
        this.f2813b = i2;
    }

    public static g b(long j2) {
        for (g gVar : values()) {
            if (j2 == gVar.f()) {
                return gVar;
            }
        }
        return UNRECOGNIZED_MODE_PRESENT;
    }

    public static g c(int i2) {
        g gVar = UNRECOGNIZED_MODE_PRESENT;
        for (g gVar2 : values()) {
            if (gVar2.g() == i2) {
                return gVar2;
            }
        }
        return gVar;
    }

    public static EnumSet d(long j2) {
        EnumSet noneOf = EnumSet.noneOf(g.class);
        for (g gVar : values()) {
            long f3 = gVar.f();
            if ((f3 & j2) == f3) {
                noneOf.add(gVar);
                j2 -= f3;
            }
        }
        if (j2 != 0) {
            noneOf.add(UNRECOGNIZED_MODE_PRESENT);
        }
        return noneOf;
    }

    public static long e(EnumSet enumSet) {
        Iterator it = enumSet.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 |= ((g) it.next()).f();
        }
        return j2;
    }

    public long f() {
        return this.f2812a;
    }

    public int g() {
        return this.f2813b;
    }
}
