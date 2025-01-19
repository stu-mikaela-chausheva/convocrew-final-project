import { MessageService } from './services/message.service';
import {HttpClientModule, HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
// import { ChannelService } from './services/channel.service';
import { ChannelType } from './models/channel.model';
import { MessageType } from './models/message.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {


  // Добавям си сервиза за работа с customer обекти
  private messageService = inject(MessageService)

  public channelCollection: ChannelType[] = [];
  public messageCollection: MessageType[] = [];

  public httpClient = inject(HttpClient);

  public ngOnInit(){

    // this.fetchAllChannels();
    this.httpClient.get('http://localhost:8328/channels').subscribe((result:any)=>{
      this.channelCollection = result.data;
    })

  }
  // public fetchAllChannels() {

  //   // this.httpClient.get('http://localhost:8328/channels').subscribe((result:any)=>{
  //   //   this.channelCollection = result.data;
  //   })
  // }


  // public processOnSeeMessages($selectedElement: ChannelType) {
  //   this.messageService.getAllMessagesByChannel($selectedElement.id!).subscribe((result: any) => {
  //     this.fetchAllChannels();
  //   });
  // }

}
