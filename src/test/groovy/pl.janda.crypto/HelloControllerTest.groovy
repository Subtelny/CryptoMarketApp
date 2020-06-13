package pl.janda.crypto

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class HelloControllerTest extends Specification {

    @Inject
    @Client("/")
    RxHttpClient client;

    def "test hello controller"() {
        given:
        def request = HttpRequest.GET("/hello");

        when:
        def body = client.toBlocking().retrieve(request);

        then:
        body != null;
        body == "hello world";
    }

}
