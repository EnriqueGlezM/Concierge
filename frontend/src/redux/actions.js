
export const USER_ANSWER = 'USER_ANSWER';
export const SUBMIT = 'SUBMIT';
export const END_SESSION = 'END_SESSION';
export const CHANGE_RESTAURANT = 'CHANGE_RESTAURANT';
export const CHANGE_TRANSPORT = 'CHANGE_TRANSPORT';
export const CHANGE_ROOM_SERVICES = 'CHANGE_ROOM_SEVICES';
export const UPDATE = 'UPDATE';
export const CONDITIONS = 'CONDITIONS';
export const INIT_DATA = 'INIT_DATA';


/* CONST shopping cart */

export const INCREASE = 'INCREASE';
export const DECREASE = 'DECREASE';
export const ADD_ITEM = 'ADD_ITEM';
export const REMOVE_ITEM = 'REMOVE_ITEM';
export const CLEAR = 'CLEAR';

/* Actions del login */

export function userAnswer(dni, room) {
    return { type: USER_ANSWER, payload: { dni, room } };
}

export function submit(clients) {
    return { type: SUBMIT, payload: { clients }  };
}

/* Actions de profile */

export function conditions(){
    return {type: CONDITIONS};
}

export function endSession(){
    return { type: END_SESSION };
}

/* Actions de Services */

export function changeRestaurant(answer){
    return {type: CHANGE_RESTAURANT, payload: {answer}}
}

export function changeRoomServices(answer){
    return {type: CHANGE_ROOM_SERVICES, payload: {answer}}
}

export function changeTransport(answer){
    return {type: CHANGE_TRANSPORT, payload: {answer}}
}

export function updateProfile(id, newData, changeOne, isPoints){
    return {type: UPDATE, payload: {id, newData, changeOne, isPoints}};
}

/* Actions del shopping cart */

export function increase(product){
    return {type: INCREASE, payload: { product }};
}

export function decrease(product){
    return {type: DECREASE, payload: { product }};
}

export function addProduct(product){
    return {type: ADD_ITEM, payload: { product }};
}

export function removeProduct(product){
    return {type: REMOVE_ITEM, payload: { product }};
}

export function clearCart(){
    return {type: CLEAR, payload: {}};
}

/* Action de la inicialización de los clients
*  Recibe como parametro el array de los clientes
*  Ver reducers.js */

export function initData(initJson) {
    return { type: INIT_DATA, payload: { initJson } };
}



