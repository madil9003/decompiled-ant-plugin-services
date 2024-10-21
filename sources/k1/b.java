package k1;

/* loaded from: classes.dex */
public class b extends s1 implements z1 {

    /* renamed from: g */
    protected static final s1 f2108g;

    static {
        s1 s1Var = new s1("activity", 34);
        f2108g = s1Var;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        s1Var.h(new s0("total_timer_time", 0, 134, 1000.0d, 0.0d, "s", false, l2.UINT32));
        s1Var.h(new s0("num_sessions", 1, 132, 1.0d, 0.0d, "", false, l2.UINT16));
        s1Var.h(new s0("type", 2, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY));
        s1Var.h(new s0("event", 3, 0, 1.0d, 0.0d, "", false, l2.EVENT));
        s1Var.h(new s0("event_type", 4, 0, 1.0d, 0.0d, "", false, l2.EVENT_TYPE));
        s1Var.h(new s0("local_timestamp", 5, 134, 1.0d, 0.0d, "", false, l2.LOCAL_DATE_TIME));
        s1Var.h(new s0("event_group", 6, 2, 1.0d, 0.0d, "", false, l2.UINT8));
    }

    public b(s1 s1Var) {
        super(s1Var);
    }

    @Override // k1.z1
    public Short a() {
        return n(6, 0, 65535);
    }

    @Override // k1.z1
    public void b(w wVar) {
        s(253, 0, wVar.e(), 65535);
    }

    @Override // k1.z1
    public void c(m0 m0Var) {
        s(4, 0, Short.valueOf(m0Var.f2338a), 65535);
    }

    @Override // k1.z1
    public m0 d() {
        Short n2 = n(4, 0, 65535);
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
        Short n2 = n(3, 0, 65535);
        if (n2 == null) {
            return null;
        }
        return k0.a(n2);
    }
}
