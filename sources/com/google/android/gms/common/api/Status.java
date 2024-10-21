package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import o1.c;
import q1.e;

/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: a */
    final int f1216a;

    /* renamed from: b */
    private final int f1217b;

    /* renamed from: c */
    private final String f1218c;

    /* renamed from: d */
    private final PendingIntent f1219d;

    /* renamed from: e */
    private final ConnectionResult f1220e;

    /* renamed from: f */
    public static final Status f1209f = new Status(0);

    /* renamed from: g */
    public static final Status f1210g = new Status(14);

    /* renamed from: h */
    public static final Status f1211h = new Status(8);

    /* renamed from: i */
    public static final Status f1212i = new Status(15);

    /* renamed from: j */
    public static final Status f1213j = new Status(16);

    /* renamed from: l */
    public static final Status f1215l = new Status(17);

    /* renamed from: k */
    public static final Status f1214k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new b();

    public Status(int i2) {
        this(i2, (String) null);
    }

    public ConnectionResult a() {
        return this.f1220e;
    }

    public int b() {
        return this.f1217b;
    }

    public String c() {
        return this.f1218c;
    }

    public boolean d() {
        return this.f1219d != null;
    }

    public final String e() {
        String str = this.f1218c;
        return str != null ? str : c.a(this.f1217b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f1216a == status.f1216a && this.f1217b == status.f1217b && e.a(this.f1218c, status.f1218c) && e.a(this.f1219d, status.f1219d) && e.a(this.f1220e, status.f1220e);
    }

    public int hashCode() {
        return e.b(Integer.valueOf(this.f1216a), Integer.valueOf(this.f1217b), this.f1218c, this.f1219d, this.f1220e);
    }

    public String toString() {
        e.a c3 = e.c(this);
        c3.a("statusCode", e());
        c3.a("resolution", this.f1219d);
        return c3.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, b());
        r1.b.n(parcel, 2, c(), false);
        r1.b.m(parcel, 3, this.f1219d, i2, false);
        r1.b.m(parcel, 4, a(), i2, false);
        r1.b.j(parcel, 1000, this.f1216a);
        r1.b.b(parcel, a3);
    }

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this(i2, i3, str, pendingIntent, null);
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f1216a = i2;
        this.f1217b = i3;
        this.f1218c = str;
        this.f1219d = pendingIntent;
        this.f1220e = connectionResult;
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public Status(ConnectionResult connectionResult, String str, int i2) {
        this(1, i2, str, connectionResult.c(), connectionResult);
    }
}
