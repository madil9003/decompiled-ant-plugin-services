package k1;

/* loaded from: classes.dex */
public class s3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2386g;

    static {
        s1 s1Var = new s1("weather_alert", 129);
        f2386g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("report_id", 0, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("issue_time", 1, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("expire_time", 2, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("severity", 3, 0, 1.0d, 0.0d, "", false, l2.WEATHER_SEVERITY));
        s1Var.h(new s0("type", 4, 0, 1.0d, 0.0d, "", false, l2.WEATHER_SEVERE_TYPE));
    }

    public s3(s1 s1Var) {
        super(s1Var);
    }
}
