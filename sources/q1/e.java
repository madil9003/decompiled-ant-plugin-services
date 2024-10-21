package q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private final List f3034a;

        /* renamed from: b */
        private final Object f3035b;

        /* synthetic */ a(Object obj, v vVar) {
            f.g(obj);
            this.f3035b = obj;
            this.f3034a = new ArrayList();
        }

        public a a(String str, Object obj) {
            List list = this.f3034a;
            f.g(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str.length() + 1 + valueOf.length());
            sb.append(str);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f3035b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f3034a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) this.f3034a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
