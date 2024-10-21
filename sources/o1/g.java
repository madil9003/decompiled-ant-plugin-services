package o1;

import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class g extends UnsupportedOperationException {

    /* renamed from: a */
    private final Feature f2860a;

    public g(Feature feature) {
        this.f2860a = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f2860a));
    }
}
