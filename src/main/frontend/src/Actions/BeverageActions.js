import { ActionTypes } from '../Constants/Action.Type';

export const setBeverages = (List) => {
    return {
        type: ActionTypes.SET_BEVERAGES,
        payload: List
    }
}

export const selectedBeverage = (beverage) => {
    return {
        type: ActionTypes.SELECTED_BEVERAGE,
        payload: beverage
    }
}

export const filteredBeverageList = (filteredList) => {
    return {
        type: ActionTypes.FILTERED_BEVERAGE_LIST,
        payload: filteredList
    }
}