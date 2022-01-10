import { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

function Menu() {

let  [ Cheeses, setCheeses ] = useState(null);
let [ Beverages , setBeverages ] = useState(null);

const cheeseList = fetch('http://localhost:8080/cheeses/').then(resp => resp.json());
const beverageList = fetch('http://localhost:8080/beverages/').then(resp => resp.json());


useEffect(() => {
    Promise.all([beverageList, cheeseList]).then(data => { setBeverages(data[0]); setCheeses(data[1]) })
}, [])

if((Cheeses) && Object.keys(Cheeses).length > 1){

console.log("cheese list: ", Cheeses);
}
if((Beverages) && Object.keys(Beverages).length > 1){
console.log("beverages list: ", Beverages);
}

function sortDrinks(e, cheeseName){
    e.preventDefault();
    console.log("Cheese: ", cheeseName);
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
                    <td><button className="name" onClick={(e) => {sortDrinks(e, cheese.cheeseName)}}>{cheese.cheeseName}</button></td>
                    </tr>
                  </div>
                ))}
                </tbody>
        </table>
              </div>
            )}
        </div>
        <div>
        {Beverages && (
                      <div><table id="beverageList">
                        <thead>
                        </thead>
                        <tbody>
                        {Beverages.map((beverage, id) => (
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