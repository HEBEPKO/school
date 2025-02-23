package com.example.school.mapper;

public interface Mapper <F,T> {
    public T map(F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
