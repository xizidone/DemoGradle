package tech.tongyu.bct.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessGroup {

    OPTION_GROUP("场外期权", 1),
    SWAP_GROUP("收益互换", 2),
    ACCOUNT_GROUP("客户信息", 3),
    CAPITAL_GROUP("资金管理", 4),
    PARAMETER_GROUP("定价参数", 5),
    STRUCTURE_NOTE("收益凭证", 6);

    private String desc;

    private Integer sort;
}
