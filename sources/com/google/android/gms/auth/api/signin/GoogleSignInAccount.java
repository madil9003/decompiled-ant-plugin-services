package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import q1.f;
import u1.b;
import u1.c;

/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: n */
    public static b f1179n = c.a();

    /* renamed from: a */
    final int f1180a;

    /* renamed from: b */
    private String f1181b;

    /* renamed from: c */
    private String f1182c;

    /* renamed from: d */
    private String f1183d;

    /* renamed from: e */
    private String f1184e;

    /* renamed from: f */
    private Uri f1185f;

    /* renamed from: g */
    private String f1186g;

    /* renamed from: h */
    private long f1187h;

    /* renamed from: i */
    private String f1188i;

    /* renamed from: j */
    List f1189j;

    /* renamed from: k */
    private String f1190k;

    /* renamed from: l */
    private String f1191l;

    /* renamed from: m */
    private Set f1192m = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List list, String str7, String str8) {
        this.f1180a = i2;
        this.f1181b = str;
        this.f1182c = str2;
        this.f1183d = str3;
        this.f1184e = str4;
        this.f1185f = uri;
        this.f1186g = str5;
        this.f1187h = j2;
        this.f1188i = str6;
        this.f1189j = list;
        this.f1190k = str7;
        this.f1191l = str8;
    }

    public static GoogleSignInAccount j(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l2.longValue(), f.e(str7), new ArrayList((Collection) f.g(set)), str5, str6);
    }

    public static GoogleSignInAccount k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount j2 = j(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        j2.f1186g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return j2;
    }

    public String a() {
        return this.f1184e;
    }

    public String b() {
        return this.f1183d;
    }

    public String c() {
        return this.f1191l;
    }

    public String d() {
        return this.f1190k;
    }

    public String e() {
        return this.f1181b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f1188i.equals(this.f1188i) && googleSignInAccount.h().equals(h());
    }

    public String f() {
        return this.f1182c;
    }

    public Uri g() {
        return this.f1185f;
    }

    public Set h() {
        HashSet hashSet = new HashSet(this.f1189j);
        hashSet.addAll(this.f1192m);
        return hashSet;
    }

    public int hashCode() {
        return ((this.f1188i.hashCode() + 527) * 31) + h().hashCode();
    }

    public String i() {
        return this.f1186g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a3 = r1.b.a(parcel);
        r1.b.j(parcel, 1, this.f1180a);
        r1.b.n(parcel, 2, e(), false);
        r1.b.n(parcel, 3, f(), false);
        r1.b.n(parcel, 4, b(), false);
        r1.b.n(parcel, 5, a(), false);
        r1.b.m(parcel, 6, g(), i2, false);
        r1.b.n(parcel, 7, i(), false);
        r1.b.l(parcel, 8, this.f1187h);
        r1.b.n(parcel, 9, this.f1188i, false);
        r1.b.q(parcel, 10, this.f1189j, false);
        r1.b.n(parcel, 11, d(), false);
        r1.b.n(parcel, 12, c(), false);
        r1.b.b(parcel, a3);
    }
}
