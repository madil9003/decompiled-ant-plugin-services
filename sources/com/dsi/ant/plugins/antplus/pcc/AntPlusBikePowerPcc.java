package com.dsi.ant.plugins.antplus.pcc;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class AntPlusBikePowerPcc extends com.dsi.ant.plugins.antplus.pccbase.b {
    private static final String K = "AntPlusBikePowerPcc";

    /* loaded from: classes.dex */
    public static class CalibrationMessage implements Parcelable {
        public static final Parcelable.Creator<CalibrationMessage> CREATOR = new a();

        /* renamed from: a */
        private final int f524a = 1;

        /* renamed from: b */
        public final b f525b;

        /* renamed from: c */
        public final Integer f526c;

        /* renamed from: d */
        public final Integer f527d;

        /* renamed from: e */
        public final byte[] f528e;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CalibrationMessage createFromParcel(Parcel parcel) {
                return new CalibrationMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CalibrationMessage[] newArray(int i2) {
                return new CalibrationMessage[i2];
            }
        }

        public CalibrationMessage(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusBikePowerPcc.K, "Decoding version " + readInt + " CalibrationMessage parcel with version 1 parser.");
            }
            this.f525b = b.c(parcel.readInt());
            this.f526c = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f527d = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f528e = (byte[]) parcel.readValue(byte[].class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f524a);
            parcel.writeInt(this.f525b.b());
            parcel.writeValue(this.f526c);
            parcel.writeValue(this.f527d);
            parcel.writeValue(this.f528e);
        }

        public CalibrationMessage(b bVar, Integer num, Integer num2, byte[] bArr) {
            this.f525b = bVar;
            this.f526c = num;
            this.f527d = num2;
            this.f528e = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class CrankParameters implements Parcelable {
        public static final Parcelable.Creator<CrankParameters> CREATOR = new a();

        /* renamed from: a */
        private final int f529a = 1;

        /* renamed from: b */
        private final BigDecimal f530b;

        /* renamed from: c */
        private final d f531c;

        /* renamed from: d */
        private final h f532d;

        /* renamed from: e */
        private final g f533e;

        /* renamed from: f */
        private final e f534f;

        /* renamed from: g */
        private final boolean f535g;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CrankParameters createFromParcel(Parcel parcel) {
                return new CrankParameters(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CrankParameters[] newArray(int i2) {
                return new CrankParameters[i2];
            }
        }

        public CrankParameters(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusBikePowerPcc.K, "Decoding version " + readInt + " CrankParameters parcel with version 1 parser.");
            }
            this.f530b = new BigDecimal(parcel.readString());
            this.f531c = d.c(parcel.readInt());
            this.f532d = h.c(parcel.readInt());
            this.f533e = g.c(parcel.readInt());
            this.f534f = e.c(parcel.readInt());
            this.f535g = parcel.readByte() != 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f529a);
            parcel.writeString(this.f530b.toString());
            parcel.writeInt(this.f531c.b());
            parcel.writeInt(this.f532d.b());
            parcel.writeInt(this.f533e.b());
            parcel.writeInt(this.f534f.b());
            parcel.writeByte(this.f535g ? (byte) 1 : (byte) 0);
        }

        public CrankParameters(BigDecimal bigDecimal, d dVar, h hVar, g gVar, e eVar, boolean z2) {
            this.f530b = bigDecimal;
            this.f531c = dVar;
            this.f532d = hVar;
            this.f533e = gVar;
            this.f534f = eVar;
            this.f535g = z2;
        }
    }

    /* loaded from: classes.dex */
    public enum a {
        OFF(0),
        ON(1),
        NOT_SUPPORTED(255),
        INVALID(-1),
        UNKNOWN(-2),
        UNRECOGNIZED(-3);


        /* renamed from: a */
        private int f543a;

        a(int i2) {
            this.f543a = i2;
        }

        public int b() {
            return this.f543a;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        GENERAL_CALIBRATION_SUCCESS(172),
        GENERAL_CALIBRATION_FAIL(175),
        CTF_MESSAGE(16),
        CTF_ZERO_OFFSET(4097),
        CTF_SLOPE_ACK(1092610),
        CTF_SERIAL_NUMBER_ACK(1092611),
        CAPABILITIES(18),
        CUSTOM_CALIBRATION_RESPONSE(187),
        CUSTOM_CALIBRATION_UPDATE_SUCCESS(189),
        INVALID(-1),
        UNRECOGNIZED(-2);


        /* renamed from: a */
        private int f556a;

        b(int i2) {
            this.f556a = i2;
        }

        public static b c(int i2) {
            for (b bVar : values()) {
                if (bVar.b() == i2) {
                    return bVar;
                }
            }
            b bVar2 = UNRECOGNIZED;
            bVar2.f556a = i2;
            return bVar2;
        }

        public int b() {
            return this.f556a;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        AUTO_CRANK_LENGTH(254),
        MANUAL_CRANK_LENGTH(65280),
        INVALID(255);


        /* renamed from: a */
        private final int f561a;

        c(int i2) {
            this.f561a = i2;
        }

        public static c c(int i2) {
            return i2 != 254 ? i2 != 65280 ? INVALID : MANUAL_CRANK_LENGTH : AUTO_CRANK_LENGTH;
        }

        public int b() {
            return this.f561a;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        INVALID_CRANK_LENGTH,
        DEFAULT_USED,
        SET_MANUALLY,
        SET_AUTOMATICALLY;

        public static d c(int i2) {
            if (i2 == 0) {
                return INVALID_CRANK_LENGTH;
            }
            if (i2 == 1) {
                return DEFAULT_USED;
            }
            if (i2 == 2) {
                return SET_MANUALLY;
            }
            if (i2 == 3) {
                return SET_AUTOMATICALLY;
            }
            throw new IllegalArgumentException("Undefined Crank Length Status");
        }

        public int b() {
            return ordinal();
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        UNDEFINED,
        CUSTOM_CALIBRATION_NOT_REQUIRED,
        CUSTOM_CALIBRATION_REQUIRED;

        public static e c(int i2) {
            if (i2 == 0) {
                return UNDEFINED;
            }
            if (i2 == 1) {
                return CUSTOM_CALIBRATION_NOT_REQUIRED;
            }
            if (i2 == 2) {
                return CUSTOM_CALIBRATION_REQUIRED;
            }
            if (i2 == 3) {
                return UNDEFINED;
            }
            throw new IllegalArgumentException("Undefined Custom Calibration Status");
        }

        public int b() {
            return ordinal();
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        POWER_ONLY_DATA(16),
        WHEEL_TORQUE_DATA(17),
        CRANK_TORQUE_DATA(18),
        CTF_DATA(32),
        COAST_OR_STOP_DETECTED(65536),
        INITIAL_VALUE_POWER_ONLY_DATA(65296),
        INITIAL_VALUE_WHEEL_TORQUE_DATA(65297),
        INITIAL_VALUE_CRANK_TORQUE_DATA(65298),
        INITIAL_VALUE_CTF_DATA(65312),
        INVALID(-1),
        INVALID_CTF_CAL_REQ(-2),
        UNRECOGNIZED(-3);


        /* renamed from: a */
        private int f584a;

        f(int i2) {
            this.f584a = i2;
        }

        public static f c(int i2) {
            for (f fVar : values()) {
                if (fVar.b() == i2) {
                    return fVar;
                }
            }
            f fVar2 = UNRECOGNIZED;
            fVar2.f584a = i2;
            return fVar2;
        }

        public int b() {
            return this.f584a;
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        UNDEFINED,
        LEFT_SENSOR_PRESENT,
        RIGHT_SENSOR_PRESENT,
        LEFT_AND_RIGHT_SENSOR_PRESENT;

        public static g c(int i2) {
            if (i2 == 0) {
                return UNDEFINED;
            }
            if (i2 == 1) {
                return LEFT_SENSOR_PRESENT;
            }
            if (i2 == 2) {
                return RIGHT_SENSOR_PRESENT;
            }
            if (i2 == 3) {
                return LEFT_AND_RIGHT_SENSOR_PRESENT;
            }
            throw new IllegalArgumentException("Undefined Sensor Availability Status");
        }

        public int b() {
            return ordinal();
        }
    }

    /* loaded from: classes.dex */
    public enum h {
        UNDEFINED,
        MISMATCH_RIGHT_SENSOR_OLDER,
        MISMATCH_LEFT_SENSOR_OLDER,
        SW_MATCHES;

        public static h c(int i2) {
            if (i2 == 0) {
                return UNDEFINED;
            }
            if (i2 == 1) {
                return MISMATCH_RIGHT_SENSOR_OLDER;
            }
            if (i2 == 2) {
                return MISMATCH_LEFT_SENSOR_OLDER;
            }
            if (i2 == 3) {
                return SW_MATCHES;
            }
            throw new IllegalArgumentException("Undefined Sensor Software Mismatch Status");
        }

        public int b() {
            return ordinal();
        }
    }
}
