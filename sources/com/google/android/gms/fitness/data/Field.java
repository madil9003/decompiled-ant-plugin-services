package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import x1.f;

/* loaded from: classes.dex */
public final class Field extends AbstractSafeParcelable {

    /* renamed from: a */
    private final String f1543a;

    /* renamed from: b */
    private final int f1544b;

    /* renamed from: c */
    private final Boolean f1545c;
    public static final Parcelable.Creator<Field> CREATOR = new f();

    /* renamed from: d */
    public static final Field f1505d = g("activity");

    /* renamed from: e */
    public static final Field f1507e = g("sleep_segment_type");

    /* renamed from: f */
    public static final Field f1509f = e("confidence");

    /* renamed from: g */
    public static final Field f1511g = g("steps");

    /* renamed from: h */
    public static final Field f1513h = e("step_length");

    /* renamed from: i */
    public static final Field f1515i = g("duration");
    public static final Field S = i("duration");
    public static final Field T = f("activity_duration.ascending");
    public static final Field U = f("activity_duration.descending");

    /* renamed from: j */
    public static final Field f1517j = e("bpm");
    public static final Field V = e("respiratory_rate");

    /* renamed from: k */
    public static final Field f1519k = e("latitude");

    /* renamed from: l */
    public static final Field f1521l = e("longitude");

    /* renamed from: m */
    public static final Field f1523m = e("accuracy");

    /* renamed from: n */
    public static final Field f1525n = h("altitude");

    /* renamed from: o */
    public static final Field f1527o = e("distance");

    /* renamed from: p */
    public static final Field f1529p = e("height");

    /* renamed from: q */
    public static final Field f1531q = e("weight");

    /* renamed from: r */
    public static final Field f1533r = e("percentage");

    /* renamed from: s */
    public static final Field f1535s = e("speed");

    /* renamed from: t */
    public static final Field f1536t = e("rpm");
    public static final Field W = d("google.android.fitness.GoalV2");
    public static final Field X = d("google.android.fitness.Device");

    /* renamed from: u */
    public static final Field f1537u = g("revolutions");

    /* renamed from: v */
    public static final Field f1538v = e("calories");

    /* renamed from: w */
    public static final Field f1539w = e("watts");

    /* renamed from: x */
    public static final Field f1540x = e("volume");

    /* renamed from: y */
    public static final Field f1541y = i("meal_type");

    /* renamed from: z */
    public static final Field f1542z = new Field("food_item", 3, Boolean.TRUE);
    public static final Field A = f("nutrients");
    public static final Field B = j("exercise");
    public static final Field C = i("repetitions");
    public static final Field D = h("resistance");
    public static final Field E = i("resistance_type");
    public static final Field F = g("num_segments");
    public static final Field G = e("average");
    public static final Field H = e("max");
    public static final Field I = e("min");
    public static final Field J = e("low_latitude");
    public static final Field K = e("low_longitude");
    public static final Field L = e("high_latitude");
    public static final Field M = e("high_longitude");
    public static final Field N = g("occurrences");
    public static final Field Y = g("sensor_type");
    public static final Field Z = new Field("timestamps", 5, null);

    /* renamed from: a0 */
    public static final Field f1502a0 = new Field("sensor_values", 6, null);
    public static final Field O = e("intensity");

    /* renamed from: b0 */
    public static final Field f1503b0 = f("activity_confidence");

    /* renamed from: c0 */
    public static final Field f1504c0 = e("probability");

    /* renamed from: d0 */
    public static final Field f1506d0 = d("google.android.fitness.SleepAttributes");

    /* renamed from: e0 */
    public static final Field f1508e0 = d("google.android.fitness.SleepSchedule");
    public static final Field P = e("circumference");

    /* renamed from: f0 */
    public static final Field f1510f0 = d("google.android.fitness.PacedWalkingAttributes");

    /* renamed from: g0 */
    public static final Field f1512g0 = j("zone_id");

    /* renamed from: h0 */
    public static final Field f1514h0 = e("met");

    /* renamed from: i0 */
    public static final Field f1516i0 = e("internal_device_temperature");

    /* renamed from: j0 */
    public static final Field f1518j0 = e("skin_temperature");

    /* renamed from: k0 */
    public static final Field f1520k0 = g("custom_heart_rate_zone_status");
    public static final Field Q = g("min_int");
    public static final Field R = g("max_int");

    /* renamed from: l0 */
    public static final Field f1522l0 = i("lightly_active_duration");

    /* renamed from: m0 */
    public static final Field f1524m0 = i("moderately_active_duration");

    /* renamed from: n0 */
    public static final Field f1526n0 = i("very_active_duration");

    /* renamed from: o0 */
    public static final Field f1528o0 = d("google.android.fitness.SedentaryTime");

    /* renamed from: p0 */
    public static final Field f1530p0 = d("google.android.fitness.MomentaryStressAlgorithm");

    /* renamed from: q0 */
    public static final Field f1532q0 = g("magnet_presence");

    /* renamed from: r0 */
    public static final Field f1534r0 = d("google.android.fitness.MomentaryStressAlgorithmWindows");

    public Field(String str, int i2, Boolean bool) {
        this.f1543a = (String) q1.f.g(str);
        this.f1544b = i2;
        this.f1545c = bool;
    }

    public static Field d(String str) {
        return new Field(str, 7, null);
    }

    public static Field e(String str) {
        return new Field(str, 2, null);
    }

    public static Field f(String str) {
        return new Field(str, 4, null);
    }

    public static Field g(String str) {
        return new Field(str, 1, null);
    }

    public static Field h(String str) {
        return new Field(str, 2, Boolean.TRUE);
    }

    public static Field i(String str) {
        return new Field(str, 1, Boolean.TRUE);
    }

    public static Field j(String str) {
        return new Field(str, 3, null);
    }

    public int a() {
        return this.f1544b;
    }

    public String b() {
        return this.f1543a;
    }

    public Boolean c() {
        return this.f1545c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        return this.f1543a.equals(field.f1543a) && this.f1544b == field.f1544b;
    }

    public int hashCode() {
        return this.f1543a.hashCode();
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.f1543a;
        objArr[1] = this.f1544b == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.n(parcel, 1, b(), false);
        r1.b.j(parcel, 2, a());
        r1.b.d(parcel, 3, c(), false);
        r1.b.b(parcel, a3);
    }
}
