package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.e;

/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: a */
    final int f1194a;

    /* renamed from: b */
    private final int f1195b;

    /* renamed from: c */
    private final PendingIntent f1196c;

    /* renamed from: d */
    private final String f1197d;

    /* renamed from: e */
    public static final ConnectionResult f1193e = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new f();

    public ConnectionResult(int i2) {
        this(i2, null, null);
    }

    public static String f(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public int a() {
        return this.f1195b;
    }

    public String b() {
        return this.f1197d;
    }

    public PendingIntent c() {
        return this.f1196c;
    }

    public boolean d() {
        return (this.f1195b == 0 || this.f1196c == null) ? false : true;
    }

    public boolean e() {
        return this.f1195b == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f1195b == connectionResult.f1195b && q1.e.a(this.f1196c, connectionResult.f1196c) && q1.e.a(this.f1197d, connectionResult.f1197d);
    }

    public int hashCode() {
        return q1.e.b(Integer.valueOf(this.f1195b), this.f1196c, this.f1197d);
    }

    public String toString() {
        e.a c3 = q1.e.c(this);
        c3.a("statusCode", f(this.f1195b));
        c3.a("resolution", this.f1196c);
        c3.a("message", this.f1197d);
        return c3.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1194a);
        r1.b.j(parcel, 2, a());
        r1.b.m(parcel, 3, c(), i2, false);
        r1.b.n(parcel, 4, b(), false);
        r1.b.b(parcel, a3);
    }

    public ConnectionResult(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f1194a = i2;
        this.f1195b = i3;
        this.f1196c = pendingIntent;
        this.f1197d = str;
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}
