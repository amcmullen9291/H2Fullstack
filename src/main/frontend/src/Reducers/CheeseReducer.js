import { ActionTypes } from '../Constants/Action.Type';

const initialState = {
    Cheese: [],
};

export const CheeseReducer = (state=initialState, {Cheeses, payload}) => {
    switch (type) {
        case ActionTypes.SET_CHEESES:
            return { ...state, Cheeses: payload};
        default:
            return state
    }
};

export const SelectedBeverageReducer = (state={}, {selection, payload}) => {
    switch (type) {
        case ActionTypes.SELECTED_CHEESE:
            return { ...state, selection: payload};
        default:
            return state;
    }
}

export const filteredCheeseList = (state={}, {filteredList, payload}) => {
    switch (type) {
        case ActionTypes.FILTERED_CHEESE_LIST:
            return { ...state, filteredList: payload};
        default:
            return state;
    }
}