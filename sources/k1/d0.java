package k1;

/* loaded from: classes.dex */
public class d0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2119g;

    static {
        s1 s1Var = new s1("device_info", 23);
        f2119g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("device_index", 0, 2, 1.0d, 0.0d, "", false, l2.DEVICE_INDEX));
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("device_type", 1, 2, 1.0d, 0.0d, "", false, l2Var));
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("ble_device_type", 2, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(0)).b(25, 3L);
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("antplus_device_type", 2, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(1)).b(25, 1L);
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("ant_device_type", 2, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(2)).b(25, 0L);
        ((s0) s1Var.f2382d.get(2)).f2376k.add(new d3("local_device_type", 2, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(2)).f2376k.get(3)).b(25, 5L);
        s1Var.h(new s0("manufacturer", 2, 132, 1.0d, 0.0d, "", false, l2.MANUFACTURER));
        s1Var.h(new s0("serial_number", 3, 140, 1.0d, 0.0d, "", false, l2.UINT32Z));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("product", 4, 132, 1.0d, 0.0d, "", false, l2Var2));
        ((s0) s1Var.f2382d.get(5)).f2376k.add(new d3("favero_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(5)).f2376k.get(0)).b(2, 263L);
        ((s0) s1Var.f2382d.get(5)).f2376k.add(new d3("garmin_product", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(5)).f2376k.get(1)).b(2, 1L);
        ((d3) ((s0) s1Var.f2382d.get(5)).f2376k.get(1)).b(2, 15L);
        ((d3) ((s0) s1Var.f2382d.get(5)).f2376k.get(1)).b(2, 13L);
        ((d3) ((s0) s1Var.f2382d.get(5)).f2376k.get(1)).b(2, 89L);
        s1Var.h(new s0("software_version", 5, 132, 100.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("hardware_version", 6, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("cum_operating_time", 7, 134, 1.0d, 0.0d, "s", false, l2.UINT32));
        s1Var.h(new s0("battery_voltage", 10, 132, 256.0d, 0.0d, "V", false, l2Var2));
        s1Var.h(new s0("battery_status", 11, 2, 1.0d, 0.0d, "", false, l2.BATTERY_STATUS));
        s1Var.h(new s0("sensor_position", 18, 0, 1.0d, 0.0d, "", false, l2.BODY_LOCATION));
        l2 l2Var3 = l2.STRING;
        s1Var.h(new s0("descriptor", 19, 7, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("ant_transmission_type", 20, 10, 1.0d, 0.0d, "", false, l2.UINT8Z));
        s1Var.h(new s0("ant_device_number", 21, 139, 1.0d, 0.0d, "", false, l2.UINT16Z));
        s1Var.h(new s0("ant_network", 22, 0, 1.0d, 0.0d, "", false, l2.ANT_NETWORK));
        s1Var.h(new s0("source_type", 25, 0, 1.0d, 0.0d, "", false, l2.SOURCE_TYPE));
        s1Var.h(new s0("product_name", 27, 7, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("battery_level", 32, 2, 1.0d, 0.0d, "%", false, l2Var));
    }

    public d0(s1 s1Var) {
        super(s1Var);
    }
}
