package com.dsi.ant.message.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AntMessageParcel extends j.a implements Parcelable {
    public static final Parcelable.Creator<AntMessageParcel> CREATOR = new a();

    /* renamed from: a */
    protected int f416a;

    /* renamed from: b */
    protected byte[] f417b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AntMessageParcel createFromParcel(Parcel parcel) {
            return new AntMessageParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AntMessageParcel[] newArray(int i2) {
            return new AntMessageParcel[i2];
        }
    }

    public AntMessageParcel(int i2, byte[] bArr) {
        this.f416a = i2;
        this.f417b = bArr;
    }

    @Override // j.a
    public byte[] a() {
        return this.f417b;
    }

    @Override // j.a
    public int c() {
        return this.f416a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(Parcel parcel) {
        if (parcel != null) {
            parcel.readInt();
            int readInt = parcel.readInt();
            this.f416a = parcel.readInt();
            byte[] bArr = new byte[readInt];
            this.f417b = bArr;
            parcel.readByteArray(bArr);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(1);
        parcel.writeInt(this.f417b.length);
        parcel.writeInt(this.f416a);
        parcel.writeByteArray(this.f417b);
    }

    public AntMessageParcel(Parcel parcel) {
        e(parcel);
    }

    public AntMessageParcel(j.a aVar) {
        this(aVar.c(), aVar.a());
    }
}
