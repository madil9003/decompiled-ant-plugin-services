package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: j */
    static final PorterDuff.Mode f110j = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f111a;

    /* renamed from: b */
    Object f112b;

    /* renamed from: c */
    public byte[] f113c;

    /* renamed from: d */
    public Parcelable f114d;

    /* renamed from: e */
    public int f115e;

    /* renamed from: f */
    public int f116f;

    /* renamed from: g */
    public ColorStateList f117g;

    /* renamed from: h */
    PorterDuff.Mode f118h;

    /* renamed from: i */
    public String f119i;

    public IconCompat() {
        this.f111a = -1;
        this.f113c = null;
        this.f114d = null;
        this.f115e = 0;
        this.f116f = 0;
        this.f117g = null;
        this.f118h = f110j;
        this.f119i = null;
    }

    public static IconCompat a(Resources resources, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f115e = i2;
        if (resources != null) {
            try {
                iconCompat.f112b = resources.getResourceName(i2);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f112b = str;
        }
        return iconCompat;
    }

    private static int c(Icon icon) {
        return icon.getResId();
    }

    private static String e(Icon icon) {
        return icon.getResPackage();
    }

    private static int g(Icon icon) {
        return icon.getType();
    }

    private static String k(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public int b() {
        int i2 = this.f111a;
        if (i2 == -1) {
            return c((Icon) this.f112b);
        }
        if (i2 == 2) {
            return this.f115e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String d() {
        int i2 = this.f111a;
        if (i2 == -1) {
            return e((Icon) this.f112b);
        }
        if (i2 == 2) {
            return ((String) this.f112b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int f() {
        int i2 = this.f111a;
        return i2 == -1 ? g((Icon) this.f112b) : i2;
    }

    public void h() {
        Parcelable parcelable;
        this.f118h = PorterDuff.Mode.valueOf(this.f119i);
        int i2 = this.f111a;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        this.f112b = this.f113c;
                        return;
                    } else if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                    }
                }
                this.f112b = new String(this.f113c, Charset.forName("UTF-16"));
                return;
            }
            parcelable = this.f114d;
            if (parcelable == null) {
                byte[] bArr = this.f113c;
                this.f112b = bArr;
                this.f111a = 3;
                this.f115e = 0;
                this.f116f = bArr.length;
                return;
            }
        } else {
            parcelable = this.f114d;
            if (parcelable == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.f112b = parcelable;
    }

    public void i(boolean z2) {
        this.f119i = this.f118h.name();
        int i2 = this.f111a;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f113c = ((String) this.f112b).getBytes(Charset.forName("UTF-16"));
                    return;
                }
                if (i2 == 3) {
                    this.f113c = (byte[]) this.f112b;
                    return;
                } else if (i2 == 4) {
                    this.f113c = this.f112b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i2 != 5) {
                    return;
                }
            }
            if (z2) {
                Bitmap bitmap = (Bitmap) this.f112b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f113c = byteArrayOutputStream.toByteArray();
                return;
            }
        } else if (z2) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.f114d = (Parcelable) this.f112b;
    }

    public Icon j() {
        Icon createWithBitmap;
        int i2 = this.f111a;
        if (i2 == -1) {
            return (Icon) this.f112b;
        }
        if (i2 == 1) {
            createWithBitmap = Icon.createWithBitmap((Bitmap) this.f112b);
        } else if (i2 == 2) {
            createWithBitmap = Icon.createWithResource(d(), this.f115e);
        } else if (i2 == 3) {
            createWithBitmap = Icon.createWithData((byte[]) this.f112b, this.f115e, this.f116f);
        } else if (i2 == 4) {
            createWithBitmap = Icon.createWithContentUri((String) this.f112b);
        } else {
            if (i2 != 5) {
                throw new IllegalArgumentException("Unknown type");
            }
            createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f112b);
        }
        ColorStateList colorStateList = this.f117g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f118h;
        if (mode != f110j) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:            if (r1 != 5) goto L56;     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f111a
            r1 = -1
            if (r0 != r1) goto Lc
            java.lang.Object r4 = r4.f112b
            java.lang.String r4 = java.lang.String.valueOf(r4)
            return r4
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f111a
            java.lang.String r1 = k(r1)
            r0.append(r1)
            int r1 = r4.f111a
            r2 = 1
            if (r1 == r2) goto L77
            r3 = 2
            if (r1 == r3) goto L4f
            r2 = 3
            if (r1 == r2) goto L39
            r2 = 4
            if (r1 == r2) goto L2e
            r2 = 5
            if (r1 == r2) goto L77
            goto L97
        L2e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f112b
            r0.append(r1)
            goto L97
        L39:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f115e
            r0.append(r1)
            int r1 = r4.f116f
            if (r1 == 0) goto L97
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f116f
            goto L94
        L4f:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.d()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            int r2 = r4.b()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L97
        L77:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f112b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f112b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L94:
            r0.append(r1)
        L97:
            android.content.res.ColorStateList r1 = r4.f117g
            if (r1 == 0) goto La5
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f117g
            r0.append(r1)
        La5:
            android.graphics.PorterDuff$Mode r1 = r4.f118h
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.f110j
            if (r1 == r2) goto Lb5
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r4 = r4.f118h
            r0.append(r4)
        Lb5:
            java.lang.String r4 = ")"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    private IconCompat(int i2) {
        this.f113c = null;
        this.f114d = null;
        this.f115e = 0;
        this.f116f = 0;
        this.f117g = null;
        this.f118h = f110j;
        this.f119i = null;
        this.f111a = i2;
    }
}
