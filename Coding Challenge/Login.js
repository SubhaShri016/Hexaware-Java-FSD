// src/components/Login.js

import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      await axios.get('http://localhost:8080/api/tasks', {
        auth: { username, password }
      });
      localStorage.setItem('auth', JSON.stringify({ username, password }));
      navigate('/Home'); // Go to Task List page
    } catch (err) {
      setError('Invalid credentials. Try admin/password');
    }
  };

  return (
    <div className="container py-5">
      <h2>🔐 Login</h2>
      {error && <div className="alert alert-danger">{error}</div>}
      <form onSubmit={handleLogin}>
        <div className="mb-3">
          <label>Username</label>
          <input value={username} onChange={e => setUsername(e.target.value)} className="form-control" required />
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} className="form-control" required />
        </div>
        <button className="btn btn-primary">Login</button>
      </form>
    </div>
  );
}
