import { combineReducers } from 'redux';
import { BeverageReducer, SelectedBeverageReducer, filteredBeverageList } from './BeverageReducer';
import { CheeseReducer, SelectedCheeseReducer, filteredCheeseList } from './CheeseReducer';


const RootReducer = combineReducers({
    Beverages: BeverageReducer,
    SelectedBeverage: SelectedBeverageReducer,
    ShortBeverageList: filteredBeverageList,
    Cheeses: CheeseReducer,
    SelectedCheese: SelectedCheeseReducer,
    ShortCheeseList: filteredCheeseList
});

export default RootReducer;