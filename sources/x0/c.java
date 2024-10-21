package x0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.dsi.ant.plugins.antplus.pcc.AntPlusWatchDownloaderPcc;
import java.util.UUID;
import s0.m;
import x0.a;

/* loaded from: classes.dex */
public class c implements m {

    /* renamed from: d */
    private static final String f3581d = "c";

    /* renamed from: b */
    private Context f3583b;

    /* renamed from: a */
    private a f3582a = null;

    /* renamed from: c */
    private boolean f3584c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "watch_antfs.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            h1.a.a(c.f3581d, "Creating ANTFS watch database");
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            sQLiteDatabase.execSQL("CREATE TABLE AntFsDeviceInfo(AntFsDeviceInfo_Id INTEGER PRIMARY KEY,Passkey BLOB,PluginUUID STRING UNIQUE NOT NULL,DisplayName STRING NOT NULL,AntFsManufacturerId INTEGER NOT NULL,AntFsDeviceType INTEGER NOT NULL,AntDeviceNumber INTEGER NOT NULL,AntFsSerialNumber INTEGER,UNIQUE (AntFsManufacturerId, AntFsDeviceType, AntDeviceNumber, AntFsSerialNumber))");
            sQLiteDatabase.execSQL("CREATE TABLE Applications(App_Id INTEGER PRIMARY KEY,AppPkgName STRING UNIQUE NOT NULL)");
            sQLiteDatabase.execSQL("CREATE TABLE LastDownloadRecords(App_Id INTEGER REFERENCES Applications (App_Id),AntFsDeviceInfo_Id INTEGER REFERENCES AntFsDeviceInfo (AntFsDeviceInfo_Id),LastDownloadedGarminTime INTEGER,UNIQUE (App_Id, AntFsDeviceInfo_Id))");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    public c(Context context) {
        this.f3583b = context;
    }

    private long h(a.C0067a c0067a, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT AntFsDeviceInfo_Id FROM AntFsDeviceInfo WHERE (PluginUUID == '" + c0067a.f3562e.c() + "');", null);
        long j2 = rawQuery.moveToNext() ? rawQuery.getLong(0) : -1L;
        rawQuery.close();
        return j2;
    }

    @Override // s0.m
    public void a(m.a aVar) {
        SQLiteDatabase writableDatabase = this.f3582a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("Passkey");
        if (writableDatabase.update("AntFsDeviceInfo", contentValues, "AntFsDeviceInfo_Id == " + aVar.f3255a, null) != 1) {
            throw new RuntimeException("SQL update() failed to clear exactly 1 passkey");
        }
        writableDatabase.close();
    }

    @Override // s0.m
    public void b() {
        this.f3582a = new a(this.f3583b);
    }

    @Override // s0.m
    public m.a c(int i2, int i3, int i4, long j2) {
        this.f3584c = false;
        SQLiteDatabase writableDatabase = this.f3582a.getWritableDatabase();
        m.a aVar = null;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT AntFsDeviceInfo_Id, Passkey, AntFsSerialNumber FROM AntFsDeviceInfo WHERE (AntFsManufacturerId == " + i2 + " AND AntFsDeviceType == " + i3 + " AND AntDeviceNumber == " + i4 + " );", null);
        if (rawQuery.moveToNext()) {
            int i5 = rawQuery.getInt(0);
            if (rawQuery.isNull(2)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("AntFsSerialNumber", Long.valueOf(j2));
                if (writableDatabase.update("AntFsDeviceInfo", contentValues, "AntFsDeviceInfo_Id == " + i5, null) != 1) {
                    throw new RuntimeException("SQL Updating ANTFS serial number failed to update exactly 1 row");
                }
            } else if (rawQuery.getLong(2) != j2) {
                this.f3584c = true;
            }
            if (!rawQuery.isNull(1) && !this.f3584c) {
                aVar = new m.a(i5, rawQuery.getBlob(1), i2, i3, i4, j2);
            }
        }
        rawQuery.close();
        writableDatabase.close();
        return aVar;
    }

    @Override // s0.m
    public void close() {
        this.f3582a.close();
    }

    @Override // s0.m
    public void d(m.a aVar) {
        this.f3584c = false;
        SQLiteDatabase writableDatabase = this.f3582a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Passkey", aVar.f3260f);
        int update = writableDatabase.update("AntFsDeviceInfo", contentValues, "AntFsManufacturerId == " + aVar.f3256b + " AND AntFsDeviceType == " + aVar.f3257c + " AND AntDeviceNumber == " + aVar.f3258d + " AND AntFsSerialNumber == " + aVar.f3259e, null);
        if (update != 1 && (!this.f3584c || update != 0)) {
            throw new IllegalArgumentException("Attempted to add passkey to non existent device.");
        }
        writableDatabase.close();
    }

    public AntPlusWatchDownloaderPcc.DeviceInfo f(int i2, int i3, int i4) {
        SQLiteDatabase readableDatabase = this.f3582a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT AntFsDeviceInfo_Id, PluginUUID, DisplayName FROM AntFsDeviceInfo WHERE (AntFsManufacturerId == " + i2 + " AND AntFsDeviceType == " + i3 + " AND AntDeviceNumber == " + i4 + ");", null);
        AntPlusWatchDownloaderPcc.DeviceInfo deviceInfo = rawQuery.moveToNext() ? new AntPlusWatchDownloaderPcc.DeviceInfo(UUID.fromString(rawQuery.getString(1)), i2, i3, rawQuery.getString(2)) : null;
        rawQuery.close();
        readableDatabase.close();
        return deviceInfo;
    }

    public a.C0067a g(UUID uuid) {
        SQLiteDatabase readableDatabase = this.f3582a.getReadableDatabase();
        a.C0067a c0067a = null;
        Cursor rawQuery = readableDatabase.rawQuery("SELECT AntDeviceNumber, AntFsManufacturerId, AntFsDeviceType, DisplayName FROM AntFsDeviceInfo WHERE (PluginUUID == '" + uuid + "');", null);
        if (rawQuery.moveToNext()) {
            c0067a = new a.C0067a(new j.b(rawQuery.getInt(0), 0, 0), new AntPlusWatchDownloaderPcc.DeviceInfo(uuid, rawQuery.getInt(1), rawQuery.getInt(2), rawQuery.getString(3)), -1);
        }
        rawQuery.close();
        readableDatabase.close();
        return c0067a;
    }

    public long i(String str, a.C0067a c0067a) {
        SQLiteDatabase readableDatabase = this.f3582a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT LastDownloadedGarminTime FROM LastDownloadRecords, Applications WHERE (Applications.AppPkgName == '" + str + "' AND AntFsDeviceInfo_Id == " + h(c0067a, readableDatabase) + " AND Applications.App_Id == LastDownloadRecords.App_Id);", null);
        long j2 = rawQuery.moveToNext() ? rawQuery.getLong(0) : 0L;
        rawQuery.close();
        h1.a.i(f3581d, "Db last time for " + c0067a.f3558a.a() + " is " + j2);
        readableDatabase.close();
        return j2;
    }

    public long j(a.C0067a c0067a) {
        SQLiteDatabase writableDatabase = this.f3582a.getWritableDatabase();
        long h2 = h(c0067a, writableDatabase);
        if (h2 == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("AntFsManufacturerId", Integer.valueOf(c0067a.f3562e.b()));
            contentValues.put("AntFsDeviceType", Integer.valueOf(c0067a.f3562e.a()));
            contentValues.put("AntDeviceNumber", Integer.valueOf(c0067a.f3558a.a()));
            contentValues.put("PluginUUID", c0067a.f3562e.c().toString());
            contentValues.put("DisplayName", c0067a.f3562e.d());
            h2 = writableDatabase.insertOrThrow("AntFsDeviceInfo", null, contentValues);
        }
        writableDatabase.close();
        return h2;
    }

    public boolean k() {
        return this.f3584c;
    }

    public void l(String str, a.C0067a c0067a, long j2) {
        long insertOrThrow;
        SQLiteDatabase writableDatabase = this.f3582a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Cursor rawQuery = writableDatabase.rawQuery("SELECT App_Id FROM Applications WHERE (AppPkgName == '" + str + "');", null);
            if (rawQuery.moveToNext()) {
                insertOrThrow = rawQuery.getLong(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                ContentValues contentValues = new ContentValues();
                contentValues.put("AppPkgName", str);
                insertOrThrow = writableDatabase.insertOrThrow("Applications", null, contentValues);
            }
            long h2 = h(c0067a, writableDatabase);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("LastDownloadedGarminTime", Long.valueOf(j2));
            if (writableDatabase.update("LastDownloadRecords", contentValues2, "App_Id == " + insertOrThrow + " AND AntFsDeviceInfo_Id == " + h2, null) == 0) {
                contentValues2.put("App_Id", Long.valueOf(insertOrThrow));
                contentValues2.put("AntFsDeviceInfo_Id", Long.valueOf(h2));
                writableDatabase.insertOrThrow("LastDownloadRecords", null, contentValues2);
            }
            writableDatabase.setTransactionSuccessful();
            h1.a.i(f3581d, "Setting last time for " + c0067a.f3558a.a() + " to " + j2);
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }
}
