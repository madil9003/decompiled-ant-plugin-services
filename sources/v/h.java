package v;

import android.os.Bundle;
import com.dsi.ant.plugins.antplus.pccbase.b;
import java.util.LinkedList;
import java.util.List;
import v.e;

/* loaded from: classes.dex */
public class h implements b.d {

    /* renamed from: a */
    public z.a f3464a;

    /* renamed from: b */
    public List f3465b;

    /* renamed from: c */
    public final int f3466c;

    /* renamed from: d */
    public final String f3467d;

    public h(z.a aVar, e.a aVar2, int i2, String str) {
        this.f3464a = aVar;
        aVar.D(false);
        aVar.E(this);
        this.f3466c = i2;
        this.f3467d = str;
        LinkedList linkedList = new LinkedList();
        this.f3465b = linkedList;
        linkedList.add(aVar2);
    }

    private void c(p0.f fVar) {
        if (fVar == p0.f.FAIL_NOT_SUPPORTED) {
            fVar = p0.f.SUCCESS;
        }
        u.a aVar = new u.a(Integer.valueOf(this.f3466c));
        for (e.a aVar2 : this.f3465b) {
            aVar.c(aVar2.f3454c, aVar2.f3455d);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(this.f3467d, fVar.b());
        aVar.a(bundle);
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.b.d
    public void a(p0.f fVar) {
        c(fVar);
    }

    public boolean b(u0.a aVar) {
        boolean z2;
        try {
            z2 = aVar.u(this.f3464a, 10000);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            z2 = false;
        }
        if (z2) {
            return true;
        }
        c(p0.f.FAIL_ALREADY_BUSY_EXTERNAL);
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        z.a aVar = this.f3464a;
        if (aVar == null) {
            if (hVar.f3464a != null) {
                return false;
            }
        } else if (!aVar.equals(hVar.f3464a)) {
            return false;
        }
        if (this.f3464a != hVar.f3464a || this.f3466c != hVar.f3466c) {
            return false;
        }
        String str = this.f3467d;
        if (str == null) {
            if (hVar.f3467d != null) {
                return false;
            }
        } else if (!str.equals(hVar.f3467d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        z.a aVar = this.f3464a;
        int hashCode = ((((aVar == null ? 0 : aVar.hashCode()) + 31) * 31) + this.f3466c) * 31;
        String str = this.f3467d;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
