import React from "react";


function SyntheticEvent(){


    function clickHandler(event){

        alert("I was clicked");

        console.log(event);

    }


    return(

        <div>

            <h2>Synthetic Event</h2>


            <button onClick={clickHandler}>
                OnPress
            </button>


        </div>

    )

}


export default SyntheticEvent;