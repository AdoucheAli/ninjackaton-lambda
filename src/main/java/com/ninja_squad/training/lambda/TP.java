package com.ninja_squad.training.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Le TP Lambda
 * @author JB
 */
public class TP {

    /**
     * Extrayez une List<String> qui contient les senders des tweets
     */
    public static void step1() {
        Tweet.TWEETS.forEach(t -> System.out.println(t.getDate()));
    }

    /**
     * Faites la même chose, sans appeler getDate() ni System.out.println()
     */
    public static void step2() {
        Tweet.TWEETS.stream().map(Tweet::getDate).forEach(System.out::println);
    }

    /**
     * Extrayez une List<String> qui contient les senders des tweets
     */
    public static List<String> step3() {
        return Tweet.TWEETS.stream().map(Tweet::getSender).collect(Collectors.<String>toList());
    }

    /**
     * Extrayez une List<String> qui contient les senders des tweets, sans duplicata
     */
    public static List<String> step4() {
        return Tweet.TWEETS.stream().map(Tweet::getSender).distinct().collect(Collectors.<String>toList());
    }

    /**
     * Extrayez une List<String> qui contient les senders des tweets, sans duplicata, triés par ordre alphabétique
     */
    public static List<String> step5() {
        return Tweet.TWEETS.stream().map(Tweet::getSender).distinct().sorted().collect(Collectors.<String>toList());
    }

    /**
     * Extrayez une List<Tweet> qui contient les tweets contenant le hashtag #lambda
     */
    public static List<Tweet> step6() {
        return Tweet.TWEETS.stream().filter(t -> t.containsHashTag("#lambda")).collect(Collectors.<Tweet>toList());
    }

    /**
     * Extrayez une List<Tweet> qui contient les tweets contenant le hashtag #lambda, triés par sender puis par date
     */
    public static List<Tweet> step7() {
        return step6().stream().sorted(Comparators.<Tweet, String>comparing(Tweet::getSender).thenComparing(Tweet::getDate))
                .collect(Collectors.<Tweet>toList());
    }

    /**
     * Extrayez un Set<String> qui contient l'ensemble des hash tags des tweets
     */
    public static Set<String> step8() {
        return Tweet.TWEETS.stream().flatMap(t -> t.getHashTags().stream()).collect(Collectors.<String>toSet());
    }

    /**
     * Créez une Map<String, List<Tweet>> qui contient, pour chaque sender, les tweets envoyés par ce sender
     */
    public static Map<String, List<Tweet>> step9() {
        return Tweet.TWEETS.stream()
                .collect(Collectors.<Tweet, String, List<Tweet>, Map<String, List<Tweet>>>groupingBy(Tweet::getSender, HashMap::new, ArrayList::new));
    }

    /**
     * Extrayez deux listes: les tweets qui contiennent le hash tag #lambda, et ceux qui ne les contiennent pas.
     */
    public static Map<Boolean, List<Tweet>> step10() {
        return Tweet.TWEETS.stream().collect(Collectors.<Tweet, Boolean, List<Tweet>, Map<Boolean, List<Tweet>>>groupingBy(t -> t.containsHashTag("#lambda"), HashMap::new, ArrayList::new));
    }

    public static class Stats {
        // TODO

        public int getAverage() {
            // TODO
            return 0;
        }

        public int getTotal() {
            // TODO
            return 0;
        }
    }

    /**
     * Calculez le total et la moyenne du nombre de caractères des textes des tweets.
     * Hints:
     *     Créez une class Stats
     *     Utilisez stream.collect(..., ..., ...) ou stream.map(...).reduce(...)
     */
    public static Stats step11() {
        return null;
    }

    /**
     * Faites la même chose, mais de manière parrallèle
     */
    public static Stats step12() {
        return null;
    }
}
