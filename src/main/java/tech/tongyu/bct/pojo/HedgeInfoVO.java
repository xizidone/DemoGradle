package tech.tongyu.bct.pojo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@Schema(description = "对冲信息结果")
@AllArgsConstructor
@NoArgsConstructor
public class HedgeInfoVO implements Serializable {

    @Schema(description = "交易簿名称")
    private String bookName;

    @Schema(description = "交易品种对冲信息")
    private List<TradeCategoryHedgeInfoVO> tradeCategoryHedgeInfoVOS;


}
