import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 88 },
        { name: "Shubman Gill", score: 65 },
        { name: "KL Rahul", score: 72 },
        { name: "Hardik Pandya", score: 60 },
        { name: "Ravindra Jadeja", score: 80 },
        { name: "R Ashwin", score: 55 },
        { name: "Mohammed Shami", score: 78 },
        { name: "Jasprit Bumrah", score: 68 },
        { name: "Surya Kumar Yadav", score: 91 },
        { name: "Ishan Kishan", score: 50 }
    ];

    const below70 = players.filter(player => player.score < 70);

    return (
        <div>

            <h2>List of Players</h2>

            {players.map((player, index) => (
                <div key={index}>
                    {player.name} - {player.score}
                </div>
            ))}

            <br />

            <h2>Players with score below 70</h2>

            {below70.map((player, index) => (
                <div key={index}>
                    {player.name} - {player.score}
                </div>
            ))}

        </div>
    );
}

export default ListofPlayers;