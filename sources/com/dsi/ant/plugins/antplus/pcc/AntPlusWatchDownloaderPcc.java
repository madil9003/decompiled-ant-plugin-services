package com.dsi.ant.plugins.antplus.pcc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class AntPlusWatchDownloaderPcc extends com.dsi.ant.plugins.antplus.pccbase.a {
    private static final String E = "AntPlusWatchDownloaderPcc";

    /* loaded from: classes.dex */
    public static class DeviceInfo implements Parcelable {
        public static final Parcelable.Creator<DeviceInfo> CREATOR = new a();

        /* renamed from: a */
        private final int f748a;

        /* renamed from: b */
        protected UUID f749b;

        /* renamed from: c */
        protected String f750c;

        /* renamed from: d */
        protected int f751d;

        /* renamed from: e */
        protected int f752e;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public DeviceInfo createFromParcel(Parcel parcel) {
                return new DeviceInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public DeviceInfo[] newArray(int i2) {
                return new DeviceInfo[i2];
            }
        }

        private DeviceInfo(Parcel parcel) {
            this.f748a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusWatchDownloaderPcc.E, "Decoding version " + readInt + " DeviceInfo parcel with version 1 parser.");
            }
            this.f749b = (UUID) parcel.readSerializable();
            this.f750c = parcel.readString();
            this.f751d = parcel.readInt();
            this.f752e = parcel.readInt();
        }

        public int a() {
            return this.f752e;
        }

        public int b() {
            return this.f751d;
        }

        public UUID c() {
            return this.f749b;
        }

        public String d() {
            return this.f750c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof DeviceInfo) && ((DeviceInfo) obj).f749b.equals(this.f749b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f748a);
            parcel.writeSerializable(this.f749b);
            parcel.writeString(this.f750c);
            parcel.writeInt(this.f751d);
            parcel.writeInt(this.f752e);
        }

        /* synthetic */ DeviceInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public DeviceInfo(UUID uuid, int i2, int i3, String str) {
            this.f748a = 1;
            this.f749b = uuid;
            this.f750c = str;
            this.f751d = i2;
            this.f752e = i3;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        NO_CHANGE(0),
        DEVICE_ADDED_TO_LIST(10),
        DEVICE_REMOVED_FROM_LIST(20),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f758a;

        b(int i2) {
            this.f758a = i2;
        }

        public int b() {
            return this.f758a;
        }
    }
}
