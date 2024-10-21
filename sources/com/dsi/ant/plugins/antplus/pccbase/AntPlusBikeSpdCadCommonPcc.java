package com.dsi.ant.plugins.antplus.pccbase;

import android.os.Parcel;
import android.os.Parcelable;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;

/* loaded from: classes.dex */
public abstract class AntPlusBikeSpdCadCommonPcc extends c {
    private static final String F = "AntPlusBikeSpdCadCommonPcc";

    /* loaded from: classes.dex */
    public static class MultiDeviceSearchSpdCadResult extends MultiDeviceSearch$MultiDeviceSearchResult {
        public static final Parcelable.Creator<MultiDeviceSearchSpdCadResult> CREATOR = new a();

        /* renamed from: f */
        protected final AntPluginDeviceDbProvider.DeviceDbDeviceInfo f806f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MultiDeviceSearchSpdCadResult createFromParcel(Parcel parcel) {
                return new MultiDeviceSearchSpdCadResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public MultiDeviceSearchSpdCadResult[] newArray(int i2) {
                return new MultiDeviceSearchSpdCadResult[i2];
            }
        }

        public MultiDeviceSearchSpdCadResult(int i2, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo2, boolean z2) {
            super(i2, p0.c.BIKE_SPDCAD, deviceDbDeviceInfo, z2);
            this.f806f = deviceDbDeviceInfo2;
        }

        @Override // com.dsi.ant.plugins.antplus.pccbase.MultiDeviceSearch$MultiDeviceSearchResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            i1.a aVar = new i1.a(parcel);
            parcel.writeInt(1);
            i1.a aVar2 = new i1.a(parcel);
            parcel.writeParcelable(this.f806f, i2);
            aVar2.a();
            aVar.a();
        }

        protected MultiDeviceSearchSpdCadResult(Parcel parcel) {
            super(parcel);
            i1.b bVar = new i1.b(parcel);
            int readInt = parcel.readInt();
            i1.b bVar2 = new i1.b(parcel);
            this.f806f = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) parcel.readParcelable(AntPluginDeviceDbProvider.DeviceDbDeviceInfo.class.getClassLoader());
            bVar2.a();
            if (readInt > 1) {
                h1.a.f(AntPlusBikeSpdCadCommonPcc.F, "Decoding " + MultiDeviceSearchSpdCadResult.class.getSimpleName() + " version " + readInt + " using version 1 decoder");
            }
            bVar.a();
        }
    }
}
