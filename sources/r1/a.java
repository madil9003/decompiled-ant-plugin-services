package r1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: r1.a$a */
    /* loaded from: classes.dex */
    public static class C0049a extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C0049a(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                int r1 = r1 + 41
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r1.a.C0049a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Bundle a(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + s2);
        return readBundle;
    }

    public static byte[] b(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + s2);
        return createByteArray;
    }

    public static float[] c(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + s2);
        return createFloatArray;
    }

    public static int[] d(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + s2);
        return createIntArray;
    }

    public static Parcelable e(Parcel parcel, int i2, Parcelable.Creator creator) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + s2);
        return parcelable;
    }

    public static String f(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + s2);
        return readString;
    }

    public static ArrayList g(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + s2);
        return createStringArrayList;
    }

    public static Object[] h(Parcel parcel, int i2, Parcelable.Creator creator) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + s2);
        return createTypedArray;
    }

    public static ArrayList i(Parcel parcel, int i2, Parcelable.Creator creator) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + s2);
        return createTypedArrayList;
    }

    public static void j(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new C0049a(sb.toString(), parcel);
    }

    public static int k(int i2) {
        return (char) i2;
    }

    public static boolean l(Parcel parcel, int i2) {
        w(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        if (s2 == 0) {
            return null;
        }
        v(parcel, i2, s2, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static float n(Parcel parcel, int i2) {
        w(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static int o(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder p(Parcel parcel, int i2) {
        int s2 = s(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (s2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + s2);
        return readStrongBinder;
    }

    public static int q(Parcel parcel, int i2) {
        w(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long r(Parcel parcel, int i2) {
        w(parcel, i2, 8);
        return parcel.readLong();
    }

    public static int s(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static void t(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + s(parcel, i2));
    }

    public static int u(Parcel parcel) {
        int o2 = o(parcel);
        int s2 = s(parcel, o2);
        int dataPosition = parcel.dataPosition();
        if (k(o2) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(o2));
            throw new C0049a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = s2 + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new C0049a(sb.toString(), parcel);
    }

    private static void v(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        String hexString = Integer.toHexString(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(i3);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new C0049a(sb.toString(), parcel);
    }

    private static void w(Parcel parcel, int i2, int i3) {
        int s2 = s(parcel, i2);
        if (s2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(s2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(s2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new C0049a(sb.toString(), parcel);
    }
}
