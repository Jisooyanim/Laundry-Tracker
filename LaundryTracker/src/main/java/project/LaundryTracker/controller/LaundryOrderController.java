package project.LaundryTracker.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;

import project.LaundryTracker.model.LaundryOrder;
import project.LaundryTracker.service.LaundryOrderService;
import project.LaundryTracker.dto.LaundryOrderRequestDTO;
import project.LaundryTracker.dto.LaundryOrderResponseDTO;
import project.LaundryTracker.enums.OrderStatus;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/laundryOrder")
public class LaundryOrderController {
    private final LaundryOrderService laundryOrderService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<LaundryOrderResponseDTO> getAllLaundryOrders() {
        return laundryOrderService.getAllLaundryOrders()
                .stream()
                .map(order -> modelMapper.map(order, LaundryOrderResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{orderId}")
    public LaundryOrderResponseDTO getLaundryOrderById(@PathVariable Long orderId) {
        LaundryOrder order = laundryOrderService.getLaundryOrderById(orderId);
        return modelMapper.map(order , LaundryOrderResponseDTO.class);
    }

    @GetMapping("/track/{trackingNumber}")
    public LaundryOrderResponseDTO getLaundryOrderByTrackingNumber(@PathVariable String trackingNumber) {
        LaundryOrder order = laundryOrderService.getLaundryOrderByTrackingNumber(trackingNumber);
        return modelMapper.map(order , LaundryOrderResponseDTO.class);
    }

    @GetMapping("/customer/{customerId}")
    public List<LaundryOrderResponseDTO> getLaundryOrderByCustomer(@PathVariable Long customerId) {
        return laundryOrderService.getLaundryOrderByCustomer(customerId)
                .stream()
                .map(order -> modelMapper.map(order, LaundryOrderResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/status/{status}")
    public List<LaundryOrderResponseDTO> getLaundryOrderByStatus(@PathVariable OrderStatus status) {
        return laundryOrderService.getLaundryOrderByStatus(status)
                .stream()
                .map(order -> modelMapper.map(order, LaundryOrderResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/time-range")
    public List<LaundryOrderResponseDTO> getOrdersByTimeRange(@RequestParam String start, @RequestParam String end) {
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);

        List<LaundryOrder> orders = laundryOrderService.getLaundryOrderByTime(startDate, endDate);
        return orders.stream()
                    .map(order -> modelMapper.map(order, LaundryOrderResponseDTO.class))
                    .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<LaundryOrderResponseDTO> addLaundryOrder(@Valid @RequestBody LaundryOrderRequestDTO laundryOrderRequestDTO) {
        LaundryOrder newOrder = laundryOrderService.createLaundryOrder(laundryOrderRequestDTO);
        LaundryOrderResponseDTO responseDTO = modelMapper.map(newOrder, LaundryOrderResponseDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateLaundryOrder(@PathVariable Long id, @Valid @RequestBody LaundryOrderRequestDTO requestDTO) {
        Optional<LaundryOrder> updatedOrder = laundryOrderService.updateLaundryOrder(requestDTO);

        if (updatedOrder.isPresent()) {
            LaundryOrderResponseDTO responseDTO = modelMapper.map(updatedOrder.get(), LaundryOrderResponseDTO.class);
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laundry Order not found.");
        }
    }

    @PatchMapping("{id}/status")
    public ResponseEntity<?> updateLaundryOrderStatus(@PathVariable Long id, @Valid @RequestBody LaundryOrderRequestDTO laundryOrderRequestDTO) {
        return laundryOrderService.updateStatus(laundryOrderRequestDTO)
            .<ResponseEntity<?>>map(order -> ResponseEntity.ok(modelMapper.map(order, LaundryOrderResponseDTO.class)))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laundry Order not found."));
    }

    @PatchMapping("{id}/pickup")
    public ResponseEntity<?> updateLaundryOrderStatusToPickedUp(@PathVariable Long id, @Valid @RequestBody LaundryOrderRequestDTO laundryOrderRequestDTO) {
        return laundryOrderService.markAsPickedup(laundryOrderRequestDTO)
            .<ResponseEntity<?>>map(order -> ResponseEntity.ok(modelMapper.map(order, LaundryOrderResponseDTO.class)))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laundry Order not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLaundryOrder(@Valid @PathVariable Long id) {
        boolean deleted = laundryOrderService.deleteLaundryOrder(id);
            if (deleted) {
                return ResponseEntity.ok("Order: '" + id + "' deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order: '" + id + "' not found.");
        }
    }
}
