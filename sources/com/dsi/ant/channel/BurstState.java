package com.dsi.ant.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class BurstState implements Parcelable {
    public static final Parcelable.Creator<BurstState> CREATOR = new a();

    /* renamed from: a */
    private boolean f299a;

    /* renamed from: b */
    private boolean f300b;

    /* renamed from: c */
    private BundleData f301c;

    /* loaded from: classes.dex */
    public static final class BundleData implements Parcelable {
        public static final Parcelable.Creator<BundleData> CREATOR = new a();

        /* renamed from: a */
        private int f302a = 10000;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public BundleData createFromParcel(Parcel parcel) {
                parcel.readInt();
                BundleData bundleData = new BundleData();
                bundleData.f302a = parcel.readInt();
                return bundleData;
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
            parcel.writeInt(this.f302a);
        }
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BurstState createFromParcel(Parcel parcel) {
            return new BurstState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BurstState[] newArray(int i2) {
            return new BurstState[i2];
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        PROCESSING,
        TRANSMIT_IN_PROGRESS,
        NUMBER_OF_DETAILS
    }

    private BurstState(Parcel parcel) {
        this.f301c = new BundleData();
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
        this.f299a = zArr[b.PROCESSING.ordinal()];
        this.f300b = zArr[b.TRANSMIT_IN_PROGRESS.ordinal()];
    }

    private void b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        readBundle.setClassLoader(BundleData.class.getClassLoader());
        this.f301c = (BundleData) readBundle.getParcelable("com.dsi.ant.channel.burststate.bundledata");
    }

    static int c() {
        return b.NUMBER_OF_DETAILS.ordinal();
    }

    private void d(Parcel parcel) {
        boolean[] zArr = new boolean[c()];
        zArr[b.PROCESSING.ordinal()] = this.f299a;
        zArr[b.TRANSMIT_IN_PROGRESS.ordinal()] = this.f300b;
        parcel.writeInt(c());
        parcel.writeBooleanArray(zArr);
    }

    private void e(Parcel parcel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.channel.burststate.bundledata", this.f301c);
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
        if (obj == null || !(obj instanceof BurstState)) {
            return false;
        }
        BurstState burstState = (BurstState) obj;
        return burstState.f299a == this.f299a && burstState.f300b == this.f300b && burstState.f301c.f302a == this.f301c.f302a;
    }

    public int hashCode() {
        return ((((217 + (this.f299a ? 1 : 0)) * 31) + (this.f300b ? 1 : 0)) * 31) + this.f301c.f302a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Burst State:");
        sb.append(this.f300b ? " -Transmit In Progress" : " -No Transmit In Progress");
        sb.append(this.f299a ? " -Burst Processing" : " -No Burst Processing");
        sb.append(" -Max Burst Size: ");
        sb.append(this.f301c.f302a);
        sb.append("bytes");
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

    /* synthetic */ BurstState(Parcel parcel, a aVar) {
        this(parcel);
    }
}
