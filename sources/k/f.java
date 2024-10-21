package k;

/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: f */
    private static final l f1990f = l.CAPABILITIES;

    /* renamed from: b */
    private final int f1991b;

    /* renamed from: c */
    private final int f1992c;

    /* renamed from: d */
    private int f1993d;

    /* renamed from: e */
    private boolean[] f1994e;

    /* loaded from: classes.dex */
    public enum a {
        CAPABILITIES_NO_RECEIVE_CHANNELS,
        CAPABILITIES_NO_TRANSMIT_CHANNELS,
        CAPABILITIES_NO_RECEIVE_MESSAGES,
        CAPABILITIES_NO_TRANSMIT_MESSAGES,
        CAPABILITIES_NO_ACKD_MESSAGES,
        CAPABILITIES_NO_BURST_MESSAGES,
        CAPABILITIES_NETWORK_ENABLED,
        CAPABILITIES_SERIAL_NUMBER_ENABLED,
        CAPABILITIES_PER_CHANNEL_TX_POWER_ENABLED,
        CAPABILITIES_LOW_PRIORITY_SEARCH_ENABLED,
        CAPABILITIES_SCRIPT_ENABLED,
        CAPABILITIES_SEARCH_LIST_ENABLED,
        CAPABILITIES_LED_ENABLED,
        CAPABILITIES_EXT_MESSAGE_ENABLED,
        CAPABILITIES_SCAN_MODE_ENABLED,
        CAPABILITIES_PROX_SEARCH_ENABLED,
        CAPABILITIES_EXT_ASSIGN_ENABLED,
        CAPABILITIES_FS_ANTFS_ENABLED,
        CAPABILITIES_ADVANCED_BURST_ENABLED,
        CAPABILITIES_EVENT_BUFFERING_ENABLED,
        CAPABILITIES_EVENT_FILTERING_ENABLED,
        CAPABILITIES_HIGH_DUTY_SEARCH_ENABLED,
        CAPABILITIES_SELECTIVE_DATA_UPDATES_ENABLED,
        CAPABILITIES_SEARCH_UPLINK_ENABLED,
        NUMBER_OF_CAPABILITIES
    }

    public f(byte[] bArr) {
        super(bArr);
        this.f1993d = 0;
        this.f1994e = new boolean[j()];
        this.f1991b = j.j.j(bArr, 0);
        this.f1992c = j.j.j(bArr, 1);
        k();
    }

    private static int j() {
        return a.NUMBER_OF_CAPABILITIES.ordinal();
    }

    private void k() {
        byte[] bArr = this.f1971a;
        int length = bArr.length;
        if (2 >= length) {
            return;
        }
        l(a.CAPABILITIES_NO_RECEIVE_CHANNELS, 2, bArr, 1);
        l(a.CAPABILITIES_NO_TRANSMIT_CHANNELS, 2, this.f1971a, 2);
        l(a.CAPABILITIES_NO_RECEIVE_MESSAGES, 2, this.f1971a, 4);
        l(a.CAPABILITIES_NO_TRANSMIT_MESSAGES, 2, this.f1971a, 8);
        l(a.CAPABILITIES_NO_ACKD_MESSAGES, 2, this.f1971a, 16);
        l(a.CAPABILITIES_NO_BURST_MESSAGES, 2, this.f1971a, 32);
        if (3 >= length) {
            return;
        }
        l(a.CAPABILITIES_NETWORK_ENABLED, 3, this.f1971a, 2);
        l(a.CAPABILITIES_SERIAL_NUMBER_ENABLED, 3, this.f1971a, 8);
        l(a.CAPABILITIES_PER_CHANNEL_TX_POWER_ENABLED, 3, this.f1971a, 16);
        l(a.CAPABILITIES_LOW_PRIORITY_SEARCH_ENABLED, 3, this.f1971a, 32);
        l(a.CAPABILITIES_SCRIPT_ENABLED, 3, this.f1971a, 64);
        l(a.CAPABILITIES_SEARCH_LIST_ENABLED, 3, this.f1971a, 128);
        if (4 >= length) {
            return;
        }
        l(a.CAPABILITIES_LED_ENABLED, 4, this.f1971a, 1);
        l(a.CAPABILITIES_EXT_MESSAGE_ENABLED, 4, this.f1971a, 2);
        l(a.CAPABILITIES_SCAN_MODE_ENABLED, 4, this.f1971a, 4);
        l(a.CAPABILITIES_PROX_SEARCH_ENABLED, 4, this.f1971a, 16);
        l(a.CAPABILITIES_EXT_ASSIGN_ENABLED, 4, this.f1971a, 32);
        l(a.CAPABILITIES_FS_ANTFS_ENABLED, 4, this.f1971a, 64);
        if (5 >= length) {
            return;
        }
        this.f1993d = j.j.j(this.f1971a, 5);
        if (6 >= length) {
            return;
        }
        l(a.CAPABILITIES_ADVANCED_BURST_ENABLED, 6, this.f1971a, 1);
        l(a.CAPABILITIES_EVENT_BUFFERING_ENABLED, 6, this.f1971a, 2);
        l(a.CAPABILITIES_EVENT_FILTERING_ENABLED, 6, this.f1971a, 4);
        l(a.CAPABILITIES_HIGH_DUTY_SEARCH_ENABLED, 6, this.f1971a, 8);
        l(a.CAPABILITIES_SELECTIVE_DATA_UPDATES_ENABLED, 6, this.f1971a, 64);
        if (7 >= length) {
            return;
        }
        l(a.CAPABILITIES_SEARCH_UPLINK_ENABLED, 7, this.f1971a, 4);
    }

    private void l(a aVar, int i2, byte[] bArr, int i3) {
        this.f1994e[aVar.ordinal()] = j.j.f(i3, bArr, i2);
    }

    @Override // j.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f1991b != fVar.f1991b || this.f1992c != fVar.f1992c || hashCode() != fVar.hashCode()) {
            return false;
        }
        int j2 = j() - 1;
        for (int i2 = 0; i2 < j2; i2++) {
            if (this.f1994e[i2] != fVar.f1994e[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // k.b
    public l h() {
        return f1990f;
    }

    @Override // j.a
    public int hashCode() {
        int i2 = 7;
        for (boolean z2 : this.f1994e) {
            i2 = (i2 * 31) + (z2 ? 1 : 0);
        }
        return i2;
    }

    @Override // j.a
    public String toString() {
        int j2 = j();
        StringBuilder sb = new StringBuilder(i());
        sb.append("\n  ");
        sb.append("Capabilities=");
        int i2 = 0;
        for (a aVar : a.values()) {
            if (this.f1994e[aVar.ordinal()]) {
                sb.append(" -");
                sb.append(aVar);
            }
            i2++;
            if (i2 == j2) {
                break;
            }
        }
        return sb.toString();
    }
}
