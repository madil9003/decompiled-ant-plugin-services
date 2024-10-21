package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: classes.dex */
public abstract class GooglePlayServicesManifestException extends IllegalStateException {

    /* renamed from: a */
    private final int f1201a;

    public GooglePlayServicesManifestException(int i2, String str) {
        super(str);
        this.f1201a = i2;
    }
}
