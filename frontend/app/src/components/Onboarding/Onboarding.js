import React from "react";
import Login from "./Login";
import "./Onboarding.css";

function Onboarding({onClick}) {
    return(
        <div className="loginContainer">
            <Login onClick = {onClick}/>
        </div>
    
    )
}

export default Onboarding;