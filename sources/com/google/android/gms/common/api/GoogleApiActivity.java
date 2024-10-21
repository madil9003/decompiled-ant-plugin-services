package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import q1.f;

@KeepName
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    protected int f1206a = 0;

    public static Intent a(Context context, PendingIntent pendingIntent, int i2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z2);
        return intent;
    }

    private final void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            com.google.android.gms.common.a.k().l(this, ((Integer) f.g(num)).intValue(), 2, this);
            this.f1206a = 1;
            return;
        }
        try {
            startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
            this.f1206a = 1;
        } catch (ActivityNotFoundException e3) {
            if (extras.getBoolean("notify_manager", true)) {
                com.google.android.gms.common.api.internal.b.x(this).F(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
            } else {
                String obj = pendingIntent.toString();
                StringBuilder sb = new StringBuilder(obj.length() + 36);
                sb.append("Activity not found while launching ");
                sb.append(obj);
                sb.append(".");
                String sb2 = sb.toString();
                if (Build.FINGERPRINT.contains("generic")) {
                    sb2 = sb2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                }
                Log.e("GoogleApiActivity", sb2, e3);
            }
            this.f1206a = 1;
            finish();
        } catch (IntentSender.SendIntentException e4) {
            Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e4);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f1206a = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                com.google.android.gms.common.api.internal.b x2 = com.google.android.gms.common.api.internal.b.x(this);
                if (i3 == -1) {
                    x2.a();
                } else if (i3 == 0) {
                    x2.F(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f1206a = 0;
            setResult(i3, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f1206a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f1206a = bundle.getInt("resolution");
        }
        if (this.f1206a != 1) {
            b();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f1206a);
        super.onSaveInstanceState(bundle);
    }
}
