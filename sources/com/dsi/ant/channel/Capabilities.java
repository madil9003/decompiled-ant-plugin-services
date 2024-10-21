package com.dsi.ant.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Capabilities implements Parcelable {
    public static final Parcelable.Creator<Capabilities> CREATOR = new a();

    /* renamed from: a */
    private boolean f307a = false;

    /* renamed from: b */
    private boolean f308b = false;

    /* renamed from: c */
    private boolean f309c = false;

    /* renamed from: d */
    private int f310d = 3;

    /* renamed from: e */
    private BundleData f311e = new BundleData();

    /* loaded from: classes.dex */
    public static final class BundleData implements Parcelable {
        public static final Parcelable.Creator<BundleData> CREATOR = new a();

        /* renamed from: a */
        private boolean f312a = false;

        /* renamed from: b */
        private boolean f313b = false;

        /* renamed from: c */
        private boolean f314c = false;

        /* renamed from: d */
        private boolean f315d = false;

        /* renamed from: e */
        private boolean f316e = false;

        /* renamed from: f */
        private boolean f317f = false;

        /* renamed from: g */
        private int f318g = 2;

        /* renamed from: h */
        private int f319h = 80;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public BundleData createFromParcel(Parcel parcel) {
                int readInt = parcel.readInt();
                boolean[] zArr = new boolean[parcel.readInt()];
                parcel.readBooleanArray(zArr);
                BundleData bundleData = new BundleData();
                if (readInt != 1) {
                    if (readInt != 2) {
                        if (readInt != 3) {
                            bundleData.f317f = zArr[b.SEARCH_UPLINK.ordinal()];
                        }
                        bundleData.f316e = zArr[b.FAST_CHANNEL_INITIATION.ordinal()];
                    }
                    bundleData.f315d = zArr[b.SEARCH_PRIORITY.ordinal()];
                }
                bundleData.f312a = zArr[b.RSSI.ordinal()];
                bundleData.f313b = zArr[b.WILDCARD_ID_LIST.ordinal()];
                bundleData.f314c = zArr[b.EVENT_BUFFERING.ordinal()];
                bundleData.f318g = parcel.readInt();
                bundleData.f319h = parcel.readInt();
                return bundleData;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public BundleData[] newArray(int i2) {
                return null;
            }
        }

        /* loaded from: classes.dex */
        public enum b {
            RSSI,
            WILDCARD_ID_LIST,
            EVENT_BUFFERING,
            SEARCH_PRIORITY,
            FAST_CHANNEL_INITIATION,
            SEARCH_UPLINK,
            NUMBER_OF_BUNDLE_CAPABILITIES
        }

        BundleData() {
        }

        static int q() {
            return b.NUMBER_OF_BUNDLE_CAPABILITIES.ordinal();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            boolean[] zArr = new boolean[q()];
            zArr[b.RSSI.ordinal()] = this.f312a;
            zArr[b.WILDCARD_ID_LIST.ordinal()] = this.f313b;
            zArr[b.EVENT_BUFFERING.ordinal()] = this.f314c;
            zArr[b.SEARCH_PRIORITY.ordinal()] = this.f315d;
            zArr[b.FAST_CHANNEL_INITIATION.ordinal()] = this.f316e;
            zArr[b.SEARCH_UPLINK.ordinal()] = this.f317f;
            parcel.writeInt(4);
            parcel.writeInt(q());
            parcel.writeBooleanArray(zArr);
            parcel.writeInt(this.f318g);
            parcel.writeInt(this.f319h);
        }
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        private Capabilities b(Parcel parcel) {
            boolean[] zArr = new boolean[parcel.readInt()];
            parcel.readBooleanArray(zArr);
            Capabilities capabilities = new Capabilities();
            capabilities.f307a = zArr[b.RX_MESSAGE_TIMESTAMP.ordinal()];
            capabilities.f308b = zArr[b.BACKGROUND_SCANNING.ordinal()];
            capabilities.f309c = zArr[b.FREQUENCY_AGILITY.ordinal()];
            capabilities.f310d = parcel.readInt();
            return capabilities;
        }

        private void c(Parcel parcel, Capabilities capabilities) {
            Bundle readBundle = parcel.readBundle();
            readBundle.setClassLoader(BundleData.class.getClassLoader());
            capabilities.f311e = (BundleData) readBundle.getParcelable("com.dsi.ant.channel.capabilities.bundledata");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Capabilities createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            Capabilities b3 = b(parcel);
            if (readInt > 1) {
                c(parcel, b3);
            }
            return b3;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d */
        public Capabilities[] newArray(int i2) {
            return new Capabilities[i2];
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        RX_MESSAGE_TIMESTAMP,
        EXTENDED_ASSIGN,
        BACKGROUND_SCANNING,
        FREQUENCY_AGILITY,
        NUMBER_OF_CAPABILITIES
    }

    static int f() {
        return b.NUMBER_OF_CAPABILITIES.ordinal();
    }

    private void m(Parcel parcel) {
        boolean[] zArr = new boolean[f()];
        zArr[b.RX_MESSAGE_TIMESTAMP.ordinal()] = this.f307a;
        zArr[b.EXTENDED_ASSIGN.ordinal()] = i();
        zArr[b.BACKGROUND_SCANNING.ordinal()] = this.f308b;
        zArr[b.FREQUENCY_AGILITY.ordinal()] = this.f309c;
        parcel.writeInt(f());
        parcel.writeBooleanArray(zArr);
        parcel.writeInt(this.f310d);
    }

    private void n(Parcel parcel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.dsi.ant.channel.capabilities.bundledata", this.f311e);
        parcel.writeBundle(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Capabilities)) {
            return false;
        }
        Capabilities capabilities = (Capabilities) obj;
        return capabilities.f307a == this.f307a && capabilities.f308b == this.f308b && capabilities.f309c == this.f309c && capabilities.f311e.f312a == this.f311e.f312a && capabilities.f311e.f313b == this.f311e.f313b && capabilities.f311e.f314c == this.f311e.f314c && capabilities.f311e.f318g == this.f311e.f318g && capabilities.f311e.f319h == this.f311e.f319h && capabilities.f310d == this.f310d && capabilities.f311e.f315d == this.f311e.f315d && capabilities.f311e.f316e == this.f311e.f316e && capabilities.f311e.f317f == this.f311e.f317f;
    }

    public int g() {
        return this.f310d;
    }

    public boolean h() {
        return this.f311e.f314c;
    }

    public int hashCode() {
        return ((((((((((((((((((((217 + (this.f307a ? 1 : 0)) * 31) + (this.f308b ? 1 : 0)) * 31) + (this.f309c ? 1 : 0)) * 31) + (this.f311e.f312a ? 1 : 0)) * 31) + (this.f311e.f313b ? 1 : 0)) * 31) + (this.f311e.f314c ? 1 : 0)) * 31) + this.f311e.f318g) * 31) + this.f311e.f319h) * 31) + (this.f311e.f315d ? 1 : 0)) * 31) + (this.f311e.f316e ? 1 : 0)) * 31) + (this.f311e.f317f ? 1 : 0);
    }

    public boolean i() {
        return this.f308b || this.f309c;
    }

    public boolean j() {
        return this.f311e.f316e;
    }

    public boolean k() {
        return this.f311e.f312a;
    }

    public void l(boolean z2) {
        this.f311e.f312a = z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Capabilities:");
        if (this.f307a) {
            sb.append(" -Rx Message Timestamp");
        }
        if (this.f308b) {
            sb.append(" -Background Scanning");
        }
        if (this.f309c) {
            sb.append(" -Frequency Agility");
        }
        if (this.f311e.f312a) {
            sb.append(" -RSSI");
        }
        if (this.f311e.f313b) {
            sb.append(" -Wildcards in ID Lists");
        }
        if (this.f311e.f314c) {
            sb.append(" -Event Buffering");
        }
        if (3 != this.f310d) {
            sb.append("  Max Transmit Power Level: ");
            sb.append(this.f310d);
        }
        sb.append(" -RF Frequency Range: ");
        sb.append(this.f311e.f318g);
        sb.append(" to ");
        sb.append(this.f311e.f319h);
        sb.append(" MHz offset of 2400 MHz");
        if (this.f311e.f315d) {
            sb.append(" -Search Priority");
        }
        if (this.f311e.f316e) {
            sb.append(" -Fast Channel Initiation");
        }
        if (this.f311e.f317f) {
            sb.append(" -Search Uplink");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(2);
        m(parcel);
        if (f.a.g()) {
            n(parcel);
        }
    }
}
