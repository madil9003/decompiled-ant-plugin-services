package n1;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class k extends i {

    /* renamed from: c */
    private static final WeakReference f2696c = new WeakReference(null);

    /* renamed from: b */
    private WeakReference f2697b;

    public k(byte[] bArr) {
        super(bArr);
        this.f2697b = f2696c;
    }

    protected abstract byte[] F();

    @Override // n1.i
    final byte[] j() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f2697b.get();
            if (bArr == null) {
                bArr = F();
                this.f2697b = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
