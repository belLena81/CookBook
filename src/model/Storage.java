package model;

import java.util.List;

public interface Storage<T> {
    void add(T recipe);
    boolean delete(String recipeName);
    T find(String recipeName);
    List<T> findAll();
    List<T> findByDifficulty(Difficulty difficulty);
}
