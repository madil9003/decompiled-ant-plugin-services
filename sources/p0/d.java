package p0;

import java.util.EnumSet;

/* loaded from: classes.dex */
public enum d {
    UNRECOGNIZED_FLAG_PRESENT(1),
    WAS_BUFFERED(2);


    /* renamed from: a */
    private final long f2935a;

    d(long j2) {
        this.f2935a = j2;
    }

    public static EnumSet b(long j2) {
        EnumSet noneOf = EnumSet.noneOf(d.class);
        for (d dVar : values()) {
            long c3 = dVar.c();
            if ((c3 & j2) == c3) {
                noneOf.add(dVar);
                j2 -= c3;
            }
        }
        if (j2 != 0) {
            noneOf.add(UNRECOGNIZED_FLAG_PRESENT);
        }
        return noneOf;
    }

    public long c() {
        return this.f2935a;
    }
}
