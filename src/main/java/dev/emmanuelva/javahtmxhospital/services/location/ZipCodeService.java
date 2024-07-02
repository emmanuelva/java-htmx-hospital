package dev.emmanuelva.javahtmxhospital.services.location;

import dev.emmanuelva.javahtmxhospital.models.ZipCodeDTO;

public interface ZipCodeService {
    ZipCodeDTO getZipCode(String zipCode);
    ZipCodeDTO saveNewZipCode(ZipCodeDTO zipCodeDTO);
}
