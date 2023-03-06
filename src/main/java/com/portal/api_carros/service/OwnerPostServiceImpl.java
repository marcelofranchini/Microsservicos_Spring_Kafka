package com.portal.api_carros.service;

import com.portal.api_carros.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.api.client.CarPostStoreClient;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private CarPostStoreClient carPostStoreClient;
    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
