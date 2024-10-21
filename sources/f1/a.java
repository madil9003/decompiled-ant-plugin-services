package f1;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c */
    private final long f1704c;

    /* renamed from: a */
    private c f1702a = c.INITIAL;

    /* renamed from: b */
    private final Handler f1703b = new Handler();

    /* renamed from: d */
    private ArrayList f1705d = new ArrayList();

    /* renamed from: e */
    private final Runnable f1706e = new RunnableC0034a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f1.a$a */
    /* loaded from: classes.dex */
    public class RunnableC0034a implements Runnable {
        RunnableC0034a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f1702a = c.TRIGGERED;
            Iterator it = a.this.f1705d.iterator();
            while (it.hasNext()) {
                a.this.f1703b.post((Runnable) it.next());
            }
            a.this.f1705d.clear();
            a.this.f1705d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1708a;

        static {
            int[] iArr = new int[c.values().length];
            f1708a = iArr;
            try {
                iArr[c.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1708a[c.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1708a[c.TRIGGERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum c {
        INITIAL,
        WAITING,
        TRIGGERED
    }

    public a(long j2) {
        this.f1704c = j2;
    }

    public void e(Runnable runnable) {
        int i2 = b.f1708a[this.f1702a.ordinal()];
        if (i2 == 1) {
            this.f1702a = c.WAITING;
            this.f1703b.postDelayed(this.f1706e, this.f1704c);
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.f1703b.post(runnable);
            return;
        }
        this.f1705d.add(runnable);
    }
}
