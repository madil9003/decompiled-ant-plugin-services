package t0;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.dsi.ant.plugins.antplus.R;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;

/* loaded from: classes.dex */
public final class a extends DialogPreference {

    /* renamed from: d */
    private static final String f3357d = String.valueOf(Character.toChars(9733));

    /* renamed from: a */
    private final AntPluginDeviceDbProvider.DeviceDbDeviceInfo f3358a;

    /* renamed from: b */
    private EditText f3359b;

    /* renamed from: c */
    private CheckBox f3360c;

    /* renamed from: t0.a$a */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0058a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ AlertDialog f3361a;

        ViewOnClickListenerC0058a(AlertDialog alertDialog) {
            this.f3361a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context;
            String str;
            Toast makeText;
            String trim = a.this.f3359b.getText().toString().trim();
            if (trim == null || trim.length() == 0) {
                context = this.f3361a.getContext();
                str = "Must specify device name";
            } else {
                if (trim.matches("^[\\p{L}\\p{N}]+$")) {
                    t0.b bVar = new t0.b(a.this.getContext());
                    try {
                        if (bVar.n(a.this.f3358a, trim, Boolean.valueOf(a.this.f3360c.isChecked()))) {
                            a.this.callChangeListener(null);
                            makeText = Toast.makeText(a.this.getContext(), "Saved changes to " + a.this.f3358a.f1177e, 0);
                        } else {
                            makeText = Toast.makeText(a.this.getContext(), "No Changes To Save", 0);
                        }
                        makeText.show();
                        this.f3361a.dismiss();
                        return;
                    } finally {
                        bVar.d();
                    }
                }
                context = this.f3361a.getContext();
                str = "Name must not contain special charcters";
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ AlertDialog f3363a;

        /* renamed from: t0.a$b$a */
        /* loaded from: classes.dex */
        class DialogInterfaceOnClickListenerC0059a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0059a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                t0.b bVar = new t0.b(a.this.getContext());
                try {
                    bVar.m(a.this.f3358a);
                    a.this.callChangeListener(null);
                    b.this.f3363a.dismiss();
                    Toast.makeText(a.this.getContext(), "Removed " + a.this.f3358a.f1177e, 0).show();
                } finally {
                    bVar.d();
                }
            }
        }

        b(AlertDialog alertDialog) {
            this.f3363a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new AlertDialog.Builder(a.this.getContext()).setTitle("Forget " + a.this.f3358a.f1177e + "?").setNegativeButton("No", (DialogInterface.OnClickListener) null).setPositiveButton("Yes", new DialogInterfaceOnClickListenerC0059a()).show();
        }
    }

    public a(Context context, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo) {
        super(context, null);
        int intValue;
        this.f3358a = deviceDbDeviceInfo;
        setPersistent(false);
        setDialogTitle("Modify Saved Device");
        setDialogLayoutResource(R.layout.dialogpref_modify_device);
        String str = deviceDbDeviceInfo.f1177e;
        String str2 = (str == null || str.length() == 0) ? "-no name saved-" : deviceDbDeviceInfo.f1177e;
        if (deviceDbDeviceInfo.f1178f.booleanValue()) {
            str2 = f3357d + " " + str2;
        }
        if ((deviceDbDeviceInfo.f1176d.intValue() & 536870912) > 0) {
            str2 = str2 + " (S&C)";
            intValue = deviceDbDeviceInfo.f1176d.intValue() & (-536870913);
        } else {
            intValue = deviceDbDeviceInfo.f1176d.intValue();
        }
        String str3 = "   ID <" + intValue + ">";
        if (deviceDbDeviceInfo.f1178f.booleanValue()) {
            str3 = str3 + ", Preferred Device";
        }
        setTitle(str2);
        setSummary(str3);
    }

    @Override // android.preference.DialogPreference
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        EditText editText = (EditText) view.findViewById(R.id.edittext_deviceName);
        this.f3359b = editText;
        editText.setText(this.f3358a.f1177e);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_isPreferred);
        this.f3360c = checkBox;
        checkBox.setChecked(this.f3358a.f1178f.booleanValue());
    }

    @Override // android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setPositiveButton("Save", this);
        builder.setNeutralButton("Cancel", this);
        builder.setNegativeButton("Forget Device", this);
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        super.showDialog(bundle);
        AlertDialog alertDialog = (AlertDialog) getDialog();
        alertDialog.getButton(-1).setOnClickListener(new ViewOnClickListenerC0058a(alertDialog));
        alertDialog.getButton(-2).setOnClickListener(new b(alertDialog));
    }
}
