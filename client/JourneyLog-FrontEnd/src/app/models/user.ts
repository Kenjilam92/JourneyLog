import { Journey } from "./journey";
import { Location } from "./location";

export class User {
    constructor(
        public userId?: number,
        public firstName? : string,
        public lastName? : string,
        public email? : string,
        public password? : string,
        public addressBook? : Location[],
        public journeyLog? : Journey[]
    ){}
}

