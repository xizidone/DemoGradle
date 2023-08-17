package tech.tongyu.bct;


import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import tech.tongyu.bct.pojo.*;

import tech.tongyu.bct.service.DictDropDownOptionService;
import tech.tongyu.bct.util.StreamUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
public class ApplicationTest {

    @Value("${bct.username}")
    private String username;

    @Value("${spring.flyway.schemas}")
    private String test;

    @Resource
    private DictDropDownOptionService dictDropDownOptionService;

    @Test
    public void t01() {
        List<String> stringList = null;
        List<String> collect1 = stringList.stream().collect(Collectors.toList());


        List<SnInvestorCriteria> list = new ArrayList<>();
        SnInvestorCriteria build = SnInvestorCriteria.builder().investorName("测试").build();
        SnInvestorCriteria build01 = SnInvestorCriteria.builder().investorName("build").build();
        SnInvestorCriteria build02 = SnInvestorCriteria.builder().investorNo("sdfsd").build();
        list.add(build);
        list.add(build01);
        list.add(build02);

        Function<Object, Object> identity = Function.identity();

        Map<String, SnInvestorCriteria> collect = list.stream().collect(Collectors.toMap(SnInvestorCriteria::getInvestorNo, dto -> dto, (t, t2) -> t));
        System.out.println(collect);

        Map<String, SnInvestorCriteria> stringSnInvestorCriteriaMap = StreamUtils.toMap(list, SnInvestorCriteria::getInvestorName);
        stringSnInvestorCriteriaMap.forEach((s, snInvestorCriteria) -> System.out.println(String.format("%s   ", s) + snInvestorCriteria));

    }

    @Test
    public void t02() throws Throwable {
        String hostname = "https://terminal.tongyu-quant.com";
        try {
            InetAddress address = InetAddress.getByName(hostname);
            String ip = address.getHostAddress();
            System.out.println("IP address of " + hostname + " is " + ip);
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host " + hostname);
        }


        List<HedgeInfoCalculateCriteria> calculateCriteria = new ArrayList<>();
        calculateCriteria.add(new HedgeInfoCalculateCriteria());
        calculateCriteria.add(new HedgeInfoCalculateCriteria());

        System.out.println(calculateCriteria);
        for (HedgeInfoCalculateCriteria calculateCriterion : calculateCriteria) {
            calculateCriterion.setBookName("cesd");
        }

        System.out.println(calculateCriteria);


    }

    @Test
    public void t05() {
        TradingCalendarDTO calendars = new TradingCalendarDTO();
        List<LocalDate> collect = Optional.ofNullable(calendars.getHolidays()).orElse(Collections.emptyList())
                .stream()
                .map(TradingCalendarDTO.Holiday::getHoliday)
                .collect(Collectors.toList());

        System.out.println(collect);


    }

    @Test
    public void t03() {
        ProcessGroup processGroup = ProcessGroup.valueOf("OPTION_GROUP");

        System.out.println(processGroup);


        List<MegaReportDTO> megaReportDTOS = new ArrayList<>();

        MegaReportDTO megaReportDTO = new MegaReportDTO();
        megaReportDTO.setTradeCategory(null);

        MegaReportDTO megaReportDTO1 = new MegaReportDTO();
        megaReportDTO.setTradeCategory("测试");

        megaReportDTOS.add(megaReportDTO1);
        megaReportDTOS.add(megaReportDTO);

        Map<String, List<MegaReportDTO>> collect = megaReportDTOS.stream().peek(dto -> {
            if (dto.getTradeCategory() == null) {
                dto.setTradeCategory("其他");
            }
        }).collect(Collectors.groupingBy(MegaReportDTO::getTradeCategory));
        System.out.println(collect);
    }

    @Test
    public void test04() {

        Map<String, List<HedgeInfoVO>> map = new HashMap<>();
        HedgeInfoVO hedgeInfoVO = new HedgeInfoVO();
        TradeCategoryHedgeInfoVO tradeCategoryHedgeInfoVO = new TradeCategoryHedgeInfoVO();
        tradeCategoryHedgeInfoVO.setTradeCategory("01");
        hedgeInfoVO.setBookName("01");

        hedgeInfoVO.setTradeCategoryHedgeInfoVOS(Collections.singletonList(tradeCategoryHedgeInfoVO));


        List<HedgeInfoVO> hedgeInfoVOS = Collections.singletonList(hedgeInfoVO);
        map.put("username", hedgeInfoVOS);
        System.out.println(map);

        List<HedgeInfoVO> hedgeInfoVOS1 = deepCopyList(hedgeInfoVOS);


        List<HedgeInfoVO> collect = hedgeInfoVOS.stream().filter(dto -> "01".equals(dto.getBookName())).collect(Collectors.toList());
        HedgeInfoVO hedgeInfoVO1 = collect.get(0);
        List<TradeCategoryHedgeInfoVO> tradeCategoryHedgeInfoVOS = hedgeInfoVO1.getTradeCategoryHedgeInfoVOS();
        TradeCategoryHedgeInfoVO tradeCategoryHedgeInfoVO1 = tradeCategoryHedgeInfoVOS.stream().filter(dto -> dto.getTradeCategory().equals("01")).collect(Collectors.toList()).get(0);
        tradeCategoryHedgeInfoVO1.setTradeCategory("sdfsdf");
        tradeCategoryHedgeInfoVO1.setDeltaHedgeQuantity("sdsssssss");


        hedgeInfoVO1.setBookName("测试");

//        System.out.println(hedgeInfoVOS);
        System.out.println(map);


    }


    @Test
    public void test05(){
        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("123");
        list.add("123");

        String join = String.join("\n", list);
        System.out.println(join);

    }


    private static <T> List<T> deepCopyList(List<T> sourceList) {
        List<T> targetList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(sourceList);
            CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, sourceList.get(0).getClass());
            targetList = objectMapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetList;
    }


}
