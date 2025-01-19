import { ChannelType } from './channel.model';
import { UserType } from './user.model';


export type MessageType = {
  id?: number;
  text_message: string;
  channel_id:number;
  user_id:number;
  channel?: ChannelType;
  user?:UserType;
}
