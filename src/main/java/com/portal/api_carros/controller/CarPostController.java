package com.portal.api_carros.controller;

import com.portal.api_carros.dto.CarPostDTO;
import com.portal.api_carros.message.KafkaProducerMessage;
import com.portal.api_carros.service.CarPostStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    private final Logger LOG = LoggerFactory.getLogger(CarPostController.class);

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO){

        LOG.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post information: {}", carPostDTO);

        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }


    @GetMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostStoreService.changeCarForSale(carPostDTO,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id){
        carPostStoreService.removeForCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
