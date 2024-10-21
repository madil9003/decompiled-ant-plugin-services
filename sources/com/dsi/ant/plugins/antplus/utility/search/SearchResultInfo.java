package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import j.l;

/* loaded from: classes.dex */
public final class SearchResultInfo implements Parcelable {
    public static final Parcelable.Creator<SearchResultInfo> CREATOR = new a();

    /* renamed from: a */
    public j.b f976a;

    /* renamed from: b */
    public l f977b;

    /* renamed from: c */
    public Bundle f978c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SearchResultInfo createFromParcel(Parcel parcel) {
            i1.b bVar = new i1.b(parcel);
            SearchResultInfo searchResultInfo = new SearchResultInfo();
            byte[] createByteArray = parcel.createByteArray();
            if (createByteArray.length > 0) {
                searchResultInfo.f976a = new j.b(createByteArray, 0);
            }
            if (parcel.readInt() != 0) {
                searchResultInfo.f977b = new l(parcel.readInt(), parcel.readInt(), parcel.readInt());
            }
            searchResultInfo.f978c = parcel.readBundle(SearchResultInfo.class.getClassLoader());
            bVar.a();
            return searchResultInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SearchResultInfo[] newArray(int i2) {
            return new SearchResultInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        i1.a aVar = new i1.a(parcel);
        j.b bVar = this.f976a;
        parcel.writeByteArray(bVar == null ? new byte[0] : bVar.c());
        if (this.f977b != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.f977b.b());
            parcel.writeInt(this.f977b.c());
            parcel.writeInt(this.f977b.d());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeBundle(this.f978c);
        aVar.a();
    }
}
