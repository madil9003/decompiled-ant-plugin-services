package n1;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: b */
    private final byte[] f2695b;

    public j(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f2695b = bArr;
    }

    @Override // n1.i
    final byte[] j() {
        return this.f2695b;
    }
}
