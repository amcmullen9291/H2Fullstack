import { ActionTypes } from '../Constants/Action.Type';

const initialState = {
    Beverages: [],
};

export const beverageReducers = (state=initialState, {Beverages, payload}) => {
    switch (type) {
        case ActionTypes.SET_BEVERAGES:
            return { ...state, Beverages: payload};
        default:
            return state
    }
};

export const SelectedBeverageReducer = (state={}, {selection, payload}) => {
    switch (type) {
        case ActionTypes.SELECTED_BEVERAGE:
            return { ...state, selection: payload};
        default:
            return state;
    }
}

export const filteredBeverageList = (state={}, {filteredList, payload}) => {
    switch (type) {
        case ActionTypes.FILTERED_BEVERAGE_LIST:
            return { ...state, filteredList: payload};
        default:
            return state;
    }
}