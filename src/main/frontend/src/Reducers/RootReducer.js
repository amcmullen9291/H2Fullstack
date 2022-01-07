import { combineReducers } from 'redux';
import { BeverageReducer, SelectedBeverageReducer, filteredBeverageList } from './BeverageReducer';
import { CheeseReducer, SelectedCheeseReducer, filteredCheeseList } from './CheeseReducer';


const RootReducer = combineReducers({
    Beverages: BeverageReducer,
    SelectedBeverage: SelectedBeverageReducer,
    ShortBeverageList: FilteredList
    Cheeses: CheeseReducer,
    SelectedCheese: SelectedCheeseReducer,
    ShortCheeseList: FilteredCheeseList
});

export default RootReducer;