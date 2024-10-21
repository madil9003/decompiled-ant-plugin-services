package g2;

/* loaded from: classes.dex */
public final class a extends IllegalStateException {
    private a(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(d dVar) {
        if (!dVar.f()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception c3 = dVar.c();
        String concat = c3 != null ? "failure" : dVar.g() ? "result ".concat(String.valueOf(dVar.d())) : dVar.e() ? "cancellation" : "unknown issue";
        return new a(concat.length() != 0 ? "Complete with: ".concat(concat) : new String("Complete with: "), c3);
    }
}
