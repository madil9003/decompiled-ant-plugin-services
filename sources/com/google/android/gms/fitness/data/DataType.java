package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import q1.f;

/* loaded from: classes.dex */
public final class DataType extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final DataType A;
    public static final DataType B;
    public static final DataType C;
    public static final Parcelable.Creator<DataType> CREATOR = new b();
    public static final DataType D;
    public static final DataType E;
    public static final DataType F;
    public static final DataType G;
    public static final DataType H;
    public static final DataType I;
    public static final DataType J;
    public static final DataType K;
    public static final DataType L;
    public static final DataType M;
    public static final DataType N;
    public static final DataType O;
    public static final DataType P;
    public static final DataType Q;
    public static final DataType R;
    public static final DataType S;
    public static final DataType T;
    public static final DataType U;
    public static final DataType V;
    public static final DataType W;
    public static final DataType X;
    public static final DataType Y;
    public static final DataType Z;

    /* renamed from: a0 */
    public static final DataType f1459a0;

    /* renamed from: b0 */
    public static final DataType f1460b0;

    /* renamed from: c0 */
    public static final DataType f1461c0;

    /* renamed from: d0 */
    public static final DataType f1462d0;

    /* renamed from: e */
    public static final DataType f1463e;

    /* renamed from: e0 */
    public static final DataType f1464e0;

    /* renamed from: f */
    public static final DataType f1465f;

    /* renamed from: f0 */
    public static final DataType f1466f0;

    /* renamed from: g */
    public static final DataType f1467g;

    /* renamed from: g0 */
    public static final DataType f1468g0;

    /* renamed from: h */
    public static final DataType f1469h;

    /* renamed from: h0 */
    public static final DataType f1470h0;

    /* renamed from: i */
    public static final DataType f1471i;

    /* renamed from: i0 */
    public static final DataType f1472i0;

    /* renamed from: j */
    public static final DataType f1473j;

    /* renamed from: j0 */
    public static final DataType f1474j0;

    /* renamed from: k */
    public static final DataType f1475k;

    /* renamed from: k0 */
    public static final DataType f1476k0;

    /* renamed from: l */
    public static final DataType f1477l;

    /* renamed from: l0 */
    public static final DataType f1478l0;

    /* renamed from: m */
    public static final DataType f1479m;

    /* renamed from: n */
    public static final DataType f1480n;

    /* renamed from: o */
    public static final DataType f1481o;

    /* renamed from: p */
    public static final DataType f1482p;

    /* renamed from: q */
    public static final DataType f1483q;

    /* renamed from: r */
    public static final DataType f1484r;

    /* renamed from: s */
    public static final DataType f1485s;

    /* renamed from: t */
    public static final DataType f1486t;

    /* renamed from: u */
    public static final DataType f1487u;

    /* renamed from: v */
    public static final DataType f1488v;

    /* renamed from: w */
    public static final DataType f1489w;

    /* renamed from: x */
    public static final DataType f1490x;

    /* renamed from: y */
    public static final DataType f1491y;

    /* renamed from: z */
    public static final DataType f1492z;

    /* renamed from: a */
    private final String f1493a;

    /* renamed from: b */
    private final List f1494b;

    /* renamed from: c */
    private final String f1495c;

    /* renamed from: d */
    private final String f1496d;

    static {
        Field field = Field.f1511g;
        DataType dataType = new DataType("com.google.step_count.delta", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field);
        f1463e = dataType;
        f1465f = new DataType("com.google.step_count.cumulative", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field);
        Field field2 = Field.f1536t;
        f1467g = new DataType("com.google.step_count.cadence", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field2);
        T = new DataType("com.google.internal.goal", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.W);
        Field field3 = Field.f1505d;
        f1469h = new DataType("com.google.activity.segment", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field3);
        f1471i = new DataType("com.google.sleep.segment", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.f1507e);
        Field field4 = Field.f1538v;
        DataType dataType2 = new DataType("com.google.calories.expended", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field4);
        f1473j = dataType2;
        f1475k = new DataType("com.google.calories.bmr", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field4);
        f1477l = new DataType("com.google.power.sample", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1539w);
        U = new DataType("com.google.sensor.events", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.Y, Field.Z, Field.f1502a0);
        f1479m = new DataType("com.google.heart_rate.bpm", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.f1517j);
        V = new DataType("com.google.respiratory_rate", 1, "https://www.googleapis.com/auth/fitness.respiratory_rate.read", "https://www.googleapis.com/auth/fitness.respiratory_rate.write", Field.V);
        Field field5 = Field.f1519k;
        Field field6 = Field.f1521l;
        Field field7 = Field.f1523m;
        Field field8 = Field.f1525n;
        f1480n = new DataType("com.google.location.sample", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, field8);
        f1481o = new DataType("com.google.location.track", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, field8);
        DataType dataType3 = new DataType("com.google.distance.delta", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.f1527o);
        f1482p = dataType3;
        f1483q = new DataType("com.google.speed", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.f1535s);
        Field field9 = Field.f1537u;
        f1484r = new DataType("com.google.cycling.wheel_revolution.cumulative", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field9);
        f1485s = new DataType("com.google.cycling.wheel_revolution.rpm", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field2);
        f1486t = new DataType("com.google.cycling.pedaling.cumulative", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field9);
        f1487u = new DataType("com.google.cycling.pedaling.cadence", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field2);
        f1488v = new DataType("com.google.height", 1, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.f1529p);
        f1489w = new DataType("com.google.weight", 1, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.f1531q);
        f1490x = new DataType("com.google.body.fat.percentage", 1, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.f1533r);
        Field field10 = Field.A;
        Field field11 = Field.f1541y;
        f1491y = new DataType("com.google.nutrition", 1, "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", field10, field11, Field.f1542z);
        DataType dataType4 = new DataType("com.google.hydration", 1, "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", Field.f1540x);
        f1492z = dataType4;
        A = new DataType("com.google.activity.exercise", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.B, Field.C, Field.S, Field.E, Field.D);
        Field field12 = Field.f1515i;
        DataType dataType5 = new DataType("com.google.active_minutes", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field12);
        B = dataType5;
        C = dataType5;
        W = new DataType("com.google.device_on_body", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1504c0);
        D = new DataType("com.google.activity.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field3, field12, Field.F);
        Field field13 = Field.G;
        Field field14 = Field.H;
        Field field15 = Field.I;
        E = new DataType("com.google.calories.bmr.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field13, field14, field15);
        F = dataType;
        G = dataType3;
        H = dataType2;
        Field field16 = Field.O;
        I = new DataType("com.google.heart_minutes", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field16);
        J = new DataType("com.google.heart_minutes.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field16, field12);
        K = new DataType("com.google.heart_rate.summary", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", field13, field14, field15);
        L = new DataType("com.google.location.bounding_box", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.J, Field.K, Field.L, Field.M);
        M = new DataType("com.google.power.summary", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field13, field14, field15);
        N = new DataType("com.google.speed.summary", 2, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field13, field14, field15);
        O = new DataType("com.google.body.fat.percentage.summary", 2, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        P = new DataType("com.google.weight.summary", 2, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        Q = new DataType("com.google.height.summary", 2, "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        R = new DataType("com.google.nutrition.summary", 2, "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", field10, field11);
        S = dataType4;
        X = new DataType("com.google.activity.samples", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1503b0);
        Y = new DataType("com.google.internal.sleep_attributes", 2, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.f1506d0);
        Z = new DataType("com.google.internal.sleep_schedule", 1, "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.f1508e0);
        f1459a0 = new DataType("com.google.internal.paced_walking_attributes", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1510f0);
        f1460b0 = new DataType("com.google.time_zone_change", 1, "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.f1512g0);
        f1461c0 = new DataType("com.google.internal.met", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1514h0);
        f1462d0 = new DataType("com.google.internal.internal_device_temperature", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.f1516i0);
        f1464e0 = new DataType("com.google.internal.skin_temperature", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.f1518j0);
        Field field17 = Field.Q;
        f1466f0 = new DataType("com.google.internal.custom_heart_rate_zone", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.f1520k0, field17, field17);
        f1468g0 = new DataType("com.google.internal.active_minutes_combined", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1522l0, Field.f1524m0, Field.f1526n0);
        f1470h0 = new DataType("com.google.internal.sedentary_time", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1528o0);
        f1472i0 = new DataType("com.google.internal.custom_max_heart_rate", 1, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.R);
        f1474j0 = new DataType("com.google.internal.momentary_stress_algorithm", 1, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.f1530p0);
        f1476k0 = new DataType("com.google.internal.magnetic_field_presence", 2, "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.f1532q0);
        f1478l0 = new DataType("com.google.internal.momentary_stress_algorithm_windows", 2, "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.f1534r0);
    }

    public DataType(String str, int i2, String str2, String str3, Field... fieldArr) {
        this.f1493a = str;
        this.f1494b = Collections.unmodifiableList(Arrays.asList(fieldArr));
        this.f1495c = str2;
        this.f1496d = str3;
    }

    public List a() {
        return this.f1494b;
    }

    public String b() {
        return this.f1493a;
    }

    public int c(Field field) {
        int indexOf = this.f1494b.indexOf(field);
        f.c(indexOf >= 0, "%s not a field of %s", field, this);
        return indexOf;
    }

    public final String d() {
        boolean startsWith = this.f1493a.startsWith("com.google.");
        String str = this.f1493a;
        return startsWith ? str.substring(11) : str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataType)) {
            return false;
        }
        DataType dataType = (DataType) obj;
        return this.f1493a.equals(dataType.f1493a) && this.f1494b.equals(dataType.f1494b);
    }

    public int hashCode() {
        return this.f1493a.hashCode();
    }

    public String toString() {
        return String.format("DataType{%s%s}", this.f1493a, this.f1494b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.n(parcel, 1, b(), false);
        r1.b.q(parcel, 2, a(), false);
        r1.b.n(parcel, 3, this.f1495c, false);
        r1.b.n(parcel, 4, this.f1496d, false);
        r1.b.b(parcel, a3);
    }

    public DataType(String str, List list, String str2, String str3) {
        this.f1493a = str;
        this.f1494b = Collections.unmodifiableList(list);
        this.f1495c = str2;
        this.f1496d = str3;
    }
}
