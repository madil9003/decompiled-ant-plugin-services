package x0;

import android.os.Bundle;
import android.os.SystemClock;
import com.dsi.ant.plugins.antplus.pcc.AntPlusWatchDownloaderPcc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import s0.j;
import v.e;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d */
    private static final String f3554d = "a";

    /* renamed from: a */
    private u.a f3555a;

    /* renamed from: b */
    private u.a f3556b = new u.a(201);

    /* renamed from: c */
    public ArrayList f3557c = new ArrayList();

    /* renamed from: x0.a$a */
    /* loaded from: classes.dex */
    public static class C0067a {

        /* renamed from: a */
        public final j.b f3558a;

        /* renamed from: b */
        public final int f3559b;

        /* renamed from: c */
        public final int f3560c;

        /* renamed from: d */
        private long f3561d = SystemClock.elapsedRealtime();

        /* renamed from: e */
        public final AntPlusWatchDownloaderPcc.DeviceInfo f3562e;

        public C0067a(j.b bVar, AntPlusWatchDownloaderPcc.DeviceInfo deviceInfo, int i2) {
            this.f3558a = bVar;
            this.f3562e = deviceInfo;
            this.f3559b = i2 < 0 ? 4096 : i2;
            this.f3560c = 50;
        }

        public long a() {
            return SystemClock.elapsedRealtime() - this.f3561d;
        }

        public void b() {
            this.f3561d = SystemClock.elapsedRealtime();
        }
    }

    public a(u.a aVar) {
        this.f3555a = aVar;
    }

    private Bundle a(int i2, C0067a c0067a) {
        AntPlusWatchDownloaderPcc.DeviceInfo[] deviceInfoArr;
        synchronized (this.f3557c) {
            deviceInfoArr = new AntPlusWatchDownloaderPcc.DeviceInfo[this.f3557c.size()];
            for (int i3 = 0; i3 < this.f3557c.size(); i3++) {
                deviceInfoArr[i3] = ((C0067a) this.f3557c.get(i3)).f3562e;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("arrayParcelable_deviceInfos", deviceInfoArr);
        bundle.putInt("int_listUpdateCode", i2);
        if (c0067a != null) {
            bundle.putParcelable("parcelable_changingDeviceInfo", c0067a.f3562e);
        }
        return bundle;
    }

    public void b(C0067a c0067a) {
        synchronized (this.f3557c) {
            if (this.f3557c.remove(c0067a)) {
                this.f3555a.a(a(AntPlusWatchDownloaderPcc.b.DEVICE_REMOVED_FROM_LIST.b(), c0067a));
            }
        }
    }

    public C0067a c(j.b bVar, byte[] bArr, c cVar) {
        StringBuilder sb;
        synchronized (this.f3557c) {
            int b3 = j.b(bArr);
            if (b3 != 1 && b3 != 257) {
                return null;
            }
            int a3 = j.a(bArr);
            boolean d3 = j.d(bArr);
            int c3 = j.c(bArr);
            h1.a.i(f3554d, "DETECT: dev#" + bVar.a() + ", type-" + a3 + ", dataFlagUp: " + d3 + ", period:" + c3);
            Iterator it = this.f3557c.iterator();
            while (it.hasNext()) {
                C0067a c0067a = (C0067a) it.next();
                if (bVar.a() == c0067a.f3558a.a() && a3 == c0067a.f3562e.a() && b3 == c0067a.f3562e.b()) {
                    c0067a.b();
                    return c0067a;
                }
            }
            AntPlusWatchDownloaderPcc.DeviceInfo f3 = cVar.f(b3, a3, bVar.a());
            if (f3 == null) {
                if (b3 != 257) {
                    switch (a3) {
                        case 988:
                            sb = new StringBuilder();
                            sb.append("FR60-");
                            sb.append(bVar.a());
                            break;
                        case 1018:
                        case 1446:
                            sb = new StringBuilder();
                            sb.append("FR310XT-");
                            sb.append(bVar.a());
                            break;
                        case 1328:
                        case 1537:
                        case 1600:
                        case 1664:
                            sb = new StringBuilder();
                            sb.append("FR910XT-");
                            sb.append(bVar.a());
                            break;
                        case 1345:
                        case 1410:
                            sb = new StringBuilder();
                            sb.append("FR610-");
                            sb.append(bVar.a());
                            break;
                        case 1436:
                            sb = new StringBuilder();
                            sb.append("FR70-");
                            sb.append(bVar.a());
                            break;
                        case 1499:
                            sb = new StringBuilder();
                            sb.append("Swim-");
                            sb.append(bVar.a());
                            break;
                        default:
                            return null;
                    }
                } else {
                    if (a3 != 1314) {
                        return null;
                    }
                    sb = new StringBuilder();
                    sb.append("AIT Sport Watch-");
                    sb.append(bVar.a());
                }
                f3 = new AntPlusWatchDownloaderPcc.DeviceInfo(UUID.randomUUID(), b3, a3, sb.toString());
            }
            C0067a c0067a2 = new C0067a(bVar, f3, c3);
            this.f3557c.add(c0067a2);
            this.f3555a.a(a(AntPlusWatchDownloaderPcc.b.DEVICE_ADDED_TO_LIST.b(), c0067a2));
            return c0067a2;
        }
    }

    public void d(e.a aVar) {
        synchronized (this.f3556b) {
            this.f3556b.c(aVar.f3454c, aVar.f3455d);
            this.f3556b.a(a(AntPlusWatchDownloaderPcc.b.NO_CHANGE.b(), null));
            this.f3556b.d(aVar.f3454c);
        }
    }
}
