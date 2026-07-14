import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        Name="Rahul"
        School="ABC Public School"
        Total={480}
        goal={6}
      />
    </div>
  );
}

export default App;