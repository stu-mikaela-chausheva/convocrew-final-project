import { UserType } from "./user.model";

export type DirectMessageType = {
  id?: number;
  sender_id?: UserType;
  receiver_id?:UserType;
  content:string;
  created_at?:Date;
}
