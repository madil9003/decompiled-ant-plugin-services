package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends a2.f {

    /* renamed from: a */
    private final Context f1321a;

    /* renamed from: b */
    final /* synthetic */ a f1322b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f1322b = aVar;
        this.f1321a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(i2);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        int e3 = this.f1322b.e(this.f1321a);
        if (this.f1322b.h(e3)) {
            this.f1322b.m(this.f1321a, e3);
        }
    }
}
