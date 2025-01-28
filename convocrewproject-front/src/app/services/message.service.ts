import { MessageType } from './../models/message.model';
import { Injectable, inject} from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: "root"
})


export class MessageService {
  private httpClient = inject(HttpClient);
  private baseUrl = 'http://localhost:8328/messages';

  // Get all messages for a given channel, including user and channel details
  public getAllMessagesByChannel($channel_id: number) {
    return this.httpClient.get<MessageType[]>(`${this.baseUrl}/${$channel_id}`);
  }
}
