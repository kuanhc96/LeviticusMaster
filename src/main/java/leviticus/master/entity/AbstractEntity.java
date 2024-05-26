package leviticus.master.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
public abstract class IEntity {
    @Id
    private Long id;
    private Timestamp lchgTime;
    public Long getId() {
        return id;
    }

    public Timestamp getLchgTime() {
        return lchgTime;
    }

    public void setLchgTime(Timestamp lchgTime) {
        this.lchgTime = lchgTime;
    }

    public void setLchgTime() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.lchgTime = Timestamp.valueOf(now);

    }
}
