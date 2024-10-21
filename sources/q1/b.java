package q1;

import android.accounts.Account;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private final Account f3017a;

    /* renamed from: b */
    private final Set f3018b;

    /* renamed from: c */
    private final Set f3019c;

    /* renamed from: d */
    private final Map f3020d;

    /* renamed from: e */
    private final int f3021e;

    /* renamed from: f */
    private final View f3022f;

    /* renamed from: g */
    private final String f3023g;

    /* renamed from: h */
    private final String f3024h;

    /* renamed from: i */
    private final e2.a f3025i;

    /* renamed from: j */
    private Integer f3026j;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private Account f3027a;

        /* renamed from: b */
        private a.b f3028b;

        /* renamed from: c */
        private String f3029c;

        /* renamed from: d */
        private String f3030d;

        /* renamed from: e */
        private e2.a f3031e = e2.a.f1668j;

        public b a() {
            return new b(this.f3027a, this.f3028b, null, 0, null, this.f3029c, this.f3030d, this.f3031e, false);
        }

        public a b(String str) {
            this.f3029c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f3028b == null) {
                this.f3028b = new a.b();
            }
            this.f3028b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f3027a = account;
            return this;
        }

        public final a e(String str) {
            this.f3030d = str;
            return this;
        }
    }

    public b(Account account, Set set, Map map, int i2, View view, String str, String str2, e2.a aVar, boolean z2) {
        this.f3017a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f3018b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f3020d = map;
        this.f3022f = view;
        this.f3021e = i2;
        this.f3023g = str;
        this.f3024h = str2;
        this.f3025i = aVar == null ? e2.a.f1668j : aVar;
        HashSet hashSet = new HashSet(emptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            k1.m.a(it.next());
            throw null;
        }
        this.f3019c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f3017a;
    }

    public Account b() {
        Account account = this.f3017a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set c() {
        return this.f3019c;
    }

    public String d() {
        return this.f3023g;
    }

    public Set e() {
        return this.f3018b;
    }

    public final e2.a f() {
        return this.f3025i;
    }

    public final Integer g() {
        return this.f3026j;
    }

    public final String h() {
        return this.f3024h;
    }

    public final void i(Integer num) {
        this.f3026j = num;
    }
}
