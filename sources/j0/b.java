package j0;

import android.os.Bundle;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import java.util.ArrayList;
import v.e;

/* loaded from: classes.dex */
public class b {

    /* renamed from: g */
    private static final String f1962g = "b";

    /* renamed from: d */
    u.a f1966d;

    /* renamed from: a */
    int[] f1963a = new int[0];

    /* renamed from: b */
    String[] f1964b = new String[0];

    /* renamed from: c */
    public ArrayList f1965c = new ArrayList();

    /* renamed from: e */
    u.a f1967e = new u.a(201);

    /* renamed from: f */
    private final Object f1968f = new Object();

    public b(u.a aVar) {
        this.f1966d = aVar;
    }

    private int b(int i2) {
        synchronized (this.f1968f) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f1963a;
                if (i3 >= iArr.length) {
                    return -1;
                }
                if (iArr[i3] == i2) {
                    return i3;
                }
                i3++;
            }
        }
    }

    private Bundle d(int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putIntArray("arrayInt_deviceIDs", this.f1963a);
        bundle.putStringArray("arrayString_deviceIdentifierStrings", this.f1964b);
        bundle.putInt("int_changeCode", i2);
        bundle.putInt("int_changingDeviceID", i3);
        return bundle;
    }

    public void a(a aVar) {
        synchronized (this.f1968f) {
            a c3 = c(aVar.f1957c.f708b);
            if (c3 != null) {
                String str = f1962g;
                h1.a.a(str, "Adding device to list that already exists");
                if (c3.f1957c.f718l.f720b.equals(aVar.f1957c.f718l.f720b)) {
                    h1.a.j(str, "Existing device has mismatched identifier string");
                }
                return;
            }
            int[] iArr = this.f1963a;
            int length = iArr.length;
            int i2 = length + 1;
            int[] iArr2 = new int[i2];
            String[] strArr = new String[i2];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            iArr2[length] = aVar.f1957c.f708b;
            this.f1963a = iArr2;
            System.arraycopy(this.f1964b, 0, strArr, 0, length);
            strArr[length] = aVar.f1957c.f718l.f720b;
            this.f1964b = strArr;
            this.f1965c.add(aVar);
            this.f1966d.a(d(AntPlusGeocachePcc.a.ADDED_TO_LIST.b(), aVar.f1957c.f708b));
        }
    }

    public a c(int i2) {
        synchronized (this.f1968f) {
            int b3 = b(i2);
            if (b3 < 0) {
                return null;
            }
            return (a) this.f1965c.get(b3);
        }
    }

    public boolean e(int i2) {
        synchronized (this.f1968f) {
            int b3 = b(i2);
            if (b3 < 0) {
                h1.a.a(f1962g, "Removing device that doesn't exist");
                return false;
            }
            int[] iArr = this.f1963a;
            int length = iArr.length;
            int i3 = length - 1;
            int[] iArr2 = new int[i3];
            String[] strArr = new String[i3];
            System.arraycopy(iArr, 0, iArr2, 0, b3);
            int i4 = b3 + 1;
            int i5 = length - i4;
            System.arraycopy(this.f1963a, i4, iArr2, b3, i5);
            this.f1963a = iArr2;
            System.arraycopy(this.f1964b, 0, strArr, 0, b3);
            System.arraycopy(this.f1964b, i4, strArr, b3, i5);
            this.f1964b = strArr;
            this.f1965c.remove(b3);
            this.f1966d.a(d(AntPlusGeocachePcc.a.REMOVED_FROM_LIST.b(), i2));
            return true;
        }
    }

    public void f(int i2) {
        synchronized (this.f1968f) {
            int b3 = b(i2);
            if (b3 < 0) {
                return;
            }
            this.f1964b[b3] = ((a) this.f1965c.get(b3)).f1957c.f718l.f720b;
            this.f1966d.a(d(AntPlusGeocachePcc.a.PROGRAMMED.b(), i2));
        }
    }

    public void g(e.a aVar) {
        synchronized (this.f1968f) {
            this.f1967e.c(aVar.f3454c, aVar.f3455d);
            this.f1967e.a(d(AntPlusGeocachePcc.a.NO_CHANGE.b(), -1));
            this.f1967e.d(aVar.f3454c);
        }
    }
}
