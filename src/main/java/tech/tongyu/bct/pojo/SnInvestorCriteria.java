package tech.tongyu.bct.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 投资人查询条件
 */

@Schema(description = "投资人查询条件")
@Data
@Accessors(chain = true)
@Builder
public class SnInvestorCriteria {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "投资者类型", example = "01")
    private String investorType;

    @Schema(description = "投资者名称")
    private String investorName;

    @Schema(description = "投资者证件号码")
    private String investorNo;
}