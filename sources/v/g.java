package v;

import java.util.UUID;

/* loaded from: classes.dex */
public class g extends u.a {

    /* renamed from: d */
    private volatile boolean f3463d;

    public g() {
        super(109);
        this.f3463d = false;
    }

    @Override // u.a
    public boolean c(UUID uuid, v0.a aVar) {
        if (this.f3463d) {
            return super.c(uuid, aVar);
        }
        return false;
    }

    public void e() {
        this.f3463d = true;
    }
}
