package fr.pinguet62.pokemongo.api;

import static java.lang.String.valueOf;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.api.dto.ResultDto;
import fr.pinguet62.pokemongo.model.Position;

@Component
public class WebserviceClient {

    @Value("${http.proxyHost:}")
    private String httpProxyHost;

    @Value("${http.proxyPort:}")
    private Integer httpProxyPort;

    @Value("${https.proxyHost:}")
    private String httpsProxyHost;

    @Value("${https.proxyPort:}")
    private Integer httpsProxyPort;

    // @Value("${api.url}")
    private final String url = "https://pokevision.com/map/data";

    public ResultDto getData(Position position) {
        return ClientBuilder.newClient().target(url).path(valueOf(position.getLatitude()))
                .path(valueOf(position.getLongitude())).request().get(ResultDto.class);
    }

    @PostConstruct
    private void initProxy() {
        Properties props = System.getProperties();
        if (!"".equals(httpProxyHost))
            props.setProperty("http.proxyHost", httpProxyHost);
        if (httpProxyPort != null)
            props.setProperty("http.proxyPort", valueOf(httpProxyPort));
        if (!"".equals(httpsProxyHost))
            props.setProperty("https.proxyHost", httpsProxyHost);
        if (httpsProxyPort != null)
            props.setProperty("https.proxyPort", valueOf(httpsProxyPort));
    }

}