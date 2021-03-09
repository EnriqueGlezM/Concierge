import React from 'react';
import {Link} from "react-router-dom";

export default class Home extends React.Component {

    render() {

        return (
            <div>
                <h1>Home Page</h1>

                <nav>
                    <ul >
                        <li style={{display: "inline-block"}}>
                            <Link to="/">Home</Link>
                        </li>
                        <li style={{display: "inline-block"}}>
                            <Link to="/services/">Services</Link>
                        </li>
                        <li style={{display: "inline-block"}}>
                            <Link to="/profile/">Profile</Link>
                        </li>

                    </ul>
                </nav>

            </div>
        );
    }
}
