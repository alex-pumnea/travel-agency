package com.amsoftacademy.touristsheet.application;

import com.amsoftacademy.touristsheet.adapter.in.rest.dto.TouristSheetRequest;
import com.amsoftacademy.touristsheet.adapter.in.rest.mapper.TouristSheetMapper;
import com.amsoftacademy.touristsheet.adapter.out.TouristSheetRepository;
import com.amsoftacademy.touristsheet.domain.TouristSheet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * @author Alex Pumnea
 */
@Service
@Transactional
public class TouristSheetServiceImpl implements TouristSheetService<TouristSheetRequest, TouristSheet> {
    private final TouristSheetRepository repository;
    private final TouristSheetMapper mapper;

    public TouristSheetServiceImpl(TouristSheetRepository repository, TouristSheetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Query("from TouristSheet ")
    @Override
    public Iterable<TouristSheet> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<TouristSheet> getById(Long id) {
        return Optional.ofNullable(this.repository.findById(id)
                .orElseThrow(TouristSheetNotFound::new));
    }

    @Override
    public TouristSheet save(@Valid TouristSheetRequest request) {
        return this.repository.save(mapper.toEntity(request));
    }

    @Override
    public TouristSheet update(Long id, @Valid TouristSheetRequest request) {
        return this.repository.findById(id)
                .map(existingTouristSheet -> {
                    mapper.partialUpdate(request, existingTouristSheet);
                    return repository.save(existingTouristSheet);
                })
                .orElseThrow(TouristSheetNotFound::new);
    }

    @Override
    public void removeById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public boolean removeAll() {
        repository.deleteAll();
        return StreamSupport.stream(repository.findAll().spliterator(), false).findAny().isEmpty();
    }
}