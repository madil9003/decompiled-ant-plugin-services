package k1;

/* loaded from: classes.dex */
public class e0 extends s1 {

    /* renamed from: g */
    protected static final s1 f2170g;

    static {
        s1 s1Var = new s1("device_settings", 2);
        f2170g = s1Var;
        l2 l2Var = l2.UINT8;
        s1Var.h(new s0("active_time_zone", 0, 2, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var2 = l2.UINT32;
        s1Var.h(new s0("utc_offset", 1, 134, 1.0d, 0.0d, "", false, l2Var2));
        s1Var.h(new s0("time_offset", 2, 134, 1.0d, 0.0d, "s", false, l2Var2));
        s1Var.h(new s0("time_mode", 4, 0, 1.0d, 0.0d, "", false, l2.TIME_MODE));
        s1Var.h(new s0("time_zone_offset", 5, 1, 4.0d, 0.0d, "hr", false, l2.SINT8));
        s1Var.h(new s0("backlight_mode", 12, 0, 1.0d, 0.0d, "", false, l2.BACKLIGHT_MODE));
        l2 l2Var3 = l2.BOOL;
        s1Var.h(new s0("activity_tracker_enabled", 36, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("clock_time", 39, 134, 1.0d, 0.0d, "", false, l2.DATE_TIME));
        l2 l2Var4 = l2.UINT16;
        s1Var.h(new s0("pages_enabled", 40, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("move_alert_enabled", 46, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("date_mode", 47, 0, 1.0d, 0.0d, "", false, l2.DATE_MODE));
        l2 l2Var5 = l2.DISPLAY_ORIENTATION;
        s1Var.h(new s0("display_orientation", 55, 0, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("mounting_side", 56, 0, 1.0d, 0.0d, "", false, l2.SIDE));
        s1Var.h(new s0("default_page", 57, 132, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("autosync_min_steps", 58, 132, 1.0d, 0.0d, "steps", false, l2Var4));
        s1Var.h(new s0("autosync_min_time", 59, 132, 1.0d, 0.0d, "minutes", false, l2Var4));
        s1Var.h(new s0("lactate_threshold_autodetect_enabled", 80, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("ble_auto_upload_enabled", 86, 0, 1.0d, 0.0d, "", false, l2Var3));
        s1Var.h(new s0("auto_sync_frequency", 89, 0, 1.0d, 0.0d, "", false, l2.AUTO_SYNC_FREQUENCY));
        s1Var.h(new s0("auto_activity_detect", 90, 134, 1.0d, 0.0d, "", false, l2.AUTO_ACTIVITY_DETECT));
        s1Var.h(new s0("number_of_screens", 94, 2, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("smart_notification_display_orientation", 95, 0, 1.0d, 0.0d, "", false, l2Var5));
        s1Var.h(new s0("tap_interface", 134, 0, 1.0d, 0.0d, "", false, l2.SWITCH));
        s1Var.h(new s0("tap_sensitivity", 174, 0, 1.0d, 0.0d, "", false, l2.TAP_SENSITIVITY));
    }

    public e0(s1 s1Var) {
        super(s1Var);
    }
}
