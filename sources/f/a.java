package f;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import i.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c */
    private static int f1686c = -1;

    /* renamed from: a */
    private final i.a f1687a;

    /* renamed from: b */
    private com.dsi.ant.channel.a f1688b;

    /* renamed from: f.a$a */
    /* loaded from: classes.dex */
    public enum EnumC0032a {
        INVALID(-1),
        CHANNEL_PROVIDER(1),
        ADAPTER_PROVIDER(2);


        /* renamed from: e */
        private static final EnumC0032a[] f1692e = values();

        /* renamed from: a */
        private final int f1694a;

        EnumC0032a(int i2) {
            this.f1694a = i2;
        }

        public int b() {
            return this.f1694a;
        }
    }

    public a(IBinder iBinder) {
        i.a a3 = a.AbstractBinderC0037a.a(iBinder);
        this.f1687a = a3;
        if (a3 == null) {
            throw new IllegalArgumentException("The given service binder does not seem to be for the ANT Radio Service");
        }
    }

    public static boolean a(Context context, ServiceConnection serviceConnection) {
        f1686c = d(context);
        Intent intent = new Intent();
        intent.setClassName("com.dsi.ant.service.socket", "com.dsi.ant.service.AntRadioService");
        intent.setAction("com.dsi.ant.bind.AntService");
        return context.bindService(intent, serviceConnection, 1);
    }

    private IBinder c(EnumC0032a enumC0032a) {
        return this.f1687a.x(enumC0032a.b());
    }

    public static int d(Context context) {
        if (context != null) {
            try {
                f1686c = context.getPackageManager().getPackageInfo("com.dsi.ant.service.socket", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                f1686c = 0;
            }
        }
        return f1686c;
    }

    public static boolean e() {
        return f1686c > 40000;
    }

    public static boolean f() {
        return f1686c >= 41212;
    }

    public static boolean g() {
        int i2 = f1686c;
        return i2 > 40000 || i2 == -1;
    }

    public com.dsi.ant.channel.a b() {
        if (this.f1688b == null) {
            this.f1688b = new com.dsi.ant.channel.a(c(EnumC0032a.CHANNEL_PROVIDER));
        }
        return this.f1688b;
    }
}
