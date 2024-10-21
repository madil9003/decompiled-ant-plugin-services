package g1;

import android.os.Bundle;
import com.dsi.ant.plugins.antplus.pcc.AntPlusGeocachePcc;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public abstract class a {
    public static AntPlusGeocachePcc.ProgrammableGeocacheDeviceData a(Bundle bundle) {
        AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData = new AntPlusGeocachePcc.ProgrammableGeocacheDeviceData();
        programmableGeocacheDeviceData.f720b = bundle.getString("string_identificationString");
        Long valueOf = Long.valueOf(bundle.getLong("long_PIN"));
        programmableGeocacheDeviceData.f721c = valueOf;
        if (valueOf.longValue() == -1) {
            programmableGeocacheDeviceData.f721c = null;
        }
        programmableGeocacheDeviceData.f722d = (BigDecimal) bundle.getSerializable("bigDecimal_latitude");
        programmableGeocacheDeviceData.f723e = (BigDecimal) bundle.getSerializable("bigDecimal_longitude");
        programmableGeocacheDeviceData.f724f = bundle.getString("string_hintString");
        programmableGeocacheDeviceData.f725g = (GregorianCalendar) bundle.getSerializable("gregorianCalendar_lastVisitTimestamp");
        Integer valueOf2 = Integer.valueOf(bundle.getInt("int_numberOfVisits"));
        programmableGeocacheDeviceData.f726h = valueOf2;
        if (valueOf2.intValue() == -1) {
            programmableGeocacheDeviceData.f726h = null;
        }
        return programmableGeocacheDeviceData;
    }

    public static void b(AntPlusGeocachePcc.GeocacheDeviceData geocacheDeviceData, Bundle bundle) {
        c(geocacheDeviceData.f718l, bundle);
        bundle.putInt("int_deviceID", geocacheDeviceData.f708b);
        bundle.putInt("int_hardwareRevision", geocacheDeviceData.f709c);
        bundle.putInt("int_manufacturerID", geocacheDeviceData.f710d);
        bundle.putInt("int_modelNumber", geocacheDeviceData.f711e);
        bundle.putInt("int_softwareRevision", geocacheDeviceData.f712f);
        bundle.putLong("long_serialNumber", geocacheDeviceData.f713g);
        bundle.putLong("long_cumulativeOperatingTime", geocacheDeviceData.f714h);
        bundle.putSerializable("decimal_batteryVoltage", geocacheDeviceData.f715i);
        bundle.putInt("int_batteryStatusCode", geocacheDeviceData.f716j.b());
        bundle.putInt("int_cumulativeOperatingTimeResolution", geocacheDeviceData.f717k);
    }

    public static void c(AntPlusGeocachePcc.ProgrammableGeocacheDeviceData programmableGeocacheDeviceData, Bundle bundle) {
        String str = programmableGeocacheDeviceData.f720b;
        if (str != null) {
            bundle.putString("string_identificationString", str);
        }
        Long l2 = programmableGeocacheDeviceData.f721c;
        bundle.putLong("long_PIN", l2 == null ? -1L : l2.longValue());
        BigDecimal bigDecimal = programmableGeocacheDeviceData.f722d;
        if (bigDecimal != null) {
            bundle.putSerializable("bigDecimal_latitude", bigDecimal);
        }
        BigDecimal bigDecimal2 = programmableGeocacheDeviceData.f723e;
        if (bigDecimal2 != null) {
            bundle.putSerializable("bigDecimal_longitude", bigDecimal2);
        }
        String str2 = programmableGeocacheDeviceData.f724f;
        if (str2 != null) {
            bundle.putString("string_hintString", str2);
        }
        GregorianCalendar gregorianCalendar = programmableGeocacheDeviceData.f725g;
        if (gregorianCalendar != null) {
            bundle.putSerializable("gregorianCalendar_lastVisitTimestamp", gregorianCalendar);
        }
        Integer num = programmableGeocacheDeviceData.f726h;
        bundle.putInt("int_numberOfVisits", num == null ? -1 : num.intValue());
    }
}
