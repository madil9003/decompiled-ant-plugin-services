package i1;

import android.os.Parcel;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private final Parcel f1863a;

    /* renamed from: b */
    private final int f1864b;

    public b(Parcel parcel) {
        this.f1863a = parcel;
        this.f1864b = parcel.dataPosition() + parcel.readInt();
    }

    public void a() {
        this.f1863a.setDataPosition(this.f1864b);
    }
}
