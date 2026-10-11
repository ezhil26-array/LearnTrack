package com.airtribe.learntrack.service;

import com.airtribe.learntrack.exception.CourseNotFoundException;

import java.util.List;

public interface LearnTrackService<T> {

    public List<T> getList(T t);
    public T get(T t) throws Exception;
    public T get(long id) throws Exception;
    public String add(T t);
    public String remove(T t);
    public String update(T t);
}
