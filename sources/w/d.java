package w;

import java.nio.IntBuffer;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private IntBuffer f3483a;

    /* renamed from: b */
    private boolean f3484b = false;

    /* renamed from: c */
    private int f3485c;

    public d(int i2) {
        this.f3483a = IntBuffer.allocate(i2);
        this.f3485c = i2;
    }

    public double a() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3483a.capacity(); i3++) {
            i2 += this.f3483a.get(i3);
        }
        return i2 / this.f3483a.capacity();
    }

    public boolean b(int i2) {
        double a3 = a();
        for (int i3 = 0; i3 < this.f3483a.capacity(); i3++) {
            double d3 = this.f3483a.get(i3);
            double d4 = i2;
            if (d3 > a3 + d4 || d3 < a3 - d4) {
                return false;
            }
        }
        return true;
    }

    public boolean c(int i2, int i3) {
        double d3 = i2;
        double d4 = i3;
        return d3 >= a() - d4 && d3 <= a() + d4;
    }

    public void d(int i2) {
        if (!this.f3483a.hasRemaining()) {
            this.f3483a.rewind();
            this.f3483a.put(i2);
        } else {
            this.f3483a.put(i2);
            if (this.f3483a.hasRemaining()) {
                return;
            }
            this.f3484b = true;
        }
    }

    public void e() {
        this.f3483a = IntBuffer.allocate(this.f3485c);
        this.f3484b = false;
    }

    public boolean f() {
        return this.f3484b;
    }
}
