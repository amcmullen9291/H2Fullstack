import { useState, useEffect } from 'react';
import { connect } from 'react-redux';



function Menu() {

let  [ Cheeses, setCheeses ] = useState(null);
let [ Beverages , setBeverages ] = useState(null);
let [ defaultValue, setDefaultValue ] = useState(null);
let [ Filter, setFilter ] = useState(null);
let [running, setRunning ] = useState(false);

const cheeseList = fetch('http://localhost:8080/cheeses/').then(resp => resp.json());
const beverageList = fetch('http://localhost:8080/beverages/').then(resp => resp.json());


useEffect(() => {
    Promise.all([beverageList, cheeseList]).then(data => { setBeverages(data[0]); setCheeses(data[1]); setDefaultValue(data[1]) })
}, [])

function ShowCheeseDetails(e){
e.preventDefault();
document.getElementById("cheeseName").style.pointerEvents = "none";
if(running === true){
console.log("function already running.")
console.log(running);
setTimeout(() => {
             setRunning(false);
         }, 3000);
return;
}
else{
setRunning(true);
console.log("starting function");
document.getElementsByClassName("name").disabled = "true";
 setTimeout(() => {
            document.getElementById("beverageList").style.display = "none";
            document.getElementById("cheeseInfo").style.display = "block";
             console.log('5 seconds have elapsed');
         }, 5000);
         }
 };

function returnBeveragesTable(e){
e.preventDefault();
    document.getElementById("cheeseName").style.pointerEvents = "none";
    document.getElementById("beverageList").style.display = "block";
    document.getElementById("cheeseInfo").style.display = "none";
    setTimeout(() => {
             setRunning(false);
             document.getElementsByClassName("name").disabled = "false";
         }, 3000);
    console.log("count reset");

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
    let newList = defaultValue.filter(cheese => (cheese.beverage1Name === beverageName)||(cheese.beverage2Name === beverageName)|| (cheese.beverage3Name === beverageName)|| (cheese.beverage4Name === beverageName)||(cheese.beverage5Name === beverageName)||(cheese.beverage6Name === beverageName)||(cheese.beverage7Name === beverageName));
    setCheeses(newList);
}

function resetTable(e){
    e.preventDefault();
    window.location.reload();
}


return (
        <>
        <div id="outerBorder">
        <center><span id="heading">𝕭eer & 𝕮heese</span></center>
        <div id="mainBorder">
        <center>
        <div>
         {Cheeses && (
              <div><table id="cheeseList">
                <thead>
                </thead>
                <tbody>
                {Cheeses.map((cheese, id) => (
                  <div key={id}>
                    <tr>
                    <td><button id="cheeseName" className="name" onMouseEnter={(e) => {ShowCheeseDetails(e)}}  onMouseOut={(e) => {returnBeveragesTable(e)}} onClick={(e) => {SortDrinks(e, cheese.cheeseName)}}>{cheese.cheeseName}</button></td>
                    </tr>
                  </div>
                ))}
                </tbody>
        </table>
              </div>
            )}
        </div>
        <div>
        <div id="cheeseInfo">
        <span>Cheese Info</span>
        </div>
        {Filter && (
                      <div><table id="beverageList">
                        <thead>
                        </thead>
                        <tbody>
                        {Filter.map((beverage, id) => (
                          <div key={id}>
                            <tr>
                            <td><button className="drinkName" onClick={(e) => {sortCheeses(e, beverage.beverageName)}}>{beverage.beverageName}</button></td>
                            </tr>
                          </div>
                        ))}
                        </tbody>
                </table>
                      </div>
                    )}
        </div>
        </center>
        <br/>
        <center><button onClick={(e) => {resetTable(e)}}>Reset List</button></center>
        </div>
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

export default connect(mapStateToProps, null)(Menu);