package j1;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    private static final String f1969a = "a";

    public static long a(Context context) {
        UUID uuid;
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("device_id.xml", 4);
            String string2 = sharedPreferences.getString("device_id", null);
            if (string2 != null) {
                uuid = UUID.fromString(string2);
            } else {
                UUID nameUUIDFromBytes = !"9774d56d682e549c".equals(string) ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
                sharedPreferences.edit().putString("device_id", nameUUIDFromBytes.toString()).commit();
                uuid = nameUUIDFromBytes;
            }
            return uuid.getLeastSignificantBits() & 4294967295L;
        } catch (UnsupportedEncodingException unused) {
            h1.a.b(f1969a, "UnsupportedEncodingException trying to decode Andriod ID as utf8");
            return -1L;
        }
    }

    public static int b(Context context) {
        UUID uuid;
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("device_id.xml", 0);
            String string2 = sharedPreferences.getString("device_id", null);
            if (string2 != null) {
                uuid = UUID.fromString(string2);
            } else {
                UUID nameUUIDFromBytes = !"9774d56d682e549c".equals(string) ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
                sharedPreferences.edit().putString("device_id", nameUUIDFromBytes.toString()).commit();
                uuid = nameUUIDFromBytes;
            }
            return (int) (uuid.getLeastSignificantBits() & 65535);
        } catch (UnsupportedEncodingException unused) {
            h1.a.b(context.getClass().getSimpleName(), "UnsupportedEncodingException trying to decode Andriod ID as utf8");
            return -1;
        }
    }
}
