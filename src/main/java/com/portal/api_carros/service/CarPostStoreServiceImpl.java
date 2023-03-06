package com.portal.api_carros.service;

import com.portal.api_carros.dto.CarPostDTO;
import com.portal.api.client.CarPostStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired // injeção de dep
    private CarPostStoreClient carPostStoreClient;

    @Override // sobreescrevendo metodo, nao criando novo
    public List<CarPostDTO> getCarForSales() {
        return carPostStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO carPost, String id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);
    }

    @Override
    public void removeForCarForSale(String id) {

        carPostStoreClient.deleteCarForSaleClient(id);

    }
}
