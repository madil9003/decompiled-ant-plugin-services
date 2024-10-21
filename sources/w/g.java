package w;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private boolean f3488a;

    /* renamed from: d */
    private int f3491d = 0;

    /* renamed from: b */
    private boolean f3489b = true;

    /* renamed from: c */
    private boolean f3490c = true;

    public int a() {
        return this.f3491d;
    }

    public boolean b(boolean z2) {
        if (this.f3490c) {
            this.f3488a = z2;
            this.f3490c = false;
            return false;
        }
        if (!this.f3489b || z2 == this.f3488a) {
            return false;
        }
        this.f3488a = z2;
        this.f3491d++;
        return true;
    }
}
