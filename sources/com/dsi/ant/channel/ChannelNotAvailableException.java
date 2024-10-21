package com.dsi.ant.channel;

import android.os.Parcel;
import android.os.Parcelable;
import g.c;

/* loaded from: classes.dex */
public final class ChannelNotAvailableException extends Exception implements Parcelable {
    public static final Parcelable.Creator<ChannelNotAvailableException> CREATOR = new a();

    /* renamed from: a */
    public final c f334a;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ChannelNotAvailableException createFromParcel(Parcel parcel) {
            return new ChannelNotAvailableException(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ChannelNotAvailableException[] newArray(int i2) {
            return new ChannelNotAvailableException[i2];
        }
    }

    private ChannelNotAvailableException(Parcel parcel) {
        this(c.b(parcel.readInt()), parcel.readString());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f334a.d());
        parcel.writeString(getMessage());
    }

    /* synthetic */ ChannelNotAvailableException(Parcel parcel, a aVar) {
        this(parcel);
    }

    public ChannelNotAvailableException(c cVar) {
        super("Could not acquire channel. Reason = " + cVar);
        this.f334a = cVar;
    }

    public ChannelNotAvailableException(c cVar, String str) {
        super(str);
        this.f334a = cVar;
    }
}
