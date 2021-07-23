import { Journey } from "./journey";

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

