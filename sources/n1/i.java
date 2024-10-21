package n1;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import q1.c0;
import q1.d0;

/* loaded from: classes.dex */
abstract class i extends c0 {

    /* renamed from: a */
    private final int f2694a;

    public i(byte[] bArr) {
        q1.f.a(bArr.length == 25);
        this.f2694a = Arrays.hashCode(bArr);
    }

    public static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // q1.d0
    public final w1.a D() {
        return w1.b.j(j());
    }

    public final boolean equals(Object obj) {
        w1.a D;
        if (obj != null && (obj instanceof d0)) {
            try {
                d0 d0Var = (d0) obj;
                if (d0Var.v() == this.f2694a && (D = d0Var.D()) != null) {
                    return Arrays.equals(j(), (byte[]) w1.b.c(D));
                }
                return false;
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2694a;
    }

    abstract byte[] j();

    @Override // q1.d0
    public final int v() {
        return this.f2694a;
    }
}
