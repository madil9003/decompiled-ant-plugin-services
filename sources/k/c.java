package k;

import android.util.Log;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: i */
    private static final String f1973i = "c";

    /* renamed from: j */
    private static final l f1974j;

    /* renamed from: k */
    private static final String f1975k;

    /* renamed from: b */
    private final String f1976b;

    /* renamed from: c */
    private String f1977c;

    /* renamed from: d */
    private float f1978d;

    /* renamed from: e */
    private char f1979e;

    /* renamed from: f */
    private int f1980f;

    /* renamed from: g */
    private String f1981g;

    /* renamed from: h */
    private a f1982h;

    /* loaded from: classes.dex */
    public enum a {
        BAD_FORMAT,
        VERSION,
        VERSION_MODULE
    }

    static {
        String simpleName = c.class.getSimpleName();
        f1974j = l.ANT_VERSION;
        f1975k = simpleName + ":OverrideState";
    }

    public c(byte[] bArr) {
        super(bArr);
        this.f1977c = null;
        this.f1978d = -1.0f;
        this.f1979e = (char) 0;
        this.f1980f = 0;
        this.f1981g = null;
        this.f1982h = a.BAD_FORMAT;
        this.f1976b = j();
        l();
    }

    private String j() {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            bArr = this.f1971a;
            if (i2 >= bArr.length || bArr[i2] == 0) {
                break;
            }
            i2++;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        try {
            return new String(bArr2, "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            Log.e(f1973i, "Could not create version string with UTF-8 encoding", e3);
            return "?";
        }
    }

    private void l() {
        a aVar;
        int indexOf = this.f1976b.indexOf(".") - 1;
        if (indexOf < 0) {
            return;
        }
        this.f1977c = this.f1976b.substring(0, indexOf).trim().replaceAll("\\-$", "");
        int i2 = indexOf + 4;
        this.f1978d = Float.parseFloat(this.f1976b.substring(indexOf, i2));
        if (this.f1976b.length() - i2 >= 3) {
            int i3 = i2 + 3;
            String substring = this.f1976b.substring(i2, i3);
            if (substring.matches("[A-Za-z]{3}") || substring.matches("RC[0-9]*")) {
                this.f1981g = this.f1976b.substring(i2, i3);
                aVar = a.VERSION_MODULE;
                this.f1982h = aVar;
            } else {
                if (!substring.matches("[A-Za-z][0-9]{2}")) {
                    return;
                }
                this.f1979e = this.f1976b.charAt(i2);
                int i4 = i2 + 1;
                this.f1980f = Integer.parseInt(this.f1976b.substring(i4, i4 + 2));
            }
        }
        aVar = a.VERSION;
        this.f1982h = aVar;
    }

    @Override // k.b
    public l h() {
        return f1974j;
    }

    public String k() {
        return this.f1977c;
    }

    @Override // j.a
    public String toString() {
        return i() + "\n  Version=" + this.f1976b;
    }
}
