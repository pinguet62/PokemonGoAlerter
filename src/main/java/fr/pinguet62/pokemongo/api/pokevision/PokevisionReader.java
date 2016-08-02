package fr.pinguet62.pokemongo.api.pokevision;

import static fr.pinguet62.pokemongo.Configuration.METER_TO_DEGREE;
import static java.lang.Math.sqrt;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.annotation.Value;

import fr.pinguet62.pokemongo.api.Reader;
import fr.pinguet62.pokemongo.api.pokevision.dto.PokemonDto;
import fr.pinguet62.pokemongo.api.pokevision.dto.ResultDto;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Pokemon;
import fr.pinguet62.pokemongo.model.Position;

/** @see <a href="https://pokevision.com/">Web site</a> */
// @Component // Offline
public class PokevisionReader implements Reader {

    /**
     * Convert data from DTO to application model.
     *
     * @param dto The {@link PokemonDto}.
     * @return The {@link Appearance}.
     */
    private static Appearance dtoToModel(PokemonDto dto) {
        return new Appearance(Pokemon.fromId(dto.getPokemonId()), new Position(dto.getLatitude(), dto.getLongitude()),
                dto.getExpiration_time());
    }

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

    public ResultDto call(Position position) {
        // @formatter:off
        return ClientBuilder.newClient()
                .target(url)
                    .path(valueOf(position.getLatitude()))
                    .path(valueOf(position.getLongitude()))
                .request()
                    .get(ResultDto.class);
        // @formatter:on
    }

    @Override
    public List<Appearance> get(Position position) {
        // @formatter:off
        return ClientBuilder.newClient()
                .target(url)
                    .path(valueOf(position.getLatitude()))
                    .path(valueOf(position.getLongitude()))
                .request()
                    .get(ResultDto.class)
                        .getPokemon().stream()
                            .map(PokevisionReader::dtoToModel)
                            .collect(toList());
        // @formatter:on
    }

    @Override
    public double getInterval() {
        return sqrt(2)/* because of circle */ * METER_TO_DEGREE.apply(1_000. /* m */); // 0.0006866°
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