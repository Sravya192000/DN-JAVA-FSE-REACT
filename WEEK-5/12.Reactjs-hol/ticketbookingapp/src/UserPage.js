import React from "react";

function UserPage() {
    return (
        <div>
            <h2>Welcome Back</h2>

            <h3>Book Your Ticket</h3>

            <table border="1">
                <thead>
                    <tr>
                        <th>Flight Name</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Indigo</td>
                        <td>Hyderabad</td>
                        <td>Delhi</td>
                        <td>₹4500</td>
                        <td>
                            <button>Book</button>
                        </td>
                    </tr>

                    <tr>
                        <td>Air India</td>
                        <td>Chennai</td>
                        <td>Mumbai</td>
                        <td>₹5200</td>
                        <td>
                            <button>Book</button>
                        </td>
                    </tr>

                    <tr>
                        <td>SpiceJet</td>
                        <td>Bangalore</td>
                        <td>Kolkata</td>
                        <td>₹6100</td>
                        <td>
                            <button onClick={() => alert("Ticket Booked Successfully!")}>
                                Book
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default UserPage;