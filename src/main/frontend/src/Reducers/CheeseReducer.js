import { ActionTypes } from '../Constants/Action.Type';

const initialState = {
    Cheese: [],
};

export const CheeseReducer = (state=initialState, {type, payload}) => {
    switch (type) {
        case ActionTypes.SET_CHEESES:
            return { ...state, Cheeses: payload};
        default:
            return state
    }
};

export const SelectedCheeseReducer = (state={}, {type, payload}) => {
    switch (type) {
        case ActionTypes.SELECTED_CHEESE:
            return { ...state, selection: payload};
        default:
            return state;
    }
}

export const filteredCheeseList = (state={}, {type, payload}) => {
    switch (type) {
        case ActionTypes.FILTERED_CHEESE_LIST:
            return { ...state, filteredList: payload};
        default:
            return state;
    }
}