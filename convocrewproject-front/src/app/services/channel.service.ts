import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ChannelType } from '../models/channel.model';

@Injectable({
  providedIn: 'root', // This ensures the service is provided at the root level
})
export class ChannelService {
  private apiUrl = 'http://localhost:8328/channels'; // Replace with your backend API URL

  constructor(private http: HttpClient) {}

  getAllChannels(): Observable<ChannelType[]> {
    return this.http.get<ChannelType[]>(this.apiUrl);
  }
}
