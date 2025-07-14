package project.LaundryTracker.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BaseModelDTO {
    private LocalDateTime createDt;
    private LocalDateTime lastModDt;
    private UUID lastModBy;
    private UUID createBy;

    public LocalDateTime getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    public LocalDateTime getLastModDt() {
        return lastModDt;
    }

    public void setLastModDt(LocalDateTime lastModDt) {
        this.lastModDt = lastModDt;
    }

    public UUID getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(UUID lastModBy) {
        this.lastModBy = lastModBy;
    }

    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }
}