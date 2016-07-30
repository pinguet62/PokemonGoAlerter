package fr.pinguet62.pokemongo;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pinguet62.pokemongo.api.WebserviceClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Program.class)
public class TestTest {

    @Inject
    private WebserviceClient api;

    @Test
    public void test() {
//        api.getData(position)
    }

}