import React, { useEffect, useState } from 'react';
import { getTaskById, updateTask } from '../services/TaskService';
import { useParams, useNavigate } from 'react-router-dom';

export default function EditTask() {
  const [success, setSuccess] = useState(false);

  const [task, setTask] = useState({
    title: '',
    description: '',
    status: '',
    dueDate: '',
    priority: ''
  });

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const loadTask = async () => {
      const result = await getTaskById(id);
      setTask(result.data);
    };
    loadTask();
  }, [id]);

  const handleChange = (e) => {
    setTask({ ...task, [e.target.name]: e.target.value });
  };

  const saveTask = async (e) => {
    e.preventDefault();
    await updateTask(id, task);
    setSuccess(true);
  };

  return (
    <div className="container py-5" style={{ backgroundColor: '#f8f9fa', minHeight: '100vh' }}>
      <div className="card shadow rounded-4 p-4">
        <h2 className="text-center mb-4 fw-bold">Edit Task</h2>

        {success ? (
          <div className="text-center">
            <div className="alert alert-success fw-bold">
              ✅ Task updated successfully!
            </div>
            <button onClick={() => navigate('/tasks')} className="btn btn-primary">
              🔙 Back to Task List
            </button>
          </div>
        ) : (
          <form onSubmit={saveTask}>
            <div className="mb-3">
              <label className="form-label">Title</label>
              <input type="text" name="title" value={task.title} onChange={handleChange} className="form-control" required />
            </div>
            <div className="mb-3">
              <label className="form-label">Description</label>
              <textarea name="description" value={task.description} onChange={handleChange} className="form-control" required />
            </div>
            <div className="mb-3">
              <label className="form-label">Priority</label>
              <input type="text" name="priority" value={task.priority} onChange={handleChange} className="form-control" required />
            </div>
            <div className="mb-3">
              <label className="form-label">Status</label>
              <input type="text" name="status" value={task.status} onChange={handleChange} className="form-control" required />
            </div>
            <div className="mb-3">
              <label className="form-label">Due Date</label>
              <input type="date" name="dueDate" value={task.dueDate} onChange={handleChange} className="form-control" required />
            </div>
            <div className="text-center mt-4">
              <button className="btn btn-primary btn-lg">💾 Update Task</button>
            </div>
            <div className="text-center mt-4"><button onClick={() => navigate('/tasks')} className="btn btn-primary">
              🔙 Back to Task List
            </button></div>
          </form>
        )}
      </div>
    </div>
  );
}
