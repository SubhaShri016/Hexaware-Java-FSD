// src/services/TaskService.js

import axios from 'axios';

const BASE_URL = "http://localhost:8080/api/tasks";

const getAuth = () => {
  const auth = JSON.parse(localStorage.getItem('auth'));
  return auth ? { auth } : {};
};

export const getTasks = () => axios.get(BASE_URL, getAuth());
export const createTask = (task) => axios.post(BASE_URL, task, getAuth());
export const getTaskById = (id) => axios.get(`${BASE_URL}/${id}`, getAuth());
export const updateTask = (id, task) => axios.put(`${BASE_URL}/${id}`, task, getAuth());
export const deleteTask = (id) => axios.delete(`${BASE_URL}/${id}`, getAuth());
