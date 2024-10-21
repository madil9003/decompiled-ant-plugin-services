package com.dsi.ant.plugins.antplus.pccbase;

import android.os.Bundle;
import android.os.Message;
import java.util.EnumSet;
import java.util.concurrent.Semaphore;
import p0.f;

/* loaded from: classes.dex */
public abstract class b extends com.dsi.ant.plugins.antplus.pccbase.a {
    private static final String J = "b";
    protected d E;
    protected Semaphore F = new Semaphore(1);
    a G;
    c H;
    InterfaceC0012b I;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j2, EnumSet enumSet, int i2, int i3, int i4);
    }

    /* renamed from: com.dsi.ant.plugins.antplus.pccbase.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0012b {
        void a(long j2, EnumSet enumSet, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(long j2, EnumSet enumSet, int i2, int i3, long j3);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(f fVar);
    }

    public void E(a aVar) {
        this.G = aVar;
        if (aVar != null) {
            B(100);
        } else {
            D(100);
        }
    }

    public boolean F(InterfaceC0012b interfaceC0012b) {
        if (this.f836t >= 20206) {
            this.I = interfaceC0012b;
            if (interfaceC0012b != null) {
                return B(103);
            }
            D(103);
            return true;
        }
        h1.a.j(J, "subscribeManufacturerSpecificDataEvent requires ANT+ Plugins Service >20206, installed: " + this.f836t);
        return false;
    }

    public void G(c cVar) {
        this.H = cVar;
        if (cVar != null) {
            B(101);
        } else {
            D(101);
        }
    }

    @Override // com.dsi.ant.plugins.antplus.pccbase.a
    public void q(Message message) {
        int i2 = message.arg1;
        if (i2 == 107) {
            d dVar = this.E;
            this.E = null;
            this.F.release();
            if (dVar == null) {
                return;
            }
            dVar.a(f.c(message.getData().getInt("int_requestStatus")));
            return;
        }
        if (i2 != 109) {
            switch (i2) {
                case 100:
                    if (this.G == null) {
                        return;
                    }
                    Bundle data = message.getData();
                    this.G.a(data.getLong("long_EstTimestamp"), p0.d.b(data.getLong("long_EventFlags")), data.getInt("int_hardwareRevision"), data.getInt("int_manufacturerID"), data.getInt("int_modelNumber"));
                    return;
                case 101:
                    if (this.H == null) {
                        return;
                    }
                    Bundle data2 = message.getData();
                    this.H.a(data2.getLong("long_EstTimestamp"), p0.d.b(data2.getLong("long_EventFlags")), data2.getInt("int_softwareRevision"), data2.getInt("int_supplementaryRevision", -2), data2.getLong("long_serialNumber"));
                    return;
                case 102:
                    return;
                case 103:
                    if (this.I == null) {
                        return;
                    }
                    Bundle data3 = message.getData();
                    this.I.a(data3.getLong("long_EstTimestamp"), p0.d.b(data3.getLong("long_EventFlags")), data3.getByteArray("arrayByte_rawDataBytes"));
                    return;
                default:
                    h1.a.a(J, "Unrecognized event received: " + message.arg1);
                    return;
            }
        }
    }
}
