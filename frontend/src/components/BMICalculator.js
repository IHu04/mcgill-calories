import React, { useState } from "react"
import { useNavigate } from 'react-router-dom';
import BMIInput from "./BMIInput.js"
import axios from "axios";

function BMI() {
    const [age, setAge] = useState('');
    const [goal, setGoal] = useState('Weight Gain');
    const [height, setHeight] = useState('');
    const [weight, setWeight] = useState('');
    const [bmi, setBmi] = useState('');
    const [result, setResult] = useState('');
    const navigate = useNavigate();

    const handleCalculate = async (e) => {
        e.preventDefault();
        
        const heightInMeters = height / 100;
        const calculatedBmi = (weight / (heightInMeters * heightInMeters)).toFixed(2);
        setBmi(calculatedBmi);

        let bmiResult = '';
        if (calculatedBmi < 18.5) {
            bmiResult = 'u skinny mf';
        } else if (calculatedBmi >= 18.5 && calculatedBmi < 24.9) {
            bmiResult = 'average tye shi';
        } else if (calculatedBmi >= 24.9 && calculatedBmi < 29.9) {
            bmiResult = 'u cuttin it close';
        } else {
            bmiResult = 'fat ahh mf maybe start diet ?';
        }
        setResult(bmiResult);

        const bmiData = {
            age,
            height,
            weight,
            bmi: calculatedBmi,
            result: bmiResult,
            goal: goal

        };

        try {
            const response = await axios.put('http://localhost:8080/users/3/profile', bmiData);
            console.log('Response from API:', response.data);
        } catch (error) {
            console.error('Error', error);
        }

        navigate('/main');
    };

    
  
    return(
        <>
            <div id="container">
                <section id="form">
                    <h1>Determine Your Goals</h1>
                    <form onSubmit={handleCalculate}>
                        <div id="inner-form">
                            <BMIInput myInput="Age (yrs)" value={age} onChange={(e) => setAge(e.target.value)}/>
                            <BMIInput myInput="Height (cm)" value={height} onChange={(e) => setHeight(e.target.value)} />
                            <BMIInput myInput="Weight (kg)" value={weight} onChange={(e) => setWeight(e.target.value)}/>
                            <label for="weight-goal">Select your weight goal:</label>
                            <select id="weight-goal" name="weight-goal" onChange={(e) => setGoal(e.target.value)}>
                                <option value="Weight Gain">Weight Gain</option>
                                <option value="Maintain Weight">Maintain Weight</option>
                                <option value="Lose Weight">Lose Weight</option>
                            </select>
                            <div id="gender">
                                <button id="Male">Male</button>
                                <button id="Female">Female</button>
                            </div>
                            <div id="calculate">
                                <button type="submit" id="calc">Set Profile</button>
                            </div>
                        </div>
                    </form>
                </section>
            </div>
        </>
    )
}

export default BMI