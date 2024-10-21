package k;

import com.dsi.ant.message.ipc.AntMessageParcel;

/* loaded from: classes.dex */
public class e extends k {

    /* renamed from: d */
    private static final l f1988d = l.BURST_TRANSFER_DATA;

    /* renamed from: c */
    private final int f1989c;

    public e(AntMessageParcel antMessageParcel) {
        this(b.g(f1988d, antMessageParcel));
    }

    @Override // k.b
    public l h() {
        return f1988d;
    }

    public int m() {
        return this.f1989c;
    }

    public boolean n() {
        return this.f1989c == 0;
    }

    public boolean o() {
        return j.j.e(4, this.f1989c);
    }

    @Override // k.k, j.a
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n  ");
        sb.append("Sequence=");
        sb.append(j.j.b(this.f1989c));
        if (n()) {
            sb.append(" (FIRST)");
        }
        if (o()) {
            sb.append(" (LAST)");
        }
        return sb.toString();
    }

    public e(byte[] bArr) {
        super(bArr);
        this.f1989c = j.j.h(this.f1971a, 0, 224, 5);
    }
}
