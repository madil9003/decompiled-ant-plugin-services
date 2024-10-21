package com.dsi.ant.plugins.antplus.pcc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public abstract class AntPlusGeocachePcc extends com.dsi.ant.plugins.antplus.pccbase.a {
    private static final String E = "AntPlusGeocachePcc";

    /* loaded from: classes.dex */
    public static class GeocacheDeviceData implements Parcelable {
        public static final Parcelable.Creator<GeocacheDeviceData> CREATOR = new a();

        /* renamed from: a */
        private final int f707a;

        /* renamed from: b */
        public int f708b;

        /* renamed from: c */
        public int f709c;

        /* renamed from: d */
        public int f710d;

        /* renamed from: e */
        public int f711e;

        /* renamed from: f */
        public int f712f;

        /* renamed from: g */
        public long f713g;

        /* renamed from: h */
        public long f714h;

        /* renamed from: i */
        public BigDecimal f715i;

        /* renamed from: j */
        public p0.a f716j;

        /* renamed from: k */
        public int f717k;

        /* renamed from: l */
        public ProgrammableGeocacheDeviceData f718l;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GeocacheDeviceData createFromParcel(Parcel parcel) {
                return new GeocacheDeviceData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public GeocacheDeviceData[] newArray(int i2) {
                return new GeocacheDeviceData[i2];
            }
        }

        public GeocacheDeviceData() {
            this.f716j = p0.a.INVALID;
            this.f718l = new ProgrammableGeocacheDeviceData();
            this.f707a = 1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f707a);
            parcel.writeInt(this.f708b);
            parcel.writeInt(this.f709c);
            parcel.writeInt(this.f710d);
            parcel.writeInt(this.f711e);
            parcel.writeInt(this.f712f);
            parcel.writeLong(this.f713g);
            parcel.writeLong(this.f714h);
            parcel.writeValue(this.f715i);
            parcel.writeInt(this.f716j.b());
            parcel.writeInt(this.f717k);
            Bundle bundle = new Bundle();
            bundle.putParcelable("parcelable_ProgrammableGeocacheDeviceData", this.f718l);
            parcel.writeBundle(bundle);
        }

        public GeocacheDeviceData(Parcel parcel) {
            this.f716j = p0.a.INVALID;
            this.f718l = new ProgrammableGeocacheDeviceData();
            this.f707a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusGeocachePcc.E, "Decoding version " + readInt + " GeocacheDeviceData parcel with version 1 parser.");
            }
            this.f708b = parcel.readInt();
            this.f709c = parcel.readInt();
            this.f710d = parcel.readInt();
            this.f711e = parcel.readInt();
            this.f712f = parcel.readInt();
            this.f713g = parcel.readLong();
            this.f714h = parcel.readLong();
            this.f715i = (BigDecimal) parcel.readValue(null);
            this.f716j = p0.a.c(parcel.readInt());
            this.f717k = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            readBundle.setClassLoader(getClass().getClassLoader());
            this.f718l = (ProgrammableGeocacheDeviceData) readBundle.getParcelable("parcelable_ProgrammableGeocacheDeviceData");
        }
    }

    /* loaded from: classes.dex */
    public static class ProgrammableGeocacheDeviceData implements Parcelable {
        public static final Parcelable.Creator<ProgrammableGeocacheDeviceData> CREATOR = new a();

        /* renamed from: a */
        private final int f719a;

        /* renamed from: b */
        public String f720b;

        /* renamed from: c */
        public Long f721c;

        /* renamed from: d */
        public BigDecimal f722d;

        /* renamed from: e */
        public BigDecimal f723e;

        /* renamed from: f */
        public String f724f;

        /* renamed from: g */
        public GregorianCalendar f725g;

        /* renamed from: h */
        public Integer f726h;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ProgrammableGeocacheDeviceData createFromParcel(Parcel parcel) {
                return new ProgrammableGeocacheDeviceData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ProgrammableGeocacheDeviceData[] newArray(int i2) {
                return new ProgrammableGeocacheDeviceData[i2];
            }
        }

        public ProgrammableGeocacheDeviceData() {
            this.f720b = null;
            this.f721c = null;
            this.f722d = null;
            this.f723e = null;
            this.f724f = null;
            this.f725g = null;
            this.f726h = null;
            this.f719a = 1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f719a);
            parcel.writeString(this.f720b);
            parcel.writeValue(this.f721c);
            parcel.writeValue(this.f722d);
            parcel.writeValue(this.f723e);
            parcel.writeString(this.f724f);
            parcel.writeValue(this.f725g);
            parcel.writeValue(this.f726h);
        }

        public ProgrammableGeocacheDeviceData(Parcel parcel) {
            this.f720b = null;
            this.f721c = null;
            this.f722d = null;
            this.f723e = null;
            this.f724f = null;
            this.f725g = null;
            this.f726h = null;
            this.f719a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusGeocachePcc.E, "Decoding version " + readInt + " ProgrammableGeocacheDeviceData parcel with version 1 parser.");
            }
            this.f720b = parcel.readString();
            this.f721c = (Long) parcel.readValue(null);
            this.f722d = (BigDecimal) parcel.readValue(null);
            this.f723e = (BigDecimal) parcel.readValue(null);
            this.f724f = parcel.readString();
            this.f725g = (GregorianCalendar) parcel.readValue(null);
            this.f726h = (Integer) parcel.readValue(null);
        }
    }

    /* loaded from: classes.dex */
    public enum a {
        NO_CHANGE(0),
        ADDED_TO_LIST(10),
        REMOVED_FROM_LIST(20),
        PROGRAMMED(100),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f733a;

        a(int i2) {
            this.f733a = i2;
        }

        public int b() {
            return this.f733a;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        SUCCESS(0),
        FAIL_CANCELLED(-2),
        UNRECOGNIZED(-3),
        FAIL_OTHER(-10),
        FAIL_ALREADY_BUSY_EXTERNAL(-20),
        FAIL_DEVICE_COMMUNICATION_FAILURE(-40),
        FAIL_DEVICE_TRANSMISSION_LOST(-41),
        FAIL_BAD_PARAMS(-50),
        FAIL_NO_PERMISSION(-60),
        FAIL_NOT_SUPPORTED(-61),
        FAIL_DEVICE_NOT_IN_LIST(10030),
        FAIL_DEVICE_DATA_NOT_DOWNLOADED(10070);


        /* renamed from: a */
        private int f747a;

        b(int i2) {
            this.f747a = i2;
        }

        public int b() {
            return this.f747a;
        }
    }
}
