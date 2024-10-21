package j;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    private boolean f1900a = false;

    /* renamed from: b */
    private boolean f1901b = false;

    /* renamed from: c */
    private boolean f1902c = false;

    public boolean a() {
        return this.f1902c;
    }

    public byte b() {
        byte b3 = this.f1900a ? (byte) 1 : (byte) 0;
        if (this.f1901b) {
            b3 = (byte) (b3 + 4);
        }
        return this.f1902c ? (byte) (b3 + 16) : b3;
    }

    public boolean c() {
        return this.f1900a || this.f1901b || this.f1902c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Extended Assignment=");
        if (c()) {
            if (this.f1900a) {
                sb.append(" -Background Scanning");
            }
            if (this.f1901b) {
                sb.append(" -Frequency Agility");
            }
            str = this.f1902c ? " -Fast Channel Initiation" : "[Not Enabled]";
            return sb.toString();
        }
        sb.append(str);
        return sb.toString();
    }
}
