import React, { Component } from "react";
import { Router, Routes, Route } from "react-router-dom";

import Onboarding from "./components/Onboarding/Onboarding";
import Welcome from "./components/Welcome";
import history from './history';

export default class Routing extends Component {
    render() {
        return (
                <Routes>
                    <Route path="/" exact element={<Welcome />} />
                    <Route path="/SignUp" element={<Onboarding />} />
                </Routes>
        )
    }
}