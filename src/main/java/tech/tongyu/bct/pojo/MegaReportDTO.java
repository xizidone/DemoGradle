
package tech.tongyu.bct.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MegaReportDTO{
    @Schema(
        description = "交易簿名称"
    )
    private String bookName;

    @Schema(
        description = "交易品种"
    )
    private String tradeCategory;

}
