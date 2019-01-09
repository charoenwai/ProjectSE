import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { AddRoomComponent } from '../add-room/add-room.component'
import { Subject, from } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RoomService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }
  getRoomType():Observable<any>{
    return this.http.get(this.API + '/roomtypes');
  }
  getRoomStatus():Observable<any>{
    return this.http.get(this.API + '/roomstatusesforroom');
  }
  getRoom():Observable<AddRoomComponent[]>{
    return this.http.get<AddRoomComponent[]>(this.API + '/rooms');
  }
}
