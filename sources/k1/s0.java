package k1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class s0 extends u0 {

    /* renamed from: c */
    protected String f2368c;

    /* renamed from: d */
    protected int f2369d;

    /* renamed from: e */
    protected int f2370e;

    /* renamed from: f */
    protected double f2371f;

    /* renamed from: g */
    protected double f2372g;

    /* renamed from: h */
    protected String f2373h;

    /* renamed from: i */
    protected boolean f2374i;

    /* renamed from: j */
    protected ArrayList f2375j;

    /* renamed from: k */
    protected ArrayList f2376k;

    /* renamed from: l */
    private l2 f2377l;

    /* renamed from: m */
    private boolean f2378m;

    public s0(String str, int i2, int i3, double d3, double d4, String str2, boolean z2, l2 l2Var) {
        this.f2368c = str;
        this.f2369d = i2;
        this.f2370e = i3;
        this.f2377l = l2Var;
        this.f2371f = d3;
        this.f2372g = d4;
        this.f2373h = str2;
        this.f2374i = z2;
        this.f2375j = new ArrayList();
        this.f2376k = new ArrayList();
        this.f2378m = false;
    }

    public boolean K() {
        return this.f2374i;
    }

    public int L() {
        return this.f2369d;
    }

    public void M(boolean z2) {
        this.f2378m = z2;
    }

    @Override // k1.u0
    protected String h() {
        return this.f2368c;
    }

    @Override // k1.u0
    protected double q() {
        return this.f2372g;
    }

    @Override // k1.u0
    protected double t() {
        return this.f2371f;
    }

    @Override // k1.u0
    public d3 y(int i2) {
        if (i2 < 0 || i2 >= this.f2376k.size()) {
            return null;
        }
        return (d3) this.f2376k.get(i2);
    }

    @Override // k1.u0
    public int z() {
        return this.f2370e;
    }

    public s0(s0 s0Var) {
        super(s0Var);
        boolean z2;
        if (s0Var == null) {
            this.f2368c = "unknown";
            this.f2369d = 255;
            z2 = false;
            this.f2370e = 0;
            this.f2377l = l2.ENUM;
            this.f2371f = 1.0d;
            this.f2372g = 0.0d;
            this.f2373h = "";
            this.f2374i = false;
            this.f2445a = new ArrayList();
            this.f2375j = new ArrayList();
            this.f2376k = new ArrayList();
        } else {
            this.f2368c = s0Var.f2368c;
            this.f2369d = s0Var.f2369d;
            this.f2370e = s0Var.f2370e;
            this.f2377l = s0Var.f2377l;
            this.f2371f = s0Var.f2371f;
            this.f2372g = s0Var.f2372g;
            this.f2373h = s0Var.f2373h;
            this.f2374i = s0Var.f2374i;
            this.f2375j = s0Var.f2375j;
            this.f2376k = s0Var.f2376k;
            z2 = s0Var.f2378m;
        }
        this.f2378m = z2;
    }
}
