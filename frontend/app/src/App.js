import React,{useState, useEffect} from 'react';
import './App.css';
import Dashboard from './components/Dashboard/Dashboard';
import Onboarding from './components/Onboarding/Onboarding';

function App() {
  const[speeches, setSpeeches] = useState();

  useEffect(()=>{
    async function getSpeeches(){
        const response = await fetch('/test');
        console.log(response);
    }

    getSpeeches();
  },[])

  return (
    <div className="App bg-body">
      <header className="App-header">
		<div> <Onboarding /> </div>
       <div> {speeches} </div>
      </header>
    </div>
  );
}

export default App;