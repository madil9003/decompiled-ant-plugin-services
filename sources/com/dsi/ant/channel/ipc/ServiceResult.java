package com.dsi.ant.channel.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.dsi.ant.message.ipc.AntMessageParcel;
import g.b;
import j.j;

/* loaded from: classes.dex */
public class ServiceResult implements Parcelable {

    /* renamed from: a */
    private boolean f350a;

    /* renamed from: b */
    private String f351b;

    /* renamed from: c */
    private b f352c;

    /* renamed from: d */
    private AntMessageParcel f353d;

    /* renamed from: e */
    private BundleData f354e;

    /* renamed from: f */
    public static final ServiceResult f347f = new ServiceResult(true);

    /* renamed from: g */
    public static final ServiceResult f348g = new ServiceResult(false);

    /* renamed from: h */
    public static final ServiceResult f349h = new ServiceResult(b.INVALID_REQUEST);
    public static final Parcelable.Creator<ServiceResult> CREATOR = new a();

    /* loaded from: classes.dex */
    public static final class BundleData implements Parcelable {
        public static final Parcelable.Creator<BundleData> CREATOR = new a();

        /* renamed from: a */
        public boolean f355a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public BundleData createFromParcel(Parcel parcel) {
                parcel.readInt();
                BundleData bundleData = new BundleData(null);
                bundleData.f355a = j.a(parcel.readInt());
                return bundleData;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public BundleData[] newArray(int i2) {
                return null;
            }
        }

        private BundleData() {
            this.f355a = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(1);
            parcel.writeInt(j.i(this.f355a));
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
        public ServiceResult createFromParcel(Parcel parcel) {
            return new ServiceResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ServiceResult[] newArray(int i2) {
            return new ServiceResult[i2];
        }
    }

    public ServiceResult(Parcel parcel) {
        this.f350a = false;
        this.f351b = "Unknown";
        this.f352c = b.UNKNOWN;
        this.f353d = null;
        this.f354e = new BundleData(null);
        j(parcel);
    }

    private static String b(b bVar) {
        return "ANT Service responded with failure reason: " + bVar;
    }

    private void c(Parcel parcel) {
        this.f350a = j.a(parcel.readInt());
        this.f351b = parcel.readString();
        this.f352c = b.b(parcel.readInt());
        this.f353d = (AntMessageParcel) parcel.readParcelable(AntMessageParcel.class.getClassLoader());
    }

    private void d(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        readBundle.setClassLoader(BundleData.class.getClassLoader());
        this.f354e = (BundleData) readBundle.getParcelable("com.dsi.ant.channel.ipc.serviceresult.bundledata");
    }

    public static ServiceResult i(Bundle bundle) {
        bundle.setClassLoader(ServiceResult.class.getClassLoader());
        return (ServiceResult) bundle.getParcelable("com.dsi.ant.serviceerror");
    }

    private void l(Parcel parcel, int i2) {
        parcel.writeInt(j.i(this.f350a));
        parcel.writeString(this.f351b);
        parcel.writeInt(this.f352c.d());
        parcel.writeParcelable(this.f353d, i2);
    }

    private void m(Parcel parcel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.channel.ipc.serviceresult.bundledata", this.f354e);
        parcel.writeBundle(bundle);
    }

    public boolean a() {
        return this.f354e.f355a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AntMessageParcel e() {
        return this.f353d;
    }

    public String f() {
        return this.f351b;
    }

    public b g() {
        return this.f352c;
    }

    public boolean h() {
        return this.f350a;
    }

    public void j(Parcel parcel) {
        if (parcel != null) {
            int readInt = parcel.readInt();
            c(parcel);
            if (readInt > 1) {
                d(parcel);
            }
        }
    }

    public void k(Bundle bundle) {
        bundle.putParcelable("com.dsi.ant.serviceerror", this);
    }

    public String toString() {
        return this.f351b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(2);
        l(parcel, i2);
        if (f.a.g()) {
            m(parcel);
        }
    }

    public ServiceResult(b bVar) {
        this.f350a = false;
        this.f351b = "Unknown";
        this.f352c = b.UNKNOWN;
        this.f353d = null;
        this.f354e = new BundleData(null);
        if (b.CHANNEL_RESPONSE == bVar) {
            throw new IllegalArgumentException("Channel Response failure type only valid when the response is provided");
        }
        this.f351b = b(bVar);
        this.f352c = bVar;
        this.f353d = null;
    }

    private ServiceResult(boolean z2) {
        String str;
        this.f350a = false;
        this.f351b = "Unknown";
        this.f352c = b.UNKNOWN;
        this.f353d = null;
        BundleData bundleData = new BundleData(null);
        this.f354e = bundleData;
        bundleData.f355a = z2;
        if (z2) {
            this.f350a = true;
            str = "Success";
        } else {
            str = "Channel Does Not Exist";
        }
        this.f351b = str;
    }
}
