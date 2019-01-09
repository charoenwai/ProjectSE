import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule,
MatSidenavModule, MatCheckboxModule, MatDialogModule } from '@angular/material';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatGridListModule} from '@angular/material/grid-list';
import { MatNativeDateModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {MatRadioModule } from '@angular/material/radio';
import { AddRoomComponent } from './add-room/add-room.component';
import { RoomStatusComponent } from './room-status/room-status.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { AddMeetingEventRoomComponent ,DialogOverviewExampleDialog} from './add-meeting-event-room/add-meeting-event-room.component';
import { MeetingRoomStatusComponent } from './meeting-room-status/meeting-room-status.component';
import { RoomService } from './shared/room.service';
import { from } from 'rxjs';
import { FoodOrderService } from './shared/food-order.service';
import { MeetingRoomService } from './shared/meeting-room.service';
const appRoutes: Routes = [
  {path:'' , component:FoodOrderComponent},
  {path: 'addroom/:inputUsername', component: AddRoomComponent},
  {path: 'roomstatus/:inputUserName', component: RoomStatusComponent},
  {path: 'addmeetingeventroom/:inputUserName', component: AddMeetingEventRoomComponent},
  {path: 'meetingroomstatus/:inputUserName', component: MeetingRoomStatusComponent},
  {path: 'foodorder',component: FoodOrderComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    AddRoomComponent,
    RoomStatusComponent,
    FoodOrderComponent,
    AddMeetingEventRoomComponent,
    MeetingRoomStatusComponent,
    DialogOverviewExampleDialog,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    MatTableModule,
    MatCheckboxModule,
    MatSidenavModule,
    MatIconModule,
    MatGridListModule,
    MatRadioModule,
    MatDialogModule,
    RouterModule.forRoot(appRoutes)
  ],
  entryComponents: [DialogOverviewExampleDialog],
  providers: [RoomService,FoodOrderService,MeetingRoomService],
  bootstrap: [AppComponent]
})
export class AppModule { }
