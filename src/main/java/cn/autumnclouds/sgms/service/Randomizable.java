package cn.autumnclouds.sgms.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Fu Qiujie
 * @since 2024/4/2
 */
public interface Randomizable<T> {
    T randomGenerate();

    default Collection<T> randomGenerate(int count) {
        return IntStream.range(0, count).parallel().mapToObj(i -> randomGenerate()).collect(Collectors.toList());
    }

}
