package sut.se.g16.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "TypeTime")
public class TypeTimeEntity {
    @Id
    @SequenceGenerator(name="meetingeventroomtypetime_seq",sequenceName="meetingeventroomtypetime_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="meetingeventroomtypetime_seq")
    @Column(name="meetingEventRoomTypeTimeManyToManyId",unique = true, nullable = false)
    private @NonNull Long typeTimeId;
    private @NonNull String typeTimeName;

    public Long getTypeTimeId() {
        return typeTimeId;
    }

    public void setTypeTimeId(Long typeTimeId) {
        this.typeTimeId = typeTimeId;
    }

    public String getTypeTimeName() {
        return typeTimeName;
    }

    public void setTypeTimeName(String typeTimeName) {
        this.typeTimeName = typeTimeName;
    }
}
