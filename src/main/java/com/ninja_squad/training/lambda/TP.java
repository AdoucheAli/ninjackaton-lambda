package com.ninja_squad.training.lambda;

import java.util.Comparators;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Le TP Lambda
 * @author JB
 */
public class TP {

    /**
     * Ecrivez les dates des tweets sur la sortie standard
     */
    public static void step1() {
        Tweet.TWEETS.forEach(t -> System.out.println(t.getDate()));
    }

    /**
     * Faites la même chose, sans appeler getDate() ni System.out.println()
     */
    public static void step2() {
        Tweet.TWEETS
             .stream()
             .map(Tweet::getDate)
             .forEach(System.out::println);
    }

    /**
     * Extrayez une List<String> qui contient les senders des tweets
     */
    public static List<String> step3() {
        return Tweet.TWEETS
                    .stream()
                    .map(Tweet::getSender)
                    .collect(Collectors.toList());
    }

    /**
     * Extrayez une List<String> qui contient les senders des tweets, sans duplicata
     */
    public static List<String> step4() {
        return Tweet.TWEETS
                    .stream()
                    .map(Tweet::getSender)
                    .distinct()
                    .collect(Collectors.toList());
    }

    /**
     * Extrayez une List<String> qui contient les senders des tweets, sans duplicata, triés par ordre alphabétique
     */
    public static List<String> step5() {
        return Tweet.TWEETS
                    .stream()
                    .map(Tweet::getSender)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
    }

    /**
     * Extrayez une List<Tweet> qui contient les tweets contenant le hashtag #lambda
     */
    public static List<Tweet> step6() {
        return Tweet.TWEETS
                    .stream()
                    .filter(t -> t.containsHashTag("#lambda"))
                    .collect(Collectors.toList());
    }

    /**
     * Extrayez une List<Tweet> qui contient les tweets contenant le hashtag #lambda, triés par sender puis par date
     */
    public static List<Tweet> step7() {
        return Tweet.TWEETS
                    .stream()
                    .filter(t -> t.containsHashTag("#lambda"))
                    .sorted(Comparators.<Tweet, String>comparing((Tweet t) -> t.getSender())
                                       .thenComparing((Tweet t) -> t.getDate()))
                    .collect(Collectors.toList());
    }

    /**
     * Extrayez un Set<String> qui contient l'ensemble des hash tags des tweets
     */
    public static Set<String> step8() {
        return Tweet.TWEETS
                    .stream()
                    .flatMap(t -> t.getHashTags().stream())
                    .collect(Collectors.toSet());
    }

    /**
     * Créez une Map<String, List<Tweet>> qui contient, pour chaque sender, les tweets envoyés par ce sender
     */
    public static Map<String, List<Tweet>> step9() {
        Map<String, List<Tweet>> tweetsPerUser =
            Tweet.TWEETS
                 .stream()
                 .collect(Collectors.groupingBy(Tweet::getSender, Collectors.toList()));
        return tweetsPerUser;
    }

    /**
     * Extrayez deux listes: les tweets qui contiennent le hash tag #lambda, et ceux qui ne les contiennent pas.
     */
    public static Map<Boolean, List<Tweet>> step10() {
        return Tweet.TWEETS
                    .stream()
                    .collect(Collectors.partitioningBy(t -> t.containsHashTag("#lambda")));
    }

    public static class Stats {

        private final int tweetCount;
        private final int characterCount;

        public Stats(int tweetCount, int characterCount) {
            this.tweetCount = tweetCount;
            this.characterCount = characterCount;
        }

        public Stats(Tweet tweet) {
            this.tweetCount = 1;
            this.characterCount = tweet.getText().length();
        }

        public Stats withStats(Stats stats) {
            return new Stats(this.tweetCount + stats.tweetCount, this.characterCount + stats.characterCount);
        }

        public int getAverage() {
            return tweetCount == 0 ? 0 : (characterCount / tweetCount);
        }

        public int getTotal() {
            return characterCount;
        }


    }

    /**
     * Calculez le total et la moyenne du nombre de caractères des textes des tweets.
     * Hints:
     *     Créez une class Stats
     *     Utilisez stream.collect(..., ..., ...) ou stream.map(...).reduce(...)
     */
    public static Stats step11() {
        return Tweet.TWEETS
                    .stream()
                    .map(t -> new Stats(t))
                    .reduce(new Stats(0, 0), (t1, t2) -> t1.withStats(t2));
    }

    /**
     * Faites la même chose, mais de manière parrallèle
     */
    public static Stats step12() {
        return Tweet.TWEETS
                    .parallelStream()
                    .map(t -> new Stats(t))
                    .reduce(new Stats(0, 0), (t1, t2) -> t1.withStats(t2));
    }

    public static Map<Long, Tweet> step13() {
        return Tweet.TWEETS.stream().collect(() -> new HashMap<Long, Tweet>(),
                                             (map, tweet) -> map.put(tweet.getId(), tweet),
                                             (map1, map2) -> map1.putAll(map2));
    }
}
