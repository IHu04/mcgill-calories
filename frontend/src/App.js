import './App.css';
import BMI from './components/BMICalculator.js'
import Home from './components/Home.js'
import Signup from './components/Signup.js';
import Main from './components/Main.js';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home />} />
          <Route path="/bmi" element={<BMI />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/main" element={<Main userID = {3}/>} />
        </Routes>
      </BrowserRouter>
    </div>
   
    
  );
}

export default App;
