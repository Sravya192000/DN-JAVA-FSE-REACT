import React from "react";
import officeImage from "./office.jpg";

function App() {

  const offices = [
    {
      name: "DBS",
      rent: 50000,
      address: "Chennai"
    },
    {
      name: "Regus",
      rent: 75000,
      address: "Bangalore"
    },
    {
      name: "WeWork",
      rent: 65000,
      address: "Hyderabad"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office Space"
        width="400"
        height="250"
      />

      <hr />

      {
        offices.map((office, index) => (

          <div key={index}>

            <h2>Name : {office.name}</h2>

            <h3
              style={{
                color: office.rent < 60000 ? "red" : "green"
              }}
            >
              Rent : Rs. {office.rent}
            </h3>

            <h3>Address : {office.address}</h3>

            <hr />

          </div>

        ))
      }

    </div>
  );
}

export default App;