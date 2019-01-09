package sut.se.g16.Controller;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import sut.se.g16.Entity.MeetingEventRoomTypeTimeManyToManyEntity;
import sut.se.g16.Repository.MeetingEventRoomTypeTimeManyToManyRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MeetingEventRoomTypeTimeManyToManyController{
    private MeetingEventRoomTypeTimeManyToManyRepository meetingEventRoomTypeTimeManyToManyRepository;
    public MeetingEventRoomTypeTimeManyToManyController(MeetingEventRoomTypeTimeManyToManyRepository meetingEventRoomTypeTimeManyToManyRepository){
        this.meetingEventRoomTypeTimeManyToManyRepository = meetingEventRoomTypeTimeManyToManyRepository;
    }

    @GetMapping("/meetingeventroomstatus/{id}")
    public Collection<MeetingEventRoomTypeTimeManyToManyEntity> getmeetingStatus(@PathVariable Long id) {
        return meetingEventRoomTypeTimeManyToManyRepository.findRoomStatusNameByMeetingRoomId(id);
    }

    @GetMapping("/meetingeventmtmidandrstid/{id}")
    public Collection<MeetingEventRoomTypeTimeManyToManyEntity> getMtMIdmeetingStatus(@PathVariable Long id) {
        return meetingEventRoomTypeTimeManyToManyRepository.findAllByMeetingRoomId(id);
    }

    @GetMapping("/meetingeventroomtypetimes")
    public Collection<MeetingEventRoomTypeTimeManyToManyEntity> meetingtypetimemany() {
        return meetingEventRoomTypeTimeManyToManyRepository.findAll().stream().collect(Collectors.toList());
    }

    // @GetMapping("/m")
    // public MeetingEventRoomTypeTimeManyToManyEntity getmeetingtypetimemany() {
    //     return meetingEventRoomTypeTimeManyToManyRepository.findTest();
    // }
}