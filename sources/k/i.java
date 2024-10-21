package k;

import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public class i extends b {

    /* renamed from: e */
    private static final l f2026e = l.CHANNEL_RESPONSE;

    /* renamed from: b */
    private int f2027b;

    /* renamed from: c */
    private int f2028c;

    /* renamed from: d */
    private j.k f2029d;

    public i(AntMessageParcel antMessageParcel) {
        this(b.g(f2026e, antMessageParcel));
    }

    private void l(byte[] bArr) {
        this.f1971a = bArr;
        this.f2027b = j.j.j(bArr, 1);
        int j2 = j.j.j(bArr, 2);
        this.f2028c = j2;
        this.f2029d = j.k.b(j2);
    }

    @Override // k.b
    public l h() {
        return f2026e;
    }

    public int j() {
        return this.f2027b;
    }

    public j.k k() {
        return this.f2029d;
    }

    @Override // j.a
    public String toString() {
        return i() + "Response to=" + j.j.b(this.f2027b) + ": code=" + this.f2029d + " (" + j.j.b(this.f2028c) + ")";
    }

    public i(byte[] bArr) {
        super(bArr);
        l(bArr);
    }
}
