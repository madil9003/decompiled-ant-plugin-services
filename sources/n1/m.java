package n1;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a */
    static final k f2699a = new e(i.c("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* renamed from: b */
    static final k f2700b = new f(i.c("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* renamed from: c */
    static final k f2701c = new g(i.c("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* renamed from: d */
    static final k f2702d = new h(i.c("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* renamed from: e */
    private static final Object f2703e = new Object();

    /* renamed from: f */
    private static Context f2704f;

    public static synchronized void a(Context context) {
        synchronized (m.class) {
            if (f2704f != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f2704f = context.getApplicationContext();
            }
        }
    }
}
