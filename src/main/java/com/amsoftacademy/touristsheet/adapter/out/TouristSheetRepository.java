package com.amsoftacademy.touristsheet.adapter.out;

import com.amsoftacademy.touristsheet.domain.TouristSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex Pumnea
 */
@Repository
public interface TouristSheetRepository extends CrudRepository<TouristSheet, Long> {
}
