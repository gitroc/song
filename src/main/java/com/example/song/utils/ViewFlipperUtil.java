package com.example.song.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 获取列表分页泛型统一实现类,支持App任意分页
 * author: roc
 * date: 20170901
 */
public class ViewFlipperUtil {
    public static <T> List<T> getPage(int page, int size, Iterable<T> all) {
        List<T> list = Lists.newArrayList(all);

        if (page <= 0 && size <= 0) {
            return list;
        }

        int fromIndex = (page - 1) * size;
        int toIndex;

        if (list.size() > page * size) {
            toIndex = page * size;
        } else {
            toIndex = list.size();
        }

        if (fromIndex > toIndex) {
            return null;
        }

        return list.subList(fromIndex, toIndex);
    }
}