import React, { useEffect, useState } from 'react';
import { getTasks, deleteTask } from '../services/TaskService';
import { Link } from 'react-router-dom';

export default function TaskList() {
  const [tasks, setTasks] = useState([]);
  const [deleteSuccess, setDeleteSuccess] = useState(false);

  useEffect(() => {
    loadTasks();
  }, []);

  const loadTasks = async () => {
    const result = await getTasks();
    setTasks(result.data);
  };

  const handleDelete = async (id) => {
    await deleteTask(id);
    setDeleteSuccess(true);
    setTimeout(() => setDeleteSuccess(false), 3000);
    loadTasks();
  };

  return (
    <div className="container py-5" style={{ backgroundColor: '#f8f9fa', minHeight: '100vh' }}>
      <h2 className="text-center mb-4 fw-bold">Task List</h2>

      {deleteSuccess && (
        <div className="alert alert-success text-center fw-bold">
          🗑️ Task deleted successfully!
        </div>
      )}

      <div className="card shadow rounded-4 p-4">
        <table className="table table-hover">
          <thead className="table-primary">
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Priority</th>
              <th>Status</th>
              <th>Due Date</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr key={task.id}>
                <td>{task.title}</td>
                <td>{task.description}</td>
                <td>{task.priority}</td>
                <td>{task.status}</td>
                <td>{task.dueDate}</td>
                <td>
                  <Link to={`/edit/${task.id}`} className="btn btn-sm btn-info me-2">
                    ✏️ Edit
                  </Link>
                  <button
                    onClick={() => handleDelete(task.id)}
                    className="btn btn-sm btn-danger"
                  >
                    🗑️ Delete
                  </button>
                </td>
              </tr>
            ))}
            {tasks.length === 0 && (
              <tr>
                <td colSpan="6" className="text-center text-muted py-4">
                  No tasks found.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      <div className="text-center mt-4">
        <Link to="/add" className="btn btn-success btn-lg">
          ➕ Add New Task
        </Link>
        </div>
        <div className="text-center mt-4">
        <Link to="/home" className="btn btn-secondary btn-lg">
          🏠 Back to Home
        </Link>
      </div>
    </div>
  );
}
