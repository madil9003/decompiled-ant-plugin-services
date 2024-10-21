package a2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a */
    public static final int f103a;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:            if (r0.charAt(0) <= 'Z') goto L32;     */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 33554432(0x2000000, float:9.403955E-38)
            if (r0 < r1) goto L9
            goto L29
        L9:
            r1 = 30
            r3 = 0
            if (r0 < r1) goto L28
            java.lang.String r0 = android.os.Build.VERSION.CODENAME
            int r1 = r0.length()
            r4 = 1
            if (r1 != r4) goto L28
            char r1 = r0.charAt(r3)
            r4 = 83
            if (r1 < r4) goto L28
            char r0 = r0.charAt(r3)
            r1 = 90
            if (r0 > r1) goto L28
            goto L29
        L28:
            r2 = r3
        L29:
            a2.e.f103a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.<clinit>():void");
    }

    public static PendingIntent a(Context context, int i2, Intent intent, int i3) {
        return PendingIntent.getActivity(context, i2, intent, i3);
    }
}
