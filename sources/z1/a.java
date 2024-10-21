package z1;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import java.util.List;
import u1.f;

/* loaded from: classes.dex */
public abstract class a extends Service {

    /* renamed from: a */
    private d f3622a;

    public abstract List a(List list);

    public abstract boolean b(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean c(DataSource dataSource);

    public final void d() {
        int callingUid = Binder.getCallingUid();
        if (f.c()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, "com.google.android.gms");
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            for (String str : packagesForUid) {
                if (str.equals("com.google.android.gms")) {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!"com.google.android.gms.fitness.service.FitnessSensorService".equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + String.valueOf(intent) + " received by " + getClass().getName());
        }
        return this.f3622a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3622a = new d(this, null);
    }
}
