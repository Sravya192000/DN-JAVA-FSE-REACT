import React from "react";

function GuestPage() {
    return (
        <div>
            <h2>Please sign up.</h2>

            <h3>Flight Details</h3>

            <table border="1">
                <thead>
                    <tr>
                        <th>Flight Name</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Price</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Indigo</td>
                        <td>Hyderabad</td>
                        <td>Delhi</td>
                        <td>₹4500</td>
                    </tr>

                    <tr>
                        <td>Air India</td>
                        <td>Chennai</td>
                        <td>Mumbai</td>
                        <td>₹5200</td>
                    </tr>

                    <tr>
                        <td>SpiceJet</td>
                        <td>Bangalore</td>
                        <td>Kolkata</td>
                        <td>₹6100</td>
                    </tr>
                </tbody>
            </table>

            <p>You must login to book tickets.</p>
        </div>
    );
}

export default GuestPage;