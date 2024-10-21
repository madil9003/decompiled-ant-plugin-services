package k1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class a2 implements b2 {

    /* renamed from: a */
    private int f2101a = 256;

    /* renamed from: b */
    private int f2102b = 255;

    /* renamed from: c */
    private int f2103c = 254;

    /* renamed from: d */
    private ArrayList f2104d = new ArrayList();

    /* renamed from: e */
    private ArrayList f2105e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2106a;

        static {
            int[] iArr = new int[m0.values().length];
            f2106a = iArr;
            try {
                iArr[m0.BEGIN_DEPRECIATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2106a[m0.END_DEPRECIATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2106a[m0.CONSECUTIVE_DEPRECIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2106a[m0.END_ALL_DEPRECIATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2106a[m0.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2106a[m0.STOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2106a[m0.STOP_DISABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2106a[m0.STOP_ALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2106a[m0.STOP_DISABLE_ALL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2106a[m0.MARKER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public a2() {
        for (int i2 = 0; i2 < this.f2101a; i2++) {
            this.f2105e.add(new LinkedList());
        }
    }

    private void b(z1 z1Var) {
        Iterator it = this.f2104d.iterator();
        while (it.hasNext()) {
            ((b2) it.next()).a(z1Var);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059 A[LOOP:0: B:20:0x0059->B:29:0x00a4, LOOP_START, PHI: r2
  0x0059: PHI (r2v13 int) = (r2v6 int), (r2v14 int) binds: [B:19:0x0054, B:29:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[LOOP:1: B:34:0x00b5->B:43:0x0100, LOOP_START, PHI: r2
  0x00b5: PHI (r2v11 int) = (r2v6 int), (r2v12 int) binds: [B:19:0x0054, B:43:0x0100] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0115 A[LOOP:2: B:47:0x0115->B:53:0x0146, LOOP_START, PHI: r2
  0x0115: PHI (r2v9 int) = (r2v6 int), (r2v10 int) binds: [B:19:0x0054, B:53:0x0146] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0149 A[LOOP:3: B:56:0x0149->B:65:0x019f, LOOP_START, PHI: r2
  0x0149: PHI (r2v7 int) = (r2v6 int), (r2v8 int) binds: [B:19:0x0054, B:65:0x019f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // k1.b2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(k1.z1 r6) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.a2.a(k1.z1):void");
    }
}
