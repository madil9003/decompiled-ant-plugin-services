package b;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a */
    private final Notification.Builder f174a;

    /* renamed from: b */
    private final c.d f175b;

    /* renamed from: c */
    private RemoteViews f176c;

    /* renamed from: d */
    private RemoteViews f177d;

    /* renamed from: e */
    private final List f178e = new ArrayList();

    /* renamed from: f */
    private final Bundle f179f = new Bundle();

    /* renamed from: g */
    private int f180g;

    /* renamed from: h */
    private RemoteViews f181h;

    public d(c.d dVar) {
        this.f175b = dVar;
        Notification.Builder builder = new Notification.Builder(dVar.f144a, dVar.I);
        this.f174a = builder;
        Notification notification = dVar.O;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f151h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f147d).setContentText(dVar.f148e).setContentInfo(dVar.f153j).setContentIntent(dVar.f149f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f150g, (notification.flags & 128) != 0).setLargeIcon(dVar.f152i).setNumber(dVar.f154k).setProgress(dVar.f161r, dVar.f162s, dVar.f163t);
        builder.setSubText(dVar.f159p).setUsesChronometer(dVar.f157n).setPriority(dVar.f155l);
        Iterator it = dVar.f145b.iterator();
        while (it.hasNext()) {
            b((c.a) it.next());
        }
        Bundle bundle = dVar.B;
        if (bundle != null) {
            this.f179f.putAll(bundle);
        }
        this.f176c = dVar.F;
        this.f177d = dVar.G;
        this.f174a.setShowWhen(dVar.f156m);
        this.f174a.setLocalOnly(dVar.f167x).setGroup(dVar.f164u).setGroupSummary(dVar.f165v).setSortKey(dVar.f166w);
        this.f180g = dVar.M;
        this.f174a.setCategory(dVar.A).setColor(dVar.C).setVisibility(dVar.D).setPublicVersion(dVar.E).setSound(notification.sound, notification.audioAttributes);
        Iterator it2 = dVar.P.iterator();
        while (it2.hasNext()) {
            this.f174a.addPerson((String) it2.next());
        }
        this.f181h = dVar.H;
        if (dVar.f146c.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle();
            for (int i2 = 0; i2 < dVar.f146c.size(); i2++) {
                bundle3.putBundle(Integer.toString(i2), e.a((c.a) dVar.f146c.get(i2)));
            }
            bundle2.putBundle("invisible_actions", bundle3);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f179f.putBundle("android.car.EXTENSIONS", bundle2);
        }
        this.f174a.setExtras(dVar.B).setRemoteInputHistory(dVar.f160q);
        RemoteViews remoteViews = dVar.F;
        if (remoteViews != null) {
            this.f174a.setCustomContentView(remoteViews);
        }
        RemoteViews remoteViews2 = dVar.G;
        if (remoteViews2 != null) {
            this.f174a.setCustomBigContentView(remoteViews2);
        }
        RemoteViews remoteViews3 = dVar.H;
        if (remoteViews3 != null) {
            this.f174a.setCustomHeadsUpContentView(remoteViews3);
        }
        this.f174a.setBadgeIconType(dVar.J).setShortcutId(dVar.K).setTimeoutAfter(dVar.L).setGroupAlertBehavior(dVar.M);
        if (dVar.f169z) {
            this.f174a.setColorized(dVar.f168y);
        }
        if (!TextUtils.isEmpty(dVar.I)) {
            this.f174a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        this.f174a.setAllowSystemGeneratedContextualActions(dVar.N);
        this.f174a.setBubbleMetadata(c.C0003c.a(null));
    }

    private void b(c.a aVar) {
        IconCompat e3 = aVar.e();
        Notification.Action.Builder builder = new Notification.Action.Builder(e3 == null ? null : e3.j(), aVar.i(), aVar.a());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : f.b(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        builder.setAllowGeneratedReplies(aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        builder.setSemanticAction(aVar.g());
        builder.setContextual(aVar.j());
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f174a.addAction(builder.build());
    }

    @Override // b.b
    public Notification.Builder a() {
        return this.f174a;
    }

    public Notification c() {
        Bundle a3;
        RemoteViews e3;
        RemoteViews c3;
        c.e eVar = this.f175b.f158o;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews d3 = eVar != null ? eVar.d(this) : null;
        Notification d4 = d();
        if (d3 != null || (d3 = this.f175b.F) != null) {
            d4.contentView = d3;
        }
        if (eVar != null && (c3 = eVar.c(this)) != null) {
            d4.bigContentView = c3;
        }
        if (eVar != null && (e3 = this.f175b.f158o.e(this)) != null) {
            d4.headsUpContentView = e3;
        }
        if (eVar != null && (a3 = c.a(d4)) != null) {
            eVar.a(a3);
        }
        return d4;
    }

    protected Notification d() {
        return this.f174a.build();
    }
}
