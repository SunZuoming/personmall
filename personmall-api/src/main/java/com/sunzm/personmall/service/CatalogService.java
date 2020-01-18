package com.sunzm.personmall.service;

import com.sunzm.personmall.bean.PmsBaseCatalog1;
import com.sunzm.personmall.bean.PmsBaseCatalog2;
import com.sunzm.personmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
