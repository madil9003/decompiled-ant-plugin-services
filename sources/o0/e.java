package o0;

/* loaded from: classes.dex */
public enum e {
    PLAY(1, true, true, false),
    PAUSE(2, true, true, true),
    STOP(3, true, true, true),
    VOLUME_UP(4, true, true, true),
    VOLUME_DOWN(5, true, true, true),
    MUTE_UNMUTE(6, true, true, true),
    AHEAD(7, true, true, false),
    BACK(8, true, true, false),
    REPEAT_CURRENT_TRACK(9, true, false, false),
    REPEAT_ALL(10, true, false, false),
    REPEAT_OFF(11, true, false, false),
    SHUFFLE_TRACKS(12, true, false, false),
    SHUFFLE_ALBUMS(13, true, false, false),
    SHUFFLE_OFF(14, true, false, false),
    FAST_FORWARD(15, true, true, false),
    FAST_REWIND(16, true, true, false),
    CUSTOM_REPEAT(17, true, false, false),
    CUSTOM_SHUFFLE(18, true, false, false),
    RECORD(19, false, false, true),
    CAPTURE_STILL_IMAGE(20, false, true, true),
    CAPTURE_BURST_IMAGES(21, false, true, true),
    CAPTURE_TIME_LAPSE_IMAGE(22, false, true, true),
    UNRECOGNIZED(-1, false, false, false);


    /* renamed from: a */
    private int f2794a;

    /* renamed from: b */
    private boolean f2795b;

    /* renamed from: c */
    private boolean f2796c;

    /* renamed from: d */
    private boolean f2797d;

    e(int i2, boolean z2, boolean z3, boolean z4) {
        this.f2794a = i2;
        this.f2795b = z2;
        this.f2796c = z3;
        this.f2797d = z4;
    }

    public static e c(int i2) {
        for (e eVar : values()) {
            if (eVar.b() == i2) {
                return eVar;
            }
        }
        return UNRECOGNIZED;
    }

    public int b() {
        return this.f2794a;
    }
}
