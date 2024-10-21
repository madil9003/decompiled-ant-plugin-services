package i1;

import android.os.Parcel;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final Parcel f1861a;

    /* renamed from: b */
    private final int f1862b;

    public a(Parcel parcel) {
        this.f1861a = parcel;
        this.f1862b = parcel.dataPosition();
        parcel.writeInt(0);
    }

    public void a() {
        int dataPosition = this.f1861a.dataPosition();
        this.f1861a.setDataPosition(this.f1862b);
        this.f1861a.writeInt(dataPosition - this.f1862b);
        this.f1861a.setDataPosition(dataPosition);
    }
}
