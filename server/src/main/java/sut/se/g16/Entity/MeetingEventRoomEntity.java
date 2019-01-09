package sut.se.g16.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data @Getter @Setter
@ToString @NoArgsConstructor
@Table(name = "MeetingEventRoom")
public class MeetingEventRoomEntity {
    @Id
    @SequenceGenerator(name="meetingeventroom_seq",sequenceName="meetingeventroom_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="meetingeventroom_seq")
    @Column(name="meetingEventRoomId",unique = true, nullable = false)
    private @NonNull Long meetingEventRoomId;
    private @NonNull int meetingEventRoomPrice;
    private @NonNull int meetingEventRoomNumber;
    private @NonNull String meetingEventRoomName;

    //Many To One with HotelEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HotelEntity.class)
    private HotelEntity newHotelEntity;

    //Many To One with MeetingEventRoomTypeEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MeetingEventRoomTypeEntity.class)
    private MeetingEventRoomTypeEntity newMeetingEventRoomTypeEntity;

    public HotelEntity getHotel() {
        return newHotelEntity;
    }

    public void setHotel(HotelEntity hotel) {
        this.newHotelEntity = hotel;
    }

    public MeetingEventRoomTypeEntity getMeetingEventRoomTypeEntity() {
        return newMeetingEventRoomTypeEntity;
    }

    public void setMeetingEventRoomTypeEntity(MeetingEventRoomTypeEntity meetingEventRoomTypeEntity) {
        this.newMeetingEventRoomTypeEntity = meetingEventRoomTypeEntity;
    }

    public Long getMeetingEventRoomId() {
        return meetingEventRoomId;
    }

    public void setMeetingEventRoomId(Long meetingEventRoomId) {
        this.meetingEventRoomId = meetingEventRoomId;
    }

    public int getMeetingEventRoomPrice() {
        return meetingEventRoomPrice;
    }

    public void setMeetingEventRoomPrice(int meetingEventRoomPrice) {
        this.meetingEventRoomPrice = meetingEventRoomPrice;
    }

    public int getMeetingEventRoomNumber() {
        return meetingEventRoomNumber;
    }

    public void setMeetingEventRoomNumber(int meetingEventRoomNumber) {
        this.meetingEventRoomNumber = meetingEventRoomNumber;
    }

    public String getMeetingEventRoomName() {
        return meetingEventRoomName;
    }

    public void setMeetingEventRoomName(String meetingEventRoomName) {
        this.meetingEventRoomName = meetingEventRoomName;
    }

    public HotelEntity getNewHotelEntity() {
        return newHotelEntity;
    }

    public void setNewHotelEntity(HotelEntity newHotelEntity) {
        this.newHotelEntity = newHotelEntity;
    }

    public MeetingEventRoomTypeEntity getNewMeetingEventRoomTypeEntity() {
        return newMeetingEventRoomTypeEntity;
    }

    public void setNewMeetingEventRoomTypeEntity(MeetingEventRoomTypeEntity newMeetingEventRoomTypeEntity) {
        this.newMeetingEventRoomTypeEntity = newMeetingEventRoomTypeEntity;
    }
}
