package com.ch.dev.async;

import com.ch.dev.async.cache.HbCache;
import com.ch.dev.async.task.HbTask;

public class SyncInterImpl implements SyncInter{

    public boolean detectHb(String id) {
        asyncDetectHb(id);
        return getHbFromCache(id);
    }

    private boolean getHbFromCache(String id){
        return HbCache.getHb(id);
    }

    private void asyncDetectHb(String id){
        HbTask.getInstance().productTask(id);
    }
}
