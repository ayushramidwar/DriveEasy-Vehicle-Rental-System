import React, { useEffect, useState } from "react";
import axios from "axios";

function VehicleList() {
  const [vehicles, setVehicles] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8081/api/vehicles")
      .then((response) => {
        setVehicles(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      <h2>Available Vehicles</h2>

      {vehicles.map((vehicle) => (
        <div key={vehicle.id}>
          <h3>{vehicle.name}</h3>
          <p>{vehicle.type}</p>
          <p>₹{vehicle.pricePerDay}</p>
        </div>
      ))}
    </div>
  );
}

export default VehicleList;