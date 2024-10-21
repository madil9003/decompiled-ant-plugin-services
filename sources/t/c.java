package t;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import s0.m;

/* loaded from: classes.dex */
public class c implements m {

    /* renamed from: d */
    private static final String f3331d = "c";

    /* renamed from: a */
    private a f3332a = null;

    /* renamed from: b */
    private Context f3333b;

    /* renamed from: c */
    private final int f3334c;

    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "bpm_download.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            h1.a.a(c.f3331d, "Creating blood pressure ANTFS downloads database");
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            sQLiteDatabase.execSQL("CREATE TABLE AntFsDeviceInfo(AntFsDeviceInfo_Id INTEGER PRIMARY KEY,Passkey BLOB,AntFsSerialNumber INTEGER,AntFsManufacturerId INTEGER NOT NULL,AntFsDeviceType INTEGER NOT NULL,AntDeviceNumber INTEGER NOT NULL,UNIQUE (AntFsManufacturerId, AntFsDeviceType, AntFsSerialNumber, AntDeviceNumber))");
            sQLiteDatabase.execSQL("CREATE TABLE Applications(App_Id INTEGER PRIMARY KEY,AppPkgName STRING UNIQUE NOT NULL)");
            sQLiteDatabase.execSQL("CREATE TABLE LastDownloadRecords(App_Id INTEGER REFERENCES Applications (App_Id),AntFsDeviceInfo_Id INTEGER REFERENCES AntFsDeviceInfo (AntFsDeviceInfo_Id),LastDownloadedGarminTime INTEGER DEFAULT 0,LastDeliveredMeasurementGarminTimestamp INTEGER DEFAULT 0,UNIQUE (App_Id, AntFsDeviceInfo_Id))");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    public c(Context context, int i2) {
        this.f3333b = context;
        this.f3334c = i2;
    }

    private long f(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT App_Id FROM Applications WHERE (AppPkgName == '" + str + "');", null);
        if (rawQuery.moveToNext()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            return j2;
        }
        rawQuery.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("AppPkgName", str);
        return sQLiteDatabase.insertOrThrow("Applications", null, contentValues);
    }

    @Override // s0.m
    public void a(m.a aVar) {
        SQLiteDatabase writableDatabase = this.f3332a.getWritableDatabase();
        if (writableDatabase.delete("AntFsDeviceInfo", "AntFsDeviceInfo_Id == " + aVar.f3255a, null) != 1) {
            h1.a.b(f3331d, "SQL Delete() failed to remove exactly 1 passkey");
        }
        writableDatabase.close();
    }

    @Override // s0.m
    public void b() {
        if (this.f3332a == null) {
            this.f3332a = new a(this.f3333b);
        }
    }

    @Override // s0.m
    public m.a c(int i2, int i3, int i4, long j2) {
        SQLiteDatabase readableDatabase = this.f3332a.getReadableDatabase();
        m.a aVar = null;
        Cursor rawQuery = readableDatabase.rawQuery("SELECT AntFsDeviceInfo_Id, Passkey FROM AntFsDeviceInfo WHERE (AntFsManufacturerId == " + i2 + " AND AntFsDeviceType == " + i3 + " AND AntDeviceNumber == " + i4 + " AND AntFsSerialNumber == " + j2 + ");", null);
        if (rawQuery.moveToNext()) {
            aVar = new m.a(rawQuery.getInt(0), rawQuery.getBlob(1), i2, i3, i4, j2);
        }
        rawQuery.close();
        readableDatabase.close();
        return aVar;
    }

    @Override // s0.m
    public void close() {
        a aVar = this.f3332a;
        if (aVar != null) {
            aVar.close();
            this.f3332a = null;
        }
    }

    @Override // s0.m
    public void d(m.a aVar) {
        long insertOrThrow;
        m.a c3 = c(aVar.f3256b, aVar.f3257c, aVar.f3258d, aVar.f3259e);
        SQLiteDatabase writableDatabase = this.f3332a.getWritableDatabase();
        if (c3 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Passkey", aVar.f3260f);
            if (writableDatabase.update("AntFsDeviceInfo", contentValues, "AntFsDeviceInfo_Id == " + c3.f3255a, null) != 1) {
                h1.a.b(f3331d, "SQL Update() did not change exactly 1 passkey row");
            }
            insertOrThrow = c3.f3255a;
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("Passkey", aVar.f3260f);
            contentValues2.put("AntFsManufacturerId", Integer.valueOf(aVar.f3256b));
            contentValues2.put("AntFsDeviceType", Integer.valueOf(aVar.f3257c));
            contentValues2.put("AntDeviceNumber", Integer.valueOf(aVar.f3258d));
            contentValues2.put("AntFsSerialNumber", Long.valueOf(aVar.f3259e));
            insertOrThrow = writableDatabase.insertOrThrow("AntFsDeviceInfo", null, contentValues2);
        }
        aVar.f3255a = insertOrThrow;
        writableDatabase.close();
    }

    public long g() {
        SQLiteDatabase readableDatabase = this.f3332a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT AntFsDeviceInfo_Id FROM AntFsDeviceInfo WHERE (AntDeviceNumber == '" + this.f3334c + "');", null);
        long j2 = rawQuery.moveToNext() ? rawQuery.getLong(0) : -1L;
        rawQuery.close();
        readableDatabase.close();
        return j2;
    }

    public long h(String str, long j2) {
        SQLiteDatabase readableDatabase = this.f3332a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT LastDownloadedGarminTime FROM LastDownloadRecords, Applications WHERE (Applications.AppPkgName == '" + str + "' AND AntFsDeviceInfo_Id == " + j2 + " AND Applications.App_Id == LastDownloadRecords.App_Id);", null);
        long j3 = rawQuery.moveToNext() ? rawQuery.getLong(0) : 0L;
        rawQuery.close();
        readableDatabase.close();
        return j3;
    }

    public long i(String str, long j2) {
        SQLiteDatabase readableDatabase = this.f3332a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT LastDeliveredMeasurementGarminTimestamp FROM LastDownloadRecords, Applications WHERE (Applications.AppPkgName == '" + str + "' AND AntFsDeviceInfo_Id == " + j2 + " AND Applications.App_Id == LastDownloadRecords.App_Id);", null);
        long j3 = rawQuery.moveToNext() ? rawQuery.getLong(0) : 0L;
        rawQuery.close();
        readableDatabase.close();
        return j3;
    }

    public void j(String str, long j2, long j3) {
        SQLiteDatabase writableDatabase = this.f3332a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            long f3 = f(writableDatabase, str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("LastDownloadedGarminTime", Long.valueOf(j3));
            if (writableDatabase.update("LastDownloadRecords", contentValues, "App_Id == " + f3 + " AND AntFsDeviceInfo_Id == " + j2, null) == 0) {
                contentValues.put("App_Id", Long.valueOf(f3));
                contentValues.put("AntFsDeviceInfo_Id", Long.valueOf(j2));
                writableDatabase.insertOrThrow("LastDownloadRecords", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }

    public void k(String str, long j2, long j3) {
        SQLiteDatabase writableDatabase = this.f3332a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            long f3 = f(writableDatabase, str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("LastDeliveredMeasurementGarminTimestamp", Long.valueOf(j3));
            if (writableDatabase.update("LastDownloadRecords", contentValues, "App_Id == " + f3 + " AND AntFsDeviceInfo_Id == " + j2, null) == 0) {
                contentValues.put("App_Id", Long.valueOf(f3));
                contentValues.put("AntFsDeviceInfo_Id", Long.valueOf(j2));
                writableDatabase.insertOrThrow("LastDownloadRecords", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }
}
