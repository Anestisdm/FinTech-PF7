package gr.codelearn.flow;

import com.google.common.base.Strings;
import gr.codelearn.service.BalanceInquiryService;
import gr.codelearn.service.WalletBalanceInquiryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

import java.util.Map;

@Configuration
@EnableIntegration
@AllArgsConstructor
public class WalletBalanceInquiryFlow {

    private WalletBalanceInquiryService walletBalanceInquiryService;

    @Bean
    public MessageChannel walletBalanceInquiryChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow walletBalanceInquiryInternalFlow(MessageChannel walletPostingChannel, MessageChannel errorChannel) {
        return IntegrationFlows
                .from(walletBalanceInquiryChannel())
                .transform(walletBalanceInquiryService::checkTransactionFinancially)
                .<Map<Boolean, Object>, Boolean>route(m -> Strings.isNullOrEmpty((String) m.get("errorMessage")), message -> message
                        .channelMapping(true, walletPostingChannel)
                        .channelMapping(false, errorChannel)
                )
                .get();
    }
}
