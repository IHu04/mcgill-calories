import React, { useState } from 'react';
import axios from 'axios';

const SignupForm = () => {
    const [name, setName] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const [message, setMessage] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError(null);
        setMessage('');

        console.log('Submitting form with:', { name, password });

        try {
            const response = await axios.post(
                'http://localhost:8080/users',
                {
                    name,
                    password
                },
                {
                    headers: {
                        'Content-Type': 'application/json',
                        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36',
                        'Connection': 'keep-alive',
                        'Accept': 'application/json',
                        'Accept-Encoding': 'gzip, deflate, br'
                    }
                }
            );
            console.log('Response:', response.data);
            setMessage('User created successfully');
        } catch (error) {
            console.error('There was an error!', error);
            if (error.response) {
                console.error('Error response data:', error.response.data);
                console.error('Error response status:', error.response.status);
                console.error('Error response headers:', error.response.headers);
                setError(error.response.data);
            } else if (error.request) {
                console.error('Error request:', error.request);
                setError('No response received from the server');
            } else {
                console.error('Error message:', error.message);
                setError('An unexpected error occurred');
            }
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Name:</label>
                <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
            </div>
            <div>
                <label>Password:</label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            </div>
            {error && <div style={{ color: 'red' }}>{error}</div>}
            {message && <div style={{ color: 'green' }}>{message}</div>}
            <button type="submit">Sign Up</button>
        </form>
    );
};

export default SignupForm;
