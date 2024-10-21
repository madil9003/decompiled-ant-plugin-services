package o;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private c f2705a;

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        private int f2706a;

        /* renamed from: b */
        public int f2707b;

        /* renamed from: c */
        public int f2708c;

        /* renamed from: d */
        public long f2709d;

        private b(a aVar, int i2, int i3, int i4, long j2) {
            this(i3, i4, j2);
            this.f2706a = i2;
        }

        public int c() {
            return this.f2706a;
        }

        public void d(int i2) {
            this.f2706a = i2;
        }

        /* synthetic */ b(a aVar, int i2, int i3, int i4, long j2, C0044a c0044a) {
            this(aVar, i2, i3, i4, j2);
        }

        public b(int i2, int i3, long j2) {
            this.f2707b = i2;
            this.f2708c = i3;
            this.f2709d = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends SQLiteOpenHelper {
        public c(Context context) {
            super(context, "saved_bikepwrcals.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE Calibrations(Calibration_Id INTEGER PRIMARY KEY,AntDeviceNumber INTEGER NOT NULL,CalibrationValue INTEGER NOT NULL,Timestamp INTEGER NOT NULL)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    public a(Context context) {
        this.f2705a = null;
        this.f2705a = new c(context);
    }

    public b a(int i2) {
        SQLiteDatabase readableDatabase = this.f2705a.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT Calibration_Id, AntDeviceNumber, CalibrationValue, Timestamp FROM Calibrations WHERE (AntDeviceNumber == " + i2 + ");", null);
        b bVar = rawQuery.moveToNext() ? new b(rawQuery.getInt(0), i2, rawQuery.getInt(2), rawQuery.getLong(3)) : null;
        rawQuery.close();
        readableDatabase.close();
        return bVar;
    }

    public void b(b bVar) {
        int insert;
        b a3 = a(bVar.f2707b);
        SQLiteDatabase writableDatabase = this.f2705a.getWritableDatabase();
        if (a3 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CalibrationValue", Integer.valueOf(bVar.f2708c));
            contentValues.put("Timestamp", Long.valueOf(bVar.f2709d));
            writableDatabase.update("Calibrations", contentValues, "Calibration_Id == " + a3.c(), null);
            insert = a3.c();
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("AntDeviceNumber", Integer.valueOf(bVar.f2707b));
            contentValues2.put("CalibrationValue", Integer.valueOf(bVar.f2708c));
            contentValues2.put("Timestamp", Long.valueOf(bVar.f2709d));
            insert = (int) writableDatabase.insert("Calibrations", null, contentValues2);
        }
        bVar.d(insert);
        writableDatabase.close();
    }
}
