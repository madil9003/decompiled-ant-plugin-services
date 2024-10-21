package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d */
    private final SparseIntArray f124d;

    /* renamed from: e */
    private final Parcel f125e;

    /* renamed from: f */
    private final int f126f;

    /* renamed from: g */
    private final int f127g;

    /* renamed from: h */
    private final String f128h;

    /* renamed from: i */
    private int f129i;

    /* renamed from: j */
    private int f130j;

    /* renamed from: k */
    private int f131k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a.a(), new a.a(), new a.a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f125e.writeInt(-1);
        } else {
            this.f125e.writeInt(bArr.length);
            this.f125e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f125e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i2) {
        this.f125e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f125e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f125e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i2 = this.f129i;
        if (i2 >= 0) {
            int i3 = this.f124d.get(i2);
            int dataPosition = this.f125e.dataPosition();
            this.f125e.setDataPosition(i3);
            this.f125e.writeInt(dataPosition - i3);
            this.f125e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f125e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f130j;
        if (i2 == this.f126f) {
            i2 = this.f127g;
        }
        return new b(parcel, dataPosition, i2, this.f128h + "  ", this.f121a, this.f122b, this.f123c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f125e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f125e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f125e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f125e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i2) {
        while (this.f130j < this.f127g) {
            int i3 = this.f131k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f125e.setDataPosition(this.f130j);
            int readInt = this.f125e.readInt();
            this.f131k = this.f125e.readInt();
            this.f130j += readInt;
        }
        return this.f131k == i2;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f125e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.f125e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f125e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i2) {
        a();
        this.f129i = i2;
        this.f124d.put(i2, this.f125e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z2) {
        this.f125e.writeInt(z2 ? 1 : 0);
    }

    private b(Parcel parcel, int i2, int i3, String str, a.a aVar, a.a aVar2, a.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f124d = new SparseIntArray();
        this.f129i = -1;
        this.f131k = -1;
        this.f125e = parcel;
        this.f126f = i2;
        this.f127g = i3;
        this.f130j = i2;
        this.f128h = str;
    }
}
