import {combineReducers} from 'redux';
import {
    ADD_ITEM,
    CHANGE_RESTAURANT,
    CHANGE_ROOM_SERVICES,
    CHANGE_TRANSPORT,
    CLEAR,
    CONDITIONS,
    DECREASE,
    END_SESSION,
    INCREASE,
    REMOVE_ITEM,
    SUBMIT,
    UPDATE,
    USER_ANSWER,
    INIT_DATA
} from './actions'

function login(state = [], action = {}) {
    switch (action.type) {

        case USER_ANSWER:
            return {
                ...state,
                dniAnswer: action.payload.dni,
                roomAnswer: action.payload.room
            };

        case SUBMIT:
            let newState = state;
            let isClient;
            console.log(action.payload.clients)
            action.payload.clients.map((client) => {
                isClient = (state.dniAnswer === client.dni) && (state.roomAnswer === client.room);
                if (isClient) {
                    newState = {
                        ...state,
                        isLogged: true,
                        id: client.id,
                        status: "success"
                    };
                }

                if (newState.attempts === 4) {
                    newState = {
                        ...state,
                        status: "warning"
                    };
                }
            });

            if (newState.status !== "success" && newState.status !== "warning") {
                newState = {
                    ...state,
                    status: "error",
                    attempts: state.attempts + 1
                };
            }
            return newState;

        case END_SESSION:

            return {
                ...state,
                status: "info",
                isLogged: false,
                dniAnswer: "",
                roomAnswer: ""
            };

        case CONDITIONS:
            return {
                ...state,
                conditionsAccepted: true
            };

        default:
            return state;
    }

}

/* Aqui se encuentra INIT_CLIENTS
*  Lo que hace es guardar en el estado el array de clientes
*  Ver ReduxProvider.jsx */

function clients(state = [], action = {}) {
    switch (action.type) {
        case UPDATE:
            if(action.payload.isPoints){
                let op1 = action.payload.changeOne;
                let op2 = state[action.payload.id-1].points;
                state[action.payload.id-1].points = parseFloat((op2 - op1).toFixed(2));
            }
            else if(action.payload.changeOne !== undefined){
                let op1 = action.payload.changeOne;
                let op2 = state[action.payload.id-1].bill;
                state[action.payload.id-1].bill = parseFloat((op1 + op2).toFixed(2));
            }
            else{
                state[action.payload.id-1] = action.payload.newData;
            }
            return state;

        case INIT_DATA:
            return JSON.parse(JSON.stringify(action.payload.initJson[0]));

        default:
            return state;
    }
}

function services(state = [], action = {}) {
    switch (action.type) {
        default:
            return state;
    }
}

function currentService(state = [], action = {}) {
    switch (action.type) {
        case CHANGE_RESTAURANT:
            return action.payload.answer
        case CHANGE_TRANSPORT:
            return action.payload.answer
        case CHANGE_ROOM_SERVICES:
            return action.payload.answer
        default:
            return state;
    }
}


function cartItems(state = [], action = {}) {

    switch (action.type) {
        case ADD_ITEM:
            if (!state.find(item => item.id === action.payload.product.id)) {
                state.push({
                    ...action.payload.product,
                    quantity: 1
                })
            }
            return state;

        case REMOVE_ITEM:
            return [...state.filter(item => item.id !== action.payload.product.id)];

        case INCREASE:
            state[state.findIndex(item => item.id === action.payload.product.id)].quantity++
            return state;

        case DECREASE:
            state[state.findIndex(item => item.id === action.payload.product.id)].quantity--
            return state;

        case CLEAR:
            return [];

        case UPDATE:
            return [];

        default:
            return state

    }
}

function products(state = [], action = {}) {
    switch (action.type) {

        case INIT_DATA:
            return JSON.parse(JSON.stringify(action.payload.initJson[1]));

        default:
            return state;
    }
}

function shows(state = [], action = {}) {
    switch (action.type) {
        default:
            return state;
    }
}


const GlobalState = (combineReducers({
    login,
    clients,
    services,
    currentService,
    cartItems,
    products,
    shows
}));

export default GlobalState;