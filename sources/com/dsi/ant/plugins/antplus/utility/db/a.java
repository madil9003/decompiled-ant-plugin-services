package com.dsi.ant.plugins.antplus.utility.db;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.dsi.ant.plugins.antplus.R;

/* loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.dsi.ant.plugins.antplus.utility.db.a$a */
    /* loaded from: classes.dex */
    public class C0014a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f892a;

        /* renamed from: b */
        final /* synthetic */ SeekBar f893b;

        /* renamed from: c */
        final /* synthetic */ TextView f894c;

        C0014a(RelativeLayout relativeLayout, SeekBar seekBar, TextView textView) {
            this.f892a = relativeLayout;
            this.f893b = seekBar;
            this.f894c = textView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            for (int i2 = 0; i2 < this.f892a.getChildCount(); i2++) {
                this.f892a.getChildAt(i2).setEnabled(z2);
            }
            if (z2) {
                this.f893b.setProgress(5);
            } else {
                this.f893b.setProgress(0);
                this.f894c.setText("Threshold Rating: OFF");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a */
        final /* synthetic */ TextView f895a;

        b(TextView textView) {
            this.f895a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            this.f895a.setText("Threshold Rating: " + (i2 + 1));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ CheckBox f896a;

        /* renamed from: b */
        final /* synthetic */ SeekBar f897b;

        /* renamed from: c */
        final /* synthetic */ int f898c;

        /* renamed from: d */
        final /* synthetic */ e f899d;

        c(CheckBox checkBox, SeekBar seekBar, int i2, e eVar) {
            this.f896a = checkBox;
            this.f897b = seekBar;
            this.f898c = i2;
            this.f899d = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            int progress = this.f896a.isChecked() ? this.f897b.getProgress() + 1 : 0;
            int i3 = this.f898c;
            if (progress != i3) {
                this.f899d.a(i3, progress);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(int i2, int i3);
    }

    public static AlertDialog a(Context context, int i2, e eVar) {
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Set Search Proximity Threshold");
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_proximity_picker, (ViewGroup) null);
        builder.setView(inflate);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checkBox_Enable);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekBar_ThresholdValue);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.relativeLayout_ProxValueControls);
        TextView textView = (TextView) inflate.findViewById(R.id.textView_ThresholdValueDisplay);
        checkBox.setChecked(true);
        checkBox.setOnCheckedChangeListener(new C0014a(relativeLayout, seekBar, textView));
        if (i2 == 0) {
            checkBox.setChecked(false);
            str = "Threshold Rating: OFF";
        } else {
            seekBar.setProgress(i2 - 1);
            str = "Threshold Rating: " + i2;
        }
        textView.setText(str);
        seekBar.setOnSeekBarChangeListener(new b(textView));
        builder.setPositiveButton("Set", new c(checkBox, seekBar, i2, eVar));
        builder.setNegativeButton("Cancel", new d());
        return builder.create();
    }
}
