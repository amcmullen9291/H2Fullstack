import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Menu from './Components/Menu';

function App() {
  return (
    <Router>
      <Routes>
          <Route path="/" element={<Menu/>} />
        </Routes>
    </Router>
  );
}

export default App;