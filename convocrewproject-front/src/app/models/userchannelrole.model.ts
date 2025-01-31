import { ChannelType } from "./channel.model";
import { UserType } from "./user.model";

export type UserChannelRoleType = {
  id?: number;
  user: UserType;
  channel:ChannelType;
  role:string;
}
