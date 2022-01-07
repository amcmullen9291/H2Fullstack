import { ActionTypes } from '../Constants/Action.Type';

export const setCheeses = (List) => {
    return {
        type: ActionTypes.SET_CHEESES,
        payload: List
    }
}

export const selectedCheese = (cheese) => {
    return {
        type: ActionTypes.SELECTED_CHEESES,
        payload: Cheese
    }
}

export const filteredCheeseList = (filteredList) => {
    return {
        type: ActionTypes.FILTERED_CHEESE_LIST,
        payload: filteredList
    }
}