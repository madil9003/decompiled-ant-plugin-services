package com.dsi.ant.plugins.antplus.pcc;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AntPlusFitnessEquipmentPcc extends com.dsi.ant.plugins.antplus.pccbase.b {
    private static final String K = "AntPlusFitnessEquipmentPcc";

    /* loaded from: classes.dex */
    public static class CalibrationInProgress implements Parcelable {
        public static final Parcelable.Creator<CalibrationInProgress> CREATOR = new a();

        /* renamed from: a */
        private final int f613a;

        /* renamed from: b */
        public BigDecimal f614b;

        /* renamed from: c */
        public BigDecimal f615c;

        /* renamed from: d */
        public Integer f616d;

        /* renamed from: e */
        public boolean f617e;

        /* renamed from: f */
        public boolean f618f;

        /* renamed from: g */
        public c f619g;

        /* renamed from: h */
        public b f620h;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CalibrationInProgress createFromParcel(Parcel parcel) {
                return new CalibrationInProgress(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CalibrationInProgress[] newArray(int i2) {
                return new CalibrationInProgress[i2];
            }
        }

        /* loaded from: classes.dex */
        public enum b {
            NOT_APPLICABLE(0),
            CURRENT_SPEED_TOO_LOW(1),
            CURRENT_SPEED_OK(2),
            UNRECOGNIZED(-1);


            /* renamed from: a */
            private int f626a;

            b(int i2) {
                this.f626a = i2;
            }

            public static b c(int i2) {
                for (b bVar : values()) {
                    if (bVar.b() == i2) {
                        return bVar;
                    }
                }
                b bVar2 = UNRECOGNIZED;
                bVar2.f626a = i2;
                return bVar2;
            }

            public int b() {
                return this.f626a;
            }
        }

        /* loaded from: classes.dex */
        public enum c {
            NOT_APPLICABLE(0),
            CURRENT_TEMPERATURE_TOO_LOW(1),
            CURRENT_TEMPERATURE_OK(2),
            CURRENT_TEMPERATURE_TOO_HIGH(3),
            UNRECOGNIZED(-1);


            /* renamed from: a */
            private int f633a;

            c(int i2) {
                this.f633a = i2;
            }

            public static c c(int i2) {
                for (c cVar : values()) {
                    if (cVar.b() == i2) {
                        return cVar;
                    }
                }
                c cVar2 = UNRECOGNIZED;
                cVar2.f633a = i2;
                return cVar2;
            }

            public int b() {
                return this.f633a;
            }
        }

        public CalibrationInProgress() {
            this.f613a = 1;
            this.f617e = false;
            this.f618f = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f613a);
            parcel.writeValue(this.f614b);
            parcel.writeValue(this.f615c);
            parcel.writeValue(this.f616d);
            parcel.writeByte(this.f617e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f618f ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f619g.b());
            parcel.writeInt(this.f620h.b());
        }

        public CalibrationInProgress(Parcel parcel) {
            this.f613a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusFitnessEquipmentPcc.K, "Decoding version " + readInt + " CalibrationInProgress parcel with version 1 parser.");
            }
            this.f614b = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f615c = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f616d = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f617e = parcel.readByte() != 0;
            this.f618f = parcel.readByte() != 0;
            this.f619g = c.c(parcel.readInt());
            this.f620h = b.c(parcel.readInt());
        }
    }

    /* loaded from: classes.dex */
    public static class CalibrationResponse implements Parcelable {
        public static final Parcelable.Creator<CalibrationResponse> CREATOR = new a();

        /* renamed from: a */
        private final int f634a;

        /* renamed from: b */
        public BigDecimal f635b;

        /* renamed from: c */
        public Integer f636c;

        /* renamed from: d */
        public Integer f637d;

        /* renamed from: e */
        public boolean f638e;

        /* renamed from: f */
        public boolean f639f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CalibrationResponse createFromParcel(Parcel parcel) {
                return new CalibrationResponse(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CalibrationResponse[] newArray(int i2) {
                return new CalibrationResponse[i2];
            }
        }

        public CalibrationResponse() {
            this.f634a = 1;
            this.f638e = false;
            this.f639f = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f634a);
            parcel.writeValue(this.f635b);
            parcel.writeValue(this.f636c);
            parcel.writeValue(this.f637d);
            parcel.writeByte(this.f638e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f639f ? (byte) 1 : (byte) 0);
        }

        public CalibrationResponse(Parcel parcel) {
            this.f634a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusFitnessEquipmentPcc.K, "Decoding version " + readInt + " CalibrationResponse parcel with version 1 parser.");
            }
            this.f635b = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f636c = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f637d = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f638e = parcel.readByte() != 0;
            this.f639f = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes.dex */
    public static class Capabilities implements Parcelable {
        public static final Parcelable.Creator<Capabilities> CREATOR = new a();

        /* renamed from: a */
        private final int f640a = 1;

        /* renamed from: b */
        public Integer f641b;

        /* renamed from: c */
        public boolean f642c;

        /* renamed from: d */
        public boolean f643d;

        /* renamed from: e */
        public boolean f644e;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Capabilities createFromParcel(Parcel parcel) {
                return new Capabilities(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Capabilities[] newArray(int i2) {
                return new Capabilities[i2];
            }
        }

        public Capabilities() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f640a);
            parcel.writeValue(this.f641b);
            parcel.writeByte(this.f642c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f643d ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f644e ? (byte) 1 : (byte) 0);
        }

        public Capabilities(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusFitnessEquipmentPcc.K, "Decoding version " + readInt + " Capabilities parcel with version 1 parser.");
            }
            this.f641b = (Integer) parcel.readValue(null);
            this.f642c = parcel.readByte() != 0;
            this.f643d = parcel.readByte() != 0;
            this.f644e = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes.dex */
    public static class CommandStatus implements Parcelable {
        public static final Parcelable.Creator<CommandStatus> CREATOR = new a();

        /* renamed from: a */
        private final int f645a;

        /* renamed from: b */
        public b f646b;

        /* renamed from: c */
        public int f647c;

        /* renamed from: d */
        public c f648d;

        /* renamed from: e */
        public byte[] f649e;

        /* renamed from: f */
        public BigDecimal f650f;

        /* renamed from: g */
        public BigDecimal f651g;

        /* renamed from: h */
        public BigDecimal f652h;

        /* renamed from: i */
        public Integer f653i;

        /* renamed from: j */
        public BigDecimal f654j;

        /* renamed from: k */
        public BigDecimal f655k;

        /* renamed from: l */
        public BigDecimal f656l;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CommandStatus createFromParcel(Parcel parcel) {
                return new CommandStatus(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CommandStatus[] newArray(int i2) {
                return new CommandStatus[i2];
            }
        }

        /* loaded from: classes.dex */
        public enum b {
            BASIC_RESISTANCE(48),
            TARGET_POWER(49),
            WIND_RESISTANCE(50),
            TRACK_RESISTANCE(51),
            NO_CONTROL_PAGE_RECEIVED(255),
            UNRECOGNIZED(-1);


            /* renamed from: a */
            private int f664a;

            b(int i2) {
                this.f664a = i2;
            }

            public static b c(int i2) {
                for (b bVar : values()) {
                    if (bVar.b() == i2) {
                        return bVar;
                    }
                }
                b bVar2 = UNRECOGNIZED;
                bVar2.f664a = i2;
                return bVar2;
            }

            public int b() {
                return this.f664a;
            }
        }

        /* loaded from: classes.dex */
        public enum c {
            PASS(0),
            FAIL(1),
            NOT_SUPPORTED(2),
            REJECTED(3),
            PENDING(4),
            UNINITIALIZED(255),
            UNRECOGNIZED(-1);


            /* renamed from: a */
            private int f673a;

            c(int i2) {
                this.f673a = i2;
            }

            public static c c(int i2) {
                for (c cVar : values()) {
                    if (cVar.b() == i2) {
                        return cVar;
                    }
                }
                c cVar2 = UNRECOGNIZED;
                cVar2.f673a = i2;
                return cVar2;
            }

            public int b() {
                return this.f673a;
            }
        }

        public CommandStatus() {
            this.f645a = 1;
            this.f647c = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f645a);
            parcel.writeInt(this.f646b.b());
            parcel.writeInt(this.f647c);
            parcel.writeInt(this.f648d.b());
            parcel.writeValue(this.f649e);
            parcel.writeValue(this.f650f);
            parcel.writeValue(this.f651g);
            parcel.writeValue(this.f652h);
            parcel.writeValue(this.f653i);
            parcel.writeValue(this.f654j);
            parcel.writeValue(this.f655k);
            parcel.writeValue(this.f656l);
        }

        public CommandStatus(Parcel parcel) {
            this.f645a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusFitnessEquipmentPcc.K, "Decoding version " + readInt + " CommandStatus parcel with version 1 parser.");
            }
            this.f646b = b.c(parcel.readInt());
            this.f647c = parcel.readInt();
            this.f648d = c.c(parcel.readInt());
            this.f649e = (byte[]) parcel.readValue(byte[].class.getClassLoader());
            this.f650f = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f651g = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f652h = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f653i = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f654j = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f655k = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f656l = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
        }
    }

    /* loaded from: classes.dex */
    public static class UserConfiguration implements Parcelable {
        public static final Parcelable.Creator<UserConfiguration> CREATOR = new a();

        /* renamed from: a */
        private final int f674a = 1;

        /* renamed from: b */
        public BigDecimal f675b;

        /* renamed from: c */
        public BigDecimal f676c;

        /* renamed from: d */
        public BigDecimal f677d;

        /* renamed from: e */
        public BigDecimal f678e;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public UserConfiguration createFromParcel(Parcel parcel) {
                return new UserConfiguration(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public UserConfiguration[] newArray(int i2) {
                return new UserConfiguration[i2];
            }
        }

        public UserConfiguration() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f674a);
            parcel.writeValue(this.f675b);
            parcel.writeValue(this.f676c);
            parcel.writeValue(this.f677d);
            parcel.writeValue(this.f678e);
        }

        public UserConfiguration(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusFitnessEquipmentPcc.K, "Decoding version " + readInt + " UserConfiguration parcel with version 1 parser.");
            }
            this.f675b = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f676c = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f677d = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
            this.f678e = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
        }
    }

    /* loaded from: classes.dex */
    public enum a {
        GENERAL(16),
        TREADMILL(19),
        ELLIPTICAL(20),
        BIKE(21),
        ROWER(22),
        CLIMBER(23),
        NORDICSKIER(24),
        TRAINER(25),
        UNKNOWN(-1),
        UNRECOGNIZED(-2);


        /* renamed from: a */
        private int f690a;

        a(int i2) {
            this.f690a = i2;
        }

        public int b() {
            return this.f690a;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        TRAINER_DATA(25),
        TRAINER_TORQUE_DATA(26),
        INITIAL_VALUE_TRAINER_DATA(65305),
        INITIAL_VALUE_TRAINER_TORQUE_DATA(65306),
        COAST_OR_STOP_DETECTED(65536),
        UNRECOGNIZED(-3);


        /* renamed from: a */
        private int f698a;

        b(int i2) {
            this.f698a = i2;
        }

        public static b c(int i2) {
            for (b bVar : values()) {
                if (bVar.b() == i2) {
                    return bVar;
                }
            }
            b bVar2 = UNRECOGNIZED;
            bVar2.f698a = i2;
            return bVar2;
        }

        public int b() {
            return this.f698a;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        UNRECOGNIZED_FLAG_PRESENT(1),
        BICYCLE_POWER_CALIBRATION_REQUIRED(2),
        RESISTANCE_CALIBRATION_REQUIRED(4),
        USER_CONFIGURATION_REQUIRED(8),
        MAXIMUM_POWER_LIMIT_REACHED(16),
        MINIMUM_POWER_LIMIT_REACHED(32);


        /* renamed from: a */
        private final long f706a;

        c(long j2) {
            this.f706a = j2;
        }

        public static long b(EnumSet enumSet) {
            Iterator it = enumSet.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2 |= ((c) it.next()).c();
            }
            return j2;
        }

        public long c() {
            return this.f706a;
        }
    }
}
