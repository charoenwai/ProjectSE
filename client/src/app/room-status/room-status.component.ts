import { Component, OnInit } from '@angular/core';
import { RoomService } from '../shared/room.service';
import { HttpClient } from '@angular/common/http';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
import { ActivatedRoute, Router } from '@angular/router';
import { AddRoomComponent } from '../add-room/add-room.component';
export interface AddRoomComponent {
  roomId: number;
  roomNumber: String;
  roomPrice: number;
  newHotelEntity: {
    hotelNameEng: String;
  }
  newRoomTypeEntity: {
    roomTypeName: String;
  }
  newRoomStatusEntity: {
    roomStatusName: String;
  }
}
@Component({
  selector: 'app-room-status',
  templateUrl: './room-status.component.html',
  styleUrls: ['./room-status.component.css']
})
export class RoomStatusComponent implements OnInit {
  room: Array<any>;
  roomType: Array<any>;
  roomStatus: Array<any>;
  select: any = {
    roomNumberInput: '',
    roomPriceInput: '',
    roomStatusInput: '',
    roomTypeInput: '',
    hotelInput: '',
    selectedRoomId: '',
    selectedRoomStatus: '',
    selectedRoomNumber: '',
    selectedRoomPrice: '',
    selectedRoomType: '',
    selectedHotel: '',
    inputMemberUserName: ''
  }


  displayedColumns: string[] = ['position', 'room_type', 'room_no', 'room_price', 'room_status', 'hotel'];
  dataSource = new RoomDataSource(this.roomService);

  constructor(private roomService: RoomService, private httpClient: HttpClient, private route: ActivatedRoute, private router: Router) {
    this.select.inputMemberUserName = this.route.snapshot.paramMap.get('inputUserName');
  }

  ngOnInit() {
    this.refresh();
    this.roomService.getRoomType().subscribe(data => {
      this.roomType = data;
      console.log(data.roomTypeName);
      console.log(this.roomType);
    });
    this.roomService.getRoomStatus().subscribe(data => {
      this.roomStatus = data;
      console.log(this.roomStatus);
    });

  }
  refresh() {
    this.roomService.getRoom().subscribe((res) => {
      this.room = res;
      this.dataSource = new RoomDataSource(this.roomService);
    });
  }
  selectRow(row){
    this.select.selectedRoomId = row.roomId;
    this.select.selectedRoomNumber = row.roomNumber;
    this.select.selectedRoomStatus = row.newRoomStatusEntity.roomStatusName;
    this.select.selectedRoomPrice = row.roomPrice;
    this.select.selectedHotel = row.newHotelEntity.hotelNameEng;
    this.select.selectedRoomType = row.newRoomTypeEntity.roomTypeName;
    console.log(this.select.selectedRoomId);
    console.log(this.select.selectedRoomNumber);
    console.log(this.select.selectedRoomStatus);
    console.log(this.select.selectedRoomPrice);
    console.log(this.select.selectedHotel);
    console.log(this.select.selectedRoomType);
  }
  addRoom(){
    this.router.navigate(['/addroom',this.select.inputMemberUserName]);
  }
  edit(){
      this.select.hotelInput = this.select.selectedHotel;
    if(!this.select.roomNumberInput)
      this.select.roomNumberInput = this.select.selectedRoomNumber;
    if(!this.select.roomPriceInput)
      this.select.roomPriceInput = this.select.selectedRoomPrice;
    if(!this.select.roomStatusInput)
      this.select.roomStatusInput = this.select.selectedRoomStatus;
    if(!this.select.roomTypeInput)
      this.select.roomTypeInput = this.select.selectedRoomType; 
    console.log(this.select.roomNumberInput);
    console.log(this.select.roomStatusInput);
    console.log(this.select.roomPriceInput);
    console.log(this.select.hotelInput);
    console.log(this.select.roomTypeInput);
    this.httpClient.get('http://localhost:8080/updateroomstatus/'+ this.select.selectedRoomId + '/' + this.select.hotelInput + '/' + this.select.roomTypeInput + '/' +this.select.roomStatusInput + '/' + this.select.roomNumberInput + '/' + this.select.roomPriceInput, this.select)
    .subscribe(
      data => {
        if(data){
          this.refresh();
          console.log('Success');
          alert('Update Room Success');
        }
        else{
          this.refresh();
          alert('Cannot update room status, room number ' + this.select.roomNumberInput + ' maybe already exit!');
        }
          
      },
      error =>{
      console.log('Uncomplete',error);
    }
    )
  }
  addMeetingEventRoom () {
    this.router.navigate(['/addmeetingeventroom',this.select.inputMemberUserName]);
  }
  UpdateMeetingRoomStatus(){
    this.router.navigate(['/meetingroomstatus',this.select.inputMemberUserName]);
  }
  
}
export class RoomDataSource extends DataSource<any> {
  constructor(private roomService: RoomService) {
    super();
  }
  connect(): Observable<AddRoomComponent[]> {
    return this.roomService.getRoom();
  }
  disconnect() { }
}
