import React from "react";
import "./Onboarding.css";
function Signup() {
    return (
       <div className="loginCard">
           <form action="/action_page.php" method="post">
           <div className="login-items-container">
            <div className="email-input">
                <label for="email"><b>Your email</b></label>
                <input type="text" placeholder="" name="email" required></input>
            </div>   

            <div className="password-input">
                <label for="password"><b>Your Password</b></label>
            <input type="password" placeholder="" name="password" required></input>
            </div>
            <button type="submit" className="theme-btn onboarding-btn">Logout</button> 
           </div>
           </form>
           <div className="sign-up-option">
                Not a user? 
                <a className="sign-up" href=""> Create Account</a>
           </div>

       </div> 
    )
}

export default Signup;