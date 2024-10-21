package c1;

import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Field;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    private static final String f282a = "a";

    public static DataPoint a(DataSource dataSource, long j2) {
        if (dataSource == null) {
            h1.a.b(f282a, "Data point cannot be created from null DataSource");
            return null;
        }
        DataPoint a3 = DataPoint.a(dataSource);
        a3.g(j2, TimeUnit.MILLISECONDS);
        return a3;
    }

    public static DataPoint b(DataSource dataSource, long j2, long j3) {
        if (dataSource == null) {
            h1.a.b(f282a, "Data point cannot be created from null DataSource");
            return null;
        }
        DataPoint a3 = DataPoint.a(dataSource);
        a3.f(j2, j3, TimeUnit.MILLISECONDS);
        return a3;
    }

    public static void c(DataPoint dataPoint, BigDecimal bigDecimal) {
        dataPoint.e(Field.f1527o).d(bigDecimal.floatValue());
    }

    public static void d(DataPoint dataPoint, int i2) {
        dataPoint.e(Field.f1517j).d(i2);
    }

    public static void e(DataPoint dataPoint, long j2) {
        dataPoint.e(Field.f1511g).e((int) j2);
    }
}
