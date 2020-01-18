package com.sunzm.personmall.service;


import com.sunzm.personmall.bean.PmsSearchParam;
import com.sunzm.personmall.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
