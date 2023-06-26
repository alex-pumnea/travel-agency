package com.amsoftacademy.touristsheet.adapter.in.rest.controller;

import com.amsoftacademy.touristsheet.adapter.in.rest.dto.TouristSheetRequest;
import com.amsoftacademy.touristsheet.application.TouristSheetService;
import com.amsoftacademy.touristsheet.domain.TouristSheet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Alex Pumnea
 */
@RestController
@RequestMapping("/api/v1/tourist-sheets")
public class TouristSheetController {
    private final TouristSheetService<TouristSheetRequest, TouristSheet> service;

    public TouristSheetController(TouristSheetService<TouristSheetRequest, TouristSheet> service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<Iterable<TouristSheet>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<TouristSheet>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    //    TODO: Solve the issue of saving duplicates
    @PostMapping
    ResponseEntity<TouristSheet> save(@Valid @RequestBody TouristSheetRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PutMapping("/{id}")
    ResponseEntity<TouristSheet> updateById(@PathVariable Long id, @Valid @RequestBody TouristSheetRequest request) {
        return ResponseEntity.accepted().body(service.update(id, request));
    }

    @DeleteMapping()
    ResponseEntity<TouristSheet> deleteAll() {
        boolean allDeleted = service.removeAll();

        return allDeleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<TouristSheet> deleteById(@PathVariable Long id) {
        service.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
