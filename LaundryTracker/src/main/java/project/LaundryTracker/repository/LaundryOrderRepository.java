package project.LaundryTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import project.LaundryTracker.model.LaundryOrder;
import project.LaundryTracker.enums.OrderStatus;

@Repository
public interface LaundryOrderRepository extends JpaRepository<LaundryOrder, Long>{

    Optional<LaundryOrder> findByTrackingNumber(String trackingNumber);

    List<LaundryOrder> findByCustomerId(Long customerId);

    List<LaundryOrder> findByStatus(OrderStatus status);

    List<LaundryOrder> findByDropOffDateBetween(LocalDateTime start, LocalDateTime end);
}
