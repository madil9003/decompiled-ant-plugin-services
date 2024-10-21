package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: a */
    protected final p1.e f1221a;

    public LifecycleCallback(p1.e eVar) {
        this.f1221a = eVar;
    }

    public static p1.e c(Activity activity) {
        return d(new p1.d(activity));
    }

    protected static p1.e d(p1.d dVar) {
        if (dVar.d()) {
            dVar.b();
            return p1.z.d(null);
        }
        if (dVar.c()) {
            return p1.y.f(dVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static p1.e getChimeraLifecycleFragmentImpl(p1.d dVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity c3 = this.f1221a.c();
        q1.f.g(c3);
        return c3;
    }

    public void e(int i2, int i3, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
