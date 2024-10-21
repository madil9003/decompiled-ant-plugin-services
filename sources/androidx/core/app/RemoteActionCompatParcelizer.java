package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f104a = (IconCompat) aVar.v(remoteActionCompat.f104a, 1);
        remoteActionCompat.f105b = aVar.l(remoteActionCompat.f105b, 2);
        remoteActionCompat.f106c = aVar.l(remoteActionCompat.f106c, 3);
        remoteActionCompat.f107d = (PendingIntent) aVar.r(remoteActionCompat.f107d, 4);
        remoteActionCompat.f108e = aVar.h(remoteActionCompat.f108e, 5);
        remoteActionCompat.f109f = aVar.h(remoteActionCompat.f109f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f104a, 1);
        aVar.D(remoteActionCompat.f105b, 2);
        aVar.D(remoteActionCompat.f106c, 3);
        aVar.H(remoteActionCompat.f107d, 4);
        aVar.z(remoteActionCompat.f108e, 5);
        aVar.z(remoteActionCompat.f109f, 6);
    }
}
