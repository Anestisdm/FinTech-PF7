package gr.codelearn.service;

import java.util.Map;

public interface WalletPostingService {
    Map<String, Object> makeTransaction(Map<String, Object> payload);
}
