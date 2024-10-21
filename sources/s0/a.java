package s0;

import android.os.SystemClock;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public final C0050a f3075a;

    /* renamed from: b */
    public final SparseArray f3076b;

    /* renamed from: c */
    GregorianCalendar f3077c;

    /* renamed from: s0.a$a */
    /* loaded from: classes.dex */
    public static class C0050a {

        /* renamed from: a */
        public int f3078a;

        /* renamed from: b */
        public int f3079b;

        /* renamed from: c */
        public int f3080c;

        /* renamed from: d */
        public d f3081d;

        /* renamed from: e */
        public long f3082e;

        /* renamed from: f */
        public long f3083f;
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public int f3084a;

        /* renamed from: b */
        public int f3085b;

        /* renamed from: c */
        public byte[] f3086c = new byte[3];

        /* renamed from: d */
        public int f3087d;

        /* renamed from: e */
        public EnumSet f3088e;

        /* renamed from: f */
        public long f3089f;

        /* renamed from: g */
        public long f3090g;

        /* renamed from: h */
        public long f3091h;
    }

    /* loaded from: classes.dex */
    public enum c {
        READ,
        WRITE,
        ERASE,
        ARCHIVE,
        APPEND,
        CRYPTO;

        public static byte b(EnumSet enumSet) {
            byte b3 = enumSet.contains(READ) ? (byte) 128 : (byte) 0;
            if (enumSet.contains(WRITE)) {
                b3 = (byte) (b3 | 64);
            }
            if (enumSet.contains(ERASE)) {
                b3 = (byte) (b3 | 32);
            }
            if (enumSet.contains(ARCHIVE)) {
                b3 = (byte) (b3 | 16);
            }
            if (enumSet.contains(APPEND)) {
                b3 = (byte) (b3 | 8);
            }
            return enumSet.contains(CRYPTO) ? (byte) (b3 | 4) : b3;
        }

        public static EnumSet c(byte b3) {
            ArrayList arrayList = new ArrayList();
            if ((b3 & 128) > 0) {
                arrayList.add(READ);
            }
            if ((b3 & 64) > 0) {
                arrayList.add(WRITE);
            }
            if ((b3 & 32) > 0) {
                arrayList.add(ERASE);
            }
            if ((b3 & 16) > 0) {
                arrayList.add(ARCHIVE);
            }
            if ((b3 & 8) > 0) {
                arrayList.add(APPEND);
            }
            if ((b3 & 4) > 0) {
                arrayList.add(CRYPTO);
            }
            return arrayList.size() != 0 ? EnumSet.copyOf((Collection) arrayList) : EnumSet.noneOf(c.class);
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        AUTO(0),
        SYSTEM(1),
        DATE(2),
        UNRECOGNIZED(255);


        /* renamed from: a */
        private int f3104a;

        d(int i2) {
            this.f3104a = i2;
        }

        public static d b(int i2) {
            if (i2 == 0) {
                return AUTO;
            }
            if (i2 == 1) {
                return SYSTEM;
            }
            if (i2 == 2) {
                return DATE;
            }
            d dVar = UNRECOGNIZED;
            dVar.f3104a = i2;
            return dVar;
        }

        public int c() {
            return this.f3104a;
        }
    }

    public a() {
        C0050a c0050a = new C0050a();
        this.f3075a = c0050a;
        this.f3076b = new SparseArray();
        c0050a.f3078a = 0;
        c0050a.f3079b = 1;
        c0050a.f3080c = 16;
        c0050a.f3081d = d.AUTO;
        c0050a.f3082e = SystemClock.uptimeMillis() / 1000;
        c0050a.f3083f = (new Date().getTime() - 631065600000L) / 1000;
    }

    public byte[] a() {
        byte[] bArr = new byte[(this.f3076b.size() + 1) * 16];
        C0050a c0050a = this.f3075a;
        w.c.b(bArr, 0, (c0050a.f3079b & 15) | (c0050a.f3078a & 240));
        w.c.b(bArr, 1, this.f3075a.f3080c);
        w.c.b(bArr, 2, this.f3075a.f3081d.c());
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        w.c.e(bArr, 8, this.f3075a.f3082e);
        w.c.e(bArr, 12, this.f3075a.f3083f);
        int i2 = 0;
        while (i2 < this.f3076b.size()) {
            b bVar = (b) this.f3076b.valueAt(i2);
            i2++;
            int i3 = i2 * 16;
            w.c.d(bArr, i3, bVar.f3084a);
            w.c.b(bArr, i3 + 2, bVar.f3085b);
            System.arraycopy(bVar.f3086c, 0, bArr, i3 + 3, 3);
            w.c.b(bArr, i3 + 6, bVar.f3087d);
            bArr[i3 + 7] = c.b(bVar.f3088e);
            w.c.e(bArr, i3 + 8, bVar.f3089f);
            w.c.e(bArr, i3 + 12, bVar.f3090g);
        }
        return bArr;
    }

    public a(byte[] bArr, GregorianCalendar gregorianCalendar) {
        this.f3077c = gregorianCalendar;
        C0050a c0050a = new C0050a();
        this.f3075a = c0050a;
        this.f3076b = new SparseArray();
        if (bArr.length < 16) {
            throw new DataFormatException("Directory bytes don't contain full 16 byte header");
        }
        if (bArr.length % 16 != 0) {
            throw new DataFormatException("Directory bytes not a multiple of 16");
        }
        c0050a.f3078a = w.c.v(bArr[0]);
        int r2 = w.c.r(bArr[0]);
        c0050a.f3079b = r2;
        if (r2 != 1 || c0050a.f3078a != 0) {
            throw new DataFormatException("Directory not version 1");
        }
        int i2 = w.c.i(bArr[1]);
        c0050a.f3080c = i2;
        if (i2 != 16) {
            throw new DataFormatException("Directory entries not 16 byte length");
        }
        c0050a.f3081d = d.b(w.c.i(bArr[2]));
        c0050a.f3082e = w.c.n(bArr, 8);
        c0050a.f3083f = w.c.n(bArr, 12);
        for (int i3 = 16; i3 < bArr.length; i3 += 16) {
            b bVar = new b();
            bVar.f3084a = w.c.k(bArr, i3);
            bVar.f3085b = w.c.i(bArr[i3 + 2]);
            byte[] bArr2 = bVar.f3086c;
            bArr2[0] = bArr[i3 + 3];
            bArr2[1] = bArr[i3 + 4];
            bArr2[2] = bArr[i3 + 5];
            bVar.f3087d = w.c.i(bArr[i3 + 6]);
            bVar.f3088e = c.c(bArr[i3 + 7]);
            bVar.f3089f = w.c.n(bArr, i3 + 8);
            long n2 = w.c.n(bArr, i3 + 12);
            bVar.f3090g = n2;
            if (n2 <= 268435455) {
                if (n2 >= 268435455 || this.f3075a.f3082e == 268435455) {
                    n2 = 0;
                } else {
                    long time = (gregorianCalendar.getTime().getTime() - 631065600000L) / 1000;
                    bVar.f3091h = time;
                    n2 = time - (this.f3075a.f3082e - bVar.f3090g);
                }
            }
            bVar.f3091h = n2;
            this.f3076b.append(bVar.f3084a, bVar);
        }
    }
}
