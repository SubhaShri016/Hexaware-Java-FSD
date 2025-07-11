import React from 'react';
import { Link } from 'react-router-dom';

export default function Home() {
    
  return (
    <div className="container py-5 text-center" style={{ minHeight: '100vh', backgroundColor: '#f8f9fa' }}>
      <div className="card shadow p-5 rounded-4">
        <h1 className="mb-4 fw-bold">🎯 Welcome to Task Manager</h1>
        <p className="lead mb-4">
          Organize your tasks efficiently. Add, edit, and track tasks with ease.
        </p>
        <Link to="/tasks" className="btn btn-primary btn-lg">
          🚀 Go to Task List
        </Link>
      </div>
      <div className="container py-5 text-center">
      <Link
        to="/"
        className="btn btn-danger btn-lg rounded-4 shadow px-4 py-2"
      >
        🔒 Logout
      </Link>
    </div>
    </div>
  );
}
