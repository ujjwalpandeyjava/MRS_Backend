import "bootstrap/dist/css/bootstrap.min.css";
import { createRoot } from 'react-dom/client';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from './App.js';
import './globals.css';




createRoot(document.getElementById('root')).render(
  <BrowserRouter >
    <Routes>
      <Route path={`/*`} element={<App />}></Route>
    </Routes>
  </BrowserRouter>
);