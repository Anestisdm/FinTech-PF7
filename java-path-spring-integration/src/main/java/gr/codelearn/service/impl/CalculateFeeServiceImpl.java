package gr.codelearn.service.impl;

import gr.codelearn.domain.Account;
import gr.codelearn.service.AccountLookupService;
import gr.codelearn.service.AccountService;
import gr.codelearn.service.CalculateFeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CalculateFeeServiceImpl implements CalculateFeeService {
    public Map<String, Object> validate(Map<String, Object> payload) {
        log.info("Calculating fees for digital wallets.");

        String paymentAmountStr = (String) payload.get("paymentAmount");
        BigDecimal paymentAmount = new BigDecimal(paymentAmountStr);
        //FeeAmount (string)
        BigDecimal feeAmount = paymentAmount.multiply(BigDecimal.valueOf(1.5 / 100));
        payload.put("feeAmount", feeAmount);
        log.info("Fees calculated.");
        return payload;
    }
}
