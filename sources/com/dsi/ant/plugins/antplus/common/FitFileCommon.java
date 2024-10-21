package com.dsi.ant.plugins.antplus.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class FitFileCommon {

    /* renamed from: a */
    private static final String f480a = "FitFileCommon";

    /* loaded from: classes.dex */
    public static class FitFile implements Parcelable {
        public static final Parcelable.Creator<FitFile> CREATOR = new a();

        /* renamed from: a */
        private final int f481a = 1;

        /* renamed from: b */
        private byte[] f482b;

        /* renamed from: c */
        private short f483c;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public FitFile createFromParcel(Parcel parcel) {
                return new FitFile(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public FitFile[] newArray(int i2) {
                return new FitFile[i2];
            }
        }

        public FitFile(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(FitFileCommon.f480a, "Decoding version " + readInt + " FitFile parcel with version 1 parser.");
            }
            this.f483c = (short) parcel.readInt();
            byte[] bArr = new byte[parcel.readInt()];
            this.f482b = bArr;
            parcel.readByteArray(bArr);
        }

        public short a() {
            return this.f483c;
        }

        public byte[] b() {
            return (byte[]) this.f482b.clone();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f481a);
            parcel.writeInt(this.f483c);
            parcel.writeInt(this.f482b.length);
            parcel.writeByteArray(this.f482b);
        }
    }

    /* loaded from: classes.dex */
    public enum a {
        FIT_DATA_TYPE(128),
        BLOOD_PRESSURE(14),
        INVALID(-1),
        UNRECOGNIZED(-2);


        /* renamed from: a */
        private int f489a;

        a(int i2) {
            this.f489a = i2;
        }

        public int b() {
            return this.f489a;
        }
    }
}
