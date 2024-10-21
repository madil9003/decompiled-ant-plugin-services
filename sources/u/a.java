package u;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c */
    private static final String f3371c = "a";

    /* renamed from: a */
    public final Integer f3372a;

    /* renamed from: b */
    private final HashMap f3373b = new HashMap();

    public a(Integer num) {
        this.f3372a = num;
    }

    public void a(Bundle bundle) {
        synchronized (this.f3373b) {
            Iterator it = this.f3373b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.arg1 = this.f3372a.intValue();
                obtain.setData(bundle);
                try {
                    ((v0.a) entry.getValue()).b(obtain);
                } catch (RemoteException unused) {
                    h1.a.b(f3371c, "Remote Exception sending event to remote response messenger with token " + entry.getKey() + ", removed from subscription. Event ID: " + this.f3372a);
                    it.remove();
                }
            }
        }
    }

    public boolean b() {
        return this.f3373b.size() > 0;
    }

    public boolean c(UUID uuid, v0.a aVar) {
        synchronized (this.f3373b) {
            if (this.f3373b.containsKey(uuid)) {
                return false;
            }
            this.f3373b.put(uuid, aVar);
            return true;
        }
    }

    public boolean d(UUID uuid) {
        synchronized (this.f3373b) {
            return this.f3373b.remove(uuid) != null;
        }
    }
}
