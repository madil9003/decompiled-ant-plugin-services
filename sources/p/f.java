package p;

import com.dsi.ant.plugins.antplus.pcc.AntPlusBikePowerPcc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class f extends w.b {

    /* renamed from: a */
    private u.a f2884a = new u.a(209);

    /* renamed from: b */
    private u.a f2885b = new u.a(210);

    /* renamed from: c */
    private int f2886c = AntPlusBikePowerPcc.a.UNKNOWN.b();

    /* renamed from: d */
    private b f2887d;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2888a;

        static {
            int[] iArr = new int[AntPlusBikePowerPcc.b.values().length];
            f2888a = iArr;
            try {
                iArr[AntPlusBikePowerPcc.b.GENERAL_CALIBRATION_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2888a[AntPlusBikePowerPcc.b.GENERAL_CALIBRATION_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2888a[AntPlusBikePowerPcc.b.CAPABILITIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2888a[AntPlusBikePowerPcc.b.CTF_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2888a[AntPlusBikePowerPcc.b.CTF_ZERO_OFFSET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2888a[AntPlusBikePowerPcc.b.CUSTOM_CALIBRATION_RESPONSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2888a[AntPlusBikePowerPcc.b.CUSTOM_CALIBRATION_UPDATE_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2);
    }

    public f(b bVar) {
        this.f2887d = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // w.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(long r11, long r13, com.dsi.ant.message.ipc.AntMessageParcel r15) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p.f.b(long, long, com.dsi.ant.message.ipc.AntMessageParcel):void");
    }

    @Override // w.b
    public List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f2885b);
        arrayList.add(this.f2884a);
        return arrayList;
    }

    @Override // w.b
    public List d() {
        return Arrays.asList(1);
    }
}
