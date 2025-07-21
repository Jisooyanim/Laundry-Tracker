package project.LaundryTracker.dto;

import lombok.*;
import project.LaundryTracker.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaundryOrderResponseDTO extends BaseModelDTO {
    private Long orderId;
    private String trackingNumber;
    private OrderStatus status;
    private LocalDateTime dropOffDate;
    private LocalDate expectedPickupDate;
    private LocalDateTime pickedUpAt;
    private BigDecimal totalPrice;

    private CustomerDTO customer;
    private List<LaundryItemResponseDTO> items;
}
