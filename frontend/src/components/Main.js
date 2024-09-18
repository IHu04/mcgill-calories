import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Main = ({ userID }) => {
  const [user, setUser] = useState(null);
  const [error, setError] = useState(null);
  const [foods, setFoods] = useState(null);
  const [cafeteria, setCafeteria] = useState('RVC');

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/users/${userID}`);
        setUser(response.data);
      } catch (err) {
        setError('Error fetching user data');
      }
    };

    fetchUserData();
  }, [userID]);

  if (error) {
    return <div>{error}</div>;
  }

  if (!user) {
    return <div>Loading...</div>;
  }
  const handleCalculate = async (e) => {
    e.preventDefault();

    const result = user.profile.result;
    const goal = user.profile.goal;
    const height = user.profile.height;
    const weight = user.profile.weight;
    const bmi = user.profile.bmi;
    const age = user.profile.age;

    let bmr = 10 * weight + 6.25 * height - 5 * bmi + 5
    let calorieGoal = bmr * 1.55

    if (goal === "Weight Gain"){
        calorieGoal += 500  
    }
    else if (goal === "Lose Weight"){
        calorieGoal -= 500
    }

    calorieGoal = calorieGoal * 0.4;
    const cGoal = {
        calories: Math.round(calorieGoal)
    };

    axios.post('http://localhost:8080/foods/by-calories', cGoal)
        .then(response => {
            setFoods(response.data);
        })
        .catch(error => {
            console.error('Error:', error);
        });



  }
  return (
    <div>
        
      <div id='statsBox'>
        <div id='statsLabel'>   
            <h1>{user.name}'s Profile</h1>
        </div>
        <div id='statsUser'>
            <p>Height: {user.profile.height} cm</p>
            <p>Weight: {user.profile.weight} kg</p>
            <h2>BMI: {user.profile.bmi}</h2>
            <h2>Result: {user.profile.result}</h2>
            <p>Goal: {user.profile.goal}</p>
        </div>
        
        <form onSubmit={handleCalculate}>
            <p class="select">Select a cafeteria:</p>
            <select id="cafeteria" onChange={(e) => setCafeteria(e.target.value)}>
                <option value="RVC">RVC</option>
                <option value="C4">C4</option>
            </select>

            <button type='submit'>Generate Food Options</button>
        </form>
        {foods && foods.length > 0 ? (
          <div>
            <h2>Foods:</h2>
            <ul>
              {foods.map((food, index) => (
                <li key={index}>{food.name} - {food.calories} calories</li>
              ))}
            </ul>
          </div>
        ) : (
          <p>No foods available</p>
        )}
      </div>
    </div>
  );
};

export default Main;
