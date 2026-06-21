import React, { useEffect, useState } from "react";
import API from "../services/api";

function Vehicle() {

    const [vehicles, setVehicles] = useState([]);

    useEffect(() => {
        API.get("/vehicles")
            .then((response) => {
                setVehicles(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    return (
        <div style={{ padding: "20px" }}>
            <h2>Available Vehicles</h2>

            {vehicles.map((vehicle) => (
                <div key={vehicle.id}>
                    <h3>{vehicle.name}</h3>
                    <p>Type: {vehicle.type}</p>
                    <p>Price: ₹{vehicle.pricePerDay}</p>
                    <p>Status: {vehicle.status}</p>
                    <hr />
                </div>
            ))}
        </div>
    );
}

export default Vehicle;