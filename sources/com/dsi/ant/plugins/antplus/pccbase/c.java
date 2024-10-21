package com.dsi.ant.plugins.antplus.pccbase;

import android.os.Message;

/* loaded from: classes.dex */
public abstract class c extends a {
    private static final String E = "c";

    @Override // com.dsi.ant.plugins.antplus.pccbase.a
    public void q(Message message) {
        int i2 = message.arg1;
        if (i2 != 109) {
            switch (i2) {
                case 204:
                case 205:
                case 206:
                    return;
                default:
                    h1.a.a(E, "Unrecognized event received: " + message.arg1);
                    return;
            }
        }
    }
}
