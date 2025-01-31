import { MessageService } from './services/message.service';
import { Component, inject, OnInit } from '@angular/core';
import { ChannelService } from './services/channel.service';
import { ChannelType } from './models/channel.model';
import { MessageType } from './models/message.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [FormsModule], // Add FormsModule to the imports array
})
export class AppComponent implements OnInit {
  public channelCollection: ChannelType[] = [];
  public messageCollection : MessageType[] = [];
  public selectedChannel: ChannelType | null = null;
  public newMessageText: string = '';

  private channelService = inject(ChannelService);
  private messageService = inject(MessageService);
selectedChannelMessages: any;

  public ngOnInit() {
    this.fetchAllChannels();
  }

  public fetchAllChannels() {
    this.channelService.getAllChannels().subscribe((result: any) => {
      this.channelCollection = result.data;
    });
  }

  // Handle channel click event
  public onChannelClick(channel: ChannelType) {
    this.selectedChannel = channel; // Set the selected channel
    this.fetchMessagesForChannel(channel.id); // Fetch messages for the selected channel
  }

  // Fetch messages for the selected channel
  private fetchMessagesForChannel(channelId: number) {
    this.messageService.getAllMessagesByChannel(channelId).subscribe({
      next: (response: any) => {
        console.log('API Response:', response); // Log the full API response
        this.selectedChannelMessages = response.data; // Extract the messages from the response
      },
      error: (err) => {
        console.error('Failed to fetch messages:', err); // Log errors
        this.selectedChannelMessages = []; // Clear messages on error
      },
    });
  }
  public sendMessage() {
    if (!this.selectedChannel || !this.newMessageText.trim()) {
      return; // Do nothing if no channel is selected or the message is empty
    }

    const newMessage: MessageType = {
      textMessage: this.newMessageText,
      channel: { id: this.selectedChannel.id }, // Only include the ID
      user: { id: 1 }, // Hardcoded user ID for testing
    };

    this.messageService.createNewMessage(newMessage).subscribe({
      next: (response: any) => {
        console.log('Message sent:', response); // Log the response
        this.newMessageText = ''; // Clear the input field
        this.fetchMessagesForChannel(this.selectedChannel!.id); // Refresh the messages
      },
      error: (err) => {
        console.error('Failed to send message:', err); // Log errors
      },
    });
  }

}
