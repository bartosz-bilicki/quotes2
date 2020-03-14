package com.example.demo;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
@Builder
class MyClipings {
    private static final Logger LOG= LoggerFactory.getLogger(MethodHandles.publicLookup().lookupClass());

    @Singular("higlight")
    List<Highlight> higlights;

    static MyClipings fromMyClippingsFile(Path path) {
        return MyClipings.builder()
                .build();
    }

    static  List<String> toHiglighs(Path path) throws IOException {
        List<String> higlights=new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)) {
            List<String> collect = lines.collect(Collectors.toUnmodifiableList()); //unoptimal !

            StringBuilder higlight=new StringBuilder();
            for (String line : collect) {
                if (line.isEmpty()) {
                    continue;
                }
                if ("==========".equals(line)) {
                    higlights.add(higlight.toString());
                    higlight=new StringBuilder();
                    continue;
                }
                //TODO: use regex capturing groups to create higlight object
                higlight.append(line);
            }
        }
        return higlights;
    }
}
