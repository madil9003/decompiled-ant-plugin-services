package q1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class q implements DialogInterface.OnClickListener {
    public static q b(Activity activity, Intent intent, int i2) {
        return new o(intent, activity, i2);
    }

    public static q c(p1.e eVar, Intent intent, int i2) {
        return new p(intent, eVar, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        try {
            a();
        } catch (ActivityNotFoundException e3) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e3);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
