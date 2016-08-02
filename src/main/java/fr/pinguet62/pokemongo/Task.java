package fr.pinguet62.pokemongo;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.api.Reader;
import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.model.Zone;
import fr.pinguet62.pokemongo.preferencies.Preferencies;

@Component
@EnableScheduling
public class Task {

    private static final Logger LOGGER = getLogger(Task.class);

    @Inject
    private List<Filter> filters;

    @Inject
    private List<Handler> handlers;

    @Inject
    private Preferencies preferencies;

    @Inject
    private Reader reader;

    @Scheduled(fixedDelay = 10_000)
    public void check2() {
        LOGGER.info("New schedule...");

        Filter allFilters = filters.stream().reduce(Filter::and).orElse(t -> true);
        Consumer<Appearance> allHandler = app -> handlers.stream().forEach(hdl -> hdl.accept(app));

        Zone.crissCross(preferencies.getZones(), reader.getInterval()).forEach(pos -> {
            reader.get(pos).stream().filter(allFilters).forEach(allHandler);
        });
    }

}