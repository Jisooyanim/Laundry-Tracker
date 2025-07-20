package project.LaundryTracker.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.LaundryTracker.model.LaundryItem;
import project.LaundryTracker.model.LaundryOrder;
import project.LaundryTracker.repository.LaundryOrderRepository;
import project.LaundryTracker.dto.LaundryOrderRequestDTO;
import project.LaundryTracker.enums.OrderStatus;

@Slf4j
@Service
@RequiredArgsConstructor
public class LaundryOrderService {

    private final LaundryOrderRepository laundryOrderRepository;
    private final ModelMapper modelMapper;

    public List<LaundryOrder> getAllLaundryOrders() {
        return laundryOrderRepository.findAll();
    }

    public LaundryOrder getLaundryOrderById(Long orderId) {
        return laundryOrderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Laundry Order not found."));
    }

    public LaundryOrder getLaundryOrderByTrackingNumber(String trackingNumber) {
        return laundryOrderRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new NoSuchElementException("Laundry Order not found."));
    }

    public List<LaundryOrder> getLaundryOrderByCustomer(Long customerId) {
        List<LaundryOrder> orders = laundryOrderRepository.findByCustomerId(customerId);
        if (orders.isEmpty()) {
            throw new NoSuchElementException(String.format("No orders found for customer %d", customerId));
        }
        return orders;
    }

    public List<LaundryOrder> getLaundryOrderByStatus(OrderStatus status) {
        List<LaundryOrder> orders = laundryOrderRepository.findByStatus(status);
        if (orders.isEmpty()) {
            throw new NoSuchElementException(String.format("No orders found for status - %s", status));
        }
        return orders;
    }

    public List<LaundryOrder> getLaundryOrderByTime(LocalDateTime start, LocalDateTime end) {
        List<LaundryOrder> orders = laundryOrderRepository.findByDropOffDateBetween(start, end);
        if (orders.isEmpty()) {
            throw new NoSuchElementException(String.format(
                    "No orders found for dates %s and %s",
                    formatDate(start),
                    formatDate(end)
            ));
        }
        return orders;
    }

    private String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private BigDecimal computeTotalPrice(List<LaundryItem> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }

        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transactional
    public LaundryOrder createLaundryOrder(LaundryOrderRequestDTO requestDTO) {
        LaundryOrder order = modelMapper.map(requestDTO, LaundryOrder.class);

        BigDecimal totalPrice = computeTotalPrice(order.getItems());
        order.setTotalPrice(totalPrice);

        log.info("Creating laundry order with tracking number {}", order.getTrackingNumber());
        return laundryOrderRepository.save(order);
    }

    @Transactional
    public boolean updateLaundryOrder(LaundryOrderRequestDTO requestDTO) {
        LaundryOrder laundryOrder = laundryOrderRepository.findById(requestDTO.getOrderId())
                .orElseThrow(() -> new NoSuchElementException("Laundry Order not found."));

        modelMapper.map(requestDTO, laundryOrder);

        BigDecimal totalPrice = computeTotalPrice(laundryOrder.getItems());
        laundryOrder.setTotalPrice(totalPrice);

        laundryOrderRepository.save(laundryOrder);
        log.info("Updated laundry order with ID {}", laundryOrder.getId());
        return true;
    }

    @Transactional
    public boolean markAsPickedup(LaundryOrderRequestDTO requestDTO) {
        LaundryOrder laundryOrder = laundryOrderRepository.findById(requestDTO.getOrderId())
                .orElseThrow(() -> new NoSuchElementException("Laundry Order not found."));

        laundryOrder.setStatus(OrderStatus.PICKED_UP);
        laundryOrder.setPickedUpAt(LocalDateTime.now());

        laundryOrderRepository.save(laundryOrder);
        log.info("Order {} marked as PICKED_UP", laundryOrder.getId());
        return true;
    }

    @Transactional
    public boolean updateStatus(LaundryOrderRequestDTO requestDTO) {
        LaundryOrder laundryOrder = laundryOrderRepository.findById(requestDTO.getOrderId())
                .orElseThrow(() -> new NoSuchElementException("Laundry Order not found."));

        laundryOrder.setStatus(requestDTO.getStatus());
        laundryOrderRepository.save(laundryOrder);

        log.info("Updated order status for order {} to {}", laundryOrder.getId(), requestDTO.getStatus());
        return true;
    }

    @Transactional
    public boolean deleteLaundryOrder(Long orderId) {
        return laundryOrderRepository.findById(orderId)
                .map(order -> {
                    laundryOrderRepository.delete(order);
                    log.info("Deleted laundry order with ID {}", orderId);
                    return true;
                })
                .orElse(false);
    }
}
