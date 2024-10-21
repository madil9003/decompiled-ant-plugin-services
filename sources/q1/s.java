package q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;

/* loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        int i6 = -1;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            switch (r1.a.k(o2)) {
                case 1:
                    i2 = r1.a.q(parcel, o2);
                    break;
                case 2:
                    i3 = r1.a.q(parcel, o2);
                    break;
                case 3:
                    i4 = r1.a.q(parcel, o2);
                    break;
                case 4:
                    j2 = r1.a.r(parcel, o2);
                    break;
                case 5:
                    j3 = r1.a.r(parcel, o2);
                    break;
                case 6:
                    str = r1.a.f(parcel, o2);
                    break;
                case 7:
                    str2 = r1.a.f(parcel, o2);
                    break;
                case 8:
                    i5 = r1.a.q(parcel, o2);
                    break;
                case 9:
                    i6 = r1.a.q(parcel, o2);
                    break;
                default:
                    r1.a.t(parcel, o2);
                    break;
            }
        }
        r1.a.j(parcel, u2);
        return new MethodInvocation(i2, i3, i4, j2, j3, str, str2, i5, i6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new MethodInvocation[i2];
    }
}
