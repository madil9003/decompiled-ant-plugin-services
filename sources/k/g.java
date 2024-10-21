package k;

import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public class g extends b {

    /* renamed from: d */
    private static final l f2021d = l.CHANNEL_EVENT;

    /* renamed from: b */
    private final int f2022b;

    /* renamed from: c */
    private final j.e f2023c;

    public g(AntMessageParcel antMessageParcel) {
        this(b.g(f2021d, antMessageParcel));
    }

    @Override // k.b
    public l h() {
        return f2021d;
    }

    public j.e j() {
        return this.f2023c;
    }

    @Override // j.a
    public String toString() {
        return i() + "\n  Event Code=" + this.f2023c + " (" + j.j.b(this.f2022b) + ")";
    }

    public g(byte[] bArr) {
        super(bArr);
        int j2 = j.j.j(this.f1971a, 2);
        this.f2022b = j2;
        this.f2023c = j.e.b(j2);
    }
}
