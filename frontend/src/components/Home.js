import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/bmi">BMI Calculator</Link>
        </li>
        <li>
          <Link to="/signup">signup</Link>
        </li>
        <li>
          <Link to="/main">main</Link>
        </li>
      </ul>
    </nav>
  );
}

export default Home;
