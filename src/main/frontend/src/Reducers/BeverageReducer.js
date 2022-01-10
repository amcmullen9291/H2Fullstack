import { ActionTypes } from '../Constants/Action.Type';

const initialState = {
    Beverages: [],
};

export const BeverageReducer = (state=initialState, {type, payload}) => {
    switch (type) {
        case ActionTypes.SET_BEVERAGES:
            return { ...state, Beverages: payload};
        default:
            return state
    }
};

export const SelectedBeverageReducer = (state={}, {type, payload}) => {
    switch (type) {
        case ActionTypes.SELECTED_BEVERAGE:
            return { ...state, selection: payload};
        default:
            return state;
    }
}

export const filteredBeverageList = (state={}, {type, payload}) => {
    switch (type) {
        case ActionTypes.FILTERED_BEVERAGE_LIST:
            return { ...state, filteredList: payload};
        default:
            return state;
    }
}