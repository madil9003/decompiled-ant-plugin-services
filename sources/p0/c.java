package p0;

/* loaded from: classes.dex */
public enum c {
    BIKE_POWER(11, "Bike Power Sensors"),
    CONTROLLABLE_DEVICE(16, "Controls"),
    FITNESS_EQUIPMENT(17, "Fitness Equipment Devices"),
    BLOOD_PRESSURE(18, "Blood Pressure Monitors"),
    GEOCACHE(19, "Geocache Transmitters"),
    ENVIRONMENT(25, "Environment Sensors"),
    WEIGHT_SCALE(119, "Weight Sensors"),
    HEARTRATE(120, "Heart Rate Sensors"),
    BIKE_SPDCAD(121, "Bike Speed and Cadence Sensors"),
    BIKE_CADENCE(122, "Bike Cadence Sensors"),
    BIKE_SPD(123, "Bike Speed Sensors"),
    STRIDE_SDM(124, "Stride-Based Speed and Distance Sensors"),
    UNKNOWN(-1, "Unknown");


    /* renamed from: a */
    private final int f2930a;

    /* renamed from: b */
    private final String f2931b;

    c(int i2, String str) {
        this.f2930a = i2;
        this.f2931b = str;
    }

    public static c c(int i2) {
        int i3 = i2 & (-129);
        for (c cVar : values()) {
            if (cVar.f2930a == i3) {
                return cVar;
            }
        }
        return UNKNOWN;
    }

    public int b() {
        return this.f2930a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f2931b;
    }
}
