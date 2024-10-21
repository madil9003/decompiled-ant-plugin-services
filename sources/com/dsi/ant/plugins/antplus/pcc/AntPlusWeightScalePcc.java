package com.dsi.ant.plugins.antplus.pcc;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class AntPlusWeightScalePcc extends com.dsi.ant.plugins.antplus.pccbase.b {
    private static final String K = "AntPlusWeightScalePcc";

    /* loaded from: classes.dex */
    public static class AdvancedMeasurement implements Parcelable {
        public static final Parcelable.Creator<AdvancedMeasurement> CREATOR = new a();

        /* renamed from: a */
        private final int f759a = 1;

        /* renamed from: b */
        public BigDecimal f760b;

        /* renamed from: c */
        public BigDecimal f761c;

        /* renamed from: d */
        public BigDecimal f762d;

        /* renamed from: e */
        public BigDecimal f763e;

        /* renamed from: f */
        public BigDecimal f764f;

        /* renamed from: g */
        public BigDecimal f765g;

        /* renamed from: h */
        public BigDecimal f766h;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public AdvancedMeasurement createFromParcel(Parcel parcel) {
                return new AdvancedMeasurement(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public AdvancedMeasurement[] newArray(int i2) {
                return new AdvancedMeasurement[i2];
            }
        }

        public AdvancedMeasurement() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f759a);
            parcel.writeString(this.f760b.toString());
            parcel.writeString(this.f761c.toString());
            parcel.writeString(this.f762d.toString());
            parcel.writeString(this.f763e.toString());
            parcel.writeString(this.f764f.toString());
            parcel.writeString(this.f765g.toString());
            parcel.writeString(this.f766h.toString());
        }

        public AdvancedMeasurement(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusWeightScalePcc.K, "Decoding version " + readInt + " AdvancedMeasurement parcel with version 1 parser.");
            }
            this.f760b = new BigDecimal(parcel.readString());
            this.f761c = new BigDecimal(parcel.readString());
            this.f762d = new BigDecimal(parcel.readString());
            this.f763e = new BigDecimal(parcel.readString());
            this.f764f = new BigDecimal(parcel.readString());
            this.f765g = new BigDecimal(parcel.readString());
            this.f766h = new BigDecimal(parcel.readString());
        }
    }

    /* loaded from: classes.dex */
    public static class UserProfile implements Parcelable {
        public static final Parcelable.Creator<UserProfile> CREATOR = new a();

        /* renamed from: a */
        private final int f767a = 1;

        /* renamed from: b */
        private final int f768b;

        /* renamed from: c */
        public c f769c;

        /* renamed from: d */
        public int f770d;

        /* renamed from: e */
        public int f771e;

        /* renamed from: f */
        public int f772f;

        /* renamed from: g */
        public boolean f773g;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public UserProfile createFromParcel(Parcel parcel) {
                return new UserProfile(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public UserProfile[] newArray(int i2) {
                return new UserProfile[i2];
            }
        }

        public UserProfile(Parcel parcel) {
            this.f769c = c.UNASSIGNED;
            this.f770d = -1;
            this.f771e = -1;
            this.f772f = -1;
            this.f773g = false;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusWeightScalePcc.K, "Decoding version " + readInt + " UserProfile parcel with version 1 parser.");
            }
            this.f768b = parcel.readInt();
            this.f769c = c.c(parcel.readInt());
            this.f770d = parcel.readInt();
            this.f771e = parcel.readInt();
            this.f772f = parcel.readInt();
            this.f773g = parcel.readByte() != 0;
        }

        public int a() {
            return this.f768b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f767a);
            parcel.writeInt(this.f768b);
            parcel.writeInt(this.f769c.b());
            parcel.writeInt(this.f770d);
            parcel.writeInt(this.f771e);
            parcel.writeInt(this.f772f);
            parcel.writeByte(this.f773g ? (byte) 1 : (byte) 0);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f774a;

        static {
            int[] iArr = new int[c.values().length];
            f774a = iArr;
            try {
                iArr[c.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f774a[c.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f774a[c.UNASSIGNED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        VALID(0),
        COMPUTING(-1),
        INVALID(-2),
        UNRECOGNIZED(-3);


        /* renamed from: a */
        private int f780a;

        b(int i2) {
            this.f780a = i2;
        }

        public int b() {
            return this.f780a;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        FEMALE,
        MALE,
        UNASSIGNED;

        public static c c(int i2) {
            if (i2 == -1) {
                return UNASSIGNED;
            }
            if (i2 == 0) {
                return FEMALE;
            }
            if (i2 == 1) {
                return MALE;
            }
            throw new IllegalArgumentException("Undefined gender value");
        }

        public int b() {
            int i2 = a.f774a[ordinal()];
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Undefined gender value");
        }
    }

    /* loaded from: classes.dex */
    public enum d {
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
        FAIL_PLUGINS_SERVICE_VERSION(-62),
        FAIL_PROFILE_MISMATCH(-1000),
        FAIL_WEIGHT_VALUE_NOT_STABILIZED(-1001);


        /* renamed from: a */
        private int f799a;

        d(int i2) {
            this.f799a = i2;
        }

        public int b() {
            return this.f799a;
        }
    }
}
