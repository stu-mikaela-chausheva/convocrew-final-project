import { Component, inject, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ChannelService } from './services/channel.service';
import { ChannelType } from './models/channel.model'; // Channel type model
import { MessageService } from './services/message.service'; // If you want to fetch messages

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

//   public channelCollection: ChannelType[] = [];
//   public selectedChannel: ChannelType | null = null;

//   private httpClient = inject(HttpClient);  // Inject HttpClient


//   constructor(
//     private channelService: ChannelService,  // Injecting ChannelService
//     private messageService: MessageService,  // You can also use it to fetch messages
//   ) {}


//   ngOnInit() {
//     this.fetchAllChannels();  // Fetch channels on component initialization
//   }

//   // Fetching all channels from the backend
//   fetchAllChannels() {
//     this.channelService.getAllChannels().subscribe((result: any) => {
//       this.channelCollection = result.data;  // Save response data to channelCollection
//     }, error => {
//       console.error('Error fetching channels', error);
//     });
//   }

//   // When a channel is selected, show its messages
//   viewChannelMessages(channel: ChannelType) {
//     this.selectedChannel = channel;  // Update selected channel
//     // Optionally, use the MessageService to fetch messages for the selected channel
//     this.messageService.getAllMessagesByChannel(channel.id!).subscribe((result: any) => {
//       console.log(result);  // You can handle the message data here
//     });
//   }
}
