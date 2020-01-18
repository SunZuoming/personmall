package com.sunzm.personmall.user.mapper;


import com.sunzm.personmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
