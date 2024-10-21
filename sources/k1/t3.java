package k1;

/* loaded from: classes.dex */
public class t3 extends s1 {

    /* renamed from: g */
    protected static final s1 f2442g;

    static {
        s1 s1Var = new s1("weather_conditions", 128);
        f2442g = s1Var;
        l2 l2Var = l2.DATE_TIME;
        s1Var.h(new s0("timestamp", 253, 134, 1.0d, 0.0d, "", false, l2Var));
        s1Var.h(new s0("weather_report", 0, 0, 1.0d, 0.0d, "", false, l2.WEATHER_REPORT));
        l2 l2Var2 = l2.SINT8;
        s1Var.h(new s0("temperature", 1, 1, 1.0d, 0.0d, "C", false, l2Var2));
        s1Var.h(new s0("condition", 2, 0, 1.0d, 0.0d, "", false, l2.WEATHER_STATUS));
        l2 l2Var3 = l2.UINT16;
        s1Var.h(new s0("wind_direction", 3, 132, 1.0d, 0.0d, "degrees", false, l2Var3));
        s1Var.h(new s0("wind_speed", 4, 132, 1000.0d, 0.0d, "m/s", false, l2Var3));
        l2 l2Var4 = l2.UINT8;
        s1Var.h(new s0("precipitation_probability", 5, 2, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("temperature_feels_like", 6, 1, 1.0d, 0.0d, "C", false, l2Var2));
        s1Var.h(new s0("relative_humidity", 7, 2, 1.0d, 0.0d, "", false, l2Var4));
        s1Var.h(new s0("location", 8, 7, 1.0d, 0.0d, "", false, l2.STRING));
        s1Var.h(new s0("observed_at_time", 9, 134, 1.0d, 0.0d, "", false, l2Var));
        l2 l2Var5 = l2.SINT32;
        s1Var.h(new s0("observed_location_lat", 10, 133, 1.0d, 0.0d, "semicircles", false, l2Var5));
        s1Var.h(new s0("observed_location_long", 11, 133, 1.0d, 0.0d, "semicircles", false, l2Var5));
        s1Var.h(new s0("day_of_week", 12, 0, 1.0d, 0.0d, "", false, l2.DAY_OF_WEEK));
        s1Var.h(new s0("high_temperature", 13, 1, 1.0d, 0.0d, "C", false, l2Var2));
        s1Var.h(new s0("low_temperature", 14, 1, 1.0d, 0.0d, "C", false, l2Var2));
    }

    public t3(s1 s1Var) {
        super(s1Var);
    }
}
