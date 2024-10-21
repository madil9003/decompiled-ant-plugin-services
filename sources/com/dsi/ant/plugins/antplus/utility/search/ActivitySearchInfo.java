package com.dsi.ant.plugins.antplus.utility.search;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.dsi.ant.channel.AntChannel;

/* loaded from: classes.dex */
public abstract class ActivitySearchInfo extends Binder implements Parcelable {
    public static final Parcelable.Creator<ActivitySearchInfo> CREATOR = new a();

    /* renamed from: a */
    public AntChannel f900a;

    /* renamed from: b */
    public e f901b;

    /* renamed from: c */
    public String f902c;

    /* renamed from: d */
    public f f903d;

    /* renamed from: e */
    public int f904e;

    /* renamed from: f */
    public boolean f905f = false;

    /* renamed from: g */
    public b f906g;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivitySearchInfo createFromParcel(Parcel parcel) {
            return (ActivitySearchInfo) parcel.readStrongBinder();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ActivitySearchInfo[] newArray(int i2) {
            return new ActivitySearchInfo[i2];
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public boolean a(SearchResultInfo searchResultInfo, SearchResultInfo searchResultInfo2) {
        return searchResultInfo.f976a.equals(searchResultInfo2.f976a);
    }

    public boolean b(SearchResultInfo searchResultInfo, Bundle bundle) {
        return searchResultInfo.f976a.a() == bundle.getInt("int_ChannelDeviceId");
    }

    public Bundle c(SearchResultInfo searchResultInfo, Bundle bundle) {
        return bundle;
    }

    public abstract e d(SearchResultInfo searchResultInfo, Bundle bundle);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e(SearchResultInfo searchResultInfo, String str) {
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this);
    }
}
