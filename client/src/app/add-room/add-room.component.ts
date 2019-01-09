import { Component, OnInit } from '@angular/core';
import { RoomService } from '../shared/room.service';
import { HttpClient } from '@angular/common/http';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
import { ActivatedRoute, Router } from '@angular/router';

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
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css'],
  
})
export class AddRoomComponent implements OnInit {
  room: Array<any>;
  roomType: Array<any>;
  roomStatus: Array<any>;
  select: any = {
    roomTypeSelect: '',
    roomNumberInput: '',
    roomPriceInput: '',
    roomStatusSelect: '',
    memberUserName: ''
  }


  displayedColumns: string[] = ['position', 'room_type', 'room_no', 'room_price', 'room_status', 'hotel'];
  dataSource = new RoomDataSource(this.roomService);
  constructor(private roomService: RoomService, private httpClient: HttpClient, private route: ActivatedRoute, private router: Router) {
    if(!this.route.snapshot.paramMap.get('inputUserName'))
      this.select.memberUserName = "Aphirat";
    else
      this.select.memberUserName = this.route.snapshot.paramMap.get('inputUserName');
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
  add() {
    if (this.select.roomStatusSelect === '' || this.select.roomTypeSelect === '' || this.select.roomNumberSelect === '' || this.select.roomPriceInput === '') {
      alert('Please Enter all Data');
    }
    else {
      this.httpClient.get('http://localhost:8080/room/' + this.select.roomTypeSelect + '/' + this.select.roomStatusSelect + '/' + this.select.roomNumberInput + '/' + this.select.roomPriceInput + '/' + this.select.memberUserName, this.select)
        .subscribe(
          data => {
            console.log(data);
            if (data) {
              console.log('PUT Request is successful', data);
              alert('Add Room Success');
              this.refresh();
            }
            else
              alert('Room number ' + this.select.inputRoomNumber + ' in hotel ' + this.select.hotelNameSelect + ' have alrady exist')
          },
          error => {
            console.log('Error', error);
          }
        )
    }
    this.refresh();
  }
  UpdateRoomStatus(){
    this.router.navigate(['/roomstatus',this.select.memberUserName]);
  }
  addMeetingEventRoom () {
    this.router.navigate(['/addmeetingeventroom',this.select.memberUserName]);
  }
  UpdateMeetingRoomStatus(){
    this.router.navigate(['/meetingroomstatus',this.select.memberUserName]);
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