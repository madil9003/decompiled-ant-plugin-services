package k1;

/* loaded from: classes.dex */
public class e2 extends s1 {

    /* renamed from: g */
    protected static final s1 f2171g;

    static {
        s1 s1Var = new s1("monitoring", 55);
        f2171g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("device_index", 0, 2, 1.0d, 0.0d, "", false, l2.DEVICE_INDEX));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("calories", 1, 132, 1.0d, 0.0d, "kcal", false, l2Var));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("distance", 2, 134, 100.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("cycles", 3, 134, 2.0d, 0.0d, "cycles", false, l2Var2));
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("steps", 134, 1.0d, 0.0d, "steps"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(0)).b(5, 6L);
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(0)).b(5, 1L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("strokes", 134, 2.0d, 0.0d, "strokes"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(1)).b(5, 2L);
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(1)).b(5, 5L);
        s1Var.h(new s0("active_time", 4, 134, 1000.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("activity_type", 5, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY_TYPE));
        s1Var.h(new s0("activity_subtype", 6, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY_SUBTYPE));
        s1Var.h(new s0("activity_level", 7, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY_LEVEL));
        s1Var.h(new s0("distance_16", 8, 132, 1.0d, 0.0d, "100 * m", false, l2Var));
        s1Var.h(new s0("cycles_16", 9, 132, 1.0d, 0.0d, "2 * cycles (steps)", false, l2Var));
        s1Var.h(new s0("active_time_16", 10, 132, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("local_timestamp", 11, 134, 1.0d, 0.0d, "", false, l2.LOCAL_DATE_TIME));
        l2 l2Var3 = l2.SINT16;
        s1Var.h(new s0("temperature", 12, 131, 100.0d, 0.0d, "C", false, l2Var3));
        s1Var.h(new s0("temperature_min", 14, 131, 100.0d, 0.0d, "C", false, l2Var3));
        s1Var.h(new s0("temperature_max", 15, 131, 100.0d, 0.0d, "C", false, l2Var3));
        s1Var.h(new s0("activity_time", 16, 132, 1.0d, 0.0d, "minutes", false, l2Var));
        s1Var.h(new s0("active_calories", 19, 132, 1.0d, 0.0d, "kcal", false, l2Var));
        s1Var.h(new s0("current_activity_type_intensity", 24, 13, 1.0d, 0.0d, "", false, l2.BYTE));
        ((s0) s1Var.f2382d.get(18)).f2375j.add(new w0(5, false, 5, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(18)).f2375j.add(new w0(28, false, 3, 1.0d, 0.0d));
        l2 l2Var4 = l2.UINT8;
        s1Var.h(new s0("timestamp_min_8", 25, 2, 1.0d, 0.0d, "min", false, l2Var4));
        s1Var.h(new s0("timestamp_16", 26, 132, 1.0d, 0.0d, "s", false, l2Var));
        s1Var.h(new s0("heart_rate", 27, 2, 1.0d, 0.0d, "bpm", false, l2Var4));
        s1Var.h(new s0("intensity", 28, 2, 10.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("duration_min", 29, 132, 1.0d, 0.0d, "min", false, l2Var));
        s1Var.h(new s0("duration", 30, 134, 1.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("ascent", 31, 134, 1000.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("descent", 32, 134, 1000.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("moderate_activity_minutes", 33, 132, 1.0d, 0.0d, "minutes", false, l2Var));
        s1Var.h(new s0("vigorous_activity_minutes", 34, 132, 1.0d, 0.0d, "minutes", false, l2Var));
    }

    public e2(s1 s1Var) {
        super(s1Var);
    }
}
