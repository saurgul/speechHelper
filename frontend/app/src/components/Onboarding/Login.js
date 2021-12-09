import React,{useState, useEffect} from 'react';
import "./Onboarding.css";
import {Animated} from "react-animated-css";
import { useNavigate } from "react-router-dom";


function Login() {
    const [show, setShow] = useState(false);
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    function showSignUpFields(){
        setShow(!show);
      }

      const navigate = useNavigate();
	
	  const handleRoute = async() =>{
        if (show) {
            //TODO: Checks for correct email and password (using REGEX)
            if (name.length != 0 && email.length != 0 && password.length != 0)  {
            // Signup
            var firstName = name.split(' ').slice(0, -1).join(' ');
            var lastName = name.split(' ').slice(-1).join(' ');

            const response = await fetch(`/add_user?firstName=${firstName}&lastName=${lastName}&username=${firstName+lastName}&password=${password}&email=${email}`, {
                method: 'POST',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json',
                }
                });
                console.log(response)
            }
        }
        else {
            console.log("This needs to actually check login info before routing. Otherwise display an error message");
		    navigate('/dashboard')
        }
    }

    return (
       <div className="loginCard">
            {
               !show && 
               <Animated animationIn="fadeInUp" animationOut="fadeInDown" isVisible={show}>  
                <h1>Welcome,</h1>
               </Animated> 
            }
           <div className="login-items-container">
           {
                show &&  
                    <Animated animationIn="fadeInUp" animationOut="fadeInDown" isVisible={show}>     
                    <div className="name-input">
                        <label for="name"><b>Your Name</b></label>
                        <input type="text" placeholder="" name="name" onChange={e=> setName(e.target.value)} required></input>
                    </div>  
                    </Animated> 
            }
            <div className="email-input">
                <label for="email"><b>Your email</b></label>
                <input type="text" placeholder="" name="email" onChange={e=> setEmail(e.target.value)} required></input>
            </div>   
            <div className="password-input">
                <label for="password"><b>Your Password</b></label>
            <input type="password" placeholder="" name="password" onChange={e=> setPassword(e.target.value)} required></input>
            </div>
            <button className="theme-btn onboarding-btn" onClick={handleRoute}>
                {
                show && "Sign Up"
                }
                {
                !show && "Login"
                }
                </button> 
           </div>
           <div className="sign-up-option">
                { show &&  "Already a user?"}
                { !show &&  "Not a user?"}
                
                { !show && <a className="sign-up" onClick={showSignUpFields}> Create Account</a>}
                { show && <a className="sign-up" onClick={showSignUpFields}> Login</a>}
           </div>

       </div> 
    );
}

export default Login;