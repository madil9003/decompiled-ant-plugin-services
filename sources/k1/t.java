package k1;

/* loaded from: classes.dex */
public class t extends s1 {

    /* renamed from: g */
    protected static final s1 f2387g;

    static {
        s1 s1Var = new s1("connectivity", 127);
        f2387g = s1Var;
        l2 l2Var = l2.BOOL;
        s1Var.h(new s0("bluetooth_enabled", 0, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("bluetooth_le_enabled", 1, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("ant_enabled", 2, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("name", 3, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("live_tracking_enabled", 4, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("weather_conditions_enabled", 5, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("weather_alerts_enabled", 6, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("auto_activity_upload_enabled", 7, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("course_download_enabled", 8, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("workout_download_enabled", 9, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("gps_ephemeris_download_enabled", 10, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("incident_detection_enabled", 11, 0, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("grouptrack_enabled", 12, 0, 1.0d, 0.0d, "", false, l2Var));
    }

    public t(s1 s1Var) {
        super(s1Var);
    }
}
