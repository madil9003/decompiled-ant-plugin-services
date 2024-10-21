package k1;

/* loaded from: classes.dex */
public class l0 extends s1 implements z1 {

    /* renamed from: g */
    protected static final s1 f2238g;

    static {
        s1 s1Var = new s1("event", 21);
        f2238g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2.DATE_TIME));
        s1Var.h(new s0("event", 0, 0, 1.0d, 0.0d, "", false, l2.EVENT));
        s1Var.h(new s0("event_type", 1, 0, 1.0d, 0.0d, "", false, l2.EVENT_TYPE));
        l2 l2Var = l2.UINT16;
        s1Var.h(new s0("data16", 2, 132, 1.0d, 0.0d, "", false, l2Var));
        ((s0) s1Var.f2382d.get(3)).f2375j.add(new w0(3, false, 16, 1.0d, 0.0d));
        s1Var.h(new s0("data", 3, 134, 1.0d, 0.0d, "", false, l2.UINT32));
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("timer_trigger", 0, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(0)).b(0, 0L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("course_point_index", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(1)).b(0, 10L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("battery_level", 132, 1000.0d, 0.0d, "V"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(2)).b(0, 11L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("virtual_partner_speed", 132, 1000.0d, 0.0d, "m/s"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(3)).b(0, 12L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("hr_high_alert", 2, 1.0d, 0.0d, "bpm"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(4)).b(0, 13L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("hr_low_alert", 2, 1.0d, 0.0d, "bpm"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(5)).b(0, 14L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("speed_high_alert", 134, 1000.0d, 0.0d, "m/s"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(6)).b(0, 15L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("speed_low_alert", 134, 1000.0d, 0.0d, "m/s"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(7)).b(0, 16L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("cad_high_alert", 132, 1.0d, 0.0d, "rpm"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(8)).b(0, 17L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("cad_low_alert", 132, 1.0d, 0.0d, "rpm"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(9)).b(0, 18L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("power_high_alert", 132, 1.0d, 0.0d, "watts"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(10)).b(0, 19L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("power_low_alert", 132, 1.0d, 0.0d, "watts"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(11)).b(0, 20L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("time_duration_alert", 134, 1000.0d, 0.0d, "s"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(12)).b(0, 23L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("distance_duration_alert", 134, 100.0d, 0.0d, "m"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(13)).b(0, 24L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("calorie_duration_alert", 134, 1.0d, 0.0d, "calories"));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(14)).b(0, 25L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("fitness_equipment_state", 0, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(15)).b(0, 27L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("sport_point", 134, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(16)).b(0, 33L);
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(16)).a(new w0(7, false, 16, 1.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(16)).a(new w0(8, false, 16, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("gear_change_data", 134, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(17)).b(0, 42L);
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(17)).b(0, 43L);
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(17)).a(new w0(11, false, 8, 1.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(17)).a(new w0(12, false, 8, 1.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(17)).a(new w0(9, false, 8, 1.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(17)).a(new w0(10, false, 8, 1.0d, 0.0d));
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("rider_position", 0, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(18)).b(0, 44L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("comm_timeout", 132, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(19)).b(0, 47L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("dive_alert", 0, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(20)).b(0, 56L);
        ((s0) s1Var.f2382d.get(4)).f2376k.add(new d3("radar_threat_alert", 134, 1.0d, 0.0d, ""));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(21)).b(0, 75L);
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(21)).a(new w0(21, false, 8, 1.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(21)).a(new w0(22, false, 8, 1.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(21)).a(new w0(23, false, 8, 10.0d, 0.0d));
        ((d3) ((s0) s1Var.f2382d.get(4)).f2376k.get(21)).a(new w0(24, false, 8, 10.0d, 0.0d));
        l2 l2Var2 = l2.UINT8;
        s1Var.h(new s0("event_group", 4, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("score", 7, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("opponent_score", 8, 132, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var3 = l2.UINT8Z;
        s1Var.h(new s0("front_gear_num", 9, 10, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("front_gear", 10, 10, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("rear_gear_num", 11, 10, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("rear_gear", 12, 10, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("device_index", 13, 2, 1.0d, 0.0d, "", false, l2.DEVICE_INDEX));
        s1Var.h(new s0("radar_threat_level_max", 21, 0, 1.0d, 0.0d, "", false, l2.RADAR_THREAT_LEVEL_TYPE));
        s1Var.h(new s0("radar_threat_count", 22, 2, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("radar_threat_avg_approach_speed", 23, 2, 10.0d, 0.0d, "m/s", false, l2Var2));
        s1Var.h(new s0("radar_threat_max_approach_speed", 24, 2, 10.0d, 0.0d, "m/s", false, l2Var2));
    }

    public l0(s1 s1Var) {
        super(s1Var);
    }

    @Override // k1.z1
    public Short a() {
        return n(4, 0, 65535);
    }

    @Override // k1.z1
    public void b(w wVar) {
        s(253, 0, wVar.e(), 65535);
    }

    @Override // k1.z1
    public void c(m0 m0Var) {
        s(1, 0, Short.valueOf(m0Var.f2338a), 65535);
    }

    @Override // k1.z1
    public m0 d() {
        Short n2 = n(1, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return m0.a(n2);
    }

    @Override // k1.z1
    public w e() {
        return u(m(253, 0, 65535));
    }

    @Override // k1.z1
    public k0 f() {
        Short n2 = n(0, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return k0.a(n2);
    }
}
