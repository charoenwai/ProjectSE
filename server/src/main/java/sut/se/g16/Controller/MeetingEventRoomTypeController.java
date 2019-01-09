package sut.se.g16.Controller;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import sut.se.g16.Entity.MeetingEventRoomTypeEntity;
import sut.se.g16.Repository.MeetingEventRoomTypeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MeetingEventRoomTypeController{
    private MeetingEventRoomTypeRepository meetingEventRoomTypeRepository;
    public MeetingEventRoomTypeController(MeetingEventRoomTypeRepository meetingEventRoomTypeRepository){
        this.meetingEventRoomTypeRepository = meetingEventRoomTypeRepository;
    }

    @GetMapping("/meetingeventroomtype/{name}")
    public MeetingEventRoomTypeEntity addMeetingRoomType(@PathVariable String name) {
        MeetingEventRoomTypeEntity mert = new MeetingEventRoomTypeEntity();
        mert.setMeetingEventRoomTypeName(name);
        return meetingEventRoomTypeRepository.save(mert);
    }

    @GetMapping("/meetingeventroomtypes")
    public Collection<MeetingEventRoomTypeEntity> meetingRoomType() {
        return meetingEventRoomTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}