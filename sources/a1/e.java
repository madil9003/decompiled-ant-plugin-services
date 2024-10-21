package a1;

import com.dsi.ant.plugins.antplus.pcc.AntPlusWeightScalePcc;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    AntPlusWeightScalePcc.UserProfile f93a;

    /* renamed from: b */
    boolean f94b;

    /* renamed from: c */
    boolean f95c;

    /* renamed from: d */
    boolean f96d;

    /* renamed from: e */
    boolean f97e;

    public void a(byte[] bArr) {
        bArr[0] = 58;
        bArr[3] = 0;
        if (this.f97e) {
            bArr[3] = (byte) (0 | 1);
        }
        if (this.f96d) {
            bArr[3] = (byte) (bArr[3] | 2);
        }
        if (this.f95c) {
            bArr[3] = (byte) (bArr[3] | 4);
        }
        if (!this.f94b) {
            bArr[3] = (byte) (bArr[3] | Byte.MIN_VALUE);
        }
        bArr[4] = -1;
        AntPlusWeightScalePcc.UserProfile userProfile = this.f93a;
        if (userProfile == null) {
            bArr[1] = -1;
            bArr[2] = -1;
            bArr[5] = 0;
            bArr[6] = 0;
            bArr[7] = 0;
            return;
        }
        if (userProfile.a() == -1) {
            bArr[1] = -1;
            bArr[2] = -1;
        } else {
            bArr[1] = (byte) (this.f93a.a() & 255);
            bArr[2] = (byte) ((this.f93a.a() >> 8) & 255);
        }
        AntPlusWeightScalePcc.UserProfile userProfile2 = this.f93a;
        int i2 = userProfile2.f770d;
        if (i2 == -1) {
            bArr[5] = 0;
        } else {
            bArr[5] = (byte) (i2 & 127);
        }
        if (userProfile2.f769c == AntPlusWeightScalePcc.c.MALE) {
            bArr[5] = (byte) (bArr[5] | Byte.MIN_VALUE);
        }
        int i3 = userProfile2.f771e;
        if (i3 == -1) {
            bArr[6] = 0;
        } else {
            bArr[6] = (byte) (i3 & 255);
        }
        int i4 = userProfile2.f772f;
        if (i4 == -1) {
            bArr[7] = 0;
        } else {
            bArr[7] = (byte) (i4 & 7);
        }
        if (userProfile2.f773g) {
            bArr[7] = (byte) (bArr[7] | 128);
        }
    }

    public void b(boolean z2) {
        this.f94b = z2;
    }

    public void c(boolean z2) {
        this.f95c = z2;
    }

    public void d(boolean z2) {
        this.f96d = z2;
    }

    public void e(boolean z2) {
        this.f97e = z2;
    }

    public void f(AntPlusWeightScalePcc.UserProfile userProfile) {
        this.f93a = userProfile;
    }
}
