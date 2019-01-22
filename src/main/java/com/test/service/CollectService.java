package com.test.service;

import com.test.entity.Collect;
import com.test.entity.CollectKey;

import java.util.List;

public interface CollectService {
    boolean insertCollect(Collect collect);
    boolean deleteCollect(String username);
    List<Collect> selectCollect(String username);
}
