package g;

import com.dsi.ant.channel.ipc.ServiceResult;
import com.dsi.ant.message.ipc.AntMessageParcel;
import k.i;
import l.k;

/* loaded from: classes.dex */
public class a extends Exception {

    /* renamed from: a */
    private b f1713a;

    /* renamed from: b */
    private k f1714b;

    /* renamed from: c */
    private AntMessageParcel f1715c;

    public a(k kVar, ServiceResult serviceResult) {
        super(c(serviceResult));
        this.f1713a = b.UNKNOWN;
        this.f1715c = null;
        this.f1714b = kVar;
        if (serviceResult != null) {
            this.f1713a = serviceResult.g();
            this.f1715c = serviceResult.e();
        }
    }

    private static String c(ServiceResult serviceResult) {
        return serviceResult == null ? "Null result" : serviceResult.f();
    }

    public b a() {
        return this.f1713a;
    }

    public i b() {
        if (b.CHANNEL_RESPONSE == this.f1713a) {
            return new i(this.f1715c);
        }
        return null;
    }
}
