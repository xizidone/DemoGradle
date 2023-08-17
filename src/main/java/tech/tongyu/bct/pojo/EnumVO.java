package tech.tongyu.bct.pojo;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 枚举字典对象
 *
 * @author summit
 * @since 2020/11/11 15:09
 */
@Data
@Schema(description = "枚举字典对象")
@NoArgsConstructor
@AllArgsConstructor
public class EnumVO implements Serializable {

    private static final long serialVersionUID = -6137259969020869414L;

    @Schema(description = "枚举编号")
    private String code;

    @Schema(description = "枚举名称")
    private String name;

    @Schema(description = "是否隐藏")
    private Boolean hidden;

    @Schema(description = "枚举显示")
    private Boolean disabled;

    public EnumVO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return getCode();
    }
}
