package cn.autumnclouds.sgms.service;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fu Qiujie
 * @since 2024/4/2
 */
public interface RandomlyAccessibleService<T> extends IService<T> {
    default <R> List<R> random(int count, SFunction<T, R> column) {
        return RandomUtil.randomEleList(this.lambdaQuery().select(column).list().stream().map(column).toList(), count);
    }

    default List<T> random(int count) {
        return RandomUtil.randomEleList(this.lambdaQuery().list().stream().toList(), count);
    }


    default T random() {
        return random(1).get(0);
    }

    default <R> R random(SFunction<T, R> column) {
        return random(1, column).get(0);
    }

}
