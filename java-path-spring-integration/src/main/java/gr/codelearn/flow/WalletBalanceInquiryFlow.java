package gr.codelearn.flow;

import com.google.common.base.Strings;
import gr.codelearn.service.BalanceInquiryService;
import gr.codelearn.service.WalletBalanceInquiryService;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

import java.util.Map;

public class WalletBalanceInquiryFlow {

    private WalletBalanceInquiryService walletBalanceInquiryService;

    @Bean
    public MessageChannel walletBalanceInquiryChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow walletBalanceInquiryInternalFlow(MessageChannel WalletPostingChannel, MessageChannel errorChannel) {
        return IntegrationFlows
                .from(walletBalanceInquiryChannel())
                .transform(walletBalanceInquiryService::checkTransactionFinancially)
                .<Map<Boolean, Object>, Boolean>route(m -> Strings.isNullOrEmpty((String) m.get("errorMessage")), message -> message
                        .channelMapping(true, WalletPostingChannel)
                        .channelMapping(false, errorChannel)
                )
                .get();
    }
}
