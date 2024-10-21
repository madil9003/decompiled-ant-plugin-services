package w1;

import android.os.IBinder;
import java.lang.reflect.Field;
import q1.f;
import w1.a;

/* loaded from: classes.dex */
public final class b extends a.AbstractBinderC0066a {

    /* renamed from: a */
    private final Object f3522a;

    private b(Object obj) {
        this.f3522a = obj;
    }

    public static Object c(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f3522a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        f.g(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(asBinder);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
        } catch (NullPointerException e4) {
            throw new IllegalArgumentException("Binder object is null.", e4);
        }
    }

    public static a j(Object obj) {
        return new b(obj);
    }
}
