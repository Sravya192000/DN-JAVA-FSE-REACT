import trainers from "./TrainersMock";
import { Link } from "react-router-dom";

function TrainersList() {
    return (
        <div>
            <h2>Trainer List</h2>

            <ul>
                {trainers.map((trainer) => (
                    <li key={trainer.trainerId}>
                        <Link to={`/trainer/${trainer.trainerId}`}>
                            {trainer.name}
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TrainersList;