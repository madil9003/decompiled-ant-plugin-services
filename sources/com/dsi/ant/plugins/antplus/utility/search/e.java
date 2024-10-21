package com.dsi.ant.plugins.antplus.utility.search;

import com.dsi.ant.channel.AntChannel;

/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public enum a {
        TIMEOUT,
        CRASH,
        INTERRUPTED
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(SearchResultInfo searchResultInfo, AntChannel antChannel);

        void d(a aVar, AntChannel antChannel);
    }

    void a();

    boolean b(AntChannel antChannel, b bVar);
}
