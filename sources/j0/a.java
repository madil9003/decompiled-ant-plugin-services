package j0;

import android.os.SystemClock;
import android.util.SparseArray;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import x.e;
import x.f;
import x.g;

/* loaded from: classes.dex */
public class a {

    /* renamed from: h */
    private static final String f1951h = "a";

    /* renamed from: i */
    private static e f1952i = new e();

    /* renamed from: j */
    private static f f1953j = new f();

    /* renamed from: k */
    private static g f1954k = new g();

    /* renamed from: a */
    private long f1955a;

    /* renamed from: c */
    public AntPlusGeocachePcc.GeocacheDeviceData f1957c;

    /* renamed from: b */
    SparseArray f1956b = new SparseArray();

    /* renamed from: d */
    private boolean f1958d = false;

    /* renamed from: e */
    private int f1959e = -1;

    /* renamed from: f */
    int f1960f = -1;

    /* renamed from: g */
    StringBuilder f1961g = null;

    public a(int i2) {
        AntPlusGeocachePcc.GeocacheDeviceData geocacheDeviceData = new AntPlusGeocachePcc.GeocacheDeviceData();
        this.f1957c = geocacheDeviceData;
        geocacheDeviceData.f708b = i2;
    }

    private boolean c(int i2, AntMessageParcel antMessageParcel) {
        String str;
        StringBuilder sb;
        int i3;
        int i4 = 2;
        byte b3 = antMessageParcel.a()[2];
        if (b3 != -1) {
            if (b3 == 0) {
                this.f1957c.f718l.f722d = new BigDecimal(w.c.h(antMessageParcel.a(), 3)).multiply(i0.a.f1850p).setScale(9, RoundingMode.HALF_UP);
            } else if (b3 == 1) {
                this.f1957c.f718l.f723e = new BigDecimal(w.c.h(antMessageParcel.a(), 3)).multiply(i0.a.f1850p).setScale(9, RoundingMode.HALF_UP);
            } else if (b3 == 2) {
                Boolean bool = (Boolean) this.f1956b.get(i2 - 1);
                if (bool == null || !bool.booleanValue() || ((i3 = this.f1960f) != -1 && i2 != i3 + 1)) {
                    h1.a.i(f1951h, "Decoder " + this.f1957c.f708b + " - out of order hint string page not decoding...lhspg: " + this.f1960f + ", pageNum" + i2 + ", pbf" + bool + ", p5" + this.f1956b.get(5));
                    return false;
                }
                this.f1960f = antMessageParcel.a()[1];
                if (this.f1961g == null) {
                    this.f1961g = new StringBuilder();
                }
                while (true) {
                    if (i4 >= 8) {
                        break;
                    }
                    i4++;
                    char i5 = (char) w.c.i(antMessageParcel.a()[i4]);
                    this.f1961g.append(i5);
                    if (i5 == 0) {
                        this.f1957c.f718l.f724f = this.f1961g.toString();
                        break;
                    }
                }
            } else if (b3 != 4) {
                str = f1951h;
                sb = new StringBuilder();
                sb.append("Unknown programmed page type received: ");
                sb.append((int) b3);
            } else {
                this.f1959e = i2;
                long n2 = w.c.n(antMessageParcel.a(), 3);
                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                gregorianCalendar.setTimeInMillis((n2 * 1000) + 631065600000L);
                AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData = this.f1957c.f718l;
                programmableGeocacheDeviceData.f725g = gregorianCalendar;
                programmableGeocacheDeviceData.f726h = Integer.valueOf(w.c.k(antMessageParcel.a(), 7));
            }
            return true;
        }
        str = f1951h;
        sb = new StringBuilder();
        sb.append("Detected device broadcasting the invalid page type within the valid page range on page ");
        sb.append((int) antMessageParcel.a()[1]);
        h1.a.a(str, sb.toString());
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x002b. Please report as an issue. */
    public void a(AntMessageParcel antMessageParcel) {
        String str;
        String str2;
        this.f1955a = SystemClock.elapsedRealtime();
        int i2 = w.c.i(antMessageParcel.a()[1]);
        if (((Boolean) this.f1956b.get(i2, Boolean.FALSE)).booleanValue()) {
            return;
        }
        int i3 = 32;
        if (i2 != 0) {
            if (i2 != 1) {
                switch (i2) {
                    case 80:
                        f1952i.f(antMessageParcel);
                        AntPlusGeocachePcc.GeocacheDeviceData geocacheDeviceData = this.f1957c;
                        e eVar = f1952i;
                        geocacheDeviceData.f710d = eVar.f3537b;
                        geocacheDeviceData.f709c = eVar.f3536a;
                        geocacheDeviceData.f711e = eVar.f3538c;
                        break;
                    case 81:
                        f1953j.f(antMessageParcel);
                        AntPlusGeocachePcc.GeocacheDeviceData geocacheDeviceData2 = this.f1957c;
                        f fVar = f1953j;
                        geocacheDeviceData2.f713g = fVar.f3542c;
                        geocacheDeviceData2.f712f = fVar.f3540a;
                        break;
                    case 82:
                        f1954k.f(antMessageParcel);
                        this.f1957c.f716j = p0.a.c(f1954k.f3546c);
                        AntPlusGeocachePcc.GeocacheDeviceData geocacheDeviceData3 = this.f1957c;
                        g gVar = f1954k;
                        geocacheDeviceData3.f715i = gVar.f3545b;
                        geocacheDeviceData3.f714h = gVar.f3544a;
                        geocacheDeviceData3.f717k = gVar.f3547d;
                        break;
                    default:
                        if (i2 <= 1 || i2 >= 31) {
                            str = f1951h;
                            str2 = "Unknown page received, page " + i2;
                            break;
                        } else if (!c(i2, antMessageParcel)) {
                            return;
                        }
                        break;
                }
            } else {
                this.f1957c.f718l.f721c = Long.valueOf(w.c.n(antMessageParcel.a(), 3));
                int i4 = antMessageParcel.a()[7] & 255;
                if (i4 != 255) {
                    if (i4 > 32) {
                        h1.a.a(f1951h, "Device reported more programmable pages than 32, ignoring.");
                    } else {
                        i3 = i4;
                    }
                    for (int i5 = 2; i5 < i3; i5++) {
                        if (this.f1956b.indexOfKey(i5) < 0) {
                            this.f1956b.put(i5, Boolean.FALSE);
                        }
                    }
                    for (int i6 = 80; i6 < 83; i6++) {
                        if (this.f1956b.indexOfKey(i6) < 0) {
                            this.f1956b.put(i6, Boolean.FALSE);
                        }
                    }
                }
            }
            this.f1956b.put(i2, Boolean.TRUE);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((antMessageParcel.a()[2] >> 2) & 63) + 32));
        sb.append((char) (((antMessageParcel.a()[2] << 4) & 48) + ((antMessageParcel.a()[3] >> 4) & 15) + 32));
        sb.append((char) (((antMessageParcel.a()[3] << 2) & 60) + ((antMessageParcel.a()[4] >> 6) & 3) + 32));
        sb.append((char) (((antMessageParcel.a()[4] >> 0) & 63) + 32));
        sb.append((char) (((antMessageParcel.a()[5] >> 2) & 63) + 32));
        sb.append((char) (((antMessageParcel.a()[5] << 4) & 48) + ((antMessageParcel.a()[6] >> 4) & 15) + 32));
        sb.append((char) (((antMessageParcel.a()[6] << 2) & 60) + (3 & (antMessageParcel.a()[7] >> 6)) + 32));
        sb.append((char) (((antMessageParcel.a()[7] >> 0) & 63) + 32));
        sb.append((char) (((antMessageParcel.a()[8] >> 2) & 63) + 32));
        this.f1957c.f718l.f720b = sb.toString();
        str = f1951h;
        str2 = "Got page 0, string ID: " + sb.toString();
        h1.a.i(str, str2);
        this.f1956b.put(i2, Boolean.TRUE);
    }

    public byte[] b(int i2) {
        return new byte[]{70, -1, -1, -1, -1, 15, (byte) i2, 1};
    }

    public int d() {
        SparseArray sparseArray = this.f1956b;
        Boolean bool = Boolean.FALSE;
        if (!((Boolean) sparseArray.get(0, bool)).booleanValue()) {
            return 0;
        }
        if (!((Boolean) this.f1956b.get(1, bool)).booleanValue()) {
            return 1;
        }
        for (int i2 = 0; i2 < this.f1956b.size(); i2++) {
            if (!((Boolean) this.f1956b.valueAt(i2)).booleanValue()) {
                return this.f1956b.keyAt(i2);
            }
        }
        return -1;
    }

    public long e() {
        return SystemClock.elapsedRealtime() - this.f1955a;
    }

    public int f() {
        if (((Boolean) this.f1956b.get(1, Boolean.FALSE)).booleanValue()) {
            return this.f1956b.size();
        }
        return -1;
    }

    public int g() {
        return this.f1959e;
    }

    public boolean h() {
        return this.f1958d || (d() < 0 && this.f1959e < 0);
    }

    public int i() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1956b.size(); i3++) {
            if (((Boolean) this.f1956b.valueAt(i3)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public void j(byte[] bArr) {
        long n2 = w.c.n(bArr, 2);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setTimeInMillis((n2 * 1000) + 631065600000L);
        AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData = this.f1957c.f718l;
        programmableGeocacheDeviceData.f725g = gregorianCalendar;
        programmableGeocacheDeviceData.f726h = Integer.valueOf(w.c.k(bArr, 6));
        h1.a.a(f1951h, "Updated visit count");
        this.f1958d = true;
    }
}
