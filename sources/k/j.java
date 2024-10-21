package k;

import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public class j extends b {

    /* renamed from: d */
    private static final l f2030d = l.CHANNEL_STATUS;

    /* renamed from: b */
    private final j.d f2031b;

    /* renamed from: c */
    private final j.c f2032c;

    public j(AntMessageParcel antMessageParcel) {
        this(b.g(f2030d, antMessageParcel));
    }

    private int j() {
        return j.j.h(this.f1971a, 1, 3, 0);
    }

    private int k() {
        return j.j.h(this.f1971a, 1, -16, 4);
    }

    @Override // k.b
    public l h() {
        return f2030d;
    }

    public j.c l() {
        return this.f2032c;
    }

    @Override // j.a
    public String toString() {
        return i() + "\n  Type=" + this.f2031b + "\n  State=" + this.f2032c;
    }

    public j(byte[] bArr) {
        super(bArr);
        this.f2031b = j.d.b(k());
        this.f2032c = j.c.b(j());
    }
}
