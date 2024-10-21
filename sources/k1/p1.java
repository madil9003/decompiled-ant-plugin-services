package k1;

/* loaded from: classes.dex */
public class p1 extends s1 implements z1 {

    /* renamed from: g */
    protected static final s1 f2354g;

    static {
        s1 s1Var = new s1("length", 101);
        f2354g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("event", 0, 0, 1.0d, 0.0d, "", false, l2.EVENT));
        s1Var.h(new s0("event_type", 1, 0, 1.0d, 0.0d, "", false, l2.EVENT_TYPE));
        s1Var.h(new s0("start_time", 2, 134, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("total_elapsed_time", 3, 134, 1000.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("total_timer_time", 4, 134, 1000.0d, 0.0d, "s", false, l2Var2));
        l2 l2Var3 = l2.UINT16;
        s1Var.h(new s0("total_strokes", 5, 132, 1.0d, 0.0d, "strokes", false, l2Var3));
        s1Var.h(new s0("avg_speed", 6, 132, 1000.0d, 0.0d, "m/s", false, l2Var3));
        s1Var.h(new s0("swim_stroke", 7, 0, 1.0d, 0.0d, "swim_stroke", false, l2.SWIM_STROKE));
        l2 l2Var4 = l2.UINT8;
        s1Var.h(new s0("avg_swimming_cadence", 9, 2, 1.0d, 0.0d, "strokes/min", false, l2Var4));
        s1Var.h(new s0("event_group", 10, 2, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("total_calories", 11, 132, 1.0d, 0.0d, "kcal", false, l2Var3));
        s1Var.h(new s0("length_type", 12, 0, 1.0d, 0.0d, "", false, l2.LENGTH_TYPE));
        s1Var.h(new s0("player_score", 18, 132, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("opponent_score", 19, 132, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("stroke_count", 20, 132, 1.0d, 0.0d, "counts", false, l2Var3));
        s1Var.h(new s0("zone_count", 21, 132, 1.0d, 0.0d, "counts", false, l2Var3));
        s1Var.h(new s0("enhanced_avg_respiration_rate", 22, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var3));
        s1Var.h(new s0("enhanced_max_respiration_rate", 23, 132, 100.0d, 0.0d, "Breaths/min", false, l2Var3));
        s1Var.h(new s0("avg_respiration_rate", 24, 2, 1.0d, 0.0d, "", false, l2Var4));
        ((s0) s1Var.f2382d.get(20)).f2375j.add(new w0(22, false, 8, 1.0d, 0.0d));
        s1Var.h(new s0("max_respiration_rate", 25, 2, 1.0d, 0.0d, "", false, l2Var4));
        ((s0) s1Var.f2382d.get(21)).f2375j.add(new w0(23, false, 8, 1.0d, 0.0d));
    }

    public p1(s1 s1Var) {
        super(s1Var);
    }

    @Override // k1.z1
    public Short a() {
        return n(10, 0, 65535);
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
