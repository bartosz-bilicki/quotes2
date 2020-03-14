package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class MyClipingsTest {
    private static final Logger LOG= LoggerFactory.getLogger(MethodHandles.publicLookup().lookupClass());

    @Test
    void toHiglighs() throws IOException {
        Path path = Paths.get("src", "test", "resources", "My Clippings-2017-06-02.txt");
        List<String> stringStream = MyClipings.toHiglighs(path);

        ;
        LOG.info("{}", String.join("\n", stringStream));
    }

}