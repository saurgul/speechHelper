import React,{useState, useEffect} from 'react';
import './App.css';
import Dashboard from './Dashboard';

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
		<div> <Dashboard /> </div>
       <div> {speeches} </div>
      </header>
    </div>
  );
}

export default App;