package com.portal.api_carros.service;

import com.portal.api_carros.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service()
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
