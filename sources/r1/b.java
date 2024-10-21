package r1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    public static int a(Parcel parcel) {
        return r(parcel, 20293);
    }

    public static void b(Parcel parcel, int i2) {
        s(parcel, i2);
    }

    public static void c(Parcel parcel, int i2, boolean z2) {
        t(parcel, i2, 4);
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i2, Boolean bool, boolean z2) {
        if (bool != null) {
            t(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z2) {
            t(parcel, i2, 0);
        }
    }

    public static void e(Parcel parcel, int i2, Bundle bundle, boolean z2) {
        if (bundle == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeBundle(bundle);
            s(parcel, r2);
        }
    }

    public static void f(Parcel parcel, int i2, byte[] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeByteArray(bArr);
            s(parcel, r2);
        }
    }

    public static void g(Parcel parcel, int i2, float f3) {
        t(parcel, i2, 4);
        parcel.writeFloat(f3);
    }

    public static void h(Parcel parcel, int i2, float[] fArr, boolean z2) {
        if (fArr == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeFloatArray(fArr);
            s(parcel, r2);
        }
    }

    public static void i(Parcel parcel, int i2, IBinder iBinder, boolean z2) {
        if (iBinder == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            s(parcel, r2);
        }
    }

    public static void j(Parcel parcel, int i2, int i3) {
        t(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void k(Parcel parcel, int i2, int[] iArr, boolean z2) {
        if (iArr == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeIntArray(iArr);
            s(parcel, r2);
        }
    }

    public static void l(Parcel parcel, int i2, long j2) {
        t(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void m(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            s(parcel, r2);
        }
    }

    public static void n(Parcel parcel, int i2, String str, boolean z2) {
        if (str == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeString(str);
            s(parcel, r2);
        }
    }

    public static void o(Parcel parcel, int i2, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                t(parcel, i2, 0);
            }
        } else {
            int r2 = r(parcel, i2);
            parcel.writeStringList(list);
            s(parcel, r2);
        }
    }

    public static void p(Parcel parcel, int i2, Parcelable[] parcelableArr, int i3, boolean z2) {
        if (parcelableArr == null) {
            if (z2) {
                t(parcel, i2, 0);
                return;
            }
            return;
        }
        int r2 = r(parcel, i2);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                u(parcel, parcelable, i3);
            }
        }
        s(parcel, r2);
    }

    public static void q(Parcel parcel, int i2, List list, boolean z2) {
        if (list == null) {
            if (z2) {
                t(parcel, i2, 0);
                return;
            }
            return;
        }
        int r2 = r(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcelable parcelable = (Parcelable) list.get(i3);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                u(parcel, parcelable, 0);
            }
        }
        s(parcel, r2);
    }

    private static int r(Parcel parcel, int i2) {
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void s(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    private static void t(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    private static void u(Parcel parcel, Parcelable parcelable, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
