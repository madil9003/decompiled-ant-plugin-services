package v0;

import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private final IBinder.DeathRecipient f3468a;

    /* renamed from: b */
    public final Messenger f3469b;

    /* renamed from: c */
    private volatile boolean f3470c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v0.a$a */
    /* loaded from: classes.dex */
    public class C0064a implements IBinder.DeathRecipient {
        C0064a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            a.this.f3470c = true;
        }
    }

    public a(Messenger messenger) {
        C0064a c0064a = new C0064a();
        this.f3468a = c0064a;
        this.f3470c = false;
        this.f3469b = messenger;
        try {
            messenger.getBinder().linkToDeath(c0064a, 0);
        } catch (RemoteException unused) {
            this.f3470c = true;
        }
    }

    public void b(Message message) {
        if (this.f3470c) {
            throw new DeadObjectException();
        }
        this.f3469b.send(message);
    }

    public void c() {
        this.f3470c = true;
    }
}
