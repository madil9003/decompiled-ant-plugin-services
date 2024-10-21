package s0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import s0.m;

/* loaded from: classes.dex */
public class k implements m {

    /* renamed from: c */
    private static final String f3250c = "k";

    /* renamed from: a */
    private a f3251a = null;

    /* renamed from: b */
    private Context f3252b;

    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "default_saved_antfs_passkey.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE AntFsDeviceInfo(AntFsDeviceInfo_Id INTEGER PRIMARY KEY,Passkey BLOB NOT NULL,AntFsManufacturerId INTEGER NOT NULL,AntFsDeviceType INTEGER NOT NULL,AntDeviceNumber INTEGER NOT NULL,AntFsSerialNumber INTEGER NOT NULL,UNIQUE (AntFsManufacturerId, AntFsDeviceType, AntDeviceNumber, AntFsSerialNumber))");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    public k(Context context) {
        this.f3252b = context;
    }

    @Override // s0.m
    public void a(m.a aVar) {
        SQLiteDatabase writableDatabase = this.f3251a.getWritableDatabase();
        if (writableDatabase.delete("AntFsDeviceInfo", "AntFsDeviceInfo_Id == " + aVar.f3255a, null) != 1) {
            h1.a.b(f3250c, "SQL Delete() failed to remove exactly 1 passkey");
        }
        writableDatabase.close();
    }

    @Override // s0.m
    public void b() {
        if (this.f3251a == null) {
            this.f3251a = new a(this.f3252b);
        }
    }

    @Override // s0.m
    public m.a c(int i2, int i3, int i4, long j2) {
        SQLiteDatabase readableDatabase = this.f3251a.getReadableDatabase();
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
        a aVar = this.f3251a;
        if (aVar != null) {
            aVar.close();
            this.f3251a = null;
        }
    }

    @Override // s0.m
    public void d(m.a aVar) {
        long insertOrThrow;
        m.a c3 = c(aVar.f3256b, aVar.f3257c, aVar.f3258d, aVar.f3259e);
        SQLiteDatabase writableDatabase = this.f3251a.getWritableDatabase();
        if (c3 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Passkey", aVar.f3260f);
            if (writableDatabase.update("AntFsDeviceInfo", contentValues, "AntFsDeviceInfo_Id == " + c3.f3255a, null) != 1) {
                h1.a.b(f3250c, "SQL Update() did not change exactly 1 passkey row");
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
}
