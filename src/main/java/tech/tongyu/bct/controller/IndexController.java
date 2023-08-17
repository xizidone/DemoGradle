package tech.tongyu.bct.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.tongyu.bct.pojo.SnInvestorCriteria;

@Tag(name = "SnInvestorController", description = "收益凭证-投资者管理")
@RestController
public class IndexController {

    @Operation(summary = "投资者-分页查询")
    @PostMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestBody SnInvestorCriteria snInvestorCriteria) {
        String investorName = snInvestorCriteria.getInvestorName();
        return ResponseEntity.ok("Hi:" + investorName);
    }
}