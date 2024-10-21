package k1;

/* loaded from: classes.dex */
public class l3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2325g;

    static {
        s1 s1Var = new s1("user_profile", 3);
        f2325g = s1Var;
        s1Var.h(new s0("message_index", 254, 132, 1.0d, 0.0d, "", false, l2.MESSAGE_INDEX));
        s1Var.h(new s0("friendly_name", 0, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("gender", 1, 0, 1.0d, 0.0d, "", false, l2.GENDER));
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("age", 2, 2, 1.0d, 0.0d, "years", false, l2Var));
        s1Var.h(new s0("height", 3, 2, 100.0d, 0.0d, "m", false, l2Var));
        l2 l2Var2 = l2.UINT16;
        s1Var.h(new s0("weight", 4, 132, 10.0d, 0.0d, "kg", false, l2Var2));
        s1Var.h(new s0("language", 5, 0, 1.0d, 0.0d, "", false, l2.LANGUAGE));
        l2 l2Var3 = l2.DISPLAY_MEASURE;
        s1Var.h(new s0("elev_setting", 6, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("weight_setting", 7, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("resting_heart_rate", 8, 2, 1.0d, 0.0d, "bpm", false, l2Var));
        s1Var.h(new s0("default_max_running_heart_rate", 9, 2, 1.0d, 0.0d, "bpm", false, l2Var));
        s1Var.h(new s0("default_max_biking_heart_rate", 10, 2, 1.0d, 0.0d, "bpm", false, l2Var));
        s1Var.h(new s0("default_max_heart_rate", 11, 2, 1.0d, 0.0d, "bpm", false, l2Var));
        s1Var.h(new s0("hr_setting", 12, 0, 1.0d, 0.0d, "", false, l2.DISPLAY_HEART));
        s1Var.h(new s0("speed_setting", 13, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("dist_setting", 14, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("power_setting", 16, 0, 1.0d, 0.0d, "", false, l2.DISPLAY_POWER));
        s1Var.h(new s0("activity_class", 17, 0, 1.0d, 0.0d, "", false, l2.ACTIVITY_CLASS));
        s1Var.h(new s0("position_setting", 18, 0, 1.0d, 0.0d, "", false, l2.DISPLAY_POSITION));
        s1Var.h(new s0("temperature_setting", 21, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("local_id", 22, 132, 1.0d, 0.0d, "", false, l2.USER_LOCAL_ID));
        s1Var.h(new s0("global_id", 23, 13, 1.0d, 0.0d, "", false, l2.BYTE));
        l2 l2Var4 = l2.LOCALTIME_INTO_DAY;
        s1Var.h(new s0("wake_time", 28, 134, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("sleep_time", 29, 134, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("height_setting", 30, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("user_running_step_length", 31, 132, 1000.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("user_walking_step_length", 32, 132, 1000.0d, 0.0d, "m", false, l2Var2));
        s1Var.h(new s0("depth_setting", 47, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("dive_count", 49, 134, 1.0d, 0.0d, "", false, l2.UINT32));
    }

    public l3(s1 s1Var) {
        super(s1Var);
    }
}
