package pl.coderslab.charity.baseModel;

import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    private String uuid = UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseEntity)){
            return false;
        }
        BaseEntity that = (BaseEntity) obj;
        return Objects.equals(that.uuid, that.uuid);
    }
}
