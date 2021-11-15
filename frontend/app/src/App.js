import React,{useState, useEffect} from 'react';
import { BrowserRouter as Router, Route, Routes, useNavigate } from "react-router-dom";
import './App.css';
import Dashboard from './components/Dashboard/Dashboard';
import Onboarding from './components/Onboarding/Onboarding';


function App() {
  const[speeches, setSpeeches] = useState();
  let navigate = useNavigate();
  useEffect(()=>{
    async function getSpeeches(){
        const response = await fetch('/test');
        console.log(response);
    }

    getSpeeches();
  },[])

  const login = () =>{
        navigate("/");
  }

  const logout = () =>{
        navigate("/login");
  }

  return (

   <div className="App bg-body">
      <link href='https://fonts.googleapis.com/css?family=Sen' rel='stylesheet'/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"/> 
      <header className="App-header">
             <Routes>
                 <Route path="/" element={<Dashboard onClick = {logout}/>}/>
                 <Route path="/login" element={<Onboarding onClick = {login}/>} />
             </Routes>
      </header>
    </div>

  );
}

export default App;