package l1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import q1.f;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c */
    private static final Lock f2609c = new ReentrantLock();

    /* renamed from: d */
    private static a f2610d;

    /* renamed from: a */
    private final Lock f2611a = new ReentrantLock();

    /* renamed from: b */
    private final SharedPreferences f2612b;

    a(Context context) {
        this.f2612b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        f.g(context);
        Lock lock = f2609c;
        lock.lock();
        try {
            if (f2610d == null) {
                f2610d = new a(context.getApplicationContext());
            }
            a aVar = f2610d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f2609c.unlock();
            throw th;
        }
    }

    private static final String d(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public GoogleSignInAccount b() {
        String c3;
        String c4 = c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(c4) || (c3 = c(d("googleSignInAccount", c4))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.k(c3);
        } catch (JSONException unused) {
            return null;
        }
    }

    protected final String c(String str) {
        this.f2611a.lock();
        try {
            return this.f2612b.getString(str, null);
        } finally {
            this.f2611a.unlock();
        }
    }
}
