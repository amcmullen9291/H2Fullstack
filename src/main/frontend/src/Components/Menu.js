import { useState, useEffect } from 'react';
import { connect } from 'react-redux';

function Menu() {

let  [ Cheeses, setCheeses ] = useState(null);
let [ Beverages , setBeverages ] = useState(null);

let [ Filter, setFilter ] = useState(null);

const DefaultCheeseList = Cheeses;
const DefaultBeverageList = Beverages;

const cheeseList = fetch('http://localhost:8080/cheeses/').then(resp => resp.json());
const beverageList = fetch('http://localhost:8080/beverages/').then(resp => resp.json());


useEffect(() => {
    Promise.all([beverageList, cheeseList]).then(data => { setBeverages(data[0]); setCheeses(data[1]) })
}, [])

if((Cheeses) && Object.keys(Cheeses).length > 1){
console.log("Default cheese list set");
}
if((Beverages) && Object.keys(Beverages).length > 1){
console.log("beverages list: ", Beverages);
let DefaultBeverageList = Beverages;
console.log("Default beverage list set");
}


async function SortDrinks(e, cheeseName){
    e.preventDefault();
    console.log("Cheese: ", cheeseName);
    const newList = Beverages.filter(drink => (drink.cheese1Name === cheeseName)||(drink.cheese2Name === cheeseName)||(drink.cheese3Name === cheeseName)||(drink.cheese4Name === cheeseName)||(drink.cheese5Name === cheeseName));
    console.log("New List:", newList);
    setFilter(newList);
}



function sortCheeses(e, beverageName){
    e.preventDefault();
    console.log("beverage: ", beverageName);
}


return (
        <>
        <div>
         {Cheeses && (
              <div><table id="cheeseList">
                <thead>
                </thead>
                <tbody>
                {Cheeses.map((cheese, id) => (
                  <div key={id}>
                    <tr>
                    <td><button className="name" onClick={(e) => {SortDrinks(e, cheese.cheeseName)}}>{cheese.cheeseName}</button></td>
                    </tr>
                  </div>
                ))}
                </tbody>
        </table>
              </div>
            )}
        </div>
        <div>
        {Filter && (
                      <div><table id="beverageList">
                        <thead>
                        </thead>
                        <tbody>
                        {Filter.map((beverage, id) => (
                          <div key={id}>
                            <tr>
                            <td><button className="name" onClick={(e) => {sortCheeses(e, beverage.beverageName)}}>{beverage.beverageName}</button></td>
                            </tr>
                          </div>
                        ))}
                        </tbody>
                </table>
                      </div>
                    )}
        </div>
        </>
    )
}

const mapStateToProps = (state) => {
    return {
      Cheeses: state.Cheeses,
      Beverages: state.Beverages
    }

  }

   const mapDispatchToProps = (dispatch) => {
     return{
       Cheeses: (cheeses) => { dispatch({type: 'SET_CHEESES', cheeses})},
       Beverages: (beverages) => { dispatch({type: 'SET_BEVERAGES', beverages})},
     }
   }



export default connect(mapStateToProps, mapDispatchToProps)(Menu);