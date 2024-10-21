package com.dsi.ant.plugins.internal.pluginsipc;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class AntPluginDeviceDbProvider {

    /* renamed from: a */
    private static final String f1172a = "AntPluginDeviceDbProvider";

    /* loaded from: classes.dex */
    public static class DeviceDbDeviceInfo implements Parcelable {
        public static final Parcelable.Creator<DeviceDbDeviceInfo> CREATOR = new a();

        /* renamed from: a */
        private int f1173a;

        /* renamed from: b */
        public Long f1174b;

        /* renamed from: c */
        public Long f1175c;

        /* renamed from: d */
        public Integer f1176d;

        /* renamed from: e */
        public String f1177e;

        /* renamed from: f */
        public Boolean f1178f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public DeviceDbDeviceInfo createFromParcel(Parcel parcel) {
                return new DeviceDbDeviceInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public DeviceDbDeviceInfo[] newArray(int i2) {
                return new DeviceDbDeviceInfo[i2];
            }
        }

        public DeviceDbDeviceInfo() {
            this.f1173a = 1;
            this.f1178f = Boolean.FALSE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1173a);
            parcel.writeValue(this.f1174b);
            parcel.writeValue(this.f1175c);
            parcel.writeValue(this.f1176d);
            parcel.writeValue(this.f1177e);
            parcel.writeValue(this.f1178f);
        }

        public DeviceDbDeviceInfo(int i2) {
            this.f1173a = i2;
        }

        public DeviceDbDeviceInfo(Parcel parcel) {
            this.f1173a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPluginDeviceDbProvider.f1172a, "Decoding version " + readInt + " AsyncScanResultDeviceInfo parcel with version 1 parser.");
            }
            this.f1174b = (Long) parcel.readValue(null);
            this.f1175c = (Long) parcel.readValue(null);
            this.f1176d = (Integer) parcel.readValue(null);
            this.f1177e = (String) parcel.readValue(null);
            this.f1178f = (Boolean) parcel.readValue(null);
        }
    }
}
