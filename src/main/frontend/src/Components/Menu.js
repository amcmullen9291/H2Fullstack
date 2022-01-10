import { useState, useEffect } from 'react';
import { connect } from 'react-redux';

function Menu() {

let  [ Cheeses, setCheeses ] = useState(null);
let [ Beverages , setBeverages ] = useState(null);
let [ defaultValue, setDefaultValue ] = useState(null);


let [ Filter, setFilter ] = useState(null);
let [ cheeseListings, setCheeseListings ]  = useState(Cheeses);

const cheeseList = fetch('http://localhost:8080/cheeses/').then(resp => resp.json());
const beverageList = fetch('http://localhost:8080/beverages/').then(resp => resp.json());


useEffect(() => {
    Promise.all([beverageList, cheeseList]).then(data => { setBeverages(data[0]); setCheeses(data[1]); setDefaultValue(data[1]) })
}, [])


async function SortDrinks(e, cheeseName){
    e.preventDefault();
    console.log("Cheese: ", cheeseName);
    const newList = Beverages.filter(drink => (drink.cheese1Name === cheeseName)||(drink.cheese2Name === cheeseName)||(drink.cheese3Name === cheeseName)||(drink.cheese4Name === cheeseName)||(drink.cheese5Name === cheeseName));
    console.log("New List:", newList);
    setFilter(newList);
}

function sortCheeses(e, beverageName){
    e.preventDefault();
    console.log("Beverage: ", beverageName);
    let newList = defaultValue.filter(cheese => (cheese.beverage1Name === beverageName)||(cheese.beverage2Name === beverageName)|| (cheese.beverage3Name === beverageName)|| (cheese.beverage4Name === beverageName)||(cheese.beverage5Name === beverageName)||(cheese.beverage6Name === beverageName)||(cheese.beverage7Name === beverageName));
    console.log("Starting dataSet: ", defaultValue);
    setCheeses(newList);

}

function resetTable(e){
    e.preventDefault();
    window.location.reload();
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

        <center><button onClick={(e) => {resetTable(e)}}>Reset List</button></center>
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