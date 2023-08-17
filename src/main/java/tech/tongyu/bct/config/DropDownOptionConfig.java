package tech.tongyu.bct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.tongyu.bct.service.DictDropDownOptionService;


/**
 * 下拉选配置
 *
 * @author summit
 * @since 2020/11/11 14:45
 */
@Configuration
public class DropDownOptionConfig {


    /**
     * 扩展 下拉选获取（从字典中获取）
     *
     * @return 字典下拉选
     */

    @Bean
    public DictDropDownOptionService customDropDownOptionService() {
        return name -> null;
    }

}
