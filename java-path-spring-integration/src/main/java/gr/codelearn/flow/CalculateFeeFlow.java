package gr.codelearn.flow;

import com.google.common.base.Strings;
import gr.codelearn.service.AccountLookupService;
import gr.codelearn.service.CalculateFeeService;
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
public class CalculateFeeFlow {
    private CalculateFeeService calculateFeeService;

    @Bean
    public MessageChannel calculateFeeChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow calculateFeeInternalFlow(MessageChannel walletAccountLookupChannel, MessageChannel errorChannel) {
        return IntegrationFlows
                .from(calculateFeeChannel())
                .transform(calculateFeeService::validate)
                .<Map<String, Object>, Boolean>route(m -> Strings.isNullOrEmpty((String) m.get("errorMessage")), message -> message
                        .channelMapping(true, walletAccountLookupChannel)
                        .channelMapping(false, errorChannel)
                )
                .get();
    }

}
