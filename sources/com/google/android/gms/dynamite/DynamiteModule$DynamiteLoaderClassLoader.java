package com.google.android.gms.dynamite;

import com.google.android.gms.common.util.DynamiteApi;
import javax.annotation.concurrent.GuardedBy;

@DynamiteApi
/* loaded from: classes.dex */
public class DynamiteModule$DynamiteLoaderClassLoader {

    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
}
