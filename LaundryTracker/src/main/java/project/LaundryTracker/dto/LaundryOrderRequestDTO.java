package project.LaundryTracker.dto;

import lombok.*;
import project.LaundryTracker.enums.OrderStatus;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaundryOrderRequestDTO {

    @NotBlank(message = "Tracking number is required")
    private String trackingNumber;

    @NotNull(message = "Order status is required")
    private OrderStatus status;

    @NotNull(message = "Drop-off date is required")
    private LocalDateTime dropOffDate;

    @NotNull(message = "Expected pickup date is required")
    private LocalDate expectedPickupDate;

    private LocalDateTime pickedUpAt;

    @NotNull(message = "Total price is required")
    @DecimalMin(value = "0.00", message = "Total price must be positive")
    private BigDecimal totalPrice;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    private List<LaundryItemRequestDTO> items;
}
