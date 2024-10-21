package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, getServiceRequest.f1329a);
        r1.b.j(parcel, 2, getServiceRequest.f1330b);
        r1.b.j(parcel, 3, getServiceRequest.f1331c);
        r1.b.n(parcel, 4, getServiceRequest.f1332d, false);
        r1.b.i(parcel, 5, getServiceRequest.f1333e, false);
        r1.b.p(parcel, 6, getServiceRequest.f1334f, i2, false);
        r1.b.e(parcel, 7, getServiceRequest.f1335g, false);
        r1.b.m(parcel, 8, getServiceRequest.f1336h, i2, false);
        r1.b.p(parcel, 10, getServiceRequest.f1337i, i2, false);
        r1.b.p(parcel, 11, getServiceRequest.f1338j, i2, false);
        r1.b.c(parcel, 12, getServiceRequest.f1339k);
        r1.b.j(parcel, 13, getServiceRequest.f1340l);
        r1.b.c(parcel, 14, getServiceRequest.f1341m);
        r1.b.n(parcel, 15, getServiceRequest.a(), false);
        r1.b.b(parcel, a3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u2 = r1.a.u(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        boolean z3 = false;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String str2 = null;
        while (parcel.dataPosition() < u2) {
            int o2 = r1.a.o(parcel);
            switch (r1.a.k(o2)) {
                case 1:
                    i2 = r1.a.q(parcel, o2);
                    break;
                case 2:
                    i3 = r1.a.q(parcel, o2);
                    break;
                case 3:
                    i4 = r1.a.q(parcel, o2);
                    break;
                case 4:
                    str = r1.a.f(parcel, o2);
                    break;
                case 5:
                    iBinder = r1.a.p(parcel, o2);
                    break;
                case 6:
                    scopeArr = (Scope[]) r1.a.h(parcel, o2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = r1.a.a(parcel, o2);
                    break;
                case 8:
                    account = (Account) r1.a.e(parcel, o2, Account.CREATOR);
                    break;
                case 9:
                default:
                    r1.a.t(parcel, o2);
                    break;
                case 10:
                    featureArr = (Feature[]) r1.a.h(parcel, o2, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) r1.a.h(parcel, o2, Feature.CREATOR);
                    break;
                case 12:
                    z2 = r1.a.l(parcel, o2);
                    break;
                case 13:
                    i5 = r1.a.q(parcel, o2);
                    break;
                case 14:
                    z3 = r1.a.l(parcel, o2);
                    break;
                case 15:
                    str2 = r1.a.f(parcel, o2);
                    break;
            }
        }
        r1.a.j(parcel, u2);
        return new GetServiceRequest(i2, i3, i4, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z2, i5, z3, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
