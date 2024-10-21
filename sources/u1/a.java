package u1;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (!q1.e.a(objArr[i2], obj)) {
                i2++;
            } else if (i2 >= 0) {
                return true;
            }
        }
        return false;
    }
}
