package o0;

import android.os.Bundle;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public boolean f2745a = false;

    /* renamed from: b */
    public boolean f2746b = false;

    public static a a(Bundle bundle) {
        a aVar = new a();
        aVar.f2745a = bundle.getBoolean("bool_customRepeatModeSupported");
        aVar.f2746b = bundle.getBoolean("boolCustomShuffleModeSupport");
        return aVar;
    }

    public void b(Bundle bundle) {
        bundle.putBoolean("bool_customRepeatModeSupported", this.f2745a);
        bundle.putBoolean("boolCustomShuffleModeSupport", this.f2746b);
    }
}
