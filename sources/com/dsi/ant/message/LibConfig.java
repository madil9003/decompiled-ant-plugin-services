package com.dsi.ant.message;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class LibConfig implements Parcelable {
    public static final Parcelable.Creator<LibConfig> CREATOR = new a();

    /* renamed from: a */
    private boolean f407a;

    /* renamed from: b */
    private boolean f408b;

    /* renamed from: c */
    private boolean f409c;

    /* renamed from: d */
    private BundleData f410d;

    /* loaded from: classes.dex */
    public static final class BundleData implements Parcelable {
        public static final Parcelable.Creator<BundleData> CREATOR = new a();

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public BundleData createFromParcel(Parcel parcel) {
                parcel.readInt();
                return new BundleData(null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public BundleData[] newArray(int i2) {
                return null;
            }
        }

        private BundleData() {
        }

        /* synthetic */ BundleData(a aVar) {
            this();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(1);
        }
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LibConfig createFromParcel(Parcel parcel) {
            return new LibConfig(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LibConfig[] newArray(int i2) {
            return new LibConfig[i2];
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        CHANNEL_ID,
        RSSI,
        RX_TIMESTAMP,
        NUMBER_OF_DETAILS
    }

    public LibConfig() {
        this(false, false, false);
    }

    private void a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt <= c()) {
            readInt = c();
        }
        boolean[] zArr = new boolean[readInt];
        parcel.readBooleanArray(zArr);
        this.f407a = zArr[b.CHANNEL_ID.ordinal()];
        this.f408b = zArr[b.RSSI.ordinal()];
        this.f409c = zArr[b.RX_TIMESTAMP.ordinal()];
    }

    private void b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        readBundle.setClassLoader(BundleData.class.getClassLoader());
        this.f410d = (BundleData) readBundle.getParcelable("com.dsi.ant.message.libconfig.bundledata");
    }

    static int c() {
        return b.NUMBER_OF_DETAILS.ordinal();
    }

    private void e(Parcel parcel) {
        boolean[] zArr = new boolean[c()];
        zArr[b.CHANNEL_ID.ordinal()] = this.f407a;
        zArr[b.RSSI.ordinal()] = this.f408b;
        zArr[b.RX_TIMESTAMP.ordinal()] = this.f409c;
        parcel.writeInt(c());
        parcel.writeBooleanArray(zArr);
    }

    private void f(Parcel parcel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.message.libconfig.bundledata", this.f410d);
        parcel.writeBundle(bundle);
    }

    public void d(boolean z2) {
        this.f408b = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LibConfig)) {
            return false;
        }
        LibConfig libConfig = (LibConfig) obj;
        return libConfig.f407a == this.f407a && libConfig.f408b == this.f408b && libConfig.f409c == this.f409c;
    }

    public int hashCode() {
        return ((((217 + (this.f407a ? 1 : 0)) * 31) + (this.f408b ? 1 : 0)) * 31) + (this.f409c ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Lib Config: Enabled extended data:");
        if (this.f407a) {
            sb.append(" -Channel Id");
        }
        if (this.f408b) {
            sb.append(" -RSSI");
        }
        if (this.f409c) {
            sb.append(" -Rx Timestamp");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(2);
        e(parcel);
        if (f.a.g()) {
            f(parcel);
        }
    }

    private LibConfig(Parcel parcel) {
        this.f410d = new BundleData(null);
        int readInt = parcel.readInt();
        a(parcel);
        if (readInt > 1) {
            b(parcel);
        }
    }

    /* synthetic */ LibConfig(Parcel parcel, a aVar) {
        this(parcel);
    }

    public LibConfig(boolean z2, boolean z3, boolean z4) {
        this.f410d = new BundleData(null);
        this.f407a = z2;
        this.f408b = z3;
        this.f409c = z4;
    }
}
