package w;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private int f3477a;

    /* renamed from: b */
    private boolean f3478b = false;

    /* renamed from: c */
    private boolean f3479c = true;

    /* renamed from: d */
    private long f3480d = 0;

    /* renamed from: e */
    private int f3481e;

    /* renamed from: f */
    private final int f3482f;

    public a(int i2) {
        this.f3482f = i2;
    }

    private void e(int i2) {
        this.f3481e = 0;
        this.f3477a = i2;
        this.f3478b = true;
        this.f3479c = true;
    }

    public void a(int i2) {
        if (this.f3478b) {
            this.f3479c = false;
        } else {
            e(i2);
        }
        long c3 = c();
        long c4 = c() + i2;
        int i3 = this.f3477a;
        long j2 = c4 - i3;
        if (i3 > i2) {
            j2 = j2 + 1 + this.f3482f;
        }
        this.f3477a = i2;
        this.f3481e = (int) (j2 - c3);
        this.f3480d = j2;
    }

    public int b() {
        return this.f3481e;
    }

    public long c() {
        return this.f3480d;
    }

    public boolean d() {
        return this.f3479c;
    }

    public void f(long j2, int i2) {
        this.f3480d = j2;
        e(i2);
    }

    public void g() {
        this.f3481e = 0;
        this.f3477a = 0;
        this.f3478b = false;
        this.f3479c = true;
    }
}
