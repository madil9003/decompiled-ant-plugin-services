package com.dsi.ant.plugins.antplus.pcc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.GregorianCalendar;
import k1.i;
import k1.j1;
import k1.k;

/* loaded from: classes.dex */
public abstract class AntPlusBloodPressurePcc extends com.dsi.ant.plugins.antplus.pccbase.a {
    private static final String E = "AntPlusBloodPressurePcc";

    /* loaded from: classes.dex */
    public static class BloodPressureMeasurement implements Parcelable {
        public static final Parcelable.Creator<BloodPressureMeasurement> CREATOR = new a();

        /* renamed from: a */
        private final int f595a = 1;

        /* renamed from: b */
        public GregorianCalendar f596b;

        /* renamed from: c */
        public Integer f597c;

        /* renamed from: d */
        public Integer f598d;

        /* renamed from: e */
        public Integer f599e;

        /* renamed from: f */
        public Integer f600f;

        /* renamed from: g */
        public Integer f601g;

        /* renamed from: h */
        public Integer f602h;

        /* renamed from: i */
        public Integer f603i;

        /* renamed from: j */
        public j1 f604j;

        /* renamed from: k */
        public k f605k;

        /* renamed from: l */
        public Integer f606l;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public BloodPressureMeasurement createFromParcel(Parcel parcel) {
                return new BloodPressureMeasurement(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public BloodPressureMeasurement[] newArray(int i2) {
                return new BloodPressureMeasurement[i2];
            }
        }

        public BloodPressureMeasurement(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusBloodPressurePcc.E, "Decoding version " + readInt + " AdvancedMeasurement parcel with version 1 parser.");
            }
            this.f596b = (GregorianCalendar) parcel.readValue(null);
            this.f597c = (Integer) parcel.readValue(null);
            this.f598d = (Integer) parcel.readValue(null);
            this.f599e = (Integer) parcel.readValue(null);
            this.f600f = (Integer) parcel.readValue(null);
            this.f601g = (Integer) parcel.readValue(null);
            this.f602h = (Integer) parcel.readValue(null);
            this.f603i = (Integer) parcel.readValue(null);
            int readInt2 = parcel.readInt();
            this.f604j = readInt2 == Integer.MIN_VALUE ? null : j1.values()[readInt2];
            int readInt3 = parcel.readInt();
            this.f605k = readInt3 == Integer.MIN_VALUE ? null : k.values()[readInt3];
            this.f606l = (Integer) parcel.readValue(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f595a);
            parcel.writeValue(this.f596b);
            parcel.writeValue(this.f597c);
            parcel.writeValue(this.f598d);
            parcel.writeValue(this.f599e);
            parcel.writeValue(this.f600f);
            parcel.writeValue(this.f601g);
            parcel.writeValue(this.f602h);
            parcel.writeValue(this.f603i);
            j1 j1Var = this.f604j;
            parcel.writeInt(j1Var == null ? Integer.MIN_VALUE : j1Var.ordinal());
            k kVar = this.f605k;
            parcel.writeInt(kVar != null ? kVar.ordinal() : Integer.MIN_VALUE);
            parcel.writeValue(this.f606l);
        }

        public BloodPressureMeasurement(i iVar) {
            if (iVar.e() == null) {
                this.f596b = null;
            } else {
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                this.f596b = gregorianCalendar;
                gregorianCalendar.setTime(iVar.e().c());
            }
            this.f597c = iVar.D();
            this.f598d = iVar.v();
            this.f599e = iVar.B();
            this.f600f = iVar.y();
            this.f601g = iVar.A();
            this.f602h = iVar.z();
            Short w2 = iVar.w();
            this.f603i = w2 != null ? Integer.valueOf(w2.intValue()) : null;
            this.f604j = iVar.x();
            this.f605k = iVar.C();
            this.f606l = iVar.E();
        }
    }

    /* loaded from: classes.dex */
    public enum a {
        FINISHED(100),
        PROGRESS_SYNCING_WITH_DEVICE(1000),
        PROGRESS_MONITORING(1500),
        UNRECOGNIZED(-1);


        /* renamed from: a */
        private int f612a;

        a(int i2) {
            this.f612a = i2;
        }

        public int b() {
            return this.f612a;
        }
    }
}
