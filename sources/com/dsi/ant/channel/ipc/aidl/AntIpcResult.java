package com.dsi.ant.channel.ipc.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AntIpcResult implements Parcelable {
    public static final Parcelable.Creator<AntIpcResult> CREATOR = new a();

    /* renamed from: a */
    private BundleData f390a;

    /* loaded from: classes.dex */
    public static final class BundleData implements Parcelable {
        public static final Parcelable.Creator<BundleData> CREATOR = new a();

        /* renamed from: a */
        public Bundle f391a;

        /* renamed from: b */
        public ArrayList f392b;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public BundleData createFromParcel(Parcel parcel) {
                parcel.readInt();
                BundleData bundleData = new BundleData(null);
                bundleData.f391a = parcel.readBundle();
                bundleData.f392b = parcel.createBinderArrayList();
                return bundleData;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public BundleData[] newArray(int i2) {
                return new BundleData[i2];
            }
        }

        private BundleData() {
            this.f391a = null;
            this.f392b = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(1);
            parcel.writeBundle(this.f391a);
            parcel.writeBinderList(this.f392b);
        }

        /* synthetic */ BundleData(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AntIpcResult createFromParcel(Parcel parcel) {
            return new AntIpcResult(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AntIpcResult[] newArray(int i2) {
            return new AntIpcResult[i2];
        }
    }

    private AntIpcResult(Parcel parcel) {
        this.f390a = new BundleData(null);
        Bundle readBundle = parcel.readBundle();
        readBundle.setClassLoader(BundleData.class.getClassLoader());
        this.f390a = (BundleData) readBundle.getParcelable("com.dsi.ant.channel.antipcresult.bundledata");
    }

    public ArrayList a() {
        return this.f390a.f392b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.channel.antipcresult.bundledata", this.f390a);
        parcel.writeBundle(bundle);
    }

    /* synthetic */ AntIpcResult(Parcel parcel, a aVar) {
        this(parcel);
    }
}
