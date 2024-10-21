package p1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y extends Fragment implements e {

    /* renamed from: d */
    private static final WeakHashMap f2989d = new WeakHashMap();

    /* renamed from: a */
    private final Map f2990a = Collections.synchronizedMap(new a.a());

    /* renamed from: b */
    private int f2991b = 0;

    /* renamed from: c */
    private Bundle f2992c;

    public static y f(Activity activity) {
        y yVar;
        WeakHashMap weakHashMap = f2989d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (yVar = (y) weakReference.get()) != null) {
            return yVar;
        }
        try {
            y yVar2 = (y) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (yVar2 == null || yVar2.isRemoving()) {
                yVar2 = new y();
                activity.getFragmentManager().beginTransaction().add(yVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(yVar2));
            return yVar2;
        } catch (ClassCastException e3) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e3);
        }
    }

    @Override // p1.e
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f2990a.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f2990a.put(str, lifecycleCallback);
        if (this.f2991b > 0) {
            new b2.e(Looper.getMainLooper()).post(new x(this, lifecycleCallback, str));
        }
    }

    @Override // p1.e
    public final LifecycleCallback b(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f2990a.get(str));
    }

    @Override // p1.e
    public final Activity c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f2990a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Iterator it = this.f2990a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2991b = 1;
        this.f2992c = bundle;
        for (Map.Entry entry : this.f2990a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f2991b = 5;
        Iterator it = this.f2990a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f2991b = 3;
        Iterator it = this.f2990a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f2990a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f2991b = 2;
        Iterator it = this.f2990a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f2991b = 4;
        Iterator it = this.f2990a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }
}
