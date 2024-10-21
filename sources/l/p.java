package l;

import com.dsi.ant.channel.Capabilities;

/* loaded from: classes.dex */
public final class p extends b {

    /* renamed from: b */
    private static final k f2600b = k.SET_CHANNEL_TRANSMIT_POWER;

    /* renamed from: a */
    private final int f2601a;

    public p(int i2, Capabilities capabilities) {
        if (!j.j.d(i2, 0, capabilities.g())) {
            throw new IllegalArgumentException("Transmit power level setting is out of range.");
        }
        this.f2601a = i2;
    }

    @Override // l.b
    public byte[] e(int i2, int i3) {
        byte[] bArr = new byte[2];
        j.j.m(i2, bArr, 1, 0);
        j.j.l((byte) this.f2601a, bArr, 1);
        return bArr;
    }

    @Override // l.b
    public k f() {
        return f2600b;
    }

    @Override // j.a
    public String toString() {
        return g() + "\n  Transmit power setting=" + this.f2601a;
    }
}
