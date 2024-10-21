package d1;

import com.google.android.gms.fitness.data.DataPoint;

/* loaded from: classes.dex */
public class g implements z1.b {

    /* renamed from: a */
    public z1.b f1646a;

    /* renamed from: b */
    public z1.b f1647b;

    @Override // z1.b
    public void a(DataPoint dataPoint) {
        z1.b bVar = this.f1646a;
        if (bVar != null) {
            bVar.a(dataPoint);
        }
        z1.b bVar2 = this.f1647b;
        if (bVar2 != null) {
            bVar2.a(dataPoint);
        }
    }
}
