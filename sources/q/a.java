package q;

import android.os.Bundle;
import com.dsi.ant.message.ipc.AntMessageParcel;
import com.dsi.ant.plugins.antplus.utility.search.SearchResultInfo;
import k.k;
import k.l;

/* loaded from: classes.dex */
public class a extends w0.d {
    @Override // w0.d
    public void B(w0.b bVar, k kVar, SearchResultInfo searchResultInfo) {
        if (searchResultInfo.f978c == null) {
            searchResultInfo.f978c = new Bundle();
        }
        searchResultInfo.f978c.putBoolean("bool_IsCombinedSensor", searchResultInfo.f976a.b() == p0.c.BIKE_SPDCAD.b());
    }

    @Override // u0.b
    public void d() {
    }

    @Override // u0.b
    public String k() {
        return "Bike SpdCad Combo Check";
    }

    @Override // u0.b
    public void o() {
    }

    @Override // u0.b
    public void s() {
    }

    @Override // u0.b
    public void u(l lVar, AntMessageParcel antMessageParcel) {
    }
}
