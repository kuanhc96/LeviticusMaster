package leviticus.master.entity;

import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
public abstract class AbstractBaseEntity {
    private Timestamp lchgTime;

    public AbstractBaseEntity() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.lchgTime = Timestamp.valueOf(now);
    }

    public AbstractBaseEntity(Timestamp lchgTime) {
        this.lchgTime = lchgTime;
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

