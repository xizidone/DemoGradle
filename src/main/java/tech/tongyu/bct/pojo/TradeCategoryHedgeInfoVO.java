package tech.tongyu.bct.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "交易品种对冲信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeCategoryHedgeInfoVO {

    @Schema(
            description = "交易品种"
    )
    private String tradeCategory;

    @Schema(
            description = "现货期货-Delta Cash"
    )
    private BigDecimal listedDeltaCash;

    @Schema(
            description = "场外期权-Delta Cash"
    )
    private BigDecimal otcOptionDeltaCash;

    @Schema(
            description = "收益互换-Delta Cash"
    )
    private BigDecimal swapDeltaCash;

    @Schema(
            description = "净 Delta Cash"
    )
    private BigDecimal cashNetDelta;

    @Schema(
            description = "预留敞口"
    )
    private BigDecimal openReserve;

    @Schema(
            description = "对冲合约"
    )
    private String underlyerInstrumentId;

    @Schema(
            description = "Delta 对冲数量（手/股）"
    )
    private String deltaHedgeQuantity;

    @Schema(
            description = "对冲后净敞口"
    )
    private BigDecimal netHedgedExposure;

    @Schema(
            description = "Gamma Cash"
    )
    private BigDecimal gammaCash;

    @Schema(
            description = "Gamma 对冲数量（手/股）"
    )
    private String gammaCashQuantity;

    @Schema(description = "错误信息展示")
    private String errorMessage;

}
