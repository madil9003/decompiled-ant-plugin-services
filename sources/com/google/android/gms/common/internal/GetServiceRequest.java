package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new s();

    /* renamed from: a */
    final int f1329a;

    /* renamed from: b */
    final int f1330b;

    /* renamed from: c */
    int f1331c;

    /* renamed from: d */
    String f1332d;

    /* renamed from: e */
    IBinder f1333e;

    /* renamed from: f */
    Scope[] f1334f;

    /* renamed from: g */
    Bundle f1335g;

    /* renamed from: h */
    Account f1336h;

    /* renamed from: i */
    Feature[] f1337i;

    /* renamed from: j */
    Feature[] f1338j;

    /* renamed from: k */
    boolean f1339k;

    /* renamed from: l */
    int f1340l;

    /* renamed from: m */
    boolean f1341m;

    /* renamed from: n */
    private String f1342n;

    public GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z2, int i5, boolean z3, String str2) {
        this.f1329a = i2;
        this.f1330b = i3;
        this.f1331c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f1332d = "com.google.android.gms";
        } else {
            this.f1332d = str;
        }
        if (i2 < 2) {
            this.f1336h = iBinder != null ? a.j(e.a.c(iBinder)) : null;
        } else {
            this.f1333e = iBinder;
            this.f1336h = account;
        }
        this.f1334f = scopeArr;
        this.f1335g = bundle;
        this.f1337i = featureArr;
        this.f1338j = featureArr2;
        this.f1339k = z2;
        this.f1340l = i5;
        this.f1341m = z3;
        this.f1342n = str2;
    }

    public final String a() {
        return this.f1342n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        s.a(this, parcel, i2);
    }

    public GetServiceRequest(int i2, String str) {
        this.f1329a = 6;
        this.f1331c = com.google.android.gms.common.b.f1315a;
        this.f1330b = i2;
        this.f1339k = true;
        this.f1342n = str;
    }
}
