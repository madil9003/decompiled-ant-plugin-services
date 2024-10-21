package k1;

/* loaded from: classes.dex */
public class s2 extends s1 implements z1 {

    /* renamed from: g */
    protected static final s1 f2385g;

    static {
        s1 s1Var = new s1("segment_lap", 142);
        f2385g = s1Var;
        l2 l2Var = l2.MESSAGE_INDEX;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("event", 0, 0, 1.0d, 0.0d, "", false, l2.EVENT));
        s1Var.h(new s0("event_type", 1, 0, 1.0d, 0.0d, "", false, l2.EVENT_TYPE));
        s1Var.h(new s0("start_time", 2, 134, 1.0d, 0.0d, "", false, l2Var2));
        l2 l2Var3 = l2.SINT32;
        s1Var.h(new s0("start_position_lat", 3, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("start_position_long", 4, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("end_position_lat", 5, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("end_position_long", 6, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        l2 l2Var4 = l2.UINT32;
        s1Var.h(new s0("total_elapsed_time", 7, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("total_timer_time", 8, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("total_distance", 9, 134, 100.0d, 0.0d, "m", false, l2Var4));
        s1Var.h(new s0("total_cycles", 10, 134, 1.0d, 0.0d, "cycles", false, l2Var4));
        ((s0) s1Var.f2382d.get(12)).f2376k.add(new d3("total_strokes", 134, 1.0d, 0.0d, "strokes"));
        ((d3) ((s0) s1Var.f2382d.get(12)).f2376k.get(0)).b(23, 2L);
        l2 l2Var5 = l2.UINT16;
        s1Var.h(new s0("total_calories", 11, 132, 1.0d, 0.0d, "kcal", false, l2Var5));
        s1Var.h(new s0("total_fat_calories", 12, 132, 1.0d, 0.0d, "kcal", false, l2Var5));
        s1Var.h(new s0("avg_speed", 13, 132, 1000.0d, 0.0d, "m/s", false, l2Var5));
        s1Var.h(new s0("max_speed", 14, 132, 1000.0d, 0.0d, "m/s", false, l2Var5));
        l2 l2Var6 = l2.UINT8;
        s1Var.h(new s0("avg_heart_rate", 15, 2, 1.0d, 0.0d, "bpm", false, l2Var6));
        s1Var.h(new s0("max_heart_rate", 16, 2, 1.0d, 0.0d, "bpm", false, l2Var6));
        s1Var.h(new s0("avg_cadence", 17, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("max_cadence", 18, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("avg_power", 19, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("max_power", 20, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("total_ascent", 21, 132, 1.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("total_descent", 22, 132, 1.0d, 0.0d, "m", false, l2Var5));
        s1Var.h(new s0("sport", 23, 0, 1.0d, 0.0d, "", false, l2.SPORT));
        s1Var.h(new s0("event_group", 24, 2, 1.0d, 0.0d, "", false, l2Var6));
        s1Var.h(new s0("nec_lat", 25, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("nec_long", 26, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("swc_lat", 27, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        s1Var.h(new s0("swc_long", 28, 133, 1.0d, 0.0d, "semicircles", false, l2Var3));
        l2 l2Var7 = l2.STRING;
        s1Var.h(new s0("name", 29, 7, 1.0d, 0.0d, "", false, l2Var7));
        s1Var.h(new s0("normalized_power", 30, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("left_right_balance", 31, 132, 1.0d, 0.0d, "", false, l2.LEFT_RIGHT_BALANCE_100));
        s1Var.h(new s0("sub_sport", 32, 0, 1.0d, 0.0d, "", false, l2.SUB_SPORT));
        s1Var.h(new s0("total_work", 33, 134, 1.0d, 0.0d, "J", false, l2Var4));
        s1Var.h(new s0("avg_altitude", 34, 132, 5.0d, 500.0d, "m", false, l2Var5));
        ((s0) s1Var.f2382d.get(36)).f2375j.add(new w0(91, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("max_altitude", 35, 132, 5.0d, 500.0d, "m", false, l2Var5));
        ((s0) s1Var.f2382d.get(37)).f2375j.add(new w0(92, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("gps_accuracy", 36, 2, 1.0d, 0.0d, "m", false, l2Var6));
        l2 l2Var8 = l2.SINT16;
        s1Var.h(new s0("avg_grade", 37, 131, 100.0d, 0.0d, "%", false, l2Var8));
        s1Var.h(new s0("avg_pos_grade", 38, 131, 100.0d, 0.0d, "%", false, l2Var8));
        s1Var.h(new s0("avg_neg_grade", 39, 131, 100.0d, 0.0d, "%", false, l2Var8));
        s1Var.h(new s0("max_pos_grade", 40, 131, 100.0d, 0.0d, "%", false, l2Var8));
        s1Var.h(new s0("max_neg_grade", 41, 131, 100.0d, 0.0d, "%", false, l2Var8));
        l2 l2Var9 = l2.SINT8;
        s1Var.h(new s0("avg_temperature", 42, 1, 1.0d, 0.0d, "C", false, l2Var9));
        s1Var.h(new s0("max_temperature", 43, 1, 1.0d, 0.0d, "C", false, l2Var9));
        s1Var.h(new s0("total_moving_time", 44, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("avg_pos_vertical_speed", 45, 131, 1000.0d, 0.0d, "m/s", false, l2Var8));
        s1Var.h(new s0("avg_neg_vertical_speed", 46, 131, 1000.0d, 0.0d, "m/s", false, l2Var8));
        s1Var.h(new s0("max_pos_vertical_speed", 47, 131, 1000.0d, 0.0d, "m/s", false, l2Var8));
        s1Var.h(new s0("max_neg_vertical_speed", 48, 131, 1000.0d, 0.0d, "m/s", false, l2Var8));
        s1Var.h(new s0("time_in_hr_zone", 49, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_in_speed_zone", 50, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_in_cadence_zone", 51, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("time_in_power_zone", 52, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("repetition_num", 53, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("min_altitude", 54, 132, 5.0d, 500.0d, "m", false, l2Var5));
        ((s0) s1Var.f2382d.get(56)).f2375j.add(new w0(93, false, 16, 5.0d, 500.0d));
        s1Var.h(new s0("min_heart_rate", 55, 2, 1.0d, 0.0d, "bpm", false, l2Var6));
        s1Var.h(new s0("active_time", 56, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("wkt_step_index", 57, 132, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("sport_event", 58, 0, 1.0d, 0.0d, "", false, l2.SPORT_EVENT));
        s1Var.h(new s0("avg_left_torque_effectiveness", 59, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_right_torque_effectiveness", 60, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_left_pedal_smoothness", 61, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_right_pedal_smoothness", 62, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("avg_combined_pedal_smoothness", 63, 2, 2.0d, 0.0d, "percent", false, l2Var6));
        s1Var.h(new s0("status", 64, 0, 1.0d, 0.0d, "", false, l2.SEGMENT_LAP_STATUS));
        s1Var.h(new s0("uuid", 65, 7, 1.0d, 0.0d, "", false, l2Var7));
        s1Var.h(new s0("avg_fractional_cadence", 66, 2, 128.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("max_fractional_cadence", 67, 2, 128.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("total_fractional_cycles", 68, 2, 128.0d, 0.0d, "cycles", false, l2Var6));
        s1Var.h(new s0("front_gear_shift_count", 69, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("rear_gear_shift_count", 70, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("time_standing", 71, 134, 1000.0d, 0.0d, "s", false, l2Var4));
        s1Var.h(new s0("stand_count", 72, 132, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("avg_left_pco", 73, 1, 1.0d, 0.0d, "mm", false, l2Var9));
        s1Var.h(new s0("avg_right_pco", 74, 1, 1.0d, 0.0d, "mm", false, l2Var9));
        s1Var.h(new s0("avg_left_power_phase", 75, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_left_power_phase_peak", 76, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_right_power_phase", 77, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_right_power_phase_peak", 78, 2, 0.7111111d, 0.0d, "degrees", false, l2Var6));
        s1Var.h(new s0("avg_power_position", 79, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("max_power_position", 80, 132, 1.0d, 0.0d, "watts", false, l2Var5));
        s1Var.h(new s0("avg_cadence_position", 81, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("max_cadence_position", 82, 2, 1.0d, 0.0d, "rpm", false, l2Var6));
        s1Var.h(new s0("manufacturer", 83, 132, 1.0d, 0.0d, "", false, l2.MANUFACTURER));
        l2 l2Var10 = l2.FLOAT32;
        s1Var.h(new s0("total_grit", 84, 136, 1.0d, 0.0d, "kGrit", false, l2Var10));
        s1Var.h(new s0("total_flow", 85, 136, 1.0d, 0.0d, "Flow", false, l2Var10));
        s1Var.h(new s0("avg_grit", 86, 136, 1.0d, 0.0d, "kGrit", false, l2Var10));
        s1Var.h(new s0("avg_flow", 87, 136, 1.0d, 0.0d, "Flow", false, l2Var10));
        s1Var.h(new s0("total_fractional_ascent", 89, 2, 100.0d, 0.0d, "m", false, l2Var6));
        s1Var.h(new s0("total_fractional_descent", 90, 2, 100.0d, 0.0d, "m", false, l2Var6));
        s1Var.h(new s0("enhanced_avg_altitude", 91, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("enhanced_max_altitude", 92, 134, 5.0d, 500.0d, "m", false, l2Var4));
        s1Var.h(new s0("enhanced_min_altitude", 93, 134, 5.0d, 500.0d, "m", false, l2Var4));
    }

    public s2(s1 s1Var) {
        super(s1Var);
    }

    @Override // k1.z1
    public Short a() {
        return n(24, 0, 65535);
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
