package com.dsi.ant.plugins.antplus.pccbase;

import android.os.Parcel;
import android.os.Parcelable;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;

/* loaded from: classes.dex */
public class MultiDeviceSearch$MultiDeviceSearchResult implements Parcelable {
    public static final Parcelable.Creator<MultiDeviceSearch$MultiDeviceSearchResult> CREATOR = new a();

    /* renamed from: e */
    private static final String f812e = "MultiDeviceSearch$MultiDeviceSearchResult";

    /* renamed from: a */
    protected final boolean f813a;

    /* renamed from: b */
    protected final p0.c f814b;

    /* renamed from: c */
    protected final AntPluginDeviceDbProvider.DeviceDbDeviceInfo f815c;

    /* renamed from: d */
    public final int f816d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MultiDeviceSearch$MultiDeviceSearchResult createFromParcel(Parcel parcel) {
            return new MultiDeviceSearch$MultiDeviceSearchResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MultiDeviceSearch$MultiDeviceSearchResult[] newArray(int i2) {
            return new MultiDeviceSearch$MultiDeviceSearchResult[i2];
        }
    }

    public MultiDeviceSearch$MultiDeviceSearchResult(int i2, p0.c cVar, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, boolean z2) {
        this.f816d = i2;
        this.f813a = z2;
        this.f814b = cVar;
        this.f815c = deviceDbDeviceInfo;
    }

    public int a() {
        return this.f815c.f1176d.intValue();
    }

    public p0.c b() {
        return this.f814b;
    }

    public String c() {
        return this.f815c.f1177e;
    }

    public boolean d() {
        return this.f813a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        i1.a aVar = new i1.a(parcel);
        parcel.writeInt(1);
        parcel.writeInt(this.f816d);
        parcel.writeInt(this.f813a ? 1 : 0);
        parcel.writeInt(this.f814b.b());
        i1.a aVar2 = new i1.a(parcel);
        parcel.writeParcelable(this.f815c, i2);
        aVar2.a();
        aVar.a();
    }

    public MultiDeviceSearch$MultiDeviceSearchResult(Parcel parcel) {
        i1.b bVar = new i1.b(parcel);
        int readInt = parcel.readInt();
        if (readInt > 1) {
            h1.a.j(f812e, "Loading DeviceInfo with ipcVersion " + readInt + " as a version 1 parcel.");
        }
        this.f816d = parcel.readInt();
        this.f813a = parcel.readInt() != 0;
        this.f814b = p0.c.c(parcel.readInt());
        i1.b bVar2 = new i1.b(parcel);
        this.f815c = (AntPluginDeviceDbProvider.DeviceDbDeviceInfo) parcel.readParcelable(AntPluginDeviceDbProvider.DeviceDbDeviceInfo.class.getClassLoader());
        bVar2.a();
        bVar.a();
    }
}
