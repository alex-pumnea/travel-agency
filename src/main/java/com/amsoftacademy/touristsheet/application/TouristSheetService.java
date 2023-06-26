package com.amsoftacademy.touristsheet.application;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Alex Pumnea
 */
@Service
public interface TouristSheetService<T, R> {
    Iterable<R> getAll();

    Optional<R> getById(Long id);

    R save(T request);

    R update(Long id, T request);

    void removeById(Long id);

    boolean removeAll();

}
