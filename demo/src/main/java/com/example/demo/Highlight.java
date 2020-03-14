package com.example.demo;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Scanner;

/*
﻿Negocjacje dla bystrzaków. Wydanie II (Michael C. Donaldson, David Frohnmayer)
- Your Highlight at location 446-448 | Added on Sunday, 12 July 2015 17:50:08

Pieskie popołudnie to przypuszczalnie najlepszy film o negocjowaniu, jaki możesz zobaczyć. Miliony osób obejrzały młodego Ala Pacino i Charlesa Durninga, jak w mistrzowski sposób odgrywają w tym klasycznym dziele role porywacza i negocjatora.
==========


tytył, w nawiasie autor
- Your Highlight at location liczba-liczba | Added on data
wolna linia
dowolnie duzo linii z text
zakonczone
==========

 */
@Value
@Builder
public class Highlight {
    String title;
    String author;

    Range<Integer> location;
    LocalDateTime added;
    String text;

    public static Highlight parse(String highlight) {
        Scanner scanner=new Scanner(highlight);
        String title = scanner.findInLine("\\(");
        if (title==null) {
            throw new IllegalArgumentException("title not found in "+highlight);
        }
        String author = scanner.findInLine("\\)");

        if (author==null) {
            throw new IllegalArgumentException("title not found in "+highlight);
        }
        String nothig = scanner.nextLine();
        if (nothig.equals("")) {
            throw new IllegalArgumentException("expecting empty string but found "+nothig);
        }
        return Highlight.builder()
                .title(title)
                .author(author)
                .build();
    }
}
