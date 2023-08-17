package tech.tongyu.bct.cache;

import tech.tongyu.bct.pojo.HedgeInfoVO;
import tech.tongyu.bct.pojo.TradeCategoryHedgeInfoVO;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对冲管理信息缓存
 */
public class HedgeManagementInfoCache {
    public static void main(String[] args) {


        List<HedgeInfoVO> list = new ArrayList<>();
        HedgeInfoVO hedgeInfoVO = HedgeInfoVO.builder().build();
        TradeCategoryHedgeInfoVO tradeCategoryHedgeInfoVO = TradeCategoryHedgeInfoVO.builder().tradeCategory("测试数据").errorMessage("测试信息").build();
        List<TradeCategoryHedgeInfoVO> tradeCategoryHedgeInfoVOS = new ArrayList<>();
        tradeCategoryHedgeInfoVOS.add(tradeCategoryHedgeInfoVO);
        hedgeInfoVO.setTradeCategoryHedgeInfoVOS(tradeCategoryHedgeInfoVOS);
        hedgeInfoVO.setBookName("测试bookName");
        list.add(hedgeInfoVO);
        HedgeManagementInfoCache.setCache("测试", list);

        List<HedgeInfoVO> cache = HedgeManagementInfoCache.getCache("测试");
        System.out.println(cache);
        cache.get(0).setBookName("修改");

        System.out.println(HedgeManagementInfoCache.getCache("测试"));

    }

    private final static ConcurrentHashMap<String, SoftReference<List<HedgeInfoVO>>> CACHE = new ConcurrentHashMap<>();


    public static List<HedgeInfoVO> getCache(String username) {
        SoftReference<List<HedgeInfoVO>> softReference = CACHE.get(username);

        List<HedgeInfoVO> hedgeInfoVOS = Optional.ofNullable(CACHE.get(username))
                .map(SoftReference::get)
                .orElse(null);


        return hedgeInfoVOS;
    }

    public static void setCache(String username, List<HedgeInfoVO> list) {
        CACHE.put(username, new SoftReference<>(list));
    }

}
