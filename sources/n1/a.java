package n1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes.dex */
public class a extends DialogFragment {

    /* renamed from: a */
    private Dialog f2688a;

    /* renamed from: b */
    private DialogInterface.OnCancelListener f2689b;

    /* renamed from: c */
    private Dialog f2690c;

    public static a a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) q1.f.h(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        aVar.f2688a = dialog2;
        if (onCancelListener != null) {
            aVar.f2689b = onCancelListener;
        }
        return aVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2689b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f2688a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f2690c == null) {
            this.f2690c = new AlertDialog.Builder((Context) q1.f.g(getActivity())).create();
        }
        return this.f2690c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
