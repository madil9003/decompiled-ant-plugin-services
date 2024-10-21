package com.dsi.ant.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BackgroundScanState implements Parcelable {
    public static final Parcelable.Creator<BackgroundScanState> CREATOR = new a();

    /* renamed from: a */
    private boolean f292a;

    /* renamed from: b */
    private boolean f293b;

    /* renamed from: c */
    private BundleData f294c;

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
                return new BundleData();
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public BundleData[] newArray(int i2) {
                return null;
            }
        }

        BundleData() {
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
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BackgroundScanState createFromParcel(Parcel parcel) {
            return new BackgroundScanState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BackgroundScanState[] newArray(int i2) {
            return new BackgroundScanState[i2];
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        CONFIGURED,
        IN_PROGRESS,
        NUMBER_OF_DETAILS
    }

    private BackgroundScanState(Parcel parcel) {
        this.f294c = new BundleData();
        int readInt = parcel.readInt();
        a(parcel);
        if (readInt > 1) {
            b(parcel);
        }
    }

    private void a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt <= c()) {
            readInt = c();
        }
        boolean[] zArr = new boolean[readInt];
        parcel.readBooleanArray(zArr);
        this.f292a = zArr[b.CONFIGURED.ordinal()];
        this.f293b = zArr[b.IN_PROGRESS.ordinal()];
    }

    private void b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        readBundle.setClassLoader(BundleData.class.getClassLoader());
        this.f294c = (BundleData) readBundle.getParcelable("com.dsi.ant.channel.backgroundscanstate.bundledata");
    }

    static int c() {
        return b.NUMBER_OF_DETAILS.ordinal();
    }

    private void d(Parcel parcel) {
        boolean[] zArr = new boolean[c()];
        zArr[b.CONFIGURED.ordinal()] = this.f292a;
        zArr[b.IN_PROGRESS.ordinal()] = this.f293b;
        parcel.writeInt(c());
        parcel.writeBooleanArray(zArr);
    }

    private void e(Parcel parcel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.channel.backgroundscanstate.bundledata", this.f294c);
        parcel.writeBundle(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BackgroundScanState)) {
            return false;
        }
        BackgroundScanState backgroundScanState = (BackgroundScanState) obj;
        return backgroundScanState.f292a == this.f292a && backgroundScanState.f293b == this.f293b;
    }

    public int hashCode() {
        return ((217 + (this.f292a ? 1 : 0)) * 31) + (this.f293b ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Background Scan State:");
        sb.append(this.f293b ? " Scan In Progress" : this.f292a ? " Channel Configured" : " No Background Scan Channels");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(2);
        d(parcel);
        if (f.a.g()) {
            e(parcel);
        }
    }

    /* synthetic */ BackgroundScanState(Parcel parcel, a aVar) {
        this(parcel);
    }
}
