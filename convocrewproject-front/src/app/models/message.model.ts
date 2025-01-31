import { ChannelType } from './channel.model';
import { UserType } from './user.model';


export type MessageType = {
  id?: number;
  textMessage: string;
  channel: { id: number }; // Nested channel object with only the ID
  user: { id: number }; // Nested user object with only the ID
}
