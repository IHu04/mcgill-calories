import React, { useState } from "react"
import BMIInput from "./BMIInput.js"
import axios from "axios";

function BMI() {
    const [age, setAge] = useState('');
    const [height, setHeight] = useState('');
    const [weight, setWeight] = useState('');
    const [bmi, setBmi] = useState('');
    const [result, setResult] = useState('');

    const handleCalculate = async (e) => {
        e.preventDefault();
        
        const heightInMeters = height / 100;
        const calculatedBmi = (weight / (heightInMeters * heightInMeters)).toFixed(2);
        setBmi(calculatedBmi);

        let bmiResult = '';
        if (calculatedBmi < 18.5) {
            bmiResult = 'Underweight';
        } else if (calculatedBmi >= 18.5 && calculatedBmi < 24.9) {
            bmiResult = 'Normal weight';
        } else if (calculatedBmi >= 25 && calculatedBmi < 29.9) {
            bmiResult = 'Overweight';
        } else {
            bmiResult = 'Obesity';
        }
        setResult(bmiResult);

        const bmiData = {
            age,
            height,
            weight,
            bmi: calculatedBmi,
            result: bmiResult
        };

        try {
            const response = await axios.put('http://localhost:8080/users/3/profile', bmiData);
            console.log('Response from API:', response.data);
        } catch (error) {
            console.error('Error', error);
        }
    };
    return(
        <>
            <div id="container">
                <section id="form">
                    <h1>BMI Calculator</h1>
                    <form onSubmit={handleCalculate}>
                        <div id="inner-form">
                            <BMIInput myInput="Age (yrs)" value={age} onChange={(e) => setAge(e.target.value)}/>
                            <BMIInput myInput="Height (cm)" value={height} onChange={(e) => setHeight(e.target.value)} />
                            <BMIInput myInput="Weight (kg)" value={weight} onChange={(e) => setWeight(e.target.value)}/>
                            <div id="gender">
                                <button id="Male">Male</button>
                                <button id="Female">Female</button>
                            </div>
                            <div id="calculate">
                                <button type="submit" id="calc">Calculate BMI</button>
                            </div>

                            <h5>{`BMI: ${bmi}`}</h5>
                            <h5>{`Result: ${result}`}</h5>
                        </div>
                    </form>
                </section>
            </div>
        </>
    )
}

export default BMI