import React from "react";
import "./Onboarding.css";
import {Animated} from "react-animated-css";

class Login extends React.Component {

    constructor() {
        super(); 
        this.state = { show: false }
    }

    _showSignUpFields = (bool) => {
        this.setState({
          show: bool
        });
      }
		
    render() {
    return (
       <div className="loginCard">
            {
               !this.state.show && 
               <Animated animationIn="fadeInUp" animationOut="fadeInDown" isVisible={this.state.show}>  
                <h1>Welcome,</h1>
                </Animated> 
            }
           <div className="login-items-container">
           {
                this.state.show &&  
                    <Animated animationIn="fadeInUp" animationOut="fadeInDown" isVisible={this.state.show}>     
                    <div className="name-input">
                        <label for="name"><b>Your Name</b></label>
                        <input type="text" placeholder="" name="name" required></input>
                    </div>  
                    </Animated> 
            }
            <div className="email-input">
                <label for="email"><b>Your email</b></label>
                <input type="text" placeholder="" name="email" required></input>
            </div>   
            <div className="password-input">
                <label for="password"><b>Your Password</b></label>
            <input type="password" placeholder="" name="password" required></input>
            </div>
            <button className="theme-btn onboarding-btn" onClick="{login}">
                {
                this.state.show && "Sign Up"
                }
                {
                !this.state.show && "Login"
                }
                </button> 
           </div>
           <div className="sign-up-option">
                { this.state.show &&  "Already a user?"}
                { !this.state.show &&  "Not a user?"}
                
                { !this.state.show && <a className="sign-up" onClick={this._showSignUpFields.bind(null, true)}> Create Account</a>}
                { this.state.show && <a className="sign-up" onClick={this._showSignUpFields.bind(null, false)}> Login</a>}
           </div>

       </div> 
    );
    }
}

export default Login;