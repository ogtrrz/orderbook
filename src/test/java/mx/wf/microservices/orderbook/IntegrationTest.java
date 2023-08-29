package mx.wf.microservices.orderbook;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mx.wf.microservices.orderbook.OrderbookApp;
import mx.wf.microservices.orderbook.config.AsyncSyncConfiguration;
import mx.wf.microservices.orderbook.config.EmbeddedElasticsearch;
import mx.wf.microservices.orderbook.config.EmbeddedKafka;
import mx.wf.microservices.orderbook.config.EmbeddedRedis;
import mx.wf.microservices.orderbook.config.EmbeddedSQL;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { OrderbookApp.class, AsyncSyncConfiguration.class })
@EmbeddedRedis
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
