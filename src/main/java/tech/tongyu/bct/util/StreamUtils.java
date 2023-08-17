package tech.tongyu.bct.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static cn.hutool.core.util.ObjectUtil.isEmpty;
import static java.util.stream.Collectors.toList;

/**
 * Stream api 工具类
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StreamUtils {

    public static <T, R> List<R> map2List(Collection<T> collection, Function<T, R> mapper) {




        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().map(mapper).collect(toList());
    }

    public static <T, R> List<R> map2ListNoneNull(Collection<T> collection, Function<T, R> mapper) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().map(mapper).filter(Objects::nonNull).collect(toList());
    }

    public static <T, R> List<R> mapDistinct2List(Collection<T> collection, Function<T, R> mapper) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().map(mapper).distinct().collect(toList());
    }

    public static <T, R> List<R> mapDistinct2ListNoneNull(Collection<T> collection, Function<T, R> mapper) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().map(mapper).filter(Objects::nonNull).distinct().collect(toList());
    }

    public static <T, R> Set<R> map2Set(Collection<T> collection, Function<T, R> mapper) {
        if (isEmpty(collection)) {
            return Collections.emptySet();
        }
        return collection.stream().map(mapper).collect(Collectors.toSet());
    }

    public static <T, R> Set<R> map2SetNoneNull(Collection<T> collection, Function<T, R> mapper) {
        if (isEmpty(collection)) {
            return Collections.emptySet();
        }
        return collection.stream().map(mapper).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public static <K, V> Map<K, V> toMap(Collection<V> collection, Function<V, K> keyExtractor) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        return collection.stream().collect(Collectors.toMap(keyExtractor, Function.identity(), (a, b) -> a));
    }

    public static <T, K, V> Map<K, V> toMap(Collection<T> collection,
                                            Function<T, K> keyExtractor,
                                            Function<T, V> valueExtractor) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        return collection.stream()
                .filter(v -> valueExtractor.apply(v) != null)
                .collect(Collectors.toMap(keyExtractor, valueExtractor, (a, b) -> a));
    }

    public static <T, K> List<T> distinctBy(Collection<T> collection, Function<T, K> keyExtractor) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        Set<K> set = new HashSet<>();
        return collection.stream().filter(v -> set.add(keyExtractor.apply(v))).collect(toList());
    }

    public static <T, K> Map<K, List<T>> groupBy(Collection<T> collection, Function<T, K> keyExtractor) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        return collection.stream().collect(Collectors.groupingBy(keyExtractor));
    }

    public static <T, K, V> Map<K, List<V>> groupBy(
            Collection<T> collection, Function<T, K> keyExtractor, Function<T, V> valueExtractor) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        return collection.stream()
                .collect(Collectors.groupingBy(keyExtractor, Collectors.mapping(valueExtractor, toList())));
    }

    public static <R> List<R> filter(Collection<R> collection, Predicate<? super R> filtering) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().filter(filtering).collect(toList());
    }

    public static <V> BigDecimal accumulate(Collection<V> collection, Function<V, BigDecimal> valueExtractor) {
        if (isEmpty(collection)) {
            return BigDecimal.ZERO;
        }
        return collection.stream()
                .map(valueExtractor)
                .map(v -> v == null ? BigDecimal.ZERO : v)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
