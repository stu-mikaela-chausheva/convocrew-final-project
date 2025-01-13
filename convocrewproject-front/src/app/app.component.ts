import {HttpClientModule, HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
// import { ChannelService } from './services/channel.service';
import { ChannelType } from './models/channel.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  public channelCollection: ChannelType[] = [];

  public httpClient = inject(HttpClient);

  public ngOnInit(){

    this.httpClient.get('http://localhost:8328/channels').subscribe((result:any)=>{
      this.channelCollection = result.data;
    })

  }

  // Добавям си сервиза за работа с  channel обекти
  // private channelService = inject(ChannelService)

  // // ПРи зареждане на компонента
  // public ngOnInit() {
  //   this.fetchAllChannels();
  // }

  // public fetchAllChannels() {

  //   this.channelService.getAllChannels().subscribe((result: any) => {
  //     this.channelCollection = result.data;
  //   })
  // }

  // }

  // public title = 'convocrewproject-front';


}
