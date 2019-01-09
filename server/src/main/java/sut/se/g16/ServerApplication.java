package sut.se.g16;

import sut.se.g16.Entity.*;
import sut.se.g16.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	ApplicationRunner init(
		MemberHotelRepository memberHotelRepository, RoomStatusRepository roomStatusRepository,
		HotelRepository hotelRepository,
		FurnitureRepository furnitureRepository, RoomTypeRepository roomTypeRepository,
		RoomRepository roomRepository,TypeTimeRepository typeTimeRepository,MeetingEventRoomTypeRepository meetingEventRoomTypeRepository,
		RoomTypeFurnitureManyToManyRepository roomTypeFurnitureManyToManyRepository,
		FoodOrderRepository foodOrderRepository, ListRepository listRepository,
		FoodTypeRepository foodTypeRepository, TotalPriceFoodRepository totalPriceFoodRepository,
		ProvinceRepository provinceRepository,
		FoodPaymentRepository foodPaymentRepository,
		FoodOrderTotalPriceFoodManyToManyRepository foodOrderTotalPriceFoodManyToManyRepository) {

		return args -> {

			// Create RoomStatusEntity
			Stream.of("ว่าง", "จอง", "พัก","ใช้สถานที่").forEach(roomstatus -> {
				RoomStatusEntity rst = new RoomStatusEntity();
				rst.setRoomStatusName(roomstatus);
				roomStatusRepository.save(rst);
			});

			// Create Provinces
			Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี",
					"ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท", "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด",
					"ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช", "นครสวรรค์", "นนทบุรี",
					"นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี",
					"พระนครศรีอยุธยา", "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่",
					"พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน", "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง",
					"ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล",
					"สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย",
					"สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย", "หนองบัวลำภู", "อ่างทอง", "อุดรธานี",
					"อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(province -> {
						ProvinceEntity provinces = new ProvinceEntity();
						provinces.setProvinceName(province);
						provinceRepository.save(provinces);
			});

			// Create Furniture
			Stream.of("Table", "OfficeTable", "Microwave", "Sofa").forEach(furniture -> {
				FurnitureEntity fr = new FurnitureEntity();
				fr.setFurnitureName(furniture);
				furnitureRepository.save(fr);
			});

			// Create RoomType
			Stream.of("Standard", "Suite", "Deluxe", "Superior").forEach(roomType -> {
				if (roomType == "Standard") {
					RoomTypeEntity rt = new RoomTypeEntity();
					rt.setRoomTypeName(roomType);
					rt.setBedType("Single");
					rt.setNumberOfBed(1);
					rt.setMaxPeople(2);
					roomTypeRepository.save(rt);
				}
				if (roomType == "Suite") {
					RoomTypeEntity rt = new RoomTypeEntity();
					rt.setRoomTypeName(roomType);
					rt.setBedType("Twice");
					rt.setNumberOfBed(1);
					rt.setMaxPeople(3);
					roomTypeRepository.save(rt);
				}
				if (roomType == "Deluxe") {
					RoomTypeEntity rt = new RoomTypeEntity();
					rt.setRoomTypeName(roomType);
					rt.setBedType("Twice");
					rt.setNumberOfBed(1);
					rt.setMaxPeople(3);
					roomTypeRepository.save(rt);
				}
				if (roomType == "Superior") {
					RoomTypeEntity rt = new RoomTypeEntity();
					rt.setRoomTypeName(roomType);
					rt.setBedType("Twice");
					rt.setNumberOfBed(2);
					rt.setMaxPeople(6);
					roomTypeRepository.save(rt);
				}
			});

			// Create RoomTypeNameManyToMany
			Stream.of("Table", "OfficeTable", "Microwave", "Sofa").forEach(furniture -> {
				Stream.of("Standard", "Suite", "Deluxe", "Superior").forEach(roomType -> {
					FurnitureEntity fr = furnitureRepository.findByName(furniture);
					RoomTypeEntity rt = roomTypeRepository.findByName(roomType);
					RoomTypeFurnitureManyToManyEntity rtf = new RoomTypeFurnitureManyToManyEntity();
					rtf.setNewFurnitureRoomTypeManyEntity(fr);
					rtf.setNewRoomTypeFurnitureManyEntity(rt);
					roomTypeFurnitureManyToManyRepository.save(rtf);
				});
			});

			// Create Member
			MemberHotelEntity mem = new MemberHotelEntity();
			mem.setMemberHotelName("Aphirat");
			mem.setMemberHotelPassword(1234L);
			memberHotelRepository.save(mem);

			MemberHotelEntity mem2 = new MemberHotelEntity();
			mem2.setMemberHotelName("Pitchayut");
			mem2.setMemberHotelPassword(1234L);
			memberHotelRepository.save(mem2);

			// Create Hotel
			ProvinceEntity p = provinceRepository.findByName("นครราชสีมา");
			MemberHotelEntity m = memberHotelRepository.findByName("Aphirat");
			MemberHotelEntity m2 = memberHotelRepository.findByName("Pitchayut");
			HotelEntity hotels = new HotelEntity();
			hotels.setHotelNameEng("PhimaiIn");
			hotels.setAlleyLane("-");
			hotels.setBuilding("-");
			hotels.setDistrictArea("Phimai");
			hotels.setFax("044004422");
			hotels.setNewProvinceEntity(p);
			hotels.setHouseNo("403");
			hotels.setNewMemberHotelEntity(m);
			hotels.setPhone("0862505906");
			hotels.setVillage("เจริญรอด");
			hotels.setRoad("แจ้งวัฒนะ");
			hotels.setSubDistrictSubArea("ในเมือง");
			hotels.setVillageNo(20);
			hotels.setPostCode(30110);
			hotels.setMobilePhone("0903768901");
			hotelRepository.save(hotels);

			HotelEntity hotel = new HotelEntity();
			hotel.setHotelNameEng("Amathara");
			hotel.setAlleyLane("-");
			hotel.setBuilding("-");
			hotel.setDistrictArea("Phimai");
			hotel.setFax("044004422");
			hotel.setNewProvinceEntity(p);
			hotel.setHouseNo("403");
			hotel.setNewMemberHotelEntity(m2);
			hotel.setPhone("0862505906");
			hotel.setVillage("เจริญรอด");
			hotel.setRoad("แจ้งวัฒนะ");
			hotel.setSubDistrictSubArea("ในเมือง");
			hotel.setVillageNo(20);
			hotel.setPostCode(30110);
			hotel.setMobilePhone("0903768901");
			hotelRepository.save(hotel);

			// Create Typetime
			Stream.of("Morning", "Afternoon", "Evening").forEach(typeTime -> {
				TypeTimeEntity tt = new TypeTimeEntity();
				tt.setTypeTimeName(typeTime);
				typeTimeRepository.save(tt);

			});

			// Create MeetingEventRoomType
			Stream.of("ประชุม", "สัมมนา", "จัดงานเลี้ยง").forEach(meetingEventRoomType -> {
				MeetingEventRoomTypeEntity mert = new MeetingEventRoomTypeEntity();
				mert.setMeetingEventRoomTypeName(meetingEventRoomType);
				meetingEventRoomTypeRepository.save(mert);

			});

			// Create Status
			Stream.of("จ่ายแล้ว", "ยังไม่จ่าย").forEach(status -> {
				FoodPaymentEntity f = new FoodPaymentEntity();
				f.setFoodPaymentStatus(status);
				foodPaymentRepository.save(f);
			});

			// Create Food Type
			Stream.of("Drink", "Food", "Dessert").forEach(foodtype -> {
				FoodTypeEntity food = new FoodTypeEntity();
				food.setFoodTypeName(foodtype);
				foodTypeRepository.save(food);
				if (foodtype == "Drink") {
					ListEntity li = new ListEntity();
					li.setListName("Cocacola");
					li.setNewFoodTypeEntity(food);
					li.setPriceFood(20L);
					listRepository.save(li);
				} else if (foodtype == "Food") {
					ListEntity li = new ListEntity();
					li.setListName("Tomyumkung");
					li.setNewFoodTypeEntity(food);
					li.setPriceFood(150L);
					listRepository.save(li);
				} else if (foodtype == "Dessert") {
					ListEntity li = new ListEntity();
					li.setListName("Sugar");
					li.setNewFoodTypeEntity(food);
					li.setPriceFood(20L);
					listRepository.save(li);
				}
			});
		};
	}
}
