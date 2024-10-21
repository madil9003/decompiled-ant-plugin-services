package com.dsi.ant.plugins.antplus.pccbase;

import android.os.Parcel;
import android.os.Parcelable;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class AsyncScanController {

    /* renamed from: a */
    private static final String f807a = "AsyncScanController";

    /* loaded from: classes.dex */
    public static class AsyncScanResultDeviceInfo implements Parcelable {
        public static final Parcelable.Creator<AsyncScanResultDeviceInfo> CREATOR = new a();

        /* renamed from: a */
        private final int f808a = 1;

        /* renamed from: b */
        public final UUID f809b;

        /* renamed from: c */
        private final boolean f810c;

        /* renamed from: d */
        private final AntPluginDeviceDbProvider.DeviceDbDeviceInfo f811d;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public AsyncScanResultDeviceInfo createFromParcel(Parcel parcel) {
                return new AsyncScanResultDeviceInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public AsyncScanResultDeviceInfo[] newArray(int i2) {
                return new AsyncScanResultDeviceInfo[i2];
            }
        }

        public AsyncScanResultDeviceInfo(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AsyncScanController.f807a, "Decoding version " + readInt + " AsyncScanResultDeviceInfo parcel with version 1 parser.");
            }
            this.f809b = (UUID) parcel.readValue(null);
            this.f810c = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f811d = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) parcel.readParcelable(getClass().getClassLoader());
        }

        public int a() {
            return this.f811d.f1176d.intValue();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f808a);
            parcel.writeValue(this.f809b);
            parcel.writeValue(Boolean.valueOf(this.f810c));
            parcel.writeParcelable(this.f811d, i2);
        }

        public AsyncScanResultDeviceInfo(UUID uuid, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, boolean z2) {
            this.f809b = uuid;
            this.f811d = deviceDbDeviceInfo;
            this.f810c = z2;
        }
    }
}
