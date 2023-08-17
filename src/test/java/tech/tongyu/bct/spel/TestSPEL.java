package tech.tongyu.bct.spel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import tech.tongyu.bct.pojo.HedgeInfoCalculateCriteria;
import tech.tongyu.bct.pojo.Sender;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class TestSPEL {

    @Test
    public void TestSPEL02() {
        List<Sender> list = new ArrayList<>();
        Sender build = Sender.builder().bookName("期权").email("123").build();
        Sender build01 = Sender.builder().name("发送02").bookName("期权互换").email("456").build();

        list.add(build);
        list.add(build01);
        list.add(Sender.builder().name("发送03").bookName("期凭证").email("789").build());

        // 创建一个 ExpressionParser 对象
        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("build", build);
        context.setVariable("build01", build01);

        String value1 = parser.parseExpression("(#build.name == null ? 'n' : 'test') + #build01.name")
                .getValue(context, String.class);
        System.out.println(value1);

        Boolean value = parser.parseExpression("#build.name + #build01.name == '发送01发送02'")
                .getValue(context, Boolean.class);
        System.out.println(value);


//        String expression = "name.contains('发送') && email.length() == 3 && bookName.contains('期权')";
//
//        // 创建 SPEL 表达式
//        Expression spelExpression = parser.parseExpression(expression);
//
//        List<Sender> filteredSenders = list.stream()
//                .filter(sender -> spelExpression.getValue(sender, Boolean.class))
//                .collect(Collectors.toList());
//
//        filteredSenders.forEach(System.out::println);


    }

    @Test
    public void TestSPEL01() {
        HedgeInfoCalculateCriteria criteria1 = new HedgeInfoCalculateCriteria();
        criteria1.setBookName("book1");

        HedgeInfoCalculateCriteria criteria2 = new HedgeInfoCalculateCriteria();
        criteria2.setBookName("book2");

        HedgeInfoCalculateCriteria criteria3 = new HedgeInfoCalculateCriteria();
        criteria3.setBookName("book3");

        List<HedgeInfoCalculateCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(criteria1);
        criteriaList.add(criteria2);
        criteriaList.add(criteria3);

        SpelExpressionParser parser = new SpelExpressionParser();

        // 使用集合选择操作符获取包含特定属性值的对象集合
        Expression expression = parser.parseExpression("?[bookName.contains('book')]");
        List<HedgeInfoCalculateCriteria> filteredList = (List<HedgeInfoCalculateCriteria>) expression.getValue(criteriaList);

        // 输出筛选结果
        System.out.println("Filtered list:");
        for (HedgeInfoCalculateCriteria criteria : filteredList) {
            System.out.println(criteria.getBookName());
        }
    }

    @Test
    public void TestSPEL() {
        HedgeInfoCalculateCriteria criteria = new HedgeInfoCalculateCriteria();
        criteria.setBookName("book1");
        criteria.setTradeCategory("category1");
        criteria.setOpenReserve(BigDecimal.valueOf(100));
        criteria.setUnderlyerInstrumentId("instrument1");

        SpelExpressionParser parser = new SpelExpressionParser();


        // 使用 hedgeInfoCalculateCriteria.bookName 访问 bookName 属性，并将其与另一个值进行比较
        Expression expression = parser.parseExpression("hedgeInfoCalculateCriteria.bookName == 'book1'");
        boolean result = Boolean.TRUE.equals(expression.getValue(criteria, Boolean.class));
        System.out.println("hedgeInfoCalculateCriteria.bookName == 'book1': " + result);


        // 判断 bookName 是否为 "book1"
        Expression expression1 = parser.parseExpression("bookName == 'book1'");
        boolean result1 = Boolean.TRUE.equals(expression1.getValue(criteria, Boolean.class));
        System.out.println("bookName == 'book1': " + result1);


        // 判断 openReserve 是否大于 0
        Expression expression2 = parser.parseExpression("openReserve > 0");
        boolean result2 = Boolean.TRUE.equals(expression2.getValue(criteria, Boolean.class));
        System.out.println("openReserve > 0: " + result2);

        // 判断 underlyerInstrumentId 是否以 "instr" 开头
        Expression expression3 = parser.parseExpression("underlyerInstrumentId.startsWith('instr')");
        boolean result3 = Boolean.TRUE.equals(expression3.getValue(criteria, Boolean.class));
        System.out.println("underlyerInstrumentId.startsWith('instr'): " + result3);
    }

}
