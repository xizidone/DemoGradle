package tech.tongyu.bct.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "对冲信息计算查询条件")
public class HedgeInfoCalculateCriteria {

    @Schema(description = "交易簿名称")
    private String bookName;

    @Schema(
            description = "交易品种"
    )
    private String tradeCategory;

    @Schema(
            description = "预留敞口"
    )
    private BigDecimal openReserve;

    @Schema(
            description = "对冲合约"
    )
    private String underlyerInstrumentId;
}
