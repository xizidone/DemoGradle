package tech.tongyu.bct.service;


import tech.tongyu.bct.pojo.EnumVO;

import java.util.List;


/**
 * 下拉选资源获取扩展
 *
 * @author summit
 * @since 2020/11/12 14:19
 */
public interface DictDropDownOptionService {

    /**
     * 字典下拉选扩展
     *
     * @param name 字典名称
     * @return 下拉选
     */
    List<EnumVO> getDicts(String name);

}
