package com.dsi.ant.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import j.j;

/* loaded from: classes.dex */
public final class EventBufferSettings implements Parcelable {

    /* renamed from: a */
    private int f337a;

    /* renamed from: b */
    private BundleData f338b;

    /* renamed from: c */
    public static final EventBufferSettings f335c = new EventBufferSettings(2000);

    /* renamed from: d */
    public static final EventBufferSettings f336d = new EventBufferSettings(0);
    public static final Parcelable.Creator<EventBufferSettings> CREATOR = new a();

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
        public EventBufferSettings createFromParcel(Parcel parcel) {
            return new EventBufferSettings(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public EventBufferSettings[] newArray(int i2) {
            return new EventBufferSettings[i2];
        }
    }

    private EventBufferSettings(int i2) {
        this.f338b = new BundleData(null);
        if (!j.d(i2, 0, 655350)) {
            throw new IllegalArgumentException("Buffer time out of range");
        }
        this.f337a = i2;
    }

    private void a(Parcel parcel) {
        this.f337a = parcel.readInt();
    }

    private void b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        readBundle.setClassLoader(BundleData.class.getClassLoader());
        this.f338b = (BundleData) readBundle.getParcelable("com.dsi.ant.channel.eventbuffersettings.bundledata");
    }

    private void c(Parcel parcel) {
        parcel.writeInt(this.f337a);
    }

    private void d(Parcel parcel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.channel.eventbuffersettings.bundledata", this.f338b);
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
        return obj != null && (obj instanceof EventBufferSettings) && ((EventBufferSettings) obj).f337a == this.f337a;
    }

    public int hashCode() {
        return 217 + this.f337a;
    }

    public String toString() {
        return "Event Buffer Settings: -Buffer Time: " + this.f337a + "ms";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(2);
        c(parcel);
        if (f.a.g()) {
            d(parcel);
        }
    }

    private EventBufferSettings(Parcel parcel) {
        this.f338b = new BundleData(null);
        int readInt = parcel.readInt();
        a(parcel);
        if (readInt > 1) {
            b(parcel);
        }
    }

    /* synthetic */ EventBufferSettings(Parcel parcel, a aVar) {
        this(parcel);
    }
}
