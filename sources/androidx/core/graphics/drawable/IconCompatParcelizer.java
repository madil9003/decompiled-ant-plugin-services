package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f111a = aVar.p(iconCompat.f111a, 1);
        iconCompat.f113c = aVar.j(iconCompat.f113c, 2);
        iconCompat.f114d = aVar.r(iconCompat.f114d, 3);
        iconCompat.f115e = aVar.p(iconCompat.f115e, 4);
        iconCompat.f116f = aVar.p(iconCompat.f116f, 5);
        iconCompat.f117g = (ColorStateList) aVar.r(iconCompat.f117g, 6);
        iconCompat.f119i = aVar.t(iconCompat.f119i, 7);
        iconCompat.h();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.i(aVar.f());
        int i2 = iconCompat.f111a;
        if (-1 != i2) {
            aVar.F(i2, 1);
        }
        byte[] bArr = iconCompat.f113c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f114d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i3 = iconCompat.f115e;
        if (i3 != 0) {
            aVar.F(i3, 4);
        }
        int i4 = iconCompat.f116f;
        if (i4 != 0) {
            aVar.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f117g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f119i;
        if (str != null) {
            aVar.J(str, 7);
        }
    }
}
