import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SelectedCheese from './Components/SelectedCheese';
import Menu from './Components/Menu';

// add email form for appointments?
function App() {
  return (
    <Router>
      <Routes>
          <Route path="/" element={<Menu/>} />
          <Route path="/BCS/cheese/:id" element={<SelectedCheese />} />
        </Routes>
    </Router>
  );
}

export default App;