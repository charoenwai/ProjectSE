
package sut.se.g16.Entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table (name = "MemberHotel")
public class MemberHotelEntity {
    @Id
    @SequenceGenerator(name="memberHotel_seq",sequenceName="memberHotel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="memberHotel_seq")
    @Column(name="memberHotelId",unique = true, nullable = false)
    private @NonNull Long memberHotelId;
    private String  memberHotelName;
    private Long  memberHotelPassword;

    public void setMemberHotelName(String memberHotelName){
        this.memberHotelName = memberHotelName;
    }
    public String getMemberHotelName(){
        return this.memberHotelName = memberHotelName;
    }
    public void setMemberHotelPassword(Long memberHotelPassword){
        this.memberHotelPassword = memberHotelPassword;
    }
    public Long getMemberHotelPassword(){
        return this.memberHotelPassword = memberHotelPassword;
    }

    public Long getMemberHotelId() {
        return memberHotelId;
    }

    public void setMemberHotelId(Long memberHotelId) {
        this.memberHotelId = memberHotelId;
    }
}
