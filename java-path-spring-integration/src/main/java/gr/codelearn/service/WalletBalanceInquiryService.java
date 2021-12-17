package gr.codelearn.service;

import java.util.Map;

public interface WalletBalanceInquiryService {
    Map<String, Object> checkTransactionFinancially(Map<String, Object> payload);
}
