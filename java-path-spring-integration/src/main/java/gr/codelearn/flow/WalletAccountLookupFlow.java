package gr.codelearn.flow;

import com.google.common.base.Strings;
import gr.codelearn.service.AccountLookupService;
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
public class WalletAccountLookupFlow {

    private AccountLookupService accountLookupService;

    @Bean
    public MessageChannel walletAccountLookupChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow walletAccountLookupInternalFlow(MessageChannel walletBalanceInquiryChannel, MessageChannel errorChannel) {
        return IntegrationFlows
                .from(walletAccountLookupChannel())
                .transform(accountLookupService::validate)
                .<Map<String, Object>, Boolean>route(m -> Strings.isNullOrEmpty((String) m.get("errorMessage")), message -> message
                        .channelMapping(true, walletBalanceInquiryChannel)
                        .channelMapping(false, errorChannel)
                )
                .get();
    }
}
