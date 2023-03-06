package com.portal.api_carros.service;

import com.portal.api_carros.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CarPostStoreService {
    List<CarPostDTO> getCarForSales();

    void changeCarForSale(CarPostDTO carPost, String id);

    void removeForCarForSale(String id);
}
