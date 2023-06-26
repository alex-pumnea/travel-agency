package com.amsoftacademy.touristsheet.application;

/**
 * @author Alex Pumnea
 */
public class TouristSheetNotFound extends RuntimeException {
    public TouristSheetNotFound() {
        super("Tourist Sheet not found.");
    }
}
