package gr.codelearn.flow;

import gr.codelearn.service.PostingService;
import gr.codelearn.service.ReportingService;
import gr.codelearn.service.WalletPostingService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@AllArgsConstructor
public class WalletPostingFlow {

    private WalletPostingService walletPostingService;
    //private WalletReportingService walletReportingService;

    @Bean
    public MessageChannel walletPostingChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow walletPostingInternalFlow() {
        return IntegrationFlows
                .from(walletPostingChannel())
                .transform(walletPostingService::makeTransaction)
                //.handle(message -> WalletReportingService.executeReports(message))
                .get();
    }
}
