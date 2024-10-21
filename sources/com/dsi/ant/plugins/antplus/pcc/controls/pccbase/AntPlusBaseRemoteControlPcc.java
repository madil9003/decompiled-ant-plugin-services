package com.dsi.ant.plugins.antplus.pcc.controls.pccbase;

import android.os.Parcel;
import android.os.Parcelable;
import com.dsi.ant.plugins.antplus.pccbase.b;

/* loaded from: classes.dex */
public abstract class AntPlusBaseRemoteControlPcc extends b {
    private static final String K = "AntPlusBaseRemoteControlPcc";

    /* loaded from: classes.dex */
    public static class ControlDeviceCapabilities implements Parcelable {
        public static final Parcelable.Creator<ControlDeviceCapabilities> CREATOR = new a();

        /* renamed from: a */
        private final int f800a;

        /* renamed from: b */
        private boolean f801b;

        /* renamed from: c */
        private boolean f802c;

        /* renamed from: d */
        private boolean f803d;

        /* renamed from: e */
        private boolean f804e;

        /* renamed from: f */
        private boolean f805f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ControlDeviceCapabilities createFromParcel(Parcel parcel) {
                return new ControlDeviceCapabilities(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ControlDeviceCapabilities[] newArray(int i2) {
                return new ControlDeviceCapabilities[i2];
            }
        }

        public ControlDeviceCapabilities() {
            this.f800a = 1;
            this.f801b = false;
            this.f802c = false;
            this.f803d = false;
            this.f804e = false;
            this.f805f = false;
        }

        public boolean a() {
            return this.f802c;
        }

        public boolean b() {
            return this.f803d;
        }

        public boolean c() {
            return this.f801b;
        }

        public boolean d() {
            return this.f804e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(boolean z2) {
            this.f802c = z2;
        }

        public void f(boolean z2) {
            this.f805f = z2;
        }

        public void g(boolean z2) {
            this.f803d = z2;
        }

        public void h(boolean z2) {
            this.f801b = z2;
        }

        public void i(boolean z2) {
            this.f804e = z2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f800a);
            parcel.writeByte(this.f801b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f802c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f803d ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f804e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f805f ? (byte) 1 : (byte) 0);
        }

        public ControlDeviceCapabilities(Parcel parcel) {
            this.f800a = 1;
            int readInt = parcel.readInt();
            if (readInt != 1) {
                h1.a.f(AntPlusBaseRemoteControlPcc.K, "Decoding version " + readInt + " CrankParameters parcel with version 1 parser.");
            }
            this.f801b = parcel.readByte() != 0;
            this.f802c = parcel.readByte() != 0;
            this.f803d = parcel.readByte() != 0;
            this.f804e = parcel.readByte() != 0;
            this.f805f = parcel.readByte() != 0;
        }
    }
}
