package com.sdacademy.javalub15.controllers;

import com.sdacademy.javalub15.controllers.dtos.OrderDTO;
import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;
import com.sdacademy.javalub15.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private OrderService orderService;// TODO: 23.11.2019 wstrzyknięcie zależności


    public ResponseEntity<OrderDTO>  addOrder(@PathVariable Long id, @RequestBody OrderRequestDTO orderRequestDTO) throws Exception {
        // TODO: 23.11.2019 dodanie zamówienia na podawie userId oraz request dto
        OrderDTO orderDTO = orderService.addOrder(id, orderRequestDTO);
        return ResponseEntity.ok(orderDTO);
    }

    public ResponseEntity deleteOrder(){
        // TODO: 23.11.2019 obsługa usunięcia zamówianie w przypadku powodzenie Httpstatus.ACCEPTED
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public List<OrderDTO> findAllOrders() {
        return null; // TODO: 23.11.2019 wyświetlanie wszystkich orderów
    }

    public ResponseEntity<OrderDTO>  findOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(new OrderDTO()); // TODO: 23.11.2019 usuniecie zamówienia po id
    }

    public ResponseEntity<OrderDTO>  changeOrderProducts(@PathVariable Long id, @RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(new OrderDTO()); // TODO: 23.11.2019 update zamówienia po id
    }

    public ResponseEntity<OrderDTO> addOneProductToOrder(@RequestBody Long productId) {
        return ResponseEntity.ok(new OrderDTO()); // TODO: 23.11.2019 dodanie produktu po id + walidacja czy dany produkt istnieje
    }

    @GetMapping
    public ResponseEntity<BigDecimal> showOrderValue() {
        // TODO: 23.11.2019 zwraca sumę zamówienia
        return ResponseEntity.ok(new BigDecimal(600)); //przykład
    }



}
