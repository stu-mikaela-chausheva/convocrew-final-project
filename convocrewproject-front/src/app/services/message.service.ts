import { MessageType } from './../models/message.model';
import { Injectable, inject} from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: "root"
})


export class MessageService{
  private httpClient  = inject(HttpClient);
  private baseUrl     = 'http://localhost:8328/message';

  public getAllMessagesByChannel($channel_id : number) {
    return this.httpClient.get(`${this.baseUrl}/${$channel_id}`);
  }
}
