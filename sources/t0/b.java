package t0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.dsi.ant.plugins.internal.pluginsipc.AntPluginDeviceDbProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import p0.c;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private C0060b f3366a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3367a;

        static {
            int[] iArr = new int[com.dsi.ant.channel.b.values().length];
            f3367a = iArr;
            try {
                iArr[com.dsi.ant.channel.b.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3367a[com.dsi.ant.channel.b.ANT_PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3367a[com.dsi.ant.channel.b.ANT_FS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: t0.b$b */
    /* loaded from: classes.dex */
    public static class C0060b extends SQLiteOpenHelper {
        public C0060b(Context context) {
            super(context, "saved_devices.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            sQLiteDatabase.execSQL("CREATE TABLE Plugins(Plugin_Id INTEGER PRIMARY KEY,VisibleName TEXT UNIQUE NOT NULL,Chan_NetKey INTEGER NOT NULL,Chan_DevType INTEGER NOT NULL,Chan_TransType INTEGER NOT NULL,Chan_Period INTEGER NOT NULL,Chan_RfFreq INTEGER NOT NULL,UNIQUE (Chan_NetKey,Chan_DevType,Chan_TransType,Chan_Period,Chan_RfFreq))");
            sQLiteDatabase.execSQL("CREATE TABLE Devices(Device_Id INTEGER PRIMARY KEY,Plugin_Id INTEGER NOT NULL REFERENCES Plugins (Plugin_Id),ChanDevId INTEGER NOT NULL,PreferredDevicePos INTEGER CHECK (PreferredDevicePos == 0 OR PreferredDevicePos == 1),VisibleName TEXT NOT NULL,UNIQUE (Plugin_Id,VisibleName))");
            sQLiteDatabase.execSQL("CREATE TABLE BikeSpdCadComboDeviceIds(Spd_Device_Id INTEGER REFERENCES Devices (Device_Id),Cad_Device_Id INTEGER REFERENCES Devices (Device_Id),UNIQUE (Spd_Device_Id)UNIQUE (Cad_Device_Id))");
            sQLiteDatabase.execSQL("CREATE TRIGGER oneDeviceIdPerPlugin_Insert BEFORE INSERT ON Devices FOR EACH ROW WHEN(EXISTS(SELECT 1 FROM Devices WHERE (NEW.ChanDevId == ChanDevId AND NEW.Plugin_Id == Plugin_Id AND 1 != (SELECT COUNT(*) FROM BikeSpdCadComboDeviceIds            WHERE ((Spd_Device_Id == NEW.ChanDevId OR Cad_Device_Id == NEW.ChanDevId)                OR (Spd_Device_Id == ChanDevId OR Cad_Device_Id == ChanDevId)))))) BEGIN SELECT RAISE(ROLLBACK, 'PreferredDevice Conflict'); END");
            sQLiteDatabase.execSQL("CREATE TRIGGER onePreferredDevicePerPlugin_Insert BEFORE INSERT ON Devices FOR EACH ROW WHEN(NEW.PreferredDevicePos != 0 AND EXISTS(SELECT 1 FROM Devices WHERE NEW.PreferredDevicePos == PreferredDevicePos AND NEW.Plugin_Id == Plugin_Id)) BEGIN SELECT RAISE(ROLLBACK, 'PreferredDevice Conflict'); END");
            sQLiteDatabase.execSQL("CREATE TRIGGER onePreferredDevicePerPlugin_Update BEFORE UPDATE ON Devices FOR EACH ROW WHEN(NEW.PreferredDevicePos != 0 AND NEW.PreferredDevicePos != OLD.PreferredDevicePos AND EXISTS(SELECT 1 FROM Devices WHERE NEW.PreferredDevicePos == PreferredDevicePos AND NEW.Plugin_Id == Plugin_Id)) BEGIN SELECT RAISE(ROLLBACK, 'PreferredDevice Conflict'); END");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    public b(Context context) {
        this.f3366a = null;
        this.f3366a = new C0060b(context);
    }

    private void a(SQLiteDatabase sQLiteDatabase, AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, String str, com.dsi.ant.channel.b bVar, int i2, int i3, int i4, int i5) {
        StringBuilder sb;
        String str2;
        int i6;
        int i7;
        SQLiteDatabase writableDatabase = sQLiteDatabase == null ? this.f3366a.getWritableDatabase() : sQLiteDatabase;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT Plugins.Plugin_Id FROM Plugins WHERE Plugins.VisibleName == '" + str + "' ", null);
        int i8 = 0;
        if (rawQuery.moveToNext()) {
            deviceDbDeviceInfo.f1175c = Long.valueOf(rawQuery.getLong(0));
            rawQuery.close();
        } else {
            rawQuery.close();
            if (i2 == c.BIKE_SPDCAD.b()) {
                c cVar = c.BIKE_CADENCE;
                if (str.equals(cVar.toString())) {
                    i7 = cVar.b();
                    i6 = 8102;
                } else {
                    c cVar2 = c.BIKE_SPD;
                    if (str.equals(cVar2.toString())) {
                        i7 = cVar2.b();
                        i6 = 8118;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("VisibleName", str);
                contentValues.put("Chan_NetKey", Integer.valueOf(e(bVar)));
                contentValues.put("Chan_DevType", Integer.valueOf(i7));
                contentValues.put("Chan_TransType", Integer.valueOf(i3));
                contentValues.put("Chan_Period", Integer.valueOf(i6));
                contentValues.put("Chan_RfFreq", Integer.valueOf(i5));
                deviceDbDeviceInfo.f1175c = Long.valueOf(writableDatabase.insertOrThrow("Plugins", null, contentValues));
            }
            i6 = i4;
            i7 = i2;
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("VisibleName", str);
            contentValues2.put("Chan_NetKey", Integer.valueOf(e(bVar)));
            contentValues2.put("Chan_DevType", Integer.valueOf(i7));
            contentValues2.put("Chan_TransType", Integer.valueOf(i3));
            contentValues2.put("Chan_Period", Integer.valueOf(i6));
            contentValues2.put("Chan_RfFreq", Integer.valueOf(i5));
            deviceDbDeviceInfo.f1175c = Long.valueOf(writableDatabase.insertOrThrow("Plugins", null, contentValues2));
        }
        if (deviceDbDeviceInfo.f1178f.booleanValue()) {
            c(writableDatabase, deviceDbDeviceInfo.f1175c.longValue());
            i8 = 1;
        }
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("Plugin_Id", deviceDbDeviceInfo.f1175c);
        contentValues3.put("ChanDevId", deviceDbDeviceInfo.f1176d);
        contentValues3.put("PreferredDevicePos", Integer.valueOf(i8));
        contentValues3.put("VisibleName", deviceDbDeviceInfo.f1177e);
        deviceDbDeviceInfo.f1174b = Long.valueOf(writableDatabase.insertOrThrow("Devices", null, contentValues3));
        if (i2 == c.BIKE_SPDCAD.b()) {
            c cVar3 = c.BIKE_CADENCE;
            if (str.equals(cVar3.toString()) || str.equals(c.BIKE_SPD.toString())) {
                AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo2 = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
                deviceDbDeviceInfo2.f1176d = deviceDbDeviceInfo.f1176d;
                deviceDbDeviceInfo2.f1177e = deviceDbDeviceInfo.f1177e;
                if (str.equals(cVar3.toString())) {
                    deviceDbDeviceInfo2.f1178f = (deviceDbDeviceInfo.f1178f.booleanValue() && k(writableDatabase, c.BIKE_SPD.toString())) ? Boolean.FALSE : deviceDbDeviceInfo.f1178f;
                    writableDatabase.execSQL("INSERT INTO BikeSpdCadComboDeviceIds (Spd_Device_Id, Cad_Device_Id) VALUES (" + deviceDbDeviceInfo.f1174b + ", " + deviceDbDeviceInfo.f1174b + ");");
                    c cVar4 = c.BIKE_SPD;
                    a(writableDatabase, deviceDbDeviceInfo2, cVar4.toString(), com.dsi.ant.channel.b.ANT_PLUS, cVar4.b(), 0, 8118, 57);
                    sb = new StringBuilder();
                    sb.append("UPDATE BikeSpdCadComboDeviceIds SET Spd_Device_Id = ");
                    sb.append(deviceDbDeviceInfo2.f1174b);
                    str2 = " WHERE Cad_Device_Id == ";
                } else {
                    if (!str.equals(c.BIKE_SPD.toString())) {
                        return;
                    }
                    deviceDbDeviceInfo2.f1178f = (deviceDbDeviceInfo.f1178f.booleanValue() && k(writableDatabase, cVar3.toString())) ? Boolean.FALSE : deviceDbDeviceInfo.f1178f;
                    writableDatabase.execSQL("INSERT INTO BikeSpdCadComboDeviceIds (Spd_Device_Id, Cad_Device_Id) VALUES (" + deviceDbDeviceInfo.f1174b + ", " + deviceDbDeviceInfo.f1174b + ");");
                    a(writableDatabase, deviceDbDeviceInfo2, cVar3.toString(), com.dsi.ant.channel.b.ANT_PLUS, cVar3.b(), 0, 8102, 57);
                    sb = new StringBuilder();
                    sb.append("UPDATE BikeSpdCadComboDeviceIds SET Cad_Device_Id = ");
                    sb.append(deviceDbDeviceInfo2.f1174b);
                    str2 = " WHERE Spd_Device_Id == ";
                }
                sb.append(str2);
                sb.append(deviceDbDeviceInfo.f1174b);
                sb.append(";");
                writableDatabase.execSQL(sb.toString());
            }
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("PreferredDevicePos", "0");
        sQLiteDatabase.update("Devices", contentValues, "Plugin_Id = " + j2, null);
    }

    private int i(SQLiteDatabase sQLiteDatabase, long j2) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT Spd_Device_Id, Cad_Device_Id FROM BikeSpdCadComboDeviceIds WHERE Spd_Device_Id == " + j2 + " OR Cad_Device_Id == " + j2, null);
        if (!rawQuery.moveToNext()) {
            return -1;
        }
        int i2 = rawQuery.getInt(0);
        if (i2 == j2) {
            i2 = rawQuery.getInt(1);
        }
        rawQuery.close();
        return i2;
    }

    private boolean k(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT EXISTS(SELECT 1 FROM Plugins, Devices WHERE Plugins.VisibleName == '" + str + "' AND Devices.PreferredDevicePos == 1 AND Devices.Plugin_Id == Plugins.Plugin_Id LIMIT 1)", null);
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    public void b(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, String str, com.dsi.ant.channel.b bVar, int i2, int i3, int i4, int i5) {
        SQLiteDatabase writableDatabase = this.f3366a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            a(writableDatabase, deviceDbDeviceInfo, str, bVar, i2, i3, i4, i5);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }

    public void d() {
        this.f3366a.close();
    }

    public int e(com.dsi.ant.channel.b bVar) {
        int i2 = a.f3367a[bVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        throw new RuntimeException("Unrecognized network key type");
    }

    public AntPluginDeviceDbProvider.DeviceDbDeviceInfo f(int i2, String str) {
        SQLiteDatabase readableDatabase = this.f3366a.getReadableDatabase();
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = null;
        Cursor rawQuery = readableDatabase.rawQuery("SELECT Devices.Device_Id, Devices.VisibleName, Devices.PreferredDevicePos, Plugins.Plugin_Id FROM Devices, Plugins WHERE Plugins.VisibleName == '" + str + "' AND Devices.ChanDevId == " + i2 + " AND Devices.Plugin_Id == Plugins.Plugin_Id", null);
        if (rawQuery.moveToNext()) {
            deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
            deviceDbDeviceInfo.f1174b = Long.valueOf(rawQuery.getLong(0));
            deviceDbDeviceInfo.f1177e = rawQuery.getString(1);
            deviceDbDeviceInfo.f1178f = Boolean.valueOf(rawQuery.getInt(2) == 1);
            deviceDbDeviceInfo.f1175c = Long.valueOf(rawQuery.getLong(3));
            deviceDbDeviceInfo.f1176d = Integer.valueOf(i2);
        }
        rawQuery.close();
        readableDatabase.close();
        return deviceDbDeviceInfo;
    }

    public Map g() {
        SQLiteDatabase readableDatabase = this.f3366a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT Devices.Device_Id, Devices.VisibleName, Devices.PreferredDevicePos, Plugins.VisibleName, Plugins.Plugin_Id, Devices.ChanDevId FROM Plugins, Devices WHERE Devices.Plugin_Id == Plugins.Plugin_Id ORDER BY Devices.PreferredDevicePos DESC, Devices.VisibleName", null);
        TreeMap treeMap = new TreeMap();
        while (rawQuery.moveToNext()) {
            AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
            deviceDbDeviceInfo.f1174b = Long.valueOf(rawQuery.getLong(0));
            deviceDbDeviceInfo.f1177e = rawQuery.getString(1);
            deviceDbDeviceInfo.f1178f = Boolean.valueOf(rawQuery.getInt(2) == 1);
            String string = rawQuery.getString(3);
            deviceDbDeviceInfo.f1175c = Long.valueOf(rawQuery.getLong(4));
            deviceDbDeviceInfo.f1176d = Integer.valueOf(rawQuery.getInt(5));
            if (treeMap.containsKey(string)) {
                ((List) treeMap.get(string)).add(deviceDbDeviceInfo);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(deviceDbDeviceInfo);
                treeMap.put(string, arrayList);
            }
        }
        rawQuery.close();
        readableDatabase.close();
        return treeMap;
    }

    public AntPluginDeviceDbProvider.DeviceDbDeviceInfo h(String str) {
        SQLiteDatabase readableDatabase = this.f3366a.getReadableDatabase();
        AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo = null;
        Cursor rawQuery = readableDatabase.rawQuery("SELECT Devices.Device_Id, Devices.VisibleName, Devices.PreferredDevicePos, Plugins.Plugin_Id, Devices.ChanDevId FROM Plugins, Devices WHERE Plugins.VisibleName == '" + str + "' AND Devices.PreferredDevicePos == 1 AND Devices.Plugin_Id == Plugins.Plugin_Id ORDER BY Devices.PreferredDevicePos DESC, Devices.VisibleName", null);
        if (rawQuery.moveToNext()) {
            deviceDbDeviceInfo = new AntPluginDeviceDbProvider.DeviceDbDeviceInfo();
            deviceDbDeviceInfo.f1174b = Long.valueOf(rawQuery.getLong(0));
            deviceDbDeviceInfo.f1177e = rawQuery.getString(1);
            deviceDbDeviceInfo.f1178f = Boolean.valueOf(rawQuery.getInt(2) == 1);
            deviceDbDeviceInfo.f1175c = Long.valueOf(rawQuery.getLong(3));
            deviceDbDeviceInfo.f1176d = Integer.valueOf(rawQuery.getInt(4));
        }
        rawQuery.close();
        readableDatabase.close();
        return deviceDbDeviceInfo;
    }

    public boolean j(long j2) {
        SQLiteDatabase readableDatabase = this.f3366a.getReadableDatabase();
        boolean z2 = i(readableDatabase, j2) >= 0;
        readableDatabase.close();
        return z2;
    }

    public boolean l(String str) {
        SQLiteDatabase readableDatabase = this.f3366a.getReadableDatabase();
        boolean k2 = k(readableDatabase, str);
        readableDatabase.close();
        return k2;
    }

    public void m(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo) {
        SQLiteDatabase writableDatabase = this.f3366a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.delete("Devices", "Device_Id = " + deviceDbDeviceInfo.f1174b, null);
            int i2 = i(writableDatabase, deviceDbDeviceInfo.f1174b.longValue());
            if (i2 != -1) {
                writableDatabase.delete("Devices", "Device_Id = " + i2, null);
                writableDatabase.delete("BikeSpdCadComboDeviceIds", "Spd_Device_Id == " + i2 + " OR Cad_Device_Id == " + i2, null);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public boolean n(AntPluginDeviceDbProvider.DeviceDbDeviceInfo deviceDbDeviceInfo, String str, Boolean bool) {
        boolean z2;
        int i2;
        SQLiteDatabase writableDatabase = this.f3366a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (str.equals(deviceDbDeviceInfo.f1177e)) {
            z2 = false;
        } else {
            contentValues.put("VisibleName", str);
            z2 = true;
        }
        if (bool != deviceDbDeviceInfo.f1178f) {
            if (bool.booleanValue()) {
                contentValues.put("PreferredDevicePos", "1");
                c(writableDatabase, deviceDbDeviceInfo.f1175c.longValue());
            } else {
                contentValues.put("PreferredDevicePos", "0");
            }
        }
        writableDatabase.beginTransaction();
        try {
            if (contentValues.size() > 0) {
                writableDatabase.update("Devices", contentValues, "Device_Id = " + deviceDbDeviceInfo.f1174b.toString(), null);
            }
            if (z2 && (i2 = i(writableDatabase, deviceDbDeviceInfo.f1174b.longValue())) != -1) {
                if (contentValues.containsKey("PreferredDevicePos")) {
                    contentValues.remove("PreferredDevicePos");
                }
                writableDatabase.update("Devices", contentValues, "Device_Id = " + String.valueOf(i2).toString(), null);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
            return contentValues.size() > 0;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }
}
