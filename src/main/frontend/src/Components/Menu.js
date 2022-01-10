import { useState, useEffect } from 'react';
import { connect } from 'react-redux';

function Menu() {

let  [ Cheeses, setCheeses ] = useState(null);
let [ Beverages , setBeverages ] = useState(null);

const cheeseList = fetch('http://localhost:8080/beverages/').then(resp => resp.json());
const beverageList = fetch('http://localhost:8080/beverages/').then(resp => resp.json());

console.log(cheeseList);

if((Cheeses) && Object.keys(Cheeses).length > 1){
console.log("cheese list: ", Cheeses);
}
if((Beverages) && Object.keys(Beverages).length > 1){
console.log("beverages list: ", Beverages);
}


return (
        <>
        <div>
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